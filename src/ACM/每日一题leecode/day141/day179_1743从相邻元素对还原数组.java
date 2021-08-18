package ACM.每日一题leecode.day141;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day179_1743从相邻元素对还原数组 {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}})));
        //System.out.println(Arrays.toString(restoreArray(new int[][]{{4,-10}, {-1,3}, {4,-3}, {-3,3}})));
        System.out.println(Arrays.toString(restoreArray(new int[][]{{-3, -9}, {-5, 3}, {2, -9}, {6, -3}, {6, 1}, {5, 3}, {8, 5}, {-5, 1}, {7, 2}})));
    }

    /***
     * 1. 找到开始和结束的元素,只出现一次的元素,start end
     * 2. map:对应每个元素的相邻元素 3-4 4-3 double个长度 40/67
     * @param adjacentPairs
     * @return
     */
    public static int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs.length == 1) {
            return adjacentPairs[0];
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> adjacentPairsLeftMap = new HashMap<>();
        Map<Integer, Integer> adjacentPairsRightMap = new HashMap<>();

        for (int i = 0; i < adjacentPairs.length; i++) {
            int n1 = adjacentPairs[i][0];
            int n2 = adjacentPairs[i][1];
            countMap.put(n1, countMap.getOrDefault(n1, 0) + 1);
            countMap.put(n2, countMap.getOrDefault(n2, 0) + 1);
            if (adjacentPairsLeftMap.containsKey(n1)) {
                adjacentPairsRightMap.put(n1, n2);
            } else {
                adjacentPairsLeftMap.put(n1, n2);
            }

            if (adjacentPairsLeftMap.containsKey(n2)) {
                adjacentPairsRightMap.put(n2, n1);
            } else {
                adjacentPairsLeftMap.put(n2, n1);
            }
        }

        //System.out.println(countMap);
        //System.out.println(adjacentPairsLeftMap);
        //System.out.println(adjacentPairsRightMap);
        int[] startAndEnd = new int[2];
        int index = 0;
        for (Integer integer : countMap.keySet()) {
            if (countMap.get(integer) == 1) {//只出现一次的元素是首末元素
                startAndEnd[index++] = integer;
            }
        }

        int ans[] = new int[adjacentPairs.length + 1];
        ans[0] = startAndEnd[0];
        ans[ans.length - 1] = startAndEnd[1];
        for (int i = 1; i < ans.length - 1; i++) {
            if (adjacentPairsLeftMap.containsKey(ans[i - 1])) {
                ans[i] = adjacentPairsLeftMap.get(ans[i - 1]);
                adjacentPairsLeftMap.remove(ans[i - 1],ans[i]);
                adjacentPairsLeftMap.remove(ans[i],ans[i-1]);
                adjacentPairsRightMap.remove(ans[i - 1],ans[i]);
                adjacentPairsRightMap.remove(ans[i],ans[i-1]);
            } else {
                ans[i] = adjacentPairsRightMap.get(ans[i - 1]);
                adjacentPairsRightMap.remove(ans[i - 1],ans[i]);
                adjacentPairsRightMap.remove(ans[i],ans[i-1]);
                adjacentPairsLeftMap.remove(ans[i - 1],ans[i]);
                adjacentPairsLeftMap.remove(ans[i],ans[i-1]);
            }
            //用过的map就要删除,下次不能再使用
        }
        return ans;
    }
}
