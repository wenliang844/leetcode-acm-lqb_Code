package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q27动态数组使用 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum+=scanner.nextInt();
        }

        System.out.println(sum+" "+sum/len);

    }
}
