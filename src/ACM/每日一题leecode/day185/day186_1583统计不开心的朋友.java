package ACM.每日一题leecode.day185;

import java.util.HashMap;
import java.util.Map;

public class day186_1583统计不开心的朋友 {
    /****
     给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
     对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
     所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
     但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
     x 与 u 的亲近程度胜过 x 与 y，且
     u 与 x 的亲近程度胜过 u 与 v
     返回 不开心的朋友的数目 。

     40/h 保洁;   中介20%   在微信群里抢单子   一个月能8千(勤快上万)
     */
    public static void main(String[] args) {
        System.out.println(unhappyFriends(4, new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}}, new int[][]{{0, 1}, {2, 3}}));
        System.out.println(unhappyFriends(4, new int[][]{{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}}, new int[][]{{1, 3}, {0, 2}}));
    }

    //解法一: 暴力解法
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        //用一个map表示第几个人 用一个嵌套map表示这个人与其他人的关系大小
        Map<Integer, Map> mapMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n - 1; j++) {
                map.put(preferences[i][j], j);
            }
            mapMap.put(i, map);
        }

        //统计pairs的 不开心的人的个数
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            //考察 pairs[i][0] pairs[i][1]是否开心
            //考察 pairs[i][0]
            for (int j = 0; j < n / 2; j++) {
                if (i != j) {
                    int x = pairs[i][0];
                    int y = pairs[i][1];
                    int u = pairs[j][0];
                    int v = pairs[j][1];
                    int relation1 = (int) mapMap.get(x).get(u);
                    int relation2 = (int) mapMap.get(x).get(y);
                    int relation3 = (int) mapMap.get(u).get(x);
                    int relation4 = (int) mapMap.get(u).get(v);
                    if (relation1 < relation2 && relation3 < relation4) {
                        System.out.println(x);
                        count++;
                    }
                    System.out.println(relation1 + "--" + relation2 + "--" + relation3 + "--" + relation4);

                    //考察 pairs[i][1]
                    relation1 = (int) mapMap.get(y).get(v);
                    relation2 = (int) mapMap.get(y).get(x);
                    relation3 = (int) mapMap.get(v).get(y);
                    relation4 = (int) mapMap.get(v).get(u);
                    if (relation1 < relation2 && relation3 < relation4) {
                        System.out.println(y);
                        count++;
                    }

                    System.out.println(relation1 + "--" + relation2 + "--" + relation3 + "--" + relation4);
                }

            }

        }
        return count;
    }
}
