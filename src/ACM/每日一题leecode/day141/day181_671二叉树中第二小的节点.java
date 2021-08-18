package ACM.每日一题leecode.day141;

import java.util.*;

public class day181_671二叉树中第二小的节点 {


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

    /**
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
     * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
     * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     */
    public static void main(String[] args) {
        System.out.println(findSecondMinimumValue(new TreeNode(2,new TreeNode(2),new TreeNode(5,new TreeNode(5),new TreeNode(7)))));
    }

    //朴素做法:直接遍历,sort,取第二个值---18/15
    public static int findSecondMinimumValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left!=null){
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        Collections.sort(list);
        //System.out.println(list);
        int target = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)!=target){
                return list.get(i);
            }
        }
        return -1;
    }

    //
    public static int findSecondMinimumValue2(TreeNode root) {
        return myfun(root,root.val);
    }

    private static int myfun(TreeNode root, int val) {
        if (root==null){
            return -1;
        }
        if (root.val > val){
            return root.val;
        }
        int l = myfun(root.left,val);
        int r = myfun(root.right,val);
        if (l>val && r>val){
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }


}
