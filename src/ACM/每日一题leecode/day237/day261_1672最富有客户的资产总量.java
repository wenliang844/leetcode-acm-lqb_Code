package ACM.每日一题leecode.day237;

public class day261_1672最富有客户的资产总量 {
    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
    }

    public static int maximumWealth(int[][] accounts) {

        int maxNum = 0;
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }

            maxNum = Math.max(maxNum, sum);
            sum = 0;
        }
        return maxNum;

    }
}
