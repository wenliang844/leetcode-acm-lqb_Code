package ACM.每日一题leecode.day185;

import java.util.Arrays;

public class day235_1005K次取反后最大化的数组和 {
    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2},6));
        System.out.println(largestSumAfterKNegations(new int[]{2,3,4},1));
        System.out.println(largestSumAfterKNegations(new int[]{-2,5,0,2,-2},3));
        System.out.println(largestSumAfterKNegations(new int[]{-4,-2,-3},4));
    }

    //100 | 50
    public static int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i = 0;
        int sum = 0;
        while (k>0 && i<nums.length){
            if (nums[i]<0){
                nums[i] = -nums[i];
                k--;
            }else {
                if (k%2!=0){
                    if ((i-1)>=0 && nums[i-1]<nums[i]){
                        //nums[0] 变成负数 nums[i]不变
                        sum -= 2*nums[i-1];
                    }else {
                        nums[i] = -nums[i];
                    }
                }
                k=-1;
                break;
            }
            sum += nums[i];
            i++;
        }
        if (k>0 && k%2!=0){
            sum-=nums[nums.length-1]*2;
        }
        System.err.println("changes=="+Arrays.toString(nums));
        for (; i <nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
