package ACM.每日一题leecode.day185;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day217_187重复的DNA序列 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    //方法一:把子串为10的都进行map计数 8|37
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String temp = s.substring(i,i+10);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }

        System.out.println(map);

        for (String temp : map.keySet()) {
            if (map.get(temp)>1){
                list.add(temp);
            }
        }
        return list;
    }
}
