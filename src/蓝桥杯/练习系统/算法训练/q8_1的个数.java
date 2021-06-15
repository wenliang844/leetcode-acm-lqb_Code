package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q8_1的个数 {
    public static void main(String[] args) {//15-8
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            //进行统计
            int temp = i;
            while (temp!=0){
                if (temp%10==1){
                    count++;
                }
                temp/=10;
            }
        }

        System.out.println(count);
    }
}
