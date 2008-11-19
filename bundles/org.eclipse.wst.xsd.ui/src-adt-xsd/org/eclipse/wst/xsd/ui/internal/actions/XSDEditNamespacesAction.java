/*******************************************************************************
 * Copyright (c) 2001, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.xsd.ui.internal.actions;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wst.xml.core.internal.contentmodel.util.DOMNamespaceInfoManager;
import org.eclipse.wst.xml.core.internal.contentmodel.util.NamespaceInfo;
import org.eclipse.wst.xml.core.internal.document.DocumentImpl;
import org.eclipse.wst.xml.ui.internal.actions.ReplacePrefixAction;
import org.eclipse.wst.xml.ui.internal.util.XMLCommonResources;
import org.eclipse.wst.xsd.ui.internal.dialogs.XSDEditSchemaNS;
import org.eclipse.wst.xsd.ui.internal.editor.XSDEditorPlugin;
import org.eclipse.wst.xsd.ui.internal.nsedit.SchemaPrefixChangeHandler;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.util.XSDConstants;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class XSDEditNamespacesAction extends Action {
	private Element element;
	private String resourceLocation;
	private XSDSchema xsdSchema;
    private DOMNamespaceInfoManager namespaceInfoManager = new DOMNamespaceInfoManager();
	
	public XSDEditNamespacesAction(String label, Element element, Node node) {
		super();
		setText(label);
		
		this.element = element;
		///////////////////// This needs to be changed....
		this.resourceLocation = "dummy";		
	}
	
	public XSDEditNamespacesAction(String label, Element element, Node node, XSDSchema schema) {
		this (label, element, node);
		xsdSchema = schema;
	}
	
	public void run() {
		if (element != null)
		{   
		      Shell shell = XMLCommonResources.getInstance().getWorkbench().getActiveWorkbenchWindow().getShell();
		      XSDEditSchemaNS dialog = new XSDEditSchemaNS(shell, new Path(resourceLocation)); 
		      
		      List namespaceInfoList = namespaceInfoManager.getNamespaceInfoList(element);
		      List oldNamespaceInfoList = NamespaceInfo.cloneNamespaceInfoList(namespaceInfoList);

		      // here we store a copy of the old info for each NamespaceInfo
		      // this info will be used in createPrefixMapping() to figure out how to update the document 
		      // in response to these changes
		      for (Iterator i = namespaceInfoList.iterator(); i.hasNext(); )
		      {
		        NamespaceInfo info = (NamespaceInfo)i.next();
		        NamespaceInfo oldCopy = new NamespaceInfo(info);
		        info.setProperty("oldCopy", oldCopy); //$NON-NLS-1$
		      }
		                              
		      dialog.setNamespaceInfoList(namespaceInfoList);   
		      dialog.create();      
		      dialog.getShell().setSize(500, 400);
		      dialog.getShell().setText(XMLCommonResources.getInstance().getString("_UI_MENU_EDIT_SCHEMA_INFORMATION_TITLE")); //$NON-NLS-1$
		      dialog.setBlockOnOpen(true);                                 
		      dialog.open();
          String xsdPrefix = "";     //$NON-NLS-1$

		      if (dialog.getReturnCode() == Window.OK)
		      {
            Element xsdSchemaElement = xsdSchema.getElement();
            DocumentImpl doc = (DocumentImpl) xsdSchemaElement.getOwnerDocument();
            
            List newInfoList = dialog.getNamespaceInfoList();

		        // see if we need to rename any prefixes
		        Map prefixMapping = createPrefixMapping(oldNamespaceInfoList, namespaceInfoList);
            
            Map map2 = new Hashtable();
            for (Iterator iter = newInfoList.iterator(); iter.hasNext(); )
            {
              NamespaceInfo ni = (NamespaceInfo)iter.next();
              String pref = ni.prefix;
              String uri = ni.uri;
              if (pref == null) pref = ""; //$NON-NLS-1$
              if (uri == null) uri = ""; //$NON-NLS-1$
              if (XSDConstants.isSchemaForSchemaNamespace(uri))
              {
                xsdPrefix = pref;
              }
              map2.put(pref, uri);
            }
           
		        if (map2.size() > 0)
		        {
		        	try {
                
                doc.getModel().beginRecording(this, XSDEditorPlugin.getXSDString("_UI_NAMESPACE_CHANGE"));

                if (xsdPrefix != null && xsdPrefix.length() == 0)
                {
                  xsdSchema.setSchemaForSchemaQNamePrefix(null);
                }
                else
                {
                  xsdSchema.setSchemaForSchemaQNamePrefix(xsdPrefix);
                }

                xsdSchema.update();
                
                SchemaPrefixChangeHandler spch = new SchemaPrefixChangeHandler(xsdSchema, xsdPrefix);
                spch.resolve();
                xsdSchema.update();
                
                xsdSchema.setIncrementalUpdate(false);
                namespaceInfoManager.removeNamespaceInfo(element);
                namespaceInfoManager.addNamespaceInfo(element, newInfoList, false);
                xsdSchema.setIncrementalUpdate(true);

                // don't need these any more?
			          ReplacePrefixAction replacePrefixAction = new ReplacePrefixAction(null, element, prefixMapping);
			          replacePrefixAction.run();
				    	}
              catch (Exception e)
              { 
//                e.printStackTrace();
              }
              finally
              {
                xsdSchema.update();
                doc.getModel().endRecording(this);
			     		}
		        }
            
		   }      
          
		}
	}
	
	 protected Map createPrefixMapping(List oldList, List newList)
	  {          
	    Map map = new Hashtable();

	    Hashtable oldURIToPrefixTable = new Hashtable();
	    for (Iterator i = oldList.iterator(); i.hasNext(); )
	    {    
	      NamespaceInfo oldInfo = (NamespaceInfo)i.next();                    
	      oldURIToPrefixTable.put(oldInfo.uri, oldInfo);
	    }
	    
	    for (Iterator i = newList.iterator(); i.hasNext(); )
	    {
	      NamespaceInfo newInfo = (NamespaceInfo)i.next();
	      NamespaceInfo oldInfo = (NamespaceInfo)oldURIToPrefixTable.get(newInfo.uri != null ? newInfo.uri : "");  //$NON-NLS-1$


	      // if oldInfo is non null ... there's a matching URI in the old set
	      // we can use its prefix to detemine out mapping
	      //
	      // if oldInfo is null ...  we use the 'oldCopy' we stashed away 
	      // assuming that the user changed the URI and the prefix
	      if (oldInfo == null)                                            
	      {
	        oldInfo = (NamespaceInfo)newInfo.getProperty("oldCopy");            //$NON-NLS-1$
	      } 

	      if (oldInfo != null)
	      {
	        String newPrefix = newInfo.prefix != null ? newInfo.prefix : ""; //$NON-NLS-1$
	        String oldPrefix = oldInfo.prefix != null ? oldInfo.prefix : ""; //$NON-NLS-1$
	        if (!oldPrefix.equals(newPrefix))
	        {
	          map.put(oldPrefix, newPrefix);    
	        }
	      }      
	    }        
	    return map;
	  }
}
