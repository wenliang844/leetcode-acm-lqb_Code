package ACM.每日一题leecode.day66;

import java.util.Arrays;

public class day67_867转置矩阵 {

    public static void main(String[] args) {
        int[][] tmp = transpose2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[][] tmp2 = transpose2(new int[][]{{1, 2, 3}, {4, 5, 6}});
        for (int[] t : tmp) {
            System.out.println("这是结果===" + Arrays.toString(t));
        }
        for (int[] t : tmp2) {
            System.out.println("这是结果===" + Arrays.toString(t));
        }
    }

    //方法一:对角进行互换
    public static int[][] transpose1(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }

    //方法二:横竖进行交换,创建一个长宽对调的新数组
    public static int[][] transpose2(int[][] matrix) {

        int matrixX = matrix[0].length;
        int matrixY = matrix.length;
        int[][] newMatrix = new int[matrixX][matrixY];
        for (int i = 0; i < matrixY; i++) {
            for (int j = 0; j < matrixX; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
