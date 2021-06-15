package 蓝桥杯.蓝桥杯每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;

public class day48_36传纸条hard {
    /*****
     小渊和小轩是好朋友也是同班同学，他们在一起总有谈不完的话题。一次素质拓展活动中，班上同学安排做成一个m行n列的矩阵，而小渊和小轩被安排在矩阵对角线的两端，因此，他们就无法直接交谈了。幸运的是，他们可以通过传纸条来进行交流。纸条要经由许多同学传到对方手里，小渊坐在矩阵的左上角，坐标(1,1)，小轩坐在矩阵的右下角，坐标(m,n)。从小渊传到小轩的纸条只可以向下或者向右传递，从小轩传给小渊的纸条只可以向上或者向左传递。
     　　在活动进行中，小渊希望给小轩传递一张纸条，同时希望小轩给他回复。班里每个同学都可以帮他们传递，但只会帮他们一次，也就是说如果此人在小渊递给小轩纸条的时候帮忙，那么在小轩递给小渊的时候就不会再帮忙。反之亦然。
     　　还有一件事情需要注意，全班每个同学愿意帮忙的好感度有高有低（注意：小渊和小轩的好心程度没有定义，输入时用0表示），可以用一个0-100的自然数来表示，数越大表示越好心。小渊和小轩希望尽可能找好心程度高的同学来帮忙传纸条，即找到来回两条传递路径，使得这两条路径上同学的好心程度只和最大。现在，请你帮助小渊和小轩找到这样的两条路径。

     输入格式
     　　输入第一行有2个用空格隔开的整数m和n，表示班里有m行n列（1<=m,n<=50）。
     　　接下来的m行是一个m*n的矩阵，矩阵中第i行j列的整数表示坐在第i行j列的学生的好心程度。每行的n个整数之间用空格隔开。
     输出格式
     　　输出一行，包含一个整数，表示来回两条路上参与传递纸条的学生的好心程度之和的最大值。

     样例输入
     3 3
     0 3 9
     2 8 5
     5 7 0
     样例输出
     34
     */
    //方法一:动态规划:但是只能求出一条最大值路径,两条路径加起来最大?
    //构造四维数组?
    //dp[x1][y1][x2][y2]=max(dp[x1-1][y1][x2-1][y2],dp[x1][y1-1][x2-1][y2],dp[x1][y1-1][x2][y2-1],dp[x1-1][y1][x2][y2-1])+map[x1][y1]+map[x2][y2];
    //三维的动态方程dp[k][x1][x2]=max(dp[k-1][x1][x2],dp[k-1][x1-1][x2-1],dp[k-1][x1-1][x2],dp[k-1][x1][x2-1])+map[x1][k-x1]+map[x2][k-x2];
    //二维的动态规划dp[x1][x2] = max(dp[x1][x2], dp[x1 - 1][x2 - 1], dp[x1 - 1][x2], dp[x1][x2 - 1]) + map[x1][k - x1] + map[x2][k - x2];
    //return dp[m-2][m-1]。;
    public static int maxPath(int m, int n) {
        int map[][] = new int[5][5];     //好心程度 | 权值
        int dp[][][][] = new int[5][5][5][5];

        for (int x1 = 1; x1 <= m; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                for (int x2 = 1; x2 <= m; x2++) {
                    for (int y2 = 1; y2 <= n; y2++) {
                    /*
                        如果第一个人没有走到最后一行或最后一列，并且两个人没有重复
                        因为走到最后一行或最后一列，容易造成第二个人无路可走的情况
                    */
                        if ((x1 < m || y1 < n) && x1 == x2 && y1 == y2) {
                            continue;
                        }
                        dp[x1][y1][x2][y2] = Math.max(Math.max(dp[x1 - 1][y1][x2 - 1][y2], dp[x1 - 1][y1][x2][y2 - 1]),
                                Math.max(dp[x1][y1 - 1][x2 - 1][y2], dp[x1][y1 - 1][x2][y2 - 1]))
                                + map[x1][y1] + map[x2][y2];
                    }
                }
            }
        }
        return dp[m][n][m][n];
    }

    //三维数组的
    public static int maxPath2(int m, int n) {
        int map[][] = new int[5][5];     //好心程度 | 权值
        int dp[][][] = new int[5 + 5][5][5];

        for (int k = 1; k <= m + n - 3; k++) {
            for (int x1 = 0; x1 <= k; x1++) {
                for (int x2 = 0; x2 <= k; x2++) {
                    if (x1 == x2)    //x1 == x2 相当于(x1 == x2 && y1 = y2)
                    {
                        continue;
                    }
                    dp[k][x1][x2] = Math.max(Math.max(dp[k - 1][x1][x2], dp[k - 1][x1 - 1][x2 - 1]),
                            Math.max(dp[k - 1][x1 - 1][x2], dp[k - 1][x1][x2 - 1]))
                            + map[x1][k - x1] + map[x2][k - x2];
                }
            }
        }
        return dp[m + n - 3][m - 1][m - 2];
    }

    //二维数组的
    public static int maxPath3(int m, int n) {
        int map[][] = new int[5][5];     //好心程度 | 权值
        int dp[][] = new int[5][5];
        Arrays.fill(dp, dp.length);
        for (int k = 1; k <= m + n - 3; k++) {
            for (int x1 = m - 1; x1 >= 0; x1--) {
                for (int x2 = m - 1; x2 > x1; x2--) {
                    if (k >= x1 && k >= x2)    //x + y = k,当k >= x时，说明还在矩阵范围之内
                    {
                        dp[x1][x2] = Math.max(Math.max(dp[x1][x2], dp[x1 - 1][x2 - 1]),
                                Math.max(dp[x1 - 1][x2], dp[x1][x2 - 1]))
                                + map[x1][k - x1] + map[x2][k - x2];
                    }
                }
            }
        }
        return dp[m - 2][m - 1];
    }

}
