package ACM.每日一题leecode.第二波.leetcode.day61;

public class day61_2651计算列车到站时间 {
    public static void main(String[] args) {
        System.out.println(findDelayedArrivalTime(15, 5)); //20
        //
    }

    //eazy
    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        if (arrivalTime+delayedTime<24){
            return arrivalTime+delayedTime;
        }else {
            return arrivalTime+delayedTime-24;
        }
    }
}
