package 蓝桥杯.练习系统.算法提高;

import java.util.Scanner;

public class q1求1加到x的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
