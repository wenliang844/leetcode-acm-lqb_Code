package 数据结构算法教程.java数据结构算法.第10节_算法.最小生成树;

import java.util.Arrays;

public class primAlgorithm {

    /****
     用1万这个大数,表示两个点不连通,
        A B C D E F G
     A    5 7       2
     B  5     9     3
     C  7       8
     D    9       4
     E       8    5 4
     F       4  5   6
     G  2 3     4 6

     修路问题:
     要求:加点:初始点+在可以和点集连接的点中的最小点
     */
    public static void main(String[] args) {
        //测试是否创建成功
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用一个二维数组进行一个描述
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        //创建一个MGrAPH对象
        MGraph graph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph,verxs,data,weight);
        minTree.showGraph(graph);
        //测试prim算法
        minTree.prim(graph,0);

    }
}

//创建最小生成树 ->村庄的图---toll类 工具类 util
class MinTree {
    //创建图的邻接矩阵
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        /***
         传进来的图的对象
         verxs 顶点个数
         data 顶点的值
         weight[][] 邻接矩阵
         */int i, j;
        for (i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {//邻接矩阵
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写一个prim算法,得到一个最小生成树
    public void prim(MGraph graph,int v){
        /***
         graph 图邻接
         v :从哪个顶点开始寻找   如果是A 就传一个0   B->1
         */
        //visited 表示标记节点被访问过 纳入了最小生成树
        int[] visited = new int[graph.verxs];//默认0 没访问

        //把当前这个节点标记为已访问
        visited[v]=1;
        //h1 h2记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight = 10000;//将minWeight初始化层一个最大树 会被替换小的
        for (int k = 1; k < graph.verxs; k++) {//因为有verxs个顶点,prim结束后,有n-1条边

            //是在确定每一次生成的子图和哪个节点的举例最近,     |穷举所有
            //遍历联通v顶点的所有边 可能不止v一个点 后面还有很多点
            for (int i = 0; i < graph.verxs; i++) {//遍历所有访问过的节点
                for (int j = 0; j < graph.verxs; j++) {//遍历所有没有访问过的节点
                        if (visited[i]==1 && visited[j]==0 && graph.weight[i][j] < minWeight){
                            //替换minWeight(寻找已经访问过的节点和未访问过的节点权值最小的边)
                            minWeight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        }
                }
            }

            //找到了最小的一个点 和已有顶点集合的边
            System.out.println("边="+graph.data[h1]+"-"+graph.data[h2]+"权值"+minWeight);
            //将当前这个访问过的节点 设置为已经访问
            visited[h2] = 1;
            minWeight=10000;

        }

    }
}

class MGraph {
    int verxs; //节点个数
    char[] data;//存放节点的数量
    int[][] weight; //存放边,就是我们的邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }

}
