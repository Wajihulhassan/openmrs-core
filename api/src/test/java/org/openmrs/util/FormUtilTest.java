/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import junit.framework.Assert;
import org.junit.Test;
import org.openmrs.Drug;
import org.openmrs.Form;
import org.openmrs.test.Verifies;


/**
 * Tests the methods on the {@link FormUtil} class
 */
public class FormUtilTest {
	
	/**
	 * @see FormUtil#getXmlToken(String)
	 */
	@Test
	@Verifies(value = "should give me valid XML token", method = "getXmlToken(String)")
	public void getXmlToken_shouldGiveValidXMLToken() {
	    String str = FormUtil.getXmlToken("Hi!");
	    Assert.assertEquals("hi_bang",str);
	}
	
	/**
	 * @see FormUtil#drugToString(Drug)
	 */
	@Test
	@Verifies(value = "should convert drug to string", method = "drugToString(Drug)")
	public void drugToString_shouldConvertDrugToString() {
	    Drug drug = new Drug();	
	    drug.setName("name");
	    drug.setDrugId(12);
	    String str = FormUtil.drugToString(drug);
	    Assert.assertEquals("12^name^99RX",str);
	}
         
        /**
	 * @see FormUtil#getFormUriWithoutExtension(Form)
	 */
	@Test
	@Verifies(value = "should convert Form URI to valid string", method = "getFormUriWithoutExtension(Form)")
	public void getFormUriWithoutExtension_shouldConvertFormToValidString() {
	    Form form = new Form(123);
	    form.setVersion("1.0");
	    form.setBuild(456);
	    String str = FormUtil.getFormUriWithoutExtension(form);
	    Assert.assertEquals("123-1.0-456",str);
	}
        
}
