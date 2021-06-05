package com.oguztopal.annualpermit.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

@UtilityClass
@Slf4j
public class DateUtil {

	public long calculateYearDiff(Date start, Date end) {
		long result = start.getTime() - end.getTime();
		return result / (1000L * 60 * 60 * 24 * 365);
	}

	public long calculateDayDiff(Date start, Date end) {
		long result = end.getTime() - start.getTime();
		return (result / (1000 * 60 * 60 * 24)) % 365;
	}

	public long calculateToBePermitDayExcludedWeekend(Date startDate, Date endDate) {
		try {
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(startDate);
			cal2.setTime(endDate);
			long days = 0;
			while (cal1.before(cal2)) {
				if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
						&& (Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
					days++;
				}
				cal1.add(Calendar.DATE, 1);
			}
			return days;
		} catch (Exception ex) {
			log.error("calculateWillPermitDayExcludedWeekend error ");
		}
		return 0L;
	}
}
