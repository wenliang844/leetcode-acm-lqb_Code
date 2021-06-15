package ACM.每日一题leecode.day100;

import java.util.TreeSet;

public class day105_363矩形区域不超过K的最大数值和 {
    /**
     给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
     题目数据保证总会存在一个数值和不超过 k 的矩形区域。
     */

    //方法一:暴力,确定两个点,计算两个点形成的矩形的和,进行res比较
    public static void main(String[] args) {
        //System.out.println(maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        System.out.println(maxSumSubmatrix(new int[][]{{2,2,-1}}, 3));

    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        //int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //看这个点是否符合条件
               /* int sum = matrix[i][j];
                if (sum<=k){
                    res = Math.max(res,sum);
                }*/

                for (int l = i; l < matrix.length; l++) {
                    //if (l!=i){
                    int sum=0;
                       /* sum+=matrix[i][l];
                        if (sum<=k){
                            res = Math.max(res,sum);
                        }*/
                   // }

                    for (int m = j; m < matrix[l].length; m++) {
                     //将竖方向上的一列一列加进来
                        for (int n = i; n <=l; n++) {
                            sum+=matrix[n][m];
                        }
                        if (sum<=k){
                            res = Math.max(res,sum);
                            if (res==k)
                                return res;
                        }
                    }
                }
            }
        }
        return res;
    }


    //官方
    public static int maxSumSubmatrix2(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }


}
