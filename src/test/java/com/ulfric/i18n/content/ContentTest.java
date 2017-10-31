package com.ulfric.i18n.content;

import org.junit.jupiter.api.Test;

import com.google.common.truth.Truth;

class ContentTest {

	@Test
	void testNothingIsNotNull() {
		Truth.assertThat(Content.nothing()).isNotNull();
	}

	@Test
	void testOfNullReturnsNothing() {
		Truth.assertThat(Content.of(null)).isEqualTo(Content.nothing());
	}

	@Test
	void testOfStringObjectReturnsStringContentInstance() {
		Object content = "content";
		Truth.assertThat(Content.of(content)).isInstanceOf(StringContent.class);
	}

	@Test
	void testOfStringNullReturnsNothing() {
		String content = null;
		Truth.assertThat(Content.of(content)).isEqualTo(Content.nothing());
	}

	@Test
	void testOfNothing() {
		Truth.assertThat(Content.of(null)).isEqualTo(Content.nothing());
	}

	@Test
	void testGetDisplayableOfNothing() {
		Truth.assertThat(Content.nothing().getDisplayable()).isEqualTo("nothing");
	}

	@Test
	void testToStringReturnsGetDisplayable() {
		Truth.assertThat(Content.of(5).toString()).isEqualTo(Content.of(5).getDisplayable());
	}

	@Test
	void testStringToStringReturnsGetDisplayable() {
		Truth.assertThat(Content.of("hello").toString()).isEqualTo(Content.of("hello").getDisplayable());
	}

	@Test
	void testGetValueOfNonNull() {
		Truth.assertThat(Content.of(5).getValue()).isEqualTo(5);
	}

	@Test
	void testGetValueOfNonNullString() {
		Truth.assertThat(Content.of("hello").getValue()).isEqualTo("hello");
	}

}
