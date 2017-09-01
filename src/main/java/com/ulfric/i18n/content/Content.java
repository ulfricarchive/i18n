package com.ulfric.i18n.content;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.ObjectUtils.Null;

import com.ulfric.commons.value.Bean;
import com.ulfric.dragoon.reflect.Classes;
import com.ulfric.i18n.invoker.Invoker;

import java.util.Objects;

public class Content extends Bean {

	private static final Content NOTHING = new Content(Null.class, ObjectUtils.NULL);

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

	public final Content invoke(String method) {
		Invoker invoker = Invoker.lookup(type, method);
		if (invoker == null) {
			throw new IllegalArgumentException("Invalid invoker '" + method + "' for " + type);
		}

		return Content.of(invoker.invoke(value));
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

}
