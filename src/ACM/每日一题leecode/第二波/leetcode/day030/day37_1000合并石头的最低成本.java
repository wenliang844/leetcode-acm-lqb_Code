package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 陈文亮
 * @date 2023/4/4 11:22
 */
public class day37_1000合并石头的最低成本 {
    public static void main(String[] args) {

//        System.out.println(mergeStones(new int[]{3, 2, 4, 1}, 2));
//        System.out.println(mergeStones(new int[]{3, 2, 4, 1}, 3));

        List<String> list = new ArrayList<>();
        list.add("333");
        list.add("444");
        list.add("344");
        list.add("366");
        System.out.println(list);
        list = list.stream().filter(s -> s.startsWith("3")).collect(Collectors.toList());
        System.out.println(list);
    }

    //暴力解法，从前向后   不行：总成本最小 困难了
    public static int mergeStones(int[] stones, int k) {

        int cost = stones[0];
        int index = 1;
        while (true){
            int count = k-1;
            while (count-->0 && index++ < stones.length){
                System.out.println(stones[index]);
            }
        }

    }
}
