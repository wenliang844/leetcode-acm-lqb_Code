package ACM.tag刷题.算法.深度优先dfs;

public class dfs_494目标和 {

    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * <p>
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 解释：
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * 一共有5种方法让最终目标和为3。
     */
   /* public static int calc(int a, int b, int p) {
        switch (p) {
            case 0:
                return a + b;
            case 1:
                return a - b;
        }
        return 0;
    }*/

    //方法一 :dfs 1 +- 1 +- 1  1 1  ==3?   count++; 回溯   37 76
    public static int dfs(int[] nums, int i, int sum, int count, int target) {


        int sum1 = sum + nums[i];
        int sum2 = sum - nums[i];
        System.out.println("层=i=" + i + "-" + sum + "-" + count);
        if (i >= (nums.length - 1)) {
           // System.out.println("这里count++=i=" + i + "-" + sum + "-" + count);
            if (sum1 == target) count++;
            if (sum2 == target) count++;
            //count++;
            return count;
        } else if (i < nums.length) {
            int newi = i + 1;
            count = dfs(nums, newi, sum1/*calc(sum, nums[i], 0)*/, count, target);
            count = dfs(nums, newi, sum2/*calc(sum, nums[i], 1)*/, count, target);
        }
        return count;
    }

    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length==1){
            return Math.abs(nums[0])==Math.abs(S)?1:0;
        }
        int count = 0;
        count += dfs(nums, 1, nums[0], 0, S);
        count += dfs(nums, 1, -nums[0], 0, S);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(findTargetSumWays(new int[]{1, 0}, 1));
        System.out.println(findTargetSumWays(new int[]{1}, 1));
    }
}
