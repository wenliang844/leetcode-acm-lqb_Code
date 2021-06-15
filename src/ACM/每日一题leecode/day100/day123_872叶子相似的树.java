package ACM.每日一题leecode.day100;

import java.util.*;

public class day123_872叶子相似的树 {
    public static void main(String[] args) {
        System.out.println(leafSimilar(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(leafSimilar(new TreeNode(1, new TreeNode(3, new TreeNode(8), new TreeNode(7)), new TreeNode(2)), new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(leafSimilar(new TreeNode(1, new TreeNode(2), null), new TreeNode(2, new TreeNode(2), null)));
    }

    //叶子序列相同,就是相似的
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //先序遍历:中左右
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        //一个一个找,一个一个匹配
        TreeNode cur1 = root1;
        TreeNode cur2 = root2;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        //层序遍历有可能序列的顺序不一样,排个序,排序会将序列不一样的搞进来,还是要用先序遍历 中左右
        while (cur1 != null || !stack1.isEmpty()) {
            if (cur1.left == null && cur1.right == null) {
                list1.add(cur1.val);
            }
            stack1.add(cur1);
            if (cur1.left != null) {
                cur1 = cur1.left;
            } else {
                cur1 = stack1.pop();
                if (cur1.right != null) {
                    cur1 = cur1.right;
                } else {
                    break;
                }
            }

        }
        while (cur2 != null || !stack2.isEmpty()) {
            if (cur2.left == null && cur2.right == null) {
                list2.add(cur2.val);
            }
            stack2.add(cur2);
            if (cur2.left != null) {
                cur2 = cur2.left;
            } else {
                cur2 = stack2.pop();
                if (cur2.right != null) {
                    cur2 = cur2.right;
                } else {
                    break;
                }
            }

        }

        //System.out.println(list1);
        //System.out.println(list2);
        //Collections.sort(list1);
        //Collections.sort(list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }

        return true;
    }

    //深度优先搜索 100/92
    public static boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        //先序遍历:中左右
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        //一个一个找,一个一个匹配
        TreeNode cur1 = root1;
        TreeNode cur2 = root2;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1,list1);
        dfs(root2,list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }

        return true;
    }

    public static void dfs(TreeNode root,List<Integer> list){
        if (root.left==null && root.right==null){
            list.add(root.val);
        }else {
        if (root.left!=null){
            dfs(root.left,list);
        }
        if (root.right!=null){
            dfs(root.right,list);
        }
        }
    }
}
