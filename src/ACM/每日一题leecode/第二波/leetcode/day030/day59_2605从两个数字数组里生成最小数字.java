package ACM.每日一题leecode.第二波.leetcode.day030;

import ACM.剑指offer_51数组中的逆序对.剑指Offer10_II青蛙跳台阶问题;

import java.util.*;
import java.util.stream.Collectors;

public class day59_2605从两个数字数组里生成最小数字 {
    public static void main(String[] args) {

        System.out.println(minNumber(new int[]{4, 1, 3}, new int[]{5, 7}));//15
        System.out.println(minNumber(new int[]{4, 1, 3}, new int[]{3, 5, 7}));//3
    }

    public static int minNumber(int[] nums1, int[] nums2) {
       Map<Integer,Integer> map = new HashMap();

        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            minOne = Math.min(nums1[i], minOne);
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            minTwo = Math.min(nums2[i], minTwo);
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }

        if (map.size() != nums1.length + nums2.length){
            int res = Integer.MAX_VALUE;
            for (Integer integer : map.keySet()) {
                if (map.get(integer) == 2){
                    res = Math.min(res,integer);
                }
            }
            return res;
        }


        String res = Math.min(minOne, minTwo) + "" + Math.max(minOne, minTwo);
        return Integer.valueOf(res);
    }

    //从两个数组中个取一个数字,组成一个最小的数字,先取最小的数字作为第一个,再取另一个数组中最小的数字
    public static int minNumber2(int[] nums1, int[] nums2) {
        List list1 = Arrays.asList(nums1);
        List list2 = Arrays.asList(nums2);

        int minOne = (int) Collections.min(list1);
        int minTwo = (int) Collections.min(list2);
        List<Integer> intersection = (List<Integer>) list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());

        if (!intersection.isEmpty()) {
            return Collections.min(intersection);
        }
        String res = Math.min(minOne, minTwo) + "" + Math.max(minOne, minTwo);
        return Integer.valueOf(res);
    }
}
