package 数据结构算法教程.java数据结构算法.第9节_图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    /****
     1.图的基本介绍
     *顶点 *边 *路径 *无向图 *有向图 *带权图{网}
     2.图的表示方式
     *邻接矩阵 用数组
     *      有几个节点就是几维 不连通1 通路是1
     *      有空间的损失
     * 邻接表 用数组+链表
     *      图比较稀疏的话,邻接表只表示联通的点,空间不浪费
     *      采用数组加链表
     *      0 |1->2->3->4
     *      1 |0->4
     *      数组下标0这个点和 1 2 3 4节点有联通
     *      数组下标1这个点和 0 4节点有联通
     多对多的关系用上了图
     A---B---C
     | -    |
     |-     F
     D---E

     图的便是表示方式:邻接表+邻接矩阵
     举例说明:以上图形
     ***代码快速入门
     * 思路:1. String ArrayList存储顶点
     *      2. 使用int[][] edges 表示边 0不通  1联通



     2.图的深度优先:DFS  递归的过程   {{也可以用栈实现}}
     **先访问第一个节点,再以这个节点为初始节点,访问它的第一个节点,再以这个节点循环访问第一个节点
     * *1.访问初始节点.并标记这个节点为已访问状态
     * *2.查找及诶单的第一个节点w
     * *3.如果w存在,继续执行4.如果w不存在,则回到第一步.将从v的第二个节点继续
     * *4.若节点w是没有访问过的,那么对w继续拿给你深度dfs
     * *5.如果v的w节点的下一个邻接点 转到步骤3
     *

     {先把A能访问到的先访问,层次分明}
     3.广度优先BFS:用队列实现 层次 把每一个层的先放到队列,在队列操作
     * *1.访问初始节点v并标记v为已访问
     * *2.节点v入队
     * *3.当队列非空的时候,继续执行,否则算法结束
     * *4.出队列,取得队头节点u
     * *5.查找节点u的第一个邻接节点w
     * *6.w没访问,标记访问,输出
     * *7.w入队列
     * *8.查找节点u的在w邻接节点后的下一个邻接节点w,转到步骤6
     *
     */
    public static void teachersTest1_graph() {
        //测试一把图是否创建正确
        int n = 5;
        String Vertexs[] = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);//AB
        graph.insertEdge(0,2,1);//AB
        graph.insertEdge(1,2,1);//AB
        graph.insertEdge(1,3,1);//AB
        graph.insertEdge(1,4,1);//AB

        //显示邻接矩阵
        graph.showGraph();

        //测试一把,我们的dfs是否OK
        System.out.println("测试深度遍历");
        //graph.dfs();//A-B-C-D-E   //先注释,因为dfs为把广度优先都设置为已访问的isVisible:true
        System.out.println();

        System.out.println("广度优先===");
        graph.bfs();
    }

    public static void main(String[] args) {
        teachersTest1_graph();
    }

    private ArrayList<String> vertexList; //存储顶点节点
    private int[][] edges; //存储图对应的邻接矩阵
    private int numOfEdges; //边的数目
    private boolean[] isVisited;//记录某个节点是否被访问

    //构造器
    public Graph(int n) {
        //初始化矩阵
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
         isVisited = new boolean[n];
        numOfEdges = 0;
    }

    //得到第一个邻接节点的下标w
    public int getFirstNeighber(int index){
        /**
         如果存在就返回对应的下标,否则返回-1 以便递归dfs
         */
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j]>0){
                return j;
            }
        }

        return -1;
    }
    //根据前一个邻接节点的词表来获取下一个邻接节点
    //要知道下一个邻接节点是什么
    public int getNextNeighber(int v1,int v2){
        for (int j = v2+1; j < vertexList.size(); j++) {
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //dfs i第一次就是0 A
    public void dfs(boolean[] isVisited,int i){
        //首先访问这个节点
        System.out.print(getValueByIndex(i)+"->");
        //将这个节点设置为已访问
        isVisited[i] = true;

        int w = getFirstNeighber(i);//查找第一个邻接
        while (w !=-1){//说明有邻接节点
            if (!isVisited[w]){//没有访问
                dfs(isVisited,w);
            }
            //w存在,但是被访问过了,继续下一个邻接点
            w = getNextNeighber(i,w);
        }
    }

    //对dfs进行一个重载 遍历所有节点 并进行dfs    防止多图,有没联通的
    public void dfs(){
        //遍历所有的节点进行递归dfs[实现回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //对一个节点进行广度优先的方法
    private void bfs(boolean[] isVisited,int i){
        int u; //表示队列的头结点对应的下标
        int w; //邻接节点的下标
        //队列 记录节点访问的顺序  addLast removeFirst
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i)+"==>");
        //标记为已访问
        isVisited[i]=true;
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            //取出队列的头节点下标
            u = (int) queue.removeFirst();//自踩箱功能
            //得到第一个邻接节点的下标
            w = getFirstNeighber(u);
            while (w!=-1){//找到了//是否访问
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"=>");
                    //标记为已访问
                    isVisited[w]=true;
                    //入队列
                    queue.addLast(w);
                }
                //如果访问过了,以u为前一个节点,找w后面的第一个节点  w的位置会变化更新,多以每一都能拿到下一个
                w = getNextNeighber(u,w);//体现出广度优先
            }
        }

    }

    //遍历所有的节点 --->防止一个节点是不行的,也就是说有些节点是 没有联通的,有多个图
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    //插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight) {
        /***
         v1表示点的下表 A是下标0   B是下标1    edge[0][1]=weight
         */
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //常用方法1->获取点的数量
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //常用方法2->获取边的数量
    public int getnumOfEdges() {
        return numOfEdges;
    }

    //常用方法3->返回下标对应的顶点 0->A   1->B
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //常用方法4->返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //常用方法5->显示图对应的矩阵
    public void showGraph() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("下面是增强for循环的输出方式---");
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }




}
