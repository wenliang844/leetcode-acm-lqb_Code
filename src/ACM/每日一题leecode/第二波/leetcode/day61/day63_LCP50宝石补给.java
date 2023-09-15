package ACM.每日一题leecode.第二波.leetcode.day61;

import java.util.Arrays;

public class day63_LCP50宝石补给 {
    public static void main(String[] args) {
        System.out.println(giveGem(new int[]{3, 1, 2}, new int[][]{{0, 2}, {2, 1}, {2, 0}}));
    }

    public static int giveGem(int[] gem, int[][] operations) {
        for (int i = 0; i < operations.length; i++) {
            int diff = gem[operations[i][0]]/2;
            gem[operations[i][0]]-=diff;
            gem[operations[i][1]]+=diff;
        }
        System.out.println(Arrays.toString(gem));

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gem.length; i++) {
            if (gem[i]>max){
                max = gem[i];
            }
            if (gem[i]<min){
                min = gem[i];
            }
        }
        return max-min;
    }

}
