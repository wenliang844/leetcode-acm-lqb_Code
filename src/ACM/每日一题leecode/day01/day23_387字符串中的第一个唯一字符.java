package ACM.每日一题leecode.day01;

import java.util.HashMap;
import java.util.Map;

public class day23_387字符串中的第一个唯一字符 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar2("leetcode"));
        System.out.println(firstUniqChar2("loveleetcode"));

    }

    //解法1：暴力解法
    /*
   思想:1.遍历从0开始   判断后面还会不会出现
        2.不出现,则返回,退出
     */
    public static int firstUniqChar(String s) {

        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i;
            }
            flag = true;
        }

        return -1;
    }

    /*
    思想2:
    和出现次数有关的，不要犹豫，hash
    hashmap计数 :直接用
    方法一：使用哈希表存储频数
思路与算法
我们可以对字符串进行两次遍历。
在第一次遍历时，我们使用哈希映射统计出字符串中每个字符出现的次数。在第二次遍历时，
我们只要遍历到了一个只出现一次的字符，那么就返回它的索引，否则在遍历结束后返回 -1−1。
     */
    public static int firstUniqChar2(String s) {

        //map计数器
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        Integer count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = map.get(s.charAt(i));
            if (count==null){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),count+1);
            }
        }

        System.out.println(map);

        for (Character character : map.keySet()) {
            if (map.get(character)==1){
                return s.indexOf(character);
            }
        }


        return -1;
    }

    /*
    最好的方法:leecode字符串   直接用s.indexof(s.charAt(i))==s.lastIndexOf(s[i]) 返回i
     */
    public static int firstUniqChar3(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) return i;
        return -1;
    }

}
