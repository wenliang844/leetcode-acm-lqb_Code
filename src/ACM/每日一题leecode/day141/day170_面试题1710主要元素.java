package ACM.每日一题leecode.day141;

import java.util.HashMap;
import java.util.Map;

public class day170_面试题1710主要元素 {

    /****
     数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
     示例 1：
     输入：[1,2,5,9,5,9,5,5,5]
     输出：5
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(majorityElement2(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(majorityElement2(new int[]{3,2,3}));
    }

    //方法一:计数
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
           if (map.get(nums[i])!=null){
               map.put(nums[i],map.get(nums[i]));
               count = Math.max(map.get(nums[i]),count);
           }else {
               map.put(nums[i],1);
           }
        }
        //System.out.println(map);
        return count>nums.length/2?count:-1;
    }

    //方法二:计数优化,次数达到了a.length即退出 13 47
    public static int majorityElement2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
           if (map.get(nums[i])>nums.length/2){
               //System.out.println(map.get(nums[i]));
               return nums[i];
           }
        }
        return -1;
    }

    //方法三:排序取中
    public static int majorityElement3(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
           if (map.get(nums[i])>nums.length/2){
               //System.out.println(map.get(nums[i]));
               return nums[i];
           }
        }
        return -1;
    }

    //官方:摩尔投票法
    public static int majorityElement4(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        int length = nums.length;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count * 2 > length ? candidate : -1;
    }
}
