package ACM.每日一题leecode.day01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class day22_103二叉树的锯齿形层序遍历 {

    
      //Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    
    public static void main(String[] args) {

          TreeNode treeNode1 = new TreeNode(3);
          TreeNode treeNode2 = new TreeNode(9);
          TreeNode treeNode3 = new TreeNode(20);
          TreeNode treeNode4 = new TreeNode(15);
          TreeNode treeNode5 = new TreeNode(7);
          TreeNode treeNode6 = new TreeNode(33);
          TreeNode treeNode7 = new TreeNode(44);
          treeNode1.left=treeNode2;
          treeNode1.right=treeNode3;
          treeNode3.left=treeNode4;
          treeNode3.right=treeNode5;

          treeNode2.left=treeNode6;
          treeNode6.left=treeNode7;
        System.out.println(zigzagLevelOrder(treeNode1));
        System.out.println(zigzagLevelOrder(null));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        listList = levelTraversal(root);


        return listList;
    }

    public static List<List<Integer>> levelTraversal(TreeNode root){
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if (root==null){
            return listList;
        }
        /*if (root == null)
            return;*/
          /*
          队列实现层序遍历
            +queue.poll()
            queue.offer("a");
           */
            /*
            因为上面每次都是从左边开始打印，但这题要求的是先从左边，
            下一层从右边，在下一次从左边……左右交替的。我们可以使用
            一个变量leftToRight，如果是true就表示从左边开始打印，
            否则就从右边开始打印，只需要把上面代码修改下即可，来看下
                1.统计一层有多少个节点；---》queue.size
                2.把这层的节点pop   list装值   用一个left控制左还是右   初始为true   每次反转一下为false
                3.queue为空了，退出
             */
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean left = true;
        while (!queue.isEmpty()){

            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();


            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val);
                if (left){
                    list.add(node.val);
                }else {
                    list.add(0,node.val);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }

            left=!left;
            listList.add(list);

        }


        return listList;
    }
    /*
2，DFS打印
这题除了使用BFS以外，还可以使用DFS，也可以参照373，数据结构-6,树中二叉树的BFS遍历的递归解法，稍作修改。但这里要有个判断，如果走到下一层的时候集合没有创建，要先创建下一层的集合，代码也很简单，我们来看下。


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null)
            return;
        //如果res.size() <= level说明下一层的集合还没创建，所以要先创建下一层的集合
        if (res.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }
        //遍历到第几层我们就操作第几层的数据
        List<Integer> list = res.get(level);
        //这里默认根节点是第0层，偶数层相当于从左往右遍历，
        // 所以要添加到集合的末尾，如果是奇数层相当于从右往左遍历，
        // 要把数据添加到集合的开头
        if (level % 2 == 0)
            list.add(cur.val);
        else
            list.add(0, cur.val);
        //分别遍历左右两个子节点，到下一层了，所以层数要加1
        travel(cur.left, res, level + 1);
        travel(cur.right, res, level + 1);
    }

作者：sdwwld
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/bfshe-dfsliang-chong-jie-jue-fang-shi-by-184y/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
}
