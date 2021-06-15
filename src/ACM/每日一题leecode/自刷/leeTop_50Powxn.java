package ACM.每日一题leecode.自刷;

import java.util.Map;

public class leeTop_50Powxn {
    /***
     实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     */
    //方法一:常规 301/304
    public static double myPow(double x, int n) {//long进行运算
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n == Integer.MIN_VALUE) return 1;
            if (n / 2 == 0) return 1;
            else return -1;
        }

        if (n == Integer.MIN_VALUE) return 0;
        boolean negative = false;
        if (n < 0) {
            n = -n;
            negative = true;
        }

        double ans = 1;
        while (n-- > 0) {
            ans *= x;
        }
        return negative ? 1 / ans : ans;
    }

    //方法一:常规 301/304
    public static double myPow1_1(double x, int n) {//long进行运算
        long N = n;
        if (N < 0) {
            x = -x;
            N = -N;
        }
        double res = 1;
        for (long i = 0; i < N; i++) {
            res = res * x;
        }
        return res;
    }

    //方法一:常规分治
    public static double myPow1_2(double x, int n) {//long进行运算
        if (n==0 || n==1){
            return 1;
        }
        if (n<0){
            return 1/myPowHelper(x, Math.abs(n));
        }
        return 1/myPowHelper(x,n);
    }

    static double myPowHelper(double x,long n){
        if (n==1){
            return x;
        }
        if (n%2!=0){
            double half = myPowHelper(x,n/2);
            return half*half*x;
        }else {
            double half = myPowHelper(x,n/2);
            return half*half;
        }
    }

    //方法二:快速幂
    public static double myPow2(double x, int n) {


        return 0;
    }
    public double myPow3(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
        System.out.println(myPow(1.00000, 2147483647));
        System.out.println(myPow(2.00000, -2147483648));
        System.out.println(myPow(-1.00000, -2147483648));

        /*System.out.println(myPow1_1(2.00000, 10));
        System.out.println(myPow1_1(2.1, 3));
        System.out.println(myPow1_1(2.0, -2));
        System.out.println(myPow1_1(1.00000, 2147483647));
        System.out.println(myPow1_1(2.00000, -2147483648));
        System.out.println(myPow1_1(-1.00000, -2147483648))*/;

        System.out.println(myPow1_2(2.00000, 10));
        System.out.println(myPow1_2(2.1, 3));
        System.out.println(myPow1_2(2.0, -2));
        System.out.println(myPow1_2(1.00000, 2147483647));
        System.out.println(myPow1_2(2.00000, -2147483648));
        System.out.println(myPow1_2(-1.00000, -2147483648));
    }
}
