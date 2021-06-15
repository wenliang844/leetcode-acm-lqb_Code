package ACM.每日一题leecode.day32;

import java.util.Arrays;

public class day52_1319连通网络的操作次数 {
    /***
     用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。

     网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。

     给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 

      

     示例 1：



     输入：n = 4, connections = [[0,1},{0,2},{1,2]]
     输出：1
     解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。

     */
    public static void main(String[] args) {

        //System.out.println("这是结果="+makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
        //System.out.println("这是结果="+makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}}));
        System.out.println("这是结果="+makeConnected(12, new int[][]{{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}}));
    }

    public static int makeConnected(int n, int[][] connections) {

        if (n>connections.length+1){
            return -1;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            uf.union(connection[0],connection[1]);
        }
        System.out.println("这回并查集="+Arrays.toString(uf.parent));

        //return uf.getCount();

        int count = 0;
        for (int i = 0; i < uf.parent.length; i++) {
            if (uf.parent[i] == i){
                count++;
            }
        }

        return count-1;
    }


    static class UnionFind{

        int count = 0;
        int[] parent;
        //初始化 让parent父节点为自己本身
        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        //合并两个点
        public void union(int x,int y){
            count++;
            if (find(x) != find(y)){
                parent[find(x)] = find(y);
                count--;
            }

        }

        //找点的父节点  //没有路径压缩
        public int find(int x){
            if (parent[x] != x){
                return find(parent[x]);
            }
            return parent[x];
        }

        public int getCount(){

            return count;
        }

        public static void test1(){
            System.out.println("你是猪");
            //李白：金三打字通
        }


        /***
         安秩合并
         int find(int x) {
         // 压缩方式：直接指向根节点
         if (x != parent[x]) {
         parent[x] = find(parent[x]);
         }
         return parent[x];
         }

         void merge(int x, int y) {
         int rootx = find(x);
         int rooty = find(y);
         if (rootx != rooty) {
         // 按秩合并
         if (rank[rootx] < rank[rooty]) {
         swap(rootx, rooty);
         }
         parent[rooty] = rootx;
         if (rank[rootx] == rank[rooty]) rank[rootx] += 1;
         count--;
         } else {
         rest++;
         }
         }
         int getCount() {
         return count;
         }
         int getRest() {
         return rest;
         }
         };

         */
    }
}
