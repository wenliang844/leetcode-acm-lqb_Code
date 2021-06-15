package ACM.每日一题leecode.day66;

import java.util.*;

public class day82_456132模式 {
    /***
     给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数
     nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false
     进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
     */

    /***
     思路:定义3个变量,动态变化
     找出一个最小值, 一个i从前面开始找,一个j从后面开始找 132
     最小值为1,保持为1,   找到一个i是大于j j又大于前面的最小值min的,true
     min < nums[j] && nums[j]<nums[i]
     * @param nums
     * @return
     */
    //方法一:暴力枚举 :可以不连续的
    public static boolean find132pattern(int[] nums) {

        //先去重,再进行操作
        /*Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int[] nums2 = new int[set.size()];
        int index =0;
        for (Integer integer : set) {
            nums2[index++] = integer;
        }*/



        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length-2; i++) {
            if (i>0 && nums[i]==nums[i-1]){//如果和前一个一样,直接退出
                continue;
            }
            for (int j = i+1; j < nums.length - 1; j++) {
                if (nums[i] < nums[j]){//保证是升序的
                    for (int k = j+1; k < nums.length; k++) {//第三个数在中间,就是true
                        if (nums[k] >nums[i] && nums[k]<nums[j]){
                            //System.out.println(nums[i]+"-"+nums[j]+"-"+nums[k]);
                            return true;
                        }

                    }
                }

            }
        }

        return false;
    }

    //方法二:降维
    public static boolean find132pattern2(int[] nums) {
        int len = nums.length;
        if (nums.length<3){
            return false;
        }
        int min = nums[0];
        for (int i = 0; i < len; i++) {
            min = Math.min(min,nums[i]);//找到最小值即1
            if (min == nums[i]){
                continue;//等于最小值,那么进行下一次遍历,   是最小值,那么一定可以是第一个数
            }
            for (int j = len-1; j > i; j--) {//从后面开始找
                if (min < nums[j] && nums[j]<nums[i]){//出现32 true {min num[i] num[j] }
                    return true;
                }

            }
        }

        return false;
    }

    //方法三:栈
    public static boolean find132pattern3(int[] nums) {
        int n = nums.length;
        int last = Integer.MIN_VALUE;//132中的2 最后一个数
        Stack<Integer> stack = new Stack<>();//存储132中的3
        for (int i = n-1; i >=0; i--) {
            if (nums[i]<last){
                return true;//出现132总的1则返回正确
            }
            //当前值大于等于2,则更新2(2是栈中小于当前值的最大元素)
            while (!stack.isEmpty() && stack.peek()<nums[i]){
                last = stack.pop();
            }

            //将当前值入栈
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern3(new int[]{1, 2, 3, 4}));
        System.out.println(find132pattern3(new int[]{1, 3, 2, 4}));
        System.out.println(find132pattern3(new int[]{4, 3, 2, 1}));
        System.out.println(find132pattern3(new int[]{3,5,0,3,4}));
    }

}
