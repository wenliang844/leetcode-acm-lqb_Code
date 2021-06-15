package ACM.每日一题leecode.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 

示例 1：

输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2：

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

 */
public class day28_188买卖股票的最佳时机IV {
    /****
     dp动态规划的状态转移方程--采用dp二维数组维持
     dp:
     0  1
     持有 不持有
     dp[0][0]=-3
     dp[0][1]=0
     这天持有           dp[1][0] = max( dp[0][0]持有 , dp[0][1]不持有的状态-prices[1]  )
     这天不持有或抛售   dp[1][1] = max( dp[i][0]+perices[i]抛售了(如果有手续费直接-fee),dp[0][1]维持不持有   )
     到最后的dp[i][1]  不持有的状态就是最大利润


     采用两个变量维持
     持有 = max(持有-prices[i] , 持有)
     不持有 = max( 不持有, prices[i]+持有 -fee)
     最后的不持有就是最大利润


     */
    public static void main(String[] args) {
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{2, 4, 1}));//2
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{3, 2, 6, 5, 0, 3}));//7
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{}));
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{1}));
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{2, 4, 1}));
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{6, 1, 3, 2, 4, 7}));
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
        System.out.println("这是最后的结果=" + maxProfix8(2, new int[]{14, 9, 10, 12, 4, 8, 1, 16}));
    }

    public static int maxProfit1(int k, int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int in = -prices[0];
        int out = 0;
        for (int i = 1; i < prices.length; i++) {
            in = Math.max(in, out - prices[i]);
            out = Math.max(in + prices[i], out);
        }

        return out;
    }

    public static int maxProfit2(int k, int[] prices) {

        /***
         最多只能进行k次交易解决方案:计数器 count=0   if count==k    return out;
         如何判断进行了交易?
         在in+prices[i]  的时候进行了一次抛售  就是一次交易
         如果in+prices[i] > out   那么out就会=in+prices[i] 也就是选了一次交易 那么count++

         那如果我前面不买 后面买两次的时候情况是最大的呢? 不就行不通了
         */
        if (prices.length == 0) {
            return 0;
        }
        int in = -prices[0];
        int out = 0;

        int count = 0;//计数器,当count=k的时候   直接返回out   结果股票之旅
        for (int i = 1; i < prices.length; i++) {
            in = Math.max(in, out - prices[i]);
            //out=Math.max(in+prices[i],out);
            int outin = in + prices[i];
            int outout = out;
            if (outin > outout) {
                out = outin;
                count++;
            } else {
                out = out;
            }

            if (count == k) {
                return out;
            }
        }

        return out;
    }

    public static int maxProfit3(int k, int[] prices) {

        /***
         用dp数组记录下每次交易的动态

         特殊情况:当 连续高涨的时候 2 4 7   这时候可以只买一次获取最大利润

         解决 :有连续高涨的  i i+1 i+2    k+1
         */
        for (int i = 0; i < prices.length - 2; i++) {
            if (prices[i + 1] > prices[i] && prices[i + 2] > prices[i + 1]) {
                k++;
            }
        }
        System.out.println("这是经过调整的k==" + k);

        if (prices.length == 0) {
            return 0;
        }
        int dp[][] = new int[prices.length][2];
        dp[0][0] = -prices[0];//持有
        dp[0][1] = 0;//不持有 抛售


        int count = 0;//计数器,当count=k的时候   直接返回out   结果股票之旅
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i][0] + prices[i], dp[i][1]);
        }

        List<Integer> profixList = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {//dp记录下了每次的利润  那么就可以寻找利润的差值最大的k个返回
            for (int j = 0; j < 2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i < prices.length; i++) {
            if (dp[i][1] - dp[i - 1][1] > 0) {
                profixList.add(dp[i][1] - dp[i - 1][1]);
            }
        }

        System.out.println(profixList);//[2, 3, 3]   k=2
        int[] profix = new int[profixList.size()];
        for (int i = 0; i < profix.length; i++) {
            profix[i] = profixList.get(i);
        }
        Arrays.sort(profix);
        for (int i = 0; i < profix.length; i++) {
            System.out.print(profix[i] + " ");
        }
        System.out.println();

        int maxProfix = 0;
        if (k < profix.length) {

            for (int i = profix.length - 1; i >= 0; i--) {

                maxProfix += profix[i];
                k--;
                if (k == 0) {
                    break;
                }

            }

            return maxProfix;
        }


        return dp[prices.length - 1][1];
    }

    //4:dp 维持4个变量
    public static int maxProfit4(int k, int[] prices) {

        /****
         任意一天考虑4个变量
         fstBuy 第一次买入的最大收益
         fstSell 第一次卖出的最大收益
         secBuy 第二次买入的最大收益
         secSell 第二次卖出的最大收益
         */
        int fstBuy = 0;
        int fstSell = 0;
        int secBuy = 0;
        int secSell = 0;
        for (int price : prices) {
            fstBuy = Math.max(fstBuy, -price);
            fstSell = Math.max(fstSell, fstBuy + price);
            secBuy = Math.max(secBuy, fstSell - price);
            secSell = Math.max(secSell, secBuy + price);
        }

        return secSell;
    }

    //暴力递归 超时
    public static int maxProfix5(int k, int[] prices) {
        return f5(prices, 0, 0, 0);
    }

    public static int f5(int[] prices, int i, int hasStock, int counts) {
        /***
         prices
         i 考虑第几天
         hasstock 是否有股票在手
         counts已经交易的次数 每次买入一次加1

         可以采用一个map来自定义一个key封装这三个变量
         index status k交易次数
         java还需要自定义hashCode  equsls
         */

        //退出条件:买了两次股票,手里没股票了,后面的不需要管了
        if (i >= prices.length || (counts >= 2 && hasStock < 1)) {
            return 0;
        }

        //如果手里有股票,可以选择卖或者不卖
        if (hasStock > 0) {
            return Math.max(prices[i] + f5(prices, i + 1, 0, counts), f5(prices, i + 1, 1, counts));
        } else {
            //如果没有股票我可以选择买或者不买
            return Math.max(-prices[i] + f5(prices, i + 1, 1, counts + 1), f5(prices, i + 1, 0, counts));
        }
    }

    //k=2的时候 这种特殊情况可以采用一个低效的方法,就是 计算0-i天  i-length天各交易一次的最大收益
    public static int maxProfix6(int k, int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, func6(prices, 0, i) + func6(prices, i, prices.length));
        }

        return max;

        /***
         优化O(n),通过
         通过预处理求得左右区间买入卖出最大差值
         left_right[i]表示prices[0,...,i]范围买入卖出最大差值
         right_left[i]表示prices[i,...,n-1]范围买入卖出最大差值


         class Solution {
         public:
         int maxProfit(vector<int>& prices) {
         int n = prices.size();

         vector<int> left_right(n), right_left(n);
         int minPrice = INT_MAX, maxLeftVal = 0;
         for(int i = 0; i < n; ++i){
         minPrice = min(minPrice, prices[i]);
         maxLeftVal = max(maxLeftVal, prices[i] - minPrice);
         left_right[i] = maxLeftVal;
         }
         int maxPrice = INT_MIN, maxRightVal = 0;
         for(int i = n-1;i >= 0; --i){
         maxPrice = max(maxPrice,prices[i]);
         maxRightVal = max(maxRightVal, maxPrice - prices[i]);
         right_left[i] = maxRightVal;
         }

         int res = 0;
         for(int i = 0; i < n; ++i){
         res = max(res, left_right[i]+right_left[i]);
         }
         return res;
         }
         };

         作者：zhangyonghui
         链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/on4you-hua-dao-on2zai-you-hua-dao-on-by-3912l/
         来源：力扣（LeetCode）
         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
    }

    private static int func6(int[] prices, int start, int end) {
        int min = prices[start];
        int profix = 0;
        for (int i = start; i < end; i++) {
            profix = Math.max(prices[i] - min, profix);//维持当前价格减掉当前最小价格
            min = Math.min(min, prices[i]);//维持当前最小价格
        }
        return profix;
    }

    //动态规划/3维 维持三个变量 dp数组
    public static int maxProfix7(int k, int[] prices) {
        /*****官方解法
         方法一：动态规划
         思路与算法

         与其余的股票问题类似，我们使用一系列变量存储「买入」的状态，再用一系列变量存储「卖出」的状态，通过动态规划的方法即可解决本题。

         我们用 \textit{buy}[i][j]buy[i][j] 表示对于数组 \textit{prices}[0..i]prices[0..i] 中的价格而言，进行恰好 jj 笔交易，并且当前手上持有一支股票，这种情况下的最大利润；用 \textit{sell}[i][j]sell[i][j] 表示恰好进行 jj 笔交易，并且当前手上不持有股票，这种情况下的最大利润。

         那么我们可以对状态转移方程进行推导。对于 \textit{buy}[i][j]buy[i][j]，我们考虑当前手上持有的股票是否是在第 ii 天买入的。如果是第 ii 天买入的，那么在第 i-1i−1 天时，我们手上不持有股票，对应状态 \textit{sell}[i-1][j]sell[i−1][j]，并且需要扣除 \textit{prices}[i]prices[i] 的买入花费；如果不是第 ii 天买入的，那么在第 i-1i−1 天时，我们手上持有股票，对应状态 \textit{buy}[i][j]buy[i][j]。那么我们可以得到状态转移方程：

         \textit{buy}[i][j] = \max \big\{ \textit{buy}[i-1][j], \textit{sell}[i-1][j] - \textit{price}[i] \big\}
         buy[i][j]=max{buy[i−1][j],sell[i−1][j]−price[i]}

         同理对于 \textit{sell}[i][j]sell[i][j]，如果是第 ii 天卖出的，那么在第 i-1i−1 天时，我们手上持有股票，对应状态 \textit{buy}[i-1][j-1]buy[i−1][j−1]，并且需要增加 \textit{prices}[i]prices[i] 的卖出收益；如果不是第 ii 天卖出的，那么在第 i-1i−1 天时，我们手上不持有股票，对应状态 \textit{sell}[i-1][j]sell[i−1][j]。那么我们可以得到状态转移方程：

         \textit{sell}[i][j] = \max \big\{ \textit{sell}[i-1][j], \textit{buy}[i-1][j-1] + \textit{price}[i] \big\}
         sell[i][j]=max{sell[i−1][j],buy[i−1][j−1]+price[i]}

         由于在所有的 nn 天结束后，手上不持有股票对应的最大利润一定是严格由于手上持有股票对应的最大利润的，然而完成的交易数并不是越多越好（例如数组 \textit{prices}prices 单调递减，我们不进行任何交易才是最优的），因此最终的答案即为 \textit{sell}[n-1][0..k]sell[n−1][0..k] 中的最大值。

         细节

         在上述的状态转移方程中，确定边界条件是非常重要的步骤。我们可以考虑将所有的 \textit{buy}[0][0..k]buy[0][0..k] 以及 \textit{sell}[0][0..k]sell[0][0..k] 设置为边界。

         对于 \textit{buy}[0][0..k]buy[0][0..k]，由于只有 \textit{prices}[0]prices[0] 唯一的股价，因此我们不可能进行过任何交易，那么我们可以将所有的 \textit{buy}[0][1..k]buy[0][1..k] 设置为一个非常小的值，表示不合法的状态。而对于 \textit{buy}[0][0]buy[0][0]，它的值为 -\textit{prices}[0]−prices[0]，即「我们在第 00 天以 \textit{prices}[0]prices[0] 的价格买入股票」是唯一满足手上持有股票的方法。

         对于 \textit{sell}[0][0..k]sell[0][0..k]，同理我们可以将所有的 \textit{sell}[0][1..k]sell[0][1..k] 设置为一个非常小的值，表示不合法的状态。而对于 \textit{sell}[0][0]sell[0][0]，它的值为 00，即「我们在第 00 天不做任何事」是唯一满足手上不持有股票的方法。

         在设置完边界之后，我们就可以使用二重循环，在 i\in [1,n), j \in [0, k]i∈[1,n),j∈[0,k] 的范围内进行状态转移。需要注意的是，\textit{sell}[i][j]sell[i][j] 的状态转移方程中包含 \textit{buy}[i-1][j-1]buy[i−1][j−1]，在 j=0j=0 时其表示不合法的状态，因此在 j=0j=0 时，我们无需对 \textit{sell}[i][j]sell[i][j] 进行转移，让其保持值为 00 即可。

         最后需要注意的是，本题中 kk 的最大值可以达到 10^910
         9
         ，然而这是毫无意义的，因为 nn 天最多只能进行 \lfloor \frac{n}{2} \rfloor⌊
         2
         n
         ​
         ⌋ 笔交易，其中 \lfloor x \rfloor⌊x⌋ 表示对 xx 向下取整。因此我们可以将 kk 对 \lfloor \frac{n}{2} \rfloor⌊
         2
         n
         ​
         ⌋ 取较小值之后再进行动态规划。

         代码

         C++JavaPython3GolangCJavaScript

         class Solution {
         public:
         int maxProfit(int k, vector<int>& prices) {
         if (prices.empty()) {
         return 0;
         }

         int n = prices.size();
         k = min(k, n / 2);
         vector<vector<int>> buy(n, vector<int>(k + 1));
         vector<vector<int>> sell(n, vector<int>(k + 1));

         buy[0][0] = -prices[0];
         sell[0][0] = 0;
         for (int i = 1; i <= k; ++i) {
         buy[0][i] = sell[0][i] = INT_MIN / 2;
         }

         for (int i = 1; i < n; ++i) {
         buy[i][0] = max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
         for (int j = 1; j <= k; ++j) {
         buy[i][j] = max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
         sell[i][j] = max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
         }
         }

         return *max_element(sell[n - 1].begin(), sell[n - 1].end());
         }
         };
         注意到在状态转移方程中，\textit{buy}[i][j]buy[i][j] 和 \textit{sell}[i][j]sell[i][j] 都从 \textit{buy}[i-1][..]buy[i−1][..] 以及 \textit{sell}[i-1][..]sell[i−1][..] 转移而来，因此我们可以使用一维数组而不是二维数组进行状态转移，即：

         \begin{cases} b[j] \leftarrow \max \big\{ b[j], s[j] - \textit{price}[i] \big\} \\ \\ s[j] \leftarrow \max \big\{ s[j], b[j-1] + \textit{price}[i] \big\} \end{cases}
         ⎩
         ⎪
         ⎪
         ⎨
         ⎪
         ⎪
         ⎧
         ​

         b[j]←max{b[j],s[j]−price[i]}
         s[j]←max{s[j],b[j−1]+price[i]}
         ​


         这样的状态转移方程会因为状态的覆盖而变得不同。例如如果我们先计算 \textit{b}b 而后计算 ss，那么在计算到 s[j]s[j] 时，其状态转移方程中包含的 b[j-1]b[j−1] 这一项的值已经被覆盖了，即本来应当是从二维表示中的 \textit{buy}[i-1][j-1]buy[i−1][j−1] 转移而来，而现在却变成了 \textit{buy}[i][j-1]buy[i][j−1]。

         但其仍然是正确的。我们考虑 \textit{buy}[i][j-1]buy[i][j−1] 的状态转移方程：

         b[j-1] \leftarrow \textit{buy}[i][j-1] = \max \big\{ \textit{buy}[i-1][j-1], \textit{sell}[i-1][j-1] - \textit{price}[i] \big\}
         b[j−1]←buy[i][j−1]=max{buy[i−1][j−1],sell[i−1][j−1]−price[i]}

         那么 s[j]s[j] 的状态转移方程实际上为：

         s[j] \leftarrow \max \big\{ s[j], \textit{buy}[i-1][j-1] + \textit{prices}[i], \textit{sell}[i-1][j-1] \big\}
         s[j]←max{s[j],buy[i−1][j−1]+prices[i],sell[i−1][j−1]}

         为什么 s[j]s[j] 的状态转移方程中会出现 \textit{sell}[i-1][j-1]sell[i−1][j−1] 这一项？实际上，我们是把「在第 ii 天以 \textit{prices}[i]prices[i] 的价格买入，并在同一天以 \textit{prices}[i]prices[i] 的价格卖出」看成了一笔交易，这样对应的收益即为：

         \textit{sell}[i-1][j-1] - \textit{prices}[i] + \textit{prices}[i]
         sell[i−1][j−1]−prices[i]+prices[i]

         也就是 \textit{sell}[i-1][j-1]sell[i−1][j−1] 本身。这种在同一天之内进行一笔交易的情况，收益为零，它并不会带来额外的收益，因此对最终的答案并不会产生影响，状态转移方程在本质上仍然是正确的。

         C++JavaPython3GolangJavaScriptC

         class Solution {
         public:
         int maxProfit(int k, vector<int>& prices) {
         if (prices.empty()) {
         return 0;
         }

         int n = prices.size();
         k = min(k, n / 2);
         vector<int> buy(k + 1);
         vector<int> sell(k + 1);

         buy[0] = -prices[0];
         sell[0] = 0;
         for (int i = 1; i <= k; ++i) {
         buy[i] = sell[i] = INT_MIN / 2;
         }

         for (int i = 1; i < n; ++i) {
         buy[0] = max(buy[0], sell[0] - prices[i]);
         for (int j = 1; j <= k; ++j) {
         buy[j] = max(buy[j], sell[j] - prices[i]);
         sell[j] = max(sell[j], buy[j - 1] + prices[i]);
         }
         }

         return *max_element(sell.begin(), sell.end());
         }
         };
         复杂度分析

         时间复杂度：O(n\min(n, k))O(nmin(n,k))，其中 nn 是数组 \textit{prices}prices 的大小，即我们使用二重循环进行动态规划需要的时间。

         空间复杂度：O(n\min(n, k))O(nmin(n,k)) 或 O(\min(n, k))O(min(n,k))，取决于我们使用二维数组还是一维数组进行动态规划。

         作者：LeetCode-Solution
         链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iv-by-8xtkp/
         来源：力扣（LeetCode）
         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        /***
         第一维 表示天 i
         第二维 表示交易几次 k=2
         第三维 表示是否持有股票 true false
         当然也可以维持4个变量


         买卖两次:
         初始-买入1 保持不动 卖出1 保持不动 买入2 保持不动 卖出2 交易结束
         通过这些状态,可以用3个变量表示买卖两次的交易状态
         index 表示当前是哪一天
         status 用来表示当前状态是买入还是卖出
         k 表示交易了几次

         如果是买入  可以维持买入不动 可以卖掉
         如果是卖出  可以维持不动  可以买入 同时coutn+1 表示交易过一次了

         */
        /****
         采用三维数组:
         动态规划 三维数组 idnex status k
         dp[n][3][2] 这里的n表示天数
         dp[i][0][0] 表示第i天交易了0次卖出后的累计最大利润
         dp[i][0][1] 表示第i天交易了0次买入后的累计最大利润
         dp[i][1][0] 表示第i天交易了1次卖出后的累计最大利润
         dp[i][1][1] 表示第i天交易了1次买入后的累计最大利润
         dp[i][2][0] 表示第i天交易了2次卖出后的累计最大利润
         dp[i][2][1] 表示第i天交易了2次买入后的累计最大利润 -实际不存在 交易两次后不能买入了

         买入1    保持不动        卖出1         保持不动    买入2     保持不动        卖出2         交易结束
         dp[i][0][1] dp[i][0][0] dp[i][1][0]  dp[i][1][0] dp[i][1][1] dp[i][1][1] dp[i][2][0] dp[i][2][0]
         i00 对应初始状态
         io1 i10  一对,一次买入 一次卖出
         iii i20 一对,二次买入 二次卖出
         买入1 = 买入1 | 初始状态
         卖出1 = 卖出1 | 买入1

         第一次买卖的DP公式
         dp[i][0][1] max {dp[i-1][0][1].dp[i-1][0][0]-prices[i]}
         第一次卖出
         dp[i][0][1] = max{dp[i-1][1][0],dp[i-1][0][1]+peices[i]}

         买入2 = 买入2 | 卖出1
         卖出2 = 卖出2 | 买入2
         DP公式
         dp[i][1][1] = max{dp[i-1][1][1]卖出1,dp[i-1][1][0]-prices[i]买入2再保持不动}
         dp[i][2][0] = max{dp[i-1][2][0]买入2,dp[i-1][1][1]+prices[i]卖出2后保持不动}

         最后的最大profix就是dp[n-1][0][0]、dp[n-1][0][1]、dp[n-1][1][0]、dp[n-1][1][1]、dp[n-1][2][0]中


         */
        //「123. 买卖股票的最佳时机 III」。
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //定义三维数组，第i天、交易了多少次、当前的买卖状态
        int[][][] dp = new int[n][3][2];
        //初始化第一天，这里的dp[0][2][1]可以不用管，后面也不会用到
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            //dp[i][0][0]相当于初始状态，它只能从初始状态转换来
            dp[i][0][0] = dp[i - 1][0][0];
            //处理第一次买入、第一次卖出
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            //处理第二次买入、第二次卖出
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }
        //返回最大值
        int a = Math.max(dp[n - 1][0][0], dp[n - 1][0][1]);
        int b = Math.max(dp[n - 1][1][0], dp[n - 1][1][1]);
        return Math.max(Math.max(a, b), dp[n - 1][2][0]);


    }

    //动态规划/3维简化  采用4个变量
    //「123. 买卖股票的最佳时机 III」。
    public static int maxProfix7_2(int k, int[] prices) {
        /***
         T[i][2][0] = max(T[i - 1][2][0], T[i - 1][2][1] + prices[i])
         T[i][2][1] = max(T[i - 1][2][1], T[i - 1][1][0] - prices[i])
         T[i][1][0] = max(T[i - 1][1][0], T[i - 1][1][1] + prices[i])
         T[i][1][1] = max(T[i - 1][1][1], T[i - 1][0][0] - prices[i]) = max(T[i - 1][1][1], -prices[i])

         因为i天的最大收益只和i-1的最大收益有关,空间复杂度可以降低到O(1)
         可以采用4个变量维持

         第一次买入 卖出 第二次买入 卖出
         one1       one0 two1   two0
         */

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profitOne0 = 0;//第一次卖出
        int profitOne1 = -prices[0];//第一次买入
        int profitTwo0 = 0;//第二次卖出
        int profitTwo1 = -prices[0];//第二次买入
        for (int i = 0; i < prices.length; i++) {
            profitTwo0 = Math.max(profitTwo0, profitTwo1 + prices[i]);
            profitTwo1 = Math.max(profitTwo1, profitOne0 - prices[i]);
            profitOne0 = Math.max(profitOne0, profitOne1 + prices[i]);
            profitOne1 = Math.max(profitOne1, -prices[i]);
        }

        return profitTwo0;
    }


    /****
     这才是买卖股票的最佳时机4 之前的都是3的尝试
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfix8(int k, int[] prices) {
        /*****
         情况四：k 为任意值
         情况四对应的题目是「188. 买卖股票的最佳时机 IV」。
         情况四是最通用的情况，对于每一天需要使用不同的 k 值更新所有的最大收益，对应持有 0 份股票
         或 1 份股票。如果 k 超过一个临界值，最大收益就不再取决于允许的最大交易次数，而是取决于
         股票价格数组的长度，因此可以进行优化。那么这个临界值是什么呢？
         一个有收益的交易至少需要两天（在前一天买入，在后一天卖出，前提是买入价格低于卖出价格）。
         如果股票价格数组的长度为 n，则有收益的交易的数量最多为 n / 2（整数除法）。因此 k 的临
         界值是 n / 2。如果给定的 k 不小于临界值，即 k >= n / 2，则可以将 k 扩展为正无穷，
         此时问题等价于情况二。
         根据状态转移方程，可以写出时间复杂度为 O(nk)O(nk) 和空间复杂度为 O(nk)O(nk) 的解法。

         */
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        if (k >= len / 2) {//一次交易最少控制两次len长度  当交易数大于了len/2 等同于可以无限交易 以此进行优化
            return f8(prices);
        }

        //定义一个三维数组 存储状态
        int[][][] dp = new int[len][k + 1][2];

        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;//首次不持有 release状态
            dp[0][i][1] = -prices[0];//持有 hold状态
        }

        for (int i = 1; i < len; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]); //release
                dp[i][j][1] = Math.max(dp[i-1][j-1][0]-prices[i],dp[i-1][j][1]); //hold状态的转换
            }
        }

        return dp[len-1][k][0]; //因为是从0--k的地推 所以中间是k而不是0
    }

    public static int f8(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int hold = -prices[0];
        int release = 0;
        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, release - prices[i]);
            release = Math.max(hold + prices[i], release);
        }
        return release;
    }


    //如果注意到第 i 天的最大收益只和第 i - 1 天的最大收益相关，空间复杂度可以降到 O(k)O(k)
    public static int maxProfix8_2(int k, int[] prices) {

        if (prices.length ==0 ||prices==null){
            return 0;
        }
        int length = prices.length;
        if (k>=length/2){
            return f8(prices);
        }
        int[][] dp = new int[k+1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0]=0; //release
            dp[i][1]=-prices[0]; //hold
        }

        for (int i = 1; i < length; i++) {
            for (int j = k; j >0; j--) {
                dp[j][0] = Math.max(dp[j][0],dp[j][1]+prices[i]); //处理release
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0]-prices[i]); //处理hold
            }
        }

        return dp[k][0];
    }
}



































