package 蓝桥杯.培训.第一次培训3_12习题2019;

public class lqb6_试题F旋转 {

    /***
     图片旋转是对图片最简单的处理方式之一，在本题中，你需要对图片顺时
     针旋转 90 度。
     我们用一个 n × m 的二维数组来表示一个图片，例如下面给出一个 3 × 4 的
     图片的例子：
     1 3 5 7
     9 8 7 6
     3 5 9 7
     这个图片顺时针旋转 90 度后的图片如下：
     3 9 1
     5 8 3
     9 7 5
     7 6 7
     给定初始图片，请计算旋转后的图片

     【输入格式】
     输入的第一行包含两个整数 n 和 m，分别表示行数和列数。
     接下来 n 行，每行 m 个整数，表示给定的图片。图片中的每个元素（像
     素）为一个值为 0 至 255 之间的整数（包含 0 和 255）。
     【输出格式】
     输出 m 行 n 列，表示旋转后的图片

     【样例输入】
     3 4
     1 3 5 7
     9 8 7 6
     3 5 9 7
     【样例输出】
     3 9 1
     5 8 3
     9 7 5
     7 6 7
     */

    /***
     思路:input n m
     创建一个m n的数字
     方法1:直接使用辅助函数
     方法二:在原图像矩阵操作
     */
    public static void test1(int[][] nums, int n, int m) {
        int[][] newNums = new int[m][n];

        for (int j = 0; j <m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test1(new int[][]{{1,3,5,7},{9,8,7,6},{3,5,9,7}},3,4);
    }
}
