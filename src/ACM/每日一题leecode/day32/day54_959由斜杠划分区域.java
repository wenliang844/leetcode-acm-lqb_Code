package ACM.每日一题leecode.day32;

public class day54_959由斜杠划分区域 {
    /***
     在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。

     （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。

     返回区域的数目。


     示例 1：

     输入：
     [
       " /",
       "/ "
     ]
     输出：2
     解释：2x2 网格如下：

     示例 2：

     输入：
     [
       " /",
       "  "
     ]
     输出：1
     解释：2x2 网格如下：
     */

    public static void test1() {
        //测试 ++i + ++i的值
        int i = 1;
        int n = (++i) + (++i);
        System.out.println(n);
    }

    public static void main(String[] args) {
        test1();

    }

    //加哨兵 线条和前面的,上面的   上左  上中  上右进行比较的结果
    public int regionsBySlashes(String[] grid) {

        //1.在每个grid中前面加入

        return 0;
    }

    //2.并查集:相当于分成4个点
    public int regionsBySlashes2(String[] grid) {
        int N=grid.length;
        int size = 4*N*N;

        //1.
        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                //二维网格转换为一维表格
                int index = 4 * (i*N+j);
                char c = row[j];
                if (c=='/'){
                    //合并0.3 1.2
                    uf.union(index,index+3);
                    uf.union(index+1,index+2);
                }else if (c=='\\'){
                    //合并0.1 2.3
                    uf.union(index,index+1);
                    uf.union(index+2,index+3);
                }else {
                    //合并所有
                    uf.union(index,index+1);
                    uf.union(index+1,index+2);
                    uf.union(index+2,index+3);
                }

                //单元格合并
                //向右合并1当前  3右一列
                if (j+1<N){
                    uf.union(index+1,4*(i*N+j+1)+3);
                }
                if (i+1<N){
                    uf.union(index+2,4*((i+1)*N+j));
                }
            }
        }

        return uf.getCount();
    }

    class UnionFind{
        private int[] parent;
        private  int count;
        public int getCount(){
            return count;
        }

        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
            }
        }

        public int find(int x){
            while (x!=parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x,int y){
            int rootx = find(x);
            int rooty=find(y);
            if (rootx==rooty){
                return;
            }
            parent[rootx] = rooty;
            count--;
        }
    }
}
