package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈文亮
 * @date 2023/5/23 15:37
 */
public class day51_1090受标签影响的最大值 {
    public static void main(String[] args) {

//        System.out.println(largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2));
//        System.out.println(largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1,1,2,2,3}, 3, 1));//9
//        System.out.println(largestValsFromLabels(new int[]{9,8,8,7,6}, new int[]{0,0,0,1,1}, 3, 1));//16
        System.out.println(largestValsFromLabels(new int[]{2, 6, 3, 6, 5}, new int[]{1, 1, 2, 1, 1}, 3, 1));//9 expect
    }

    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int length = values.length;
        int[][] big = new int[2][length];
        big[0] = values;
        big[1] = labels;

        Map<Integer, Integer> userLimitMap = new HashMap();
        int count = 0;
        int sum = 0;


        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(big[i]));
        }

        Arrays.sort(big, (o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(big[i]));
        }

        for (int i = length - 1; i >= 0; i--) {
            if (count >= numWanted) {
                return sum;
            }

            if (userLimitMap.containsKey(labels[length - i - 1]) && userLimitMap.get(labels[length - i - 1]) >= useLimit) {
                continue;
            }

            sum += values[i];
            count++;
            userLimitMap.put(labels[length - i - 1], userLimitMap.getOrDefault(labels[length - i - 1], 0) + 1);
        }

        return sum;
    }
}
