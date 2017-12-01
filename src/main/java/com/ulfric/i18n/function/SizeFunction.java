package com.ulfric.i18n.function;

import java.util.Collection;

public class SizeFunction extends Function<Collection<?>> {

	public SizeFunction() {
		super("size", Collection.class);
	}

	@Override
	public Object apply(Collection<?> handle) {
		return handle.size();
	}

}