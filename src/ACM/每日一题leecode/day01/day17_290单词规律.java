package ACM.每日一题leecode.day01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day17_290单词规律 {

    public static void main(String[] args) {
        System.out.println("这是结果==="+wordPattern("abba", "dog cat cat dog"));
        System.out.println("这是结果==="+wordPattern("abba", "dog cat cat fish"));
        System.out.println("这是结果==="+wordPattern("aaaa", "dog cat cat dog"));
        System.out.println("这是结果==="+wordPattern("abba", "dog dog dog dog"));
        System.out.println("这是结果==="+wordPattern("abc", "dog cat dog"));
        System.out.println("这是结果==="+wordPattern("aaa", "aa aa aa aa"));

    }

    public static boolean wordPattern(String pattern, String s) {



        char[] chs = pattern.toCharArray();
        String[] ss = s.split(" ");
        /*for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]+"---"+ss[i]);
        }*/
        if (chs.length!=ss.length){
            return false;
        }

        Map<Character,String> map = new HashMap<Character, String>();
        String s1;

        for (int i = 0; i < chs.length; i++) {
            s1 = map.get(chs[i]);
            if (s1==null){
                map.put(chs[i],ss[i]);
                //System.out.println("匹配的==="+chs[i]+"---"+ss[i]);
                if(map.size()>1 && map.get(chs[i]).equals(map.get(chs[i-1]))){
                    return false;
                }
            }else {
                if (s1.equals(ss[i])){
                    continue;
                }else {
                    //System.out.println("这是不匹配的==="+chs[i]+"---"+ss[i]);
                    return false;
                }
            }
        }
        //System.out.println(map);
        //pattern = "abba", str = "dog dog dog dog"- ----这种情况不可以
        //方法一 :判断map是否有重复值   用set自动去重复功能
        Set<String> set = new HashSet<String>();
        for (Character character : map.keySet()) {
            set.add(map.get(character));
        }
        if (map.size()!=set.size()){
            return false;
        }
        return true;
    }
}
