package 蓝桥杯.蓝桥杯大赛历届真题.第九届;

import sun.nio.cs.ext.ISCII91;

import java.util.Arrays;
import java.util.Scanner;

public class code4全球变暖 {
    /***
     1.计算变暖前的岛的数量
     2.用一个新hchar数组计算之后的情况
     3.再次统计岛的数量

     计算:遍历每一个点:到了一个点就dfs消灭上下左右的
     7
     .......
     .##....
     .##....
     ....##.
     ..####.
     ...###.
     .......
     */
    public static int getIsland(char[][] island) {

        int count = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == '#') {
                    count++;
                    dfs(island, i, j);//将i j上下左右去掉
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] island, int i, int j) {
        /*
       ((i - 1 >= 0) && island[i - 1][j] == '.') ||
        ((i + 1 < n) && island[i + 1][j] == '.') ||
        ((j - 1 >= 0) && island[i][j - 1] == '.') ||
        ((j + 1 < n) && island[i][j + 1] == '.')
         */
        island[i][j]='.';
        if (((i - 1 >= 0) && island[i - 1][j] == '#')){
            dfs(island,i-1,j);
        }if (((i + 1 < island.length) && island[i + 1][j] == '#')){
            dfs(island,i+1,j);
        }if (((j - 1 >= 0) && island[i][j - 1]== '#')){
            dfs(island,i,j-1);
        }if (((j + 1 < island.length) && island[i][j + 1] == '#')){
            dfs(island,i,j+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] island = new char[n][n];
        char[][] landNum = new char[n][n];
        char[][] endIsland = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                island[i][j] = s.charAt(j);
                endIsland[i][j] = s.charAt(j);
                landNum[i][j] = s.charAt(j);
            }
        }

        printChars(island);
        int startnum = getIsland(landNum);
        printChars(landNum);

        //操作
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (island[i][j] == '#') {
                    //判断上下左右是否有.
                    if (
                            ((i - 1 >= 0) && island[i - 1][j] == '.') ||
                                    ((i + 1 < n) && island[i + 1][j] == '.') ||
                                    ((j - 1 >= 0) && island[i][j - 1] == '.') ||
                                    ((j + 1 < n) && island[i][j + 1] == '.')
                    ) {
                        endIsland[i][j] = '.';
                    }
                }
            }
        }

        printChars(endIsland);
        int endnum = getIsland(endIsland);

        System.out.println(startnum);
        System.out.println(endnum);
        System.out.println(startnum - endnum);

    }

    private static void printChars(char[][] endIsland) {
        for (int i = 0; i < endIsland.length; i++) {
            System.out.println(Arrays.toString(endIsland[i]));
        }
        System.out.println("-------------------");
    }
}
