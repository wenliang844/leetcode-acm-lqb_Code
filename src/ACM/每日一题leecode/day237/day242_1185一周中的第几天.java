package ACM.每日一题leecode.day237;

import java.util.Calendar;

public class day242_1185一周中的第几天 {
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek(18, 7, 1999));
        System.out.println(dayOfTheWeek(15, 8, 1993));
    }

    //11|12  注意:时间的表示:月份的表示month是 0-11 和现实有点差距
    public static String dayOfTheWeek(int day, int month, int year) {

        System.out.println("-----------------------start time------------");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)+"--"+calendar.toString()+"\n"+calendar.getTime());
        return getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
    }

    public static String getDayOfWeek(int day){
        switch(day) {
         case 1: return "Sunday";
         case 2: return "Monday";
         case 3: return "Tuesday";
         case 4: return "Wednesday";
         case 5: return "Thursday";
         case 6: return "Friday";
         case 7: return "Saturday";
         default: return "there are nothing!!!";
        }
    }
}
