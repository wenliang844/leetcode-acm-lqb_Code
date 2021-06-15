package ACM.其他的算法比赛.笔试.腾讯音乐;

import java.util.Scanner;

public class code3军营选择 {

    private static int[][] nums;
    private static int maxCount;

    public static void main(String[] args) {
        //把军营wi最大的移动到wi最小的,从而得到更小的一个wi
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            nums = new int[n][n];
            for (int i = 0; i < n - 1; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                nums[row-1][col-1] = 1;
                nums[col-1][row-1] = 1;
            }

            //求出wi
            int weight[] = new int[n];
            //邻接表更好

            for (int i = 0; i < n; i++) {
                maxCount = 0;
                //每个节点进行尝试,如果是联通的,就进行dfs看最大深度
                for (int j = 0; j < n; j++) {
                    if (nums[i][j]==1){//连着的
                        dfs(j,-1);
                    }
                }
                weight[i]=maxCount;
            }

            //将一条weight最大的边换到最下的边中
        }
    }

    private static void dfs( int j, int count) {
        count++;
        maxCount = Math.max(count,maxCount);
        for (int k = 0; k < nums.length; k++) {
            if (nums[j][k]==1){
                dfs(k,count);
            }
        }
    }
}
