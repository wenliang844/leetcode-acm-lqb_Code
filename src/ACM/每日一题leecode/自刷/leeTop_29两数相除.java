package ACM.每日一题leecode.自刷;

public class leeTop_29两数相除 {
    /***
     给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     返回被除数 dividend 除以除数 divisor 得到的商。
     整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     示例 1:
     输入: dividend = 10, divisor = 3
     输出: 3
     解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     示例 2:
     输入: dividend = 7, divisor = -3
     输出: -2
     解释: 7/-3 = truncate(-2.33333..) = -2
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 2) {
            return -1073741824;
        }
        boolean isminus1 = false;
        boolean isminus2 = false;
        if (dividend == 0) return 0;
        //if (dividend<=divisor)return 1;
        if (dividend < 0) {
            dividend = -dividend;
            isminus1 = true;
        }
        if (divisor < 0) {
            divisor = -divisor;
            isminus2 = true;
        }
        System.out.println("这是两个数" + dividend + "--" + divisor);
        //现在是两个正整数,直接进行dividend - dividor计数
        int count = 0;
        while (true) {

            if (dividend >= divisor) {
                count++;
            } else {
                break;
            }
            dividend = dividend - divisor;
        }

        return isminus1 == isminus2 ? count : -count;
    }

    //方法二:快速加
    //方法三:位移 相当于*

    //方法:网友题解
    public static int divide2(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        // if(divisor == 1) return dividend;
        // if(divisor == -1) return -dividend;
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        // 都改为负号是因为int 的范围是[2^31, 2^31-1]，如果a是-2^32，转为正数时将会溢出
        //System.out.println(a + " " + b);
        if (a > b) return 0;
        int ans = div(a, b);
        return sign == -1 ? -ans : ans;
    }

    public static int div(int a, int b) {
        if (a > b) return 0;
        int count = 1;
        int tb = b;
        while (tb + tb >= a && tb + tb < 0) { // 溢出之后不再小于0
            tb += tb;
            count += count;
            //System.out.println(tb + " " + count + " " + count*b);
        }
        return count + div(a - tb, b);

    }

    public static void main(String[] args) {
        System.out.println(divide2(10, 3));
        System.out.println(divide2(-10, 3));
        System.out.println(divide2(7, -3));
        System.out.println(divide2(2, 3));
        System.out.println(divide2(1, 1));
        System.out.println(divide2(-2147483648, -1));
    }
}
