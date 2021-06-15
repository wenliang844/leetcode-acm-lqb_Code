package ACM.每日一题leecode.day01;

import java.util.HashMap;
import java.util.Map;

public class day11_860柠檬水找零 {
    public static void main(String[] args) {
        int[] nums1 = {5, 5, 5, 10, 20};
        System.out.println("--1-------------------" + lemonadeChange(nums1));
        int[] nums2 = {5, 5, 10};
        System.out.println("--2-------------------" + lemonadeChange(nums2));
        int[] nums3 = {10, 10};
        System.out.println("--3-------------------" + lemonadeChange(nums3));
        int[] nums4 = {5, 5, 10, 10, 20};
        System.out.println("--4-------------------" + lemonadeChange(nums4));
        int[] nums5 = {5, 5,10, 20};
        System.out.println("--5-------------------" + lemonadeChange(nums5));

    }

    public static boolean lemonadeChange(int[] bills) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < bills.length; i++) {

            Integer count = map.get(bills[i]);
            /*if (count == null) {
                System.out.println("null-->加了1");
                if (bills[i] == 5) {
                    map.put(bills[i], 1);
                }
                *//*if (bills[i] == 10) {
                    map.put(10, 1);
                }
                if (bills[i] == 20) {
                    map.put(20, 1);
                }*//*

            } else {*/

            if (bills[i] == 5) {
                if (count != null)
                    map.put(5, count + 1);
                else
                    map.put(5, 1);
                System.out.println("收了5美元===");
            }
            if (bills[i] == 10) {
                Integer a = map.get(5);
                if (a != null) {
                    map.put(5, map.get(5) - 1);
                    System.out.println("-5美元===");
                } else {
                    return false;
                }
                if (count != null)
                    map.put(10, count + 1);
                else map.put(10, 1);
                System.out.println("收了10美元===");
            }
            if (bills[i] == 20) {
                if (map.get(10) != null && map.get(5) != null && (int) map.get(10) > 0 && (int) map.get(5) > 0) {
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                    System.out.println("-10+5美元===");
                } else if (map.get(5) != null && (int) map.get(5) >= 3) {
                    map.put(5, map.get(5) - 3);
                    System.out.println("-5+5+5美元===");
                } else {
                    return false;
                }

                if (count != null)
                    map.put(20, count + 1);
                else map.put(20, 1);
                System.out.println("收了20美元===");
            }
        }


        return true;
    }
}
