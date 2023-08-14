package Codejava.java面试题.美登科技笔试;

import java.util.Arrays;

public class T2输入日期输出到期日 {
    public static void main(String[] args) {

        //test data
        System.out.println(Arrays.toString(getExpirationDate(2018, 11, 10)));//2018-12-10
        System.out.println(Arrays.toString(getExpirationDate(2018, 12, 10)));//2019-01-10
        System.out.println(Arrays.toString(getExpirationDate(2019, 1, 30)));//2019-02-28

        System.out.println(Arrays.toString(getExpirationDate(2000, 1, 31)));//2000-02-29
        System.out.println(Arrays.toString(getExpirationDate(2016, 1, 30)));//2016-02-29
        System.out.println(Arrays.toString(getExpirationDate(2016, 7, 31)));//2018-08-31
        System.out.println(Arrays.toString(getExpirationDate(2016, 8, 31)));//2019-09-30
    }


    /**
     * 获取月订单到期日
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static int[] getExpirationDate(int year, int month, int day) {

        //处理year,month
        if (month == 12) {
            year++;
            month = 1;
        } else {
            month++;
        }

        //处理day 取下个月的同一个日期,如果没有这个日期,取该月最后一天
        day = Math.min(getMonthDay(year, month), day);

        return new int[]{year, month, day};
    }

    /**
     * 获取每个月有多少天
     * @param y
     * @param m
     * @return
     */
    public static int getMonthDay(int y, int m) {
        //1,3,5,7,8,10,12 = 31天
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            return 31;
            //4，6，9，11 = 31天
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        } else if (m == 2) {
            //根据年判断2月天数
            if ((y % 100 != 0 && y % 4 == 0) || y % 400 == 0) {
                return 29;
            } else {
                return 28;
            }
        } else {
            throw new RuntimeException("月份数据不合法");
        }
    }

}
