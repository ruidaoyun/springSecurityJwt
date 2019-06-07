package com.belle.springsecurityjwt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: 增加描述
 * 
 * @author jin.jy
 * @date 2016年3月28日 下午9:56:08
 * @version 0.1.0 
 * @copyright yougou.com 
 */
public class DateUtil {

	public String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static Date parseDate(java.sql.Date date) {
		return date;
	}

	public static java.sql.Date parseSqlDate(Date date) {
		if (date != null) {
			return new java.sql.Date(date.getTime());
		} else {
			return null;
		}
	}

	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				java.text.DateFormat df = new SimpleDateFormat(format);
				result = df.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	public static String format(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	public static String format1(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	public static int getWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		dayOfWeek = dayOfWeek - 1;
		if (dayOfWeek == 0) {
			dayOfWeek = 7;
		}
		return dayOfWeek;
	}

	public static String getDate(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	public static String getDate(Date date, String formatStr) {
		return format(date, formatStr);
	}

	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	public static String getDateTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 日期相加
	 * @param date Date
	 * @param day int
	 * @return Date
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 日期相加
	 * @param date Date
	 * @param month int
	 * @return Date
	 */
	public static Date addMonth(Date date, int month) {
		Calendar c = Calendar.getInstance();
		c.add(c.MONTH, month);
		return c.getTime();
	}

	/**
	 * 日期相减
	 * @param date Date
	 * @param date1 Date
	 * @return int
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}

	/**
	 * 日期相减(返回秒值)
	 * @param date Date
	 * @param date1 Date
	 * @return int
	 * @author
	 */
	public static Long diffDateTime(Date date, Date date1) {
		return (Long) ((getMillis(date) - getMillis(date1)) / 1000);
	}

	public static Date getdate(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(date);
	}

	public static Date getdate1(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(date);
	}

	public static Date getMaxTimeByStringDate(String date) throws Exception {
		String maxTime = date + " 23:59:59";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(maxTime);
	}

	/**
	 * 获得当前时间
	 * @return
	 */
	public static Date getCurrentDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = DateUtil.getDateTime(date);
		try {
			return sdf.parse(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static String getCurrentDateTimeToStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(getCurrentDateTime());
	}

	public static String getCurrentDateTimeToStr2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(getCurrentDateTime());
	}

	public static Long getWmsupdateDateTime() {
		Calendar cl = Calendar.getInstance();

		return cl.getTimeInMillis();
	}

	public static Integer getLeftSeconds(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date condition = sdf.parse(date);
		long n = condition.getTime();
		long s = sdf.parse(getCurrentDateTimeToStr2()).getTime();
		//    	System.out.println("开始时间:"+date+"-->"+(int)((s-n)/1000));
		return (int) ((s - n) / 1000);
	}

	/**
	 * 获得时间戳
	 * @return
	 * @throws Exception
	 */
	public static String getTime() {
		Date date = new Date();
		return String.valueOf(date.getTime());
	}

	public static void main(String[] args) {
		try {

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/** 判断日期格式是否正确 */
	public static boolean validateDate(String dateString) {
		//使用正则表达式 测试 字符 符合 dddd-dd-dd 的格式(d表示数字)
		Pattern p = Pattern.compile("\\d{4}+[-]\\d{2}+[-]\\d{2}+");
		Matcher m = p.matcher(dateString);
		if (!m.matches()) {
			return false;
		}
		//得到年月日
		String[] array = dateString.split("-");
		int year = Integer.valueOf(array[0]);
		int month = Integer.valueOf(array[1]);
		int day = Integer.valueOf(array[2]);

		if (month < 1 || month > 12) {
			return false;
		}
		int[] monthLengths = new int[] { 0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year)) {
			monthLengths[2] = 29;
		} else {
			monthLengths[2] = 28;
		}
		int monthLength = monthLengths[month];
		if (day < 1 || day > monthLength) {
			return false;
		}
		return true;
	}

	/** 是否是闰年 */
	private static boolean isLeapYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}
	
	  /** 
     *  
     * 1 第一季度 2 第二季度 3 第三季度 4 第四季度 
     *  
     * @param date 
     * @return 
     */  
    public static int getSeason(Date date) {  
  
        int season = 0;  
  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        case Calendar.MARCH:  
            season = 1;  
            break;  
        case Calendar.APRIL:  
        case Calendar.MAY:  
        case Calendar.JUNE:  
            season = 2;  
            break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        case Calendar.SEPTEMBER:  
            season = 3;  
            break;  
        case Calendar.OCTOBER:  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
            season = 4;  
            break;  
        default:  
            break;  
        }  
        return season;  
    }  

}