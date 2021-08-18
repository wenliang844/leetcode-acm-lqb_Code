package ACM.每日一题leecode.day141;

import java.util.Arrays;

public class day166_645错误的集合 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
    }

    //方法一: sort 再nums相等的一个,nums!=i的一个 44/69
    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int res[] = new int[2];
        int n = nums.length;
        int sumN = n;
        int sumNums = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i]==nums[i-1]){
                res[0] = nums[i];
            }
            sumN += i;
            sumNums+=nums[i];
        }
        res[1] = sumN - sumNums + res[0];
        return res;
    }
}
