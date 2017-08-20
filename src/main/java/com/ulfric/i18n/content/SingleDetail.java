package com.ulfric.i18n.content;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class SingleDetail extends Detail {

	private final Content content;

	public SingleDetail(String name, Content content) {
		super(name);

		Objects.requireNonNull(content, "content");
		this.content = content;
	}

	@Override
	public Content getPrimaryContent() {
		return content;
	}

	@Override
	public List<Content> getAllContent() {
		return Collections.singletonList(content);
	}

	@Override
	public boolean isMultiPart() {
		return false;
	}

}