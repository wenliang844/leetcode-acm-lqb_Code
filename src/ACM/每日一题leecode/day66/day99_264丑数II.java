package ACM.每日一题leecode.day66;

import java.lang.reflect.Array;
import java.util.Arrays;

public class day99_264丑数II {
    /***
     给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     示例 1：
     输入：n = 10
     输出：12
     解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
     */
    //动态规划:递推 22 12
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        //ugly[1] = 1;
        int i = 0;
        int j = 0;
        int k = 0;
        for (int l = 1; l < n; l++) {
            int temp = Math.min(ugly[i] * 2, Math.min(ugly[j] * 3, ugly[k] * 5));
            if (temp == ugly[i] * 2) i++;
            if (temp == ugly[j] * 3) j++;
            if (temp == ugly[k] * 5) k++;
            ugly[l] = temp;
        }
        System.out.println(Arrays.toString(ugly));
        return ugly[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
