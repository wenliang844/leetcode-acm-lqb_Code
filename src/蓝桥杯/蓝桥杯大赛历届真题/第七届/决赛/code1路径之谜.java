package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class code1路径之谜 {
    //递归回溯 跟随两个数组
    //也可使用公共数组,不行的话else里面return之前把ij加回来
    /***
     4
     2 4 3 4
     4 3 3 3

     分析：对于这道题目，我的第一感觉就是深搜，即每次判断符合条件的4个方向然后进入，
     并将其对应的x、y对应的总值减一。同时将该点的路径存入数组，结束的条件当到达最下角的点，
     且所有x、y对应的值为0，此时返回真值。如果当前深搜的路径不满足条件，则返回假，
     同时将之前对应x、y减少的值再恢复到原来的值。如果当前点的四个方向都无法走，那么删除当前数组的最后一个值。
     总的来说，就是深搜如果该路走不通，则撤销的上一层继续深搜。直到找到正确的路为止。
     */
    static int[] row;
    static int[] col;
    static int load[][];
    static int n;//长度
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       n = 4;
       /* row = new int[n];
        col = new int[n];*/
        row = new int[]{4,3,3,3};
        col = new int[]{2, 4, 3, 4};
        load = new int[n][n];
        /*for (int i = 0; i < n; i++) {
            row[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            col[i] = scanner.nextInt();
        }*/

        row[0]--;
        col[0]--;
        dfs(0, 0);

        //输出load数字
        for (int i = 0; i < load.length; i++) {
            System.out.println(Arrays.toString(load[i]));
        }
        System.out.println("---------------");

        System.out.println(list);
    }

    private static boolean dfs(int i, int j) {
        //输出load数字
        /*for (int i1 = 0; i1 < load.length; i1++) {
            System.out.println(Arrays.toString(load[i1]));
        }
        System.out.println("---------------");

        System.out.println(list);*/

        //让i j对应的row col--
       /* load[i][j] = 1;
        row[i]--;
        col[j]--;*/

        if (i == load.length - 1 && j == load.length - 1) {
            //终结条件
            if (judge(row, col)) {
                list.add(i*n+j);
                return true;
            } else {
                /*load[i][j] = 1;
                row[i]--;
                col[j]--;*/
                return false;
            }
        }

        //将当前点记录
        list.add(i*n+j);
        load[i][j]=1;

       /* if (row[i] < 0 || col[j] < 0) {
            row[i]++;
            col[j]++;
            load[i][j] = 0;//设为没走过
            return false;
        }*/

        //boolean flag = false;

        if (j + 1 < load.length && load[i][j + 1] == 0) {//没走过
//            flag = dfs(load,i,j+1);
            //load[i][j + 1] = 1;
            row[i]--;
            col[j + 1]--;
            if (dfs(i, j + 1)) {
                return true;
            } else {
                //load[i][j + 1] = 1;
                row[i]++;
                col[j + 1]++;
            }
        } //向左走i-1
        //向右走i+1
        if (i + 1 < load.length && load[i + 1][j] == 0) {//没走过
            //load[i+ 1][j ] = 1;
            row[i + 1]--;
            col[j]--;
            if (dfs(i+ 1, j )) {
                return true;
            } else {
                //load[i+ 1][j ] = 1;
                row[i+ 1]++;
                col[j ]++;
            }
        } //向下走i+1

        if (i - 1 >= 0 && load[i - 1][j] == 0) {//没走过
            //load[i- 1][j ] = 1;
            row[i-1]--;
            col[j]--;
            if (dfs(i- 1, j )) {
                return true;
            } else {
                //load[i- 1][j ] = 1;
                row[i- 1]++;
                col[j ]++;
            }
        } //向上走j-1
        if (j - 1 >= 0 && load[i][j - 1] == 0) {//没走过
            //load[i][j - 1] = 1;
            row[i]--;
            col[j - 1]--;
            if (dfs(i, j - 1)) {
                return true;
            } else {
                //load[i][j - 1] = 1;
                row[i]++;
                col[j -1]++;
            }
        }

        list.remove(list.size()-1);
        load[i][j]=0;
        return false;
    }

    private static boolean judge(int[] row, int[] col) {
        //当row和col都等于0的时候return true
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0 || col[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
