package ACM.leecode周赛.第233场周赛;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lee3_5711有界数组中指定下标处的最大值 {
    /**
     * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
     * <p>
     * nums.length == n
     * nums[i] 是 正整数 ，其中 0 <= i < n
     * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
     * nums 中所有元素之和不超过 maxSum
     * nums[index] 的值被 最大化
     * 返回你所构造的数组中的 nums[index] 。
     * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x
     * <p>
     * 输入：n = 4, index = 2,  maxSum = 6
     * 输出：2
     * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
     */

    public static int maxValue(int n, int index, int maxSum) {

        /***
         思路:方程
         4 2 6

         x-2 x-1   x  x-1

         4x< 6+4
         x=2
         */

        int sum = maxSum;

        //左边 index位数
        //右边 len - index - 1位
        int left = index;
        while (left > 0) {
            sum += left;
            left--;
        }
        int right = n - index - 1;
        while (right > 0) {
            sum += right;
            right--;
        }
        System.out.println(sum);

        int result = sum / n;//最大可承受值
        System.out.println("这个最大可承受值result=="+result);

        while (result > 0) {
            int a[] = new int[n];
            a[index] = result;
            for (int i = index + 1; i < a.length; i++) {
                if (a[i - 1] > 1) {
                    a[i] = a[i - 1] - 1;
                } else {
                    a[i] = a[i - 1];
                }
            }
            for (int i = index - 1; i >= 0; i--) {
                if (a[i + 1] > 1) {
                    a[i] = a[i + 1] - 1;
                } else {
                    a[i] = a[i + 1];
                }
            }

            //System.out.println(Arrays.toString(a));
            int sum2 = 0;
            for (int i = 0; i < a.length; i++) {
                sum2 += a[i];
            }
            System.out.println("这是计算的sum2==" + sum2);
            if (sum2 <= maxSum) {
                return result;
            } else {
                result--;
            }
        }

        return 0;


    }

    public static int calc_sum(int low,int high){
        if ((low+high)%2==0){
            return ((low+high)/2)*(low-high+1);
        }else {
            return (((low+high)/2)+((low+high)/2+1))*((low-high)/2+1);
        }
    }
    //求和函数
    public static int calc(int n,int index,int maxNum){
        int sum = 0;
        int left = index; //2个数
        int right = n-index; //3个数
        //暴力
        if (left >= maxNum-1){
            sum += calc_sum(1,maxNum);
            sum += maxNum-left;
        }else{
            sum += calc_sum(maxNum-left,maxNum);
        }

        return sum;
    }
    //求最大值函数 二分法
    public static int calc_max(int low,int high,int n,int index,int maxSum){
        while (low < high){
           if (calc(n,index,(low+high)/2)<maxSum){
               low = (low+high)/2;
           }else {
               high = (low+high)/2;
           }
        }

        return low;
    }
    public static int maxValue2(int n, int index, int maxSum) {//4 2 6

        /***
         思路:用2分
         */

        return calc_max(1,maxSum,n,index,maxSum);


    }

    public static void main(String[] args) {

        System.out.println(maxValue2(4, 2, 6));
        System.out.println(maxValue2(6, 1, 10));
        System.out.println(maxValue2(8, 7, 14));
        System.out.println(maxValue2(6, 1, 10));
        System.out.println(maxValue2(8257285, 4828516,850015631));
    }


}
