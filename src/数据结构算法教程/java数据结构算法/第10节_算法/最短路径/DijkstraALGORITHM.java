package 数据结构算法教程.java数据结构算法.第10节_算法.最短路径;

import java.util.Arrays;

public class DijkstraALGORITHM {

    /***Dijkstra算法实现原理 基于贪心
     BFS:
     设置出发顶点为v,顶点集合V{v1,v2,vi...}v到Vi各顶点的距离为构成距离集合DIS,
     DIS{d1,d2,di...},DIS集合记录看v到图中各顶点的距离{到自身可以看做0,v到vi距离距离对应即为最短路径}

     1.从DIS中选择值最小的di移除DIS集合,同时移除V集合中对应的vi,此时的v到vi即为最短路径
     2.更新DIS集合,更新规则为:比较v到V集合中顶点的距离值,与v通过vi到V集合中顶点的距离值,保留值较小的
     一个{同时也应该更新定顶点的前驱节点为vi,表示是通过vi到达的}
     3.重复执行两步骤,直到最短路径顶点为目标顶点即可结束

     pre前驱距离:

     (A)----1---(B)---3--(C)--------13-----(D)-----(E)-------(F)

     A B C D E F
     0 1 N N N N

     纳入B 之后
     0 1 4 N N N
     4=1+3


     //贪心思路:每次选取最小的边,来作为桥梁松弛其他的边 并更薪
     */
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535; //便是不可连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        //创建一个graph对象
        Graph graph = new Graph(vertex, matrix);
        //测试图输出
        graph.showFraph();
        //测试dsj算法
        graph.dsj(6);
        graph.showDijkstra();
        System.out.println("下标换C");
        graph.dsj(2);
        graph.showDijkstra();
    }

}

//已访问质点集合  三个集合{已访问 前驱 距离}
class VisitedVertex {
    public int[] alread_arr; //记录各个顶点是否访问过 1表示访问过 0表示为访问 会动态更新
    public int[] pre_visited; //每个下标对应的值为前一个顶点下标,会动态更新
    public int[] dis; //记录出发顶点到其所有顶点的距离,比如G为出发顶点,就会记录G到其他顶点的距离,动更,求的最短距离会在dis

    //构造器
    public VisitedVertex(int length, int index) {//len:顶点的个数  index出发的顶点 下标G->6
        this.alread_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化dis距离
        Arrays.fill(dis, 65535);
        this.alread_arr[index] = 1; //设置出发顶点为已访问过
        this.dis[index] = 0;//设置出发的顶点0  --这里应该动态设置
    }

    //判断index这个顶点是否访问过  访问过true  false
    public boolean in(int index) {
        return alread_arr[index] == 1;//==1就是访问过
    }

    //更新出发顶点到index顶点的距离
    public void updateDis(int index, int len) {
        dis[index] = len;//距离 小于就更新
    }

    //更新顶点的前驱为index这个节点  前驱节点变化了要体现出来
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;//更新pre这个顶点的前驱顶点为index顶点
    }

    //功能:返回出发顶点到index顶点的距离
    public int getDis(int index) {
        return dis[index];
    }

    //继续选择并返回新的访问顶点,比如这里的G完后,就是A作为新的访问接地那(不是出发节点)
    public int updateArr() {//找到没访问过的,且距离最小的
        int min = 65535, index = 0;
        for (int i = 0; i < alread_arr.length; i++) {
            if (alread_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //更新index顶点被访问过
        alread_arr[index] = 1;
        return index;
    }

    //显示最后的结果 --输出三个数组 前驱
    public void show() {
        System.out.println("========================");
        //输出alread_arr
        for (int i : alread_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出前驱顶点
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis
        for (int di : dis) {
            System.out.print(di + " ");
        }
        System.out.println();
        //为了好看 最后的最短距离处理一下
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "(" + i + ")");
            } else {
                System.out.print("N  ");
            }
            count++;
        }
        System.out.println();
    }

}

//图类
class Graph {
    private char[] vertex; //顶点数组
    private int[][] matrix; //邻接矩阵
    private VisitedVertex vv; //已经访问的顶点的集合

    //构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示图
    public void showFraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    //显示结果
    public void showDijkstra() {
        vv.show();
    }

    //dijkstra算法  idnex=出发顶点的下标
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index); //更新index下标顶点到周围顶点的距离和前驱顶点一次

        for (int j = 1; j < vertex.length; j++) {
            index = vv.updateArr();//选择并返回min最短的新的访问顶点
            update(index); //更新index下标顶点到周围顶点的距离和前驱顶点一次
        }
    }

    //更新index顶点的到周围顶点的距离和周围顶点的前驱顶点
    private void update(int index) {//index为6  遍历6行,根据这行的数据进行更新dis距离
        int len = 0;
        for (int j = 0; j < matrix[index].length; j++) {
            //len 表示处罚书顶点到index顶点的距离加上index顶点到j顶点的和, 把已经统计过的距离拿到
            len = vv.getDis(index) + matrix[index][j];//index就相当于中间节点
            //j没有访问过,还小于顶点的距离,就需要更新
            if (!vv.in(j) && len < vv.getDis(j)) {//找到一条更小的
                vv.updatePre(j, index); //更新j顶点的前驱为index顶点
                vv.updateDis(j, len); //更新出发顶点到j顶点的距离
            }
        }
    }


}