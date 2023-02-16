package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.HashSet;

/**
 * @author 陈文亮
 * @date 2023/1/29 11:24
 */
public class day030_2319判断矩阵是否是一个X矩阵 {
    public static void main(String[] args) {
        //System.out.println(checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}}));
        
    }


    //暴力解法，足矣
    //1. 矩阵对角线上的所有元素都 **不是 0**
    //2. 矩阵中所有其他元素都是 **0**
    //对角线的xy规律是 x=y
    public static boolean checkXMatrix(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j || i+j==grid.length-1) {
                    //对角
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
