package ACM.tag刷题.数据结构.栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class stack_94二叉树的中序遍历 {

    public static void treePrint(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            treePrint(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            treePrint(root.right, list);
        }
    }

    //方法一:递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        treePrint(root, list);
        //System.out.println(list);
        return list;
    }

    //方法二:栈

    /**
     1.一直向left找到底,直到left = null
     cur = stack.top;
     cur = cur.right //看看右边有没有
        右边没有就会自动cur = stack.top  上上层了
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = new TreeNode();
        cur = root;
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){//不为空就左走,
                stack.add(cur);
                cur = cur.left;
            }else {//当cur==null 也就是到了stack.top要打印,的最左边的节点
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;//右走还空,就一直右走
            }
        }

        return list;

    }

    public static void main(String[] args) {
        System.out.println(inorderTraversal2(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)))));
        System.out.println(inorderTraversal2(new TreeNode()));
    }


    //Definition for a binary tree node.
    public static class TreeNode {
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
    }

}
