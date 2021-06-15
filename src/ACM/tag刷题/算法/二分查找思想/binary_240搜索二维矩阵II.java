package ACM.tag刷题.算法.二分查找思想;

public class binary_240搜索二维矩阵II {
    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 输入：matrix = [[1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30]], target = 5
     * 输出：true
     */

    //方法一:暴力查找 6 32
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //方法二:二分
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length - 1;//列
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[0][mid] == target) {
                return true;
            } else if (target > matrix[0][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println(left + "---" + right);
        }

        System.out.println(left + "---" + right);

        //对left 以及left-1进行搜索
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][left] == target) return true;
        }
        if (left - 1 >= 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][left - 1] == target) return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix2(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 5));

    }
}
