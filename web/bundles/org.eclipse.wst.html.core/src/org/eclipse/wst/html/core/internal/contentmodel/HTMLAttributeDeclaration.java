/*******************************************************************************
 * Copyright (c) 2004, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.html.core.internal.contentmodel;

import org.eclipse.wst.xml.core.internal.contentmodel.CMAttributeDeclaration;



/**
 * This interface is intended to be a public interface which has
 * interfaces defined in both of {@link <code>CMAttributeDeclaration</code>}
 * and {@link <code>HTMLCMNode</code>}.<br>
 */
public interface HTMLAttributeDeclaration extends CMAttributeDeclaration {
	String IS_HTML = "isHTML"; //$NON-NLS-1$
}
