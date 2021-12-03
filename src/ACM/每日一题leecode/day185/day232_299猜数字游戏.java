package ACM.每日一题leecode.day185;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day232_299猜数字游戏 {
    public static void main(String[] args) {
        System.out.println(getHint2("1807", "7810"));
        System.out.println(getHint2("1123", "0111"));
    }

    //方法一:暴力破解 错误,不能解决有重复的问题
    public static String getHint(String secret, String guess) {
        //计算有重复的个数,计算位置对的个数
        Set<Character> set = new HashSet<>();
        int len1 = secret.length();
        for (int i = 0; i < len1; i++) {
            set.add(secret.charAt(i));
        }

        for (int i = 0; i < len1; i++) {
            set.add(guess.charAt(i));
        }
        int B = len1*2-set.size();

        int A = 0;
        for (int i = 0; i < len1; i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                A++;
            }
        }
        B-=A;
        return A+"A"+B+"B";
    }

    //方法二:暴力解法:计数使用map计数 29|12
    public static String getHint2(String secret, String guess) {
        //计算有重复的个数,计算位置对的个数
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        int len1 = secret.length();
        for (int i = 0; i < len1; i++) {
            char c = secret.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < len1; i++) {
            char c = guess.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }


        int B = 0;
        for (int i = 0; i < len1; i++) {
            char c = guess.charAt(i);
            if (map1.containsKey(c)){
                B+= Math.min(map1.get(c),map2.get(c));
                map1.remove(c);
                map2.remove(c);
            }
        }
        //int B = len1*2-set.size();

        int A = 0;
        for (int i = 0; i < len1; i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                A++;
            }
        }
        B-=A;
        return A+"A"+B+"B";
    }
}
