package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q22Anagrams问题 {
    //单词的频率一致 问题 YN判断问题
    public static void main(String[] args) {
        //用一个26len的数组记录出现的次数,在第二个单词中减去次数,全部为0则Y
        int[] count = new int[26];//0---25
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next().toLowerCase();
        String s2 = sc.next().toLowerCase();
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)-'a']++;
        } for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)-'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i]!=0){
                System.out.println("N");
                return;
            }
        }
        System.out.println("Y");
    }
}
