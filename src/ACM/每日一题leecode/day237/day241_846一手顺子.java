package ACM.每日一题leecode.day237;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day241_846一手顺子 {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand(new int[]{8, 10, 12}, 3));
    }

    //顺子的特征 hand%groupSize应该相等的数量
    public static boolean isNStraightHand(int[] hand, int groupSize) {

        Arrays.sort(hand);
        int[] count = new int[groupSize];
        for (int i = 0; i < hand.length; i++) {
            count[hand[i] % groupSize]++;
        }

        for (int i = 0; i < count.length - 1; i++) {
            if (count[i] != count[i + 1]) {
                return false;
            }

        }

        System.out.println(Arrays.toString(count));
        return true;
    }

    public static boolean isNStraightHand2(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0 || hand.length % groupSize != 0) {
            return false;
        }
        // 数组进行排序预处理，并将元素及其出现次数存储在 map 中
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int h : hand) {
            if (map.get(h) > 0) {
                // 判断 map 中是否有足够的元素构成顺子
                for (int j = 0; j < groupSize; j++) {
                    if (map.getOrDefault(h + j, 0) > 0) {
                        map.put(h + j, map.get(h + j) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
