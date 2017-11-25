package com.ulfric.i18n.content;

public class ContentHelper {

	public static boolean isTrue(Content content) {
		Object value = content.getValue();
		if (value instanceof Boolean) {
			return (boolean) value;
		}

		return Boolean.parseBoolean(content.getDisplayable());
	}

	private ContentHelper() {
	}

}
