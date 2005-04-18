/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Jens Lukowski/Innoopract - initial renaming/restructuring
 *     
 *******************************************************************************/
package org.eclipse.wst.sse.ui.internal;


import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;


public class ReadOnlyAwareDropTargetAdapter extends ExtendedEditorDropTargetAdapter {

	public ReadOnlyAwareDropTargetAdapter() {
		super();
	}

	public void drop(DropTargetEvent event) {
		IDocument document = getTextViewer().getDocument();
		if (document instanceof IStructuredDocument) {
			if (((IStructuredDocument) document).containsReadOnly(getDropOffset(event), 0)) {
				event.operations = DND.DROP_NONE;
				event.detail = DND.DROP_NONE;
				getTextViewer().getTextWidget().redraw();
				getTextViewer().getTextWidget().update();
				getTextViewer().getTextWidget().getDisplay().beep();
			}
		}
		super.drop(event);
	}

}
