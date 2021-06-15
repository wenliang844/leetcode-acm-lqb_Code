package ACM.每日一题leecode.day01;
/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class day28_123买卖股票的最佳时机III {
    public static void main(String[] args) {
        System.out.println("这是最大利润="+maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));//6
        System.out.println("这是最大利润="+maxProfit(new int[]{1,2,3,4,5}));//4
        System.out.println("这是最大利润="+maxProfit(new int[]{7,6,4,3,1}));//0

    }

    public static int maxProfit(int[] prices) {
        /***
         因为只有两笔交易  尝试使用分成两个区间进行扫描出最大差值进行取最大利润 之和
         left[]  prices[i] - minprices
         right[] maxprices - prices[i]
         */
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int minprices = Integer.MAX_VALUE;
        int maxprices = 0;
        int maxProfix = 0;
        for (int i = 0; i < prices.length; i++) {//向左寻找最大差值
            minprices = Math.min(minprices,prices[i]);
            maxProfix = Math.max(maxprices,prices[i]-minprices);
            left[i] = maxProfix;
        }

        maxProfix=0;
        for (int i = prices.length-1; i >=0; i--) {//从右开始寻找最大差值
            maxprices = Math.max(maxprices,prices[i]);
            maxProfix = Math.max(maxProfix,maxprices-prices[i]);
            right[i]=maxProfix;
        }

        //在左右之间找到一个加起来最大的差值
        maxProfix=0;
        for (int i = 0; i < left.length; i++) {
            System.out.println("这是左右="+left[i]+"-"+right[i]);
            maxProfix = Math.max(maxProfix,left[i]+right[i]);
        }
        return maxProfix;
    }
}
