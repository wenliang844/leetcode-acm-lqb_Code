package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day104_6Z字形变换 {
    /***
     将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     P   A   H   N
     A P L S I I G
     Y   I   R
     之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     请你实现这个将字符串进行指定行数变换的函数：
     string convert(string s, int numRows);
     */

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("PAYPALISHIRING",4));
        System.out.println(convert("AB",1));
    }
    /**
     思路:设置num个子串,一个change,一个index change指针在1-num之间循环 23 50
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows==1)return s;
        int change = 0;
        int index = 0;
        String[] substrings = new String[numRows];
        Arrays.fill(substrings,"");
        boolean add = true;
        while (index<s.length()){
            substrings[change] += s.charAt(index);
            index++;
            if (change==0){
                //change=1;
                add=true;
            }
            if (change==numRows-1){
                //change=numRows-2;
                add=false;
            }
            if (add){
                change++;
            }else {
                change--;
            }
        }
        String res = "";
        for (int i = 0; i < substrings.length; i++) {
            res+=substrings[i];
        }
        return res;
    }
}
