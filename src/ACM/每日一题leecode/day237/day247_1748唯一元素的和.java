package ACM.每日一题leecode.day237;

import java.util.HashMap;
import java.util.Map;

public class day247_1748唯一元素的和 {
    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1, 2, 3, 2}));
    }

    public static int sumOfUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int sum = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key)==1){
                sum += key;
            }
        }
        return sum;
    }
}
