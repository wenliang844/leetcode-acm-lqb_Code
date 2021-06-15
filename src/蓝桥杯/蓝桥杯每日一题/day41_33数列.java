package 蓝桥杯.蓝桥杯每日一题;

import java.util.Arrays;

public class day41_33数列 {
    /***
     （数学 进制）
     时间限制：1.0s   内存限制：256.0MB
     问题描述
     　　给定一个正整数k(3≤k≤15),把所有k的方幂及所有有限个互不相等的k的方幂之和构成一个递增的序列，例如，当k=3时，这个序列是：
     　　1，3，4，9，10，12，13，…
     　　（该序列实际上就是：30，31，30+31，32，30+32，31+32，30+31+32，…）
     　　请你求出这个序列的第N项的值（用10进制数表示）。
     　　例如，对于k=3，N=100，正确答案应该是981。
     输入格式
     　　只有1行，为2个正整数，用一个空格隔开：
     　　k N
     　　（k、N的含义与上述的问题描述一致，且3≤k≤15，10≤N≤1000）。
     输出格式
     　　计算结果，是一个正整数（在所有的测试数据中，结果均不超过2.1*109）。（整数前不要有空格和其他符号）。
     样例输入
     3 100
     样例输出
     981
     */

    /**
     * 思路:3的0次方=1 3的1次方=3
     * 1 3 1+3 3的2次方 =9 9+1 9+3 9+4 (每次的次方要加前面的所有数,构成后面的数)
     */
    //方法一:暴力解法
    public static int getPowNum(int floorNum, int time) {
        int result[] = new int[time];
        int pow = 0;
        for (int i = 0; i < time; ) {
            int currentNum = (int) Math.pow(floorNum, pow++);
            result[i] = currentNum;
            int end = i;
            i++;
            for (int j = 0; j < end && i < time; j++) {
                result[i] = currentNum + result[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(result));

        return result[time - 1];
    }

    //方法二:找规律--->进制 二进制解法
    // 1 10 11 100 101---->正好表达为二进制1 2 3 4 5------>第300项的二进制表示出--->将二进制按照三进制展开即所得的结果。
    //1, 3, 4, 9, 10, 12, 13, 27, 28, 30, 31, 36, 37, 39, 40, 81, 82, 84, 85, 90,
    public static int getPowNum2(int floorNum, int time) {
        //也就是说time转二进制 转floorNum进制 复杂度O(1)
        //10进制转二进制,取余法,每次的余数是最后一个数
        int sum = 0;
        int pow = 0;
        while (time > 0) {
            if (time % 2 == 1) {
                sum += Math.pow(floorNum, pow);
                //System.out.println(Math.pow(floorNum,pow));
            }
            time = time / 2;
            pow++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getPowNum(3, 100));
        System.out.println(getPowNum2(3, 5));
        System.out.println(getPowNum2(3, 100));
    }
}
