package ACM.tag刷题.算法.树;

import java.util.LinkedList;
import java.util.Queue;

public class tree_101对称二叉树 {

    /***
     给定一个二叉树，检查它是否是镜像对称的。
     例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     */

    //方法一 leftQ先放左 rightQ先放右,层序遍历,有一个不相等就return false   28 19
    public static boolean isSymmetric(TreeNode root) {
        //定义两个Queue
        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();

        if (root.left!=null){
            leftQ.add(root.left);
        }
        if (root.right!=null){
            rightQ.add(root.right);
        }
        if (leftQ.size() != rightQ.size()){
            return false;
        }
        while (!leftQ.isEmpty() && !rightQ.isEmpty()) {
            //比较栈中的元素
            TreeNode left = leftQ.poll();
            TreeNode right = rightQ.poll();
            if (left.val != right.val) {//两个节点的值不相等,直接false
                return false;
            }

            //思考题:如何精简判断?这里有8 个判断了
            if (left.left != null) {
                //如果这时候right的右边空了,直接false退出
                if (right.right == null) return false;
                leftQ.add(left.left);
            }
            if (left.right != null) {
                if (right.left==null)return false;
                leftQ.add(left.right);
            }
            if (right.right != null) {
                if (left.left==null)return false;
                rightQ.add(right.right);
            }
            if (right.left != null) {
                if (left.right==null)return false;
                rightQ.add(right.left);
            }

        }

        //如果两个栈中都空了,才true
        if (leftQ.isEmpty() && rightQ.isEmpty()) {
            return true;
        } else {
            return false;
        }


    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(1, new TreeNode(4), new TreeNode(3)))));
        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)))));
        System.out.println(isSymmetric(new TreeNode(1,new TreeNode(0),null)));
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
