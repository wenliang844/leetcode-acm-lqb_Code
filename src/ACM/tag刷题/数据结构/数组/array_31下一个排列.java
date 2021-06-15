package ACM.tag刷题.数据结构.数组;

import java.lang.reflect.Array;
import java.util.Arrays;

public class array_31下一个排列 {
    /***
     现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     必须 原地 修改，只允许使用额外常数空间。
     示例 1：
     输入：nums = [1,2,3]
     输出：[1,3,2]
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/next-permutation
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    // 1 2 3      1 3 2
    // 1235 67 6  -> 1235 76 6
    // 1235 6 4 9 6  -> 1235 6 9 4 6
    //思路,直接将最后一个逆序对 交换
    public static void nextPermutation(int[] nums) {
        boolean flag = false;
        //寻找最后一个逆序对
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //swap num[i,i-1]  修正flag=true标志修改成功了,如果flag=false,没有修改,将进行下一步处理
                flag = true;
                int temp = nums[i];//交换
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;

                //还需要对i包括i 后面的进行升序排序
                for (int j = i; j < nums.length-1; j++) {
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[j]>nums[k]){
                            //交换
                            int temp1 = nums[j];
                            nums[j]=nums[k];
                            nums[k]=temp1;
                        }
                    }
                }
                break;
            }
        }
        if (!flag){//如果是全降序,变成升序
            Arrays.sort(nums);
        }

        System.out.println(Arrays.toString(nums));
    }

    //优化:只能找一个大于,但是最小的元素和我交换 98 92
    public static void nextPermutation2(int[] nums) {
        boolean flag = false;
        //寻找最后一个逆序对
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //swap num[i,i-1]  修正flag=true标志修改成功了,如果flag=false,没有修改,将进行下一步处理
                //是找一个大于的,最小的元素进行交换
                int index = i;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j]>nums[i-1]){
                       if (nums[j]<nums[i]){//比较的是element
                           index=j;
                       }
                    }
                }
                System.out.println("这是最终决定交换的大元素"+nums[index]);

                flag = true;
                int temp = nums[index];//交换
                nums[index] = nums[i - 1];
                nums[i - 1] = temp;

                //还需要对i包括i 后面的进行升序排序
                for (int j = i; j < nums.length-1; j++) {
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[j]>nums[k]){
                            //交换
                            int temp1 = nums[j];
                            nums[j]=nums[k];
                            nums[k]=temp1;
                        }
                    }
                }
                break;
            }
        }
        if (!flag){//如果是全降序,变成升序
            Arrays.sort(nums);
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        nextPermutation2(new int[]{1,2,3});//132
        nextPermutation2(new int[]{1,3,2});//
        nextPermutation2(new int[]{1,2,3,4,5,6,4,9,8,7});//[1, 2, 3, 4, 5, 6, 9, 4, 3]
    }
}
