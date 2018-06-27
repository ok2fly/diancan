package com.qinergy.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/***
 * 处理所有和日期相关的处理.
 */
public class DateUtil extends Object {
	/*** 系统总的失效日期. */
	public static final String DATE_FOREVER = "9999-12-31";

	/** 时间格式. */
	public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

	/** 到小时分钟的日期格式. */
	public static final String FORMAT_DATETIME_HM = "yyyy-MM-dd HH:mm";

	/** 全时间格式. */
	public static final String FORMAT_FULLTIME = "yyMMddHHmmssSSS";

	/** 日期格式. */
	public static final String FORMAT_DATE = "yyyy-MM-dd";

	/** 日期格式. */
	public static final String FORMAT_YEARMONTH = "yyyy-MM";

	/** 纯时间格式. */
	public static final String FORMAT_TIME = "HH:mm:ss";

	/** 年月日时分秒无分隔符 **/
	public final static String FORMAT_TRADETIME = "yyyyMMddHHmmss";

	/** 年月日无分隔符 **/
	public final static String FORMAT_TRADEDATE = "yyyyMMdd";

	/** ISODateTime yyyymmddhhmmss **/
	public final static String FORMAT_ISODATETIME = "yyyyMMddHHmmss";

	/** ISODate yyyymmdd **/
	public final static String FORMAT_ISODATE = "yyyyMMdd";

	/** ISOTime hhmmss **/
	public final static String FORMAT_ISOTIME = "yyyyMMdd";

