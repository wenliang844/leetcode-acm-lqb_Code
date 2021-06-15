package ACM.tag刷题.数据结构.数组;

import java.util.ArrayList;
import java.util.List;

class array_448找到所有数组中消失的数字 {

    /***
     给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     示例:
     输入:
     [4,3,2,7,8,2,3,1]
     输出:
     [5,6]
     */
    //方法一:定义一个bool数组,进行判定谁没有出现,扫描两次,一次nums 一次bool  98 49
    //不使用额外的空间,就是使用list来记录
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean judge[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            judge[nums[i]-1]=true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!judge[i]){
                list.add(i+1);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

}