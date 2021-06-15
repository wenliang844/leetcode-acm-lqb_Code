package 蓝桥杯.蓝桥杯大赛历届真题.第九届;

import java.util.Calendar;

public class 填空1第几天 {
    /***
     2000 1 1第一天
     2000 5 4第几天

     方法一:数日历
     方法二:calandar
     * @param args
     */
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000,1,1);
        int count = 1;
        while (true){
            if (calendar.get(Calendar.MONTH)==5 && calendar.get(Calendar.DAY_OF_MONTH)==4){
                break;
            }

            calendar.add(Calendar.DAY_OF_MONTH,1);
            count++;
        }
        System.out.println(count);
    }
}
