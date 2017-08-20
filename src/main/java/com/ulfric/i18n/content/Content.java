package com.ulfric.i18n.content;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.ObjectUtils.Null;

import com.ulfric.commons.value.Bean;
import com.ulfric.i18n.invoker.Invoker;

import java.util.Objects;

public class Content extends Bean {

	private static final Content NULL = new Content(Null.class, ObjectUtils.NULL);

	public static Content nullContent() {
		return NULL;
	}

	public static <T> Content of(Object value) {
		if (value == null) {
			return NULL;
		}

		if (value instanceof String) {
			return of((String) value);
		}

		return new Content(value.getClass(), value);
	}

	public static Content of(String value) {
		if (value == null) {
			return NULL;
		}

		return new StringContent(value);
	}

	protected final Class<?> type;
	protected final Object value;

	protected <T> Content(Class<T> type, Object value) {
		Objects.requireNonNull(type, "type");

		this.type = type; // TODO handle dynamic from Dragoon
		this.value = value;
	}

	public final Content invoke(String method) { // TODO
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
