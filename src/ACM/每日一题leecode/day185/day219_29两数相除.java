package ACM.每日一题leecode.day185;

//不使用乘法 除法 mod运算
public class day219_29两数相除 {
    public static void main(String[] args) {
        System.out.println(divide2(10, 3));
        System.out.println(divide2(-2147483648, -1));
    }

    //使用乘法 除法 mod运算
    public static int divide(int dividend, int divisor) {
        return (int) ((long) dividend / (long) divisor);
    }

    //1.使用减法:效率低
    public static int divide2(int dividend, int divisor) {
        long count = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            count++;
        }
        return (int) count;
    }

    //leecode评论:---2.用位移法 100|43
    public static int divide3(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) < 0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {//找出足够大的数2^n*divisor
                result += 1 << i;//将结果加上2^n
                t -= d << i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}
