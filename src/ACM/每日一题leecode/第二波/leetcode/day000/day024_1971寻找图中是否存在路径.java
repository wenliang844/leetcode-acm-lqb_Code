package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 陈文亮
 * @date 2022/12/19 10:22
 */
public class day024_1971寻找图中是否存在路径 {
    public static void main(String[] args) {
        //System.out.println(validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
        //System.out.println(validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        //System.out.println(validPath(10, new int[][]{{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}}, 5, 9));
        //7-4-0-8-5
        System.out.println(validPath(10, new int[][]{{0,7}, {0,8}, {6,1}, {2,0}, {0,4}, {5,8}, {4,7}, {1,3}, {3,5}, {6,5}}, 7, 5));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        if (n == 1) {
            return true;
        }
        int[][] map = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            //从小到大，采用半个map
            map[edges[i][0]][edges[i][1]] = 1;
            map[edges[i][1]][edges[i][0]] = 1;
        }
        printMap(map);

        List<Integer> pathList = new ArrayList<>();
        return findPath(source, destination, map, pathList);
    }

    private static boolean findPath(int i, int i1, int[][] map, List<Integer> pathList) {
        if (pathList.contains(i)) {
            return false;
        }
        pathList.add(i);

        if (map[i][i1] == 1) {
            return true;
        }
        for (int j = 0; j < map.length; j++) {
            if (map[i][j] == 1) {
                return findPath(j, i1, map, pathList);
            }

        }
        return false;
    }

    private static void printMap(int[][] map) {
        System.out.println("---begin print---");
        for (int i = 0; i < map.length; i++) {
            System.out.println(i+"-"+Arrays.toString(map[i]));
        }
    }

    //并查集：判断是否有共同root
    public static boolean validPath2(int n, int[][] edges, int source, int destination) {

        if (n == 1) {
            return true;
        }
        int[][] map = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            //从小到大，采用半个map
            map[edges[i][0]][edges[i][1]] = 1;
            map[edges[i][1]][edges[i][0]] = 1;
        }
        printMap(map);

        List<Integer> pathList = new ArrayList<>();
        return findPath(source, destination, map, pathList);
    }
}
