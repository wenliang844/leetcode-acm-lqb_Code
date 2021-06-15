package ACM.每日一题leecode.day100;

public class day116_7整数反转 {
    /***
     给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     假设环境不允许存储 64 位整数（有符号或无符号）。
     */
    public static void main(String[] args) {

        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1534236469));

    }

    public static int reverse(int x) {

        //-2147483648~2147483647[-2^31~2^31-1]
        //判断是正数还是负数
        if (x > 0) {
            String s = new StringBuilder(String.valueOf(x)).reverse().toString();
            if (judge(s)) {
                return 0;
            }

            //反转数字
            return Integer.parseInt(s);
        } else {
            String s = new StringBuilder(String.valueOf(-x)).reverse().toString();
            if (judge(s)) {
                return 0;
            }

            //反转数字
            return -Integer.parseInt(s);
        }

    }

    private static boolean judge(String s) {
        if (s.length() < 10) {
            return false;
        } else if (s.length() > 10) {
            return true;
        } else {
            //将s和2147483647进行比较
            String target = "2147483647";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > target.charAt(i)) {
                    return true;
                } else if (s.charAt(i) < target.charAt(i)) {
                    return false;
                }

            }
        }

        return false;
    }


    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


}
