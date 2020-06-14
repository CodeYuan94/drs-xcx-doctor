package com.df.drs.base.utils;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

public class ComFunc {

    //查询日期格式正则
    public final static  String QUERY_DATE_REG = "^\\d{4}-((1[0-2])|(0[1-9]))-(([1-3]\\d)|(0[1-9]))$";

    public static String ip = "";
    static{
        ip =  getLocalIp();
    }

    /**
     * 获取本机ip
     * @return
     */
    public static String getLocalIp(){
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String localip=ia.getHostAddress();
        return localip;
    }

    /**
     *
     * Description 获取字符串MD5值
     *
     * @param sourceStr
     *
     */
    public static String MD5(String sourceStr) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(sourceStr.getBytes());

        byte b[] = md.digest();

        int i;

        StringBuffer buf = new StringBuffer("");

        for (int offset = 0; offset < b.length; offset++) {

            i = b[offset];

            if (i < 0)

                i += 256;

            if (i < 16)

                buf.append("0");

            buf.append(Integer.toHexString(i));

        }

        String result = buf.toString();

        return result;

    }

    /**
     *
     * Description 获取字符串MD5值
     *
     * @param srcBytes
     *
     */
    public static String MD5(byte[] srcBytes) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(srcBytes);

        byte b[] = md.digest();

        int i;

        StringBuffer buf = new StringBuffer("");

        for (int offset = 0; offset < b.length; offset++) {

            i = b[offset];

            if (i < 0)

                i += 256;

            if (i < 16)

                buf.append("0");

            buf.append(Integer.toHexString(i));

        }

        String result = buf.toString();

        return result;

    }

    /***
     * SHA加密 生成40位SHA码
     * @param 待加密字符串
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**	 * byte数组转int类型的对象
     *
     * @param bytes
     * @return	 */
    public static int byte2Int(byte[] bytes) {

        return (bytes[0] & 0xff) << 24 |
               (bytes[1] & 0xff) << 16 |
               (bytes[2] & 0xff) << 8 |
               (bytes[3] & 0xff);
    }

    /**	 * int转byte数组
     * @param num
     *  @return
     */
    public static byte[] intToByte(int num) {

        byte[] bytes = new byte[4];
        bytes[0] = (byte)((num >> 24) & 0xff);
        bytes[1] = (byte)((num >> 16) & 0xff);
        bytes[2] = (byte)((num >> 8) & 0xff);
        bytes[3] = (byte)(num & 0xff);

        return bytes;
    }

    /**
     * locadate相差几天
     */
    public static String getGapDay(String startDate,String endDate) {
        if ("".equals(startDate) || startDate == null) {
            return "";
        }
        if ("".equals(endDate) || endDate == null) {
            return "";
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time1 = cal.getTimeInMillis();
        try {
            cal.setTime(sdf.parse(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return String.valueOf(between_days);
    }


    /**
     * 判断文件夹是否存在
     */
    public static boolean isDirExists(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            } else {
                System.out.println("the same name file exists, can not create dir");
                return false;
            }
        } else {
            System.out.println("dir not exists, create it ...");
            file.mkdir();
            System.out.println("create success!");
            return false;
        }

    }

    /**
     * 处理查询时间
     * @param startDate
     * @param endDate
     * @param attr 属性字段
     * @return
     */
    public static String dealQueryDateToStr(String startDate, String endDate, String attr){
        if(StringUtils.isBlank(attr)){
            return null;
        }

        //1 大于起始时间 ,2 小于结束时间 ， 3 某日期内 ， 其他不生成
        int type =0;
        if(!StringUtils.isBlank(startDate) && Pattern.matches(QUERY_DATE_REG,startDate)){
            type=1;
        }

        if(!StringUtils.isBlank(endDate) &&  Pattern.matches(QUERY_DATE_REG,startDate)){
            type = type == 1 ? 3 : 2;
            endDate = endDate.trim() + " 23:59:59";
        }

        StringBuilder sb = new StringBuilder();
        switch (type){
            case 1:
                //大于等于起始时间
                sb.append(attr);
                sb.append(" >= ");
                sb.append(startDate);
                break;
            case 2:
                //小于等于结束时间
                sb.append(attr);
                sb.append(" <= ");
                sb.append(endDate);
                break;
            case 3:
                //在某区间内
                sb.append(attr);
                sb.append(" BETWEEN ");
                sb.append(startDate);
                sb.append(" AND ");
                sb.append(endDate);
                break;
            default:
                break;
        }
        return sb.toString();
    }

    /**
     * 生成唯一编号
     * @param no
     * @return
     */
    public static String generateNo(String no){
        return no+ "_" +  UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成随机数
     * @param length 随机数长度
     * @return
     */
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

}
