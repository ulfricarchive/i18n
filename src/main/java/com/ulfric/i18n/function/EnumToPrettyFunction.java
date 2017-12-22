package com.ulfric.i18n.function;

import org.apache.commons.text.WordUtils;

public class EnumToPrettyFunction extends Function<Enum<?>> {

	public EnumToPrettyFunction() {
		super("pretty", Enum.class);
	}

	@Override
	public Object apply(Enum<?> value) {
		return WordUtils.capitalizeFully(value.name().toLowerCase().replace('_', ' ').trim());
	}

}
