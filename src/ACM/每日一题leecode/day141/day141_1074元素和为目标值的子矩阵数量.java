package ACM.每日一题leecode.day141;

import java.util.Arrays;

public class day141_1074元素和为目标值的子矩阵数量 {
    public static void main(String[] args) {
        //System.out.println(numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}},0));
        //System.out.println(numSubmatrixSumTarget2(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}},0));
        System.out.println(numSubmatrixSumTarget(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 5));
        System.out.println(numSubmatrixSumTarget2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 5));
    }

    //方法一:暴力枚举
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {

        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        //从单点出发,向两边扩展,起点
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //这是终点
                for (int k = i; k < row; k++) {
                    for (int l = j; l < col; l++) {
                        //对从i,j 到 k,l的数字进行总和,count++
                        int sum = 0;
                        for (int m = i; m <= k; m++) {
                            for (int n = j; n <= l; n++) {
                                sum += matrix[m][n];
                            }
                        }
                        //考察 sum是否=target
                        if (sum == target) {
                            count++;
                        }
                        System.out.print(sum + " ");
                    }
                }
            }
        }


        return count;
    }

    //方法二:暴力枚举优化 前缀和
    public static int numSubmatrixSumTarget2(int[][] matrix, int target) {

        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        //创建一个二维数组,是单列的前缀和
        /*int[][] pre = new int[row][col];
        for (int i = 0; i < col; i++) {
            pre[i][0] = matrix[i][0];
        }
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                pre[i][j] += pre[i][j - 1] + matrix[i][j];
            }
        }
        System.out.println("------这是前缀和");
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(pre[i]));
        }*/

        //从单点出发,向两边扩展,起点
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //这是终点
                int[][] temp = new int[row + 1][col + 1];
                for (int k = i; k < row; k++) {
                    //创建一个当前行的前缀和,前面已创建
                    int[] pre = new int[col + 1];
                    for (int l = j; l < col; l++) {
                        pre[l + 1] = pre[l] + matrix[k][l];
                        temp[k + 1][l + 1] = temp[k][l + 1] + pre[l + 1];
                        if (temp[k + 1][l + 1] == target) {
                            count++;
                        }
                        System.out.print(temp[k + 1][l + 1] + " ");
                    }
                }
            }
        }


        return count;
    }



    //方法三:暴力枚举优化 前缀和+差分数组
    public static int numSubmatrixSumTarget3(int[][] matrix, int target) {

        /*****
         那么通过：dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+map[i][j] 来预处理矩阵
         求以i j 为右下角c为边长的子矩阵：
         val = dp[i][j]-dp[i][j-c]-dp[i-c][j]+dp[i-1][j-1]
         */
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        int per[][] = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {

        }
        //从单点出发,向两边扩展,起点
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //这是终点
                int[][] temp = new int[row + 1][col + 1];
                for (int k = i; k < row; k++) {
                    //创建一个当前行的前缀和,前面已创建
                    int[] pre = new int[col + 1];
                    for (int l = j; l < col; l++) {
                        pre[l + 1] = pre[l] + matrix[k][l];
                        temp[k + 1][l + 1] = temp[k][l + 1] + pre[l + 1];
                        if (temp[k + 1][l + 1] == target) {
                            count++;
                        }
                        System.out.print(temp[k + 1][l + 1] + " ");
                    }
                }
            }
        }


        return count;
    }
}