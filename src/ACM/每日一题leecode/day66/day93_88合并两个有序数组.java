package ACM.每日一题leecode.day66;

import java.lang.reflect.Array;
import java.util.Arrays;

public class day93_88合并两个有序数组 {

    /***
     给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     示例 1：
     输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     输出：[1,2,2,3,5,6]
     示例 2：
     输入：nums1 = [1], m = 1, nums2 = [], n = 0
     输出：[1]
     */
    //方法一,模拟归并排序 100 91
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //1.把num1数组元素后撤n步, 123000 -> 0 0 0 0 1 2 3
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        System.out.println("调整num1" + Arrays.toString(nums1));
        //2.双指针,一个在num1的n位置,一个在num2的0位置
        int i = n;//指向num1的第一个数字
        int j = 0;//指向num2的第一个数字
        int k = 0;//指向num1的新存数字的位置
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums1[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        //如果i还有残留,就是最大的
        while (i < nums1.length) {
            nums1[k] = nums1[i];
            k++;
            i++;
        }
        while (j < nums2.length) {
            nums1[k] = nums2[j];
            k++;
            j++;
        }
        System.out.println("最后填充好的num1" + Arrays.toString(nums1));

    }

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 10, 15, 0, 0, 0, 0}, 5, new int[]{2, 5, 6, 9}, 4);
    }
}
