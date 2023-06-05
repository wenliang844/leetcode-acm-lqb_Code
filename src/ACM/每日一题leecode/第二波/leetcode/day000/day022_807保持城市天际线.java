package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/15 14:22
 */
public class day022_807保持城市天际线 {
    public static void main(String[] args) {
        System.out.println(maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }


    //暴力解法：取每个最大值
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int[] xMax = new int[length];
        int[] yMax = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                xMax[i] = Math.max(xMax[i], grid[i][j]);
                yMax[i] = Math.max(yMax[i], grid[j][i]);
            }
        }
        //System.out.println(Arrays.toString(xMax));
        //System.out.println(Arrays.toString(yMax));

        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                count += Math.min(xMax[i],yMax[j])-grid[i][j];
            }
        }
        return count;
    }

    public static int find4Max(int a, int b, int c, int d) {
        int x = a > b ? a : b; //1次比较，1次赋值
        int y = c > d ? c : d; //1次比较，1次赋值
        return x > y ? x : y; //1次比较

    }

}
