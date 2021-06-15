package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class code1路径之谜method2 {
    /***
     方法二:直接使用搜索,判断,

     4
     2 4 3 4
     4 3 3 3
     */


    static int[] row;
    static int[] col;
    static boolean flag = false;

    static void dfs(int[][] load, int i, int j, int row2[], int col2[]) {


        for (int k = 0; k < load.length; k++) {
            System.out.println(Arrays.toString(load[k]));
        }
        System.out.println("change case-----------------");


        //将现在的load变1,并且上下加1
        load[i][j] = 1;
        row2[i]++;
        col2[j]++;

        //判断是否到达最后一个节点
        if (i >= row.length - 1 && j >= col.length - 1) {
            //判断两个函数是否相等
            if (judge(col, col2, row, row2)) {
                System.out.println("find-");
                for (int k = 0; k < load.length; k++) {
                    System.out.println(Arrays.toString(load[k]));
                }
                flag = true;
            }
            return;
        }

        if (flag) return;

        //剪枝:判断这个符不符合
       /* if (row2[i] > row[i] || col2[j] > col[j]) {
            //行不通
            return;
        }*/
        if (j + 1 < load.length && load[i][j + 1] == 0) {//没走过
            //构造新的数组传进去
            int[][] tmepload = new int[load.length][load.length];
            int[] temprow = new int[load.length];
            int[] tempcol = new int[load.length];
            System.arraycopy(load, 0, tmepload, 0, load.length);
            System.arraycopy(row2, 0, temprow, 0, load.length);
            System.arraycopy(col2, 0, tempcol, 0, load.length);
            dfs(tmepload, i, j + 1, temprow, tempcol);
            load[i][j+1]=0;
        } //向左走i-1
        //向右走i+1
        if (i + 1 < load.length && load[i + 1][j] == 0) {//没走过
            int[][] tmepload = new int[load.length][load.length];
            int[] temprow = new int[load.length];
            int[] tempcol = new int[load.length];
            System.arraycopy(load, 0, tmepload, 0, load.length);
            System.arraycopy(row2, 0, temprow, 0, load.length);
            System.arraycopy(col2, 0, tempcol, 0, load.length);
            dfs(tmepload, i + 1, j, temprow, tempcol);
            load[i+1][j]=0;
        } //向下走i+1

        if (i - 1 >= 0 && load[i - 1][j] == 0) {//没走过
            int[][] tmepload = new int[load.length][load.length];
            int[] temprow = new int[load.length];
            int[] tempcol = new int[load.length];
            System.arraycopy(load, 0, tmepload, 0, load.length);
            System.arraycopy(row2, 0, temprow, 0, load.length);
            System.arraycopy(col2, 0, tempcol, 0, load.length);
            dfs(tmepload, i - 1, j, temprow, tempcol);
            load[i-1][j]=0;
        } //向上走j-1
        if (j - 1 >= 0 && load[i][j - 1] == 0) {//没走过
            int[][] tmepload = new int[load.length][load.length];
            int[] temprow = new int[load.length];
            int[] tempcol = new int[load.length];
            System.arraycopy(load, 0, tmepload, 0, load.length);
            System.arraycopy(row2, 0, temprow, 0, load.length);
            System.arraycopy(col2, 0, tempcol, 0, load.length);
            dfs(tmepload, i, j - 1, temprow, tempcol);
            load[i][j-1]=0;
        }


    }

    //判断两个数组是否一致
    private static boolean judge(int[] col, int[] col2, int[] row, int[] row2) {

        for (int i = 0; i < row.length; i++) {
            if (row[i] != row2[i] || col[i] != col2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        int[][] load = new int[4][4];
        row = new int[]{2, 4, 3, 4};
        col = new int[]{4, 3, 3, 3};


       /* for (int i = 0; i < n; i++) {
            row[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            col[i] = scanner.nextInt();
        }*/

        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        int row2[] = new int[4];
        int col2[] = new int[4];
        for (int k = 0; k < load.length; k++) {
            System.out.println(Arrays.toString(load[k]));
        }
        System.out.println("change case-----------------");
        dfs(load, 0, 0, row2, col2);
        for (int k = 0; k < load.length; k++) {
            System.out.println(Arrays.toString(load[k]));
        }
        System.out.println("change case-----------------");


        int a[] = {1};
        a[0]++;
        System.out.println(a[0]);

        //输出load

    }

}
