package ACM2021;

/*
行末要求不带空格（或带空格）
输出要求分行（或不分行）
有空格没空格要看仔细
输出中的标点符号要看清楚，尤其是绝对不能用中文全角的标点符号，另外单引号“'”和一撇“`”要分清楚
当输出浮点数时，通常题目中会做适当处理，要求比较明确的输出格式，一定要严格遵守，因为浮点数会涉及到输出的精度问题
当输出浮点数时，如果可能输出0，而数据可能为负时，有可能出现输出-0.0的情况，需要自己写代码判断，保证不出现-0.0
 */

import java.util.Arrays;
import java.util.Scanner;

//漏洞 屋顶
public class JLeakingRoof {
    public static void main(String[] args) {
//        double d = 1000000000;
//        System.out.printf("%.6f ",500*10000.0);
//        double d = 0;
        //System.out.printf("%.6d ",d);
        //System.out.printf("%.6f ",d);
//        System.out.println(String.format());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //roof屋顶数组
        int[][] array = new int[n][n];
        double[] as = new double[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
                as[i * n + j] = array[i][j] * 100000 + i * n + j;
            }
        }
        //sort
        Arrays.sort(as);


//        for (double a : as) {
//            System.out.print(a + " ");
//        }
//        System.out.println();

        //初始化容器 默认都是0 只有当array是0 才漏水
        double[][] target = new double[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(target[i], m);
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(array, target, i, j, m, n);
            }
        } */
        for (int i = n * n - 1; i >= 0; i--) {
            double a = as[i];
            int i1 = (int) (a % 100000);
            //dfs(array, target, i1/n, i1%n, target[i1/n][i1%n], n);
            if (array[i1 / n][i1 % n] != 0) {
                dfs(array, target, i1 / n, i1 % n, target[i1 / n][i1 % n], n);
            }

//            System.out.println("-------"+i+"--"+i1);
//            for (int j = 0; j < n; j++) {
//                System.out.println(Arrays.toString(target[j]));
//            }
        }

        //System.out.println("---target[][]");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (target[i][j] == 0) {
                    System.out.print(0 + " ");
                } else {
                    System.out.printf("%.6f ", target[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] array, double[][] target, int i, int j, double m, int n) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            int d = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            if (i - 1 >= 0 && array[i - 1][j] < array[i][j]) {
                a = array[i - 1][j];
                min = Math.min(min, a);
            }
            if (j - 1 >= 0 && array[i][j - 1] < array[i][j]) {
                b = array[i][j - 1];
                min = Math.min(min, b);
            }
            if (i + 1 < n && array[i + 1][j] < array[i][j]) {
                c = array[i + 1][j];
                min = Math.min(min, c);
            }
            if (j + 1 < n && array[i][j + 1] < array[i][j]) {
                d = array[i][j + 1];
                min = Math.min(min, d);
            }
            if (min != Integer.MAX_VALUE) {
                int count = 0;
                if (a == min) count++;
                if (b == min) count++;
                if (c == min) count++;
                if (d == min) count++;

                if (a == min) target[i - 1][j] += m / count;
                if (b == min) target[i][j - 1] += m / count;
                if (c == min) target[i + 1][j] += m / count;
                if (d == min) target[i][j + 1] += m / count;

            }
            target[i][j] = 0;
    }

    private static void dfs2(int[][] array, double[][] target, int i, int j, double m, int n) {
        if (array[i][j] == 0) {
            target[i][j] += m;
            return;
        } else {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;
            int d = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            if (i - 1 >= 0 && array[i - 1][j] < array[i][j]) {
                a = array[i - 1][j];
                min = Math.min(min, a);
            }
            if (j - 1 >= 0 && array[i][j - 1] < array[i][j]) {
                b = array[i][j - 1];
                min = Math.min(min, b);
            }
            if (i + 1 < n && array[i + 1][j] < array[i][j]) {
                c = array[i + 1][j];
                min = Math.min(min, c);
            }
            if (j + 1 < n && array[i][j + 1] < array[i][j]) {
                d = array[i][j + 1];
                min = Math.min(min, d);
            }
            if (min == Integer.MAX_VALUE) {
                return;
            } else {
                int count = 0;
                if (a == min) count++;
                if (b == min) count++;
                if (c == min) count++;
                if (d == min) count++;

                if (a == min) dfs(array, target, i - 1, j, m / count, n);
                if (b == min) dfs(array, target, i, j - 1, m / count, n);
                if (c == min) dfs(array, target, i + 1, j, m / count, n);
                if (d == min) dfs(array, target, i, j + 1, m / count, n);
            }

        }
    }
}
