package ACM.其他的算法比赛.笔试.阅文科技;

import java.util.HashMap;
import java.util.Map;

public class yw1字符串的排列 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("bc", "abcd"));
        System.out.println(checkInclusion("bc", "a"));
        System.out.println(checkInclusion("bc", "cd"));
        System.out.println(checkInclusion("", ""));
        System.out.println(checkInclusion("asdf", "asdff"));
    }


    //滑动窗口 加一个减一个,判断是否数量一致
    public static boolean checkInclusion (String s1, String s2) {
        // write code here
        if (s1.length()>s2.length()){
            return false;
        }

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        //System.out.println(map1);
        //System.out.println(map2);
        if (checkMap(map1,map2)){
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
            Integer integer = map2.get(s2.charAt(i - s1.length()));
            if (integer==1){
                map2.remove(s2.charAt(i-s1.length()));
            }else {
                map2.put(s2.charAt(i-s1.length()),integer-1);
            }

            //System.out.println("map1:--"+i+"--"+map1);
            //System.out.println("map2:--"+i+"--"+map2);
            if (checkMap(map1,map2)){
                return true;
            }
        }

        return false;
    }

    public static boolean checkMap(Map<Character,Integer> map1,Map<Character,Integer> map2){
        for (Character c : map1.keySet()) {
            if (!map2.containsKey(c) || !map2.get(c).equals(map1.get(c))){
                return false;
            }
        }

        return true;
    }
}
