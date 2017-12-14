package com.ulfric.i18n.function;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import com.ulfric.commons.time.TemporalHelper;

public class InstantToPrettyFunction extends Function<Instant> {

	private final DateTimeFormatter formatter =
			DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT)
			.withLocale(Locale.US)
			.withZone(TemporalHelper.newYorkOrDefault());

	public InstantToPrettyFunction() {
		super("pretty", Instant.class);
	}

	@Override
	public Object apply(Instant instant) {
		return formatter.format(instant);
	}

}
