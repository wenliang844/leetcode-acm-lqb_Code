package ACM.tag刷题.算法.树;

import java.util.*;

public class tree_538_1038把二叉搜索树转换为累加树 {
    /***
     给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

     提醒一下，二叉搜索树满足下列约束条件：

     节点的左子树仅包含键 小于 节点键的节点。
     节点的右子树仅包含键 大于 节点键的节点。
     左右子树也必须是二叉搜索树。
     */

    //理解错误题目的意思,是左加右减
    public static int translateTree0(TreeNode root) {
        if (root == null) return 0;
        root.val = translateTree0(root.left) + translateTree0(root.right) + root.val;
        return root.val;
    }

    public static TreeNode convertBST0(TreeNode root) {
        //System.out.println(root);
        translateTree0(root);
        return root;
    }


    //左加右减 1.中序遍历2.后缀和   10 74          100 68
    public static TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //1.中序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        //System.out.println(list);
        //2.list的后缀和
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            list.set(i, sum);
        }

        //System.out.println(list);
        //3.中序遍历赋值
        int i = 0;
        //Stack<TreeNode> stack = new Stack<>();
        cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur.val = list.get(i);
                i++;
                cur = cur.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //System.out.println(convertBST(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(0, new TreeNode(6), new TreeNode(6)))));
        System.out.println(convertBST(new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))))));
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
