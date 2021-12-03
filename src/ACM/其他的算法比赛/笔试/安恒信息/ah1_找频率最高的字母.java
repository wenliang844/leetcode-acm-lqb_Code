package ACM.其他的算法比赛.笔试.安恒信息;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ah1_找频率最高的字母 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character,Integer> map = new HashMap<>();
        char maxC = '0';
        int max = 0;
        for (int i = 0; i < s.length(); i++) {

            char k = s.charAt(i);
            map.put(k,map.getOrDefault(k,0)+1);
            if (map.get(k)>max){
                max = map.get(k);
                maxC = k;
            }
        }

        System.out.println(maxC);
    }
}
