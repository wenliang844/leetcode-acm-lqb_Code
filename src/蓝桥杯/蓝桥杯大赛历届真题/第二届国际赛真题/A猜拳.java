package 蓝桥杯.蓝桥杯大赛历届真题.第二届国际赛真题;

import java.util.Scanner;

public class A猜拳 {
    /****
     n局石头剪刀布的赢钱情况
     */
    public static void main(String[] args) {
        /***
         分为3中情况:one赢两块 two 或three赢
         0石头 1剪刀 2布
         one赢 one出石头 其他人出剪刀
         one出剪刀,其他人出布
         one出布,其他人出石头
         0 11
         1 22
         2 00
         two赢 101
         212
         020
         three赢
         11 0
         22 1
         00 2

         one输两块的情况:
         1 00
         2 11
         0 22
         大同小异

         3
         0 2 2
         0 1 2
         1 1 1

         return -2 1 1
         */
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int one = 0;
        int two = 0;
        int three = 0;
        while (m-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            if ((i == 0 && j == 1 && k == 1) || (i == 1 && j == 2 && k == 2) || (i == 2 && j == 0 && k == 0)) {//one赢两块的情况
                one += 2;
                two -= 1;
                three -= 1;
            } else if ((i == 1 && j == 0 && k == 0) || (i == 2 && j == 1 && k == 1) || (i == 0 && j == 2 && k == 2)) {//one输两块的情况
                one -= 2;
                two += 1;
                three += 1;
            } else if ((i == 1 && j == 0 && k == 1) || (i == 2 && j == 1 && k == 2) || (i == 0 && j == 2 && k == 0)) {//two赢两块的情况
                two += 2;
                one -= 1;
                three -= 1;
            } else if ((i == 0 && j == 1 && k == 0) || (i == 1 && j == 2 && k == 1) || (i == 2 && j == 0 && k == 2)) {//two输两块的情况
                two -= 2;
                one += 1;
                three += 1;
            } else if ((i == 1 && j == 1 && k == 0) || (i == 2 && j == 2 && k == 1) || (i == 0 && j == 0 && k == 2)) {//three赢两块的情况
                three += 2;
                two -= 1;
                one -= 1;
            } else if ((i == 0 && j == 0 && k == 1) || (i == 1 && j == 1 && k == 2) || (i == 2 && j == 2 && k == 0)) {//three输两块的情况
                three -= 2;
                two += 1;
                one += 1;
            }
        }
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
    }
}
