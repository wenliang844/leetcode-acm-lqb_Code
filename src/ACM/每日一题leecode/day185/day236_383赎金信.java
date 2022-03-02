package ACM.每日一题leecode.day185;

import java.util.HashMap;
import java.util.Map;

public class day236_383赎金信 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }

    //8 48
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))){
                Integer integer = map.get(ransomNote.charAt(i));
                if (integer >1){
                    map.put(ransomNote.charAt(i),integer-1);
                }else {
                    map.remove(ransomNote.charAt(i));
                }
            }else {
                return false;
            }
        }

        return true;
    }
}
