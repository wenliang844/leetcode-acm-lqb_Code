package ACM.tag刷题.算法.深度优先dfs;

import sun.plugin.javascript.navig.Link;

import java.util.*;

public class dfs_17电话号码的字母组合 {
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //示例 1：
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]  25 58
    static class ListLink{
        char value;
        ListLink next;
        ListLink(){

        }
        ListLink(char value){
            this.value=value;
        }

        @Override
        public String toString() {
            return "ListLink{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void getDeep(Map<Character,String> map,ListLink queue,String s,List<String> list){
        if (queue !=null){
            Character poll = queue.value;
            //System.out.println(poll);//2
            String s1 = map.get(poll);
            //System.out.println(s1);//abc def
            String[] split = s1.split("");
            for (int i = 0; i < split.length; i++) {
                getDeep(map,queue.next,s+split[i],list);
            }
        }else {
            list.add(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals(""))return list;
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        char[] chars = digits.toCharArray();
        //Queue<Character> queue = new LinkedList<>();
        ListLink queue = new ListLink(chars[0]);
        ListLink cur = new ListLink();
        cur = queue;
        for (int i = 1; i < chars.length; i++) {
            ListLink tmp = new ListLink(chars[i]);
            cur.next=tmp;
            cur = cur.next;
        }
        //System.out.println(queue);//2 3
        //System.out.println(map);

        getDeep(map,queue,"",list);

        return list;
    }

    public static void main(String[] args) {
        System.out.println("这是结果"+letterCombinations("23"));
        System.out.println(letterCombinations("234"));
        System.out.println(letterCombinations(""));
    }
}
