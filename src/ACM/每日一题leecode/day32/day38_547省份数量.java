package ACM.每日一题leecode.day32;

import java.util.*;

/****
 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连
 ，而 isConnected[i][j] = 0 表示二者不直接相连。
 返回矩阵中 省份 的数量。

 示例 1：
 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 输出：2
 示例 2：
 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 输出：3
 */
public class day38_547省份数量 {
    public static void main(String[] args) {
        System.out.println("这是结果=" + findCircleNum2(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));//2
        System.out.println("这是结果=" + findCircleNum2(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));//3
    }

    //思路:采用广度优先搜索:bfs  能搜索几次,就是几个城市
    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int[] vertex = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            vertex[i] = i;
        }
        System.out.println("这是点" + Arrays.toString(vertex));
        int cityCount = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (!visited[i]) {
                cityCount++;
                bfs(isConnected, visited, i);
            }
        }


        return cityCount;
    }

    public static void bfs(int[][] isConnected, boolean[] visited, int v) {
        //visited[v]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            Integer v1 = queue.poll();
            visited[v1] = true;
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[v1][i] != 0 && v1 != i && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
    }

    //尝试采用并查集
    public static int findCircleNum2(int[][] isConnected) {
        /****
         并查集是一种数据结构:
         并union:合并
         查find:查找
         集set:字典为基础的数据结构 :基本功能:合并集合中的元素,查找集合中的元素
         应用:连通分量; 并查集解决添加,合并,查找的时间复杂度都是O{1}
         应此并查集可以应用到在线算法中

         实现:
         并查集和树类似,不过和树相反,树每个节点记录子节点,并查集是记录父节点

         如果节点是相互连通的,那么他们的祖先是相同的,这个和最小生成树里面定义的终点数组有点像
         终点数组:一开始自己的终点指向自己,而后每个节点的终点指向他起点的终点,也就是同一个终点
         *   1       4
         * 2  3      5
         *567        6

         如果发现两个节点是联通的,就合并这两个节点,也就是他们的祖先是相同的,这里把谁当成祖先一般是没有
         区别的

         判断两个节点是否处于同一个连通分量的时候,就需要判断他们的祖先是否相同

         查找祖先的方法是:如果节点的父节点不为空,就不断迭代


         这里有一个优化的点：如果我们树很深，比如说退化成链表，那么每次查询的效率都会非常低。所以我们要做一下路径压缩。也就是把树的深度固定为二。
         这么做可行的原因是，并查集只是记录了节点之间的连通关系，而节点相互连通只需要有一个相同的祖先就可以了。
         路径压缩可以用递归，也可以迭代。这里用迭代的方法。

         *      1
         *    2 3 5 6 7
         *
         */

        UnionFind uf = new UnionFind();
        for (int i = 0; i < isConnected.length; i++) {
            uf.add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j]==1){
                    uf.add(j);
                    uf.merge(i,j);
                }
            }
        }
        return uf.getNumOfSets();
    }
}

class UnionFind {
    //记录父节点
    private Map<Integer, Integer> father;

    //记录集合的数量
    private int numOfSets = 0;

    public UnionFind() {
        father = new HashMap<Integer,Integer>();
    }

    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
            numOfSets++;
        }
    }

    //如果发现两个节点是联通的,就合并这两个节点,也就是他们的祖先是相同的,这里把谁当成祖先一般是没有
    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY){
            father.put(rootX,rootY);
            numOfSets--;
        }
    }

    //判断两个节点是否处于同一个连通分量的时候,就需要判断他们的祖先是否相同
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    //查找祖先的方法是:如果节点的父节点不为空,就不断迭代
    public int find2(int x) {
        int root = x;

        while(father.get(root) != null){
            root = father.get(root);
        }

        return root;
    }

    //加入路径压缩功能的查找方法
    public int find(int x) {
        int root = x;

        while(father.get(root) != null){
            root = father.get(root);
        }

        while(x != root){
            int original_father = father.get(x);
            father.put(x,root);
            x = original_father;
        }

        return root;
    }

    public int getNumOfSets() {
        return numOfSets;
    }
}