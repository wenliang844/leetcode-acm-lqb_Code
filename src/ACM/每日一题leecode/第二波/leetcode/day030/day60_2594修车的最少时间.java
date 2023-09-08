package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.Arrays;

public class day60_2594修车的最少时间 {
    public static void main(String[] args) {

        System.out.println(repairCars(new int[]{4, 2, 3, 1}, 10));
        //2147169027
        System.out.println(repairCars(new int[]{31,31,5,19,19,10,31,18,19,3,16,20,4,16,2,25,10,16,23,18,21,23,28,6,7,29,11,11,19,20,24,19,26,12,29,29,1,14,17,26,24,7,11,28,22,14,31,12,3,19,16,26,11}, 736185));
    }

    //暴力解法
    public static long repairCars(int[] ranks, int cars) {

        int length = ranks.length;
        //int[][] rankss = new int[length][cars];
        int[] index = new int[length];
        //int[] values = Arrays.copyOf(ranks,length);
        //int[] values = new int[length];

        System.out.println(Arrays.toString(ranks));
        //System.out.println(Arrays.toString(values));

        while (cars --> 0){
            //去values最小值作为当前车辆的修理工
            long min = Integer.MAX_VALUE;
            int minIndex = -1;
            int i = 0;
            for (; i < length; i++) {
                if (ranks[i]*(index[i]+1)*(index[i]+1)<min){
                    min = ranks[i]*(index[i]+1)*(index[i]+1);
                    minIndex = i;
                }
            }

            //最小值的index向前推进1
            index[minIndex]++;
        }

        //index[i]的最小值就是最小时间
        System.out.println(Arrays.toString(index));

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            max = Math.max(max,ranks[i]*(index[i])*(index[i]));
        }

        return max;
    }
}
