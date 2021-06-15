package ACM.每日一题leecode.day141;

import java.util.Arrays;

public class day151_879盈利计划 {
    public static void main(String[] args) {
        System.out.println(profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
        System.out.println(profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
        System.out.println(profitableSchemes(64, 0, new int[]{80, 40}, new int[]{88, 88}));
    }

    //暴力解法:子集 和 ---超出内存限制
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int count = 0;
        int len = profit.length;
        int resLen = (int) Math.pow(2, len);
        int[] sums = new int[resLen];
        int[] hammer = new int[resLen];
        int index = 2;
        sums[0] = 0;
        hammer[0] = 0;
        sums[1] = profit[0];
        hammer[1] = group[0];

        //构造子集和
        for (int i = 1; i < len; i++) {
            int tempIndex = index;
            /*sums[index]=profit[i];
            hammer[index]=group[i];
            index++;*/
            for (int j = 0; j < tempIndex; j++) {
                sums[index] = sums[j] + profit[i];
                hammer[index] = hammer[j] + group[i];
                index++;
            }
        }

        System.out.println("产出" + Arrays.toString(sums));
        System.out.println("人数" + Arrays.toString(hammer));

        for (int i = 0; i < resLen; i++) {
            if (sums[i] >= minProfit && hammer[i] <= n) {
                count++;
                //System.out.println("达标者="+i);
            }
        }
        return count;
    }

    //用一个len长度的数组,每次进行覆盖操作,同步赋值和检测,到0终止
    public static int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int count = 0;
        int len = profit.length;
        int resLen = (int) Math.pow(2, len);
        int[] sums = new int[resLen];
        int[] hammer = new int[resLen];
        int index = 1;
        sums[0] = 0;
        hammer[0] = 0;
        if (sums[0] >= minProfit && hammer[0] <= n) {
            count++;
        }

        //构造子集和
        for (int i = 0; i < len; i++) {
            int tempIndex = index;
            /*sums[index]=profit[i];
            hammer[index]=group[i];
            index++;*/
            for (int j = 0; j < tempIndex; j++) {
                sums[index] = sums[j] + profit[i];
                hammer[index] = hammer[j] + group[i];
                index++;
            }
        }

        System.out.println("产出" + Arrays.toString(sums));
        System.out.println("人数" + Arrays.toString(hammer));

        for (int i = 0; i < resLen; i++) {
            if (sums[i] >= minProfit && hammer[i] <= n) {
                count++;
            }
        }
        return count;
    }
}
