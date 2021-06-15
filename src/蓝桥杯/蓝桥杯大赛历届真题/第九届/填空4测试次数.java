package 蓝桥杯.蓝桥杯大赛历届真题.第九届;

public class 填空4测试次数 {
    //dp[i][j]=max(dp[i-1][k-1],dp[i][j-k])+1,k∈[1,j-1]
    /**
     (k*k*k+5k) / 6 >=1000
     */

    static int dp[][] = new int[5][1005];

    static void solve(int phone, int floor) {
        for (int i = 1; i <= phone; i++) {
            for (int j = 1; j <= floor; j++)
                dp[i][j] = j;  //i部手机在j层摔坏的最坏次数为j次
        }
        for (int i = 2; i <= phone; i++) {
            for (int j = 1; j <= floor; j++) {
                for (int k = 1; k < j; k++)  //从第k层摔下
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1);
            }
        }
    }

    public static void main(String[] args) {
        solve(3, 1000);
        System.out.println(dp[3][1000]);

    }
}
