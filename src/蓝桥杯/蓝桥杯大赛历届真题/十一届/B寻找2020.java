package 蓝桥杯.蓝桥杯大赛历届真题.十一届;

import static 蓝桥杯.蓝桥杯大赛历届真题.第一届国际赛真题.E希尔伯特曲线.dfs;

public class B寻找2020 {
    static int nums[][] = new int[][]{
            {2, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 2, 2, 0, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 2},
            {0, 0, 2, 0, 2, 0},
    };

    static int count = 0;

    public static void main(String[] args) {
        /**
         220000
         000000
         002202
         000000
         000022
         002020

         列,行,斜线  多少个2020
         枚举开头即可,对每个节点
         */

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 2)
                    dfs(i, j);
            }
        }

        System.out.println(count);//5
    }

    private static void dfs(int i, int j) {
        //找三条线上连续的2020
        if (j + 3 < nums[i].length && nums[i][j + 1] == 0 && nums[i][j + 2] == 2 && nums[i][j + 3] == 0) {
            count++;
        }
        if (i + 3 < nums.length && nums[i + 1][j] == 0 && nums[i + 2][j] == 2 && nums[i + 3][j] == 0) {
            count++;
        }
        if (i + 3 < nums.length && j + 3 < nums[i].length && nums[i + 1][j + 1] == 0 && nums[i + 2][j + 2] == 2 && nums[i + 3][j + 3] == 0) {
            count++;
        }
    }
}
