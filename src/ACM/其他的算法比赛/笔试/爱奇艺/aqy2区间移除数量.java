package ACM.其他的算法比赛.笔试.爱奇艺;

import java.util.Arrays;
import java.util.Scanner;

public class aqy2区间移除数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length()<9){
            System.out.println(0);
            return;
        }
        //System.out.println(s);
        s = s.substring(3,s.length()-3);
        //System.out.println(s);
        String[] split = s.split("], \\[");
        //System.out.println(Arrays.toString(split));
        int[][] intervals = new int[split.length][2];
        for (int i = 0; i < split.length; i++) {
            intervals[i][0] = Integer.parseInt(String.valueOf(split[i].charAt(0)));
            intervals[i][1] = Integer.parseInt(String.valueOf(split[i].charAt(2)));
        }
        //for (int i = 0; i < intervals.length; i++) {
        //    System.out.println(Arrays.toString(intervals[i]));
        //}


        sortByJ_shengxu(intervals);

        int count = 1;
        int i = 0;
        int j = 1;
        while (j < intervals.length) {
            if (intervals[j][0] >= intervals[i][1]) {
                count++;
                i = j;
                j++;
            } else {
                //i = j;
                j++;
                //break;
            }
        }
        System.out.println(intervals.length-count);
    }

    public static void sortByJ_shengxu(int[][] intervals) {

        for (int i = 1; i < intervals.length; i++) {
            int temp = intervals[i][1];//临时变量 保存num[i]的值
            int temp2 = intervals[i][0];//保存1这边的值

            int j = i;//从已经排序的序列最右边开始比较 找到小的值
            //将这个数后移
            while (j > 0 && temp < intervals[j - 1][1]) {
                intervals[j][1] = intervals[j - 1][1];
                intervals[j][0] = intervals[j - 1][0];
                j--;
            }

            //存在更小的值 插入
            //如果不存在 就不插入
            if (j != i) {//加不加判断都一样  若是没找到,j就不会一定
                intervals[j][1] = temp;
                intervals[j][0] = temp2;
            }

            //System.out.println("第"+i+"轮插入后=");
            //printNums(nums);
        }
    }
}
