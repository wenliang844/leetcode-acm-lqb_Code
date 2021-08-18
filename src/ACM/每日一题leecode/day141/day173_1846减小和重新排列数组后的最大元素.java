package ACM.每日一题leecode.day141;

import java.util.Arrays;

public class day173_1846减小和重新排列数组后的最大元素 {
    /***
     使得数组满足以下条件：
     arr 中 第一个 元素必须为 1 。
     任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
     你可以执行以下 2 种操作任意次：
     减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
     重新排列 arr 中的元素，你可以以任意顺序重新排列
     */
    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));

    }

    //方法一:排序后进行1到最大操作 一趟遍历,最多只能加一,如果相等就跳过,不相等就等于加1 98/64
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[i] = arr[i-1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
