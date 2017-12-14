package com.ulfric.i18n.function;

public class StringToUppercaseFunction extends Function<String> {

	public StringToUppercaseFunction() {
		super("uppercase", String.class);
	}

	@Override
	public Object apply(String handle) {
		return handle.toUpperCase();
	}

}