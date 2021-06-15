package 蓝桥杯.蓝桥杯每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day46_39数组排序去重 {
    /***
     　输入10个整数组成的序列，要求对其进行升序排序，并去掉重复元素
     */
    public static List<Integer> sort_deWeight(int[] nums){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        int j=i+1;
        while (j<nums.length){
            if (nums[i]==nums[j]){
                j++;
            }else {
                list.add(nums[i]);
                i=j;
                j=i+1;
            }
        }
        list.add(nums[j-1]);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(sort_deWeight(new int[]{2,2,3,3,1,1,5,5,5,5}));//1,2,3,5
        System.out.println(sort_deWeight(new int[]{2,2,3,3,1,1,5,5,5,5,9,11,45}));//1,2,3,5
        System.out.println(sort_deWeight(new int[]{2,2,3,3,1,1,5,5,5,5,9,11,45,45}));//1,2,3,5
    }
}
