/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.data.generator.manager.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.sample.data.generator.manager.SDGManager;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author José Abelenda
 */
@RunWith(Arquillian.class)
public class SDGManagerTest {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testGenerateSampleData() {
		JSONArray jsonArray = _sdgManager.generateSampleData(JSONUtil.put(
			"fields",
			JSONFactoryUtil.createJSONArray(
			).put(
				JSONUtil.put(
					"fieldName", "age"
				).put(
					"fieldType", "AGE"
				).put(
					"fieldRangeValue", "18,50"
				)
			).put(
				JSONUtil.put(
					"fieldName", "gender"
				).put(
					"defaultValue", "M"
				)
			).put(
				JSONUtil.put(
					"fieldName", "name"
				).put(
					"fieldType", "MALE_FULL_NAME"
				)
			)
		), 10);

		System.out.println("result: " + jsonArray);

		Assert.assertNotNull(jsonArray);
	}

	@Inject
	private SDGManager _sdgManager;

}