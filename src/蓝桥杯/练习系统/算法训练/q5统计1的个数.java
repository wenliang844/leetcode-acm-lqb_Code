package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q5统计1的个数 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int sum = 0;
        for (int i = left; i <= right; i++) {
            int count = Integer.bitCount(i);
            sum+=count;
        }

        System.out.println(sum);
    }

}
