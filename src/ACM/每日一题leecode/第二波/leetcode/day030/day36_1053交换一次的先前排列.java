package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.Arrays;

/**
 * @author 陈文亮
 * @date 2023/4/3 10:28
 */
public class day36_1053交换一次的先前排列 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(prevPermOpt1(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(prevPermOpt1(new int[]{1, 1, 5})));
        System.out.println(Arrays.toString(prevPermOpt1(new int[]{1, 9, 4, 6, 7})));
        System.out.println(Arrays.toString(prevPermOpt1(new int[]{3, 1, 1, 3})));//1313   1133

    }

    //暴力：直接从后开始二从遍历，找到第一个大于的数字交换
    public static int[] prevPermOpt1(int[] arr) {

        for (int i = arr.length-2; i >=0 ; i--) {
            //System.out.println(arr[i]);
            int big = Integer.MIN_VALUE;
            int index = -1;
            for (int j = arr.length-1; j > i ; j--) {
                if (arr[j] < arr[i] && arr[j]>=big) {
                    big = arr[j];
                    index = j;
                }
                //System.out.print(arr[j]);
            }
            if (big != Integer.MIN_VALUE){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                return arr;
            }
            //System.out.println("---");
        }

        return arr;
    }
}
