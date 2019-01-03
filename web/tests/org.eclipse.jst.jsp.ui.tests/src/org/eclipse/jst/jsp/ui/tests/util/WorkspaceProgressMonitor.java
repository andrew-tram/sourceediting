/*******************************************************************************
 * Copyright (c) 2004, 2017 IBM Corporation and others.
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
package org.eclipse.jst.jsp.ui.tests.util;

import org.eclipse.core.runtime.IProgressMonitor;

class WorkspaceProgressMonitor implements IProgressMonitor {
	private boolean finished = false;

	public void beginTask(String name, int totalWork) {
	}

	public void done() {
		finished = true;
	}

	public boolean isFinished() {
		return finished;
	}

	public void internalWorked(double work) {
	}

	public boolean isCanceled() {
		return finished;
	}

	public void setCanceled(boolean value) {
		if (value == true)
			finished = true;
	}

	public void setTaskName(String name) {
	}

	public void subTask(String name) {
	}

	public void worked(int work) {
	}
}