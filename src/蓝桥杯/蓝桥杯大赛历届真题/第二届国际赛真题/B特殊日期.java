package 蓝桥杯.蓝桥杯大赛历届真题.第二届国际赛真题;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class B特殊日期 {
    /****
     给定起始结束日期,计算这个日期中有多少特殊的日期(连续三个数以上的日期)
     */
    public static void main(String[] args) throws ParseException {
        /***枚举
         方法一:利用calendar类
         方法二:自己构造day递增函数
         fun->获取指定日期的后一天
         fun->判断指定日期是否是连续3位相同
         */
        /*Date date = new Date();
        System.out.println(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018,11,01);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date time = calendar.getTime();
        String s = sdf.format(time);
        System.out.println(time);
        System.out.println(s);

        int date1 = calendar.DATE;
        System.out.println(date1);

        // 使用默认时区和语言环境获得一个日历
        Calendar cal = Calendar.getInstance();
        // 赋值时年月日时分秒常用的6个值，注意月份下标从0开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));

        //set方法:直接set(年,月,日)

        //add方法:直接cal.add(Calendar.Day,+1)

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2018,11,1);
        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
        calendar1.add(Calendar.DATE,1);
        System.out.println(calendar1.get(Calendar.YEAR));
        System.out.println(calendar1.get(Calendar.MINUTE)+1);
        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));*/

        /***
         20181101
         20181130
         20181203
         */
       Scanner scanner = new Scanner(System.in);
        String startDate = scanner.next();
       /*  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(startDate.substring(0,4)+"-"+startDate.substring(4,6)+"-"+startDate.substring(6,8));
        System.out.println(sdf.format(parse));
        System.out.println(parse);*/
        Calendar calendar = Calendar.getInstance();
        int year = Integer.parseInt(startDate.substring(0,4));
        int mouth = Integer.parseInt(startDate.substring(4,6));
        int day = Integer.parseInt(startDate.substring(6,8));
        calendar.set(year,mouth-1,day);
//        calendar.setTime(parse);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        String endDate = scanner.next();
        int count = 0;
        if (judgement(startDate))count++;
        if (judgement(endDate))count++;
        while (!startDate.equals(endDate)){//startTime不等于endTime的时候就要比较
            calendar.add(Calendar.DAY_OF_MONTH,1);//加一天
            int mouth1 = calendar.get(Calendar.MONTH);
            String mouth2="";
            if(mouth1<10){
                mouth2+="0";
            }
            mouth2+=calendar.get(Calendar.MONTH)+1;
            int day1 = calendar.get(Calendar.DAY_OF_MONTH);
            String day2 = "";
            if (day1<10){
                day2+="0";
            }
            day2+=calendar.get(Calendar.DAY_OF_MONTH);
            startDate=calendar.get(Calendar.YEAR)+mouth2+day2;
            if (judgement(startDate))count++;
            System.out.println(startDate);
        }

        System.out.println(count);
    }

    public static String getNextDay(String date){
        int year = Integer.parseInt(date.substring(0,4));
        int mouth = Integer.parseInt(date.substring(4,6));
        int day = Integer.parseInt(date.substring(6,8));

        return null;
    }
    //判断一个数是否连续3个
    public static boolean judgement(String s){
        for (int i = 0; i < s.length()-2; i++) {
            if (s.charAt(i)==s.charAt(i+1)&&s.charAt(i)==s.charAt(i+2)){
                return true;
            }
        }

        return false;
    }
}
