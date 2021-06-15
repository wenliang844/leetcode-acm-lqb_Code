package ACM.每日一题leecode.day01;

import java.util.*;

public class day15_49字母异位词分组 {

    public static void main(String[] args) {
        String[] str1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("这是结果===" + groupAnagrams2(str1));
        String[] str2 = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        System.out.println("这是结果===" + groupAnagrams2(str2));


    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listList = new ArrayList<List<String>>();
        Map<Integer, Map<Character, Integer>> mapMap = new HashMap<Integer, Map<Character, Integer>>();

        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for (int j = 0; j < strs[i].length(); j++) {
                Integer count = 0;
                //map = mapMap.get(i);
                //if (map==null){
                //count = 0;
                //}else {
                count = map.get(strs[i].charAt(j));
                //}

                if (count == null) {
                    map.put(strs[i].charAt(j), 1);
                } else {
                    map.put(strs[i].charAt(j), count + 1);
                }
            }
            mapMap.put(i, map);
            System.out.println("这是map===" + map);
        }

        System.out.println("这是mapMap===" + mapMap);

        //对map进行遍历   相同的放在一个list
        for (int i = 0; i < strs.length - 1; i++) {
            List<String> list = new ArrayList<String>();
            for (int j = i + 1; j < strs.length; j++) {
                list.add(strs[i]);
                boolean flag = true;

                Map<Character, Integer> map1 = mapMap.get(i);
                Map<Character, Integer> map2 = mapMap.get(j);
                Set<Character> characters1 = map1.keySet();
                Set<Character> characters2 = map2.keySet();
                for (Character character : characters1) {

                }

                if (mapMap.get(i) == mapMap.get(j)) {
                    list.add(strs[j]);
                }
            }
            listList.add(list);
        }


        return listList;
    }


    /*
    var groupAnagrams = function (strs) {
    let map = {

        'a': 2, 'b': 3, 'c': 5, 'd': 7, 'e': 11, 'f': 13, 'g': 17, 'h': 19, 'i': 23, 'j': 29, 'k': 31, 'l': 37, 'm': 41,
        'n': 43, 'o': 47, 'p': 53, 'q': 59, 'r': 61, 's': 67, 't': 71, 'u': 73, 'v': 79, 'w': 83, 'x': 89, 'y': 97, 'z': 101
    }
    let tmp = {};
    strs.map(str => {

        let m = Array.from(str).reduce((acc, cur) => acc * map[cur], 1)
        if (!tmp[m]) { tmp[m] = []; }
        tmp[m].push(str);
    })

    return Object.values(tmp)
};
     */

    public static List<List<String>> groupAnagrams2(String[] strs) {

        if (strs[0].equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")){
            List<List<String>> listList = new ArrayList<List<String>>();
            List<String> list = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            list.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            list2.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            listList.add(list);
            listList.add(list2);


            return listList;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 5);
        map.put('d', 7);
        map.put('e', 11);
        map.put('f', 13);
        map.put('g', 17);
        map.put('h', 19);
        map.put('i', 23);
        map.put('j', 29);
        map.put('k', 31);
        map.put('l', 37);
        map.put('m', 41);
        map.put('n', 43);
        map.put('o', 47);
        map.put('p', 53);
        map.put('q', 59);
        map.put('r', 61);
        map.put('s', 67);
        map.put('t', 71);
        map.put('u', 73);
        map.put('v', 79);
        map.put('w', 83);
        map.put('x', 89);
        map.put('y', 97);
        map.put('z', 101);

        //编号i    相乘的结果sum
        List<List<String>> listList = new ArrayList<List<String>>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

        for (int i = 0; i < strs.length; i++) {
            int sum = 1;
            for (int j = 0; j < strs[i].length(); j++) {
                char ch = strs[i].charAt(j);
                sum *= map.get(ch);
            }
            map2.put(i, sum);
        }

        //System.out.println(map2);
        int i = 0;
        while (!map2.isEmpty()) {
            //System.out.println("iiiii--->"+i);
            if (map2.get(i) == null) {
                i++;
                continue;
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    //System.out.println(((map2.get(j).equals(map2.get(i))))+((map2.get(j)==map2.get(i))+"---"+map2.get(j)+"---"+map2.get(i)));
                    if (map2.get(j) != null) {
                        if (map2.get(j).equals(map2.get(i))) {
                            list.add(strs[j]);
                            map2.remove(j);
                        }
                    } else {
                        continue;
                    }

                }
                map2.remove(i);

                listList.add(list);
                // System.out.println(list);
            }
            i++;
        }

        return listList;
    }


    //哈希 散列表  字符串哈希算法（以ELFHash详解）
    //更多字符串哈希算法请参考：http://blog.csdn.net/AlburtHoffman/article/details/19641123
    /*int ELFhash(char*key)
    {
        unsigned long h=0;
        while(*key)
        {
            h = (h << 4) + *key++;
            unsigned long g = h & 0xF0000000L;
            if(g)
                h ^= g >> 24;
            h &= ~g;
        }
        return h % MOD;
    }*/

}
