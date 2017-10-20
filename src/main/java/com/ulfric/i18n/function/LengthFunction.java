package com.ulfric.i18n.function;

public class LengthFunction extends Function<String> {

	public LengthFunction() {
		super("length", String.class);
	}

	@Override
	public Object apply(String handle) {
		return handle.length();
	}

}