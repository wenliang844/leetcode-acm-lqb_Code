package ACM.leecode周赛.第57场双周赛;

import java.util.HashMap;
import java.util.Map;

public class lee1_5804检查是否所有字符出现次数相同 {
    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
    }

    //count
    public static boolean areOccurrencesEqual(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int baseCount = map.get(s.charAt(0));

        for (Integer value : map.values()) {
            if (value != baseCount){
                return false;
            }
        }

        return true;
    }
}
