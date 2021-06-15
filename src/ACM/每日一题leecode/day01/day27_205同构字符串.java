package ACM.每日一题leecode.day01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false

 */
public class day27_205同构字符串 {
    public static void main(String[] args) {

        System.out.println("这是结果=========="+isIsomorphic2("egg", "add"));//true
        System.out.println("这是结果============"+isIsomorphic2("foo", "bar"));//false
        System.out.println("这是结果============"+isIsomorphic2("paper", "title"));//true
        System.out.println("这是结果=========="+isIsomorphic2("ab", "aa"));//false
        System.out.println("这是结果=========="+isIsomorphic2("aa", "ab"));//false
    }

    public static boolean isIsomorphic(String s, String t) {
        /****
         思路:一一对应的映射,用key-value map<ch,ch>进行一一对应
         前出现的字符在后面一定是对应,一不对应就返回false
         全部对应则返回true
         ch = map.get(ch)
         ch=null
         map.add

         else{对比map.get(ch) 和另一个字符组里的ch}
         */

        /*String temp = s;
        s=t;
        t=temp;*/
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = map.get(s.charAt(i));
            System.out.println("对比了字符"+s.charAt(i)+"-"+t.charAt(i));
            if (ch==null){
                map.put(s.charAt(i),t.charAt(i));
            }else {
                if (ch!=t.charAt(i)){
                    return false;
                }
            }
        }

        //两个字符不可以映射同一个字符 解决 map中没有重复的情况 比如 a-a   b-a

        Set<Character> set = new HashSet<>();
        for (Character character : map.keySet()) {
            set.add(map.get(character));
        }

        if (set.size()!=map.size()){
            return false;
        }

        return true;
    }
    public static boolean isIsomorphic2(String s, String t) {
        /****
         思路:双向映射
         c++:
         class Solution {
         public:
         bool isIsomorphic(string s, string t) {
         unordered_map<char, char> map1;
         unordered_map<char, char> map2;
         for (int i = 0, j = 0; i < s.size(); i++, j++) {
         if (map1.find(s[i]) == map1.end()) { // map1保存s[i] 到 t[j]的映射
         map1[s[i]] = t[j];
         }
         if (map2.find(t[j]) == map2.end()) { // map2保存t[j] 到 s[i]的映射
         map2[t[j]] = s[i];
         }
         // 发现映射 对应不上，立刻返回false
         if (map1[s[i]] != t[j] || map2[t[j]] != s[i]) {
         return false;
         }
         }
         return true;
         }
         };
         */

        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = map.get(s.charAt(i));
            Character ch2 = map2.get(t.charAt(i));
            System.out.println("对比了字符"+s.charAt(i)+"-"+t.charAt(i));
            if (ch==null){
                map.put(s.charAt(i),t.charAt(i));
            }else {
                if (ch!=t.charAt(i)){
                    return false;
                }
            }
            if (ch2==null){
                map2.put(t.charAt(i),s.charAt(i));
            }else {
                if (ch2!=s.charAt(i)){
                    return false;
                }
            }
        }


        return true;
    }
}
