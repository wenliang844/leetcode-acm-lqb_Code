package ACM.tag刷题.算法.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree_104二叉树的最大深度 {

    /***
     给定一个二叉树，找出其最大深度。
     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     说明: 叶子节点是指没有子节点的节点。
     示例：
     给定二叉树 [3,9,20,null,null,15,7]，
     */

    //递归 动态规划 左右子树的最大深度
    public static int maxDepth(TreeNode root) {
        if (root!=null){
            if (root.left!=null && root.right!=null){
                return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
            }else if (root.left!=null){
                return maxDepth(root.left)+1;
            }else if (root.right!=null){
                return maxDepth(root.right)+1;
            }else {
                return 1;
            }
        }else {
            return 0;
        }


    }

    public static void main(String[] args) {
        System.out.println(maxDepth(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        System.out.println(maxDepth(null));
    }


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


//Definition for a binary tree node.
