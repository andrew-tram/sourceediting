/*******************************************************************************
 * Copyright (c) 2001, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Jens Lukowski/Innoopract - initial renaming/restructuring
 *     
 *******************************************************************************/
package org.eclipse.wst.sse.core.internal.provisional.exceptions;



/**
 * Indicates that a model with a particular ID already exists
 */
public class ResourceInUse extends Exception {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ResourceAlreadyExists constructor comment.
	 */
	public ResourceInUse() {
		super();
	}

	/**
	 * ResourceAlreadyExists constructor comment.
	 * 
	 * @param s
	 *            java.lang.String
	 */
	public ResourceInUse(String s) {
		super(s);
	}
}
