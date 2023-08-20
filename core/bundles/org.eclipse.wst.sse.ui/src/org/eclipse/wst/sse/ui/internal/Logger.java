/*******************************************************************************
 * Copyright (c) 2001, 2023 IBM Corporation and others.
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
package org.eclipse.wst.sse.ui.internal;



import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import com.ibm.icu.util.StringTokenizer;

/**
 * Small convenience class to log messages to plugin's log file and also, if
 * desired, the console. This class should only be used by classes in this
 * plugin. Other plugins should make their own copy, with appropriate ID.
 */
public class Logger {
	private static final String PLUGIN_ID = "org.eclipse.wst.sse.ui"; //$NON-NLS-1$
	
	public static final int ERROR = IStatus.ERROR; // 4
	public static final int ERROR_DEBUG = 200 + ERROR;
	public static final int INFO = IStatus.INFO; // 1
	public static final int INFO_DEBUG = 200 + INFO;

	public static final int OK = IStatus.OK; // 0

	public static final int OK_DEBUG = 200 + OK;

	private static final String TRACEFILTER_LOCATION = "/debug/tracefilter"; //$NON-NLS-1$
	public static final int WARNING = IStatus.WARNING; // 2
	public static final int WARNING_DEBUG = 200 + WARNING;

	/**
	 * true if platform and plug-in are in debug mode and debugging formatting
	 */
	public static final boolean DEBUG_FORMAT = "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.wst.sse.core/format")); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Adds message to log.
	 * 
	 * @param level
	 *            severity level of the message (OK, INFO, WARNING, ERROR,
	 *            OK_DEBUG, INFO_DEBUG, WARNING_DEBUG, ERROR_DEBUG)
	 * @param message
	 *            text to add to the log
	 * @param exception
	 *            exception thrown
	 */
	protected static void _log(int level, String message, Throwable exception) {
		if (level == OK_DEBUG || level == INFO_DEBUG || level == WARNING_DEBUG || level == ERROR_DEBUG) {
			if (!isDebugging())
				return;
		}

		int severity = IStatus.OK;
		switch (level) {
			case INFO_DEBUG :
			case INFO :
				severity = IStatus.INFO;
				break;
			case WARNING_DEBUG :
			case WARNING :
				severity = IStatus.WARNING;
				break;
			case ERROR_DEBUG :
			case ERROR :
				severity = IStatus.ERROR;
		}
		message = (message != null) ? message : "null"; //$NON-NLS-1$
		Status statusObj = new Status(severity, PLUGIN_ID, severity, message, exception);
		_log(statusObj);

	}
	
	/**
	 * Adds {@link IStatus} to the log.
	 * 
	 * @param statusObj {@link IStatus} to add to the log
	 */
	protected static void _log(IStatus statusObj) {
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		if (bundle != null) {
			Platform.getLog(bundle).log(statusObj);
		}
	}

	/**
	 * Prints message to log if category matches /debug/tracefilter option.
	 * 
	 * @param message
	 *            text to print
	 * @param category
	 *            category of the message, to be compared with
	 *            /debug/tracefilter
	 */
	protected static void _trace(String category, String message, Throwable exception) {
		if (isTracing(category)) {
			message = (message != null) ? message : "null"; //$NON-NLS-1$
			Status statusObj = new Status(IStatus.OK, PLUGIN_ID, IStatus.OK, message, exception);
			Bundle bundle = Platform.getBundle(PLUGIN_ID);
			if (bundle != null) 
				Platform.getLog(bundle).log(statusObj);

		}
	}

	/**
	 * @return true if the platform is debugging
	 */
	public static boolean isDebugging() {
		return Platform.inDebugMode();
	}

	/**
	 * Determines if currently tracing a category
	 * 
	 * @param category
	 * @return true if tracing category, false otherwise
	 */
	public static boolean isTracing(String category) {
		if (!isDebugging())
			return false;

		String traceFilter = Platform.getDebugOption(PLUGIN_ID + TRACEFILTER_LOCATION);
		if (traceFilter != null) {
			StringTokenizer tokenizer = new StringTokenizer(traceFilter, ","); //$NON-NLS-1$
			while (tokenizer.hasMoreTokens()) {
				String cat = tokenizer.nextToken().trim();
				if (category.equals(cat)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void log(int level, String message) {
		_log(level, message, null);
	}

	public static void log(int level, String message, Throwable exception) {
		_log(level, message, exception);
	}
	
	/**
	 * <p>Allows an already constructed status to be logged</p>
	 * 
	 * @param status {@link IStatus} to log.
	 */
	public static void log(IStatus status) {
		_log(status);
	}

	public static void logException(String message, Throwable exception) {
		_log(ERROR, message, exception);
	}

	public static void logException(Throwable exception) {
		_log(ERROR, exception.getMessage(), exception);
	}

	public static void trace(String category, String message) {
		_trace(category, message, null);
	}

	public static void traceException(String category, String message, Throwable exception) {
		_trace(category, message, exception);
	}

	public static void traceException(String category, Throwable exception) {
		_trace(category, exception.getMessage(), exception);
	}
}
