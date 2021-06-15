package ACM.tag刷题.数据结构.数组;

import java.lang.reflect.Array;
import java.util.Arrays;

public class array_238除自身以外数组的乘积 {

    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * <p>
     * 示例:
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * <p>
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * <p>
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 进阶：
     * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     */
    //方法1,使用除法---做验证  100 51
    public static int[] productExceptSelf(int[] nums) {

        int mulSum = 1;
        for (int i = 0; i < nums.length; i++) {
            mulSum *= nums[i];
        }
        int mulSpace[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                mulSpace[i] = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (j != i)
                        mulSpace[i] *= nums[j];
                }
            } else {
                mulSpace[i] = mulSum / nums[i];
            }
        }
        return mulSpace;
    }

    //方法2,双指针:维护两个变量left,right从两边开始乘 8 85
    public static int[] productExceptSelf2(int[] nums) {
        int mulSpace[] = new int[nums.length];
        Arrays.fill(mulSpace,1);
        int left = 1;
        int right = 1;
        //一趟循环
        for (int i = 0; i < nums.length; i++) {

            mulSpace[i] *= left;//相当于mul[i]只*left左边的数
            left *= nums[i];//累积当前的数字,后面要乘

            //right同理
            mulSpace[nums.length-1-i] *= right;//相当于没有乘本身.乘了本身右边的全部数字
            right *=nums[nums.length-i-1];//累积本身
        }

        return mulSpace;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));//0 0  9 0 0
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{-1, 1, 0, -3, 3})));//0 0  9 0 0
    }
}
