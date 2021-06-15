package ACM.tag刷题.算法.动态规划;

public class dp_647回文子串 {
    /***
     给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。


     官方方法:中心拓展法,每个字符,或两个字符有可能是回文串的中心
     中心拓展，说白了，就是挨个遍历，只不过，中心可能是1个字符也可能是2个字符而已，
     不可能出现3个字符作为中心的情况，因为3个字符作为中心的话，他就是回文了，等于1个字符作为中心的情况
     我觉得下面的代码更好理解一点
     */
    public static boolean isPalirome(String s){
        int left=0;
        int right=s.length()-1;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    //方法一,双指针截取子串 O(n) 7 14
    public static int countSubstrings(String s) {
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if (isPalirome(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));//3
        System.out.println(countSubstrings("aaa"));//6 //"a", "a", "a", "aa", "aa", "aaa"
    }
}
