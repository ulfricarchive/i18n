package com.ulfric.i18n.function;

public class LengthFunction extends Function<CharSequence> {

	public LengthFunction() {
		super("length", CharSequence.class);
	}

	@Override
	public Object apply(CharSequence handle) {
		return handle.length();
	}

}