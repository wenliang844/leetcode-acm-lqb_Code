package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q31寻找数组中最大值 {

    //找数组的最大值返回最大值 和下标
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }

        //业务处理
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        System.out.println(max+" "+index);

    }
}
