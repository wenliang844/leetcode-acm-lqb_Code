package ACM.每日一题leecode.day66;

import java.util.Arrays;

/***
 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 请你找出并返回这两个正序数组的 中位数 。
 输入：nums1 = [1,3], nums2 = [2]
 输出：2.00000
 解释：合并数组 = [1,2,3] ，中位数 2
 */
public  class day74_4寻找两个正序数组的中位数 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /***
         思路:
         1.对两个数组进行排序
         2.利用归并排序,两个指针找出len/2  的那个数即可 len/2 +1就是中位数

         直接将两个数组组成在一起,利用一个新数组,排序
         */
        //Arrays.sort(nums1);
        //Arrays.sort(nums2);
        int[] newNum = new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            newNum[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            newNum[i+nums1.length] = nums2[i];
        }
        Arrays.sort(newNum);
        //System.out.println(Arrays.toString(newNum));
        double ret = newNum.length%2==0?((newNum[newNum.length/2]+newNum[newNum.length/2-1])*1.00000/2):newNum[newNum.length/2];

        /* int i=0;
        int j=0;
        int count = 1;
        int len = nums1.length + nums2.length;
        while (count < len/2+1){
            if (nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
            count++;
        }

        System.out.println("中位数1="+nums1[i]);
        System.out.println("中位数2="+nums2[j]);*/

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3, 7, 5}, new int[]{2, 4, 6}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3, 7, 5}, new int[]{2, 4, 6,8}));

    }
}
