package ACM.tag刷题.算法.动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

public class dp_152乘积最大子数组 {

    /***
     给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     输入: [2,3,-2,4]
     输出: 6
     解释: 子数组 [2,3] 有最大乘积 6。
     示例 2:

     输入: [-2,0,-1]
     输出: 0
     解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    //方法一,暴力破解:双循环 × :求的是连续子数组
    public static int maxProduct(int[] nums) {

        int maxProduct = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                maxProduct = Math.max(maxProduct, nums[i] * nums[j]);
            }
        }
        return maxProduct;
    }

    //方法二:贪心算法,如果负数直接等于1,正数保留 114/187
    public static int maxProduct2(int[] nums) {
        int maxMul = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mul = nums[i - 1] * nums[i];
            if (mul <= 0) {
                maxMul = Math.max(maxMul, nums[i - 1]);
                // nums[i]=1;
            } else {
                nums[i] = mul;
            }
        }
        maxMul = Math.max(maxMul, nums[nums.length - 1]);
        return maxMul;
    }

    //没有0之后的子数组处理成最大值
    public static int getMax(int[] nums, int left, int right) {
        //1.先判断负数的个数是奇数还是偶数
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] < 0) count++;
        }
        int sum = 1;
        if (count % 2 != 0) {//奇数
            int sum1 = 1;
            int sum2 = 1;

            int index1 = 0;
            int index2 = 0;
            for (int i = left; i <= right; i++) {
                sum1 *= nums[i];
                if (nums[i] < 0) {
                    index1 = i + 1;
                    break;
                }
            }
            for (int i = right; i >= left; i--) {
                sum2 *= nums[i];
                if (nums[i] < 0) {
                    index2 = i - 1;
                    break;
                }
            }
            for (int i = index1; i <= index2; i++) {
                sum *= nums[i];
            }
            if (Math.abs(sum1) > Math.abs(sum2)) {
                sum *= sum1;
            } else {
                sum *= sum2;
            }

        }
        System.out.println("这是通过getmax求出的sum=" + sum);
        return sum;
    }

    /***
     一个数组没有0存在:
     1.负数偶数个,所有乘积
     2.负数奇数个,从左开始,乘到左后一个为止有一个最大值,右边开始也有一个,比较
     有0,则0分隔,求子数组的最大值
     */

    //方法三:以0为中心,切两半处理,没有0之后,直接判断0的个数, 奇数就去掉两边最近零最小的一个
    public static int maxProduct3(int[] nums) {
        if (nums.length <= 1) return nums[0];
        int maxSum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxSum = Math.max(getMax(nums, index, i - 1), maxSum);
                index = i + 1;
            }
        }
        maxSum = Math.max(getMax(nums, index, nums.length - 1), maxSum);
        return maxSum;
    }
    //方法4:动态规划成子问题 dp[i][j] =

    /***
     参考最大序列和可以得出dp[i] = max(dp[i-1]*i,i)
     但是有负负得正的情况存在,所以需要加入几种情况 比如5,4,-2,3,-5
     需要记录前面负值最小的情况
     不难得到
     max(i-1)*i , i ,min{i-1}*i)
     min(i-1=1,i,max(i-1)*i)
     */
    //dp:4131   同时维护一个最小值数组,当负负为正的时候用的上
    public static int maxProduct4(int[] nums) {
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDP[i] = Math.max(maxDP[i - 1] * nums[i], Math.max(nums[i], minDP[i - 1] * nums[i]));
            minDP[i] = Math.min(minDP[i - 1] * nums[i], Math.min(nums[i], maxDP[i - 1] * nums[i]));
        }
        System.out.println(Arrays.toString(maxDP));
        System.out.println(Arrays.toString(minDP));
        //答案就在maxDP中的数组中的最大值中,一般在最后一个,但不是绝对的,所以需要比较得出
        int ans = maxDP[0];
        for (int i = 1; i < maxDP.length; i++) {
            ans = Math.max(ans, maxDP[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct4(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct4(new int[]{-2, 0, -1}));
        System.out.println(maxProduct4(new int[]{2, 0, 1}));
        System.out.println(maxProduct4(new int[]{2, 4, 1}));
        System.out.println(maxProduct4(new int[]{-2}));
        System.out.println(maxProduct4(new int[]{-2, 3, -4}));//贪心不适合用
        System.out.println("-----------------测试dp");
        System.out.println(maxProduct4(new int[]{4, 5, -1, -2, 3}));
        System.out.println(maxProduct4(new int[]{2,-5,-2,-4,3}));
    }
}
