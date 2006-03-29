/*******************************************************************************
 * Copyright (c) 2001, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.wst.xml.validation.tests.internal;
import junit.framework.Test;

import org.eclipse.wst.xml.core.internal.validation.XMLValidationConfigurationTest;
import org.eclipse.wst.xml.core.internal.validation.eclipse.ValidatorTest;
import org.eclipse.wst.xml.core.internal.validation.eclipse.XMLMessageInfoHelperTest;
import org.eclipse.wst.xml.core.internal.validation.eclipse.XMLValidatorTest;

/**
 * The root test suite that contains all other XML validator test suites.
 */
public class AllXMLTests extends junit.framework.TestSuite
{
  /**
   * Create this test suite.
   * 
   * @return This test suite.
   */
  public static Test suite()
  {
    return new AllXMLTests();
  }
  
  /**
   * Constructor
   */
  public AllXMLTests()
  {
    super("XMLTestsTestSuite");
    addTest(XMLValidationConfigurationTest.suite());
    addTest(ValidatorTest.suite());
    addTest(XMLMessageInfoHelperTest.suite());
    addTest(XMLValidatorTest.suite());
    addTest(XMLExamplesTest.suite());
    addTest(BugFixesTest.suite());
    addTest(PathsTest.suite());
  }
}