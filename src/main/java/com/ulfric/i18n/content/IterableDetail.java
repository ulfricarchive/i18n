package com.ulfric.i18n.content;

import com.ulfric.commons.stream.Collectors2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class IterableDetail extends Detail {

	private final List<Content> content;

	public IterableDetail(String name, List<Content> content) {
		super(name);

		Objects.requireNonNull(content, "content");
		this.content = safeContent(content);
	}

	private List<Content> safeContent(List<Content> content) {
		List<Content> safeContent = content.stream()
				.peek(Objects::nonNull)
				.collect(Collectors2.toUnmodifiableList());

		return Collections.unmodifiableList(safeContent);
	}

	@Override
	public Content getPrimaryContent() {
		return content.isEmpty() ? Content.nullContent() : content.get(0); // TODO stop returning null
	}

	@Override
	public List<Content> getAllContent() {
		return content;
	}

	@Override
	public boolean isMultiPart() {
		return content.size() > 1;
	}

}