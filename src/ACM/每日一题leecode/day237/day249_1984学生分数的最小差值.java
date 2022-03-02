package ACM.每日一题leecode.day237;

import java.util.Arrays;

public class day249_1984学生分数的最小差值 {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }

    //排序 区间扫描
    public static int minimumDifference(int[] nums, int k) {

        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length-k; i++) {
            min = Math.min(min,nums[i+k-1] - nums[i]);
        }
        return min;
    }
}
