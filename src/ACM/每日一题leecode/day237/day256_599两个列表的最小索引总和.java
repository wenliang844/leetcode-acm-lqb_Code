package ACM.每日一题leecode.day237;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class day256_599两个列表的最小索引总和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant(new String[]{"a", "b", "c", "d"}, new String[]{"h", "b", "c", "t"})));
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"KFC","Shogun","Burger King"})));
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"KFC","Burger King","Tapioca Express","Shogun"})));
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun","Piatti","Tapioca Express","Burger King","KFC"}, new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"})));
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"KFC","Shogun","Burger King"})));
    }

    //方法1：暴力破解 最小索引
    public static String[] findRestaurant(String[] list1, String[] list2) {
        boolean flag = false;
        Set<String> res = new HashSet<>();
        int i = 0;
        int j = 0;
        int minI = 0;
        int minJ = 0;
        for (; i < list1.length; i++) {
            for (; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    res.add(list1[i]);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            j=0;
        }
        System.out.println("i="+i+",j="+j);
        while (i<list1.length && j<list2.length &&i>=0 &&j>=0){
            if (list1[i].equals(list2[j])) {
                res.add(list1[i]);
            }
            i++;
            j--;
        }
        return res.toArray(new String[res.size()]);
    }
    public static String[] findRestaurant2(String[] list1, String[] list2) {
        Set<String> res = new HashSet<>();
        int minI = 0;
        int minJ = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int sum = i+j;
                    if (sum<minSum){
                        minI = i;
                        minJ = j;
                    }
                }
            }
        }
        System.out.println("i="+minI+",j="+minJ);
        while (minI<list1.length && minJ<list2.length &&minI>=0 &&minJ>=0){
            if (list1[minI].equals(list2[minJ])) {
                res.add(list1[minI]);
            }
            minI++;
            minJ--;
        }
        return res.toArray(new String[res.size()]);
    }
    public static String[] findRestaurant3(String[] list1, String[] list2) {
        return IntStream.range(0, list1.length + list2.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> i < list1.length ? list1[i] : list2[i - list1.length]))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 2)
                .collect(Collectors.groupingBy(entry -> entry.getValue().get(0) + entry.getValue().get(1), TreeMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .values()
                .iterator()
                .next()
                .toArray(new String[0]);
    }
}
