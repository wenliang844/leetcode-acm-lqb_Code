package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.*;

/**
 * @author 陈文亮
 * @date 2022/8/12 15:53
 */
public class day002_1282用户分组 {
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(Arrays.asList(1, 2));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])){
                map.get(groupSizes[i]).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i],list);
            }
        }

        System.out.println(map);

        List<List<Integer>> resList = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            List<Integer> list = map.get(integer);
            if (list.size() == integer){
                resList.add(list);
            }else {
                List<List<Integer>> lists = partList(list, integer);
                resList.addAll(lists);
            }
        }
        return resList;
    }

    public static <T> List<List<T>> partList(List<T> source, int n) {

        if (source == null) {
            return null;
        }

        if (n == 0) {
            return null;
        }
        List<List<T>> result = new ArrayList<List<T>>();
        // 集合长度
        int size = source.size();
        // 余数
        int remaider = size % n;
        System.out.println("余数:" + remaider);
        // 商
        int number = size / n;
        System.out.println("商:" + number);

        for (int i = 0; i < number; i++) {
            List<T> value = source.subList(i * n, (i + 1) * n);
            result.add(value);
        }

        if (remaider > 0) {
            List<T> subList = source.subList(size - remaider, size);
            result.add(subList);
        }
        return result;
    }
}
