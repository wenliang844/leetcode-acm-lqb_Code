package ACM.每日一题leecode.day100;

import java.util.LinkedList;
import java.util.Queue;

public class day110_938二叉搜索树的范围和 {
    //返回二叉树[low,high]的范围和
    public static void main(String[] args) {
        System.out.println(rangeSumBST(new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18))), 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        //进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            if (temp.val>=low && temp.val<=high){
                sum+=temp.val;
            }
        }

        return sum;

    }
}
