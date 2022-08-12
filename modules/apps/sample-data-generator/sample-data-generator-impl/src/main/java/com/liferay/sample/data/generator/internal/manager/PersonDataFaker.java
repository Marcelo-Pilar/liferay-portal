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
public class PersonDataFaker extends DataFaker {

	public static String getRandomFemaleFirstName() {
		int index = getRandomNumber(0, _femaleFirstNamesJSONArray.length());

		return _femaleFirstNamesJSONArray.getString(index);
	}

	public static String getRandomFemaleFullName() {
		return getRandomFemaleFirstName() + " " +  getRandomLastName();
	}

	public static String getRandomLastName() {
		int index = getRandomNumber(0, _lastNamesJSONArray.length());

		return _lastNamesJSONArray.getString(index);
	}

	public static String getRandomMaleFirstName() {
		int index = getRandomNumber(0, _maleFirstNamesJSONArray.length());

		return _maleFirstNamesJSONArray.getString(index);
	}

	public static String getRandomMaleFullName() {
		return getRandomMaleFirstName() + " " + getRandomLastName();
	}

	private static final Log _log = LogFactoryUtil.getLog(PersonDataFaker.class);

	private static JSONArray _femaleFirstNamesJSONArray =
		JSONFactoryUtil.createJSONArray();
	private static JSONArray _lastNamesJSONArray =
		JSONFactoryUtil.createJSONArray();
	private static JSONArray _maleFirstNamesJSONArray =
		JSONFactoryUtil.createJSONArray();

	static {
		try {
			String json = readFile("names.json");

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(json);

			_femaleFirstNamesJSONArray = jsonObject.getJSONArray(
				"femaleFirstNames");

			_lastNamesJSONArray = jsonObject.getJSONArray("lastNames");

			_maleFirstNamesJSONArray = jsonObject.getJSONArray(
				"maleFirstNames");
		}
		catch (Exception exception) {
			_log.error(exception);
		}
	}

}