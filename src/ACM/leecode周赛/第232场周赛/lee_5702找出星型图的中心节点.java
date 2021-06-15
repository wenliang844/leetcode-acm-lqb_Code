package ACM.leecode周赛.第232场周赛;

import java.util.HashMap;
import java.util.Map;

public class lee_5702找出星型图的中心节点 {

    /****
     有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，
     并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。

     给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui
     和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
     */

    public static int findCenter(int[][] edges) {

        /**
         思路:
         计数 数组的边,map<integer,integer></>
         哪个的数量是n-1,哪个就是中心节点
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            Integer integer1 = map.get(edges[i][0]);
            if (integer1 != null) {
                map.put(edges[i][0], integer1 + 1);
            } else {
                map.put(edges[i][0], 1);
            }

            Integer integer2 = map.get(edges[i][1]);
            if (integer2 != null) {
                map.put(edges[i][1], integer2 + 1);
            } else {
                map.put(edges[i][1], 1);
            }

        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) == edges.length) {
                return integer;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{
                {1, 2}, {2, 3}, {4, 2}
        }));

    }
}
