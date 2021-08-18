package ACM.每日一题leecode.day141;

import java.util.List;

public class day183_987二叉树的垂序遍历 {
    /****
     给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
     对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
     二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
     返回二叉树的 垂序遍历 序列。
     */
    // Definition for a binary tree node.
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

    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int deep = 3;//getDeep(root);
        int grid[][] = new int[deep][deep*2];

        return null;
    }


}
