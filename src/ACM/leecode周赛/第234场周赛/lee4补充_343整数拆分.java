package ACM.leecode周赛.第234场周赛;

public class lee4补充_343整数拆分 {
    /***
     给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     */

    //整数拆分 100 30   这是数不大的情况,当数字大的时候,如何创建一个几千的数组长度?
    //dp动态规划法   curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
    public static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            int a[] = new int[n + 1];
            a[1] = 1;
            a[2] = 2;
            a[3] = 3;
            for (int i = 4; i <= n; i++) {
                //从a[4]开始 求解 a[4] = a[3]*a[4-3] a[2]*a[4-2]
                int maxNum = 0;
                for (int j = i - 1; j >= 0; j--) {//i/2-1
                    if (a[j] * a[i - j] > maxNum) {
                        maxNum = a[j] * a[i - j];
                    } else {
                        //System.out.println("这是i="+i+"这是采用的j="+(j));
                        break;
                    }
                }
                a[i] = maxNum;
            }

            //System.out.println(Arrays.toString(a));
            return (int) (a[n] % ((int) Math.pow(10, 9) + 7));
        }
    }

    /***
     数学推导法:
     class Solution {
     public int integerBreak(int n) {
     if(n <= 3) return n - 1;
     int a = n / 3, b = n % 3;
     if(b == 0) return (int)Math.pow(3, a);
     if(b == 1) return (int)Math.pow(3, a - 1) * 4;
     return (int)Math.pow(3, a) * 2;
     }
     }

     作者：jyd
     链接：https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(10));
    }
}
