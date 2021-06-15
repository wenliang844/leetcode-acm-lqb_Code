package ACM.每日一题leecode.day01;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*
给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class day14_217存在重复元素 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate2(nums));
    }

    public static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {

        for (int i = nums.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //public static boolean containsDuplicate3(int[] nums) {


        //return Arrays.stream(nums).distinct().count() != nums.length;
   // }

    //java set去重功能
    public static boolean containsDuplicate4(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size()==nums.length){
            return false;
        }

        return true;
    }

    //stream流去重
    public static boolean containsDuplicate5(int[] nums) {
        //long count = Arrays.stream(nums).distinct().count();


        return true;
    }

}
