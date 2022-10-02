package ACM.每日一题leecode.day237;

import java.util.*;

public class day259_653两数之和IV输入BST {
    public static void main(String[] args) {

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

    //map解决 一趟遍历 5|15
    public static boolean findTarget(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (list.contains(k-pop.val)){
                return true;
            }
            list.add(pop.val);
            if (pop.left!=null){
                stack.add(pop.left);
            }
            if (pop.right!=null){
                stack.add(pop.right);
            }
        }
        return false;
    }



}
