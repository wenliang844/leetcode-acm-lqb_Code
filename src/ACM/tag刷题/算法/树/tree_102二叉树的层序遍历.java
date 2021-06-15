package ACM.tag刷题.算法.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class tree_102二叉树的层序遍历 {

    /***
     给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     示例：
     二叉树：[3,9,20,null,null,15,7],
     */


    //方法1:对列   10 68
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null){
            queue.add(root);
        }
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (queue.size()>0){
            TreeNode p = new TreeNode();
            p = queue.poll();
            list.add(p.val);
            if (p.left!=null){
                tmp.add(p.left);
            }
            if (p.right!=null){
                tmp.add(p.right);
            }

            if (queue.isEmpty()){
                //利用一个临时链表深度复制list,list再清空,lists加入的是临时表
                List<Integer> tmpList = new ArrayList<>();
                tmpList.addAll(list);
                lists.add(tmpList);
                list.clear();
                //queue = tmp;
                //将tmp中的treenode加入queue
                while (!tmp.isEmpty()){
                    queue.add(tmp.poll());
                }
                //tmp.clear();
            }

        }


        return lists;
    }

    public static void main(String[] args) {
        System.out.println(levelOrder(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
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


//Definition for a binary tree node.
