package ACM.每日一题leecode.day01;

public class day28_309最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        System.out.println("这是结果=" + maxProfit2(new int[]{1, 2, 3, 0, 2}));
        System.out.println("这是结果=" + maxProfit2(new int[]{1}));
        System.out.println("这是结果=" + maxProfit2(new int[]{1, 2, 4}));
        System.out.println("这是结果=" + maxProfit2(new int[]{1, 2, 3, 0, 2}));
    }

    public static int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int in = -prices[0];
        int out = 0;
        for (int i = 1; i < prices.length; i++) {

            //
            in = Math.max(in, out - prices[i]);
            //out=Math.max(in+prices[i],out);
            if (in + prices[i] > out) {
                out = in + prices[i];
                if (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                    i++;
                }

            }
        }
        return out;
    }

    public static int maxProfit2(int[] prices) {
/***
 // f[i][0]: 手上持有股票的最大收益
 // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
 // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
 三个变量维持
 1.持有  =max(可以由持有 和不持有不在冷冻期转化)
 2.不持有 处于冷冻期 =(持有)
 3.不持有 不在冷冻期 =max(不持有处于冷冻期,不持有不在冷冻期)
 */
        if (prices.length == 0) {
            return 0;
        }
        int[][] f = new int[prices.length][3];
        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {

            //
            f[i][0] = Math.max(f[i-1][0], f[i-1][2] - prices[i]);//f[i][0]+prices[i]
            f[i][1] = f[i-1][0]+prices[i];
            f[i][2]=Math.max(f[i-1][1],f[i-1][2]);
            /*if (in + prices[i] > out) {
                out = in + prices[i];
                if (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                    i++;
                }

            }*/
        }
        return Math.max(f[prices.length-1][1],f[prices.length-1][2]);
    }
}
