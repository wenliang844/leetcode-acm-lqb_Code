package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.util.Arrays;

public class code1_判断回文数 {
    /**
     1.用栈
     //string -> char[] ->双指针  粘剂的解 --->常数时间会超时
     //如果样本量是n,时间复杂度的n^2 -> 10^8
     */
    public static boolean isPalindrome(int n){
        if (n<0){
            return false;
        }
        int help = 1;
        while (n / help >=10){ //n=12321
            help *= 10; //将help调整到10000
        }
        while (n != 0){
            System.out.println(n/help +"//"+help+"/////"+ n% 10);
            System.out.println("这是N="+n);
            if (n/help != n% 10){
                return false;
            }
            n = (n % help) / 10;//n变成2321 --> 232         32->3
            help /= 100;//从10000到 100
        }
        return true;
    }

    //方法2,用stringbuffered.reversestof2("2.5")
    public static boolean isPalindrome2(int n){
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        System.out.println(sb);
        System.out.println(sb.reverse());

        if (sb.reverse().equals(sb)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(12321));
    }
}
