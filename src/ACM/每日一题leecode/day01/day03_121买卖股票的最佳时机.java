package ACM.每日一题leecode.day01;

import java.util.Scanner;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

 

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 0.暴力双循环
 * 1.动态规划:维持两个变量 minprice  maxprofit
 *
 *
 */
public class day03_121买卖股票的最佳时机 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit01(prices);
        System.out.println(maxProfit);

        int i = maxProfit02(prices);
        System.out.println(i);

        System.out.println(maxProfit03(prices));
    }
    public static int maxProfit01(int[] prices) {
        int maxNum = 0;
        int tamp;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]-prices[i]>maxNum){
                    maxNum=prices[j]-prices[i];
                }
            }

        }

        return maxNum;
    }

    public static int maxProfit02(int[] prices) {
        int minPrice=max(prices);
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<minPrice){
                minPrice=prices[i];
            }
            if (prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
    public static int maxProfit03(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int minPrice=prices[0];
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<minPrice){
                minPrice=prices[i];
            }
            if (prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }

    private static int max(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]>max){
                max=prices[i];
            }
        }
        return max;
    }
}
