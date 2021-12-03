package ACM.tag刷题.算法.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree路径总和_437路径总和III {

    /***
     给定一个二叉树，它的每个结点都存放着一个整数值。
     找出路径和等于给定数值的路径总数。
     路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     10
     /  \
     5   -3
     / \    \
     3   2   11
     / \   \
     3  -2   1
     返回 3。和等于 8 的路径有:
     1.  5 -> 3
     2.  5 -> 2 -> 1
     3.  -3 -> 11
     */

    //方法一,递归 每个节点都去尝试   63 70|54 70
    public static int pathSum(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
           System.out.println("--------------"+temp.val+"---------------------");
            count += searchTarget(temp,0,sum,0);
            if (temp.left!=null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
        }

        return count;
    }

    public static int searchTarget(TreeNode root, int sum, int target, int count) {
        sum += root.val;
        System.out.println(root.val + "这是树===" + sum);
        if (sum == target) {
           count++;
           //return count; //116case不通过
        }
        //else {
            if (root.left != null) count = searchTarget(root.left, sum, target,count);
            if (root.right != null) count = searchTarget(root.right, sum, target, count);
        //}
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(pathSum(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(0, new TreeNode(6), new TreeNode(6))), 7));
//        [1,-2,-3,1,3,-2,null,-1] -1
        System.out.println(pathSum(new TreeNode(1,new TreeNode(-2,new TreeNode(1,new TreeNode(-1),null),new TreeNode(3)),new TreeNode(-3,new TreeNode(-2),null)),-1));
    }

    // Definition for a binary tree node.
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
