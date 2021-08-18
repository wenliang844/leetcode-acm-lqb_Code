package ACM.每日一题leecode.day141;

import java.util.Arrays;

public class day180_1713得到子序列的最少操作次数 {
    public static void main(String[] args) {
        //System.out.println(minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4}));
        //System.out.println(minOperations(new int[]{6,4,8,1,3,2}, new int[]{4,7,6,2,3,8,6,1}));
        //System.out.println(minOperations(new int[]{17,18,14,13,6,9,1,3,2,20}, new int[]{18,15,14,6,6,13,15,20,2,6}));
        //System.out.println(minOperations2(new int[]{17,18,14,13,6,9,1,3,2,20}, new int[]{18,15,14,6,6,13,15,20,2,6}));
        //System.out.println(minOperations(new int[]{6,4,8,1,3,2}, new int[]{4,7,6,2,3,8,6,1}));
        System.out.println(minOperations2(new int[]{6,4,8,1,3,2}, new int[]{4,7,6,2,3,8,6,1}));
    }

    /*
       9 4 2 3 4
     5 0 0 0 0 0
     1 0 0 0 0 0
     3 0 0 0 1 1

       4 7 6 2 3 8 6 1
     6 0 0 1 1 1 1 1 1   max{(i-1 j-1)+1(相等), (不相等)i-1 ,j-1 }
     4 1 1 1 1 1 1 1 1
     8 1 1 1 1 1 2 2 2
     1 1 1 1 1 1 2 2 3
     3 1 1 1 1 2 2 2 3
     2 1 1 1 2 2 2 2 3
     */

    /***
     * method1: dp最长公共子序列 再用 target - 最长
     * 73 / 82 个通过测试用例{超出内存限制}
     * @param target
     * @param arr
     * @return
     */
    public static int minOperations(int[] target, int[] arr) {
        int row = target.length;
        int col = arr.length;
        int dp[][] = new int[row+1][col+1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (target[i]==arr[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return row-dp[row][col];
    }

    /***
     * method1: dp最长公共子序列 再用 target - 最长{优化内存项}
     * {超时}76/82
     * @param target
     * @param arr
     * @return
     */
    public static int minOperations2(int[] target, int[] arr) {
        int row = target.length;
        int col = arr.length;
        int dp[][] = new int[2][col+1];
        //System.out.println(Arrays.toString(dp[0]));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (target[i]==arr[j]){
                    dp[1][j+1] = dp[0][j]+1;
                    /*if (dp[1][j+1]==5){
                        System.out.println(target[i]+"-"+arr[j]+"---"+dp[0][j]);
                    }*/
                }else {
                    dp[1][j+1] = Math.max(dp[0][j+1],dp[1][j]);
                }
            }
            //dp[0]=dp[1]; //不能直接赋值,不然一个变另一个也会变
            System.arraycopy(dp[1],0,dp[0],0,col+1);
            //System.out.println(Arrays.toString(dp[0]));
            /*System.out.println(Arrays.toString(dp[1]));
            System.out.println();*/
        }


        return row-dp[1][col];
    }
}
