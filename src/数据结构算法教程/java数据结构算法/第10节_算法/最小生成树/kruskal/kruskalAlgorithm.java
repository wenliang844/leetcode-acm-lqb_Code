package 数据结构算法教程.java数据结构算法.第10节_算法.最小生成树.kruskal;

import java.util.Arrays;

public class kruskalAlgorithm {
    /***
     算法思路:
     求加权联通图的最小生成树的算法
     做法:
     1.构造一个只含n个顶点的森林,从权值小到大 选择边到森林
     使森林中不产生回路,直至森林变成一颗树为止
     排序
     满足条件 {不回路,} 则加入

     {用数组报存结果}

     ???如何判断回路???
     answer:记录顶点在最小生成树中的终点
     判断边的两个顶点的终点是否重合.重合则回路
     {我们加入的边的两个顶点 不能指向同一个终点} //判断端点u v是否属于同一棵树
     也就是说:不能是边集上的点
     如何判断最大终点? ---
     */
    private int edgeNum; //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;//表是不连通

    public static void main(String[] args) {

        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                /***//*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/{0, 12, INF, INF, INF, 16, 14},
                /*B*/{12, 0, 10, INF, INF, 7, INF},
                /*C*/{INF, 10, 0, 3, 5, 6, INF},
                /*D*/{INF, INF, 3, 0, 4, INF, INF},
                /*E*/{INF, INF, 5, 4, 0, 2, 8},
                /*F*/{16, 7, 6, INF, 2, 0, 9},
                /*G*/{14, INF, INF, INF, 8, 9, 0}};
        kruskalAlgorithm kruskalAlgorithm = new kruskalAlgorithm(vertexs, matrix);
        kruskalAlgorithm.printShowMessage();

        EData[] mEdges = kruskalAlgorithm.getEdges();
        System.out.println(Arrays.toString(mEdges));
        kruskalAlgorithm.sortEData(mEdges);
        System.out.println("排序后=------=" + Arrays.toString(mEdges));

        //测试kruskal
        kruskalAlgorithm.kruskal();
    }

    //构造器
    public kruskalAlgorithm(char[] vertexs, int[][] matrix) {
        //初始化顶点和边的个数
        int vlen = vertexs.length;

        //赋值 初始化顶点
        this.vertexs = new char[vlen];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        //this.vertexs = vertexs;//这是同步地址
        //初始化边 使用的是赋值copy方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) { //j = 0
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }


    }

    //打印邻接矩阵
    public void printShowMessage() {
        System.out.println("邻接矩阵为:");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println("这是边的数量" + this.edgeNum);
    }

    private int getPosition(char ch) {
        /***
         ch: 顶点的值
         return ch顶点对应的下表 or-1    A->0 B->1
         */
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }

        //找不到 -1
        return -1;
    }

    //边的排序_集合排序_对边进行排序
    private void sortEData(EData[] eData) {
        /***
         eData: 边的集合
         */
        for (int i = 0; i < eData.length - 1; i++) {
            for (int j = 0; j < eData.length - 1 - i; j++) {
                if (eData[j].weight > eData[j + 1].weight) {
                    //交换
                    EData temp = eData[j];
                    eData[j] = eData[j + 1];
                    eData[j + 1] = temp;
                }
            }
        }
    }

    //功能:获取图中的边,放到EData数组中   需要遍历这个数组,找出最小的且符合条件的边
    private EData[] getEdges() {
        //通过matix 邻接矩阵获取
        /***
         EDate: A,B,12   B,F,7
         */
        int index = 0;
        EData[] edges = new EData[edgeNum];//所有的边放在这个构造器中 存放边
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }

        return edges;

    }

    //获取下标为i的顶点的终点 //判断是否形成回路,判断是否有最大顶点   两个点的终点是不是桶一个终点
    //用于后面判断两个顶点的终点是否相同
    //ends记录了各个顶点对应的终点是哪个;  ends是在遍历过程中动态形成的 逐步形成的
    private int getEnd(int[] ends, int i) {
        /***
         比如:下标 3'D'  的终点是 F6
              下标4'E'  的终点也是F6
              下标6F   的终点也是F6
            你传入一个没有记录的,终点是它本身
         就是F是源头,加入的所有的点都指向F
         然后新加入的点 不能是两个都是指向F的 不然会构成回路
         也就是把问题转换为 不能两个点在同一颗生成树  -> 把生成树上的点的下标建立一个数组,值相同->都指向一开始的那棵树

         question???那么:如果一开始有两颗最小生成树,后面合成了之后.这个终点数组需要变化吗???

         */
        while (ends[i] != 0) {
            i=ends[i];
        }
        return i;
    }

    public void kruskal(){
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgeNum];//并查集 保存节点的起始节点
        //创建结果数组,保存最终的最小生成树
        EData[] rets = new EData[edgeNum];//不可能超过

        //获取图所有边的集合,一共12条边
        EData[] edges = getEdges();
        System.out.println("获取边的集合="+Arrays.toString(edges)+"共边"+edgeNum);

        //边按照升序排序
        sortEData(edges);

        //遍历所有的边,将边添加到最小生成树,判断是否构成回路 |如果没构成回路,就加入,否则不加
        for (int i = 0; i < edgeNum; i++) {
            //1,获取到第i条边的第一个起点
            int p1 = getPosition(edges[i].start);//p1 =4
            //获取i边的第二个顶点
            int p2 = getPosition(edges[i].end);//p2=5

            //获取p1这个顶点在已有最小生成树中的终点
            int m = getEnd(ends,p1); //4
            //获取p2这个顶点在最小生成树的终点
            int n = getEnd(ends, p2); //5
            if (m!=n){//不构成回路 没有指向一个终点   入选了
                ends[m] = n;//设置m在"已有最小生成树"中的终点 <m->n   n->n
                //<E,F> [0,0,0,5,0,0,0,0,0,0,0,0]  -->E
                //下标4的终点是5   5->5 F->F   会返回自己,所以不用记录自己  自己都是指向自己的
                //妙 :然后下一个点进来,又是指向你的终点的终点 还是同一个终点 这个终点就是树的顶点
                rets[index++] = edges[i];
            }
        }

        //统计并打印最小生成树_输出rets
        System.out.println("最小生成树是=========="+Arrays.toString(rets));

    }
}

//创建一个边类,表示一条边; 两个顶点,一个权值
class EData {
    char start; //边的起点
    char end; //边的终点
    int weight; //权值

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    //输出信息_从写toString
    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }


}