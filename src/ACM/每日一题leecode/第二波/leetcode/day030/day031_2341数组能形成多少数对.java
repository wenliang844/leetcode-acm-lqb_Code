package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈文亮
 * @date 2023/2/16 14:03
 */
public class day031_2341数组能形成多少数对 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1,3,2,1,3,2,2})));
    }

    //返回数对数量 / 剩余数的数量
    //方案：用map计数每个数重复的数量，遍历map得出结果
    public static int[] numberOfPairs(int[] nums) {

        int[] count = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (Integer value : map.values()) {
            count[0] += value / 2;
            count[1] += value % 2;
        }

        return count;
    }
}
