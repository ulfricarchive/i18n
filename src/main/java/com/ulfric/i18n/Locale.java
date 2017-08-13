package com.ulfric.i18n;

public interface Locale {

	String getMessage(String key);

	String getMessage(String key, Details details);

}