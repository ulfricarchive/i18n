package com.ulfric.i18n.content;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Details {

	private static final Details NONE = new Details() {
		@Override
		public Detail get(String key) {
			return null;
		}

		@Override
		public void add(String key, Object value) {
		}

		@Override
		public void add(Detail detail) {
		}
	};

	public static Details none() {
		return NONE;
	}

	public static Details of(String key, String content) {
		return of(new SingleDetail(key, Content.of(content)));
	}

	public static Details of(String key, Object content) {
		return of(new SingleDetail(key, Content.of(content)));
	}

	public static Details of(Detail detail) {
		Map<String, Detail> backing = new HashMap<>();
		backing.put(detail.getName(), detail);
		return new Details(backing);
	}

	public static Details of(Detail first, Detail... additional) {
		Details details = of(first);
		for (Detail detail : additional) {
			details.add(detail);
		}
		return details;
	}

	private final Map<String, Detail> backing;

	public Details() {
		this(new HashMap<>());
	}

	private Details(Map<String, Detail> backing) {
		this.backing = backing;
	}

	public Detail get(String key) {
		return backing.get(key);
	}

	public void add(String key, Object content) {
		add(new SingleDetail(key, Content.of(content))); // TODO value
	}

	public void add(String key, Content content) {
		add(new SingleDetail(key, content)); // TODO value
	}

	public void add(Detail detail) {
		Objects.requireNonNull(detail, "detail");

		backing.put(detail.getName(), detail);
	}

}
