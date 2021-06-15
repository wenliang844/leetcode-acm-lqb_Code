package 蓝桥杯.第一次小选拔;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
在X星系的广袤空间中漂浮着许多X星人造“炸弹”，用来作为宇宙中的路标。

 每个炸弹都可以设定多少天之后爆炸。

 比如：阿尔法炸弹2015年1月1日放置，定时为15天，则它在2015年1月16日爆炸。

 有一个贝塔炸弹，2020年11月27日放置，定时为10000天，请你计算它爆炸的准确日期。



 请填写该日期，格式为 yyyy-MM-dd  即4位年份2位月份2位日期。比如：2020-02-09

 请严格按照格式书写。不能出现其它文字或符号。
 */
public class lanqiao_3_星系炸弹 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String date1 = sdf.format(date);
        System.out.println(date1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,10);
        Date date2 = calendar.getTime();
        System.out.println(date2);
        System.out.println(sdf.format(date2));

        System.out.println("-------------");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2020,10,27);
        System.out.println(sdf.format(calendar1.getTime()));
        calendar1.add(Calendar.DATE,10000);
        System.out.println(sdf.format(calendar1.getTime()));

        System.out.println("-------------");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2019,10,27);
        System.out.println(sdf.format(calendar2.getTime()));
        calendar2.add(Calendar.DATE,366);
        System.out.println(sdf.format(calendar2.getTime()));
    }
}
