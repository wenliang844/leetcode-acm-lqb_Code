package ACM.leecode周赛.第246场周赛;

public class lee5789你完成的完整对局数 {
    public static void main(String[] args) {
        System.out.println(numberOfRounds("12:01", "12:44"));//1
        System.out.println(numberOfRounds("20:00", "06:00"));//40
        System.out.println(numberOfRounds("00:00", "23:59"));//95
        System.out.println(numberOfRounds("01:45", "15:19"));//54
        System.out.println(numberOfRounds("15:19", "01:45"));//41
    }

    //方法一:直接判断法
    public static int numberOfRounds(String startTime, String finishTime) {
        String[] start = startTime.split(":");
        String[] finish = finishTime.split(":");
        int hour1 = Integer.parseInt(start[0]);
        int mimute1 = Integer.parseInt(start[1]);
        int hour2 = Integer.parseInt(finish[0]);
        int mimute2 = Integer.parseInt(finish[1]);
        if (hour1>hour2 || (hour1==hour2 && mimute1>mimute2)){
            return getTime(hour1,mimute1,24,0) + getTime(0,0,hour2,mimute2);
        }
        return getTime(hour1,mimute1,hour2,mimute2);
    }

    public static int getTime(int hour1, int mimute1, int hour2, int mimute2) {
        int sub = hour2 - hour1;
        if (sub == 0) {
            return getcount(mimute1, mimute2);
        } else {
            return (sub - 1) * 4 + getcount(mimute1, 60) + getcount(0, mimute2);
        }
    }

    private static int getcount(int mimute1, int mimute2) {
        int res = getNum2(mimute2) - getNum1(mimute1);
        return res > 1 ? res - 1 : 0;
        /*int count = 0;
        if (mimute1<=0 && mimute2>=0){
            count++;
        }else if (mimute1<=15 && mimute2>=15){
            count++;
        }else if (mimute1<=30 && mimute2>=30){
            count++;
        }else if (mimute1<=45 && mimute2>=45){
            count++;
        }else if (mimute1<=60 && mimute2>=60){
            count++;
        }
        return count<1?0:count-1;*/
    }

    //两者兼顾 兼得
    private static int getNum1(int mimute) {
        if (mimute == 0) {
            return 0;
        } else if (mimute <= 15) {
            return 1;
        } else if (mimute <= 30) {
            return 2;
        } else if (mimute <= 45) {//0-45   45-60局面
            return 3;
        } else if (mimute <= 60) {
            return 4;
        }
        return 5;
    }private static int getNum2(int mimute) {//45属于大数
        if (mimute == 0) {
            return 0;
        } else if (mimute < 15) {
            return 1;
        } else if (mimute < 30) {
            return 2;
        } else if (mimute < 45) {//0-45   45-60局面
            return 3;
        } else if (mimute < 60) {
            return 4;
        }
        return 5;
    }
}
