package ACM.tag刷题.数据结构.数组;

import java.lang.reflect.Array;
import java.util.Arrays;

public class array_287寻找重复数 {
    /****
     给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

     假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     */
    //方法一:排序后下标+1对应数组,不对应就是重复数 不行,这个重复的数可能不止一个
    public static int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1){
                return nums[i];
            }
        }
        return 0;
    }

    //方法2:创建一个num+1的bool数组,访问过就变true,再次访问是true直接返回这个数 73 48
    public static int findDuplicate2(int[] nums) {

        boolean[] judge = new boolean[nums.length-1];//0->1
        for (int i = 0; i < nums.length; i++) {
            if (judge[nums[i]-1]){
                return nums[i];
            }
            judge[nums[i]-1]=true;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate2(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate2(new int[]{7,9,7,4,2,8,7,7,1,5}));

    }
}
