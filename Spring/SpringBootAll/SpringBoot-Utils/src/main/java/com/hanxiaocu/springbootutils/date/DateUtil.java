package com.hanxiaocu.springbootutils.date;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/23 10:10 AM
 */
public class DateUtil {

	/**
	 * 判断时间是否半点
	 *
	 * @return
	 */
	public static boolean judgeTimeIsHalf() {
		Boolean judgeTimeIsHalf = false;
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		if (gc.get(gc.MINUTE) == 30) {
			judgeTimeIsHalf = true;
		}

		return judgeTimeIsHalf;
	}

	/**
	 * 判断时间是否整点
	 *
	 * @return
	 */
	public static boolean judgeTimeIsWhole() {

		Boolean judgeTimeIsWhole = false;
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		if (gc.get(gc.MINUTE) == 0) {
			judgeTimeIsWhole = true;
		}
		return judgeTimeIsWhole;
	}

	public static int getMinute() {
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		return gc.get(gc.MINUTE);
	}

	public static boolean quarzTime(int h, int m) {
		boolean isQuarzTime = false;
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		if (gc.get(gc.HOUR_OF_DAY) == h && gc.get(gc.MINUTE) == m) {
			isQuarzTime = true;
		}
		return isQuarzTime;
	}

	public static String getHourAndMinute() {
		Date date = new Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		String hour = String.valueOf(gc.get(gc.HOUR_OF_DAY));
		String minute = String.valueOf(gc.get(gc.MINUTE));
		return hour + minute;
	}

}
