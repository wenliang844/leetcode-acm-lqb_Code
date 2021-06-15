package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.javaB;

import java.util.Scanner;

public class code2垒骰子 {
    /***
     n个筛子的朝向就是4^n次方
     几个面就是1->五个面
     2->五个面
     3-6 -> 6个面

     如果3个筛子呢?
     */
    public static int getNum(int n,int m,int[][] forbid){
        //进行计算贴面的个数
        /***
         m代表有两个面不能接触,那么 第一个只能接触5个,第二个也只能接触5个
         */

        return 0;
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.method();//运行主方法
    }
}

class Main {
    static final double MOD = 10e9 - 7;
    static int[][] arr = new int[6][6];

    public static void method() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        /**
         * 初始化arr数组
         * */
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            arr[a - 1][b - 1] = 0;
            arr[b - 1][a - 1] = 0;
        }


        int[][] ans = pow(arr, n - 1);


        int sum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                sum += ans[i][j] % MOD;
            }
        }
        /**
         * 旋转情况  4^n
         * */
        sum *= Math.pow(4, n) % MOD;

        System.out.println((int) (sum % MOD));
    }

    private static int[][] pow(int[][] arr, int k) {
        /**
         * 初始化单位矩阵
         * */
        int[][] ans = new int[6][6];
        for (int i = 0; i < 6; i++) {
            ans[i][i] = 1;
        }
        /**
         * 矩阵快速幂核心算法
         * */
        while (k != 0) {
            if (k % 2 != 0) {
                ans = Multiply(arr, ans);
            } else {
                arr = Multiply(arr, arr);
            }
            k >>= 1;
        }

        return ans;
    }

    private static int[][] Multiply(int[][] m, int[][] n) {
//        标准计算矩阵乘法算法
        int rows = m.length;
        int cols = n[0].length;
        int[][] r = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < m[i].length; k++) {
                    r[i][j] += (m[i][k] * n[k][j]) % MOD;
                }
            }
        }
        return r;
    }
}