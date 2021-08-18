package ACM.每日一题leecode.day141;

import java.util.*;

public class day160_149直线上最多的点数 {
    /***
     给你一个数组 points,其中points[i]=[xi,yi]表示X-Y平面上的一个点。
     求最多有多少个点在同一条直线上。
     */
    public static void main(String[] args) {
       //System.out.println(maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
       //System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
       //System.out.println(maxPoints(new int[][]{{0, 0}}));
       //System.out.println(maxPoints(new int[][]{{0, 0},{1,1}}));
        System.out.println(maxPoints(new int[][]{{0,0},{4,5},{7,8},{8,9},{5,6},{3,4},{1,1}}));//平行关系怎么处理
    }

    //方法一:直接用斜率,计数有多少斜率相同的点
    //用一个二维数组保存两个点的斜率
    /*
        1 2 3
    1     1 1
    2       1
    3
    3个
    y-y/x-x
     */
    //29/32
    public static int maxPoints(int[][] points) {
        int len = points.length;
        if (len<=2)return len;
        Map<Double, Integer> map = new HashMap<Double, Integer>();//斜率,数量
        Map<Double, Set<Integer>> mapSet = new HashMap<Double, Set<Integer>>();//斜率,坐标
        int maxCount = 0;//最大数量
        double maxSlopes = 0;//最大斜率
        double[][] slopes = new double[len][len];
        //两点的斜率赋值
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int y = points[i][1] - points[j][1];
                int x = points[i][0] - points[j][0];
                double temp;
                if (x == 0) {
                    temp = 100;
                } else {
                    temp = y * 1.0 / x;
                }

                slopes[i][j] = temp;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                if (mapSet.get(temp) == null) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    mapSet.put(temp, set);
                } else {
                    Set<Integer> set = mapSet.get(temp);
                    set.add(i);
                    set.add(j);
                }
            }
        }

        //扫描一遍map,找出最大值的slope
        for (Double temp : map.keySet()) {
            Integer integer = map.get(temp);
            if (integer > maxCount) {
                maxCount = integer;
                maxSlopes = temp;
            }
        }

        System.out.println(mapSet);
        System.out.println(map);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(slopes[i][j]+" ");
            }
            System.out.println();
        }

        return mapSet.get(maxSlopes).size();
    }






    public int maxPoints2(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
