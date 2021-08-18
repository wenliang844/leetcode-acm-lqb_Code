package 数据结构算法教程.java数据结构算法.第10节_算法.最短路径.Floyd;

import java.util.Arrays;

/*
Floyd-Warshall算法不能解决带有“负权回路”（或者叫“负权环”）的图，
因为带有“负权回路”的图没有最短路。例如下面这个图就不存在1号顶点到3
号顶点的最短路径。因为1->2->3->1->2->3->…->1->2->3这样路径中，每
绕一次1->-2>3这样的环，最短路就会减少1，永远找不到最短路。其实如
果一个图中带有“负权回路”那么这个图则没有最短路。
1 --2->2---3->3--- (-6)--->1
 */
public class Floyd {
    /****
     巧妙:好写,时间复杂度较高
     计算图中各个顶点中的最短路径

     djs是从一个顶点出发
     floyd是每一个顶点都是要给出发顶点
     从i号顶点到j号顶点只经过前k号点的最短路程。

     1.设置顶点vi到顶点dk的最短路径为已知Lik
     顶点vk到vj的最短路径已知为Lkj
     顶点vi到vk的路径为Lij 则vi到vj的最短路径为min(Lik+Lkj),Lij)
     vk的取值为图中的所有顶点,则可获得vi到vk的最短路径
     2.至于vi到vk的最短路径Lij 或者vk到vj的最短路径Lkj,是以同样的方式获得的

     三层for循环;
     A B C D E F G          A B C D E F G
     A 0 5 7 N N N 2        A 0 5 7 N N N 2
     B 5 0 N 9 N N 3        B 5 0|12 9 N N 3
     C 7 N 0 N 8 N N   ---> C 7|12 0 N 8 N |9
     D N 9 N 0 N 4 N        D N 9 N 0 N 4 N
     E N N 8 N 0 5 4        E N N 8 N 0 5 4
     F N N N 4 5 0 6        F N N N 4 5 0 6
     G 2 3 N N 4 6 0        G 2 3|9 N 4 6 0

     前驱结点:
     A B C D E F G
     A  A A A A A A
     B  B B B B B B
     C  C C C C C C
     D  D D D D D D
     E  E E E E E E
     F  F F F F F F
     G  G G G G G G
     中间节点: [A B C D E F G ]
     出发节点: [A B C D E F G ]
     终点节点: [A B C D E F G ]
     时间复杂度On^3

     容易理解,容易编写:你怎么想不到呢???有意思 -基于动态规划
     在稠密图效率最佳 能知道任意两个节点的最短距离

     //Floyd-Warshall算法核心语句
     20     for(k=1;k<=n;k++)
     21     for(i=1;i<=n;i++)
     22     for(j=1;j<=n;j++)
     23     if(e[i][j]>e[i][k]+e[k][j] )
     24     e[i][j]=e[i][k]+e[k][j];
     */

    public static void main(String[] args) {
        //测试一下图是否创建成功
        char[] vertex = {'A' ,'B', 'C', 'D', 'E', 'F', 'G'};
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N=65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};

        //创建图对象
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }
}

class Graph {
    private char[] vertex; //点
    private int[][] dis;//距离表  结果的距离也是在此更新
    private int[][] pre;//前驱节点 的下标

    //构造器
    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        //对pre进行初始化  存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);

        }
    }

    //显示方法 dis pre
    public void show() {
        //为了显示方便阅读 优化输出
        char[] vertex = {'A' ,'B', 'C', 'D', 'E', 'F', 'G'};
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {//pre
                System.out.print(vertex[pre[k][i]]+" ");
            }
            System.out.println();
            for (int i = 0; i < dis.length; i++) {//dis
                System.out.print("("+vertex[k]+"到"+vertex[i]+"的最短路径是--"+dis[k][i] + "--) ");
            }
            System.out.println();
        }
    }

    //floyd算法
    public void floyd(){
        int len = 0; //保存距离
        //从中间节点的遍历,k就是中间顶点的下标 A BC D E F G
        for (int k = 0; k < dis.length; k++) {
            //这是从i顶点出发 A B C
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k]+dis[k][j];//就是i到k的距离  +k+j的距离==i 通过k中间节点到大k的距离
                    if (len < dis[i][j]){//有中间节点的距离,小于没有k的距离,那么我就更新你
                        dis[i][j] = len;//更新距离
                       pre[i][j] = pre[k][j];//更新前驱节点===把ij  -> kj的顶点   pre没有也可以
                    }
                }
            }
        }
    }

    /***
     作者：绝顶我为峰
     链接：https://www.zhihu.com/question/20630094/answer/758191548
     来源：知乎
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     inline void dijkstra()//可以不带参数，也可以把起点带进来
     {
     priority_queue<element> q;//优先队列大法吼
     q.push(element(1,0));//把起点压进去
     while(!q.empty())//不空就说明还有点没搜完
     {
     element k=q.top();//取出队首
     q.pop();
     if(vis[k.node])//如果已经在集合中（被搜到过）
     continue;//扔掉
     vis[k.node]=1;//标记
     dis[k.node]=k.value;//存下最短路（由于优先队列的排序已经相当于完成了松弛，所以这就是答案）
     for(vector<edge>::iterator it=v[k.node].begin();it!=v[k.node].end();++it)//用指针遍历邻接表
     q.push(element(it->node,it->weight+k.value));//松弛
     }
     }
     这样一来，均摊时间复杂度降为 O((e+n)log n) ，效率大大提升，处理稀疏图所向披靡^_^
     */
}
