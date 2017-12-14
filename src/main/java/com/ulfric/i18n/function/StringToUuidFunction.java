package com.ulfric.i18n.function;

import com.ulfric.commons.value.UniqueIdHelper;

public class StringToUuidFunction extends Function<String> {

	public StringToUuidFunction() {
		super("uuid", String.class);
	}

	@Override
	public Object apply(String handle) {
		return UniqueIdHelper.nameUniqueId(handle.toString());
	}

}