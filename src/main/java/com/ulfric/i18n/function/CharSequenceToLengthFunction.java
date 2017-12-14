package com.ulfric.i18n.function;

public class CharSequenceToLengthFunction extends Function<CharSequence> {

	public CharSequenceToLengthFunction() {
		super("length", CharSequence.class);
	}

	@Override
	public Object apply(CharSequence handle) {
		return handle.length();
	}

}