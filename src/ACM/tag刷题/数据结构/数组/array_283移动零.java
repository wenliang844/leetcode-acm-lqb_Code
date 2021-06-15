package ACM.tag刷题.数据结构.数组;

import java.lang.reflect.Array;
import java.util.Arrays;

public class array_283移动零 {

    /***
     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

     示例:

     输入: [0,1,0,3,12]
     输出: [1,3,12,0,0]
     */

    //方法一:交换法 O(n) 一趟扫描
    //方法二:count 0的个数计数,
    //方法三,从1开始,如果左边是0 就移动到最后一个0的位置,自己的位置0 10 84
    //最优解法:第一个位置放第一个非0的数,第n个位置放第n个非0的数
    //双指针,第一个指针找到0,后指针找到数,交换,继续,知道i>=j
    public static void moveZeroes(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]==0){
                int j = i-1;
                while (j>0 && nums[j-1]==0){
                    j--;
                }
                nums[j]=nums[i];
                nums[i]=0;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
       moveZeroes(new int[]{0,1,0,3,12});
       moveZeroes(new int[]{0,1,0,3,0,1,1,5,9,4});
       moveZeroes(new int[]{4,1,8,3,0,0,1,5,9,4});
       moveZeroes(new int[]{0,0,0,0,0,1,8,3,0,0,1,5,9,4});
    }
}
