package 蓝桥杯.十二届国赛;

import java.util.Arrays;
import java.util.Scanner;

public class F123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pre[] = new int[10000];
        for (int i = 1; i < 10000; i++) {
            pre[i] = pre[i-1]+i;
        }
        System.out.println(Arrays.toString(pre));

        int sum = 0;

    }
}
