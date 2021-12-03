package ACM.每日一题leecode.day185;

public class day230_598范围求和II {
    public static void main(String[] args) {
        System.out.println(maxCount2(3, 3, new int[][]{{2, 2}, {3, 3}}));
        System.out.println(maxCount2(3, 3, new int[][]{}));
        System.out.println(maxCount2(3, 2, new int[][]{}));
    }

    //方法一:暴力解决
    public static int maxCount(int m, int n, int[][] ops) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < ops.length; i++) {
            for (int j = 0; j < ops[i][0]; j++) {
                for (int k = 0; k < ops[i][1]; k++) {
                    matrix[j][k]++;
                }
            }
        }
        //遍历matrix 计数
        int x = 0;
        int y = 0;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == matrix[0][0]) {
                x++;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == matrix[0][0]) {
                y++;
            } else {
                break;
            }
        }
        return x * y;
    }

    //方法一:横纵坐标的最小值 100|79
    public static int maxCount2(int m, int n, int[][] ops) {

        int minX = m;
        int minY = n;
        for (int i = 0; i < ops.length; i++) {
            minX = Math.min(ops[i][0], minX);
            minY = Math.min(ops[i][1], minY);
        }
        return minX * minY;
    }
}
