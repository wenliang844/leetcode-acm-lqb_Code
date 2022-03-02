package ACM.每日一题leecode.day185;

import java.util.Arrays;

public class day236_748最短补全词 {
    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words,(a, b)->a.length()-b.length());
        int[] arr = new int[26];
        int sum = 0;
        for(char ch : licensePlate.toLowerCase().toCharArray()){
            if(Character.isLowerCase(ch)){
                arr[ch-'a']++;
                sum++;
            }
        }
        for(String s : words){
            int[] arr_ = Arrays.copyOf(arr,arr.length);
            int sum_ = 0;
            char[] chs = s.toCharArray();
            for(char ch : chs){
                if(arr_[ch-'a'] > 0){
                    arr_[ch-'a']--;
                    sum_++;
                }
                if(sum_ == sum) {
                    return s;
                }
            }
        }
        return "煞笔";
    }
}
