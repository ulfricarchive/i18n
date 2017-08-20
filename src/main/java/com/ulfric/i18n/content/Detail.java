package com.ulfric.i18n.content;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract class Detail implements Iterable<Content> {

	public static Detail single(String name, Object content) {
		return new SingleDetail(name, Content.of(content));
	}

	public static Detail single(String name, String content) {
		return new SingleDetail(name, Content.of(content));
	}

	public static Detail single(String name, Content content) {
		return new SingleDetail(name, content);
	}

	private final String name;

	public Detail(String name) {
		Objects.requireNonNull(name, "name");

		this.name = name;
	}

	public final String getName() {
		return name;
	}

	@Override
	public final Iterator<Content> iterator() {
		return getAllContent().iterator();
	}

	public abstract Content getPrimaryContent();

	public abstract List<Content> getAllContent();

	public abstract boolean isMultiPart();

}
