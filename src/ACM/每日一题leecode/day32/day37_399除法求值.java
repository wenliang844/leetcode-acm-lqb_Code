package ACM.每日一题leecode.day32;

import java.rmi.MarshalledObject;
import java.util.*;

/****
 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。

  

 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。

  

 示例 1：

 输入：equations = [["a","b"},{"b","c"]], values = [2.0,3.0], queries = [["a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"]]
 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 解释：
 条件：a / b = 2.0, b / c = 3.0
 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 示例 2：

 输入：equations = [["a","b"},{"b","c"},{"bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"},{"c","b"},{"bc","cd"},{"cd","bc"]]
 输出：[3.75000,0.40000,5.00000,0.20000]
 示例 3：

 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"},{"b","a"},{"a","c"},{"x","y"]]
 输出：[0.50000,2.00000,-1.00000,-1.00000]
 ***存在传递函数依赖
 *
 [["x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"]]
 [3.0,4.0,5.0,6.0]
 [["x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"]]
 输出：
 [-1.00000,-1.00000,20.00000,1.00000,-1.00000,-1.00000]
 预期：
 [360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000]

 a=2b
 b=3c
 我们可以把不同变量转换成相同变量的倍数[统一标准]  兑换关系
 a/a=1=6c/6c --> x/xw=0=-1 不在并查集中
 建立有向图 a -> b -> c
 采用统一变量/路径压缩
 b->c
 a->c
 


 官方解答:
 食用并查集:
 990利用了等式相等具有传递性
 -并查集:不想交集合,用于处理动态连通性问题,最典型的应用是求解最小生成树的kruskal算法
 -并查集:支持find union合并两个操作
 -并查集只回答两个节点是不是在一个连通分量,连通性问题,并不回答路径问题
 -如果一个问题有传递性质,使用并查集
 -并查集常见的设计思想是:把一个连通分量的节点组成的树形结构
 -并查集使用[路径压缩][安秩合并] 解决树的高度增加带来的查询性能消耗问题
 可以在算法4 算法导论中学习并查集

 路径压缩中维护权值的变化:
 a->b->c->d   --->    c->d
 如何在合并的过程中维护权值的变化
 ::我们将要合并的两颗树的高度最多为2
 已知a/b=3   d/c=4  a/d=6  问b/c=?
 合并后产生了一颗高度为3的树.是不是会影响结果?

 一边查询/一边修改是并查集的特点
 */

/****
 *import java.util.List;
 * import java.util.Map;
 *
 * public class Solution {
 *
 *     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
 *         int equationsSize = equations.size();
 *
 *         UnionFind unionFind = new UnionFind(2 * equationsSize);
 *         // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
 *         Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
 *         int id = 0;
 *         for (int i = 0; i < equationsSize; i++) {
 *             List<String> equation = equations.get(i);
 *             String var1 = equation.get(0);
 *             String var2 = equation.get(1);
 *
 *             if (!hashMap.containsKey(var1)) {
 *                 hashMap.put(var1, id);
 *                 id++;
 *             }
 *             if (!hashMap.containsKey(var2)) {
 *                 hashMap.put(var2, id);
 *                 id++;
 *             }
 *             unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
 *         }
 *
 *         // 第 2 步：做查询
 *         int queriesSize = queries.size();
 *         double[] res = new double[queriesSize];
 *         for (int i = 0; i < queriesSize; i++) {
 *             String var1 = queries.get(i).get(0);
 *             String var2 = queries.get(i).get(1);
 *
 *             Integer id1 = hashMap.get(var1);
 *             Integer id2 = hashMap.get(var2);
 *
 *             if (id1 == null || id2 == null) {
 *                 res[i] = -1.0d;
 *             } else {
 *                 res[i] = unionFind.isConnected(id1, id2);
 *             }
 *         }
 *         return res;
 *     }
 *
 *     private class UnionFind {
 *
 *         private int[] parent;
 *
 *         /**
 *    指向的父结点的权值
 *   /
 *private double[]weight;
 
 
 public UnionFind(int n){
 this.parent=new int[n];
 this.weight=new double[n];
 for(int i=0;i<n; i++){
 parent[i]=i;
 weight[i]=1.0d;
 }
 }
 
 public void union(int x,int y,double value){
 int rootX=find(x);
 int rootY=find(y);
 if(rootX==rootY){
 return;
 }
 
 parent[rootX]=rootY;
 weight[rootX]=weight[y]*value/weight[x];
 }
 
          /**
 *    路径压缩
 public int find(int x){
 if(x!=parent[x]){
 int origin=parent[x];
 parent[x]=find(parent[x]);
 weight[x]*=weight[origin];
 }
 return parent[x];
 }
 
 public double isConnected(int x,int y){
 int rootX=find(x);
 int rootY=find(y);
 if(rootX==rootY){
 return weight[x]/weight[y];
 }else{
  return-1.0d;
    }
     }
      }
        }
  
 */
