package com.ulfric.i18n.function;

public class ObjectToStringFunction extends Function<Object> {

	public ObjectToStringFunction() {
		super("string", Object.class);
	}

	@Override
	public Object apply(Object handle) {
		return handle.toString();
	}

}