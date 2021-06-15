package ACM.每日一题leecode.day66;

import java.lang.reflect.Array;
import java.util.Arrays;

public class day80_191位1的个数 {

    /***
     编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

     提示：
     请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
     示例 1：
     输入：00000000000000000000000000001011
     输出：3
     解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

     都Integer.toBinaryString(n);了怎么不直接Integer.valueOf(n).bitCount(1);
     */
    /*int hammingWeight2(uint32_t n) {
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >> 16) & 0x0000ffff);
        return n;
    }*/
    /*
     // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int temp = n;
        int index = 0;
        while (index < 32) {
            if ((temp & 1) == 1) {
                res++;
            }
            temp >>= 1;
            index++;
        }
        return res;
    }
     */
/*位运算
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int count = 0;
        int i = 0;
        while(i < 32) {   //循环32次
            if((n & 1) == 0)  //统计0的个数
                count++;
            n = n >> 1;   //右移
            i++;
        }

        return 32 - count;
    }
}
 */
    public static int hammingWeight(int n) {
        String s1 = Integer.toBinaryString(n);
       // System.out.println(n);
        //String s = String.valueOf(n);
        //System.out.println(s1);
        char[] chars = s1.toCharArray();
        //System.out.println(Arrays.toString(chars));

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='1'){
                count++;
            }
        }

        return count;
    }

    public static int hammingWeight2(int n){

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
        //System.out.println(hammingWeight(11111111111111111111111111111101));

    }
}
