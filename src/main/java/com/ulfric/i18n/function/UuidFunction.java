package com.ulfric.i18n.function;

import com.ulfric.commons.value.UniqueIdHelper;

public class UuidFunction extends Function<String> {

	public UuidFunction() {
		super("uuid", String.class);
	}

	@Override
	public Object apply(String handle) {
		return UniqueIdHelper.nameUniqueId(handle.toString());
	}

}