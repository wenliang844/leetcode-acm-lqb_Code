package ACM.每日一题leecode.自刷;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetension_344反转字符串 {
    /***
     编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     输入：['h','e','l','l','o']
     输出：['o','l','l','e','h']
     示例 2：
     输入：['H','a','n','n','a','h']
     输出：['h','a','n','n','a','H']
     */

    //100 20
    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    //方法二:空间换时间 100 95
    public static void reverseString2(char[] s) {
        int len = s.length;
        char newS[] = new char[len];
        for (int i = s.length-1; i >=0 ; i--) {
            newS[len-1-i] = s[i];
        }
        System.arraycopy(newS,0,s,0,len);

    }

    //方法三:API 9 99
    public static void reverseString3(char[] s) {
        System.arraycopy(new StringBuilder(String.valueOf(s)).reverse().toString().toCharArray(),0,s,0,s.length);
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o', 'a'};
        System.out.println(Arrays.toString(s));
        reverseString(s);
        System.out.println(Arrays.toString(s));
        reverseString2(s);
        System.out.println(Arrays.toString(s));
        reverseString3(s);
        System.out.println(Arrays.toString(s));
    }
}
