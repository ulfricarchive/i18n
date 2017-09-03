package com.ulfric.i18n.placeholder;

import com.ulfric.commons.naming.Named;
import com.ulfric.i18n.content.Detail;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public abstract class Placeholder<T> implements Named, Function<T, Detail> {

	private static final Map<String, Placeholder<?>> PLACEHOLDERS = new HashMap<>();

	public static void register(Placeholder<?> placeholder) {
		Objects.requireNonNull(placeholder, "placeholder");

		PLACEHOLDERS.put(placeholder.getName(), placeholder);
	}

	public static void unregister(Placeholder<?> placeholder) {
		Objects.requireNonNull(placeholder, "placeholder");

		PLACEHOLDERS.remove(placeholder.getName(), placeholder);
	}

	public static Placeholder<?> get(String name) {
		return PLACEHOLDERS.get(name);
	}

	private final String name;

	public Placeholder(String name) {
		Objects.requireNonNull(name);

		this.name = name;
	}

	@Override
	public final String getName() {
		return this.name;
	}

	public final Detail detail(Object content) {
		return Detail.of(name, content);
	}

	public final Detail detail(String content) {
		return Detail.of(name, content);
	}

}