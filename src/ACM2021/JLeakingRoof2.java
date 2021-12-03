package ACM2021;

import java.util.Arrays;
import java.util.Scanner;

public class JLeakingRoof2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] array = new int[n][n];
        float[][] res = new float[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], m);
        }

        double[] as = new double[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
                as[i*n + j] = array[i][j]*100000 + i*n + j;
            }
        }
        Arrays.sort(as);

        for (int ii = as.length - 1; ii > 0; ii--) {
            double a = as[ii];
            int i = (int)a % 100000 / n;
            int j = (int)a % 100000 % n;
            int av = (int)a / 100000;
            System.out.println(i + " - " + j + " - " + av);

            int min = Integer.MAX_VALUE;
            int count = 0;
            if (i - 1 >= 0 && array[i - 1][j] < av) {
                if(array[i - 1][j] < min) { min = array[i - 1][j]; }
            }
            if (j - 1 >= 0 && array[i][j - 1] < av) {
                if(array[i][j - 1] < min) { min = array[i][j - 1]; }
            }
            if (i + 1 < n && array[i + 1][j] < av) {
                if(array[i + 1][j] < min) { min = array[i + 1][j]; }
            }
            if (j + 1 < n && array[i][j + 1] < av) {
                if(array[i][j + 1] < min) { min = array[i][j + 1]; }
            }

            if (i - 1 >= 0 && array[i - 1][j] == min) {
                count++;
            }
            if (j - 1 >= 0 && array[i][j - 1] == min) {
                count++;
            }
            if (i + 1 < n && array[i + 1][j] == min) {
                count++;
            }
            if (j + 1 < n && array[i][j + 1] == min) {
                count++;
            }

            float to = (float)m / count;
            System.out.println(m + " - " + count + " - " + to);
            System.out.println();

            if (i - 1 >= 0 && array[i - 1][j] == min) {
                res[i - 1][j] += to;
            }
            if (j - 1 >= 0 && array[i][j - 1] == min) {
                res[i][j - 1] += to;
            }
            if (i + 1 < n && array[i + 1][j] == min) {
                res[i + 1][j] += to;
            }
            if (j + 1 < n && array[i][j + 1] == min) {
                res[i][j + 1] += to;
            }
            res[i][j] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                if (array[i][j]==0){
//                    System.out.print(0+" ");
//                }else {
//                    System.out.printf("%.6f ",array[i][j]);
//                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }



    }
}
