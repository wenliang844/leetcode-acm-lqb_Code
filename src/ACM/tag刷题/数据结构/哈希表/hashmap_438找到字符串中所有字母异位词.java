package ACM.tag刷题.数据结构.哈希表;

import java.util.*;

public class hashmap_438找到字符串中所有字母异位词 {
    /***
     给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     说明：
     字母异位词指字母相同，但排列不同的字符串。
     不考虑答案输出的顺序。
     示例 1:
     输入:
     s: "cbaebabacd" p: "abc"
     输出:
     [0, 6]
     解释:
     起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     */
    //方法一:用map,如果窗口内的个数一样,但是不equal就是异同位 超时35/36
    public static List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        List<Integer> resList = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {//构造要匹配的map
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= s.length() - pLen; i++) {
            int j = i + pLen;
            Map<Character, Integer> temp = new HashMap<Character, Integer>();
            temp.putAll(map);
            String substring = s.substring(i, j);
            //if (substring.equals(p)) continue;
            for (int k = 0; k < substring.length(); k++) {
                char c = substring.charAt(k);
                Integer integer = temp.get(c);
                if (integer != null) {
                    if (integer > 1) {//有重复的情况
                        temp.put(c, integer - 1);
                    } else {
                        temp.remove(c);
                    }
                }
            }

            //对temp进行分析,如果temp==空了,就是有了,把i加进来
            if (temp.isEmpty()) {
                resList.add(i);
            }
        }

        return resList;
    }

    //方法二:用set+滑动窗口效率更高
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        Set<Character> set = new HashSet<Character>();
        Set<Character> tempSet = new HashSet<Character>();
        for (int i = 0; i < p.length(); i++) {//构造原始set
            set.add(p.charAt(i));
        }

        int i = 0;
        int j = i + p.length()-1;
        for (int k = i; k <= j; k++) {
            if (set.contains(s.charAt(k))) {
                tempSet.add(s.charAt(k));
            }
        }
        while (j < s.length()-1) {
            System.out.println(tempSet);
            if (set.size() == tempSet.size()) {
                resList.add(i);
            }
            tempSet.remove(s.charAt(i));
            if (set.contains(s.charAt(j+1))) {
                tempSet.add(s.charAt(j+1));
            }
            i++;
            j++;
        }
        return resList;
    }

    //方法三,用数组实现单词计数,比较 61 51
    public static List<Integer> findAnagrams3(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        int[] s_count = new int[26];
        int[] p_count = new int[26];

       if (s.length()<p.length())return resList;

        int left = 0;
        int right = -1;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            char c1 = s.charAt(i);
            p_count[c-'a']++;
            s_count[c1-'a']++;
            right++; //使窗口达到固定长度 right达到 0+p.length
        }

        if (Arrays.equals(s_count,p_count)){
            resList.add(left);
        }
        while (right < s.length()-1) {
            s_count[s.charAt(left)-'a']--;//左指针的字符去掉
            left++; //左指针左移动一个
            right++;//右指针右移动一个
            s_count[s.charAt(right)-'a']++;//右指针对应的字符加起来

            if (Arrays.equals(s_count,p_count)){
                resList.add(left);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams3("cbaebabacd", "abc"));//0 6
        System.out.println(findAnagrams3("abab", "ab"));//0 1 2

    }
}
