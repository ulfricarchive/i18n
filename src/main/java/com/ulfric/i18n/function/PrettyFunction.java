package com.ulfric.i18n.function;

import java.text.NumberFormat;

public class PrettyFunction extends Function<Number> {

	public PrettyFunction() {
		super("pretty", Number.class);
	}

	@Override
	public Object apply(Number number) {
		return NumberFormat.getInstance().format(number);
	}

}
