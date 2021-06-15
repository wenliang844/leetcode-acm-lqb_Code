package ACM.tag刷题.算法.树;

public class tree_226翻转二叉树 {

    /***
     翻转一棵二叉树。

     示例：

     输入：

     4
     /   \
     2     7
     / \   / \
     1   3 6   9
     输出：

     4
     /   \
     7     2
     / \   / \
     9   6 3   1
     */
    //100 33
    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left!=null){
            invertTree(root.left);
        }if (root.right!=null){
            invertTree(root.right);
        }
        return root;
    }
    public static void main(String[] args) {
        //System.out.println(maxPathSum(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        System.out.println(invertTree(new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        //System.out.println(maxPathSum(new TreeNode(-3)));
        //System.out.println(maxPathSum(new TreeNode(-2,new TreeNode(-1),null)));
        //System.out.println(maxPathSum(new TreeNode(0,new TreeNode(1),new TreeNode(1))));
        //System.out.println(maxPathSum(new TreeNode(-1,new TreeNode(8,null,new TreeNode(-9,new TreeNode(-3,null,new TreeNode(2)),null)),new TreeNode(2,new TreeNode(0,null,new TreeNode(-9)),null))));

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
