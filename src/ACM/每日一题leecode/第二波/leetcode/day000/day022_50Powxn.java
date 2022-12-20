package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/15 16:47
 */
public class day022_50Powxn {
    public static void main(String[] args) {

        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));

    }

    public static double myPow(double x, int n) {
        double pow = Math.pow(x, n);
        return pow;
    }

    //others1
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if ((n & 1) == 0) {
            return myPow(x * x, n / 2);
        } else {
            return (n > 0 ? x : 1.0 / x) * myPow(x * x, n / 2);
        }
    }
}
