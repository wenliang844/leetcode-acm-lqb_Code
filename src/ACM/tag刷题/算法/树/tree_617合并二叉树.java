package ACM.tag刷题.算法.树;

public class tree_617合并二叉树 {

    /***
     给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

     你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

     示例 1:

     输入:
     Tree 1                     Tree 2
     1                         2
     / \                       / \
     3   2                     1   3
     /                           \   \
     5                             4   7
     输出:
     合并后的树:
     3
     / \
     4   5
     / \   \
     5   4   7
     */
    //41 96
    public static void merge(TreeNode root1,TreeNode root2){
        //情况一,这个节点都有:直接相加
        //case2:节点1有2没有,不动,return
        //case3:节点1没有2有,新建一个节点,作为1的节点
        if(root1==null || root2==null)return;
        if (root1.left!=null){
            root1.left.val += root2.left==null?0:root2.left.val;
        }else{
            if (root2.left!=null){
                root1.left = new TreeNode(root2.left.val);
            }
        }
        if (root1.right!=null){
            root1.right.val += root2.right==null?0:root2.right.val;
        }else{
            if (root2.right!=null){
                root1.right = new TreeNode(root2.right.val);
            }
        }

        merge(root1.left,root2.left);
        merge(root1.right,root2.right);
    }
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1==null)return root2;
        else if (root2==null)return root1;
        else {
            root1.val+=root2.val;
            merge(root1,root2);
        }
        return root1;
    }

    public static void main(String[] args) {
        System.out.println(mergeTrees(new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2)), new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)))));

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
