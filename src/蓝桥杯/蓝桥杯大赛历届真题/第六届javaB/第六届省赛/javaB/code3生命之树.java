package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.javaB;

public class code3生命之树 {
    /****
     状态转移方程是：dp [ i ] [ 1 ] = sum(max(dp[ j ][ 1 ] , dp[ j ][ 0 ]));  j 是 i 的孩子结点 。

            dp[ i ][ 0 ] = 0;

        由于题目中给出的是无根树，所以在进行DFS的时候要进行标记，当要搜索的结点的孩子结点都曾经被访问过，那么他就是叶节点。也是就递归的边界(停止该分支的搜索)。

     给出n棵树 和n-1条边,求最大和
     5
     1 -2 -3 4 5
     4 2
     3 1
     1 2
     2 5
     */
    public static void dfs(){

    }
    public static void main(String[] args) {
        //动态规划:树形DP


    }
}