public class day37_399除法求值 {
    public static void test1() {
        List<List<String>> equations = new ArrayList<>();
        String[][] equationsArrays = {{"a", "b"}, {"b", "c"}};
        for (int i = 0; i < equationsArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(equationsArrays[i][0]);
            listTemp.add(equationsArrays[i][1]);
            equations.add(listTemp);
        }

        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        String[][] queriesArrays = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        for (int i = 0; i < queriesArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(queriesArrays[i][0]);
            listTemp.add(queriesArrays[i][1]);
            queries.add(listTemp);
        }
        System.out.println("这个是问题模板" + equations);
        System.out.println("这个是答案模板" + Arrays.toString(values));
        System.out.println("这是问题" + queries);


        double[] answers = calcEquation3(equations, values, queries);
        System.out.println("这是答案=" + Arrays.toString(answers));
    }

    public static void test2() {
        List<List<String>> equations = new ArrayList<>();
        String[][] equationsArrays = {{"x1", "x2"}, {"x2", "x3"},{"x3", "x4"},{"x4", "x5"}};
        for (int i = 0; i < equationsArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(equationsArrays[i][0]);
            listTemp.add(equationsArrays[i][1]);
            equations.add(listTemp);
        }

        double[] values = {3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = new ArrayList<>();
        String[][] queriesArrays = {{"x1", "x5"},{"x5", "x2"},{"x2", "x4"},{"x2", "x2"},{"x2", "x9"},{"x9", "x9"}};
        for (int i = 0; i < queriesArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(queriesArrays[i][0]);
            listTemp.add(queriesArrays[i][1]);
            queries.add(listTemp);
        }
        System.out.println("这个是问题模板" + equations);
        System.out.println("这个是答案模板" + Arrays.toString(values));
        System.out.println("这是问题" + queries);


        double[] answers = calcEquation3(equations, values, queries);
        System.out.println("这是答案=" + Arrays.toString(answers));
    }
    public static void test3() {
        List<List<String>> equations = new ArrayList<>();
        String[][] equationsArrays = {{"a","b"},{"c","d"}};
        for (int i = 0; i < equationsArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(equationsArrays[i][0]);
            listTemp.add(equationsArrays[i][1]);
            equations.add(listTemp);
        }

        double[] values = {1.0,1.0};
        List<List<String>> queries = new ArrayList<>();
        String[][] queriesArrays = {{"a","c"},{"b","d"},{"b","a"},{"d","c"}};
        for (int i = 0; i < queriesArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(queriesArrays[i][0]);
            listTemp.add(queriesArrays[i][1]);
            queries.add(listTemp);
        }
        System.out.println("这个是问题模板" + equations);
        System.out.println("这个是答案模板" + Arrays.toString(values));
        System.out.println("这是问题" + queries);


        double[] answers = calcEquation3(equations, values, queries);
        System.out.println("这是答案=" + Arrays.toString(answers));
    }
    public static void test4() {

        List<List<String>> equations = new ArrayList<>();
        String[][] equationsArrays = {{"a","b"},{"b","c"},{"bc","cd"}};
        for (int i = 0; i < equationsArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(equationsArrays[i][0]);
            listTemp.add(equationsArrays[i][1]);
            equations.add(listTemp);
        }

        double[] values = {1.5,2.5,5.0};
        List<List<String>> queries = new ArrayList<>();
        String[][] queriesArrays = {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}};
        for (int i = 0; i < queriesArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(queriesArrays[i][0]);
            listTemp.add(queriesArrays[i][1]);
            queries.add(listTemp);
        }
        System.out.println("这个是问题模板" + equations);
        System.out.println("这个是答案模板" + Arrays.toString(values));
        System.out.println("这是问题" + queries);


        double[] answers = calcEquation3(equations, values, queries);
        System.out.println("这是答案=" + Arrays.toString(answers));
    }
    public static void test5() {

        List<List<String>> equations = new ArrayList<>();
        String[][] equationsArrays = {{"a","b"},{"b","c"},{"bc","cd"}};
        for (int i = 0; i < equationsArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(equationsArrays[i][0]);
            listTemp.add(equationsArrays[i][1]);
            equations.add(listTemp);
        }

        double[] values = {1.5,2.5,5.0};
        List<List<String>> queries = new ArrayList<>();
        String[][] queriesArrays = {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}};
        for (int i = 0; i < queriesArrays.length; i++) {
            List<String> listTemp = new ArrayList<>();
            listTemp.add(queriesArrays[i][0]);
            listTemp.add(queriesArrays[i][1]);
            queries.add(listTemp);
        }
        System.out.println("这个是问题模板" + equations);
        System.out.println("这个是答案模板" + Arrays.toString(values));
        System.out.println("这是问题" + queries);


