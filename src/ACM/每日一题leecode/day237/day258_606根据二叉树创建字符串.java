package ACM.每日一题leecode.day237;

import java.util.Stack;

public class day258_606根据二叉树创建字符串 {
    public static void main(String[] args) {

        System.out.println(tree2str(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))));
    }

    //前序遍历
    //递归解决

    public static String tree2str(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }

    public static void dfs(TreeNode root,StringBuilder res){
        res.append(root.val);
        if (root.left!=null){
            res.append("(");
            dfs(root.left,res);
            res.append(")");

        }
        if (root.right!=null){
            if (root.left==null){
                res.append("()");
            }
            res.append("(");
            dfs(root.right,res);
            res.append(")");
        }
    }

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
