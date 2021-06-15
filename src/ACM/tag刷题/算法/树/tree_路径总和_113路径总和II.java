package ACM.tag刷题.算法.树;

import java.util.ArrayList;
import java.util.List;

public class tree_路径总和_113路径总和II {

    //方法一,递归   100 44
    //网络方法 用sum不断的去减节点的值,其实是一样的
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<List<Integer>>();//case113
        //if (root.left == null && root.right == null) return root.val == targetSum;
        List<List<Integer>> lists = new ArrayList<>();
        return searchTarget(root, 0, targetSum, lists, new ArrayList<>());
    }

    public static List<List<Integer>> searchTarget(TreeNode root, int sum, int target, List<List<Integer>> lists, List<Integer> list) {
        sum += root.val;
        list.add(root.val);
        System.out.println(root.val + "这是树===" + sum);
        if (sum == target && root.left == null && root.right == null) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            lists.add(newList);
            //list.clear();
            list.remove(list.size()-1);
            return lists;
        } else {
            if (root.left != null) searchTarget(root.left, sum, target, lists, list);
            if (root.right != null) searchTarget(root.right, sum, target, lists, list);
        }
        list.remove(list.size()-1);
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(pathSum(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(0, new TreeNode(6), new TreeNode(6))), 7));
    }

    // Definition for a binary tree node.
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
