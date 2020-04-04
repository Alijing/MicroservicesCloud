package com.jing.springcloud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: IntegratedBis
 * @Date: 2018/10/19 10:56
 * @Author: Jing
 * @Description:
 */
public class DateUtils {

    public static final String FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_STRING_1 = "yyyy-MM-dd";
    public static final String FORMAT_STRING_2 = "yyyy年MM月dd";

    /**
     * 获取当前系统时间
     *
     * @return 当前系统时间
     */
    public static String getCurrentDate(String sdf) {
        SimpleDateFormat df = new SimpleDateFormat(sdf);//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    /**
     * 获取当前时间的后几天或者是前几天
     *
     * @param interval 间隔天数
     * @return 后几天或者是前几天
     */
    public static String getDistanceCurrentDayDate(int interval) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, interval);
        date = calendar.getTime();
        return sdf.format(date);
    }

    /**
     * 获取当前时间的后几天或者是前几天
     *
     * @param interval 间隔天数
     * @return 后几天或者是前几天
     */
    public static String getDistanceCurrentDayDate(int interval, String sdfStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(sdfStr);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, interval);
        date = calendar.getTime();
        return sdf.format(date);
    }

    /**
     * 获取指定时间的后几天或者是前几天
     *
     * @param interval 间隔天数
     * @return 后几天或者前几天
     */
    public static String getDistanceAppointDayDate(String appointDate, int interval, String sdfStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(sdfStr);
        Date date = sdf.parse(appointDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, interval);
        date = calendar.getTime();
        return sdf.format(date);
    }

    /**
     * 时间比大小
     *
     * @param t1
     * @param t2
     * @return
     */
    public static int timeCompare(String t1, String t2, String sdf) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(sdf);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(formatter.parse(t1));
        c2.setTime(formatter.parse(t2));
        return c1.compareTo(c2);
    }

    public static String dateFormat(String dateStr, String sSdfStr, String eSdfStr) throws ParseException {
        SimpleDateFormat sFormat = new SimpleDateFormat(sSdfStr);
        SimpleDateFormat eFormat = new SimpleDateFormat(eSdfStr);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(sFormat.parse(dateStr));
        return eFormat.format(c1.getTime());
    }

    public static String dateFormat(long time, String eSdfStr) {
        return new SimpleDateFormat(eSdfStr).format(new Date(time));
    }

    public static long dateToTimestamp(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(time);
            long ts = date.getTime();
            return ts;
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * 计算指定年度共有多少个周。
     *
     * @param year 格式 yyyy ，必须大于1900年度 小于9999年
     * @return
     */
    public static int getWeekNumByYear(final int year) {
        if (year < 1900 || year > 9999) {
            throw new NullPointerException("年度必须大于等于1900年小于等于9999年");
        }
        int result = 52;// 每年至少有52个周 ，最多有53个周。
        String date = getYearWeekFirstDay(year, 53);
        if (date.substring(0, 4).equals(year + "")) { // 判断年度是否相符，如果相符说明有53个周。
            result = 53;
        }
        return result;
    }

    /**
     * 计算某年某周的开始日期
     *
     * @param yearNum 格式 yyyy ，必须大于1900年度 小于9999年
     * @param weekNum 1到52或者53
     * @return 日期，格式为yyyy-MM-dd
     */
    public static String getYearWeekFirstDay(int yearNum, int weekNum) {
        if (yearNum < 1900 || yearNum > 9999) {
            throw new NullPointerException("年度必须大于等于1900年小于等于9999年");
        }
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY); // 设置每周的第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 每周从周一开始
        // 上面两句代码配合，才能实现，每年度的第一个周，是包含第一个星期一的那个周。
        cal.setMinimalDaysInFirstWeek(7); // 设置每周最少为7天
        cal.set(Calendar.YEAR, yearNum);
        cal.set(Calendar.WEEK_OF_YEAR, weekNum);

        // 分别取得当前日期的年、月、日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 计算某年某周的结束日期
     *
     * @param yearNum 格式 yyyy ，必须大于1900年度 小于9999年
     * @param weekNum 1到52或者53
     * @return 日期，格式为yyyy-MM-dd
     */
    public static String getYearWeekEndDay(int yearNum, int weekNum) {
        if (yearNum < 1900 || yearNum > 9999) {
            throw new NullPointerException("年度必须大于等于1900年小于等于9999年");
        }
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY); // 设置每周的第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);// 每周从周一开始
        // 上面两句代码配合，才能实现，每年度的第一个周，是包含第一个星期一的那个周。
        cal.setMinimalDaysInFirstWeek(7); // 设置每周最少为7天
        cal.set(Calendar.YEAR, yearNum);
        cal.set(Calendar.WEEK_OF_YEAR, weekNum);

        // 分别取得当前日期的年、月、日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * 大于24小时返回天数
     * 小于24小时返回小时
     *
     * @param dateStr1
     * @param dateStr2
     * @return
     */
    public static int diffTimeBMillisecond(String dateStr1, String dateStr2, String sdf) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(sdf);
        Date date1 = format.parse(dateStr1);
        Date date2 = format.parse(dateStr2);
        long hours = (date2.getTime() - date1.getTime()) / (1000 * 3600);
        if (hours > 24) return (int) (hours / 24);
        else return (int) hours;
    }

}
