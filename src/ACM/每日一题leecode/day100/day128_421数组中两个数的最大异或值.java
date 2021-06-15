package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day128_421数组中两个数的最大异或值 {
    //数组中两个数最大异或值'
    public static void main(String[] args) {
        System.out.println(findMaximumXOR2(new int[]{3, 10, 5, 25, 2, 8}));//28
        System.out.println(findMaximumXOR2(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));//127
        System.out.println(findMaximumXOR2(new int[]{8,10,2}));//
    }

    //方法一:暴力破解  5/94
    public static int findMaximumXOR(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }

        return max;
    }

    //方法二:尝试规律
    //发现一:一定是某个最大的数字,和一个数的异或
    public static int findMaximumXOR2(int[] nums) {

        int max = Integer.MIN_VALUE;
     /*   int ii = 0;
        int jj = 0;*/
        Arrays.sort(nums);
        int last = nums[nums.length-1];
            for (int j = 0; j < nums.length; j++) {
                max = Math.max(max,last ^ nums[j]);
            }

        //System.out.println("这是ii=" + ii + "--" + nums[ii]);
        //System.out.println("这是jj=" + jj + "--" + nums[jj]);

        return max;
    }

    //方法三:哈希表
    //方法三:字典树
}
