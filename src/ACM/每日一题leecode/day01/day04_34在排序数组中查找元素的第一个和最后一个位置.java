package ACM.每日一题leecode.day01;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 

示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day04_34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {1};
        int[] ints = searchRange(nums,1);
        System.out.println("["+ints[0]+","+ints[1]+"]");

        int[] nums1 = {5,7,7,8,8,10};
        int[] ints1 = searchRange(nums1,8);
        System.out.println("["+ints1[0]+","+ints1[1]+"]");

        int[] nums2 = {3,3,3};
        int[] ints2 = searchRange(nums2,3);
        System.out.println("["+ints2[0]+","+ints2[1]+"]");
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] results = {-1,-1};
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                results[j]=i;
                //nums[i]=i;
                if (j<1&&results[j+1]==-1){
                    results[j+1]=results[j];
                }
                if (j==0){
                    j++;
                }
            }
        }
        return results;
    }
}
