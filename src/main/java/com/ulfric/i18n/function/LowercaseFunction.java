package com.ulfric.i18n.function;

public class LowercaseFunction extends Function<String> {

	public LowercaseFunction() {
		super("lowercase", String.class);
	}

	@Override
	public Object apply(String handle) {
		return handle.toLowerCase();
	}

}