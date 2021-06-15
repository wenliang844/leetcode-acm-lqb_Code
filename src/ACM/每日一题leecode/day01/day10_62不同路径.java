package ACM.每日一题leecode.day01;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**[1*1=0]   [1*2=1]   [2*1==1]
 * dp[2*3] = dp[2*2] + dp[1 * 3]
 *
 * dp[3*7] = dp[3*6] + dp[2*7]
 */
public class day10_62不同路径 {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 7));
        //System.out.println(uniquePaths(51, 9));
        System.out.println(dp2(3, 7));
        System.out.println(dp2(51, 9));
    }

    public static int uniquePaths(int m, int n) {
        return dp(m,n);
    }
    public static int dp(int m, int n) {
        if (m==1){
            return 1;
        }
        if (n==1){
            return 1;
        }
        return dp(m-1,n)+dp(m,n-1);
    }

    public static int dp2(int m, int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            a[i][n-1]=1;
        }
        for (int j = 0; j < n; j++) {
            a[m-1][j] = 1;
        }
        for (int i = m - 2; i >=0; i--) {
            for (int j = n - 2; j >=0; j--) {
                a[i][j] = a[i+1][j]+a[i][j+1];
            }
        }

        return a[0][0];
    }

    public static int dp3(int m,int n){
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}
