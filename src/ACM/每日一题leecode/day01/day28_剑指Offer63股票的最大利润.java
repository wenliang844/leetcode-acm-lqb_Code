package ACM.每日一题leecode.day01;

public class day28_剑指Offer63股票的最大利润 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
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
}
