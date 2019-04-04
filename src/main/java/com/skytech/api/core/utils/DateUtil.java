package com.skytech.api.core.utils;

import com.google.common.base.Strings;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期格式化
 */
public final class DateUtil {

    public static final String LONG_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String PURE_LONG_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmssSSS";

    public static final String STANDARD_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String STANDARD_DATE_TIME_FORMAT_STR_EXT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String PURE_STANDARD_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmss";

    public static final String MIDDLE_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm";
    public static final String PURE_MIDDLE_DATE_TIME_FORMAT_STR = "yyyyMMddHHmm";

    public static final String SHORT_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH";
    public static final String PURE_SHORT_DATE_TIME_FORMAT_STR = "yyyyMMddHH";

    public static final String STANDARD_DATE_FORMAT_STR = "yyyy-MM-dd";
    public static final String PURE_STANDARD_DATE_FORMAT_STR = "yyyyMMdd";

    public static final String MIDDLE_DATE_FORMAT_STR = "yyyy-MM";
    public static final String PURE_MIDDLE_DATE_FORMAT_STR = "yyyyMM";

    public static final String YEAR_FORMAT_STR = "yyyy";

    /**
     * 通用日期模式
     */
    private static final String[] GENERIC_DATE_PATTERNS = {
            LONG_DATE_TIME_FORMAT_STR, STANDARD_DATE_TIME_FORMAT_STR,
            MIDDLE_DATE_TIME_FORMAT_STR, STANDARD_DATE_FORMAT_STR, STANDARD_DATE_TIME_FORMAT_STR_EXT, MIDDLE_DATE_FORMAT_STR, PURE_STANDARD_DATE_FORMAT_STR};

    private DateUtil() {
    }

    /**
     * 日期字符串转化为日期
     *
     * @param str  日期字符串
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String str) {
        try {
            return DateUtils.parseDate(str, GENERIC_DATE_PATTERNS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期时间格式(yyyyMMddHHmmssSSS)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatmiddledatestr(Date date) {
        return DateFormatUtils.format(date, MIDDLE_DATE_FORMAT_STR);
    }
    /**
     * 日期时间格式(yyyyMMddHHmmssSSS)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureLongDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_LONG_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyy-MM-dd HH:mm:ss)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatStandardDatetime(Date date) {
        if (null == date) {
            return "";
        }
        return DateFormatUtils.format(date, STANDARD_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMddHHmmss)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureStandardDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_STANDARD_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyy-MM-dd HH:mm)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatMiddleDatetime(Date date) {
        return DateFormatUtils.format(date, MIDDLE_DATE_TIME_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMddHHmm)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureMiddleDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_MIDDLE_DATE_TIME_FORMAT_STR);
    }

    /**
     * 格式日期为系统的标准格式(yyyy-MM-dd)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatStandardDate(Date date) {
        if (null == date) {
            return "";
        }
        return DateFormatUtils.format(date, STANDARD_DATE_FORMAT_STR);
    }

    /**
     * 日期时间格式(yyyyMMdd)
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureStandardDate(Date date) {
        return DateFormatUtils.format(date, PURE_STANDARD_DATE_FORMAT_STR);
    }

    /**
     * 根据出生日期计算年龄
     *
     * @param birthday
     * @return
     */
    public static int getAgeByBirthday(String birthday) {
        if (Strings.isNullOrEmpty(birthday)) {
            return 0;
        }

        return getAgeByBirthday(parseDate(birthday));
    }

    /**
     * 根据出生日期计算年龄
     *
     * @param birthday
     * @return
     */
    public static int getAgeByBirthday(Date brithday) {
        if (brithday == null) {
            return 0;
        }

        Calendar todayCalendar = Calendar.getInstance();
        Calendar brithdayCalendar = Calendar.getInstance();
        brithdayCalendar.setTime(brithday);

        return todayCalendar.get(Calendar.YEAR) - brithdayCalendar.get(Calendar.YEAR);
    }


    /**
     * 根据日期计算天数差
     *
     * @param beforeDate 早日期
     * @param afterDate  晚日期
     * @return
     */
    public static int getDaysNum(Date beforeDate,
                                 Date afterDate) {
        Calendar calBefore = Calendar.getInstance();
        Calendar calAfter = Calendar.getInstance();
        calBefore.setTime(beforeDate);
        calAfter.setTime(afterDate);
        long day = ((calAfter.getTimeInMillis() - calBefore.getTimeInMillis()) / (60 * 60 * 24 * 1000));
        return (int) day;
    }

    /**
     * 根据天数，计算日期
     *
     * @param date   日期
     * @param dayNum 天数差
     * @return
     */
    public static Date getDateByDayNum(Date date, int dayNum) {
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        return new Date(calDate.getTimeInMillis() + (60 * 60 * 24 * 1000) * dayNum);
    }

    /**
     * 日期比较，1表示大于，0表示等于，-1表示小于
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compare(Date date1, Date date2) {
        long l = date1.getTime() - date2.getTime();
        if (l > 0) {
            return 1;
        } else if (l == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
