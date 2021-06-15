package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.校选拔B;

import java.util.ArrayList;
import java.util.Scanner;

public class code3树的选择全排列问题 {
    /***
     * 没有上司的舞会问题。注意排列组合计数原理。 树形DP
     从一棵树中选一对敢死队的选法,父子不能都选
     1
     2 3          4种-> 1   2   3   23

     1
     2 3
     4 5 6 7          40种:自顶向上,继承法,全排列法

     7
     1 1 2 2 3 3

     dp【root】【0】就是当前人不去的可能
     dp【root】【1】就是当前人去的可能

     f[i][1] = f[i_1][0] * f[i_2][0] * f[i_3][0] * …… * f[i_K][0]
     f[i][0] = (f[i_1][0]+f[i_1][1]) * …… * (f[i_K][0]+f[i_K][1])
     ans = (f[1][0] + f[1][1] - 1) % mod//除去所有人都不去的情况
     ————————————————

     <没有上司的舞会>
     树形dp
     用vector建图，找到没有boss的那个点，从这个点开始dfs
     而每个点都有两种情况，一是选择这个点取得的最大值和不选取得最大值，dp[i][1]表示选择这个点时的最大值， dp[i][0]表示不选这个点取得最大值，方程式为 dp[x][0]+=max(dp[i][1],dp[i][0]);dp[x][1]+=dp[i][0];
     */
    public static void main(String[] args) {
new Main().test();
    }
}
class Main {
    public static int n;
    public static int MOD = 10007;
    public static ArrayList<Integer>[] list;
    public static long[][] dp;

    public static void dfs(int root) {
        dp[root][0] = 1;
        dp[root][1] = 1;
        for(int i = 0;i < list[root].size();i++) {
            int child = list[root].get(i);
            dfs(child);
            dp[root][0] = dp[root][0] * (dp[child][0] + dp[child][1]) % MOD;
            dp[root][1] = dp[root][1] * dp[child][0] % MOD;
        }
    }

    @SuppressWarnings("unchecked")
    public static void test() {
        //Main test = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        list = new ArrayList[n + 1];
        for(int i = 1;i <= n;i++)
            list[i] = new ArrayList<Integer>();
        for(int i = 2;i <= n;i++) {
            int father = in.nextInt();
            list[father].add(i);
        }
        dp = new long[n + 1][2];
        dfs(1);
        long result = (dp[1][0] + dp[1][1] - 1) % MOD;
        System.out.println(result);
    }
}