package ACM.tag刷题.算法.树;

import sun.reflect.generics.tree.Tree;

public class tree_124二叉树中的最大路径和 {

    /***
     路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     路径和 是路径中各节点值的总和。
     给你一个二叉树的根节点 root ，返回其 最大路径和 。
     <p>
     输入：root = [1,2,3]
     输出：6
     解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
     */

    //100 60
    public static int maxPath(TreeNode root, int max) {
        if (root.left==null && root.right==null){
            return root.val;
        }
        int sum = Integer.MIN_VALUE;
        //if (root.val >= 0){
            //sum = root.val;
        //}else {
            sum = root.val;
        //}
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        max = Math.max(sum, max);
        if (root.left == null && root.right == null) {//更新root.val的值
            root.val = root.val > 0 ? root.val : 0;
        } else if (root.left == null) {
            rightMax = maxPath(root.right, max);
            root.val = Math.max(root.val, root.val + (root.right.val > 0 ? root.right.val : 0));
            if (root.right.val > 0) sum += root.right.val;
        } else if (root.right == null) {
            leftMax = maxPath(root.left, max);
            root.val = Math.max(root.val, root.val + (root.left.val > 0 ? root.left.val : 0));
            if (root.left.val > 0) sum += root.left.val;
        } else {
            leftMax = maxPath(root.left, max);//这里返回的要接收并比较和max
            rightMax = maxPath(root.right, max);
            if (root.val + root.right.val >= 0)
                if (root.right.val > 0) sum += root.right.val;
            if (root.val + root.left.val >= 0)
                if (root.left.val > 0) sum += root.left.val;
            root.val = Math.max(root.val, root.val + Math.max(root.left.val, root.right.val));
        }

        max = Math.max(Math.max(max, sum),Math.max(leftMax,rightMax));
        return max;
    }

    public static int maxPathSum(TreeNode root) {
        //int max1 = maxPath(root.left,0);
        //int max2 = maxPath(root.right,0);
        int max = maxPath(root, root.val);
        //System.out.println(max);
        //System.out.println(root);
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(maxPathSum(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        //System.out.println(maxPathSum(new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        //System.out.println(maxPathSum(new TreeNode(-3)));
        //System.out.println(maxPathSum(new TreeNode(-2,new TreeNode(-1),null)));
        //System.out.println(maxPathSum(new TreeNode(0,new TreeNode(1),new TreeNode(1))));
        System.out.println(maxPathSum(new TreeNode(-1,new TreeNode(8,null,new TreeNode(-9,new TreeNode(-3,null,new TreeNode(2)),null)),new TreeNode(2,new TreeNode(0,null,new TreeNode(-9)),null))));
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
