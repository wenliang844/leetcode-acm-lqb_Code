package ACM.每日一题leecode.day185;

import java.util.*;

public class day226_260只出现一次的数字III {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    //暴力线性 18|14
    public static int[] singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }

            System.out.println("---"+i+"---"+set);
        }
        int res[] = new int[2];
        int index = 0;
        for (Integer integer : set) {
            res[index++] = integer;
        }
        return res;
    }

}
