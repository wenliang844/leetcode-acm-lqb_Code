package ACM.leecode周赛.第238场周赛;

public class lee_5741最高建筑高度 {
    /***
     在一座城市里，你需要建 n 栋新的建筑。这些新的建筑会从 1 到 n 编号排成一列。
     这座城市对这些新建筑有一些规定：
     每栋建筑的高度必须是一个非负整数。
     第一栋建筑的高度 必须 是 0 。
     任意两栋相邻建筑的高度差 不能超过  1 。
     除此以外，某些建筑还有额外的最高高度限制。这些限制会以二维整数数组 restrictions 的形式给出，其中 restrictions[i] = [idi, maxHeighti] ，表示建筑 idi 的高度 不能超过 maxHeighti 。
     题目保证每栋建筑在 restrictions 中 至多出现一次 ，同时建筑 1 不会 出现在 restrictions 中。
     请你返回 最高 建筑能达到的 最高高度 。
     */
    //方法一:模拟法
    public static int maxBuilding(int n, int[][] restrictions) {
        int maxlength = 0;

        int[] floor = new int[n];
        for (int i = 0; i < restrictions.length; i++) {
            floor[restrictions[i][0]-1] = restrictions[i][1];
        }
        for (int i = 1; i < n; i++) {
            if (floor[i]==0){
                floor[i] = floor[i-1]+1;
            }else {
               if (floor[i-1]+1 < floor[i]){
                   floor[i] = floor[i-1]+1;
               }
            }
            maxlength = Math.max(maxlength,floor[i]);
        }

        return maxlength;
    }

    public static void main(String[] args) {
        System.out.println(maxBuilding(5, new int[][]{{2, 1}, {4, 1}}));//2
        System.out.println(maxBuilding(10, new int[][]{{5, 3}, {2, 5},{7,4},{10,3}}));//5
    }
}
