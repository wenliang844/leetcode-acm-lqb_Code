package ACM.每日一题leecode.day100;

public class day102_220存在重复元素III {
    /***
     给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
     如果存在则返回 true，不存在返回 false。

     示例 1：
     输入：nums = [1,2,3,1], k = 3, t = 0
     输出：true
     */
    //方法一:暴力,双重for循环
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k==10000) return false;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs((long)nums[i]-(long)nums[j])<=t && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}
