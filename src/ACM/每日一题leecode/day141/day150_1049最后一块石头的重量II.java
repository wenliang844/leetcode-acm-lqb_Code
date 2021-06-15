package ACM.每日一题leecode.day141;

import java.util.Arrays;
import java.util.Comparator;

public class day150_1049最后一块石头的重量II {
    public static void main(String[] args) {
        System.out.println(lastStoneWeightII2(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeightII2(new int[]{31,26,33,21,40}));//5
        System.out.println(lastStoneWeightII2(new int[]{2,1,6,4,5}));//0
    }

    //方法一:从大到小,缩小规模
    public static int lastStoneWeightII(int[] stones) {
        //从后面出发,将最后的俩个值相减,如果是0直接跳过,如果不是则差值进行交换
        Arrays.sort(stones);
        System.out.println(Arrays.toString(stones));
        int len = stones.length;
        if (len%2!=0){
            int tmep = stones[len-1]-stones[0];
            stones[0]=tmep;
            len--;
            for (int i = 1; i < len; i++) {
                if (stones[i]<stones[i-1]){
                    int tp = stones[i];
                    stones[i] = stones[i-1];
                    stones[i-1]=tp;
                }else {
                    break;
                }
            }

        }
        for (int i = len-1; i >0; i--) {
            int temp = stones[i]-stones[i-1];
            stones[i-1] = temp;
            if (temp==0){
                i--;
            }else {
                //将i-1这个数进行和前面的数交换,直到>=前面的数
                for (int j = i-2; j >=0; j--) {
                    if (stones[j]>stones[j+1]){
                        int tmp = stones[j+1];
                        stones[j+1] = stones[j];
                        stones[j] = tmp;
                    }else {
                        break;
                    }
                }
            }

            System.out.println(Arrays.toString(stones));
        }
        return stones[0];
    }

    //方法二:转变成01背包问题,最多装sum/2 最大装多少,贪心,直接从最大开始取,对半分,最后sum1 2的差值
    public static int lastStoneWeightII2(int[] stones) {
        int sum1 = 0;
        int sum2 = 0;
        int sum = 0;
        Arrays.sort(stones);
        for (int i = stones.length-1; i >=0; i--) {
            sum+=stones[i];
            if (sum1<sum2){
                sum1+=stones[i];
            }else {
                sum2+=stones[i];
            }
        }
        //return Math.abs(sum1-sum2);
        return Math.abs(sum-Math.max(sum1,sum2)-Math.max(sum1,sum2));

    }
    //方法二:转变成01背包问题,最多装sum/2 最大装多少,贪心,直接从最大开始取,对半分,最后sum1 2的差值
    public static int lastStoneWeightII3(int[] stones) {
        int sum1 = 0;
        int sum2 = 0;
        int sum = 0;
        Arrays.sort(stones);
        for (int i = stones.length-1; i >=0; i--) {
            sum+=stones[i];
            if (sum1<sum2){
                sum1+=stones[i];
            }else {
                sum2+=stones[i];
            }
        }
        //return Math.abs(sum1-sum2);
        return Math.abs(sum-Math.max(sum1,sum2)-Math.max(sum1,sum2));

    }
    /***
     class Solution {
     public int lastStoneWeightII(int[] ss) {
     int n = ss.length;
     int sum = 0;
     for (int i : ss) sum += i;
     int t = sum / 2;
     int[][] f = new int[n + 1][t + 1];
     for (int i = 1; i <= n; i++) {
     int x = ss[i - 1];
     for (int j = 0; j <= t; j++) {
     f[i][j] = f[i - 1][j];
     if (j >= x) f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + x);
     }
     }
     return Math.abs(sum - f[n][t] - f[n][t]);
     }
     }

     作者：AC_OIer
     链接：https://leetcode-cn.com/problems/last-stone-weight-ii/solution/gong-shui-san-xie-xiang-jie-wei-he-neng-jgxik/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     class Solution {
     public int lastStoneWeightII(int[] ss) {
     int n = ss.length;
     int sum = 0;
     for (int i : ss) sum += i;
     int t = sum / 2;
     int[] f = new int[t + 1];
     for (int i = 1; i <= n; i++) {
     int x = ss[i - 1];
     for (int j = t; j >= x; j--) {
     f[j] = Math.max(f[j], f[j - x] + x);
     }
     }
     return Math.abs(sum - f[t] - f[t]);
     }
     }

     作者：AC_OIer
     链接：https://leetcode-cn.com/problems/last-stone-weight-ii/solution/gong-shui-san-xie-xiang-jie-wei-he-neng-jgxik/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
