/*-
 * #%L
 * Home Automation
 * %%
 * Copyright (C) 2016 - 2017 Koen Serneels
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package be.error.wsproxy.interceptors.internalchain;

import org.testng.Assert;
import org.testng.annotations.Test;

import be.error.wsproxy.interceptors.logging.WebServiceMessageXPathExpressionMetaData;
import be.error.wsproxy.interceptors.logging.WebServiceMessageXPathExpressionMetaData.XPathExpressionResultCardinality;
import be.error.wsproxy.interceptors.logging.WebServiceMessageXPathExpressionMetaData.XPathExpressionScope;
import be.error.wsproxy.interceptors.logging.WebServiceMessageXPathExpressionMetaData.XPathExpressionType;

@Test
public class WebServiceMessageXPathExpressionMetaDataTest {

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testWebServiceMessageXPathExpressionMetaDataNoXpathExpression() {
		new WebServiceMessageXPathExpressionMetaData(null, "test");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testWebServiceMessageXPathExpressionMetaDataNoKey() {
		new WebServiceMessageXPathExpressionMetaData("test", null);
	}

	public void testWebServiceMessageXPathExpressionMetaData() {
		Assert.assertEquals(new WebServiceMessageXPathExpressionMetaData("//*", "testKey"),
				new WebServiceMessageXPathExpressionMetaData("/*", "testKey"));

		WebServiceMessageXPathExpressionMetaData webServiceMessageXPathExpressionMetaData = new WebServiceMessageXPathExpressionMetaData(
				"/*", "testKey");

		Assert.assertNotNull(webServiceMessageXPathExpressionMetaData.getXPathExpression());
		Assert.assertEquals(webServiceMessageXPathExpressionMetaData.getXPathExpressionResultCardinality(),
				XPathExpressionResultCardinality.MANDATORY);
		Assert.assertEquals(webServiceMessageXPathExpressionMetaData.getXPathExpressionType(),
				XPathExpressionType.VALUE);
		Assert.assertEquals(webServiceMessageXPathExpressionMetaData.getXPathExpressionScope(),
				XPathExpressionScope.SOAP_BODY);
	}
}
