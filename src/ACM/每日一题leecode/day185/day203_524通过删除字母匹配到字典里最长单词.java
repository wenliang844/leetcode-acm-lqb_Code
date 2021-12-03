package ACM.每日一题leecode.day185;

import java.util.*;

public interface day203_524通过删除字母匹配到字典里最长单词 {
    static List<String> toList(String[] strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", toList(new String[]{"ale", "apple", "monkey", "plea","appne","appae","appze"})));
        System.out.println(findLongestWord("abpcplea", toList(new String[]{"a","b","c"})));
    }



    //方法一:排序:长到小 相同就按照字典序   比较 42|84
    public static String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (t1.length()!=s.length()){
                    return t1.length()-s.length();
                }else {
                    return s.compareTo(t1);
                }
            }
        });
        //System.out.println(dictionary);

        //从大到小 判断是否全包含
        for (int i = 0; i < dictionary.size(); i++) {
            String target = dictionary.get(i);
            if (check(s,target)){
                return target;
            }
        }
       //return null;//30/31
        return "";
    }

    //判断origin是否全包含target
    static boolean check(String originStr, String targetStr) {
        //System.out.println(originStr+"----------"+targetStr);
        int originIndex = 0;
        int targetIndex = 0;
        while (targetIndex<targetStr.length() && originIndex<originStr.length()){
            if (originStr.charAt(originIndex)==targetStr.charAt(targetIndex)){
                targetIndex++;
            }
            originIndex++;
            //System.out.println(originIndex+"--"+targetIndex);
        }
        return targetIndex == targetStr.length();
    }
}
