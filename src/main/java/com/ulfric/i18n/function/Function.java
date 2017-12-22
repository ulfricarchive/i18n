package com.ulfric.i18n.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.ulfric.commons.collection.Computations;

public abstract class Function<T> implements java.util.function.Function<T, Object> {

	private static final Map<String, List<Function<?>>> FUNCTIONS = new HashMap<>();

	static {
		register(new ObjectToStringFunction());
		register(new CharSequenceToLengthFunction());
		register(new StringToLowercaseFunction());
		register(new StringToUppercaseFunction());
		register(new NumberToPrettyFunction());
		register(new CollectionToSizeFunction());
		register(new InstantToPrettyFunction());
		register(new EnumToPrettyFunction());
	}

	public static void register(Function<?> function) {
		Objects.requireNonNull(function, "function");

		FUNCTIONS.computeIfAbsent(function.name, Computations::newArrayListIgnoring)
			.add(function);
	}

	public static void unregister(Function<?> function) {
		Objects.requireNonNull(function, "function");

		List<Function<?>> functions = FUNCTIONS.get(function.name);
		if (functions == null) {
			return;
		}

		functions.remove(function);
	}

	@SuppressWarnings("unchecked")
	public static <T> Function<? extends T> lookup(String name, Class<T> type) {
		List<Function<?>> functions = FUNCTIONS.get(name);
		if (functions == null) {
			return null;
		}

		for (Function<?> function : functions) {
			if (function.targetType == type) {
				return (Function<T>) function;
			}
		}

		for (Function<?> function : functions) {
			if (function.targetType.isAssignableFrom(type)) {
				return (Function<T>) function;
			}
		}

		return null;
	}

	private final String name;
	private final Class<?> targetType;

	public Function(String name, Class<?> targetType) {
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(targetType, "targetType");

		this.name = name;
		this.targetType = targetType;
	}

}