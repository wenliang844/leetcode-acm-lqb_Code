package 蓝桥杯.lan真题训练.lqb2021省赛1场java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J括号序列 {
    /***
     dfs暴力骗分
     ()()()

     这个set容器可以不需要,直接在dfs中计数,count设置为全局变量
     */
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
        }
        //int count = Math.max(left, right);
        int count;//最多的括号数量
        int sub;//插入的括号不能超过sub个,也就是不一样的括号数量
        if (left > right) {
            count = left;
            sub = left - right;
        } else {
            count = right;
            sub = right - left;
        }

        String temp = "";
        for (int i = 0; i < count; i++) {
            temp += "()";
        }
        dfs(temp);
        System.out.println(set);

        int resCount = 0;

        for (String s1 : set) {
            int i = 0;
            int j = 0;
            boolean isMatch = true;
            while (i < s.length() && j < s1.length()) {
                int tempCount = sub;
                if (s.charAt(i) == s1.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                    tempCount--;
                }
                if (tempCount < 0) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                resCount++;
            }
        }

        System.out.println(resCount);
    }

    private static void dfs(String temp) {
        set.add(temp);
        for (int i = 0; i < temp.length() - 1; i++) {
            if (temp.charAt(i) == ')' && temp.charAt(i + 1) == '(') {
                String temps = temp.substring(0, i) + "()" + temp.substring(i + 2, temp.length());
                dfs(temps);
            }
        }
    }
}
