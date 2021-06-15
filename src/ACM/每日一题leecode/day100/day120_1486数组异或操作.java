package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day120_1486数组异或操作 {

    /****
     给你两个整数，n 和 start 。
     数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
     请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     示例 1：
     输入：n = 5, start = 0
     输出：8
     解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
     "^" 为按位异或 XOR 运算符。
     */
    public static void main(String[] args) {


        System.out.println(xorOperation(5, 0));
    }

    //模拟即可
    public static int xorOperation(int n, int start) {

        //int[] array = new int[n];

        int res = start;
        for (int i = 1; i < n; i++) {
            res^=start+2*i;
        }
//        System.out.println(res);

        //异或操作

        return res;
    }
}
