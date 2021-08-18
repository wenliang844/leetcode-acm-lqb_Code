package ACM.每日一题leecode.day141;

import java.lang.reflect.Array;
import java.util.*;

public class day176_面试题10_02变位词组 {

    /***
     输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     输出:
     [
     ["ate","eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]
     */
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    //方法一: compareTo排序 + map计数
    //选择合适的哈希算法求出数组中每个字符的哈希值，值一样的放入一个list数组中即可
    //采用26个素数进行 20/23
    public static List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        List<List<String>> list = new ArrayList<>();
        int len = strs.length;
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            values[i] = calcHash(strs[i]);
        }

        //map {values[i] -> index}
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(values[i])){
                map.get(values[i]).add(i);
            }else {
                //Arrays.asList(i) 不能添加删除元素
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(values[i], temp);
            }
        }

        for (List<Integer> indexs : map.values()) {
            List<String> temp = new ArrayList<>();
            for (Integer index : indexs) {
                temp.add(strs[index]);
            }
            list.add(temp);
        }
        return list;
    }

    public static int calcHash(String s) {
        //String alphas = "abcdefghijklmnopqrstuvwxyz";
        int[] values = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        int hashValue = 1;
        for (int i = 0; i < s.length(); i++) {
            //hashValue *= values[alphas.indexOf(s.charAt(i))];
            hashValue *= values[s.charAt(i) - 'a'];
        }
        return hashValue;
    }


}
