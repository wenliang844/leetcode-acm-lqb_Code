package ACM.每日一题leecode.day185;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day234_438找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("aaa", "aaaaa"));
        System.out.println(findAnagrams("aaa", "aaa"));
    }

    //18 6
    public static List<Integer> findAnagrams(String s, String p) {

        //滑动窗口 map计数
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int len1 = p.length();
        int len2 = s.length();
        if (len2<len1){
            return list;
        }
        for (int i = 0; i < len1; i++) {
            map1.put(p.charAt(i), map1.getOrDefault(p.charAt(i), 0) + 1);
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (map1.equals(map2)) {
            list.add(0);
        }
        for (int i = len1; i < len2; i++) {
            //add
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
            //del
            Integer integer = map2.get(s.charAt(i - len1));
            if (integer > 1) {
                map2.put(s.charAt(i - len1), integer - 1);
            } else {
                map2.remove(s.charAt(i - len1));
            }
            if (map1.equals(map2)) {
                list.add(i - len1 + 1);
            }
        }

        return list;
    }
}
