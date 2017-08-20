package com.ulfric.i18n.invoker;

public class LowercaseInvoker extends Invoker {

	public LowercaseInvoker() {
		super("lowercase", String.class);
	}

	@Override
	public Object invoke(Object handle) {
		return ((String) handle).toLowerCase();
	}

}