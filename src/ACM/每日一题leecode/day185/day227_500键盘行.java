package ACM.每日一题leecode.day185;

import java.util.*;

public class day227_500键盘行 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Alaska", "Dad"})));
        System.out.println(Arrays.toString(findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
    }

    //100/43
    public static String[] findWords(String[] words) {

        Map<Character,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        map.put('q',1);
        map.put('w',1);
        map.put('e',1);
        map.put('r',1);
        map.put('t',1);
        map.put('y',1);
        map.put('u',1);
        map.put('i',1);
        map.put('o',1);
        map.put('p',1);
        map.put('a',2);
        map.put('s',2);
        map.put('d',2);
        map.put('f',2);
        map.put('g',2);
        map.put('h',2);
        map.put('j',2);
        map.put('k',2);
        map.put('l',2);
        map.put('z',3);
        map.put('x',3);
        map.put('c',3);
        map.put('v',3);
        map.put('b',3);
        map.put('n',3);
        map.put('m',3);

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            //System.out.println(word);
            char o = word.charAt(0);
            int target = map.get(o);
            boolean flag = true;
            for (int j = 1; j < word.length(); j++) {
                if (map.get(word.charAt(j))!=target){
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(words[i]);
            }
        }

        String[] res = new String[list.size()];
        int index = 0;
        for (String s : list) {
            res[index++] = s;
        }
        return res;
    }
}
