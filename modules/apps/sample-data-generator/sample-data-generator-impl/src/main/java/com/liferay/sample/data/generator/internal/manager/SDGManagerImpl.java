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

package com.liferay.sample.data.generator.internal.manager;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.sample.data.generator.internal.manager.PersonDataFaker;
import com.liferay.sample.data.generator.manager.SDGManager;

import org.osgi.service.component.annotations.Component;

/**
 * @author José Abelenda
 */
@Component(immediate = true, service = SDGManager.class)
public class SDGManagerImpl implements SDGManager {

	public JSONObject generateSampleData(JSONObject jsonObject) {
		JSONObject jsonObject1 = JSONFactoryUtil.createJSONObject();

		JSONArray jsonArray = jsonObject.getJSONArray("fields");

		for (int i = 0; i < jsonArray.length(); i++) {

			String defaultValue = jsonObject.getString("defaultValue");

			if (Validator.isNotNull(defaultValue)) {
				jsonObject1.put(
					jsonObject.getString("fieldName"), defaultValue);
			}
			else {

			}

			// JSONObject jsonObject2 = _getFieldJSONObject(jsonArray.getJSONObject(i))
			// jsonObject1.put(jsonObject2.getKey(), jsonObject2.getValue());
		}

		return jsonObject1;
	}

	private JSONObject _getFieldJSONObject(JSONObject jsonObject) {
		System.out.println("_getField: " + jsonObject);

		String defaultValue = jsonObject.getString("defaultValue");

		if (Validator.isNotNull(defaultValue)) {
			return JSONUtil.put(
				jsonObject.getString("fieldName"), defaultValue);
		}

		String fieldType = jsonObject.getString("fieldType");

		String value = "";

		if (fieldType.equals("AGE")) {
			int age = DataFaker.getRandomNumber(18, 45);

			value = String.valueOf(age);
		}

		if (fieldType.equals("MALE_FIRST_NAME")) {
			value = PersonDataFaker.getRandomMaleFirstName();
		}
		else if (fieldType.equals("MALE_FULL_NAME")) {
			value = PersonDataFaker.getRandomMaleFullName();
		}
		else if (fieldType.equals("FEMALE_FULL_NAME")) {
			value = PersonDataFaker.getRandomFemaleFullName();
		}
		else if (fieldType.equals("FEMALE_FIRST_NAME")) {
			value = PersonDataFaker.getRandomFemaleFirstName();
		}

		return JSONUtil.put(jsonObject.getString("fieldName"), value);
	}

	private JSONArray _getFieldsJSONArray(JSONArray jsonArray) {
		JSONArray fieldsJSONArray = JSONFactoryUtil.createJSONArray();

		for (int i = 0; i < jsonArray.length(); i++) {
			fieldsJSONArray.put(
				_getFieldJSONObject(jsonArray.getJSONObject(i)));
		}

		return fieldsJSONArray;
	}

}