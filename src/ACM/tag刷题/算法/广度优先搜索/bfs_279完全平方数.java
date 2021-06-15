package ACM.tag刷题.算法.广度优先搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bfs_279完全平方数 {

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * <p>
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * <p>
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     */

    /***
     这道题如果知道数学定理之后，相当于告诉你：

     任何正整数都可以拆分成不超过4个数的平方和 ---> 答案只可能是1,2,3,4
     如果一个数最少可以拆成4个数的平方和，则这个数还满足 n = (4^a)*(8b+7) ---> 因此可以先看这个数是否满足上述公式，如果不满足，答案就是1,2,3了
     如果这个数本来就是某个数的平方，那么答案就是1，否则答案就只剩2,3了
     如果答案是2，即n=a^2+b^2，那么我们可以枚举a，来验证，如果验证通过则答案是2
     只能是3


     f(n) = 1 + min{
     f(n-1^2), f(n-2^2), f(n-3^2), f(n-4^2), ... , f(n-k^2) //(k为满足k^2<=n的最大的k)
     int numSquares(int n) {
     vector<int> f(n+1, 0);//n+1大小，f[0]为0
     for (int i = 1; i <= n; i++) {//从f[1]开始计算
     int minVal = INT_MAX;
     for ( int j = 1; j*j <= i ; j++ )  minVal = min(minVal, f[i - j*j]);
     f[i] = minVal + 1;
     }
     return f[n];
     }

     int numSquares(int n) {
     vector<int> dp(n+1,INT_MAX);
     dp[0]=0;
     for(int i=1;i<=n;++i)
     for(int j=1;j*j<=i;++j)
     {
     dp[i]=min(dp[i],dp[i-j*j]+1);
     }
     return dp[n];

     转化成容量为n，物品重量为小于n的所有平方数的完全背包问题
     这题跟322零钱兑换是一样的，只不过coin[j]换成了j*j
     */


    public static int numSquares(int n) {
        if (n <= 3) return n;
        //if (n==43)return 3;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; ; i++) {
            if (i * i <= n) {
                list.add(i * i);
            } else {
                break;
            }
        }
        System.out.println(list);

        //从list.size -1开始+,直到=n
        int count = 10000;
        for (int i = list.size() - 1; i > 0; i--) {
            int countTemp = 0;
            int max = 0;
            int j = i;
            while (j >= 0) {
                System.out.println(max + "-" + countTemp + "-" + i + "-" + j);
                max += list.get(j);//max+i
                countTemp++;
                if (max/*+list.get(j)*/ == n) {
                    System.out.println("相等了"+max + "-" + countTemp + "-" + i + "-" + j);
                    //countTemp++;
                    break;
                } else if (max/*+list.get(j)*/ > n) {//大于了,反悔,不加list[j]了,加下一个,conut--
                    max -= list.get(j);
                    countTemp--;
                    j--;
                }

            }
            count = Math.min(count, countTemp);
        }

        //if (n>=43)return count-1;
        return count;
    }

    //方法二:动态规划递推 d[0]=0 d[1]=min(d(1-j*j))+1  --j*j<=i d[i]=min{d(i-j*j)}
    //numSquares(n)=min(numSquares(n-k) + 1)∀k∈square numbers
    public static int numSquares2(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min,dp[i-j*j]);
            }
            dp[i]=min+1;
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    /***
     13   13-1 13-4 13-9  减完后还是一个完全平方数,则是正确的解法
     12 9   4
        需要一个queue  next_queue  用set类型,减少每一层的冗余,可以5倍提速
     * @param n
     * @return
     */
    //方法三:bfs广度优先算法,谁先到叶子节点,直接returnstep +贪心
    public int numSquares3(int n) {

        return 0;
    }

    /****
     方法五:数学证明
     protected boolean isSquare(int n) {
     int sq = (int) Math.sqrt(n);
     return n == sq * sq;
     }

     public int numSquares(int n) {
     // four-square and three-square theorems.
     while (n % 4 == 0)
     n /= 4;
     if (n % 8 == 7)
     return 4;

     if (this.isSquare(n))
     return 1;
     // enumeration to check if the number can be decomposed into sum of two squares.
     for (int i = 1; i * i <= n; ++i) {
     if (this.isSquare(n - i * i))
     return 2;
     }
     // bottom case of three-square theorem.
     return 3;
     }
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(numSquares(13));
       // System.out.println(numSquares(12));
       // System.out.println(numSquares(1));
        //System.out.println(numSquares(2));
        //System.out.println(numSquares(3));
        //System.out.println(numSquares(4));
        System.out.println(numSquares2(13));
        System.out.println(numSquares2(43)); //[1,4,9,16,25,36] //可以等于25 9 9
        System.out.println(numSquares2(67));//96
    }
}
