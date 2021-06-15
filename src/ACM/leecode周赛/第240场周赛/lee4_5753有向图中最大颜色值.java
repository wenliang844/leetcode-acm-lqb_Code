package ACM.leecode周赛.第240场周赛;

public class lee4_5753有向图中最大颜色值 {

    private static int[][] matrix;
    private static int max;

    /***
     给你一个 有向图 ，它含有 n 个节点和 m 条边。节点编号从 0 到 n - 1 。
     给你一个字符串 colors ，其中 colors[i] 是小写英文字母，表示图中第 i 个节点的 颜色 （下标从 0 开始）。同时给你一个二维数组 edges ，其中 edges[j] = [aj, bj] 表示从节点 aj 到节点 bj 有一条 有向边 。
     图中一条有效 路径 是一个点序列 x1 -> x2 -> x3 -> ... -> xk ，对于所有 1 <= i < k ，从 xi 到 xi+1 在图中有一条有向边。路径的 颜色值 是路径中 出现次数最多 颜色的节点数目。
     请你返回给定图中有效路径里面的 最大颜色值 。如果图中含有环，请返回 -1 。
     示例 1：
     输入：colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
     输出：3
     解释：路径 0 -> 2 -> 3 -> 4 含有 3 个颜色为 "a" 的节点（上图中的红色节点）。
     */
    public static void main(String[] args) {
        System.out.println(largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}}));
    }

    //一个路线visited && 联通//就可以走下去 有环直接-1/map记录颜色数量 max
    public static int largestPathValue(String colors, int[][] edges) {

        //构造一个颜色矩阵
        int len = colors.length();
        max = 0;
        matrix = new int[len][len];
        //boolean visited[][] = boolean[len][len];
        int[] start = new int[len];
        for (int i = 0; i < edges.length; i++) {
                matrix[edges[i][0]][edges[i][1]]=1;
                start[edges[i][1]]=1;//这个点不是起始节点
        }

        //判环:1.并查集  2.快慢指针


        //找入度为0 的点,从这个点的各种情况进行找
        for (int i = 0; i < len; i++) {
            //是起始节点,可以进行 dfs搜索
            if (start[i]==0){
                for (int j = 0; j < len; j++) {
                    if (matrix[i][j]==1){
                        //dfs()

                    }

                }
            }
        }

        return 0;
    }
}
