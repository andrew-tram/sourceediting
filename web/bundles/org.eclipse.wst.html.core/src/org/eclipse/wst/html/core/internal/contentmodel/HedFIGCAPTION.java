/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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

import org.eclipse.wst.html.core.internal.provisional.HTML50Namespace;

public class HedFIGCAPTION extends HedFlowContainer {
	public HedFIGCAPTION(ElementCollection collection) {
		super(HTML50Namespace.ElementName.FIGCAPTION, collection);
		layoutType = LAYOUT_HIDDEN;
	}

	/**
	 * Article.
	 * %attrs;
	 * Global attributes
	 */
	protected void createAttributeDeclarations() {
		if (attributes != null)
			return; // already created.
		if (attributeCollection == null)
			return; // fatal

		attributes = new CMNamedNodeMapImpl();

		// %attrs;
		attributeCollection.getAttrs(attributes);
	}
}
