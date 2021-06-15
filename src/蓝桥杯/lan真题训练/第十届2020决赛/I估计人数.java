package 蓝桥杯.lan真题训练.第十届2020决赛;

import java.util.Scanner;

public class I估计人数 {

    public static void main(String[] args) {
        /***
         从0开始,遍历
         每个点,如果是1 进行dfs 优先进入1 如果下,右没有1,进一个-1,直到1的尽头,return

         5 5
         00100
         11111
         00100
         11111
         00100
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        int maze[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                maze[i][j]=s.charAt(j)-'0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    dfs(maze, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] maze, int i, int j) {
        //先把这个ij =-1
        maze[i][j]=-1;//前人踩过了,我可以重复踩,但是我下一步优先踩前人没踩过的,没有的话,-1我也去踩

        //优先向下,
        if (i+1<maze.length && maze[i+1][j]==1){
            dfs(maze,i+1,j);
            return;
        }

        //向右
        if (j+1<maze[i].length && maze[i][j+1]==1){
            dfs(maze,i,j+1);return;
        }

        //没有的话找-1
        if (i+1<maze.length && maze[i+1][j]==-1){
            dfs(maze,i+1,j);
            return;
        }

        //向右
        if (j+1<maze[i].length && maze[i][j+1]==-1){
            dfs(maze,i,j+1);return;
        }
    }
}
