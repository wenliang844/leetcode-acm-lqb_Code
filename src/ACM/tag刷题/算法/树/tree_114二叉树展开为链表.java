package ACM.tag刷题.算法.树;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class tree_114二叉树展开为链表 {

    /***
     给你二叉树的根结点 root ，请你将它展开为一个单链表：

     展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     展开后的单链表应该与二叉树 先序遍历 顺序相同。

     输入：root = [1,2,5,3,4,null,6]
     输出：[1,null,2,null,3,null,4,null,5,null,6]
     */

    //方法一:先序遍历一个stack一个cur cur!=null:cur=cur.left;else:cur=stack.pop.right
    public static void flatten(TreeNode root) {
        //System.out.println(root);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode newRoot = new TreeNode();
        TreeNode p1 = new TreeNode();
        p1 = newRoot;
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){
                TreeNode tmp = new TreeNode();
                tmp.val = cur.val;
                p1.right = tmp;
                p1=p1.right;
                stack.push(cur);
                cur=cur.left;
            }else {
                cur=stack.pop().right;
            }
        }
        root = newRoot.right;

        //System.out.println(newRoot.right);
       //System.out.println(root);
    }

    //方法二,stack存右子树,把右子树进栈,让右子树=left,cur = cur.right; 非空的话,继续右子树进栈,右=左, 41 26
    public static void flatten2(TreeNode root) {
        //System.out.println(root);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode perCur = new TreeNode();//作为cur的父节点
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){
                if (cur.right!=null){
                    stack.push(cur.right);
                }
                cur.right = cur.left;
                cur.left=null;
                perCur = cur;
                cur = cur.right;
            }else {
                perCur.right = stack.pop();
                cur=perCur.right;
            }
        }


       System.out.println(root);
    }

    public static void main(String[] args) {
        flatten2(new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,null,new TreeNode(6))));
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
