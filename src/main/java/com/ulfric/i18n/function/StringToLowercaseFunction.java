package com.ulfric.i18n.function;

public class StringToLowercaseFunction extends Function<String> {

	public StringToLowercaseFunction() {
		super("lowercase", String.class);
	}

	@Override
	public Object apply(String handle) {
		return handle.toLowerCase();
	}

}