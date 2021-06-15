package ACM.每日一题leecode.day32;

import java.util.List;

/***
 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。

 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。

 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。

  

 示例 1：



 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 输出：[[0,1],[2,3,4,5]]
 解释：上图描述了给定图。
 下图是所有的最小生成树。

 注意到第 0 条边和第 1 条边出现在了所有最小生成树中，所以它们是关键边，我们将这两个下标作为输出的第一个列表。
 边 2，3，4 和 5 是所有 MST 的剩余边，所以它们是伪关键边。我们将它们作为输出的第二个列表。
 示例 2 ：



 输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
 输出：[[],[0,1,2,3]]
 解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
 ucbug
 */

/***

 * 关键边：最小生成树中删去某条边，会导致最小生成树的权值和增加
 解法：1. 该边必须出现在mst中
 2. 删除该边，重新构建mst则权值会和会改变
 注：有可能一开始给的图就是mst，即删除边后无法构建mst导致权值和反而变小
 正常情况就是该边是关键边，那么权值和会变大
 * 伪关键边：可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边
 解法：1. 可能出现在mst中
 2. 把该边一开始就加入最终生成树中，看最后权值不变则是伪关键边
 3. 且一定不是关键边
 * 求最小生成树这里用克鲁斯卡尔，判断有无环用并查集
 * 注意最后ans是在_edges的索引所以要提前存好索引以免排序就乱了

class Solution {
    vector<vector<int>> edges;
    vector<int> parent;
    public:
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& _edges) {
        edges.clear();
        int _edges_size=_edges.size();
        for (int i=0;i<_edges_size;++i)
        {
            edges.push_back(_edges.at(i));
            edges.at(i).push_back(i);
        }
        parent=vector<int>(n);
        //使用kruskal所以权值要按从小到大排序
        sort(edges.begin(),edges.end(),[](const vector<int> &A,const vector<int> &B){
            return A.at(2)<B.at(2);
        });
        //求mst的最小权值和，因为没有删除的边就一个无意义的数组
        int mst_weight_sum=kruskal(n,{-1,-1,-1});
        //求关键边
        vector<int> key_edge=get_key_edge(n,mst_weight_sum);
        //求伪关键边，且伪关键边中不能有关键边
        unordered_set<int> key_edge_set(key_edge.begin(),key_edge.end());
        vector<int> fake_key_edge=get_fake_key_edge(n,mst_weight_sum,key_edge_set);
        return {key_edge,fake_key_edge};
    }
    void initialise(int n)
    {
        for(int i=0;i<n;++i)
            parent.at(i)=i;
    }
    int find_root(int i)
    {
        if (parent.at(i)!=i)
        {
            int root=find_root(parent.at(i));
            parent.at(i)=root;
            return root;
        }
        return i;
    }
    bool union_vertices(int a,int b)
    {
        int a_root=find_root(a);
        int b_root=find_root(b);
        if (a_root==b_root)
            return false;
        parent.at(a_root)=b_root;
        return true;
    }
    int kruskal(int n,vector<int> delete_edge)
    {
        initialise(n);
        int weight_sum=0;
        int cur_size=0;
        for (vector<int> &i:edges)
        {
            if (i==delete_edge)
                continue;
            if (union_vertices(i.at(0),i.at(1)))
            {
                ++cur_size;
                weight_sum+=i.at(2);
                if (cur_size==n-1)
                    return weight_sum;
            }
        }
        return weight_sum;
    }
    vector<int> get_key_edge(int n,const int & mst_weight_sum)
    {
        vector<int> ans;
        for (vector<int> &i:edges)
        {
            int cur_weight_sum=kruskal(n,i);
            if (cur_weight_sum!=mst_weight_sum)
                ans.push_back(i.at(3));
        }
        return ans;
    }
    vector<int> get_fake_key_edge(int n,const int & mst_weight_sum,unordered_set<int> &key_edge_set)
    {
        vector<int> ans;
        for (vector<int> &i:edges)
        {
            if (key_edge_set.find(i.at(3))!=key_edge_set.end())
                continue;
            int cur_weight_sum=add_one_edge_kruskal(n,i);
            if (cur_weight_sum==mst_weight_sum)
                ans.push_back(i.at(3));
        }
        return ans;
    }
    int add_one_edge_kruskal(int n,vector<int> add_edge)
    {
        initialise(n);
        union_vertices(add_edge.at(0),add_edge.at(1));
        int weight_sum=add_edge.at(2);
        int cur_size=1;
        for (vector<int> &i:edges)
        {
            if (i==add_edge)
                continue;
            if (union_vertices(i.at(0),i.at(1)))
            {
                ++cur_size;
                weight_sum+=i.at(2);
                if (cur_size==n-1)
                    return weight_sum;
            }
        }
        return weight_sum;
    }
};
 */
public class day50_1489找到最小生成树里的关键边和伪关键边 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {


        return null;
    }
}
