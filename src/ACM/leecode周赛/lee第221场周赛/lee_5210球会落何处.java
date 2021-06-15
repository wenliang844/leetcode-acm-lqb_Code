package ACM.leecode周赛.lee第221场周赛;

/***
 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。

 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。

 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。

 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。

 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 输出：[1,-1,-1,-1,-1]
 解释：示例如图：
 b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
 b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 示例 2：

 输入：grid = [[-1]]
 输出：[-1]
 解释：球被卡在箱子左侧边上。
 */
public class lee_5210球会落何处 {
    public static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] ball = findBall(new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1},
        });
        printNums(ball);
        int[] ball2 = findBall(new int[][]{
                {-1},
        });
        printNums(ball2);
        System.out.println("---------");
        int[] ball3 = findBall(new int[][]{
                {1, 1},
                {1, 1},
        });
        System.out.println("---------");
        int[] ball6 = findBall(new int[][]{
                {1, 1,1},

        });
        printNums(ball6);
        int[] ball4 = findBall(new int[][]{
                {-1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1,
                        -1,
                        -1, 1, 1, -1, -1, -1, 1, 1, 1, -1, -1, 1, 1, -1,
                        -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 1,
                        -1, -1, 1, -1, 1, -1, -1, 1, 1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1,
                        -1, 1, 1, 1, -1, -1, -1, 1, -1, 1, -1, -1, 1, 1, -1, -1, 1, -1, 1, -1, 1, 1, 1, -1,
                        -1, -1, -1}
        });
        printNums(ball4);
    }

    public static int[] findBall(int[][] grid) {

        /***
         思路:当前grid[i][j]是1 就看grid[i][j+1]是不是1 是1就通行         开到grid[i+1][j+1]
         思路:当前grid[i][j]是-1 就看grid[i][j-1]是不是-1 是-1就通行         开到grid[i+1][j-1]
         */

        int[] answer = new int[grid[0].length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        if (grid[0].length == 1) {
            return answer;
        }
        int i = 0;
        boolean flag;
        for (int j = 0; j < grid[i].length; j++) {
             flag = true;//代表这个球默认可以通行
            //System.out.println("这是第一个起点=" + grid[i][j]);
            int k = j;
            while (i < grid.length) {
                //System.out.println("这是我第i次进入while循环+"+i);
                if (k + 1 < grid[0].length && grid[i][k] == 1 && grid[i][k + 1] == 1) {
                    //System.out.println("成功一个1");
                    flag=true;
                    i = i + 1;

                    k = k + 1;
                } else if (k - 1 >= 0 && grid[i][k] == -1 && grid[i][k - 1] == -1) {
                    //System.out.println("成功一个-1");
                    flag=true;
                    i = i + 1;
                    k = k - 1;
                } else {
                    //System.out.println("这个行不通:"+i+"-"+j);
                    flag = false;
                    break;
                }

            }
            if (flag) {
                answer[j] = k;
            }
            i = 0;
        }

        return answer;
    }
}
