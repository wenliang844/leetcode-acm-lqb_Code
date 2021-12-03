package ACM.每日一题leecode.day185;

public class day213_437路径总和III {


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(pathSum(tree, 8));
    }


    /****
     方法一:滑动窗口 ×
     方法二:双重递归,第一个递归找每一个节点   第二个递归以这个节点为根节点进行sum加和
     */
    //private static int sum;
    static int count;

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            count++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
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
