package 蓝桥杯.lan真题训练.lan2020省赛javaB组;

import java.security.Key;
import java.util.Arrays;
import java.util.Collections;

/*
【问题描述】
给定 N 个加号、 M 个减号以及 N + M + 1 个整数 A1; A2; · · · ; AN+M+1，小
明想知道在所有由这 N 个加号、 M 个减号以及 N + M + 1 个整数凑出的合法的
后缀表达式中，结果最大的是哪一个？
请你输出这个最大的结果。
例如使用1 2 3 + -，则 “2 3 + 1 -” 这个后缀表达式结果是 4，是最大的。
【输入格式】
第一行包含两个整数 N 和 M。
第二行包含 N + M + 1 个整数 A1; A2; · · · ; AN+M+1。
【输出格式】
输出一个整数，代表答案。
【样例输入】
1 1
1 2 3
【样例输出】
4
【评测用例规模与约定】
对于所有评测用例， 0 ≤ N; M ≤ 100000， −109 ≤ Ai ≤ 109。
 */
public class I后缀表达式 {
    static void printNums(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println(getNums(1, 1, new Integer[]{1, 2, 3}));
        System.out.println(getNums(2, 1, new Integer[]{1, 2, 3,4}));
    }

    static int getNums(int N, int M, Integer[] nums) {
        /*
        给出N个加号
        M个减号
        思路:排序后: 前N+1个数  减去后M个数
         */
        printNums(nums);
        Arrays.sort(nums, Collections.reverseOrder());
        printNums(nums);

        int sum = 0;
        for (int i = 0; i < N + 1; i++) {
            sum+=nums[i];
        }
        int sub = 0;
        for (int i = N+1; i < N+M+1; i++) {
            sub+=nums[i];
        }



        return sum-sub;
    }
}
