package com.ulfric.i18n.function;

public class UppercaseFunction extends Function<String> {

	public UppercaseFunction() {
		super("uppercase", String.class);
	}

	@Override
	public Object apply(String handle) {
		return handle.toUpperCase();
	}

}