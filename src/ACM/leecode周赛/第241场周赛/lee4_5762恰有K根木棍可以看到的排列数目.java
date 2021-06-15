package ACM.leecode周赛.第241场周赛;

public class lee4_5762恰有K根木棍可以看到的排列数目 {
    /****
     有 n 根长度互不相同的木棍，长度为从 1 到 n 的整数。请你将这些木棍排成一排，并满足从左侧 可以看到 恰好 k 根木棍。从左侧 可以看到 木棍的前提是这个木棍的 左侧 不存在比它 更长的 木棍。
     例如，如果木棍排列为 [1,3,2,5,4] ，那么从左侧可以看到的就是长度分别为 1、3 、5 的木棍。
     给你 n 和 k ，返回符合题目要求的排列 数目 。由于答案可能很大，请返回对 109 + 7 取余 的结果。
     示例 1：
     输入：n = 3, k = 2
     输出：3
     解释：[1,3,2], [2,3,1] 和 [2,1,3] 是仅有的能满足恰好 2 根木棍可以看到的排列。
     可以看到的木棍已经用粗体+斜体标识。
     */

    public static void main(String[] args) {

    }

    //1.暴力解法 全部的排列,check计数
    public static int rearrangeSticks(int n, int k) {
        int[] array = new int[n];
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[0]=i+1;
            array[i]=1;
            dfs(1,nums,array.clone());
            array[i]=0;
        }
        return 0;
    }

    private static void dfs(int i, int[] nums, int[] clone) {

    }

    //2.动态规划: dp[i][j]=dp[i−1][j−1]+(i−1)∗dp[i−1][j]
    public static int rearrangeSticks2(int n, int k) {
        return 0;
    }
}
