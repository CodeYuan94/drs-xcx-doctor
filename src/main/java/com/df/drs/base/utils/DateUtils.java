package com.df.drs.base.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class DateUtils {

    /**
     * 日期分隔符
     */
    private final static List<String> symbols = Arrays.asList(".", "-", "/");

    /**
     * 日期格式yyyy-MM-dd HH:mm:ss
     */
    private static final Pattern NORNAML = Pattern.compile("^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)" +
            "\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$");

    /**
     * 日期格式 yyyy/MM/dd
     */
    private static final Pattern NO_NORNAML_SMPLE = Pattern.compile("^((?!0000)[0-9]{4}\\/((0[1-9]|1[0-2])\\/(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])\\/(29|30)|(0[13578]|1[02])\\/31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)\\/02\\/29)$");

    /**
     * 日期格式 yyyy/MM/dd HH:mm:ss
     */
    private static final Pattern NO_NORNAML = Pattern.compile("^((?!0000)[0-9]{4}\\/((0[1-9]|1[0-2])\\/(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])\\/(29|30)|(0[13578]|1[02])\\/31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)\\/02\\/29)" +
            "\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$");

    /**
     * 日期格式 yyyy-MM-dd
     */
    private static final Pattern NORNAML_SMPLE = Pattern.compile("^((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)$");

    /**
     * 客户端与服务端时间差（单位s）
     */
    private static Integer diffServer;

    /**
     * 初始化客户端与服务端时间差
     *
     * @param clientDate 客户端时间
     * @param serverDate 服务端时间
     */
    public static void init(Date clientDate, Date serverDate) {
        //相差秒数
        long diffSec = DateUtils.diffTime(serverDate, clientDate) / 1000L;
        diffServer = (int) diffSec;
        System.out.println("***********客户端与服务端时间差" + diffSec);
    }

    /**
     * 字符串时间格式转换
     *
     * @param str
     * @return
     */
    public static Date strToDate(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return null;
        }
        //时间格式
        String format = matchFormat(str);
        if (null != format) {
            return strToDate(str, format);
        }

        Long time = null;
        try {
            time = Long.parseLong(str);
            return new Date(time);
        } catch (Exception e) {
        }

        return null;
    }

    /**
     * 匹配时间格式
     *
     * @param data 时间字符串
     * @return
     */
    public static String matchFormat(String data) {
        if (NORNAML.matcher(data).matches()) {
            return "yyyy-MM-dd HH:mm:ss";
        }

        if (NORNAML_SMPLE.matcher(data).matches()) {
            return "yyyy-MM-dd";
        }

        if (NO_NORNAML_SMPLE.matcher(data).matches()) {
            return "yyyy/MM/dd";
        }

        if (NO_NORNAML.matcher(data).matches()) {
            return "yyyy/MM/dd";
        }
        return null;
    }

    /**
     * 校验时间格式
     *
     * @param data    时间字符串
     * @param formate 时间格式
     * @return
     */
    public static boolean checkFromat(String data, String formate) {
        if (null == data) {
            return false;
        }
        Pattern pattern = null;
        formate = StringUtils.isNullOrEmpty(formate) ? "yyyy-MM-dd" : formate;
        switch (formate) {
            case "yyyy-MM-dd HH:mm:ss":
                pattern = NORNAML;
                break;
            case "yyyy/MM/dd":
                pattern = NO_NORNAML_SMPLE;
                break;
            case "yyyy/MM/dd HH:mm:ss":
                pattern = NO_NORNAML;
                break;
            default:
                //yyyy-MM-dd
                pattern = NORNAML_SMPLE;
                break;
        }
        return pattern.matcher(data).matches();
    }

    /**
     * 计算服务器指定天数日期字符串
     *
     * @param days
     * @return
     */
    public static String setServiceTimeStrByDay(int days) {
        Date date = setServiceTimeByDay(days);
        return dateToString(date, "");
    }

    /**
     * 计算服务器指定天数日期
     *
     * @param days
     * @return
     */
    public static Date setServiceTimeByDay(int days) {
        try {
            return setDateByDay(getServiceTime(), days);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取服务器当前时间
     *
     * @return
     */
    public static Date getServiceTime() {
        Date now = new Date();
//        //服务端与客户端误差大于1s使用客户端时间
//        if(null != diffServer && Math.abs(diffServer) > 1){
//            now = DateUtils.setDateBySec(now,diffServer);
//        }
        return now;
    }

    /**
     * 时间格式转为指定格式字符串（未设置，默认为yyyy-MM-dd）
     *
     * @param date
     * @param format
     */
    public static String dateToString(Date date, String format) {
        if (null == date) {
            return null;
        }
        String str = "";
        format = StringUtils.isBlank(format) ? "yyyy-MM-dd" : format;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            str = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String getCurrectTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    /**
     * 转换日期格式
     *
     * @param
     * @return
     */
    public static Map<String, String> matchDate(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        String[] arr = null;
        //根据定义的符号分割日期
        for (String symbol : symbols) {
            if (str.indexOf(symbol) >= 0) {
                symbol = symbol.equals(".") ? "\\." : symbol;
                arr = str.split(symbol);
                break;
            }
        }

        if (null != arr && arr.length == 3) {
            StringBuilder format = new StringBuilder();
            StringBuilder date = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (i != 0) {
                    format.append("-");
                    date.append("-");
                }
                String sf;
                String sd;
                switch (i) {
                    case 0:
                        sf = "yyyy";
                        sd = arr[i];
                        break;
                    case 1:
                        sd = arr[i].replaceFirst("0", "");
                        sf = sd.length() == 1 ? "M" : "MM";
                        break;
                    default:
                        sd = arr[i].replaceFirst("0", "");
                        int endIndex = sd.indexOf(" ");
                        if (endIndex > 0) {
                            sd = sd.substring(0, endIndex);
                        }
                        sf = sd.length() == 1 ? "d" : "dd";
                        break;
                }
                format.append(sf);
                date.append(sd);
            }
            Map<String, String> map = new HashMap<String, String>(2);
            map.put("format", format.toString());
            map.put("date", date.toString());
            return map;
        }
        return null;
    }

    /**
     * 自定义字符串日期格式转换
     *
     * @param str
     * @param format
     * @return
     */
    public static Date strToDate(String str, String format) {
        if (StringUtils.isNullOrEmpty(str)) {
            return null;
        }
        try {
            format = StringUtils.isBlank(format) ? "yyyy-MM-dd" : format;
            format = str.length() < format.length() ? format.substring(0, str.length()) : format;
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 是否是相同的时间
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameTime(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        return cal1.getTime().equals(cal2.getTime());
    }

    /**
     * 给定天数设置日期
     *
     * @param date 日期
     * @param days 天数
     * @return
     */
    public static Date setDateByDay(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /**
     * 给定秒数设置日期
     *
     * @param date 日期
     * @param sec  间隔秒数
     * @return
     */
    public static Date setDateBySec(Date date, int sec) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, sec);
        return cal.getTime();
    }

    /**
     * 间隔时间（单位为毫秒）
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long diffTime(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return -1;
        }
        return d1.getTime() - d2.getTime();
    }

    /**
     * 日期之间间隔天数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long diffDay(Date d1, Date d2) {
        return diffTime(d1, d2) / 86400000l;
    }

    /**
     * 间隔时间（单位为小时）
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long diffTimeByHour(Date d1, Date d2) {
        return diffTime(d1, d2) / 3600000l;
    }

    /**
     * 对象转时间格式
     *
     * @param d      支持字符类型，长整型，时间格式
     * @param format
     * @return
     */
    public static Date objToDate(Object d, String format) {
        if (null == d) {
            return null;
        }
        if (d instanceof String) {
            return strToDate(d.toString(), format);
        }
        if (d instanceof Long) {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis((Long) d);
            return c.getTime();
        }
        return (Date) d;
    }

    public static void main(String[] arg) {
//        Date date = new Date();
//        System.out.println(isSameTime(date,date));
//        System.out.println(">>>>>>>>>>>>>>>"+matchDate("2013.12.1"));
//        Map<String,String> map = matchDate("2018.09.18 ewq12");
//        System.out.println(">>>>>>>>>>>>>>>"+strToDate(map.get("date"),map.get("format")));
//        System.out.println(">>>>>>>>>>>>>>>"+matchDate("2013/1/1"));
//        System.out.println(">>>>>>>>>>>>>>>"+objToDate("2013-01-01","yyyy-MM-dd HH:mm:ss"));
//        System.out.println(">>>>>>>>>>>>>>>"+objToDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
//        System.out.println(">>>>>>>>>>>>>>>"+objToDate(1234566l,"yyyy-MM-dd HH:mm:ss"));
//        System.out.println(dateToString(new Date(),""));
//        System.out.println(">>>>>>>>>>>>>>>"+diffDay(strToDate("2020-01-31","yyyy-MM-dd"),new Date()));
//        System.out.println(diffTime(strToDate("2013-12-12","yyyy-MM-dd HH:mm:ss"),new Date()));


//        List<Integer[]> list= getWeeks(2020, 7);
//        for (Integer[] integers : list) {
//            System.out.println(integers[0]+"~"+integers[6]+"日");
//        }
        Map<String, String> map = getdate123("2020-06");

        System.out.println(map.toString());

        System.out.println(getweek(0));
    }

    private static Map<String, String> getDate(int i) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = dateFormat.format(new Date());
        String month = nowDate.substring(5, 7) + i;
        Date startDate = null;
        Date endDate = null;
        return null;
    }


    private static Map<String ,String> getdate123(String s){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate2 = null;
        Date myDate1 = null;
        try {
            myDate2 = dateFormat.parse(s+"-01");
            switch (s.substring(5,7)){
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    myDate1 = dateFormat.parse(s+"-31");
                    break;
                case "04":
                case "06":
                case "09":
                case "11":
                    myDate1 = dateFormat.parse(s+"-30");
                    break;
                case "02":
                    myDate1 = dateFormat.parse(s.substring(0,5)+"03-01");
                    myDate1 = new Date(myDate1.getTime() - 24*60*60*1000);
                    break;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String begin = getweek(myDate2);
        String end = getweek(myDate1);

        Map<String ,String> result = new HashMap<>(2);
        result.put("begin",begin);
        result.put("end",end);
        return result;
    }

    /**
     * //     * @param m 0 本月   正的 后    负的 前
     *
     * @return java.lang.String   开始和结束日期
     * @auther Liu Yaoguang
     * @Description
     */
    public static Map<String, String> getmonth(int y) {
        Map<String, String> result = new HashMap<>();
        int o = y;
        Integer integer = Integer.valueOf(getCurrectTime().substring(5, 7));
        int m = y - integer;
        for (int i = 6 * (m); i < 6 * (m + 1); i++) {
            String getweek = getweek(i);
            String[] split = getweek.split(",");
            if (Integer.valueOf(split[0].substring(5, 7)) != o) {
                break;
            }
            result.put(split[0], split[1]);

        }
        for (int i = 6 * (m); i > 6 * (m - 1); i--) {
            String getweek = getweek(i - 1);
            String[] split = getweek.split(",");
            if (Integer.valueOf(split[1].substring(5, 7)) != o) {
                break;
            }
            result.put(split[0], split[1]);

        }
        return result;
    }


    private static List<Integer[]> getWeeks(int year, int month) {
        List<Integer[]> weeks = new ArrayList<Integer[]>();
        // 获取上个月的最后一天日期 和本月的最后一天日期
        // 取得系统当前时间
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        int currentMonthDayCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 取得系统当前时间所在月第一天时间对象
        cal.set(Calendar.DAY_OF_MONTH, 1);
        // 日期减一,取得上月最后一天时间对象
        cal.add(Calendar.DAY_OF_MONTH, -1);
        int lastMonthDayCount = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, 1);
        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            cal.add(Calendar.DATE, 1);
        }
        int currentMonthFirstSunday = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(currentMonthDayCount + "  " + currentMonthFirstSunday + "  " + lastMonthDayCount);
        int sunday = currentMonthFirstSunday - 7;
        while (sunday < currentMonthDayCount) {
            Integer[] weekArr = new Integer[7];
            for (int i = 0; i < weekArr.length; i++) {
                sunday = sunday + 1;
                weekArr[i] = sunday;

            }
            weeks.add(weekArr);
        }
        Integer[] firstWeek = weeks.get(0);
        int firstDayOfWeek = firstWeek[0] + lastMonthDayCount;
        if (firstDayOfWeek <= lastMonthDayCount) {
            int index = 0;
            for (int i = firstDayOfWeek; i <= lastMonthDayCount; i++) {
                weeks.get(0)[index] = i;
                index++;
            }
        }
        Integer[] lastWeek = weeks.get(weeks.size() - 1);
        int lastDayOfWeek = lastWeek[6];
        if (lastDayOfWeek > currentMonthDayCount) {
            int outOfMonthCount = lastDayOfWeek - currentMonthDayCount;
            int index = 1;
            for (int i = outOfMonthCount; i >= 1; i--) {
                weeks.get(weeks.size() - 1)[7 - index] = i;
                index++;
            }
        }
        return weeks;
    }

    /**
     * @param m 0 本周   正的 后    负的 前
     * @return java.lang.String   开始和结束日期
     * @auther Liu Yaoguang
     * @Description
     */
    public static String getweek(int m) {
        int n = -m;
        String beginDate = getFromToDate(n + 1, -1);
        String endDate = getFromToDate(n, 0);
        return beginDate + "," + endDate;
    }

    /**
     * 获取起止日期
     *
     * @param n 最近n周
     * @return
     */
    private static String getFromToDate(int n, int i) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) + i;
        int offset = 1 - dayOfWeek;
//                0 == 0 ? 1 - dayOfWeek : 7 - dayOfWeek;
        int amount = offset - (n - 1 + 0) * 7;
//                0 == 0 ? offset - (n - 1 + 0) * 7 : offset - 0 * 7;
        calendar.add(Calendar.DATE, amount);
        return sdf.format(calendar.getTime());
    }


    /**
     * @return java.lang.String   开始和结束日期
     * @auther Liu Yaoguang
     * @Description
     */
    public static String getweek(Date data) {
        String beginDate = getFromToDate(data, 1, -1);
        String endDate = getFromToDate(data, 0, 0);
        return beginDate + "," + endDate;
    }

    /**
     * 获取起止日期
     *
     * @param n 最近n周
     * @return
     */
    private static String getFromToDate(Date date, int n, int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) + i;
        int offset = 0 == 0 ? 1 - dayOfWeek : 7 - dayOfWeek;
        int amount = offset - (n - 1 + 0) * 7;
//                0 == 0 ? offset - (n - 1 + 0) * 7 : offset - 0 * 7;
        calendar.add(Calendar.DATE, amount);
        return sdf.format(calendar.getTime());
    }
}
