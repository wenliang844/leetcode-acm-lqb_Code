package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈文亮
 * @date 2022/12/14 10:42
 */
public class day021_1697检查边长度限制的路径是否存在 {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();
            for (int j = 0; j < 100000; j++) {
                //System.out.println(Arrays.toString(
                        distanceLimitedPathsExist2(3,
                        new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}},
                        new int[][]{{0, 1, 2}, {0, 2, 5}});
            }
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            total+=time;
            System.out.println(time);
        }
        System.out.println("total="+total);

    }

    //暴力：每一条边保存最小值，用map存储 start end value/  然后贪心查询
    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        //start:end
        Map<Integer, Integer> pathMap = new HashMap<>();

        //start-end:value
        Map<String, Integer> valueMap = new HashMap<>();

        for (int i = 0; i < edgeList.length; i++) {
            int start = Math.min(edgeList[i][0], edgeList[i][1]);
            int end = Math.max(edgeList[i][0], edgeList[i][1]);
            int value = edgeList[i][2];
            String key = new StringBuilder().append(start).append(":").append(end).toString();
            System.out.println(start + "---" + end + "---" + value + "---" + key);
            if (valueMap.containsKey(key)) {
                Integer oldValue = valueMap.get(key);
                if (value < oldValue) {
                    valueMap.put(key, value);
                }
            } else {
                pathMap.put(start, end);
                valueMap.put(key, value);
            }

            System.out.println(pathMap);
            System.out.println(valueMap);
            System.out.println("-----");
        }


        return null;
    }

    //暴力：每一条边保存最小值，用二维数组存储 start end value/  然后贪心查询
    public static boolean[] distanceLimitedPathsExist2(int n, int[][] edgeList, int[][] queries) {

        int[][] map = new int[n][n];
        boolean[] res = new boolean[queries.length];

        for (int i = 0; i < edgeList.length; i++) {
            int start = Math.min(edgeList[i][0], edgeList[i][1]);
            int end = Math.max(edgeList[i][0], edgeList[i][1]);
            int value = edgeList[i][2];
            if (map[start][end] != 0) {
                map[start][end] = Math.min(map[start][end], value);
            } else {
                map[start][end] = value;
            }
        }
        //printMap(map);

        for (int i = 0; i < queries.length; i++) {
            int start = Math.min(queries[i][0], queries[i][1]);
            int end = Math.max(queries[i][0], queries[i][1]);
            int limitValue = queries[i][2];

            res[i] = find(start, end, limitValue, map);
        }

        return res;
    }

    private static boolean find(int start, int end, int limitValue, int[][] map) {
        if (map[start][end] != 0 && map[start][end] < limitValue) {
            return true;
        }
        for (int i = 0; i < map[start].length; i++) {
            if (map[start][i] != 0 && map[start][i] < limitValue) {
                return find(i, end, limitValue, map);
            }
        }
        return false;
    }

    private static void printMap(int[][] map) {
        System.out.println("---begin print---");
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
