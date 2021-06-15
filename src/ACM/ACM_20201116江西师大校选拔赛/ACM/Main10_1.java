package ACM.ACM_20201116江西师大校选拔赛.ACM;


/**
 * 链接：https://ac.nowcoder.com/acm/contest/5697/J
 * 来源：牛客网
 *
 * 题目描述
 * 小熊哆啦有一个神奇盒子，里面有两种零食，一个糖果和一个饼干（初始数量均为1）。小熊每次随机拿出盒子中的一个吃掉，而贴心的熊妈妈就会放回两个同种的零食（即原有数量+1）。
 * 小熊哆啦比较喜欢吃糖果，想知道n次零食取出吃掉后，盒子中糖果数目的期望
 * 输入描述:
 * 输入一个整数n，表示取出次数 0≤n≤10000000
 * 输出描述:
 * 输出一个实数，表示n次取后糖果数目的期望。答案保留7位小数。
 * 示例1
 * 输入
 * 复制
 * 2
 * 输出
 * 复制
 * 2.0000000
 * 示例2
 * 输入
 * 复制
 * 3
 * 输出
 * 复制
 * 2.5000000
 * 示例3
 * 输入
 * 复制
 * 1
 * 输出
 * 复制
 * 1.5000000
 */

import java.util.Scanner;

public class Main10_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int getCount = sc.nextInt();
        double startCount = 1;
        for (int i = 1; i <= getCount; i++) {
            startCount += 0.5;
        }



        System.out.println(String.format("%.7f", startCount));   //结果保留七位小数

    }
}
