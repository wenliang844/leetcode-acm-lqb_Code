package ACM.每日一题leecode.day100;

public class day126_1269停在原地的方案数 {
    /****
     有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
     每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
     给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
     由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
     示例 1：
     输入：steps = 3, arrLen = 2
     输出：4
     解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
     向右，向左，不动
     不动，向右，向左
     向右，不动，向左
     不动，不动，不动
     */

    public static void main(String[] args) {
        System.out.println(numWays2(3, 2));//4
        System.out.println(numWays2(2, 4));//2
        System.out.println(numWays2(4, 2));//8
        System.out.println(numWays2(27, 7));//超时
    }

    static int count;
    static int len;

    //dfs暴力搜索 12/31   mod 10^9 + 7
    public static int numWays(int steps, int arrLen) {
        //递归三次下标变0,就可以
        len = Math.min(arrLen, steps / 2 + 1);//最多走这么多步
        count = 0;
        dfs(0, steps);
        return count;
    }

    private static void dfs(int index, int steps) {
        if (index < 0 || index >= len || steps < 0) {
            return;
        }
        if (index == 0 && steps == 0) {
            count++;
            return;
        }

        dfs(index, steps - 1);
        dfs(index - 1, steps - 1);
        dfs(index + 1, steps - 1);

    }


    //动态规划-
    public static int numWays2(int steps, int arrLen) {
        final int MODULO = 1000000007;
        //递归三次下标变0,就可以
        len = Math.min(arrLen, steps / 2 + 1);//最多走这么多步
        int[][] dp = new int[len][steps];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < steps; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < steps; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        return dp[len-1][steps-1];
    }
}
