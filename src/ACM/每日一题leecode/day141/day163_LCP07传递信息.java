package ACM.每日一题leecode.day141;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day163_LCP07传递信息 {
    public static void main(String[] args) {
        System.out.println(numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
    }

    static int count = 0;

    // 56//80
    public static int numWays(int n, int[][] relation, int k) {
        count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : relation) {
            List<Integer> list = map.get(ints[0]);
            if (list == null) {
                List<Integer> temp = new ArrayList<>();
                temp.add(ints[1]);
                map.put(ints[0], temp);
            } else {
                list.add(ints[1]);
            }
        }
        System.out.println(map);
        //深度优先搜索
        dfs(map, 0, k, n - 1);
        return count;
    }

    //从key开始,在map中传递下一个,k次传递
    private static void dfs(Map<Integer, List<Integer>> map, int key, int k, int target) {
        if (k == 0) {
            if (key == target) {
                count++;
            }
            return;
        }
        if (map.containsKey(key)) {
            List<Integer> list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                dfs(map, list.get(i), k - 1, target);
            }
        }

    }
}
