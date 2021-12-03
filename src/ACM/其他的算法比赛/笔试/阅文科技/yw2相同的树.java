package ACM.其他的算法比赛.笔试.阅文科技;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class yw2相同的树 {

    public static void main(String[] args) {

        System.out.println(isSameTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3)), new TreeNode(1)));
    }

    //层序遍历相同   前序遍历相同
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // write code here
        List<Integer> list1 = inorderTraversal2(p);
        List<Integer> list2 = inorderTraversal2(q);
        if (list1.size()!=list2.size())return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = new TreeNode(0);
        cur = root;
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){//不为空就左走,
                stack.add(cur);
                cur = cur.left;
            }else {//当cur==null 也就是到了stack.top要打印,的最左边的节点
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;//右走还空,就一直右走
            }
        }

        return list;

    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
