package 蓝桥杯.练习系统.算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class q15数字三角形 {
    //简单dp
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[][] = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j = 0; j <= i; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }

        int[][] ans = new int[n][n];
        ans[0][0] = nums[0][0];
        for (int i = 1; i < n; i++) {
            ans[i][0] = nums[i][0]+ans[i-1][0];
            ans[i][i] = nums[i][i]+ans[i-1][i-1];
        }

        for (int i=2;i<n;i++){
            for (int j = 1; j < i; j++) {
                ans[i][j] = nums[i][j] + Math.max(ans[i-1][j-1],ans[i-1][j]);
            }
        }

        /*for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }*/

        int max = ans[n-1][0];
        for (int i = 1; i < n; i++) {
            max = Math.max(ans[n-1][i],max);
        }
        System.out.println(max);
    }
}
