package ACM.每日一题leecode.自刷;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leeTop66加一 {
    /***
     给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     你可以假设除了整数 0 之外，这个整数不会以零开头。
     示例 1：
     输入：digits = [1,2,3]
     输出：[1,2,4]
     解释：输入数组表示数字 123。
     */
    //方法一:模拟进位 100 73
    public static int[] plusOne(int[] digits) {
        boolean isnine = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            //分两种情况,一种是全都是9的情况,一种不是
            if (digits[i]==9){
                digits[i]=0;
            }else {
                isnine=false;
                digits[i] += 1;
                break;
            }
        }

        if (isnine){
            //新建一个n+1长度的数组输出
            int[] newDigit = new int[digits.length+1];
            newDigit[0]=1;
            return newDigit;
        }else {
            return digits;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{0,0,0,0})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,8})));
        System.out.println(Arrays.toString(plusOne(new int[]{8,9,9,9})));
    }
}
