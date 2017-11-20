/*******************************************************************************
 * Copyright (c) 2005, 2009 Andrea Bittau, University College London, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andrea Bittau - initial API and implementation from the PsychoPath XPath 2.0 
 *******************************************************************************/

package org.eclipse.wst.xml.xpath2.processor.internal.ast;

/**
 * Support for Unary expressions.
 */
public abstract class UnExpr extends Expr {
	private Expr _arg;

	/**
	 * Constructor for UnExpr.
	 * 
	 * @param arg
	 *            expression.
	 */
	public UnExpr(Expr arg) {
		_arg = arg;
	}

	/**
	 * Support for Expression interface.
	 * 
	 * @return Result of Expr operation.
	 */
	public Expr arg() {
		return _arg;
	}
}
