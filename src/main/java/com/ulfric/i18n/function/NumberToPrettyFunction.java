package com.ulfric.i18n.function;

import java.text.NumberFormat;

public class NumberToPrettyFunction extends Function<Number> {

	public NumberToPrettyFunction() {
		super("pretty", Number.class);
	}

	@Override
	public Object apply(Number number) {
		return NumberFormat.getInstance().format(number);
	}

}
