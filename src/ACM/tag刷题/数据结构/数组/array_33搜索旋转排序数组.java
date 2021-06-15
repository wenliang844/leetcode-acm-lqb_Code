package ACM.tag刷题.数据结构.数组;

public class array_33搜索旋转排序数组 {
    /**
     整数数组 nums 按升序排列，数组中的值 互不相同 。
     在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。

     示例 1：
     输入：nums = [4,5,6,7,0,1,2], target = 0
     输出：4
     */
    //method1:暴力循环:O{n} 100 50
    public static int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }//method2:数组一分为2,有序的二分,无序的再一份为2调用次算法
    public static int search2(int[] nums, int target) {
        //或者直接二分找出旋转点先

        return 0;

    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
}
