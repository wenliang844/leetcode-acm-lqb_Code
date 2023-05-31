package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈文亮
 * @date 2023/4/13 16:15
 */
public class day40_2404出现最频繁的偶数元素 {
    public static void main(String[] args) {
        System.out.println(mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));
        System.out.println(mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
        System.out.println(mostFrequentEven(new int[]{8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290}));
    }

    public static int mostFrequentEven(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 == 0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }

        int maxNum = -1;
        int maxValue = -1;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > maxNum || (map.get(integer) == maxNum && maxValue>integer)){
                maxNum = map.get(integer);
                maxValue = integer;
            }
        }


        return maxValue;
    }

    public static int mostFrequentEven2(int[] nums) {

        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));

        int maxAcount = -1;
        int count = -1;
        int maxNum = -1;
        if (nums[0] % 2 == 0) {
            maxNum = nums[0];
            count = 1;
        }
        for (int i = 1; i < nums.length; i++) {

            if (nums[0] % 2 == 0) {
                //满足是偶数。并且相等的情况
                if (nums[i] == nums[i - 1]){
                    count++;
                }
            }

            if (count > maxAcount) {
                    maxAcount = count;
                    maxNum = nums[i - 1];
                }else {
                count=1;
            }


            System.out.println("test");

        }

        if (count > maxAcount) {
            maxAcount = count;
            maxNum = nums[nums.length-1];
        }


        return maxNum;
    }

}
