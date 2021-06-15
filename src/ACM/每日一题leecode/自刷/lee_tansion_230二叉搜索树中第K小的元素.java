package ACM.每日一题leecode.自刷;

import java.util.*;

public class lee_tansion_230二叉搜索树中第K小的元素 {
    /***
     给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     输入：root = [3,1,4,null,2], k = 1
     输出：1

     输入：root = [5,3,6,2,4,null,null,1], k = 3
     输出：3
     */
    //方法一:转成二叉树的前序遍历 左中右,是有序的,取第k个即可 5 12
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        //前序遍历
        Stack<TreeNode> queue = new Stack<>();
        //queue.add(root);

        TreeNode cur = root;
        while (cur != null || !queue.isEmpty()) {
            if (cur != null) {
                queue.add(cur);
                cur = cur.left;
            } else {
                cur = queue.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        //System.out.println(list);
        return list.get(k-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println(kthSmallest(root, 1));
    }

}
