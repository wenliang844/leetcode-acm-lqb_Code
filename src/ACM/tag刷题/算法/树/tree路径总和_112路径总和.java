package ACM.tag刷题.算法.树;

import java.util.LinkedList;
import java.util.Queue;

public class tree路径总和_112路径总和 {
    public static boolean searchTarget0(TreeNode root, int sum, int target) {
        sum += root.val;
        System.out.println(root.val + "这是树===" + sum);
        if (sum == target) return true;
        else if (sum > target) return false;
        else if (root.left != null) return searchTarget(root.left, sum, target);
        else if (root.right != null) return searchTarget(root.right, sum, target);
        else return false;
    }

    //方法一:递归   从第一个节点出发,把子节点入对列  然后进行search sum=root.val sum<tar sum+=left sum+=right if(sum=tar) return
    public static boolean hasPathSum0(TreeNode root, int targetSum) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (searchTarget(tmp, 0, targetSum)) return true;
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
        }
        return false;
    }

    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     * <p>
     * 叶子节点 是指没有子节点的节点。
     */

    //方法一:递归   从第一个节点出发,把子节点入对列  然后进行search sum=root.val sum<tar sum+=left sum+=right if(sum=tar) return
    public static boolean hasPathSum01(TreeNode root, int targetSum) {

        Queue<TreeNode> queue = new LinkedList<>();
        //if (root==null)return false;
        if (root != null)
            queue.add(root);
        /*if (root.right!=null)
            queue.add(root.right);*/
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.println("执行了一次节点遍历");
            if (searchTarget(tmp, 0, targetSum)) return true;
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
        }
        return false;
    }

    public static boolean searchTarget01(TreeNode root, int sum, int target) {
        boolean flag = false;
        sum += root.val;
        System.out.println(root.val + "这是树===" + sum);
        if (sum == target && root.val != sum) return true;
        else if (sum > target) return false;
        if (root.left != null) flag = searchTarget(root.left, sum, target);
        if (root.right != null) flag = searchTarget(root.right, sum, target);
        //else return false;
        return flag;
    }

    //任意节点到任意节点
    public static boolean hasPathSum02(TreeNode root, int targetSum) {

        Queue<TreeNode> queue = new LinkedList<>();
        //if (root==null)return false;
        if (root != null)
            queue.add(root);
        else return false;
        if (root.left == null && root.right == null) return root.val == targetSum;

        //防止有root.val=0的情况,影响后面的判断 不可以
        /*if (root.val==0) {
            root.val+=1;
            targetSum+=1;
        }*/
        /*if (root.right!=null)
            queue.add(root.right);*/
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.println("执行了一次节点遍历");
            int target = targetSum;
            if (tmp.val == 0) {
                tmp.val++;
                target++;
            }
            if (searchTarget(tmp, 0, target)) return true;
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
        }
        return false;
    }

    public static boolean searchTarget02(TreeNode root, int sum, int target) {

        sum += root.val;
        System.out.println(root.val + "这是树===" + sum);
        if (sum == target && root.val != sum) return true;
            //else if (sum > target) return false;  //本来是剪枝操作,如果有负数就不行,要Math.abs
        else {
            boolean flag = false;
            if (root.left != null) flag = searchTarget(root.left, sum, target);
            if (flag) return flag;
            if (root.right != null) flag = searchTarget(root.right, sum, target);
            return flag;
        }

        //else return false;

    }

    //根节点到叶子节点 12 5
    public static boolean hasPathSum(TreeNode root, int targetSum) {

        //Queue<TreeNode> queue = new LinkedList<>();
        //if (root==null)return false;
        //if (root != null)
        //queue.add(root);
        //else return false;
        if (root==null)return false;
        if (root.left == null && root.right == null) return root.val == targetSum;

        //防止有root.val=0的情况,影响后面的判断 不可以
        /*if (root.val==0) {
            root.val+=1;
            targetSum+=1;
        }*/
        /*if (root.right!=null)
            queue.add(root.right);*/
        //while (!queue.isEmpty()) {
           /* TreeNode tmp = queue.poll();
            System.out.println("执行了一次节点遍历");
            int target = targetSum;
            if (tmp.val == 0) {
                tmp.val++;
                target++;
            }
            if (searchTarget(tmp, 0, target)) return true;
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);*/
        // }
        return searchTarget(root,0,targetSum);
    }

    public static boolean searchTarget(TreeNode root, int sum, int target) {

        sum += root.val;
        System.out.println(root.val + "这是树===" + sum);
        if (sum == target && root.left==null&&root.right==null) return true;
            //else if (sum > target) return false;  //本来是剪枝操作,如果有负数就不行,要Math.abs
        else {
            boolean flag = false;
            if (root.left != null) flag = searchTarget(root.left, sum, target);
            if (flag) return flag;
            if (root.right != null) flag = searchTarget(root.right, sum, target);
            return flag;
        }

        //else return false;

    }

    public static void main(String[] args) {
        //5,4,8,11,null,13,4,7,2,null,null,null,1     22
        System.out.println(hasPathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7),
                new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null,
                new TreeNode(1)))), 22));
        System.out.println(hasPathSum(new TreeNode(1, new TreeNode(2), null), 1));
        System.out.println(hasPathSum(null, 1));
        System.out.println(hasPathSum(new TreeNode(1), 1));
        System.out.println("-------------77case-------------");
        System.out.println(hasPathSum(new TreeNode(-2, null, new TreeNode(-3)), -5));
        System.out.println("-----------101case------------------");
        System.out.println(hasPathSum(new TreeNode(0, new TreeNode(1), new TreeNode(1)), 1));
        System.out.println("--------102case-----------------");
        System.out.println(hasPathSum(new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4),null),null),null),6));

    }

    //Definition for a binary tree node.
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
    }

}

