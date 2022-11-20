package com.houli.pms.sync.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description 提供与日期时间相关的方法
 * @version 20140822
 */
public class DateTimeUtil {


	/**
	 * @description 由输入指定格式方式Eg:dateTimeUtil.format('yyyy-mm-dd hh:mm:ss',new Date());
	 * @param formatstr：格式方式（Eg:yyyy-mm-dd hh:mm:ss,yyyy-mm-dd）等
	 * @param date：日期
	 * @return
	 * @throws
	 */
	public static String format(String formatstr, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatstr);
		return dateFormat.format(date);
	}
	
	

	/**
	 * @description 得到当前时间，格式为：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNowDateTime1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = sdf.format(new Date());
		return dt;
	}

	/**
	 * @description 得到当前时间，格式为：yyyyMMdd-HHmmss
	 * @return
	 */
	public static String getNowDateTime2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}

	/**
	 * @description 得到当前时间，格式为：yyyyMMddHHmmss
	 * @return
	 */
	public static String getNowDateTime3() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}

	/**
	 * @description 得到当前时间，格式为：yyyyMMddHHmmssSSSS
	 * @return
	 */
	public static String getNowDateTime4() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}

	
	/**
	 * @description 得到当前日期，格式为：yyyy-MM-dd
	 * @return
	 */
	public static String getNowDate1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}

	/**
	 * @description 得到当前日期，格式为：yyyy年MM月dd
	 * @return
	 */
	public static String getNowDate2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}

	/**
	 * @description 得到当前日期，格式为：yyyyMMdd
	 * @return
	 */
	public static String getNowDate3() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}

	
	/**
	 * @description 得到当前年份，格式为：yyyy
	 * @return
	 */
	public static String getNowYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}
	
	/**
	 * @description 得到当前月份，格式为：MM
	 * @return
	 */
	public static String getNowMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}
	
	/**
	 * @description 得到当前天，格式为：dd
	 * @return
	 */
	public static String getNowDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}

	/**
	 * @description 得到当前小时，格式为：HH
	 * @return
	 */
	public static String getNowHour() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		String shortdt = sdf.format(new Date());
		return shortdt;
	}

	
	
	/**
	 * @description 将给定字符串转为指定格式的时间，转换后格式为：yyyy-MM-dd HH:mm:ss
	 * @param strDateTime	给定的字符串日期
	 * @return
	 * @throws Exception
	 */
	public static Date getDateTime(String strDateTime) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date strToDateTime = null;
		if (strDateTime == null) {
			return strToDateTime;
		}
		try {
			strToDateTime = formatter.parse(strDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strToDateTime;
	}

	/**
	 * @description 将给定字符串转为指定格式的日期，转换后格式为：yyyy-MM-dd
	 * @param strDate	给定的字符串日期
	 * @return
	 * @throws Exception
	 */
	public static Date getDate1(String strDate) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date strToDate = null;
		try {
			strToDate = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strToDate;
	}

	/**
	 * @description 将给定字符串转为指定格式的日期，转换后格式为：yyyy年MM月dd日
	 * @param strDate	给定的字符串日期
	 * @return
	 * @throws Exception
	 */
	public static Date getDate2(String strDate) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		Date strToDate = null;
		try {
			strToDate = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strToDate;
	}

	
	
	/**
	 * @description 将给定字符串转为指定格式的日期，返回字符串形式，转换后格式为：yyyy/MM/dd
	 * @param strDateTime	给定的字符串日期
	 * @return
	 * @throws Exception
	 */
	public static String getDateByStr1(String strDate) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String strToDate = null;
		try {
			strToDate = formatter.format(formatter.parse(strDate)).toString();
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strToDate;
	}

	/**
	 * @description 将给定字符串转为指定格式的日期，返回字符串形式，转换后格式为：yyyy-MM-dd
	 * @param strDate	给定的字符串日期
	 * @return
	 * @throws Exception
	 */
	public static String getDateByStr2(String strDate){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strToDate = null;
		try {
			strToDate = formatter.format(formatter.parse(strDate)).toString();
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return strToDate;
	}
	
	
	/**
	 * @description 将给定字符串转为指定格式的时间，返回字符串形式，转换后格式为：yyyy-MM-dd HH:mm:ss
	 * @param strDateTime	给定的字符串时间
	 * @return
	 * @throws Exception
	 */
	public static String getDateTimeByStr1(String strDateTime) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strToDateTime = null;
		try {
			strToDateTime = formatter.format(formatter.parse(strDateTime)).toString();
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strToDateTime;
	}
	
	/**
	 * @description 得到当前时间，返回Date，格式为：yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws Exception
	 */
	public static Date getNowDateTime10() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(new Date());
		Date nowDate = null;
		try {
			nowDate = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return nowDate;
	}

	
	/**
	 * @description 得到当前时间，返回Date，格式为：yyyy-MM-dd
	 * @return
	 * @throws Exception
	 */
	public static Date getNowDate10() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(new Date());
		Date nowDateShort = null;
		try {
			nowDateShort = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return nowDateShort;
	}

	
	
	/**
	 * @description 得到2个日期的天数差，strEndDate - strStartDate
	 * @param strStartDate：开始时间
	 * @param strEndDate：结束时间
	 * @return
	 * @throws Exception
	 */
	public static long getDayDifference(String strStartDate, String strEndDate) throws Exception {
		Date d1 = DateTimeUtil.getDate1(strStartDate);
		Date d2 = DateTimeUtil.getDate1(strEndDate);
		long dayNum = (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);
		return dayNum;
	}
	
	/**
	 * @description 得到2个日期的天数差，dEndDate - dStartDate
	 * @param dStartDate：开始时间
	 * @param dEndDate：结束时间
	 * @return
	 */
	public static long getDayDifference(Date dStartDate, Date dEndDate) throws Exception {
		long rowe = (dEndDate.getTime() - dStartDate.getTime()) / (1000 * 60 * 60 * 24);
		return rowe;
	}

	/**
	 * @description 得到指定日期加上天数后的日期，eg:2013-8-15 + 20 = 2013-09-04
	 * @param strDate：指定日期
	 * @param iDayNum：所加天数
	 * @return
	 * @throws Exception
	 */
	public static String getDateByAddNum(String strDate, int iDayNum) throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTime(DateTimeUtil.getDateTime(strDate));
		c.add(Calendar.DATE, iDayNum);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String st = sd.format(c.getTime());
		return st;
	}

	
	
	/**
	 * @description 判断第二个日期是否大于第一个日期
	 * @param dateFirst：第一个日期
	 * @param dateSecond：第二个日期
	 * @return
	 * @throws Exception
	 */
	public static Boolean isAfter(Date dateFirst, Date dateSecond) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		String strFirst = formatter.format(dateFirst);
		String strSecond = formatter.format(dateSecond);

		Integer iFirst = Integer.valueOf(strFirst);
		Integer iSecond = Integer.valueOf(strSecond);

		if (iSecond - iFirst > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 两个日期间的天数
	 * @param one
	 * @param two
	 * @return
	 */
	public static long daysBetween(Date one, Date two) {
		long difference =  (one.getTime()-two.getTime())/86400000;
		return Math.abs(difference);
	}

}