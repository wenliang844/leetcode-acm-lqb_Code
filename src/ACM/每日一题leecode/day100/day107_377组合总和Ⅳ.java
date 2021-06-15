package ACM.每日一题leecode.day100;

public class day107_377组合总和Ⅳ {

    public static void dfs(int[] nums,int i,int target,int sum){
        if (sum>=target){
            if(sum==target){
                count++;
            }
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            dfs(nums,j,target,sum+nums[j]);
        }
    }
    static int count;
    public static int combinationSum4(int[] nums, int target) {
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            dfs(nums,i,target,nums[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
        System.out.println(combinationSum4(new int[]{9},3));
        System.out.println(combinationSum4(new int[]{2,1,3},35));
    }

    /**
     **
     * 简单递归
     *
    public int combinationSum4_1(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4_1(nums, target - num);
            }
        }
        return res;
    }

    **
     * 记忆化搜索
     *
    private int[] memo;

    public int combinationSum4_2(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }

    **
     * 动态规划
     *
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    memo[i + num] += memo[i];
                }
            }
        }
        return memo[target];
    }
     */
}

