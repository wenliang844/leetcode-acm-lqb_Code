package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day131_1738找出第K大的异或坐标值 {
    /****
     给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
     矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
     请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。

     示例 1：
     输入：matrix = [[5,2],[1,6]], k = 1
     输出：7
     解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
     */
    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
    }

    //方法一:暴力破解 97/6.06
    public static int kthLargestValue(int[][] matrix, int k) {
        //用一个一维数组row * col得到
        int row = matrix.length;
        int col = matrix[0].length;
        int len = row*col;
        int[] nums = new int[len];
        nums[0] = matrix[0][0];
        int index = 1;
        for (int i = 1; i < col; i++) {
            matrix[0][i]^=matrix[0][i-1];
            nums[index]=matrix[0][i];
            index++;
        }

        for (int i = 1; i < row; i++) {
            //用一个一维数组保存当前的值,再用一维数组中的值^下面的值
            int[] temp = new int[col];
            System.arraycopy(matrix[i],0,temp,0,col);
            matrix[i][0] ^= matrix[i-1][0];
            nums[index]= matrix[i][0];
            index++;
            for (int j = 1; j < col; j++) {
                temp[j]^=temp[j-1];
                matrix[i][j] = temp[j]^matrix[i-1][j];
                nums[index]=matrix[i][j];
                index++;
            }
        }

        /*for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }*/

        //找出matrix中第k大的数 提前找出
        Arrays.sort(nums);
        return nums[len-k];
    }

    //方法二:二维前缀和
    //pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
}
