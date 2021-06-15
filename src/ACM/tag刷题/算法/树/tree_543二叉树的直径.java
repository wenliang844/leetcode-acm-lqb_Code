package ACM.tag刷题.算法.树;

import java.util.LinkedList;
import java.util.Queue;

public class tree_543二叉树的直径 {
    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     * 示例 :
     * 给定二叉树
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     */
    public static int deepTwo(TreeNode root,int count,int max){
        //左边有子树就count++
        if (root.left!=null){
            count++;
            count = deepTwo(root.left,count,max);
        }
        //count--
        max = Math.max(count,max);
        count--;//退出左子树,开始右子树,回归
        //右边有子树就count++ 当无return
        if (root.right!=null){
            count++;
            count = deepTwo(root.right,count,max);
        }
        max = Math.max(count,max);
        return max;
    }

    //分解子问题思想 9 70
    public static int deepDp(TreeNode root){
        //左右子树的最大深度:就是max(left,right)
        if (root==null)return 0;
        return Math.max(deepDp(root.left),deepDp(root.right))+1;
    }
    public static int diameterOfBinaryTree(TreeNode root) {

        //int deep = deepTwo(root,0,0);
        //System.out.println(deep);
        //System.out.println(deepDp(root.left));
        //System.out.println(deepDp(root.right));
        Queue<TreeNode> queue = new LinkedList<>();
        int maxCount = 0;
        if (root!=null) {
            queue.add(root);
        }
        System.out.println(deepDp(root.left));
        System.out.println(deepDp(root.right));
        //TreeNode cur = root;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            maxCount = Math.max(maxCount,deepDp(temp.left)+deepDp(temp.right));
            if (temp.left!=null)queue.add(temp.left);
            if (temp.right!=null)queue.add(temp.right);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        //System.out.println(diameterOfBinaryTree(new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))))));
        System.out.println(diameterOfBinaryTree(new TreeNode(2, new TreeNode(3, new TreeNode(1),null), null)));
    }

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
