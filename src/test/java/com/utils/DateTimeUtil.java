package com.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {

	public static String getTimewithDaysAgo(int days) {
		String s = Instant.now().minus(10, ChronoUnit.DAYS).toString();
		return s;
	}

}
