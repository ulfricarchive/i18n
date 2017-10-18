package com.ulfric.i18n.function;

public class StringFunction extends Function<Object> {

	public StringFunction() {
		super("string", Object.class);
	}

	@Override
	public Object apply(Object handle) {
		return handle.toString();
	}

}