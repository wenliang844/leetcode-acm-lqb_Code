package ACM.leecode周赛.第234场周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lee4_5716好因子的最大数目 {

    /****
     给你一个正整数 primeFactors 。你需要构造一个正整数 n ，它满足以下条件：
     n 质因数（质因数需要考虑重复的情况）的数目 不超过 primeFactors 个。
     n 好因子的数目最大化。如果 n 的一个因子可以被 n 的每一个质因数整除，我们称这个因子是 好因子 。比方说，如果 n = 12 ，那么它的质因数为 [2,2,3] ，那么 6 和 12 是好因子，但 3 和 4 不是。
     请你返回 n 的好因子的数目。由于答案可能会很大，请返回答案对 109 + 7 取余 的结果。
     请注意，一个质数的定义是大于 1 ，且不能被分解为两个小于该数的自然数相乘。一个数 n 的质因子是将 n 分解为若干个质因子，且它们的乘积为 n 。

     示例 1：
     输入：primeFactors = 5
     输出：6
     解释：200 是一个可行的 n 。
     它有 5 个质因子：[2,2,2,5,5] ，且有 6 个好因子：[10,20,40,50,100,200] 。
     不存在别的 n 有至多 5 个质因子，且同时有更多的好因子。
     示例 2：
     */

    /**
     * 思路:就是选取peime 的组合数的最大值
     * 1 1种
     * 2 22 =2种
     * 3 333 3种
     * 4 2222 4
     * 1222 1*3=3
     * 5 5可以拆22222 5  6种
     * 22225 1*4=4
     * 22255 2*3=6
     * 22335 2*2*1=4
     * 6   3*3=9
     * 7 = 2*2*3=12  a[5]*a[2]
     * 8 22222222 8     16种
     * 22233355 2*3*3=18
     * 22225555 4*4=16
     * 9 =a[8]*a[1] a[7]*a[2]=24 a[6]*a[3]=3*3*3=27
     * 10 2223335555=36
     * 5*5=25
     * 11=a[10]*a[1] a[9]*a[2]=54  a[8]a[3]54 a[7]*a[4]=48
     */

    //超出内存限制
    public static int maxNiceDivisors(int primeFactors) {

        if (primeFactors == 2) {
            return 2;
        } else if (primeFactors == 3) {
            return 3;
        } else if (primeFactors == 1) {
            return 1;
        } else {
            long a[] = new long[primeFactors + 1];
            a[1] = 1;
            a[2] = 2;
            a[3] = 3;
            for (int i = 4; i <= primeFactors; i++) {
                //从a[4]开始 求解 a[4] = a[3]*a[4-3] a[2]*a[4-2]
                long maxNum = 0;
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
            return (int) (a[primeFactors] % ((int) Math.pow(10, 9) + 7));
        }


    }

    //用list  ->超出内存限制
    public static int maxNiceDivisors2(int primeFactors) {

        if (primeFactors == 2) {
            return 2;
        } else if (primeFactors == 3) {
            return 3;
        } else if (primeFactors == 1) {
            return 1;
        } else {
            List<Long> a = new ArrayList<>();
            a.add((long) 0);
            a.add((long) 1);
            a.add((long) 2);
            a.add((long) 3);

            for (int i = 4; i <= primeFactors; i++) {
                //从a[4]开始 求解 a[4] = a[3]*a[4-3] a[2]*a[4-2]
                long maxNum = 0;
                for (int j = i - 1; j >= 0; j--) {//i/2-1
                    if (a.get(j) * a.get(i - j) > maxNum) {
                        maxNum = a.get(j) * a.get(i - j);
                    } else {
                        break;
                    }
                }
                a.add(maxNum);
            }

            //System.out.println(Arrays.toString(a));
            return (int) (a.get(primeFactors) % ((int) Math.pow(10, 9) + 7));
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

     推论一： 若拆分的数量 aa 确定， 则 各拆分数字相等时 ，乘积最大。
     推论二： 将数字 nn 尽可能以因子 33 等分时，乘积最大。


     作者：jyd
     链接：https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */

    //双100
    public static int maxNiceDivisors3(int primeFactors) {
        double modN =  (1e9 + 7);
        if (primeFactors <= 3) {
            return primeFactors;
        } else {
            int a = primeFactors / 3, b = primeFactors % 3;
            if (b == 0) {
                return (int) ((myPow(3, a) ) % modN);
            } else if (b == 1) {
                return (int) ((myPow(3, a - 1) * 4) % modN);
            } else {
                return (int) ((myPow(3, a) * 2) % modN);
            }
        }

        // return 0;
    }
    static long myPow( long x, int n) {
        int modN = (int) (1e9 + 7);
        long ans = 1;
        n = Math.abs(n);
        while(n!=0){
            if(n % 2 != 0){
                ans *= x;
                ans %= modN;
            }
            x *= x;
            x %= modN;
            n /= 2;
        }
        return ans;
    }


    public static void main(String[] args) {
        //System.out.println(maxNiceDivisors(1));
        //System.out.println(maxNiceDivisors(2));
        //System.out.println(maxNiceDivisors(3));
        //System.out.println(maxNiceDivisors(4));
        System.out.println(maxNiceDivisors3(5));
        System.out.println(maxNiceDivisors3(6));
        System.out.println(maxNiceDivisors3(7));
        System.out.println(maxNiceDivisors3(8));
        System.out.println(maxNiceDivisors3(9));
        System.out.println(maxNiceDivisors3(10));
        System.out.println(maxNiceDivisors3(11));
        System.out.println(maxNiceDivisors3(12));//81


        System.out.println(maxNiceDivisors3(64));
        System.out.println(maxNiceDivisors3(73));
        System.out.println(maxNiceDivisors3(74));
        System.out.println(maxNiceDivisors3(75));
        System.out.println(maxNiceDivisors3(545918790));
        System.out.println(maxNiceDivisors3(545918790));//421090465
        System.out.println(maxNiceDivisors3(83));//421090465

    }

    /***
     *
     // 暴力解法
     public int integerBreak(int n) {
     if (n == 2) {
     return 1;
     }
     int res = -1;
     for (int i = 1; i <= n - 1; i++) {
     res = Math.max(res, Math.max(i * (n - i), i * integerBreak1(n - i)));
     }
     return res;
     }
     这题还可以这样想，对于给定的数 n，F(n)F(n) 表示将 n 分解成多个(≥2)整数的最大乘积，那么有以下几种情况：
     1️⃣ 将n分解成两个数:

     F(n)=i* (n - i),\ (i=1,2,...,n-1)
     F(n)=i∗(n−i), (i=1,2,...,n−1)

     2️⃣ 将n分解成两个以上的数:
     也就是说我们要对 i 和 n - i 进一步分解，那么就有三种情况（继续分解其中一个或两个都继续分解），将i和n - i进一步分解的最大乘积分别记为 F(i)F(i)和F(n - i)F(n−i)，那么有：

     F(n)=max\left\{ \begin{array}{rcl} i * F(n - i) & & {对\ n - i\ 继续分解}\\ F(i) * (n - i) & & {对\ i\ 继续分解}\\ F(i) * F(n- i) & & {对\ i 和\ n - i\ 都继续分解} \end{array} \right.
     F(n)=max
     ⎩
     ⎪
     ⎨
     ⎪
     ⎧
     ​

     i∗F(n−i)
     F(i)∗(n−i)
     F(i)∗F(n−i)
     ​

     ​

     对 n−i 继续分解
     对 i 继续分解
     对 i和 n−i 都继续分解
     ​


     但是，我们观察上面的表达式，不难发现，当i取遍[1,n-1][1,n−1]时，由于i和n - i的取值对称，i * F(n - i)i∗F(n−i) 和 F(i) * (n - i)F(i)∗(n−i)的取值集合是一样的，也就是说这两种情况算出来的结果是一样的，所以只取其中一种就可以了。对于F(i)*F(n-i)F(i)∗F(n−i)，其实这种情况也是不用考虑的，因为 i*(n - i)i∗(n−i)和i * F(n - i)i∗F(n−i)已经包含了所有的分解情况了。那么整个表达式就为：

     F(n) = max\{ i * (n - i), i * F(n - i)\},\ (i=1,2,...,n-1)
     F(n)=max{i∗(n−i),i∗F(n−i)}, (i=1,2,...,n−1)
     2. 记忆化搜索（备忘录）
     对于暴力搜索，通过图1不难得出该方法的时间复杂度为指数级别，显然不能满足题目要求。那么如此耗时的原因也是因为在递归的过程中计算了很多 重复值。例如，图 1 中 F(n-2)F(n−2)和F(n-3)F(n−3) 至少重复计算了两次，并且在后面会有更多次重复运算，而这部分重复运算完全是没有必要的，如果我们每次求完一个 F(i)F(i)，都将其保存起来，下次再求的时候直接读取保存的值就行了，这显然会节省大量时间。既然有这个想法，那么相应的代码应该也不难实现，我们只要用一个数组存放每次的 F(i)F(i)，记为memory，这个数组我们一般称之为 备忘录数组，具体实现如下：

     Java

     // 记忆化搜索-自顶向下
     int[] memory;
     public int integerBreak(int n) {
     memory = new int[n + 1];
     return integerBreakHelper(n);
     }
     public int integerBreakHelper(int n) {
     if (n == 2) {
     return 1;
     }
     // memory的初始值为0，如果它不为0，说明已经计算过了，直接返回即可
     if (memory[n] != 0) {
     return memory[n];
     }
     int res = -1;
     for (int i = 1; i <= n - 1; i++) {
     res = Math.max(res, Math.max(i * integerBreakHelper(n - i), i * (n - i)));
     }
     // 将每次计算的结果保存到备忘录数组中
     memory[n] = res;
     return res;
     }
     通过上述代码我们可以看出，记忆化搜索是将目标 F(n)F(n) 不断转化为求 F(n-1)F(n−1),F(n - 2)F(n−2),...,F(2)F(2),F(1)F(1)，过程中将计算过的值存起来，从图1的递归树中看出来这是一个从上到下的过程，一般将之称为 自顶向下。

     3. 动态规划
     其实，方法2已经满足的题目的要求。但是对于这样的一个递归代码，我们更习惯转化为递推，将自顶向下的思路转换为自底向上，这也是记忆化搜索和DP之间的区别所在。
     代码如下：

     Java

     // 动态规划
     public int integerBreak3(int n) {
     memory[2] = 1;
     for (int i = 3; i <= n; i++) {
     for ( int j = 1; j <= i - 1; j++) {
     memory[i] = Math.max(memory[i], Math.max(j * memory[i - j], j * (i - j)));
     }
     }
     return memory[n];
     }

     作者：97wgl
     链接：https://leetcode-cn.com/problems/integer-break/solution/bao-li-sou-suo-ji-yi-hua-sou-suo-dong-tai-gui-hua-/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
