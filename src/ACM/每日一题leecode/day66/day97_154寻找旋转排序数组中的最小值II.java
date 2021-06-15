package ACM.每日一题leecode.day66;

import java.util.Map;

public class day97_154寻找旋转排序数组中的最小值II {
    /***
     已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
     若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。

     示例 1：
     输入：nums = [1,3,5]
     输出：1
     示例 2：
     输入：nums = [2,2,2,0,1]
     输出：0
     */
    //方法一:暴力法 100 59
    public static int findMin(int[] nums) {

        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minNum = Math.min(nums[i],minNum);
        }
        return minNum;
    }

    //方法二:二分查找,如果中间的大于右边的high,放弃左边,如果mid小于high放弃右边的 100 58
    public static int findMin2(int[] nums) {
        if (nums.length==1)return nums[0];
        if (nums.length==2)return Math.min(nums[0],nums[1]);
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid = (right-left)/2+left;
            //如果mid小于right && 小于左边的;就是你了
            /*if (nums[mid]<=nums[right] && (mid-1<0 || mid<=nums[mid-1])){
                return nums[mid];
            }*/
            if (nums[mid]<nums[right]){//右边不要了
                right=mid;
            }else
            if (nums[mid]>nums[right]){//右边不要了
                left=mid+1;
            }else {
                right -=1;
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 3, 5}));
        System.out.println(findMin2(new int[]{1, 3, 5}));
        System.out.println(findMin(new int[]{2,2,2,0,1}));
        System.out.println(findMin2(new int[]{2,2,2,0,1}));

    }
}
