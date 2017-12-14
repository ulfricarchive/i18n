package com.ulfric.i18n.function;

import java.util.Collection;

public class CollectionToSizeFunction extends Function<Collection<?>> {

	public CollectionToSizeFunction() {
		super("size", Collection.class);
	}

	@Override
	public Object apply(Collection<?> handle) {
		return handle.size();
	}

}