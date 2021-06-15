package ACM.ACM_20201116江西师大校选拔赛.ACM;


/**
 * 链接：https://ac.nowcoder.com/acm/contest/5697/G
 * 来源：牛客网
 * <p>
 * 题目描述
 * qz最近在学字符串，他对一种字符串很感兴趣，将这种字符串称之为“好串”，“好串”从两边读都是一样的，比如aabbaa,从左边和右边读都是一样的，现在qz有一些字符串，他想知道一个字符串有多少个子串是“好串”，（从母串中取出一段连续的串叫子串，例如：abcd的子串有a,ab,abc,abcd,b,bc,bcd,d，而ad不是它的子串）
 * 输入描述:
 * 输入第一行有一个整数t，表示有t组测试样例（t<=10）.
 * 接下来是t个测试样例，每个测试样例有一个字符串s。（|s| <= 100，字符串仅由英文小写字母构成）
 * <p>
 * <p>
 * 输出描述:
 * 对于每组样例的字符串，输出其子串是“好串”的个数。
 * 示例1
 * 输入
 * 复制
 * 1
 * aabbaa
 * 输出
 * 复制
 * 11
 */

import java.util.Scanner;

public class Main7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int strCount = sc.nextInt();
        String s[] = new String[strCount];

        for (int i = 0; i < strCount; i++) {
            s[i] = sc.next();
        }

        for (int i = 0; i < strCount; i++) {

            System.out.println(goodStrCount(s[i]));
        }

    }

    private static int goodStrCount(String s) {
        int count = 0;
        //分解子串
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                sb.append(chars[j]);
//                System.out.println(sb.toString()+"-------add");
                if (isGoodStr(sb.toString())) {
                    count++;
                }
            }
            sb.delete(0,sb.length());
//            System.out.println(sb.toString()+"--------del");
        }


        return count;
    }

    private static boolean isGoodStr(String s) {
        boolean flag = true;
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
//            System.out.println(chars[i] + "------" + chars[n - 1]);
            int a = chars[i];
            int b = chars[n - 1];
//            System.out.println(a + "------" + b);
            if (a != b) {
                flag = false;
                break;
            }
            n--;
        }
        return flag;
    }
}
