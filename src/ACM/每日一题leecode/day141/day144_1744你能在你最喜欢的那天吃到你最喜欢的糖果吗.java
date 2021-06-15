package ACM.每日一题leecode.day141;

import java.util.ArrayList;
import java.util.Arrays;

public class day144_1744你能在你最喜欢的那天吃到你最喜欢的糖果吗 {
    //前缀和 +暴力算法
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] per = new long[candiesCount.length];
        boolean[] ans = new boolean[queries.length];
        per[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            per[i] = candiesCount[i] + per[i - 1];
        }

        //System.out.println("前缀和="+ Arrays.toString(per));

        //对每一行数据进行计算
        for (int i = 0; i < queries.length; i++) {
            //queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
            int favoriteTypei = queries[i][0];//类型
            int favoriteDayi = queries[i][1];//天
            int dailyCapi = queries[i][2];//limit限制
            //如果要求的最小点 会小于能达到的最大点,则true
            long canmin = favoriteDayi;
            long canmax = favoriteDayi * dailyCapi;
            long expectmin = per[favoriteTypei] - candiesCount[favoriteTypei] + 1;
            long expectmax = per[favoriteTypei];

            //只要canmin expect能重合就是true
            //false的情况:
            if (canmin > expectmax || expectmin > canmax) {
                ans[i] = false;
            } else {
                ans[i] = true;

            }
        }
        return ans;
    }

    //13 85
    public static boolean[] canEat2(int[] candiesCount, int[][] queries) {
        long[] dp = new long[candiesCount.length+1];
        boolean[] ans = new boolean[queries.length];


        //System.out.println("前缀和="+ Arrays.toString(per));

        for (int i = 1; i < candiesCount.length + 1; i++) {
            dp[i] = dp[i - 1] + candiesCount[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0] + 1;
            int day = queries[i][1] + 1;
            int cap = queries[i][2];

            long low = dp[type];
            long high = dp[type - 1] / cap;

            ans[i] = (day <= low && day > high);

        }

        return ans;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(canEat2(new int[]{7, 4, 5, 3, 8}, new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 100000}})));
    }
}
