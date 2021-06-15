package ACM.每日一题leecode.day66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class day79_73矩阵置零 {

    /**
     给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

     进阶：

     一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     你能想出一个仅使用常量空间的解决方案吗？
     */

    public static void printNums(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void fillZero(int[][] matrix,int i,int j){
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k]=0;
        }
        //printNums(matrix);
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][j]=0;
        }
        //printNums(matrix);
    }
    //方法一
    public static void setZeroes(int[][] matrix) {

        List<Integer> listi = new ArrayList<>();
        List<Integer> listj = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    //先保存起来
                    listi.add(i);
                    listj.add(j);
                }
            }
        }

        for (int i = 0; i < listi.size(); i++) {
            fillZero(matrix,listi.get(i),listj.get(i));
        }


        printNums(matrix);

    }

    //方法二:网络
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }

}
