package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.*;

/**
 * @author 陈文亮
 * @date 2023/4/25 14:06
 */
public class day46_2418按身高排序 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
        System.out.println(Arrays.toString(sortPeople(new String[]{"Alice","Bob","Bob"}, new int[]{155,185,150})));
    }


    //勉强通过
    public static String[] sortPeople(String[] names, int[] heights) {

        Map<String, Integer> map = new IdentityHashMap<>();

        for (int i = 0; i < names.length; i++) {
            if(map.containsKey(names[i])){
                String key = new String(names[i]);
                map.put(key, i);
                names[i] = key;
            }else {
                map.put(names[i],i);
            }
        }
        //System.out.println("map---"+map);

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return heights[map.get(o2)] - heights[map.get(o1)];
            }
        });

        return names;
    }

}
