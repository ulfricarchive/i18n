package com.ulfric.i18n.content;

final class StringContent extends Content {

	public StringContent(String value) {
		super(String.class, value);
	}

	@Override
	public String getDisplayable() {
		return (String) value;
	}

}