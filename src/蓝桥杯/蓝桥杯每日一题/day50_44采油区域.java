package 蓝桥杯.蓝桥杯每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;

public class day50_44采油区域 {
    /***
     　采油区域　　Siruseri政府决定将石油资源丰富的Navalur省的土地拍卖给私人承包商以建立油井。被拍卖的整块土地为一个矩形区域，被划分为M×N个小块。
     　　Siruseri地质调查局有关于Navalur土地石油储量的估测数据。这些数据表示为M×N个非负整数，即对每一小块土地石油储量的估计值。
     　　为了避免出现垄断，政府规定每一个承包商只能承包一个由K×K块相连的土地构成的正方形区域。
     　　AoE石油联合公司由三个承包商组成，他们想选择三块互不相交的K×K的区域使得总的收益最大。
     如果K = 2, AoE公司可以承包的区域的石油储量总和为100, 如果K = 3, AoE公司可以承包的区域的石油储量总和为208。
     　　AoE公司雇佣你来写一个程序，帮助计算出他们可以承包的区域的石油储量之和的最大值。
     输入格式
     　　输入第一行包含三个整数M, N, K，其中M和N是矩形区域的行数和列数，K是每一个承包商承包的正方形的大小（边长的块数）。接下来M行，每行有N个非负整数表示这一行每一小块土地的石油储量的估计值。
     输出格式
     M N K
     */
    public static void printNums(int nums[][]) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //用一个sum数组,从target*target开始,对以当前为终点的矩阵求和,然后进行选取最大值,置0,再选取最大值,在置零 3次
    //贪心策略:只适合用于部分情况,如果有特殊情况,比如选择两个第二小的最终结果最大,而选一个最大的会破坏这种结构,就失效了
    public static int getMaxOil(int[][] oil, int targetEdge) {

        int[][] sum = new int[oil.length - targetEdge + 1][oil[0].length - targetEdge + 1];
        for (int i = 0; i < oil.length - targetEdge + 1; i++) {
            for (int j = 0; j < oil[0].length - targetEdge + 1; j++) {
                //计算从0,0开始到0+t,0+t的矩阵赋给sum[0][0]
                int tempSum = 0;
                for (int k = i; k < i + targetEdge; k++) {
                    for (int l = j; l < j + targetEdge; l++) {
                        tempSum += oil[k][l];
                    }
                }
                sum[i][j] = tempSum;
            }
        }
        printNums(sum);

        //从sum中选取一个最大的值,然后将sum这个值的上面3个置0
        int resSum = 0;
        for (int count = 0; count < 3; count++) {
            int maxIndexI = 0;
            int maxIndexJ = 0;
            int tempMax = 0;
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    if (sum[i][j] > tempMax) {
                        tempMax = sum[i][j];
                        maxIndexI = i;
                        maxIndexJ = j;
                    }
                }
            }
            resSum += tempMax;
            int starti = maxIndexI - 2 >= 0 ? maxIndexI - 2 : 0;
            int startj = maxIndexJ - 2 >= 0 ? maxIndexJ - 2 : 0;
            int targetI = maxIndexI + 2 < sum.length ? maxIndexI + 2 : sum.length - 1;
            int targetJ = maxIndexJ + 2 < sum[0].length ? maxIndexJ + 2 : sum[0].length - 1;
            System.out.println("最大值=" + tempMax);
            System.out.println("i=" + starti);
            System.out.println("j=" + startj);
            System.out.println("endi=" + targetI);
            System.out.println("endj=" + targetJ);
            for (int i = starti; i <= targetI; i++) {
                for (int j = startj; j <= targetJ; j++) {
                    //置0
                    sum[i][j] = 0;
                }
            }
            System.out.println("---置0后---" + "count=" + count);
            printNums(sum);
        }


        return resSum;

    }

    public static void main(String[] args) {
        System.out.println(getMaxOil(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1},//   {1,  1,  1,  1,  1,  1,  1,  1,  1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},//   {1,  1,  1,  1,  1,  1,  1,  1,  1},
                {1, 8, 8, 8, 8, 8, 1, 1, 1},//   {1,  8, 32, 39,  8,  8,  1,  1,  1},
                {1, 8, 8, 8, 8, 8, 1, 1, 1},//   {1,  8,  8,  8,  8,  8,  1,  1,  1},
                {1, 8, 8, 8, 8, 8, 1, 1, 1},//   {1,  8,  8,  8,  8,  8,  1,  1,  1},
                {1, 1, 1, 1, 8, 8, 8, 1, 1},//   {1,  1,  1,  1,  8,  8,  8,  1,  1},
                {1, 1, 1, 1, 1, 1, 8, 8, 8},//   {1,  1,  1,  1,  1,  1,  8,  8,  8},
                {1, 1, 1, 1, 1, 1, 9, 9, 9},//   {1,  1,  1,  1,  1,  1,  9,  9,  9},
                {1, 1, 1, 1, 1, 1, 9, 9, 9},//   {1,  1,  1,  1,  1,  1,  9,  9,  9},

        }, 3));


    }


}
