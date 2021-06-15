package 蓝桥杯.培训.第一次培训3_12习题2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lqb3_试题C不同子串 {

    /***
     一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成
     的串。例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
     注意在计算时，只算本质不同的串的个数。
     请问，字符串0100110001010001 有多少个不同的非空子串？
     */

    public static void test1() {

        //利用set 0100110001010001
        Set<String> set = new HashSet<>(); //treeSet可以字典排序
        String s = "0100110001010001";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
                set.add(s.substring(i, j));
            }
        }

        System.out.println(set);
        System.out.println(set.size());
    }

    //来自网络
    public static void test2() {
        String a = "0100110001010001";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j <= a.length(); j++) {
                if (!list.contains(a.substring(i, j))) {
                    list.add(a.substring(i, j));
                }

            }
        }
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        test1();
    }
}
