package ACM.每日一题leecode.day100;

import java.util.*;

public class day115_554砖墙 {

    /***
     你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
     你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
     给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
     */

    //方法一:计数,寻找最少的缝隙
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int num = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                num+= list.get(i);
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }

        //将map中最大的选出
        int max = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > max){
                max = map.get(integer);
            }
        }
        return (wall.size() - max);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2,2,1));
        list.add(Arrays.asList(3,1,2));
        list.add(Arrays.asList(1,3,2));
        list.add(Arrays.asList(2,4));
        list.add(Arrays.asList(3,1,2));
        list.add(Arrays.asList(1,3,1,1));
        System.out.println(leastBricks(list));
    }
}
