package ACM.每日一题leecode.day185;

import java.util.HashMap;
import java.util.Map;

public class day228_575分糖果 {
    public static void main(String[] args) {

        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies(new int[]{1,1,2,3}));
        System.out.println(distributeCandies(new int[]{6,6,6,6}));
    }

    //map计数 12|75
    public static int distributeCandies(int[] candyType) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = candyType.length;
        int target = len/2;
        for (int i = 0; i < len; i++) {
            map.put(candyType[i],map.getOrDefault(candyType[i],0)+1);
        }

        int mapLen = map.size();
        return mapLen<target?mapLen:target;
    }
}
