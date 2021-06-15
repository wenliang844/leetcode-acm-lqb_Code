package ACM.每日一题leecode.day100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day132_692前K个高频单词 {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    //9 29
    public static List<String> topKFrequent(String[] words, int k) {

        //1.计数
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        System.out.println(map);

        //按照map的顺序进行排序
        String[] s1 = new String[map.size()];
        int[] indexs = new int[map.size()];
        int index = 0;
        for (String s : map.keySet()) {
            s1[index] = s;
            indexs[index]=map.get(s);
            index++;
        }

        //按照index进行排序,如果index相等,按照字典序进行排序
        //冒泡排序
        for (int i = 0; i < indexs.length; i++) {
            for (int j = i+1; j < indexs.length; j++) {
                if (indexs[i]<indexs[j]){
                    //交换
                    swap(indexs,s1,i,j);
                }else if (indexs[i]==indexs[j]){
                    //判断字典序
                    if (s1[i].compareTo(s1[j])>0){
                        swap(indexs,s1,i,j);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(s1[i]);
        }
        return list;
    }

    private static boolean check(int i, int j, String[] s1) {
        String s11 = s1[i];
        String s22 = s1[j];
        //如果s22在前面,return true
        int index = 0;
        while (index<s11.length() && index<s22.length()){
            if (s11.charAt(index)<s22.charAt(index)){
                return true;
            }
        }
        if (s22.length()<s11.length()){
            return true;
        }
        return false;
    }

    private static void swap(int[] indexs, String[] s1, int i, int j) {
        int temp = indexs[i];
        String tempString = s1[i];
        indexs[i]=indexs[j];
        s1[i]=s1[j];
        indexs[j]=temp;
        s1[j]=tempString;
    }

    /***
     return Arrays.stream(words)
     .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
     .entrySet()
     .stream()
     .sorted((o1, o2) -> {
     if (o1.getValue().equals(o2.getValue())) {
     return o1.getKey().compareTo(o2.getKey());
     } else {
     return o2.getValue().compareTo(o1.getValue());
     }
     })
     .map(Map.Entry::getKey)
     .limit(k)
     .collect(Collectors.toList());
     */
}
