package 蓝桥杯.lan真题训练.第十届2020决赛;

import java.util.Map;
import java.util.Scanner;

public class J分考场 {

    /***
     5
     5 3 4 2 1
     5
     2 1 4 3
     1 4 8
     2 3 5 3
     1 2 2
     2 1 3 2
     * @param args
     */
    public static void main(String[] args) {
        double d = 3.1415926;
        double e = 3.465;
        System.out.println(String.format("%.3f", d));
        System.out.println(String.format("%.2f", e));

        //业务逻辑
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int score[] = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            //每一次的操作
            int oprete = sc.nextInt();
            switch (oprete) {
                case 1:
                    //修改
                    score[sc.nextInt()] = sc.nextInt();
                case 2:
                    //查询平均值
                    int left = sc.nextInt();
                    int right = sc.nextInt();
                    int k = sc.nextInt();//k组
                    K = k;
                    maxAvg = 0;
                    findAvg(score, left - 1, right, k);
                    System.out.println(String.format("%.3f", maxAvg));
            }
        }
    }

    static double maxAvg = 0;
    static int K = 0;

    private static void findAvg(int[] score, int left, int right, int k) {
        //从ieft-1 到right-1的分数

        //dfs分考场,先第一个考场分一个,2 3
        //第二考场也1  2 3
        //sum 平均值的和
        for (int i = left; i < right; i++) {
            for (int j = i; j < right; j++) {
                //从一个开始分
                double sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += score[l];
                }
                sum = sum * 1.0 / (j - i + 1);//平均分的和
                dfs(score, j + 1, right, k - 1, sum);
            }
        }

    }

    //第二层
    private static void dfs(int[] score, int left, int right, int k, double sum) {

        if (left >= right) {
            return;
        }

        if (k == 1) {//由最后一组拿下最后的部分
            double avg = 0;
            for (int i = left; i < right; i++) {
                avg += score[i];
            }
            avg = avg / (right - left);
            sum += avg;
            maxAvg = Math.max(maxAvg, sum / K);
            return;
        }

        //没到1
        for (int i = left; i < right; i++) {
            for (int j = i; j < right; j++) {
                //从一个开始分
                double avg = 0;
                for (int l = i; l <= j; l++) {
                    avg += score[l];
                }
                //sum += ;//平均分的和
                dfs(score, j + 1, right, k - 1, sum+(avg / (j - i + 1)));
            }
        }
    }
}
