/*******************************************************************************
 * Copyright (c) 2005, 2009 Andrea Bittau, University College London, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Andrea Bittau - initial API and implementation from the PsychoPath XPath 2.0 
 *******************************************************************************/

package org.eclipse.wst.xml.xpath2.processor.internal;

/**
 * Error caused by static attribute name.
 */
public class StaticAttrNameError extends StaticNameError {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5037788654293050262L;

	/**
	 * Constructor for static attribute name error
	 * 
	 * @param reason
	 *            is the reason for the error.
	 */
	public StaticAttrNameError(String reason) {
		super(reason);
	}
}
