package com.ulfric.i18n.function;

import java.util.Collection;

public class SizeFunction extends Function<Collection<?>> {

	@SuppressWarnings("unchecked")
	public SizeFunction() {
		super("size", (Class<? extends Collection<?>>) Collection.class);
	}

	@Override
	public Object apply(Collection<?> handle) {
		return handle.size();
	}

}