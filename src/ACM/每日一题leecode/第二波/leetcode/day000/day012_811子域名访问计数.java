package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈文亮
 * @date 2022/10/5 14:32
 */
public class day012_811子域名访问计数 {
    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String cpdomain : cpdomains) {
            String[] splitCpdomain = cpdomain.split(" ");
            //System.out.println(Arrays.toString(splitCpdomain));
            Integer number = Integer.valueOf(splitCpdomain[0]);
            String[] split = splitCpdomain[1].split("\\.");
            //System.out.println(Arrays.toString(split));
            String start = split[split.length-1];
            map.put(start, map.getOrDefault(start, 0) + number);
            for (int i = split.length - 2; i >= 0; i--) {
                start = split[i] + "." + start;
                map.put(start, map.getOrDefault(start, 0) + number);
            }
        }
        //System.out.println(map);
        for (String s : map.keySet()) {
            Integer integer = map.get(s);
            res.add(integer + " " + s);
        }
        return res;
    }
}
