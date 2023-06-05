package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/9/27 20:29
 */
public class day007_面试题0102判定是否互为字符重排 {

    /*
    给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

示例 1：

输入: s1 = "abc", s2 = "bca"
输出: true
示例 2：

输入: s1 = "abc", s2 = "bad"
输出: false
     */

    public static void main(String[] args) {

    }

    public boolean CheckPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] alphabets = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alphabets[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            alphabets[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != 0){
                return false;
            }
        }

        return true;
    }
}
