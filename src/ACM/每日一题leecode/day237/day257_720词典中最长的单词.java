package ACM.每日一题leecode.day237;

import java.util.*;

public class day257_720词典中最长的单词 {
    public static void main(String[] args) {
        List<String> map = new ArrayList<>();
        map.add(null);
        map.add("");
        System.out.println(map);
        System.out.println("apple".compareTo("apply"));
        System.out.println(longestWord3(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"}));//由于没有e ewqz不能算
        System.out.println(longestWord3(new String[]{"a","banana","app","appl","ap","apply","apple"}));

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time1=" + (endTime - startTime));

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            longestWord2(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("time1=" + (endTime2 - startTime2));

        startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            longestWord2(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
        }
        endTime2 = System.currentTimeMillis();
        System.out.println("time1=" + (endTime2 - startTime2));
    }

    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Map<String, String> map = new HashMap<>();
        map.put(words[0], "flag");
        String res = words[0];
        for (int i = 1; i < words.length; i++) {
            if (map.containsKey(words[i].substring(0, words[i].length() - 1)) && words[i].length() > res.length()) {
                res = words[i];
            }
            map.put(words[i], "flag");
        }
        return res;
    }

    public static String longestWord2(String[] words) {
        Arrays.sort(words);
        Set<String> map = new HashSet<>();
        map.add(words[0]);
        String res = words[0];
        for (int i = 1; i < words.length; i++) {
            if (map.contains(words[i].substring(0, words[i].length() - 1)) && words[i].length() > res.length()) {
                res = words[i];
            }
            map.add(words[i]);
        }
        return res;
    }

    public static String longestWord3(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.length() > t1.length()) {
                    return 1;
                } else if (s.length() < t1.length()) {
                    return -1;
                } else {
                    if (s.equals(t1)) {
                        return 0;
                    }
                    if (s.compareTo(t1) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        System.out.println(Arrays.toString(words));
        List<String> map = new ArrayList<>();
        String res = "";
        map.add(res);
        for (int i = 0; i < words.length; i++) {
            //最长的 字典序最小的
            if (map.contains(words[i].substring(0, words[i].length() - 1))) {
                if (words[i].length() > res.length()) {
                    res = words[i];
                }
                if (words[i].length() == res.length() && words[i].compareTo(res) < 0) {
                    res = words[i];
                }
                map.add(words[i]);
            }

        }
        return res;
    }
}
