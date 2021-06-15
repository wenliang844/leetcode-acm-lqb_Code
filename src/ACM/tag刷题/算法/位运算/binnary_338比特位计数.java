package ACM.tag刷题.算法.位运算;

import java.util.Arrays;

public class binnary_338比特位计数 {

    /***
     给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     示例 1:
     输入: 2
     输出: [0,1,1]
     */

    //方法一:暴力破解,一个一个求 5 5
    public static int[] countBits(int num) {
        int result[] = new int[num+1];
        for (int i = 0; i <= num; i++) {

            String temp = Integer.toBinaryString(i);
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1'){
                    result[i]++;
                }
            }
        }

        return result;
    }

    //官方:方法二:动态规划:,利用以前的数,现在的=i&(i-1) +1   99 22
    public static int[] countBits2(int num) {
        int result[] = new int[num+1];
        for (int i = 1; i <= num; i++) {
           result[i] = result[i&(i-1)]+1;
        }
        return result;
    }

    /***
     方法二：i >> 1会把最低位去掉，因此i >> 1 也是比i小的，同样也是在前面的数组里算过。当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
     */
    //官方:方法三:动态规划:,利用以前的数,现在的=i&(i-1) +1
    public static int[] countBits3(int num) {
        int result[] = new int[num+1];
        for (int i = 1; i <= num; i++) {
           result[i] = result[i>>1]+(i&1);//右移一个1,就是之前算过这个数字,再加上是否有1
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));//011
        System.out.println(Arrays.toString(countBits(5)));//011212
    }
}
