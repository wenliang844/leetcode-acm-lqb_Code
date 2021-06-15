package ACM.ACM_20201116江西师大校选拔赛.ACM;


/**
 * 链接：https://ac.nowcoder.com/acm/contest/5697/C
 * 来源：牛客网
 *
 * 题目描述
 * 曾经青竹大佬发现过两句神奇的咒语，如今他结合这两条咒语衍生出一条简单暴力的咒语。
 * 在任意一天中，每使用一次咒语可以获得一个香蕉（咒语不失效），咒语为（青竹tql）
 * 然而，青竹大佬因为滥用咒语导致受到了香蕉之神诅咒，诅咒是：在任意一天中青竹的第x次咒语失效，x满足的条件是x的因子个数为奇数(青竹将不会获得香蕉)。
 * 例如24，24的因子是1，2，3，4，6，8，12，24，因子个数是8所以第24次咒语不失效，1的因子个数是1所以第1次咒语失效
 * 请大家帮忙算下在接下来T(T<=10000)天中青竹大佬每次使用n（1<=n<=10^12）次咒语能获得几个香蕉？
 * 输入描述:
 * 第一行输入青竹发动咒语的天数T(T<=10000)，
 * 接下来T行输入一个整数Ni(1<=n<=1012)，代表第i天青竹发动咒语的次数。
 * 输出描述:
 * 每行对应输出一个整数，代表当天青竹能够获得的香蕉总数。
 * 示例1
 * 输入
 * 复制
 * 1
 * 6
 * 输出
 * 复制
 * 4
 * 说明
 * 在第一天，青竹发动六次咒语，其中：
 * 1(奇),2(偶),3(偶),4(奇),5(偶),6(偶)
 * 在1、4两次诅咒发动，故最终得到4个香蕉。
 */

import java.util.Scanner;

public class Main3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        long everydays[] = new long[days],sum[] = new long[days];
        for (int i = 0; i < days; i++) {
            everydays[i] = sc.nextLong();
        }

        for (int i = 0; i < days; i++) {
            System.out.println(everydays[i]-(int)Math.floor(Math.sqrt(everydays[i])));
        }
    }
}
