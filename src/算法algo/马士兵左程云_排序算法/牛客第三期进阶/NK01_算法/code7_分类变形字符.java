package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.util.*;

public class code7_分类变形字符 {

    /**
     * 题目:将一个字符序列,按照字符的含量相同分组
     */
    //方法一:将所有字符按字典序排序,在判断大小:不可行  排序后的结果分组
    //单词计数,记录每个字符串的单词数量,一样的数量属于一组
    //用一个map装一个map单词计数 对应的list序号
    //可以用一个数组record记录二十四个字符的出现次数
    public static List<List<String>> strClassfiy(List<String> list) {
        Map<Map<Character, Integer>, Integer> map = new HashMap<>();
        int index = 0;
        List<List<String>> resList = new ArrayList<>();
//        List<String> resList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<Character, Integer> map1 = new HashMap<>();//主要担心问题:每次创建的map1是不是同一个map1,能不能从map取出下标
            String s = list.get(i);
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                Integer integer = map1.get(ch);
                if (integer == null) {
                    map1.put(ch, 1);
                } else {
                    map1.put(ch, integer + 1);
                }
            }

            //计数完成之后,进行map对map1的一个查找
            Integer integer = map.get(map1);
            if (integer == null) {//创建一个新的下标
                map.put(map1, index);
                index++;
                List<String> temp = new ArrayList<>();
                temp.add(s);
                resList.add(temp);
            } else {//非空,证明存在了,只要在resList[integer]中加入就可以
                resList.get(integer).add(s);
            }

        }

        System.out.println(map);
        System.out.println(resList);
        return resList;
    }

    //方法二:遍历list<String> 每个string进行字典序排序 即可 map<排序词代表,匹配词> 进行分类
    public static List<List<String>> strClassfiy2(List<String> list) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : list) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        System.out.println(map);

        return null;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("eat");
        list.add("tea");
        list.add("tan");
        list.add("ate");
        list.add("nat");
        list.add("bat");
        System.out.println(strClassfiy2(list));
    }
}
