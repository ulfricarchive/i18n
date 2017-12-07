package com.ulfric.i18n.content;

import java.util.Objects;

import com.ulfric.commons.value.Bean;
import com.ulfric.dragoon.reflect.Classes;
import com.ulfric.i18n.function.Function;

public class Content extends Bean {

	private static final Content NOTHING = new Content(Nothing.class, Nothing.INSTANCE);

	public static boolean isNothing(Content content) {
		if (content == null) {
			return true;
		}

		return content == NOTHING;
	}

	public static Content nothing() {
		return NOTHING;
	}

	public static Content of(Object value) {
		if (value == null) {
			return NOTHING;
		}

		if (value instanceof String) {
			return of((String) value);
		}

		return new Content(value.getClass(), value);
	}

	public static Content of(String value) {
		if (value == null) {
			return NOTHING;
		}

		return new StringContent(value);
	}

	protected final Class<?> type;
	protected final Object value;

	protected <T> Content(Class<T> type, Object value) {
		Objects.requireNonNull(type, "type");

		this.type = Classes.getNonDynamic(type);
		this.value = value;
	}

	public final Content invoke(String functionName) {
		@SuppressWarnings("unchecked")
		Function<Object> function = (Function<Object>) Function.lookup(functionName, type);
		if (function == null) {
			if (type == Nothing.class) {
				return nothing();
			}

			throw new IllegalArgumentException("Invalid function '" + functionName + "' for " + type);
		}

		return Content.of(function.apply(value));
	}

	public final Object getValue() {
		return value;
	}

	public String getDisplayable() {
		return String.valueOf(value);
	}

	@Override
	public String toString() {
		return getDisplayable();
	}

	enum Nothing {
		INSTANCE;

		@Override
		public final String toString() {
			return getClass().getSimpleName().toLowerCase();
		}
	}

}
