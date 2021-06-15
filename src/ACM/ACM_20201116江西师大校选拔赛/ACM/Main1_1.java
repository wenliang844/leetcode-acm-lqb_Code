package ACM.ACM_20201116江西师大校选拔赛.ACM;



/**
 * 链接：https://ac.nowcoder.com/acm/contest/5697/A
 * 来源：牛客网
 *
 * 期末考试结束了，青竹发现很多人挂了高数，只能等着重修，还要交200元的重修费。现在青竹有了所有人的高数成绩，青竹想知道如果所有挂科的人都在第二年重修，学校收到多少重修费？
 *
 * 挂科是指一门课的分数小于60分。
 * 输入描述:
 * 第一行一个整数nn，表示考试的人数。(1<n<=100)(1<n<=100)
 * 接下来nn行，每行表示每个人的成绩。
 * 学生的成绩为0-100（包括0和100）之间的整数。
 * 输出描述:
 * 一行，表示学校能收到多少重修费。
 * 输入
 * 复制
 * 4
 * 60
 * 56
 * 100
 * 59
 * 输出
 * 复制
 * 400
 */

import java.util.Scanner;
public class Main1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int score,sumMoney=0;
        for (int i = 1; i <= people; i++) {
            score = sc.nextInt();
            if (score<60)
                sumMoney += 200;
        }
        System.out.println(sumMoney);

    }
}
