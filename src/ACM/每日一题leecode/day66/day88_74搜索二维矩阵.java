package ACM.每日一题leecode.day66;

import java.util.HashMap;
import java.util.Map;

public class day88_74搜索二维矩阵 {

    /***
     编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

     每行中的整数从左到右按升序排列。
     每行的第一个整数大于前一行的最后一个整数。
     输入：matrix = [[1,3,5,7],
     [10,11,16,20],
     [23,30,34,60]], target = 3
     输出：true
     */
    //方法一,暴力破解 100 94
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    //方法二:从前往后:剪枝,这个恐怕不行 100 27
    public static boolean searchMatrix2(int[][] matrix, int target) {

        int i=0;
        for (int j = 0; j < matrix[0].length;j++) {
            if (target>=matrix[i][j]){
                //搜索下面的
                while (i<matrix.length){
                    if (target==matrix[i][j]){
                        return true;
                    }else {
                        i++;
                    }
                }
            }
            i=0;
        }
        return false;
    }

    //方法三,从后向前 100 99
    public static boolean searchMatrix3(int[][] matrix, int target) {
        int i = 0;
        for (int j = matrix[0].length-1; j >=0; j--) {
            if (matrix[i][j]>target){//向前找

            }else {//在这列找
                while (i<matrix.length){
                    if (matrix[i][j]==target){
                        return true;
                    }else {
                        i++;
                    }
                }
            }

            i=0;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix3(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println(searchMatrix3(new int[][]{{1, 3}}, 3));
    }
}
