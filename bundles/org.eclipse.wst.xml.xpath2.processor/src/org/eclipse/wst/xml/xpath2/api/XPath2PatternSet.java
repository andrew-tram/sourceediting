/*******************************************************************************
 * Copyright (c) 2009 Jesper Moller, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jesper Moller - initial API and implementation
 *******************************************************************************/

package org.eclipse.wst.xml.xpath2.api;

import org.w3c.dom.Node;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.0
 */
public interface XPath2PatternSet {
	
	XPath2Pattern compilePattern(StaticContext context, String pattern, String mode, int priority, Object userData);
	void removePattern(XPath2Pattern pattern);
	
	void clear();
	
	Match match(DynamicContext dc, Node context);
}