	public static Date getMinuteBefore(int min) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());// 设置当前日期
		calendar.add(Calendar.MINUTE, -min);// ﹣时间查询当前时间之前
		return calendar.getTime();
	}

	/**
	 * compare two kinds String with format : 12:00 , 08:00; or 12:00:00,
	 * 08:00:00.<br>
	 * <br>
	 * 
	 * @param firstTime
	 *            the first time string.
	 * @param secondTime
	 *            the second time string.
	 * @return 0 -- same 1 -- first bigger than second -1 -- first smaller than
	 *         second -2 -- invalid time format
	 */
	public static int compareOnlyByTime(String firstTime, String secondTime) {
		try {
			String timeDelm = ":";

			// calculate the first time to integer
			int pos = firstTime.indexOf(timeDelm);
			int iFirst = Integer.parseInt(firstTime.substring(0, pos)) * 10000;
			firstTime = firstTime.substring(pos + 1);
			pos = firstTime.indexOf(timeDelm);

			if (pos > 0) {
				iFirst = iFirst
						+ (Integer.parseInt(firstTime.substring(0, pos)) * 100)
						+ Integer.parseInt(firstTime.substring(pos + 1));
			} else {
				iFirst = iFirst + (Integer.parseInt(firstTime) * 100);
			}

			// calculate the second time string to integer
			pos = secondTime.indexOf(timeDelm);
			int iSecond = Integer.parseInt(secondTime.substring(0, pos)) * 10000;
			secondTime = secondTime.substring(pos + 1);
			pos = secondTime.indexOf(timeDelm);

			if (pos > 0) {
				iSecond = iSecond
						+ (Integer.parseInt(secondTime.substring(0, pos)) * 100)
						+ Integer.parseInt(secondTime.substring(pos + 1));
			} else {
				iSecond = iSecond + (Integer.parseInt(secondTime) * 100);
			}

			// compare two
			if (iFirst == iSecond) {
				return 0;
			} else if (iFirst > iSecond) {
				return 1;
			} else {
				return -1;
			}
		} catch (Exception e) {
			return -2;
		}
	}

	public static int getCurrentHour() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static int getCurrentMinute() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 根据规定格式的字符串得到Calendar.<br>
	 * <br>
	 * 
	 * @param dateString
	 *            日期串.
	 * @return 对应Calendar
	 */
	public static Calendar getCalendar(String dateString) {
		Calendar calendar = Calendar.getInstance();
		String[] items = dateString.split("-");
		calendar.set(Integer.parseInt(items[0]),
				Integer.parseInt(items[1]) - 1, Integer.parseInt(items[2]));
		return calendar;
	}

	/**
	 * 得到与当前日期相差指定天数的日期字符串.<br>
	 * <br>
	 * 
	 * @param days
	 *            前后的天数，正值为后， 负值为前.
	 * @return 日期字符串
	 */
	public static String getCertainDate(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, days);
		return getStringFromDate(calendar.getTime(), FORMAT_DATE);
	}

	/**
	 * 得到与指定日期相差指定天数的日期字符串.<br>
	 * <br>
	 * 
	 * @param dateString
	 *            指定的日期.
	 * @param days
	 *            前后的天数，正值为后， 负值为前.
	 * @return 日期字符串
	 */
	public static String getCertainDate(String dateString, int days) {
		Calendar calendar = getCalendar(dateString);
		calendar.add(Calendar.DATE, days);
		return getStringFromDate(calendar.getTime(), FORMAT_DATE);
	}

	public static String getCertainDate(String dateString, int days,
			String format) {
		Calendar calendar = getCalendar(dateString);
		calendar.add(Calendar.DATE, days);
		return getStringFromDate(calendar.getTime(), format);
	}

	/**
	 * 得到与指定日期相差指定天数的日期
	 * 
	 * @param date
	 *            指定的日期
	 * @param days
	 *            相差天数
	 * @return
	 */
	public static Date getCertainDate(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * 得到与指定日期相差指定天数的日期字符串.<br>
	 * <br>
	 * 
	 * @param dateString
	 *            指定的日期.
	 * @param period
	 *            前后的天数，正值为后， 负值为前.
	 * @param periodType
	 *            周期类别 可以是天、月、年.
	 * @return 日期字符串
	 */
	public static String getCertainDate(String dateString, int period,
			int periodType) {
		Calendar calendar = getCalendar(dateString);

		switch (periodType) {
		case 1: // 天
			calendar.add(Calendar.DATE, period);
			break;
		case 2: // 月
			calendar.add(Calendar.MONTH, period);
			break;
		case 3: // 年
			calendar.add(Calendar.MONTH, period * 12);
			break;
		default:
		}
		return getStringFromDate(calendar.getTime(), FORMAT_DATE);
	}

	/**
	 * 某日期（带时间）加上几天得到另外一个日期(带时间).<br>
	 * <br>
	 * 
	 * @param datetime
	 *            需要调整的日期(带时间).
	 * @param days
	 *            调整天数.
	 * @return 调整后的日期(带时间)
	 */
	public static String getCertainDatetime(String datetime, int days) {
		Date curDate = getDateFromString(datetime, FORMAT_DATETIME);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curDate);
		calendar.add(Calendar.DATE, days);
		return getStringFromDate(calendar.getTime(), FORMAT_DATETIME);
	}

	/**
	 * 得到与当前日期相差指定月数的日期字符串.
	 * 
	 * @param dif
	 *            前后的月数，正值为后， 负值为前.
	 * @return 日期字符串
	 */
	public static String getCertainMonth(int dif) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, dif);
		return getStringFromDate(calendar.getTime(), FORMAT_DATE);
	}

	/**
	 * 得到与当前日期相差指定月数的日期字符串.
	 * 
	 * @param dif
	 *            前后的月数，正值为后， 负值为前.
	 * @param format
	 *            格式
	 * @return 日期字符串
	 */
	public static String getCertainMonth(int dif, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, dif);
		return getStringFromDate(calendar.getTime(), format);
	}

	/**
	 * 得到当前日期的中文日期字符串.<br>
	 * <br>
	 * 
	 * @return 中文日期字符串
	 */
	public static String getChineseDate() {
		return getChineseDate(getDate());
	}

	/**
	 * 根据日期值得到中文日期字符串.<br>
	 * <br>
	 * 
	 * @param date
	 *            日期值.
	 * @return 中文日期字符串
	 */
	public static String getChineseDate(String date) {
		if (date.length() < Integer.valueOf("10")) {
			return "";
		} else {
			String year = date.substring(0, 4); // 年
			String month = date.substring(5, 7); // 月
			String day = date.substring(8, 10); // 日
			String y1 = year.substring(0, 1); // 年 字符1
			String y2 = year.substring(1, 2); // 年 字符1
			String y3 = year.substring(2, 3); // 年 字符3
			String y4 = year.substring(3, 4); // 年 字符4
			String m2 = month.substring(1, 2); // 月 字符2
			String d1 = day.substring(0, 1); // 日 1
			String d2 = day.substring(1, 2); // 日 2
			String cy1 = getChineseNum(y1);
			String cy2 = getChineseNum(y2);
			String cy3 = getChineseNum(y3);
			String cy4 = getChineseNum(y4);
			String cm2 = getChineseNum(m2);
			String cd1 = getChineseNum(d1);
			String cd2 = getChineseNum(d2);
			String cYear = cy1 + cy2 + cy3 + cy4 + "年";
			String cMonth = "月";

			if (Integer.parseInt(month) > 9) {
				cMonth = "十" + cm2 + cMonth;
			} else {
				cMonth = cm2 + cMonth;
			}

			String cDay = "日";

			if (Integer.parseInt(day) > 9) {
				cDay = cd1 + "十" + cd2 + cDay;
			} else {
				cDay = cd2 + cDay;
			}

			String chineseday = cYear + cMonth + cDay;
			return chineseday;
		}
	}

	/**
	 * 得到当前日期的星期数 : 例如 '星期一', '星期二'等.<br>
	 * <br>
	 * 
	 * @return 当前日期的星期数
	 */
	public static String getChineseDayOfWeek() {
		return getChineseDayOfWeek(getDate());
	}

	/**
	 * 得到指定日期的星期数.<br>
	 * <br>
	 * 
	 * @param strDate
	 *            指定日期字符串.
	 * @return 指定日期的星期数
	 */
	public static String getChineseDayOfWeek(String strDate) {
		Calendar calendar = getCalendar(strDate);

		int week = calendar.get(Calendar.DAY_OF_WEEK);
		String strWeek = "";

		switch (week) {
		case Calendar.SUNDAY:
			strWeek = "星期日";
			break;
		case Calendar.MONDAY:
			strWeek = "星期一";
			break;
		case Calendar.TUESDAY:
			strWeek = "星期二";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "星期三";
			break;
		case Calendar.THURSDAY:
			strWeek = "星期四";
			break;
		case Calendar.FRIDAY:
			strWeek = "星期五";
			break;
		case Calendar.SATURDAY:
			strWeek = "星期六";
			break;
		default:
			strWeek = "星期一";
			break;
		}

		return strWeek;
	}

	/**
	 * 根据数字得到中文数字.<br>
	 * <br>
	 * 
	 * @param number
	 *            数字.
	 * @return 中文数字
	 */
	public static String getChineseNum(String number) {
		String chinese = "";
		int x = Integer.parseInt(number);

		switch (x) {
		case 0:
			chinese = "零";
			break;
		case 1:
			chinese = "一";
			break;
		case 2:
			chinese = "二";
			break;
		case 3:
			chinese = "三";
			break;
		case 4:
			chinese = "四";
			break;
		case 5:
			chinese = "五";
			break;
		case 6:
			chinese = "六";
			break;
		case 7:
			chinese = "七";
			break;
		case 8:
			chinese = "八";
			break;
		case 9:
			chinese = "九";
			break;
		default:
		}
		return chinese;
	}

	/**
	 * 根据日期值得到中文日期字符串.<br>
	 * <br>
	 * 
	 * @param date
	 *            给定日期.
	 * @return 2005年09月23日格式的日期
	 */
	public static String getChineseTwoDate(String date) {
		if (date.length() < 10) {
			return "";
		} else {
			String year = date.substring(0, 4); // 年
			String month = date.substring(5, 7); // 月
			String day = date.substring(8, 10); // 日

			return year + "年" + month + "月" + day + "日";
		}
	}

	/**
	 * 自定义当前时间格式.<br>
	 * <br>
	 * 
	 * @param customFormat
	 *            自定义格式
	 * @return 日期时间字符串
	 */
	public static String getCustomDateTime(String customFormat) {
		Calendar calendar = Calendar.getInstance();
		return getStringFromDate(calendar.getTime(), customFormat);
	}

	/**
	 * 得到当前的日期字符串.<br>
	 * <br>
	 * 
	 * @return 日期字符串
	 */
	public static String getDate() {
		return getDate(Calendar.getInstance());
	}

	/**
	 * 得到指定日期的字符串.<br>
	 * <br>
	 * 
	 * @param calendar
	 *            指定的日期.
	 * @return 日期字符串
	 */
	public static String getDate(Calendar calendar) {
		return getStringFromDate(calendar.getTime(), FORMAT_DATE);
	}

	/**
	 * 某日期加上几天得到另外一个日期.<br>
	 * <br>
	 * 
	 * @param addNum
	 *            要增加的天数.
	 * @param getDate
	 *            某日期.
	 * @return 与某日期相差addNum天的日期
	 */
	public static String getDateAdded(int addNum, String getDate) {
		return getCertainDate(getDate, addNum);
	}

	/**
	 * 将指定格式的字符串格式化为日期.<br>
	 * <br>
	 * 
	 * @param s
	 *            字符串内容.
	 * @return 日期
	 */
	public static Date getDateFromString(String s) {
		return getDateFromString(s, FORMAT_DATE);
	}

	/**
	 * 将指定格式的字符串格式化为日期.<br>
	 * <br>
	 * 
	 * @param s
	 *            字符串内容.
	 * @param format
	 *            字符串格式.
	 * @return 日期
	 */
	public static Date getDateFromString(String s, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(s);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date getDateTimeFromDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String str = sdf.format(date);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 得到当前的日期时间字符串.<br>
	 * <br>
	 * 
	 * @return 日期时间字符串
	 */
	public static String getDatetime() {
		Calendar calendar = Calendar.getInstance();
		return getStringFromDate(calendar.getTime(), FORMAT_DATETIME);
	}

	/**
	 * 得到当前的日期时间字符串,到小时分钟.<br>
	 * <br>
	 * 
	 * @return 日期时间字符串
	 */
	public static String getDateTimeHm() {
		Calendar calendar = Calendar.getInstance();
		return getStringFromDate(calendar.getTime(), FORMAT_DATETIME_HM);
	}

	/**
	 * 得到当前的日期时间字符串.<br>
	 * <br>
	 * 
	 * @return 日期时间字符串
	 */
	public static String getDatetimeW3C() {
		return getDate() + "T" + getTime();
	}

	/**
	 * 得到当前的日期时间字符串.<br>
	 * <br>
	 * 
	 * @return 日期时间字符串
	 */
	public static String getDatetimeZd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return getStringFromDate(calendar.getTime(), FORMAT_DATETIME);
	}

	/**
	 * 得到当前的日期.<br>
	 * <br>
	 * 
	 * @return 当前日期
	 */
	public static int getDay() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 获取相差时间，精确到分钟.<br>
	 * <br>
	 * 
	 * @param beginTime
	 *            开始时间.
	 * @param endTime
	 *            结束时间.
	 * @return 相差时间
	 */
	public static String getDiffTime(String beginTime, String endTime) {
		try {
			if (endTime == null || endTime.length() == 0) {
				endTime = getDatetime();
			}
			Date eTime = getDateFromString(endTime, FORMAT_DATETIME);
			Date bTime = getDateFromString(beginTime, FORMAT_DATETIME);
			long time = eTime.getTime() - bTime.getTime();
			StringBuffer sb = new StringBuffer();
			int day = (int) Math.floor(time / (double) (24 * 3600000));
			if (day > 0) {
				sb.append(day).append("天");
			}
			time = time % (24 * 3600000);
			int hour = (int) Math.floor(time / (double) 3600000);
			if (hour > 0) {
				sb.append(hour).append("小时");
			}
			time = time % 3600000;
			int minute = (int) Math.ceil(time / (double) 60000);
			if (minute > 0) {
				sb.append(minute).append("分钟");
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 得到本周星期一的日期.<br>
	 * <br>
	 * 
	 * @return 日期字符串
	 */
	public static String getFirstDateOfWeek() {
		return getFirstDateOfWeek(getDate());
	}

	/**
	 * 得到指定日期的星期一的日期.<br>
	 * <br>
	 * 
	 * @param dateString
	 *            日期字符串.
	 * @return 本周星期一的日期
	 */
	public static String getFirstDateOfWeek(String dateString) {
		Calendar calendar = getCalendar(dateString);
		int iCount;
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			iCount = -6;
		} else {
			iCount = Calendar.MONDAY - calendar.get(Calendar.DAY_OF_WEEK);
		}

		return getCertainDate(dateString, iCount);
	}

	/**
	 * 得到当前的全时间字符串，包含毫秒.<br>
	 * <br>
	 * 
	 * @return 日期时间字符串
	 */
	public static String getFulltime() {
		Calendar calendar = Calendar.getInstance();
		return getStringFromDate(calendar.getTime(), FORMAT_FULLTIME);
	}

	/**
	 * 得到当前的月份.<br>
	 * <br>
	 * 
	 * @return 当前月份
	 */
	public static int getMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 取得两日期间的月份差数.
	 * 
	 * @param startDate
	 *            起始日期.
	 * @param endDate
	 *            结束日期.
	 * @return 月份差数
	 */
	public static int getMonthDiff(String startDate, String endDate) {
		String[] startArray = startDate.split("-");
		String[] endArray = endDate.split("-");
		int startYear = Integer.parseInt(startArray[0]);
		int startMonth = Integer.parseInt(startArray[1]);
		int endYear = Integer.parseInt(endArray[0]);
		int endMonth = Integer.parseInt(endArray[1]);
		return Math.abs((endYear - startYear) * 12 + endMonth - startMonth);
	}

	/**
	 * 当月第一天
	 * 
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date targetDate) {
		Calendar gcLast = Calendar.getInstance();
		gcLast.setTime(targetDate);
		gcLast.set(Calendar.DATE, 1);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String day_first = df.format(gcLast.getTime());
		day_first = day_first + " 00:00:00";
		return getDateFromString(day_first, FORMAT_DATETIME);
	}

	/**
	 * 当月最后一天
	 * 
	 * @return
	 */
	public static Date getLastDayOfMonth(Date targetDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(targetDate);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String lastDay = df.format(calendar.getTime());
		lastDay = new StringBuffer().append(lastDay).append(" 23:59:59")
				.toString();
		return getDateFromString(lastDay, FORMAT_DATETIME);
	}

	/**
	 * 将日期格式化为指定的字符串.<br>
	 * <br>
	 * 
	 * @param d
	 *            日期.
	 * @param format
	 *            输出字符串格式.
	 * @return 日期字符串
	 */
	public static String getStringFromDate(Date d, String format) {
		if (d == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}

	public static String getDateTimeFromString(String d, String format,
			String rtnFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		SimpleDateFormat rtnf = new SimpleDateFormat(rtnFormat);
		try {
			return rtnf.format(sdf.parse(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将日期格式化为字符串.<br>
	 * 
	 * @param d
	 *            日期
	 * @return 日期字符串
	 */
	public static String getStringFromDate(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(d);
	}

	/**
	 * 得到当前的纯时间字符串.<br>
	 * <br>
	 * 
	 * @return 时间字符串
	 */
	public static String getTime() {
		Calendar calendar = Calendar.getInstance();
		return getStringFromDate(calendar.getTime(), FORMAT_TIME);
	}

	/**
	 * 如果当前日期是周六或者周日，则返回下周一的日期.<br>
	 * <br>
	 * 
	 * @param date
	 *            当前日期.
	 * @return 下周一日期
	 */
	public static String getWorkDate(final String date) {
		Date curDate = getDateFromString(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curDate);
		int week = calendar.get(Calendar.DAY_OF_WEEK);

		if (week == Calendar.SATURDAY) {
			calendar.add(Calendar.DATE, 2);
		} else if (week == Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, 1);
		}
		return getDate(calendar);
	}

	/**
	 * 得到当前的年份.<br>
	 * <br>
	 * 
	 * @return 当前年份
	 */
	public static int getYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * @Title: getYear  
	 * @Desc: "yyyy-MM-dd" 时间格式获取年份 
	 * @return int
	 * @throws
	 */
	public static int getYear(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		
		Date parse = null;
		try {
			parse = sdf.parse(date);
			calendar.setTime(parse);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
       return  calendar.get(Calendar.YEAR);
	}
	
	/**
	 * @Title: getYear  
	 * @Desc: "yyyy-MM-dd" 时间格式获取月份 
	 * @return int
	 * @throws
	 */
	public static int getMonth(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		Date parse = null;
		try {
			parse = sdf.parse(date);
			calendar.setTime(parse);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return  calendar.get(Calendar.MONTH) + 1;
	}
	/**
	 * @Title: getYear  
	 * @Desc: "yyyy-MM-dd" 时间格式获取月份 
	 * @return int
	 * @throws
	 */
	public static int getMonth(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return  calendar.get(Calendar.MONTH) + 1;
	}
	
	

	/**
	 * 得到当前的年月日期字符串.<br>
	 * <br>
	 * 
	 * @return 年月日期字符串
	 */
	public static String getYearMonth() {
		Calendar calendar = Calendar.getInstance();
		return getStringFromDate(calendar.getTime(), FORMAT_YEARMONTH);
	}

	/**
	 * 当前日期与参数传递的日期的相差天数.<br>
	 * <br>
	 * 
	 * @param dateinfo
	 *            指定的日期.
	 * @return 相差的天数
	 */
	public static int selectDateDiff(String dateinfo) {
		return selectDateDiff(dateinfo, getDate());
	}

	/**
	 * 当得到两个日期相差天数.<br>
	 * <br>
	 * 
	 * @param first
	 *            第一个日期.
	 * @param second
	 *            第二个日期.
	 * @return 相差的天数
	 */
	public static int selectDateDiff(String first, String second) {
		int dif = 0;
		try {
			Date fDate = getDateFromString(first, FORMAT_DATE);
			Date sDate = getDateFromString(second, FORMAT_DATE);
			dif = (int) ((fDate.getTime() - sDate.getTime()) / 86400000);
		} catch (Exception e) {
			dif = 0;
		}
		return dif;
	}

	/**
	 * 
	 * @说明计算两个日期的时间相差毫秒数
	 * @param start
	 * @param end
	 * @param date_formate
	 * @return long
	 */

	public static long selectMillSecDiff(String start, String end,
			String date_formate) {
		SimpleDateFormat dfs = new SimpleDateFormat(date_formate);
		long between = 0;
		try {
			Date begin_date = dfs.parse(start);
			Date end_date = dfs.parse(end);
			between = (end_date.getTime() - begin_date.getTime());// 得到两者的毫秒数
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return between;
	}

	/**
	 * 
	 * <p>
	 * Description:获取当前日期
	 * </p>
	 * 
	 * @Title: getCurrentDate
	 * @return 当前日期
	 * @author maqingrong
	 */
	public static String getCurrentDate() {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(new Date());
	}

	/**
	 * 
	 * <p>
	 * Description:获取当前日期
	 * </p>
	 * 
	 * @Title: getCurrentDate
	 * @param pattern
	 *            转换模式
	 * @return 当前日期
	 * @author maqingrong
	 */
	public static String getCurrentDate(String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(new Date());
	}

	/**
	 * 
	 * <p>
	 * Description:获取当前时间
	 * </p>
	 * 
	 * @Title: getCurrentTime
	 * @return 当前时间
	 * @author maqingrong
	 */
	public static String getCurrentTime() {
		DateFormat df = new SimpleDateFormat("HHmmss");
		return df.format(new Date());
	}

	/**
	 * 
	 * <p>
	 * Description:字符串转换为时间
	 * </p>
	 * 
	 * @Title: string2Date
	 * @return 转换日期
	 * @author maqingrong
	 */
	public static Date string2Date(String date) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			return df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * <p>
	 * Description:字符串转换为时间
	 * </p>
	 * 
	 * @Title: string2Date
	 * @param date
	 *            日期字符串
	 * @param pattern
	 *            转换模式
	 * @return
	 * @author maqingrong
	 */
	public static Date string2Date(String date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @Title: initDate
	 * @Description: 将当期日期时间转换为当日初始日期时间，如2014-12-02 11:58:59 转换为2014-12-02
	 *               00:00:00
	 * @param
	 * @return String 返回类型
	 * @throws
	 */
	public static String initDate(Date dt) {
		DateFormat df = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		return df.format(dt) + " 00:00:00";

	}

	/**
	 * 得到任意一个年份中某一月份的最大天数.<br>
	 * <br>
	 * 
	 * @param year
	 *            年份.
	 * @param month
	 *            月份.
	 * @return 最大天数
	 */
	public static int getMaxDaysByYearMonth(int year, int month) {

		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 获取年份、月份、天数的字符型的串（例：传过来的是2016、7、17，返回则是2016-7-17）.<br>
	 * <br>
	 * 
	 * @param year
	 *            年份.
	 * @param month
	 *            月份.
	 * @param month
	 *            月份.
	 * @return 相差的天数
	 */
	public static String getYearMonthDayString(int year, int month, int day) {

		return year + "-" + month + "-" + day;
	}

	/**
	 * 格式化日期
	 * 
	 * @param d
	 * @return
	 */
	public static String formatDates(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date parseDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date ret = null;
		try {
			ret = sdf.parse(date);
		} catch (ParseException pe) {
			System.out.println(pe.getMessage());
		}
		return ret;
	}

	/**
	 * 获取指定年份天数
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static int getDayOfYear(int year) {

		Calendar calendar = getCalendar(formatDates(parseDate(
				getYearMonthDayString(year, 1, 1), "yyyy-MM-dd")));

		return calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 获取前N天日期
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static String getBefNDayDate(String date, int n)
			throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c = Calendar.getInstance();

		c.setTime(df.parse(date));

		c.add(Calendar.DATE, -n);

		Date monday = c.getTime();

		return df.format(monday);
	}

	public static String getOneHoursAgoTime() {
		String oneHoursAgoTime = "";
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, Calendar.HOUR - 1); // 把时间设置为当前时间-1小时，同理，也可以设置其他时间
		cal.set(Calendar.MONTH, Calendar.MONTH - 1); // 当前月前一月
		oneHoursAgoTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(cal.getTime());// 获取到完整的时间
		return oneHoursAgoTime;
	}

	/**
	 * 获取两个日期之间的所有月份
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate)
			throws ParseException {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化为年月

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		min.setTime(sdf.parse(minDate));
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

		max.setTime(sdf.parse(maxDate));
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}

		return result;
	}
	
	/**
	 * 获取某一天所有15分钟时间点
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<Map<String,Object>> getDayBy15Minute(String date)
			throws ParseException {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化为年月
		
		String day = sdf.format(sdf.parse(date));
		
		for(int i = 0 ; i< 96 ; i++){
			
			Map<String,Object> retMap = new HashMap<String, Object>();
			
			String min = "";
			
			String max = "";
			
			String crt = "";
			
			int hour = 0;
			
			if(i%4 == 1){
				
				min = ":13:00";
				
				max = ":17:00";
				
				crt = ":15:00";
				
				hour = i/4;
				
				retMap.put("sta_tim", day+" "+hour+min);
				
				retMap.put("end_tim", day+" "+hour+max);
				
				retMap.put("tol_tim", dateToStamp(day+" "+hour+crt));
				
			}else if(i%4 == 2){
				
				min = ":28:00";
				
				max = ":32:00";

				crt = ":30:00";
				
				hour = i/4;
				
				retMap.put("sta_tim", day+" "+hour+min);
				
				retMap.put("end_tim", day+" "+hour+max);

				retMap.put("tol_tim", dateToStamp(day+" "+hour+crt));
				
			}else if(i%4 == 3){
				
				min = ":43:00";

				max = ":47:00";
				
				crt = ":45:00";
				
				hour = i/4;
				
				retMap.put("sta_tim", day+" "+hour+min);
				
				retMap.put("end_tim", day+" "+hour+max);

				retMap.put("tol_tim", dateToStamp(day+" "+hour+crt));
				
			}else if(i%4 == 0){
				
				min = ":58:00";

				max = ":02:00";
				
				crt = ":00:00";
				
				if(i==95){
					
					hour = i/4+1;
					
					String staDate = sdf.format(sdf.parse(date));
					
					String endDate = sdf.format(addDay(sdf.parse(date), 1));
					
					retMap.put("sta_tim", staDate+" "+hour+min);
					
					retMap.put("end_tim", endDate+" "+hour+max);
					
					retMap.put("tol_tim", dateToStamp(endDate+" "+hour+crt));
					
				}else if(i==0){
					
					hour = i/4;
					
					String staDate = getSpecifiedDayBefore(date);
					
					String endDate = sdf.format(sdf.parse(date));
					
					retMap.put("sta_tim", staDate+" "+23+min);
					
					retMap.put("end_tim", endDate+" "+hour+max);
					
					retMap.put("tol_tim", dateToStamp(endDate+" "+hour+crt));
				}else{
					
					hour = i/4;
					
					retMap.put("sta_tim", day+" "+(hour-1)+min);
					
					retMap.put("end_tim", day+" "+hour+max);

					retMap.put("tol_tim", dateToStamp(day+" "+hour+crt));
				}
			}
			
			result.add(retMap);
		}
		return result;
	}


	/**
	 * 获取某一天所有15分钟时间点
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<Map<String,Object>> getDayByHours(String date)
			throws ParseException {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化为年月
		
		for(int i = 0 ; i< 24 ; i++){
			
			Map<String,Object> retMap = new HashMap<String, Object>();
			
			String min = ":58:00";
			
			String max = ":02:00";

			String crt = ":00:00";
			
			if(i==23){
				
				String endDate = sdf.format(sdf.parse(date));
				
				retMap.put("sta_tim", endDate+" "+i+min);
				
				retMap.put("end_tim", sdf.format(addDay(sdf.parse(date), 1))+" 00"+max);
				
				retMap.put("tol_tim", dateToStamp(endDate+" "+i+crt));
				
			}else{
				
				String cr_date = sdf.format(sdf.parse(date));

				retMap.put("sta_tim", cr_date+" "+i+min);
				
				retMap.put("end_tim", cr_date+" "+(i+1)+max);
				
				retMap.put("tol_tim", dateToStamp(cr_date+" "+i+crt));
				
			}
			
			result.add(retMap);
		}
		return result;
	}
	/**
	 * 获取某一天所有1小时时间点(环境检测仪用)
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<Map<String,Object>> getDayByHoursEnv(String date)
			throws ParseException {
		
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化为年月
		
		for(int i = 0 ; i< 24 ; i++){
			
			Map<String,Object> retMap = new HashMap<String, Object>();
			
			String min = ":58:00";
			
			String max = ":02:00";
			
			String crt = ":00:00";
			
			if(i==0){
				
				String endDate = sdf.format(sdf.parse(date));
				
				retMap.put("sta_tim", endDate+" "+i+max);
				
				retMap.put("end_tim", redDay(date)+" 23"+min);
				
//				retMap.put("tol_tim", endDate+" "+i+crt);
				retMap.put("tol_tim", dateToStamp(endDate+" "+i+crt));
				
			}else{
				
				String cr_date = sdf.format(sdf.parse(date));
				
				retMap.put("sta_tim", cr_date+" "+(i-1)+min);
				
				retMap.put("end_tim", cr_date+" "+i+max);
				
//				retMap.put("tol_tim", cr_date+" "+i+crt);
				retMap.put("tol_tim", dateToStamp(cr_date+" "+i+crt));
				
			}
			
			result.add(retMap);
		}
		return result;
	}
	
	/**
	 * 获取两个日期之间的所有日期
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getDateBetween(String minDate, String maxDate)
			throws ParseException {

		List<String> lst = new ArrayList<String>();
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = df.parse(minDate);
		startCalendar.setTime(startDate);
		Date endDate = df.parse(maxDate);
		endCalendar.setTime(endDate);
		while (true) {
			startCalendar.add(Calendar.DAY_OF_MONTH, 1);
			if (startCalendar.getTimeInMillis() <= endCalendar
					.getTimeInMillis()) {// TODO 转数组或是集合，楼主看着写吧
				lst.add(df.format(startCalendar.getTime()));
				System.out.println(df.format(startCalendar.getTime()));
			} else {
				break;
			}
		}
		return lst;
	}

	/**
	 * 获取两个日期之间的所有时间
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getHourBetween(String minDate, String maxDate)
			throws ParseException {

		List<String> lst = new ArrayList<String>();

		try {

			Calendar startCalendar = Calendar.getInstance();

			Calendar endCalendar = Calendar.getInstance();

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			startCalendar.setTime(df.parse(minDate));

			endCalendar.setTime(df.parse(maxDate));

			while (true) {

				startCalendar.add(Calendar.HOUR, 1);

				if (startCalendar.getTimeInMillis() <= endCalendar
						.getTimeInMillis()) {// TODO 转数组或是集合，楼主看着写吧

					lst.add(df.format(startCalendar.getTime()));

					System.out.println(df.format(startCalendar.getTime()));

				} else {

					break;
				}
			}
		} catch (Exception e) {

			System.err.println(e);
		}
		return lst;
	}

	/**
	 * 获取两个日期之间的所有年份
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getYearBetween(String minDate, String maxDate)
			throws ParseException {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");// 格式化为年月

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();

		min.setTime(sdf.parse(minDate));
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

		max.setTime(sdf.parse(maxDate));
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.YEAR, 1);
		}

		return result;
	}

	/**
	 * 获取当前日期与参数传递的日期之间的相差年数(精确到小数点后一位)
	 * 
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static String selectYearDiff(String startDate) throws ParseException {

		// 获取当前日期与参数传递的日期的相差天数.
		int diffDays = selectDateDiff(startDate);
		// 获取两个日期之间的所有年份
		List<String> yearLst = getYearBetween(startDate, getDate());

		int sum = 0;
		// 获取两个日期之间的所有年份间有多少个闰年
		for (String year : yearLst) {

			if ((Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 == 0)
					|| Integer.parseInt(year) % 400 == 0) {

				sum++;
			}
		}

		DecimalFormat df = new DecimalFormat("######0.0");

		String diffYear = df.format(((-diffDays) - sum) / 365);

		return diffYear;
	}

	public static Date addDay(Date date, int n) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		for (int i = 0; i < n; i++) {
			ca.roll(Calendar.DAY_OF_YEAR, true);
			int day = ca.get(Calendar.DAY_OF_YEAR);
			if (day == 1) {
				ca.roll(Calendar.YEAR, true);
			}
		}
		return ca.getTime();
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return dayBefore;
	}

	public static void main(String[] args) throws ParseException {

//		System.out.println(redDay("2018-01-01 00:00:00"));
		System.out.println(getDayByHoursEnv("2018-01-01"));
	}

	public static List<Date> findDates(Date dBegin, Date dEnd) {
		
		List<Date> lDate = new ArrayList<Date>();
		
		lDate.add(dBegin);
		
		Calendar calBegin = Calendar.getInstance();
		
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		
		Calendar calEnd = Calendar.getInstance();
		
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			
			lDate.add(calBegin.getTime());
		}
		
		return lDate;
	}

	/**
	 * 
	 * @param dateTime
	 *            格式为"yyyy-mm-dd"的日期格式
	 * @return string类型的前一天的日期
	 * @throws ParseException
	 */
	public static String getFormerDate(String dateTime) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long dif = df.parse(dateTime).getTime() - 86400 * 1000;
		Date date = new Date();
		date.setTime(dif);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(date);
	}

	/**
	 * 月份加1
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String addMonth(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);

		rightNow.add(Calendar.MONTH, 1);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);

		return reStr;
	}

	/**
	 * 月份减1
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String redMonth(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);

		rightNow.add(Calendar.MONTH, -1);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);

		return reStr;
	}
	

	/**
	 * 日份减1
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String redDay(String date) throws ParseException {
		SimpleDateFormat sj = new SimpleDateFormat(FORMAT_DATE);
        Date d = sj.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        //理论上讲应该是2015-11-29
        calendar.add(calendar.DATE, -1);
        String reStr = sj.format(calendar.getTime());
		return reStr;
	}
	
	/**
	 * 月份减 n
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String redNumMonth(String date, int num) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);

		rightNow.add(Calendar.MONTH, -num);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);

		return reStr;
	}
	
	/**
	 * 年份减1
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String redYear(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);

		rightNow.add(Calendar.YEAR, -1);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);

		return reStr;
	}
	/**
	 * 年份加 n
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String addYear(String date,int n) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		
		rightNow.add(Calendar.YEAR, n);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);
		
		return reStr;
	}
	
	
	/**
	 * 
	 * @param dateTime
	 *            格式为"yyyy-mm-dd"的日期格式
	 * @return string类型的前指定天的日期
	 * @throws ParseException
	 */
	public static String getFormerDate2(String dateTime, int n)
			throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long dif = df.parse(dateTime).getTime() - 86400 * 1000 * n;
		Date date = new Date();
		date.setTime(dif);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(date);
	}

	/**
	 * 
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
	 * 将时间转换为时间戳
	 */
	public static String dateToStamp(String s) throws ParseException {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(s);
		long ts = date.getTime();
		res = String.valueOf(ts);
		return res;
	}

	/**
	 * 获取前一小时时间
	 */
	public static String getOneHourBefore() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		/* HOUR_OF_DAY 指示一天中的小时 */
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.get(Calendar.HOUR_OF_DAY) - 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// System.out.println("一个小时前的时间：" + df.format(calendar.getTime()));
		// System.out.println("当前的时间：" + df.format(new Date()));

		return df.format(calendar.getTime());
	}

	public static String getTimeByHour(int hour) {

		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)
				+ hour);

		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar
				.getTime());
	}

	/**
	 * 所在日期前后偏移几个月的第一天和最后一天
	 * 
	 * @param date
	 *            所在日期
	 * @param offset
	 *            偏移量（例如：当月0，下月1，上月-1）
	 * @return 当月的第一天和最后一天
	 */
	public static Map<String, Object> getMonthStartAndEnd(String date,
			int offset) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.valueOf(date.split("-")[0]));
		cal.set(Calendar.MONTH, Integer.valueOf(date.split("-")[1]) - 1);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, offset + 1);
		cal.add(Calendar.DATE, -1);
		String end = sdf.format(cal.getTime());

		cal.set(Calendar.DATE, 1);
		String start = sdf.format(cal.getTime());

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("end", end);

		return map;
	}

	/***
	 * 获取当前时间 "yyyy-MM-dd HH:mm:ss"
	 */
	public static String getcurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(new Date());
	}

	/***
	 * 获取某年、月、日起始和结束时间点集合
	 * 
	 * @throws ParseException
	 */
	public static List<Map<String, Object>> getDayMonYearTimLst(String date, String type) throws ParseException {
		
		// 返回的时间集合
		List<Map<String, Object>> timLst = new ArrayList<Map<String, Object>>();
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);

		if (type.equals("1")) {// 日

			timLst = getDayBy15Minute(date);
			
		} else if (type.equals("2")) {// 月
			
			Calendar calendar = Calendar.getInstance();
			
			calendar.setTime(sdf.parse(date));

			int year = calendar.get(Calendar.YEAR);
			
			int month = calendar.get(Calendar.MONTH)+1;
			
			List<Date> dateLst = findDates(sdf.parse(DateUtil.getYearMonthDayString(year, month, 1)), sdf.parse(addMonth(DateUtil.getYearMonthDayString(year, month, 1))));
			
			for (int i=0 ; i<dateLst.size() ; i++) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				if (i + 1 != dateLst.size()) {

					map.put("staTim", sdf.format(dateLst.get(i)));

					map.put("endTim", sdf.format(dateLst.get(i + 1)));

					timLst.add(map);
				} 
			}

		} else if (type.equals("3")) {// 年

			Calendar calendar = Calendar.getInstance();
			
			calendar.setTime(sdf.parse(date));
			
			int year = calendar.get(Calendar.YEAR);
			
			List<String> monthLst = getMonthBetween(getYearMonthDayString(year, 1, 1), getYearMonthDayString(year+1, 1, 1));
			
			for (int i=0 ; i<monthLst.size() ; i++) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				if (i + 1 != monthLst.size()) {

					map.put("staTim", monthLst.get(i));

					map.put("endTim", monthLst.get(i + 1));

					timLst.add(map);
				} 
			}
		}else if(type.equals("4")){
			
			timLst = getDayByHours(date);
			
		}else if(type.equals("5")){
			
			Map<String, Object> map = new HashMap<String, Object>();

			Date sta_tim = sdf.parse(date);

			Date end_tim = addDay(sta_tim, 1);

			map.put("sta_tim", sdf.format(sta_tim));

			map.put("end_tim", sdf.format(end_tim));

			timLst.add(map);
		}
		return timLst;
	}
	
	/***
	 * 获取某年、月、日起始和结束时间点集合(传入minDate与maxDate)
	 * 
	 * @throws ParseException
	 */
	public static List<Map<String, Object>> getDayMonYearTimBettwenLst(String minDate,String maxDate, String type) throws ParseException {
		
		// 返回的时间集合
		List<Map<String, Object>> timLst = new ArrayList<Map<String, Object>>();
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
		
		if (type.equals("1")) {// 日
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("staTim", minDate);
			
			map.put("endTim", maxDate);
			
			timLst.add(map);
			
		} else if (type.equals("2")) {// 月
			
			List<Date> dateLst = findDates(sdf.parse(minDate), sdf.parse(maxDate));
			
			for (int i=0 ; i<dateLst.size() ; i++) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				if (i + 1 != dateLst.size()) {
					
					map.put("staTim", sdf.format(dateLst.get(i)));
					
					map.put("endTim", sdf.format(dateLst.get(i + 1)));
					
					timLst.add(map);
				} 
			}
			
		} else if (type.equals("3")) {// 年
			
			List<String> monthLst = getMonthBetween(minDate, maxDate);
			
			for (int i=0 ; i<monthLst.size() ; i++) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				if (i + 1 != monthLst.size()) {
					
					map.put("staTim", monthLst.get(i));
					
					map.put("endTim", monthLst.get(i + 1));
					
					timLst.add(map);
				} 
			}
		} else if (type.equals("4")) {// 多年
			
			if(minDate.equals(maxDate)){
				
				minDate = redYear(minDate);
				
			}
			List<String> yearLst = getYearBetween(minDate, maxDate);
			
			for (int i=0 ; i<yearLst.size() ; i++) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				if (i + 1 != yearLst.size()) {
					
					map.put("staTim", getYearMonthDayString(Integer.valueOf(yearLst.get(i)), 1, 1));
					
					map.put("endTim", getYearMonthDayString(Integer.valueOf(yearLst.get(i + 1)), 1, 1));
					
					timLst.add(map);
				}
			}
		}
		return timLst;
	}

	/**
	 * @Title: getAfterMinutisTime  
	 * @Desc:  日期yyyy-MM-dd HH:mm:ss  加减n分钟 
	 * @return String
	 * @throws
	 */
	public static String getAfterMinutisTime(String time, int minutes) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String afterTime = "";
		long timeLength = minutes * 60 * 1000; 
		try {
			Date now = simpleDateFormat.parse(time);
			Date afterDate = new Date(now .getTime() + timeLength);
			afterTime = simpleDateFormat.format(afterDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return afterTime;
	}
	
	/**
	 * @Title: compareDataTime  
	 * @Desc:  比较两个时间相差的时间间隔 mm 
	 * 			afterTime - beforeTime
	 * @return int
	 * @throws
	 */
	public static long compareDataTime(String beforeTime, String afterTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long res = 0;
		try {
			Date beforeDate = sdf.parse(beforeTime);
			Date afterDate = sdf.parse(afterTime);
			
			long time = beforeDate.getTime();
			long time2 = afterDate.getTime();
			
			res = time2 - time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	/**
	 * @Title: formatTime  
	 * @Desc:  	将yyyy-MM-dd HH:mm:ss格式的时间初始化为yyyy-MM-dd  00:00:00 
	 * 			time: "yyyy-MM-dd HH:mm:ss"格式
	 * @return long
	 * @throws
	 */
	public static String formatTime(String time) {
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = "";
		try {
			Date parse = sdfDate.parse(time);
			format = sdfTime.format(parse);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format;
	}
	
	/**
	 * @Title: formatYearToString  
	 * @Desc:  	将yyyy格式的时间初始化为yyyy-MM-dd 
	 * @throws
	 */
	public static String formatYearToString(String year) {
		
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		String format = "";
		try {
			Date parse = sdfYear.parse(year);
			format = sdfTime.format(parse);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format;
	}
	
	
	/**
	 * @Title: formatYearMonToString  
	 * @Desc:  	将yyyy格式的时间初始化为yyyy-MM-dd 
	 * @throws
	 */
	public static String formatYearMonToString(String yearMon) {
		
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		String format = "";
		try {
			Date parse = sdfYear.parse(yearMon);
			format = sdfTime.format(parse);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format;
	}
	
	/**
	 * 获取15分钟曲线图方法
	 */
	public static List<Map<String, Object>> getFifteenMinutesCurves(String date,List<Map<String,Object>> curLst) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		// 每15分钟一个间隔获取1天96个时间的集合
		List<Map<String, Object>> minLst = getDayMonYearTimLst(date, "1");
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		// 对曲线图点信息集合进行遍历
		
		for(Map<String, Object> minMap:minLst){
			
			Iterator<Map<String,Object>> it = curLst.iterator();
			
			Map<String,Object> retMap = new HashMap<String, Object>();
			// 将从96个时间点集合中取出的开始时间，取出并转化成long类型数字串
			long staTimL = sdf.parse(minMap.get("sta_tim").toString()).getTime();
			// 将从96个时间点集合中取出的结束时间，取出并转化成long类型数字串
			long endTimL = sdf.parse(minMap.get("end_tim").toString()).getTime();
			// 将从96个时间点集合中取出的展示时间，取出并转化成long类型数字串
			long tolTimL = Long.valueOf(minMap.get("tol_tim").toString());
			
			while(it.hasNext()){
				
			    Map<String,Object> curMap = it.next();
			    // 将从数据库中取出的当前时间，取出并转化成long类型数字串
			    long crtTimL = sdf.parse(curMap.get("crtTim").toString()).getTime();
			    
			    if(crtTimL<staTimL){
			    	
			    	it.remove();
			    	
			    }  else if(staTimL<crtTimL && crtTimL<endTimL){
			    	
			    	retMap.putAll(curMap);
			    	
			    	it.remove();
			    	
			    	break;
			    	
			    } else if(endTimL<crtTimL){
			    	
			    	break;
			    }
			}

	    	retMap.put("tol_tim", tolTimL);
	    	
	    	retLst.add(retMap);
		}
		
		return retLst;
	}
}
