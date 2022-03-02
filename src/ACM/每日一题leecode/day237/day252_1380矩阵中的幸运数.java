package ACM.每日一题leecode.day237;

import java.util.ArrayList;
import java.util.List;

public class day252_1380矩阵中的幸运数 {
    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
    }

    //97 | 9
    public static List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minIndex = 0;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < matrix[i][minIndex]){
                    minIndex = j;
                }
            }

            boolean flag = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][minIndex] > matrix[i][minIndex]){
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(matrix[i][minIndex]);
            }
        }
        return list;
    }
}
