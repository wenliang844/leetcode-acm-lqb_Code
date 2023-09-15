package ACM.每日一题leecode.第二波.leetcode.day61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day62_1222可以攻击国王的皇后 {
    public static void main(String[] args) {
        System.out.println(queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0}));
        System.out.println(queensAttacktheKing(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}}, new int[]{3, 3}));
    }

    //从国王出发,枚举8个方向
    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] graph = new int[8][8];
        //构造图
        for (int i = 0; i < queens.length; i++) {
            graph[queens[i][0]][queens[i][1]] = 1;
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = king[0] + 1; i < 8; i++) {
            if (graph[i][king[1]] == 1) {
                resList.add(Arrays.asList(i, king[1]));
                break;
            }
        }
        for (int i = king[1] + 1; i < 8; i++) {
            if (graph[king[0]][i] == 1) {
                resList.add(Arrays.asList(king[0], i));
                break;
            }
        }
        for (int i = king[0] - 1; i >= 0; i--) {
            if (graph[i][king[1]] == 1) {
                resList.add(Arrays.asList(i, king[1]));
                break;
            }
        }
        for (int i = king[1] - 1; i >= 0; i--) {
            if (graph[king[0]][i] == 1) {
                resList.add(Arrays.asList(king[0], i));
                break;
            }
        }
        for (int i = king[0] + 1, j = king[1] + 1; i < 8 && j < 8; i++, j++) {
            if (graph[i][j] == 1) {
                resList.add(Arrays.asList(i, j));
                break;
            }
        }
        for (int i = king[0] - 1, j = king[1] - 1; i >= 0 && j >= 0; i--, j--) {
            if (graph[i][j] == 1) {
                resList.add(Arrays.asList(i, j));
                break;
            }
        }
        for (int i = king[0] - 1, j = king[1] + 1; i >= 0 && j < 8; i--, j++) {
            if (graph[i][j] == 1) {
                resList.add(Arrays.asList(i, j));
                break;
            }
        }
        for (int i = king[0] + 1, j = king[1] - 1; i < 8 && j >= 0; i++, j--) {
            if (graph[i][j] == 1) {
                resList.add(Arrays.asList(i, j));
                break;
            }
        }
        return resList;
    }

    public static void prientGraph(int[][] graph) {
        System.out.println("---开始打印图");
        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        System.out.println("---结束打印图");
    }

    public static List<List<Integer>> queensAttacktheKing2(int[][] queens, int[] king) {
        List<List<Integer>> resList = new ArrayList<>();
        int maxX1 = -1;
        int maxY1 = -1;

        int maxX2 = -1;
        int maxY2 = -1;

        int maxX3 = -1;
        int maxY3 = -1;

        for (int i = 0; i < queens.length; i++) {
            int x = queens[i][0];
            int y = queens[i][1];
            System.out.println(String.format("开始验证x==%s---y=%s", x, y));

            //x相同---y相同---x/y比值相同
            if (x == king[0] && (maxX1 == -1 || Math.abs(king[0] - maxX1) < Math.abs(king[0] - x))) {
                maxX1 = x;
                maxY1 = y;
                System.out.println(String.format("命中x相同此时maxx1==%s---maxy1=%s", maxX1, maxY1));
            }
            if (y == king[1] && (maxY2 == -1 || Math.abs(king[1] - maxY2) < Math.abs(king[1] - maxY2))) {
                maxX2 = x;
                maxY2 = y;
                System.out.println(String.format("命中y相同此时maxx2==%s---maxy2=%s", maxX2, maxY2));
            }
            if (king[0] - x == king[1] - y && (maxX3 == -1 || Math.abs(king[0] - maxX1) < Math.abs(king[0] - x))) {
                maxX3 = x;
                maxY3 = y;
                System.out.println(String.format("命中xy差值相同此时maxx3==%s---maxy3=%s", maxX3, maxY3));
            }
        }


        if (maxX1 != -1) {
            resList.add(Arrays.asList(maxX1, maxY1));
        }
        if (maxX2 != -1) {
            resList.add(Arrays.asList(maxX2, maxY2));
        }
        if (maxX3 != -1) {
            resList.add(Arrays.asList(maxX3, maxY3));
        }
        return resList;
    }
}
