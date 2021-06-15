package ACM.tag刷题.算法.深度优先dfs;

import java.util.Arrays;

public class dfs_200岛屿数量 {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * 示例 1：
     * 输入：grid = [
     * ['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']
     * ]
     * 输出：1
     */
    //从一个1节点出发,向左,下全部变0 93 51
    public static void deepOneToZero(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        //int temp = j;
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            deepOneToZero(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            deepOneToZero(grid, i, j - 1);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            deepOneToZero(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            deepOneToZero(grid, i - 1, j);
        }
    }

    //找到1,进行deep
    public static int numIslands(char[][] grid) {
        // printGrid(grid);
        //双重遍历找
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    deepOneToZero(grid, i, j);
                    //printGrid(grid);
                }
            }
        }
        //printGrid(grid);
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static void printGrid(char[][] grid) {
        System.out.println("---");
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}
