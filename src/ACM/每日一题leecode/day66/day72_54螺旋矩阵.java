package ACM.每日一题leecode.day66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day72_54螺旋矩阵 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        /***
         规律:模拟法
         搞一个哨兵,在数组外包一层10000,i j从1开始 到len结束
        4个for循环,终止条件是变10000,ij的变化是
         j++;
         i++;
         j--;
         i--;
         */

        List<Integer> list = new ArrayList<>();
        int[][] matrix2 = new int[matrix.length+2][matrix[0].length+2];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix2[i][j]=10000;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix2[i+1][j+1] = matrix[i][j];
        }}
        /*for (int i = 0; i < matrix2.length; i++) {//设置外圈一个哨兵 i j从1开始,碰到0结束
            System.out.println(Arrays.toString(matrix2[i]));
        }*/

        int i=1;
        int j=1;
        int times1 = matrix.length;
        int times2 = matrix[0].length;
        int times = Math.min(times1,times2);
        times = (times1+1)/2;
        while (times>0){
            //四个for循环 j++ i++ j-- i--   终止条件是0
            while (matrix2[i][j]!=10000){
                //System.out.println(matrix2[i][j]);
                list.add(matrix2[i][j]);
                matrix2[i][j]=10000;
                j++;
            }
            j--;
            i++;
            while (matrix2[i][j]!=10000){
                //System.out.println(matrix2[i][j]);
                list.add(matrix2[i][j]);
                matrix2[i][j]=10000;
                i++;
            }
            i--;
            j--;
            while (matrix2[i][j]!=10000){
                //System.out.println(matrix2[i][j]);
                list.add(matrix2[i][j]);
                matrix2[i][j]=10000;
                j--;
            }
            j++;
            i--;
            while (matrix2[i][j]!=10000){
                //System.out.println(matrix2[i][j]);
                list.add(matrix2[i][j]);
                matrix2[i][j]=10000;
                i--;
            }
            i++;
            j++;
            //times--;
            if (matrix2[i][j]==10000){
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(spiralOrder(new int[][]{{2,5},{8,4},{0,-1}}));



    }


    /***
     网上不用哨兵的解法
     public List<Integer> spiralOrder(int[][] matrix) {
     List<Integer> list = new ArrayList<Integer>();
     if(matrix == null || matrix.length == 0)
     return list;
     int m = matrix.length;
     int n = matrix[0].length;
     int i = 0;

     //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
     int count = (Math.min(m, n)+1)/2;
     //从外部向内部遍历，逐层打印数据
     while(i < count) {
     for (int j = i; j < n-i; j++) {
     list.add(matrix[i][j]);
     }
     for (int j = i+1; j < m-i; j++) {
     list.add(matrix[j][(n-1)-i]);
     }

     for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
     list.add(matrix[(m-1)-i][j]);
     }
     for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
     list.add(matrix[j][i]);
     }
     i++;
     }
     return list;
     }

     作者：liao-tian-yi-jian
     链接：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-liao-tian-yi-jian/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
