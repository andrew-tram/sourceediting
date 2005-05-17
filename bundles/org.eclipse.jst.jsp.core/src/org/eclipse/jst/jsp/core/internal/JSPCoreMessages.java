/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jst.jsp.core.internal;

import org.eclipse.osgi.util.NLS;

/**
 * Strings used by JSP Core
 * 
 * @since 1.0
 */
public class JSPCoreMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.jst.jsp.core.internal.JSPCorePluginResources"; //$NON-NLS-1$

	public static String JSPIndexManager_0;
	public static String JSPIndexManager_2;
	public static String JSP_Search;
	public static String JSPDocumentLoader_1;
	
	private JSPCoreMessages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, JSPCoreMessages.class);
	}
}
