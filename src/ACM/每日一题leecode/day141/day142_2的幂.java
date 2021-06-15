package ACM.每日一题leecode.day141;

public class day142_2的幂 {
    /***
     给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     示例 1：
     输入：n = 1
     输出：true
     解释：20 = 1
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo2(2));
    }

    //方法一:暴力一直除以2,直到等于0,1 0是 1不是
    public static boolean isPowerOfTwo(int n) {

        while (n>=2) {
            if (n % 2 == 0)
                n = n / 2;
            else
                return false;
        }
        return true;
    }

    //方法二:2的幂->二进制的形式是10000000,判断1的个数一个且开始的是1即可
    public static boolean isPowerOfTwo2(int n) {
        if (n<=0)return false;
        int count = Integer.bitCount(n);
        char c = Integer.toBinaryString(n).charAt(0);
        return count == 1 && c == '1';
    }

    public boolean isPowerOfTwo3(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}
