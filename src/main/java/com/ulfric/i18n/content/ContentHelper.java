package com.ulfric.i18n.content;

import org.apache.commons.lang3.BooleanUtils;

public class ContentHelper {

	public static boolean isTrue(Content content) {
		Object value = content.getValue();
		if (value instanceof Boolean) {
			return (boolean) value;
		}

		if (value == null) {
			return false;
		}

		Boolean booleanValue = BooleanUtils.toBooleanObject(content.getDisplayable());
		return booleanValue == null ? true : booleanValue;
	}

	private ContentHelper() {
	}

}
