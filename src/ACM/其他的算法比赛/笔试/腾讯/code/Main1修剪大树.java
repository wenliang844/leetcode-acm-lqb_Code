package ACM.其他的算法比赛.笔试.腾讯.code;

import sun.reflect.generics.tree.Tree;

public class Main1修剪大树 {
    /***
     删除最少的叶子,-->完全二叉树{要么无子节点,要么两个子节点,一个子节点的去掉即可}
     * @param root
     * @return
     */
    public static TreeNode solve(TreeNode root) {
        // write code here
        System.out.println(root);
        if (root.left != null && root.right != null) {
            solve(root.left);
            solve(root.right);
        } else if (root.left == null && root.right != null) {
            root.right = null;
        } else if (root.left != null && root.right == null) {
            root.left = null;
        }

        return root;
    }

    public static void main(String[] args) {
        System.out.println(solve(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null))));
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode() {
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int val) {
            this.val = val;
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