        double[] answers = calcEquation4(equations, values, queries);
        System.out.println("这是答案=" + Arrays.toString(answers));
    }

    public static void main(String[] args) {
        //test1();
        //test02();
        //test3();
        //test4();
        test5();

    }

    //用map映射
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //建立一个答案映射map
        Map<String, Double> answerMaps = new HashMap();
        int len = equations.size();
        for (int i = 0; i < len - 1; i++) {
            List<String> strings = equations.get(i);
            String s1 = strings.get(0);
            String s2 = strings.get(1);
            answerMaps.put(s1 + s2, values[i]);
            answerMaps.put(s2 + s1, 1 / values[i]);
            answerMaps.put(s1 + s1, (double) 1);
            answerMaps.put(s2 + s2, (double) 1);
            for (int j = i + 1; j < len; j++) {
                if (s2.equals(equations.get(j).get(0))) {//s2==equations.get(j).get(0)
                    answerMaps.put(s1 + equations.get(j).get(1), values[i] * values[j]);
                    answerMaps.put(equations.get(j).get(1) + s1, 1 / (values[i] * values[j]));
                } else if (s2.equals(equations.get(j).get(1))) {
                    answerMaps.put(s1 + equations.get(j).get(0), values[i] / values[j]);
                    answerMaps.put(equations.get(j).get(0) + s1, values[j] / values[i]);
                }
            }
        }
        answerMaps.put(equations.get(len - 1).get(0) + equations.get(len - 1).get(1), values[len - 1]);
        answerMaps.put(equations.get(len - 1).get(1) + equations.get(len - 1).get(0), 1 / values[len - 1]);
        answerMaps.put(equations.get(len - 1).get(0) + equations.get(len - 1).get(0), (double) 1);
        answerMaps.put(equations.get(len - 1).get(1) + equations.get(len - 1).get(1), (double) 1);
        //System.out.println("这是回答map映射"+answerMaps);

        //对问题进行遍历,如果map找到了就double answer[i]=map.get(string)   如果没找到double answer[i]=-1
        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            Double ans = answerMaps.get(list.get(0) + list.get(1));
            if (ans == null) {
                answer[i] = -1;
            } else {
                answer[i] = ans;
            }
        }

        return answer;
    }

    //map映射 优化:解除传递函数依赖
    public static double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //建立一个答案映射map
        Map<String, Double> answerMaps = new HashMap();
        List<List<String>> answerList1 = new ArrayList<>();
        List<List<String>> answerList2 = new ArrayList<>();

        int len = equations.size();
        for (int i = 0; i < len; i++) {
            List<String> strings = equations.get(i);
            String s1 = strings.get(0);
            String s2 = strings.get(1);
            answerMaps.put(s1 + s2, values[i]);
            answerMaps.put(s2 + s1, 1 / values[i]);
            answerMaps.put(s1 + s1, (double) 1);
            answerMaps.put(s2 + s2, (double) 1);
        }

        answerList1 = equations;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < len - 1; i++) {
                List<String> strings = answerList1.get(i);
                String s1 = strings.get(0);
                String s2 = strings.get(1);
                for (int j = 0; j < len; j++) {

                }
            }
        }
        //System.out.println("这是回答map映射"+answerMaps);

        //对问题进行遍历,如果map找到了就double answer[i]=map.get(string)   如果没找到double answer[i]=-1
        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            Double ans = answerMaps.get(list.get(0) + list.get(1));
            if (ans == null) {
                answer[i] = -1;
            } else {
                answer[i] = ans;
            }
        }

        return answer;
    }

    //用图 邻接矩阵 floyd算法
    public static double[] calcEquation3(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //构建一个答案图 len*len
        //1.构建一个节点集合
        Map<String, Integer> pointMap = new HashMap<>();
        int i = 0;
        for (int j = 0; j < equations.size(); j++) {
            String s1 = equations.get(j).get(0);
            String s2 = equations.get(j).get(1);
            Integer i1 = pointMap.get(s1);
            if (i1 == null) {
                pointMap.put(s1, i);
                i++;
            }
            Integer i2 = pointMap.get(s2);
            if (i2 == null) {
                pointMap.put(s2, i);
                i++;
            }

        }
        //System.out.println("这是节点集合" + pointMap);

        int len = pointMap.size();
        double[][] answerGraph = new double[len][len];

        //对answergraph进行初始化
        /*for (int j = 0; j < answerGraph.length; j++) {
            for (int k = 0; k < answerGraph.length; k++) {
                answerGraph[j][k]=-1;
            }
        }*/
        for (int j = 0; j < equations.size(); j++) {
            answerGraph[pointMap.get(equations.get(j).get(0))][pointMap.get(equations.get(j).get(1))] = values[j];
            answerGraph[pointMap.get(equations.get(j).get(1))][pointMap.get(equations.get(j).get(0))] = 1 / values[j];
        }
        System.out.println("这是答案图初始");
        for (double[] doubles : answerGraph) {
            System.out.println(Arrays.toString(doubles));
        }

        //利用floyd算法进行图的_最短路径全部求解_不同的是我们求的不是最短路径,由于两个节点的通路是唯一的,求的是唯一通路
        //int[] point


        for (int j = 0; j < answerGraph.length; j++) {
            for (int k = 0; k < answerGraph.length; k++) {
                for (int l = 0; l < answerGraph[k].length; l++) {
                    double num1 = answerGraph[k][j] * answerGraph[j][l];
                    if (num1 > answerGraph[k][l]) {
                        //System.out.println("这是找到的连续函数=====" + num1 + answerGraph[k][j] + "-" + answerGraph[j][l]);
                        answerGraph[k][l] = num1;
                    }
                }
            }
        }
       System.out.println("这是floys后的answerGraph");
        for (double[] doubles : answerGraph) {
            System.out.println(Arrays.toString(doubles));
        }

        double[] answers = new double[queries.size()];
        //利用anserGraph进行求解
        for (int j = 0; j < queries.size(); j++) {
            Integer num1 = pointMap.get(queries.get(j).get(0));
            Integer num2 = pointMap.get(queries.get(j).get(1));
            double n = answerGraph[num1][num2];
            if (num1 != null && num2 != null) {
                answers[j] = n;
            } else {//if (num1==null || num2==null || answerGraph[num1][num2]==0)
                answers[j] = -1;
            }
        }

        for (int j = 0; j < answers.length; j++) {
            if (answers[j]==0){
                answers[j]=-1;
            }
        }

        return answers;
    }

    //尝试采用并查集
    public static double[] calcEquation4(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /***
         典型:kruskal算法:边查 边进行合并,
         回答了两个节点是不是在一个联通分量中,不回答路径问题,
         只需要关系是不是连接,不关心怎么连接的

         把同在一个连通分量的节点合并在一个,把一个树的根节点,连接另一棵树的根节点
         代表元法,路径压缩,按秩查询

         */
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);//都不相同的长度
        Map<String,Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)){
                hashMap.put(var1,id);
                id++;
            }
            if (!hashMap.containsKey(var2)){
                hashMap.put(var2,id);
                id++;
            }
            unionFind.union(hashMap.get(var1),hashMap.get(var2),values[i]);//合并v1 v2/权值
        }
        System.out.println("这是整理好的hashMap="+hashMap);

        //第二步,查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 ==null || id2==null){
                res[i]=-1.0;
            }else {
                res[i]=unionFind.isConnected(id1,id2);
            }
        }

        return res;
    }

    private static class UnionFind{
        private int[] parent;
        private double[] weight;//权值:节点指向父节点的权值

        public UnionFind(int n){
            this.parent = new int[n];
            this.weight=new double[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i; //和kruskal加边法类似,数组值是对应下标点的父节点
                weight[i]=1.0d;
            }
        }

        public void union(int x,int y,double value){
            int rootX = find(x);
            int rootY = find(y);//找他们的父节点,如果父节点一致的话,不需要合并
            if (rootX == rootY){
                return;
            }
            parent[rootX]=rootY;//让X的父节点指向Y
            weight[rootX] = weight[y]*value /weight[x];
        }

        public int find(int x){//路径压缩 return根节点
            //如何维护节点的信息?
            if (x!=parent[x]){
                int origin = parent[x];
                parent[x]=find(parent[x]);//找到自己指向自己的那个节点,也就是根节点
                weight[x] *= weight[origin];
            }

            return parent[x];//x的父节点才是根节点
        }

        public double isConnected(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY){
                return weight[x] / weight[y];//指向了同一个根节点/根据据经压缩
            }else {
                return -1.0;
            }
        }

    }
}
