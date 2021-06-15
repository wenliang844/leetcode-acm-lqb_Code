package ACM.tag刷题.数据结构.哈希表;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hashmap_76最小覆盖子串 {
    /***
     给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

     示例 1：
     输入：s = "ADOBECODEBANC", t = "ABC"
     输出："BANC"
     示例 2：
     输入：s = "a", t = "a"
     输出："a"
     */
    //方法一:扫描一遍,i为开头,如果后面的字符是ABC中的一个,map计数 超时 265/266
    public static String minWindow(String s, String t) {
        String res = "";
        //将t元素中的所有封装进map计数
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer integer = targetMap.get(t.charAt(i));
            if (integer == null) {
                targetMap.put(t.charAt(i), 1);
            } else {
                targetMap.put(t.charAt(i), integer + 1);
            }
        }

        //从i开始,贪心的选择元素,如果加入了某个元素,能让map置空,则直接res更新,搞下一个i++
        //=为地址  putAll是深复制
        //integer要比较的话必须使用equal   integer => get(x).intValue
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            Map<Character, Integer> temp = new HashMap<>();
            temp.putAll(targetMap);
            //System.out.println(temp);//赋值成功
            while (j < s.length()) {
                Integer integer = temp.get(s.charAt(j));
                if (integer != null) {
                    if (integer > 1) {
                        temp.put(s.charAt(j), integer - 1);
                    } else {
                        temp.remove(s.charAt(j));
                    }
                    //System.out.println("感受tempMap的变化="+temp);
                    //System.out.println("---"+targetMap);
                }
                j++;

                if (temp.isEmpty()) {
                    String substring = s.substring(i, j);
                    //System.out.println("这是每次的substring="+substring);
                    if (res.length() == 0 || substring.length() < res.length()) {
                        res = substring;
                    }
                    break;
                }
            }

        }

        return res;
    }

    //计数:滑动窗口+计数索引

    /****
     1. 注意到题目的关键："所有字母的最小子串"，也就是说两个串都只能是字母。
     2. 于是，可以开辟一个大小为64的数组，来存放数组中字母的频率(Frequency)。准确的说，
     通过字母的ASCII码作为数组的索引，开辟空间的大小为26+6+26=58：26个大写字母，26个小写字母，
     还有中间的6个非字母  A~Z[65~90]  非字母[91~96]  a~z[97~122]
     3. 滑动窗口的使用：分三种情况来移动窗口：（这里令当前窗口的左右边界分别为l，r，窗口的大小为winSize=r-l+1）
     1) 当winSize < t.size()  r++;  也就是窗口右边界向右移动
     2) 当winSize == t.size() :
     2.1) 当窗口中的字符已经符合要求了，直接返回return，已经找到了
     2.2) 否则r++，窗口右边界向右移动
     3) 当winSize > t.size()
     3.1) 当窗口中的字符已经符合要求了，l++，窗口左边界向右移动
     3.2) 否则r++，窗口右边界向右移动

     4. 上面是滑动窗口的使用思路，具体实现上有一定的不同，下面是需要考虑到的要点：
     1) 啥叫作窗口中的字符已经符合要求了？
     2) 窗口滑动时的操作是关键
     3) 要考虑到数组越界的问题
     */

    /****
     官方解答:
     这样可能出现 \rm XXABXXCXXABXXC 的情况，在统计长度的时候可以扔掉前两个 \rm XX，但是不扔掉中间的 \rm XX，怎样解决这个问题呢？

     */
    //官方方法
    static Map<Character, Integer> origin = new HashMap<>();//要匹配的ABC
    static Map<Character, Integer> cnt = new HashMap<>();//窗口内的
    public static String minWindow2(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {//将要匹配的个数封装到oriMap
            char c = t.charAt(i);
            origin.put(c, origin.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int r = -1;
        int len = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        int sLen = s.length();
        while (check() && r < sLen) {//当右指针小于s串的长度
            if (r - 1 + 1 < len) {
                len = r - 1 + 1;
                ansL = l;
                ansR = l + len;
            }
            if (origin.containsKey(s.charAt(l))) {
                cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 1) - 1);
            }
            ++l;

        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);

    }

    private static boolean check() {//检测窗口是否符合,符合的话就不必继续了
        Iterator<Map.Entry<Character, Integer>> iterator = origin.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (cnt.getOrDefault(key,0)<value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //测试map可不可以为空
        //Map<Integer,Integer> map = new HashMap<>();

        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow2("a", "a"));
        System.out.println(minWindow2("a", "aa"));

    }
}
