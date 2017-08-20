package com.ulfric.i18n.invoker;

public class UppercaseInvoker extends Invoker {

	public UppercaseInvoker() {
		super("uppercase", String.class);
	}

	@Override
	public Object invoke(Object handle) {
		return ((String) handle).toUpperCase();
	}

}