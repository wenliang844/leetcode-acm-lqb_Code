package ACM.每日一题leecode.day141;

import java.util.Arrays;
import java.util.HashMap;

public class day145_523连续的子数组和 {
    /****
     给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     子数组大小 至少为 2 ，且
     子数组元素总和为 k 的倍数。
     如果存在，返回 true ；否则，返回 false 。
     如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
     示例 1：
     输入：nums = [23,2,4,6,7], k = 6
     输出：true
     解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
     */
    public static void main(String[] args) {
        System.out.println(checkSubarraySum2(new int[]{23, 2, 4, 6, 7}, 6));//t
        System.out.println(checkSubarraySum2(new int[]{23, 2, 4, 6, 6}, 7));//t
        System.out.println(checkSubarraySum2(new int[]{0}, 1));//f
        System.out.println(checkSubarraySum2(new int[]{5,0,0,0}, 3));//f
    }

    //方法一:暴力解法,每个数字都可以作为起点
    public static boolean checkSubarraySum(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];//也可以设置为第一个数字
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                //System.out.println(sum);
                if (sum % k == 0) {
                    //System.out.println(i+"--"+j+"***"+nums[i]+"--"+nums[j]+"=="+sum);
                    return true;
                }
            }
        }

        return false;
    }

    //方法二:前缀和
    public static boolean checkSubarraySum2(int[] nums, int k) {

        int len = nums.length;
        int[] pre = new int[len+1];
        pre[0] = 0;
        for (int i = 1; i < nums.length+1; i++) {
            pre[i] = pre[i-1]+nums[i-1];
        }
        //System.out.println("pre=="+Arrays.toString(pre));

        //利用前缀和求区间
        for (int i = 2; i < len+1; i++) {
            if (pre[i] %k==0){
                return true;
            }
            for (int j = 0; j <= i - 2; j++) {
                if ((pre[i]-pre[j]) %k==0){
                    return true;
                }
            }

        }

        return false;
    }

    /*****
     【同余定理】 【哈希表】【简化前缀和】
     同余定理：如果两个整数m、n满足n-m能被k整除，那么n和m对k同余

     即 ( pre(j) - pre (i) ) % k == 0 则 pre(j) % k == pre(i) % k推导 => pre (i) % k = (a0 + a1 + ... + ai) % k = (a0 % k + a1 % k + ... ai % k ) % k （该推导在简化前缀和的时候有用，说明当前前缀和 % k 不会影响后面的前缀和 % k ）

     哈希表 存储 Key ：pre(i) % k
     Value： i

     遍历过程：
     计算前缀和 pre( j ) % k
     当pre(j) % k 在哈希表中已存在，则说明此时存在 i 满足 pre(j) % k == pre(i) % k ( i < j )
     HashMap里，已知Key，可以取到Value 即i的值， 最后 判断 j - i >= 2 是否成立 即可
     当 pre(j) % k 不存在于哈希表，则将 (pre(j) % k, j ) 存入哈希表
     因在计算 pre(i) = (pre(i-1) + nums[i]) % k 时，pre(i) 只与上一个状态有关
     故可以直接用变量pre 替代数组。 那么 求前缀和 % k 的公式就简化为 题解代码中的 remainder = (remainder + nums[i]) % k;
     */
    //81 53
    public static boolean checkSubarraySum3(int[] nums, int k) {

        int len = nums.length;
        int[] pre = new int[len+1];
        for (int i = 1; i < nums.length+1; i++) {
            pre[i] = pre[i-1]+nums[i-1];
        }
        //System.out.println("pre=="+Arrays.toString(pre));

        //利用前缀和求区间--暴力超时了
       /* for (int i = 2; i < len+1; i++) {
            if (pre[i] %k==0){
                return true;
            }
            for (int j = 0; j <= i - 2; j++) {
                if ((pre[i]-pre[j]) %k==0){
                    return true;
                }
            }

        }*/

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<pre.length; i++){
            if(hashMap.containsKey(pre[i] % k)){
                int recent = hashMap.get(pre[i] % k);
                if(i - recent >= 2){
                    return true;
                }
            }else{
                hashMap.put(pre[i]%k, i);
            }
        }

        return false;
    }
}
