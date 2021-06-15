package 蓝桥杯.lan真题训练.第十届2020决赛;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class F最长子序列 {

    public static void main(String[] args) {
        //动态规划:
        //相等 dp=斜上角+1
        //不相等 dp=左,上最大

        //双指针,
        /**
         ABCDEABCD
         AABZ
         */

        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        char[] ss = S.toCharArray();
        char[] tt = T.toCharArray();
        int[][] res = new int[tt.length][ss.length];
        for (int i = 0; i < ss.length; i++) {
            if (ss[i]==tt[0]){
                res[0][i]=1;
            }else {
                if (i-1>=0){
                    res[0][i] = res[0][i-1];
                }
            }
        }

        for (int i = 0; i < tt.length; i++) {
            if (tt[i]==ss[0]){
                res[i][0]=1;
            }else {
                if (i-1>=0){
                    res[i][0] = res[i-1][0];
                }
            }
        }

        for (int i = 1; i < tt.length; i++) {
            for (int j = 1; j < ss.length; j++) {
                if (ss[j]==tt[i]){
                    res[i][j]=res[i-1][j-1]+1;
                }else {
                    res[i][j]= Math.max(res[i-1][j],res[i][j-1]);
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
