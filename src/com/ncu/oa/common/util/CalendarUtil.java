package com.ncu.oa.common.util;

import java.util.Calendar;

public class CalendarUtil {

	/**
	 * 时分秒清零
	 * 
	 * @param calendar
	 * @return
	 */
	public static Calendar cleanCalendar(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

}
