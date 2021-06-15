package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q12递归求二项式系数值 {
    //方法一:递归法
    public static void main2(String[] args) {
        /***
         k=0 k=n  ->1
         k,n = n-1,k + n-1,k-1
         */
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(dfs(k, n));
    }

    private static int dfs(int k, int n) {
        if (k == 0 || k == n) {
            return 1;
        }
        return dfs(k, n - 1) + dfs(k - 1, n - 1);

    }

    public static void main(String[] args) {
        /***
         k=0 k=n  ->1
         k,n = n-1,k + n-1,k-1
         */
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        int numk = k, numn = n;
        for (int i = 1; i < k; i++) {
            numn *= --n;
        }
        for (int i = 1; i < k; i++) {
            numk *= --k;
        }
//        System.out.println(numn+"---"+numk);
        System.out.println(numn/numk);
    }
}
