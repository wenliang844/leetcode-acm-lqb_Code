package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/10/7 21:13
 */
public class day013_1800最大升序子数组和 {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));

    }

    public static int maxAscendingSum(int[] nums) {

        int finalMax = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                //升 max+
                max += nums[i];
            }else {
                finalMax = Math.max(finalMax,max);
                max = nums[i];
            }
        }
        finalMax = Math.max(finalMax,max);
        return finalMax;
    }
}
