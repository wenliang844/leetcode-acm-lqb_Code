package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/15 17:25
 */
public class day22_108将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    //暴力   边界问题
    public static TreeNode sortedArrayToBST(int[] nums) {

        return setHead(nums, 0, nums.length);
    }

    private static TreeNode setHead(int[] nums, int left, int right) {
        TreeNode head = new TreeNode(nums[(right - left) / 2]);
        // head.left = new TreeNode(nums[(right-left)/2]);
        if (left+1 < (right - left) / 2) {
            head.left = setHead(nums, left, (right - left) / 2);
        }
        if ((right - left) / 2 < right-1) {
            head.right = setHead(nums, (right - left) / 2, right);
        }
        return head;
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
