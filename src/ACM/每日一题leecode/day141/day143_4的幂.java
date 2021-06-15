package ACM.每日一题leecode.day141;

public class day143_4的幂 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(8));
    }

    /***
     1
     10
     100
     1000

     1
     100
     10000
     */
    //方法二:2的幂->二进制的形式是10000000,判断1的个数一个且开始的是1即可 8 43
    public static boolean isPowerOfFour(int n) {


            if (n<0)return false;
            int count = Integer.bitCount(n);
            String s = Integer.toBinaryString(n);
            char c = s.charAt(0);
            int length = s.length();
            return count == 1 && c == '1' && length%2!=0;

    }


}
