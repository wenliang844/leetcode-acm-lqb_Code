package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/4/19 11:44
 */
public class day42_1026节点与其祖先之间的最大差值 {

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

    public static void main(String[] args) {

        System.out.println(maxAncestorDiff(new TreeNode(1, new TreeNode(2, new TreeNode(0, new TreeNode(3), null), null), null)));
        System.out.println(maxAncestorDiff(new TreeNode(8,new TreeNode(3,new TreeNode(1),new TreeNode(6,new TreeNode(4),new TreeNode(7))),new TreeNode(10,null,new TreeNode(14,new TreeNode(13),null)))));
    }

    /**
     * 方法：
     * 从root开始，每次向下遍历每一个节点   维持当前最大值，最小值，最大差值
     *
     * @param root
     * @return
     */
    public static int maxAncestorDiff(TreeNode root) {
        int[] res = new int[1];
        int maxValue = root.val;
        int minValue = root.val;
        res[0] = 0;
        dfs(root, maxValue, minValue, res);

        return res[0];
    }

    public static void dfs(TreeNode root, int maxValue, int minValue, int[] res) {
        res[0] = Math.max(res[0], Math.max(Math.abs(root.val - maxValue), Math.abs(root.val - minValue)));
        maxValue = Math.max(root.val, maxValue);
        minValue = Math.min(root.val, minValue);
        if (root.left != null) {
            dfs(root.left, maxValue, minValue, res);
        }
        if (root.right != null) {
            dfs(root.right, maxValue, minValue, res);
        }
    }
}
