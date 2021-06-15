package ACM.其他的算法比赛.笔试.腾讯.code4充电问题;


import java.util.Scanner;

public class Main {
    /***
     手机充电问题:共享充电:
     充电每秒5
     手机剩余电量和耗电
     3 4
     2 5
     1 6
     0.5  3冲0.4秒 2冲0.1秒 维持0.5秒

     设充电时间为x y z
     有5x +5y +5z=5
     1+x/6 = T T就是步长
     * @param args
     */

    public static void main(String[] args) {
        //System.out.println((int)'0');
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[][] phone = new int[n][2];
            for (int i = 0; i < n; i++) {
                phone[i][0] = sc.nextInt();//剩余点
                phone[i][1] = sc.nextInt();//耗电速度
            }

            for (int x = 0; x < phone.length; x++) {

            }

        }
    }
}
