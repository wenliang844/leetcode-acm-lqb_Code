package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/9/2 10:28
 */
public class day006_687最长同值路径 {

    /*
    给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。

两个节点之间的路径长度 由它们之间的边数表示。

 

示例 1:



输入：root = [5,4,5,1,1,5]
输出：2
     */


    public static void main(String[] args) {

    }

    public int longestUnivaluePath(TreeNode root) {

        return 0;
    }


    public class TreeNode {
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
