package 蓝桥杯.lan真题训练.lan2020省赛javaB组;

import java.util.HashSet;
import java.util.Set;

public class B不同子串 {
/*
一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成
的串。例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
注意在计算时，只算本质不同的串的个数。
请问，字符串0100110001010001 有多少个不同的非空子串？
 */

    public static void main(String[] args) {

        System.out.println(getNums("aaab"));
        System.out.println(getNums("0100110001010001"));
    }

    public static int getNums(String s){

        Set<String> set = new HashSet<String>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            set.add(sb.toString());
            for (int j = i+1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }

        System.out.println(set);
        return set.size();
    }
}
