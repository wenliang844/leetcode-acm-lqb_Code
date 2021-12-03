package ACM.每日一题leecode.day185;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class day224_496下一个更大元素I {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 2, 4, 2})));
    }

    //先遍历nums2 map遍历记录 再遍历nums1对应map值 98|9
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {


        Map<Integer,Integer> map = new HashMap<>();//存储key的下一个更大的至value
        for (int i = 0; i < nums2.length; i++) {
            int temp = -1;
            for (int j = i+1; j < nums2.length; j++) {
                if (nums2[j]>nums2[i]){
                    temp = nums2[j];
                    break;
                }
            }
            map.put(nums2[i],temp);
        }

        System.out.println(map);

        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    //leetcode解决方案 stack map解决   91|35
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();

        int[] result = new int[nums1.length];

        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek()<num){
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for(int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);

        return result;
    }
}
