package 蓝桥杯.练习系统.基础练习;

import java.math.BigInteger;
import java.util.Scanner;

public class lqb216to8 {
    /*
    2
　　39
　　123ABC

C9DAB2B36C
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- >0){
            //转10进制
            String s = sc.next();
            //int num = Integer.parseInt(s, 16);
            BigInteger integer = new BigInteger(s,16);
            System.out.println(integer);
            //转8进制输出
            String s1 = Integer.toString(integer.intValue(), 8);
            System.out.println(s1);
        }
    }
}
