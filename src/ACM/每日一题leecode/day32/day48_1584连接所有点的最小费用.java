package ACM.每日一题leecode.day32;

public class day48_1584连接所有点的最小费用 {

    public static void main(String[] args) {

        System.out.println("这是解过:"+minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }

    //prim算法:加点法 ---69 / 72 个通过测试用例---优化后通过
    public static int minCostConnectPoints(int[][] points) {
        //构造边集
        int len=points.length;
        //int[] vertax = new int[len];
        //初始化边
        /*for (int i = 0; i < len; i++) {
            vertax[i] = i;
        }*/
        //构造点权值节点边
        int[][] edges = new int[len][len];
        //初始胡权值的边
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                edges[i][j]=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                //System.out.print(edges[i][j]+"\t");
            }
           // System.out.println();
        }

        //创建一个记录已访问
        int[] visited = new int[len];//默认初始化0

        visited[0]=1;
        int sum = 0;
        for (int i = 0; i < len-1; i++) {
            int minlen = prim(visited,edges,len);
            //System.out.println("--"+minlen);
            sum+=minlen;
        }

        return sum;
    }

    private static int prim(int[] visited, int[][] edges,int len) {
            int minlenX=0,minlenY = 0;
            int minlen = Integer.MAX_VALUE;
        for (int i = 0; i <len; i++) {
            if (visited[i]==1){
                for (int j = 0; j < len; j++) {
                    if (edges[i][j]<minlen && visited[j]==0){
                        minlen = edges[i][j];
                        minlenX=i;
                        minlenY=j;
                    }
                }
            }
        }
        visited[minlenY]=1;
        return minlen;
    }

}
