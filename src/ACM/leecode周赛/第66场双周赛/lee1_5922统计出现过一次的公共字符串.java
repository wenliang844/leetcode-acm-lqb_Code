package ACM.leecode周赛.第66场双周赛;

import java.util.HashMap;
import java.util.Map;

public class lee1_5922统计出现过一次的公共字符串 {
    public static void main(String[] args) {

    }

    //方法一:mapCount
    public static int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words1.length; i++) {
            map1.put(words1[i], map1.getOrDefault(words1[i], 0) + 1);
        }

        for (int i = 0; i < words2.length; i++) {
            map2.put(words2[i], map2.getOrDefault(words2[i], 0) + 1);
        }
        for (String s : map1.keySet()) {
            if (map1.get(s) == 1) {
                if (map2.containsKey(s) && map2.get(s)==1) {
                    count++;
                }
            }
        }

        return count;
    }
}
