package ACM.每日一题leecode.自刷;

import java.util.Arrays;

public class leeTop_91解码方法 {
    /****
     一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
     给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
     题目数据保证答案肯定是一个 32 位 的整数。
     */
    /*public static int getCount(int n){
     *//* if (n==1)return 1;
        if (n==2)return 2;
        return *//*
    }*/
    //f(n)=f(n-1)+f(n-2) 一般情况,但是有边界条件 f[n]=f[n-1] 100 98
    public static int numDecodings(String s) {
        //前导零
        //if (s.contains("0"))return 0;
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1 || s.length() == 0) return 1;
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 1; i < f.length - 1; i++) {
            //f[i]=f[i-1]+f[i-2];
            if (s.charAt(i) == '0') {//1.s[i]=0的情况
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    f[i+1]=f[i-1];//i+1是因为s[1]对应的是s[2]比s[i-1]大二
                }else {
                    return 0;
                }

            }else {//2.s[i]不为0的情况
                if (s.charAt(i-1)=='1'||s.charAt(i-1)=='2' &&s.charAt(i)<='6'){
                    //两位数小于26的情况
                    f[i+1]=f[i]+f[i-1];
                }else {
                    //其他情况
                    f[i+1]=f[i];
                }

            }
        }
        System.out.println(Arrays.toString(f));
        return f[f.length - 1];
    }

    /***
     关于特殊情况的解决:

     */

    public static void main(String[] args) {
        //System.out.println(numDecodings(""));
        //System.out.println(numDecodings("2"));
        //System.out.println(numDecodings("22"));
        System.out.println(numDecodings("222"));
        //System.out.println(numDecodings("2222"));
        //System.out.println(numDecodings("22222"));
        //System.out.println(numDecodings("222222"));
        System.out.println(numDecodings("2222222"));//7
        System.out.println(numDecodings("0"));//7
    }
}
