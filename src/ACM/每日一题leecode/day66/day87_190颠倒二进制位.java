package ACM.每日一题leecode.day66;

public class day87_190颠倒二进制位 {
    //颠倒给定的 32 位无符号整数的二进制位。
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        s = String.valueOf(new StringBuilder(s).reverse());
        System.out.println(s);


        return Integer.parseUnsignedInt(s);
    }

    //方法二:Integer.reverse
    public static int reverseBits2(int n) {
        return Integer.reverse(n);
    }

    //方法三:位运算:Integer.reverse
    public static int reverseBits3(int var0) {
        var0 = (var0 & 1431655765) << 1 | var0 >>> 1 & 1431655765;
        var0 = (var0 & 858993459) << 2 | var0 >>> 2 & 858993459;
        var0 = (var0 & 252645135) << 4 | var0 >>> 4 & 252645135;
        var0 = var0 << 24 | (var0 & '\uff00') << 8 | var0 >>> 8 & '\uff00' | var0 >>> 24;
        return var0;
    }

    //方法4:位运算:Integer.reverse   100 9
    public static int reverseBits4(int n) {
        int ans = 0;
        //进制的本质
        int i = 32;
        while (i-- != 0) {
            ans <<= 1;//慢慢把ans顶上去,一用n的末尾位
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(reverseBits(43261596));//00111001011110000010100101000000
        System.out.println(reverseBits3(43261596));//00111001011110000010100101000000
        System.out.println(reverseBits4(43261596));//00111001011110000010100101000000
    }
}
