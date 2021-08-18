package ACM.每日一题leecode.day141;

import java.util.Arrays;

public class day164_1833雪糕的最大数量 {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
    }

    //11/75
    public static int maxIceCream(int[] costs, int coins) {
        int maxCount = 0;
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {
                coins -= costs[i];
                maxCount++;
            } else {
                break;
            }
        }
        return maxCount;
    }

    /**
     vector<int> dp(coins + 1);
     for (int i : costs) {
     for (int j = coins; j >= i; --j) {
     dp[j] = max(dp[j], dp[j - i] + 1);
     }
     }
     return dp[coins];
     */
}
