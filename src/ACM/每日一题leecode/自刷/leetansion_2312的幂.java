package ACM.每日一题leecode.自刷;

public class leetansion_2312的幂 {
    /***
     给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     示例 1:
     输入: 1
     输出: true
     解释: 20 = 1
     */
    //方法一:二进制法,只要 7 5
    public static boolean isPowerOfTwo(int n) {
        if (n<=0)return false;
        String s = Integer.toBinaryString(n);
        if (s.charAt(0) != '1') return false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') return false;
        }
        return true;
    }

    /***
     if (n == 0) return false;
     while (n % 2 == 0) n /= 2;
     return n == 1;

     如何获取二进制中最右边的 1：x & (-x)。
     如何将二进制中最右边的 1 设置为 0：x & (x - 1)。
     */
//    100 29
    public boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;//将第一个数置一,其他置0

        /**
         if (n == 0) return false;
         long x = (long) n;
         return (x & (x - 1)) == 0;
         */
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(-2147483648));
    }
}
