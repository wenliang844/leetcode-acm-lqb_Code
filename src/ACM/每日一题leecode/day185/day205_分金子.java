package ACM.每日一题leecode.day185;

import java.util.Arrays;

public class day205_分金子 {

    private static int maxSum;

    public static void main(String[] args) {
        System.out.println(solve(new int[]{10, 20, 30}));
    }

    //思路: 从中间切割 1.计算sum  2.计算0到中间的和 对半分 直到数组长度为1
    public static int solve(int[] golds){
        Arrays.sort(golds);
        maxSum = 0;
        int sum = 0;
        for (int i = 0; i < golds.length; i++) {
            sum += golds[i];
        }
        getNum(golds,0,golds.length,sum);
        return 0;
    }

    //考虑奇偶,分出终点,再左右getNum
    private static void getNum(int[] golds, int i, int length, int sum) {
        if (length - i==1){
            return;
        }


    }
}
