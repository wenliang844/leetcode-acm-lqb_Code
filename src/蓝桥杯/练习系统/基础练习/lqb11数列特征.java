package 蓝桥杯.练习系统.基础练习;

import java.util.Map;
import java.util.Scanner;

/**
 5
 1 3 -2 4 5
 */
public class lqb11数列特征 {

    public static void main(String[] args) {
        //max min sum
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int nums[] =new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);

    }
}
