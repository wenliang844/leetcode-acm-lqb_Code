package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.Arrays;

/**
 * @author 陈文亮
 * @date 2022/9/28 12:32
 */
public class day008_面试题1709第k个数 {

    /*
    有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
    而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21 25。27 35 45 49 63
    示例 1:
    输入: k = 5
    输出: 9

    1
    3 3
    5
    7
    9 3*3
    15 3*5
    21 3*7
    25 5*5
    27 3*3*3
    35 5*7

    7
      5
        3
    3 5 7 9 15 21
     */
    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(130));
    }

    public static int getKthMagicNumber(int k) {

        int index3 = 0;
        int index5 = 0;
        int index7 = 0;
        int[] sequence = new int[k];
        sequence[0] = 1;
        int index = 0;
        while (++index < k) {
            int min;
            int a = sequence[index3] * 3;//21
            int b = sequence[index5] * 5;//25
            int c = sequence[index7] * 7;//21
            if (a <= b && a <= c) {
                index3++;
                min = a;
            } else if (c <= a && c <= b) {
                index7++;
                min = c;
            } else {
                index5++;
                min = b;
            }
            sequence[index] = min;
            if (sequence[index-1] == min){
                index--;
            }
            //System.out.println("sequence["+index+"]="+min+"--"+"--index3="+index3+"--idnex5="+index5+"--index7="+index7);
        }

        System.out.println(Arrays.toString(sequence));
        return sequence[k - 1];
    }

    public static int getKthMagicNumber1(int k) {

        int index3 = 0;
        int index5 = 0;
        int index7 = 0;
        int[] sequence = new int[k];
        sequence[0] = 1;
        int index = 0;
        while (++index < k) {
            int min;
            int a = sequence[index3] * 3;
            int b = sequence[index5] * 5;
            int c = sequence[index7] * 7;
            if (a < b && a < c) {
                index3++;
                min = a;
            } else if (c < a && c < b) {
                index7++;
                min = c;
            } else {
                index5++;
                min = b;
            }
            sequence[index] = min;
        }

        System.out.println(Arrays.toString(sequence));
        return sequence[k - 1];
    }

}