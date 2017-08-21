package com.ulfric.i18n.invoker;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Invoker {

	private static final Map<String, Map<Class<?>, Invoker>> WRAPPERS = new HashMap<>();

	static {
		register(new LowercaseInvoker());
		register(new UppercaseInvoker());
	}

	public static void register(Invoker invoker) {
		Objects.requireNonNull(invoker, "invoker");

		WRAPPERS.computeIfAbsent(invoker.getName(), ignore -> new IdentityHashMap<>())
			.put(invoker.getTargetType(), invoker);
	}

	public static void unregister(Invoker invoker) {
		Objects.requireNonNull(invoker, "invoker");

		Map<Class<?>, Invoker> invokers = WRAPPERS.get(invoker.getName());
		if (invokers == null) {
			return;
		}

		invokers.remove(invoker.getTargetType(), invoker);
	}

	public static Invoker lookup(Class<?> type, String name) { // TODO look for function on type (cached), support polymorphism
		Map<Class<?>, Invoker> invokers = WRAPPERS.get(name);
		if (invokers == null) {
			return null;
		}

		return invokers.get(type);
	}

	private final String name;
	private final Class<?> targetType;

	public Invoker(String name, Class<?> targetType) {
		Objects.requireNonNull(name, "name");
		Objects.requireNonNull(targetType, "targetType");

		this.name = name;
		this.targetType = targetType;
	}

	public final String getName() {
		return name;
	}

	public final Class<?> getTargetType() {
		return targetType;
	}

	public abstract Object invoke(Object handle);

}