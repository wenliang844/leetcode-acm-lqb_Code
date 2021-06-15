package 蓝桥杯.lan真题训练.lan2020省赛javaB组;

import java.util.Arrays;

public class D数的分解 {
    /*
    把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包
含数字 2 和 4，一共有多少种不同的分解方法？
注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和
1001+1000+18 被视为同一种

0不可以
所以0不是正整数
     */

    public static void main(String[] args) {

        int count = 0;
        //2019
        for (int i = 1; i <= 2019; i++) {
            for (int j = i; j <= 2019-i; j++) {
                //for (int k = j; k <= 2019; k++) {
                    int a[] = new int[3];
                    a[0] = i;
                    a[1] = j;
                    a[2] = 2019-i-j;
                    //i + j + a[2] == 2019 &&
                    if (!Arrays.toString(a).contains("2") && !Arrays.toString(a).contains("4")) {
                        count++;
                        System.out.println(i + "-" + j + "-" + a[2] + "---" + a[0] + Arrays.toString(a));
                    }
                //}
            }
        }

        System.out.println(count);
        plus();
    }

    public static void plus() {
        System.out.println(5 +
                5 +
                10 +
                10 +
                15 +
                15 +
                20 +
                20 +
                25 +
                25);
    }
}
