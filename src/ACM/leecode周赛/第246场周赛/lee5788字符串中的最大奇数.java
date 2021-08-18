package ACM.leecode周赛.第246场周赛;

public class lee5788字符串中的最大奇数 {
    /***
     给你一个字符串 num ，表示一个大整数。
     请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，
     并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
     子字符串 是字符串中的一个连续的字符序列。
     */


    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
    }

    //方法一:从后往前,找第一个奇数,输出
    public static String largestOddNumber(String num) {
        for (int i = num.length()-1; i >=0; i--) {
            int n = num.charAt(i)-'0';
            if (n%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
