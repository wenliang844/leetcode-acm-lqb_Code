package ACM.tag刷题.算法.树;

public class tree_98验证二叉搜索树 {

    /*
     给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     假设一个二叉搜索树具有如下特征：
     节点的左子树只包含小于当前节点的数。
     节点的右子树只包含大于当前节点的数。
     所有左子树和右子树自身必须也是二叉搜索树。*/

    //方法一:递归
    public static boolean searchLeft(TreeNode leftRoot,int med){//leftRoot需要全部小于med
        if (leftRoot.val>=med){
            return false;
        }
        boolean flag = true;
        if (leftRoot.left!=null){
            flag = searchLeft(leftRoot.left,med);
        }
        if (!flag)return flag;
        if (leftRoot.right!=null){
            return searchLeft(leftRoot.right,med);
        }

        //return false;
        return true;
    }public static boolean searchRight(TreeNode rightRoot,int med){//rightRoot需要全部小于med
        if (rightRoot.val<=med){
            return false;
        }
        boolean flag = true;
        if (rightRoot.left!=null){
            flag = searchRight(rightRoot.left,med);
        }
        if (!flag)return flag;
        if (rightRoot.right!=null){
            return searchRight(rightRoot.right,med);
        }

        //return false;
        return true;
    }

    //root先向左搜索 全部要小于root.val
    public static boolean isBFS(TreeNode root) {
        boolean flag = true;
        //boolean flag = true;
        if (root.left != null) {
            /*if (root.left.val >= root.val) {
                return false;
            }
            flag = isValidBST(root.left);*/
           flag = searchLeft(root.left,root.val) && isBFS(root.left);//searchLeft需要检查左边全部满足
        }
        if (flag == false)return false;
        if (root.right != null) {
           /* if (root.right.val <= root.val) {
                return false;
            }
            flag = isValidBST(root.right);*/
           flag = searchRight(root.right,root.val) && isBFS(root.right);
        }

        return flag;
    }

    //方法一:递归搜索
    public static boolean isValidBST(TreeNode root) {

        return isBFS(root);
    }

    /***
     官方
     class Solution {
     public boolean isValidBST(TreeNode root) {
     return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
     }

     public boolean isValidBST(TreeNode node, long lower, long upper) {
     if (node == null) {
     return true;
     }
     if (node.val <= lower || node.val >= upper) {
     return false;
     }
     return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
     }
     }
     */

    /***
     方法二:中序遍历: 一定是升序的,不是升序,则不是排序二叉树
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
       /* System.out.println(isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
        System.out.println(isValidBST(new TreeNode(5,new TreeNode(4),new TreeNode(6,new TreeNode(3),new TreeNode(7)))));
        System.out.println(isValidBST(new TreeNode(2,new TreeNode(1),new TreeNode(3))));*/
        System.out.println(isValidBST(new TreeNode(3,new TreeNode(1,new TreeNode(0),new TreeNode(2,null,new TreeNode(3))),new TreeNode(5,new TreeNode(4),new TreeNode(6)))));
    }
}


//Definition for a binary tree node.
class TreeNode {
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
