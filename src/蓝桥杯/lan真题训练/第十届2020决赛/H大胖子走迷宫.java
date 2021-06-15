package 蓝桥杯.lan真题训练.第十届2020决赛;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class H大胖子走迷宫 {

    /***
     9 5
     +++++++++
     +++++++++
     +++++++++
     +++++++++
     +++++++++
     ***+*****
     +++++++++
     +++++++++
     +++++++++
     * @param maze
     */
    public static void printNums(char maze[][]){
        for (int i = 0; i < maze.length; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
        System.out.println("------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        char maze[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            maze[i] = sc.next().toCharArray();
        }
        printNums(maze);


    }
}
