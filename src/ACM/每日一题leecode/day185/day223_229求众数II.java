package ACM.每日一题leecode.day185;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day223_229求众数II {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 1, 1, 2, 2, 3, 3, 3}));

    }

    //超过1/3的数   13|93
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(map);
        int target = nums.length / 3;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > target){
                list.add(integer);
            }
        }

        return list;
    }

    //方法二:摩尔投票法
}
