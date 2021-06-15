package 蓝桥杯.蓝桥杯大赛历届真题.第一届国际赛真题;

import java.util.HashMap;
import java.util.Map;

public class C基因配对 {
    /**
     * ATGC
     * 只能AT GC
     * <p>
     * 如AAATC   配对TTTAG
     * 给两个字符串能不能配对
     */
    public static boolean isMatch(String l, String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('A', 'T');
        map.put('T', 'A');
        map.put('G', 'C');
        map.put('C', 'G');
        //1.暴力解法
        for (int i = 0; i < l.length(); i++) {
            //从i=0开始,看以i开头能否配对
            boolean match = true;
            int index = i;
            for (int j = 0; j < s.length(); j++) {
                if (map.get(s.charAt(j)) != l.charAt(index)) {
                    System.out.println(index+"---"+j+"这两个下标false");
                    match = false;
                    break;
                }
                System.out.println(s.charAt(j) + "---" + l.charAt(index)+"i="+index+"j="+j);
                index++;
            }

            if (match) {
                System.out.println(i);
                return match;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ATCAAATCG", "TTTAG"));
    }
}
