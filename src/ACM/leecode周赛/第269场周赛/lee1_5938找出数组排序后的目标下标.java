package ACM.leecode周赛.第269场周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lee1_5938找出数组排序后的目标下标 {
    public static void main(String[] args) {

        System.out.println(targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
    }

    public static List<Integer> targetIndices(int[] nums, int target) {

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                list.add(i);
            }
            if (nums[i]>target){
                break;
            }
        }
        return list;
    }
}
