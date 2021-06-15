package ACM.leecode周赛.第241场周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lee1_5759找出所有子集的异或总和再求和 {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
    }
    public static int subsetXORSum(int[] nums) {

        //1.求子集->一次遍历
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                List<Integer> templist = new ArrayList<>();
                templist.addAll(list.get(j));
                templist.add(nums[i]);
                list.add(templist);
            }
           /* ArrayList<Integer> templist = new ArrayList<>();
            templist.add(nums[i]);*/
            list.add(Arrays.asList(nums[i]));//Arrays.asList(nums[i])
        }

        for (List<Integer> integers : list) {
            //将每个list中的值异或->sum
            int temp = integers.get(0);
            for (int j = 1; j < integers.size(); j++) {
                temp^= integers.get(j);
            }
            sum += temp;
            //System.out.println(integers);
        }
        return sum;
    }
}
