package ACM.leecode周赛.第259场周赛;

import java.util.Arrays;

public class lee25876数组美丽值求和 {
    public static void main(String[] args) {
        System.out.println(sumOfBeauties(new int[]{1, 2, 3}));
        System.out.println(sumOfBeauties(new int[]{2,4,6,4}));
        System.out.println(sumOfBeauties(new int[]{3,2,1}));
    }

    public static int sumOfBeauties(int[] nums) {
        int res = 0;
        int max = nums[0];
        int len = nums.length;
        int[] min = new int[len];
        int maxValue = Integer.MAX_VALUE;
        for (int i = len-1; i > 0 ; i--) {
            maxValue = Math.min(maxValue,nums[i]);
            min[i] = maxValue;
        }
        System.out.println(Arrays.toString(min));

        for (int i = 1; i < len-1; i++) {
            if (nums[i]>max &&nums[i]<min[i+1]){
                res+=2;
            }else if (nums[i]>nums[i-1]&&nums[i]<nums[i+1]){
                res++;
            }
            max = Math.max(max,nums[i]);
        }
        return res;
    }
}
