package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class day58_449序列化和反序列化二叉搜索树 {

    public static void main(String[] args) {
        TreeNode head = deserialize("4251306");
        System.out.println(head);
        System.out.println(serialize(head));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.poll();
            if (node.val == 0){
                sb.append(node.val);
                continue;
            }
            if (node.left==null && node.right==null){
                sb.append(node.val);
                continue;
            }
            if (node.left !=null) {
                stack.add(node.left);
            }else {
                stack.add(new TreeNode(0));
            }
            if (node.right !=null) {
                stack.add(node.right);
            }else {
                stack.add(new TreeNode(0));
            }
            sb.append(node.val);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        TreeNode head = new TreeNode(data.charAt(0) - '0');
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(head);
        for (int i = 1; i < data.length(); i+=2) {
            TreeNode node = stack.poll();
            if (data.charAt(i) != '0'){
                TreeNode left = new TreeNode(data.charAt(i) - '0');
                node.left = left;
                stack.add(left);
            }
            if (data.charAt(i+1) != '0'){
                TreeNode right = new TreeNode(data.charAt(i+1) - '0');
                node.right=right;
                stack.add(right);
            }

        }
        return head;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        public int getVal() {
            return val;
        }
    }
}
