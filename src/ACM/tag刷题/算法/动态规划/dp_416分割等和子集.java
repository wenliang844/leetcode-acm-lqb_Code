package ACM.tag刷题.算法.动态规划;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp_416分割等和子集 {
    /***
     给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     注意:
     每个数组中的元素不会超过 100
     数组的大小不会超过 200
     示例 1:
     输入: [1, 5, 11, 5]
     输出: true
     解释: 数组可以分割成 [1, 5, 5] 和 [11].
     */
    //方法一:归并排序思想:从大到小,大的先放,然后谁小就放谁那里 特殊 333 45
    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int heap1 = nums[nums.length - 1];
        int heap2 = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (heap1 < heap2) {
                heap1 += nums[i];
            } else {
                heap2 += nums[i];
            }
        }

        return heap1 == heap2;
    }

    //方法二:枚举所有子集,看有没有和sum/2一样大的 超出内存限制
    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;//这是总和的一半

        //在list中加入每一个子集的和
        List<Integer> list = new ArrayList<>();//装子集
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == sum) return true;
            //将子集取出,list.add每一个子集,加上当前数字
            int len = list.size();
            for (int j = 0; j < len; j++) {
                list.add(list.get(j) + nums[i]);
                System.out.println(list);
                if (list.get(j) + nums[i] == sum) return true;
            }
            list.add(nums[i]);
        }


        return false;
    }

    //方法3:动态规划
    //给定一个只包含正整数的非空数组 \textit{nums}[0]nums[0]，判断是否可以从数组中选出一些数字，使得这些数字的和等于整个数组的元素和的一半  01背包问题
    //如果maxNum>sum/2 sum是奇数, len<2 直接不可能false

    /***
     dp[len][target+1]  不选取任何dp[i][0]=true   选取一个数dp[i][nums[0]]=true
     dp[i][j] = dp[i-1[j] | dp[i-1][j-nums[i]]; j>=nums[i]
     dp[i]j]=dp[i-1][j] ; j<nums[i]

     return dp[len-1][target]
     */
    //16 21
    public static boolean canPartition3(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            maxNum = Math.max(maxNum,nums[i]);
        }
        int target = sum/2;
        if (len<2 || maxNum>target || sum%2!=0)return false;//长度小于2,最大值大于了一半,总数是奇数

        //业务逻辑:采用dp[len][taegetr+!];
        //1.初始化dp
        boolean[][] dp = new boolean[len][target+1];//0 1 2 3   ---   0 1 2 3 4 5 6   len=4{1,2,3,6};target = 6
        for (int i = 0; i < len; i++) {//不选取,直接true
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;//选取nums[0]一个数,也是true
        //2.开始从1,1开始,进行dp的迭代
        for (int i = 1; i < len; i++) {


            for (int j = 1; j < target+1; j++) {
                if (j>=nums[i]){//j大,就是target大,选择的余地多
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];

                }else {//taeget小,直接等于前一个tgeget对应的值
                    dp[i][j] = dp[i-1][j];

                }
            }
        }
        printBool(dp);

        return dp[len-1][target];
    }

    /***可以降低空间复杂度,降低到一维
     class Solution {
     public boolean canPartition(int[] nums) {
     int n = nums.length;
     if (n < 2) {
     return false;
     }
     int sum = 0, maxNum = 0;
     for (int num : nums) {
     sum += num;
     maxNum = Math.max(maxNum, num);
     }
     if (sum % 2 != 0) {
     return false;
     }
     int target = sum / 2;
     if (maxNum > target) {
     return false;
     }
     boolean[] dp = new boolean[target + 1];
     dp[0] = true;
     for (int i = 0; i < n; i++) {
     int num = nums[i];
     for (int j = target; j >= num; --j) {
     dp[j] |= dp[j - num];
     }
     }
     return dp[target];
     }
     }
     */
    public static void printBool(boolean[][] flagss){
        for (int i = 0; i < flagss.length; i++) {
            System.out.println(Arrays.toString(flagss[i]));
        }
    }
    public static void main(String[] args) {
        System.out.println(canPartition3(new int[]{1, 2, 3, 6}));//true
        System.out.println(canPartition3(new int[]{1, 5, 11, 5}));//true
        System.out.println(canPartition3(new int[]{1, 2, 3, 5}));//false
        System.out.println(canPartition3(new int[]{3, 3, 3, 4, 5}));//true
        System.out.println(canPartition3(new int[]{1, 2, 5}));//false
        //System.out.println(canPartition3(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
    }
}
