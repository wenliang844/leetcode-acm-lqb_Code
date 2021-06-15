package ACM.每日一题leecode.day01;

/*
给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1:

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

 */
public class day18_714买卖股票的最佳时机含手续费 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println("这是结果===" + maxProfit2(prices, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        int min = prices[0];
        int max = prices[0];
        int temp;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {

            System.out.println("这是本轮的最小值最大值和price:" + min + "  " + max+"  "+prices[i]+ "---------------");

            if (max - prices[i] <= fee) {
                temp = max;
            }

            if (prices[i] > max) {
                max = prices[i];
                System.out.println("修正最大值为---：" + prices[i]);
            }

            if (prices[i] < min) {
                min = prices[i];
                System.out.println("修正最小值为:" + min);
            }

            if (max - prices[i] > 2 && max - min > fee) {
                sum += max - min - fee;
                System.out.println("买了+" + min + "--" + max);
                min = prices[i];
                max = prices[i];
                //continue;
            }
        }

        return sum;
    }

    /* dp
    对于每个时间节点，只有两种状态:已持有股票，或者未持有股票，分别维护这两种情况下的最大利润。
    最终输出未持有股票情况下的利润即可。
     */
    public static int maxProfit2(int[] prices, int fee) {
        int 今天不持有 = 0;
        int 今天持有 = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            今天持有 = Math.max(今天不持有-prices[i],今天持有);
            今天不持有 = Math.max(今天不持有,prices[i]+今天持有-fee);
        }

        return 今天不持有;
    }

    /*
    上面的贪心思想可以浓缩成一句话，即当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。在遍历完整个数组 \textit{prices}prices 之后之后，我们就得到了最大的总收益。

代码

C++JavaJavaScriptPython3GolangC

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
