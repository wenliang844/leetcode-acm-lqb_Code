package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.Arrays;

/**
 * @author 陈文亮
 * @date 2023/5/26 10:24
 */
public class day52_1091二进制矩阵中的最短路径 {
    public static void main(String[] args) {

        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));//4
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));//2
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}}));//3
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1, 1, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0}, {0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 0}}));//3
    }

    //深度遍历dfs
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        int[][] res = new int[length][length];

        //判断第一个数可通
        if (grid[0][0] == 0) {
            res[0][0] = 1;
        } else {
            return -1;
        }

        //判断最后一个格子 可通
        if (grid[length - 1][length - 1] == 1) {
            return -1;
        }


        //判断其他的 dp动态规划
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 0) {
                    int temp = Integer.MAX_VALUE;
                    if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] != -1 && res[i - 1][j - 1] != 0) {
                        temp = Math.min(temp, res[i - 1][j - 1] + 1);
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] != -1 && res[i - 1][j] != 0) {
                        temp = Math.min(temp, res[i - 1][j] + 1);
                    }
                    if (i - 1 >= 0 && j + 1 < length && grid[i - 1][j + 1] != -1 && res[i - 1][j + 1] != 0) {
                        temp = Math.min(temp, res[i - 1][j + 1] + 1);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] != -1 && res[i][j - 1] != 0) {
                        temp = Math.min(temp, res[i][j - 1] + 1);
                    }
                    if (j + 1 < length && grid[i][j + 1] != -1 && res[i][j + 1] != 0) {
                        temp = Math.min(temp, res[i][j + 1] + 1);
                    }
                    if (i + 1 < length && j - 1 >= 0 && grid[i + 1][j - 1] != -1 && res[i + 1][j - 1] != 0) {
                        temp = Math.min(temp, res[i + 1][j - 1] + 1);
                    }
                    if (i + 1 < length && grid[i + 1][j] != -1 && res[i + 1][j] != 0) {
                        temp = Math.min(temp, res[i + 1][j] + 1);
                    }
                    if (i + 1 < length && j + 1 < length && grid[i + 1][j + 1] != -1 && res[i + 1][j + 1] != 0) {
                        temp = Math.min(temp, res[i + 1][j + 1] + 1);
                    }

                    if (temp != Integer.MAX_VALUE) {
                        res[i][j] = temp;
                    }

                }
            }
        }

        //---
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        //---
        return res[length - 1][length - 1];
    }

    //dp
    public static int shortestPathBinaryMatrix3(int[][] grid) {
        int length = grid.length;
        int[][] res = new int[length][length];

        //判断第一个数可通
        if (grid[0][0] == 0) {
            res[0][0] = 1;
        } else {
            return -1;
        }

        //判断最后一个格子 可通
        if (grid[length - 1][length - 1] == 1) {
            return -1;
        }


        //判断其他的 dp动态规划
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 0) {
                    int temp = Integer.MAX_VALUE;
                    if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] != -1 && res[i - 1][j - 1] != 0) {
                        temp = Math.min(temp, res[i - 1][j - 1] + 1);
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] != -1 && res[i - 1][j] != 0) {
                        temp = Math.min(temp, res[i - 1][j] + 1);
                    }
                    if (i - 1 >= 0 && j + 1 < length && grid[i - 1][j + 1] != -1 && res[i - 1][j + 1] != 0) {
                        temp = Math.min(temp, res[i - 1][j + 1] + 1);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] != -1 && res[i][j - 1] != 0) {
                        temp = Math.min(temp, res[i][j - 1] + 1);
                    }
                    if (j + 1 < length && grid[i][j + 1] != -1 && res[i][j + 1] != 0) {
                        temp = Math.min(temp, res[i][j + 1] + 1);
                    }
                    if (i + 1 < length && j - 1 >= 0 && grid[i + 1][j - 1] != -1 && res[i + 1][j - 1] != 0) {
                        temp = Math.min(temp, res[i + 1][j - 1] + 1);
                    }
                    if (i + 1 < length && grid[i + 1][j] != -1 && res[i + 1][j] != 0) {
                        temp = Math.min(temp, res[i + 1][j] + 1);
                    }
                    if (i + 1 < length && j + 1 < length && grid[i + 1][j + 1] != -1 && res[i + 1][j + 1] != 0) {
                        temp = Math.min(temp, res[i + 1][j + 1] + 1);
                    }

                    if (temp != Integer.MAX_VALUE) {
                        res[i][j] = temp;
                    }

                }
            }
        }

        //---
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        //---
        return res[length - 1][length - 1];
    }

    public static int shortestPathBinaryMatrix2(int[][] grid) {

        //判断第一个数可通
        if (grid[0][0] == 0) {
            grid[0][0] = 1;
        } else {
            return -1;
        }
        int length = grid.length;

        //判断第一行 可通
        for (int i = 1; i < length; i++) {
            if (grid[0][i] == 0) {
                grid[0][i] = grid[0][i - 1] + 1;
            } else {
                grid[0][i] = -1;
            }
        }

        //判断第一列 可通
        for (int i = 1; i < length; i++) {
            if (grid[i][0] == 0) {
                grid[i][0] = grid[i - 1][0] + 1;
            } else {
                grid[i][0] = -1;
            }
        }

        //判断其他的 dp动态规划
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (grid[i][j] == 0) {
                    int temp = Integer.MAX_VALUE;
                    if (grid[i - 1][j] != -1) {
                        temp = Math.min(temp, grid[i - 1][j] + 1);
                    }
                    if (grid[i][j - 1] != -1) {
                        temp = Math.min(temp, grid[i][j - 1] + 1);
                    }
                    if (grid[i - 1][j - 1] != -1) {
                        temp = Math.min(temp, grid[i - 1][j - 1] + 1);
                    }
                    grid[i][j] = temp;
                } else {
                    grid[i][j] = -1;
                }
            }
        }

        //---
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        //---
        return grid[length - 1][length - 1];
    }
}
