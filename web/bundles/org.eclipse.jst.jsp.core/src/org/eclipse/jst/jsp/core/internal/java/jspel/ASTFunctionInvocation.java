/*******************************************************************************
 * Copyright (c) 2005 BEA Systems and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     BEA Systems - initial implementation
 *     
 *******************************************************************************/
/* Generated By:JJTree: Do not edit this line. ASTFunctionInvocation.java */

package org.eclipse.jst.jsp.core.internal.java.jspel;

public class ASTFunctionInvocation extends SimpleNode {
  String fullFunctionName; 
  
  public ASTFunctionInvocation(int id) {
    super(id);
  }

  public ASTFunctionInvocation(JSPELParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(JSPELParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

public String getFullFunctionName() {
	return fullFunctionName;
}

public void setFullFunctionName(String fullFunctionName) {
	this.fullFunctionName = fullFunctionName;
}
}
