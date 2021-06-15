package ACM.tag刷题.算法.动态规划;

public class dp_221最大正方形 {

    /***
     在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     */
    //方法一:暴力解法:循环勾勒方形 1,2
    public static int maximalSquare(char[][] matrix) {
        System.out.println("长度i="+matrix.length);
        System.out.println("长度j="+matrix[0].length);
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') break;
                System.out.println("当前在处理ij"+i+"--"+j);
                //这是ij是开始的节点
                //这是在i基础上扩展向左扩展
                int area = 1;
                for (int k = j + 1; k < matrix[0].length; k++) {
                    if (matrix[i][k] == '0') break;
                    area++;
                }
                maxArea = Math.max(maxArea, area);
                area = 1;
                //向下扩展,长度4
                for (int k = i + 1; k < matrix.length; k++) {
                    if (matrix[k][j] == '0') break;
                    area++;
                }
                maxArea = Math.max(maxArea, area);

                //向两边扩展得出最大的正方形

                for (int k = i + 1; k < matrix.length; k++) {
                    for (int l = j + 1; l < matrix[0].length; l++) {
                        //如果从i -i+1
                        //j - j+1   全是1的话,最大值就是k-i+! * l-j+1
                        boolean flag = true;
                        for (int m = i; m <= k; m++) {
                            for (int n = j; n <= l; n++) {
                                if (matrix[m][n] == '0') {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (flag) {
                            int temparea = (k - i + 1) * (l - j + 1);
                            System.out.println("计算的面积="+temparea);
                            maxArea = Math.max(maxArea, temparea);
                        }
                    }
                }

            }
        }

        return maxArea;
    }

    //方法二:dp:用dp三边最小加1,求出来的是边长
    //看错了题目,是最大正方形,直接上,左,斜的最小值加1就可以了
    public static int maximalSquare2(char[][] matrix) {

        int maxArea = 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    maxArea = Math.max(dp[i][j] * dp[i][j],maxArea);
                }
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(maximalSquare2(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
