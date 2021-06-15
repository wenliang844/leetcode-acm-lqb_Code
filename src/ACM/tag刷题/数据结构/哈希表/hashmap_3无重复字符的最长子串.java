package ACM.tag刷题.数据结构.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hashmap_3无重复字符的最长子串 {

    /***
     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     输入: s = "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    //方法一:暴力法:每个子串sub进行map计数,有重复直接brenk,没有重复就将这个长度记下 超时:986/987
    public static int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                //System.out.println("每一个subString"+substring);
                //测试这个substring 如果没有重复字符,maxLne更新
                Map<Character, Integer> map = new HashMap<>();
                boolean flag = true;
                for (int k = 0; k < substring.length(); k++) {
                    Integer integer = map.get(substring.charAt(k));
                    if (integer == null) {
                        map.put(substring.charAt(k), 1);
                    } else {
                        //说明已经有这个字符了,直接退出
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    //System.out.println("符合条件的substring"+substring);
                    maxLen = Math.max(maxLen, substring.length());
                }
            }
        }

        return maxLen;
    }

    //方法一优化 9 9
    public static int lengthOfLongestSubstring2(String s) {

        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            //从i=0开始,贪心的向前map,直到map有重复的,brak,下一个i
            int j = i;
            Map<Character, Integer> map = new HashMap<>();
            while (j < s.length()) {
                //String substring = s.substring(i, j);
                //System.out.println("每一个subString"+substring);
                //测试这个substring 如果没有重复字符,maxLne更新
                Integer integer = map.get(s.charAt(j));
                if (integer == null) {
                    map.put(s.charAt(j), 1);
                    j++;
                } else {
                    //说明已经有这个字符了,直接退出

                    break;
                }
            }
            maxLen = Math.max(maxLen, j - i);
        }
        //如果一直有不相同的,将maxLen在while之后执行即可

        return maxLen;
    }

    //方法二:set采用 __滑动窗口的方法
    public static int lengthOfLongestSubstring3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("bbbbbbb"));
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
        System.out.println(lengthOfLongestSubstring3(" "));
        System.out.println(lengthOfLongestSubstring3("ababab"));
        System.out.println(lengthOfLongestSubstring3("ab"));
        System.out.println(lengthOfLongestSubstring3("abc"));
        System.out.println(lengthOfLongestSubstring3("abcd"));
    }
}
