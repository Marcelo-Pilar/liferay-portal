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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;

/**
 * @author José Abelenda
 */
public class DataFaker {

	public static String getValue(JSONObject jsonObject) {
		String defaultValue = jsonObject.getString("defaultValue");

		// if (Validator.isNotNull(defaultValue)) {
		// 	jsonObject1.put(
		// 		jsonObject.getString("fieldName"), defaultValue);
		// }
		// else {

		// }
		return "";
	}

	public static int getRandomNumber(int min, int max) {
		return Math.toIntExact(Math.round((Math.random() * (max - min)) + min));
	}

	public static String readFile(String fileName) throws Exception {
		try (InputStream inputStream = DataFaker.class.getResourceAsStream(
				_BASE_DIR + fileName)) {

			return StringUtil.read(inputStream);
		}
	}

	private static final String _BASE_DIR = "/META-INF/resources/";

	private static final Log _log = LogFactoryUtil.getLog(DataFaker.class);
}