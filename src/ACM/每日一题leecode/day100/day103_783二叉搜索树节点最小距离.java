package ACM.每日一题leecode.day100;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class day103_783二叉搜索树节点最小距离 {
    /****
     给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     */
    //方法一:中序遍历  5  22
    public static int minDiffInBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        //前序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){
                stack.add(cur);
                cur=cur.left;
            }else {
                cur=stack.pop();
                list.add(cur.val);//其实可以在这里直接处理最小差值,保存上一个的值即可
                cur=cur.right;
            }
        }
        System.out.println(list);
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list.size()-1; i++) {
            minSum = Math.min(minSum,list.get(i+1)-list.get(i));
        }
        return minSum;

    }

    public static void main(String[] args) {
        System.out.println(minDiffInBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))));
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
