package ACM.每日一题leecode.day32;

import java.util.*;

public class day41_1202交换字符串中的元素 {

    static void swap(int i, int j, char[] chars) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void test1() {
        int[][] pairs = new int[][]{{0, 3}, {1, 2}, {0, 2}};
        List<List<Integer>> pairsList = new ArrayList<>();
        for (int i = 0; i < pairs.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(pairs[i][0]);
            list.add(pairs[i][1]);
            pairsList.add(list);
        }
        System.out.println("这是结果=" + smallestStringWithSwaps3("dcab", pairsList));
    }

    public static void test2() {
        int[][] pairs = new int[][]{{0, 3}, {1, 2}, {0, 2}};
        List<List<Integer>> pairsList = new ArrayList<>();
        for (int i = 0; i < pairs.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(pairs[i][0]);
            list.add(pairs[i][1]);
            pairsList.add(list);
        }
        System.out.println("这是结果=" + smallestStringWithSwaps3("abcd", pairsList));
    }

    public static void LeeCodeSolution(){
        int[][] pairs = new int[][]{{0, 3}, {1, 2}, {0, 2}};
        List<List<Integer>> pairsList = new ArrayList<>();
        for (int i = 0; i < pairs.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(pairs[i][0]);
            list.add(pairs[i][1]);
            pairsList.add(list);
        }
        System.out.println("这是结果=" + smallestStringWithSwaps4("abcd", pairsList));

    }
    public static void main(String[] args) {
        //test1();
        //test02();
        LeeCodeSolution();

    }

    //方法一:暴力
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();

        boolean flag = true;
        while (flag) {
            flag = false;

            for (List<Integer> list : pairs) {
                if (chars[list.get(0)] > chars[list.get(1)]) {
                    swap(list.get(0), list.get(1), chars);
                    flag = true;
                }
            }
        }
        return new String(chars);
    }

    //方法二:图算法_广度优先      34 / 36 个通过测试用例/超出内存限制
    public static String smallestStringWithSwaps2(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] e = new int[len][len];
        for (List<Integer> list : pairs) {
            e[list.get(0)][list.get(1)] = 1;
            e[list.get(1)][list.get(0)] = 1;
        }

        System.out.println("这是图===========");
        for (int i = 0; i < e.length; i++) {
            System.out.println(Arrays.toString(e[i]));
        }
        for (int i = 0; i < len; i++) {
            bfs(e, chars, i);
        }

        return new String(chars);
    }
    public static void bfs(int e[][], char v[], int v1) {
        int minV = v1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v1);
        int[] visited = new int[v.length];
        while (!queue.isEmpty()) {
            System.out.println("这是队列"+v1+"---"+queue);
            int q = queue.poll();
            //定义一个临时的visited数组

            for (int i = 0; i < v.length; i++) {
                if (e[q][i] == 1 && visited[i]==0) {//这两个点是联通的
                    queue.offer(i);//加入队列
                    visited[i]=1;
                    if (v1 < i && v[minV] > v[i]) {
                        //标记最小是这个
                        minV = i;
                        System.out.println("标记最小值为"+v[minV]);
                    }
                }
            }
        }
        //交换charV v1 i
        if (minV != v1) {
            char temp = v[v1];
            v[v1] = v[minV];
            v[minV] = temp;
        }

    }
    //方法二:图算法_深度优先
    public static String smallestStringWithSwaps3(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] e = new int[len][len];
        for (List<Integer> list : pairs) {
            e[list.get(0)][list.get(1)] = 1;
            e[list.get(1)][list.get(0)] = 1;
        }

        System.out.println("这是图===========");
        for (int i = 0; i < e.length; i++) {
            System.out.println(Arrays.toString(e[i]));
        }
        for (int i = 0; i < len; i++) {
            int[] visited = new int[chars.length];
            int minV = i;
            minV = dfs(e, chars, i, visited, i,i);
            //交换charV v1 i
            if (minV != i) {
                char temp = chars[i];
                chars[i] = chars[minV];
                chars[minV] = temp;
            }
        }

        return new String(chars);
    }

    //34 / 36 个通过测试用例 超出内存限制
    public static int dfs(int e[][], char v[], int v1,int[] visited,int minV,int dv) {//dv深度的点
            for (int i = 0; i < v.length; i++) {
                if (e[dv][i] == 1 && visited[i]==0) {//这两个点是联通的
                    visited[i]=1;
                    if (v1 < i && v[minV] > v[i]) {
                        //标记最小是这个
                        minV = i;
                        System.out.println("标记最小值为"+v[minV]);
                    }
                    minV = dfs(e,v,v1,visited,minV,i);
                }
            }

            return minV;
        }




    //方法三:并查集
    /***
     理解「交换关系具有传递性」：

     [0, 3] 和 [0, 2] 有共同索引 0 ，说明索引 0、2、3 可以任意交换；
     [1, 2] 和 [0, 2] 有共同索引 2 ，说明索引 0、1、2 可以任意交换； 因此 [0, 2] 把 [0, 3] 和 [1, 2] 中出现的索引 0、1、2、3 连在了一起。
     把可以任意交换次序的排序升序排序

     问题可以转化为下标共同连通分量 bfs dfs
     并查集
     key是代表元
     value是同属于代表元的下标集合
     并查集:合并,找代表元

     时间复杂度
     O((M+N) * a(N) + NlogN)
     空间O(N)
     交换关系是否连通,不关系如何连通的路径,可以用并查集
     */
    public static String smallestStringWithSwaps4(String s, List<List<Integer>> pairs){
        if (pairs.isEmpty()){
            return s;
        }

        //1.加入并查集
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            Integer index1 = pair.get(0);
            Integer index2 = pair.get(1);
            unionFind.union(index1,index2);
        }

        //2.构建映射关系
        char[] charArray = s.toCharArray();
        Map<Integer,PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);//找代表元
            if (hashMap.containsKey(root)){
                hashMap.get(root).offer(charArray[i]);
            }else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(charArray[i]);
                hashMap.put(root,minHeap);
            }
        }

        //3.重组字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }

        return stringBuilder.toString();
    }
    private static class UnionFind{
        private int[] parent;
        //以i为节点的子树的高度,引入了路径压缩以后这个定义并不准确
        private int[] rank; //按秩压缩 ---算法导论第三章
        public UnionFind(int n){
            this.parent = new int[n];
            this.rank=new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i]=i;//自己指向自己
                this.rank[i]=i;
            }
        }

        public void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if (rootX==rootY){
                return;
            }

            if (rank[rootX]==rank[rootY]){
                parent[rootX]=rootY;
                //此时rootX根节点的树的高度仅加了1
                rank[rootY]+=1;
            }else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
                //此时rootY为根节点的树的高度不变
            }else {
                //同理,此时以rootX为根节点的树的高度不变
                parent[rootY]=rootX;
            }
        }

        public int find(int x){ //路径压缩
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
