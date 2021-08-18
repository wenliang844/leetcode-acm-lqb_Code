package ACM.校招面试题.美团前端2021;

import java.util.Scanner;

/*****
 小美现在有一个字符串，小美现在想知道能不能通过在字符串的尾端增加若干字符使得整个字符串变成一个回文串。
 回文串的定义：若一个字符串，对他正序遍历和倒序遍历得到的结果是完全一致的，就称它是一个回文串。例如 abcba 就是一个回文串，因为无论正序还是倒序都是一样的。
 对于字符串 abaaca，显然在该字符串末尾继续补上三个字符 aba 就可以构成 abaacaaba，就可以把原字符串变成回文串。换句话说，最少补上三个字符。
 你的任务就是找到使得原来的字符串变成回文串所需要的最少字符数量。
 * 本题数据保证没有空串，因此不考虑空串是否为回文串。
 保证输入的字符串仅包含小写字母。
 */
public class mt4小美的回文串构建 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length()-1; i++) {
            String test = s.substring(i,s.length());
            System.out.println(test);
            if (isPalindrome2(test)){
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isPalindrome2(String s){
        StringBuilder sb = new StringBuilder(s);
        if (sb.reverse().equals(sb)){
            return true;
        }else {
            return false;
        }
    }
}
