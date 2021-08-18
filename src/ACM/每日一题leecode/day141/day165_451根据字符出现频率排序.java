package ACM.每日一题leecode.day141;

import java.util.*;

public class day165_451根据字符出现频率排序 {
    public static void main(String[] args) {
        System.out.println(frequencySort2("tree"));
    }

    public static String frequencySort(String s) {
        String res = "";
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] c26 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c26[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (c26[i] != 0) {
                map.put(i, c26[i]);
            }
        }
        System.out.println(Arrays.toString(c26));
        System.out.println(map);
        Arrays.sort(c26);
        for (int i = 25; i >= 0; i--) {
            int count = c26[i];
            if (count == 0) break;
            char ch = (char) (map.get(count) + 'a');
            while (count-- > 0) {
                res += ch;
            }
        }
        return res;
    }

    //用int[][]自定义排序 count-ch   5/34
    public static String frequencySort2(String s) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int[][] count_ch = new int[map.size()][2];
        int index = 0;
        for (Character character : map.keySet()) {
            Integer integer = map.get(character);
            count_ch[index][0] = integer;
            count_ch[index][1] = character;
            index++;
        }
       /* for (int i = 0; i < map.size(); i++) {
            System.out.println(Arrays.toString(count_ch[i]));
        }*/
        Arrays.sort(count_ch, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return t1[0] - ints[0];
            }
        });
        //System.out.println("sort后:----------");
        /*for (int i = 0; i < map.size(); i++) {
            System.out.println(Arrays.toString(count_ch[i]));
        }*/
        for (int i = 0; i < count_ch.length; i++) {
            while (count_ch[i][0]-- > 0) {
                res += (char) count_ch[i][1];
            }
        }
        return res;
    }

    //官方:63/92 用sb容器 用list通过map.get(list[1]) map.get(list[2])进行排序
    public String frequencySort3(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //3桶排序:官方
    public String frequencySort4(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxFreq = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }

}
