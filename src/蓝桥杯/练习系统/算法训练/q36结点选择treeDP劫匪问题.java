package 蓝桥杯.练习系统.算法训练;

/***
 10
 41 982 686 796 781 801 63 52 60 748
 3 4
 8 5
 1 9
 10 7
 2 3
 1 6
 1 3
 2 7
 4 5

 1527--->3439(right)
 */

import java.util.Scanner;

public class q36结点选择treeDP劫匪问题 {
    //劫匪问题2中等 树形DP 跨层选择问题
    //f(1) = max(1+f(left.le.ri)+f(left.le.ri),f(left) + f(right))
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeNode[] treeNodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            treeNodes[i] = new TreeNode(scanner.nextInt());//权值
        }

        for (int i = 0; i < n-1; i++) {
            int from = scanner.nextInt()-1;
            int to = scanner.nextInt()-1;
            if (treeNodes[from].left==null){
                treeNodes[from].left=treeNodes[to];
            }else {
                treeNodes[from].right=treeNodes[to];
            }
        }

        //业务处理 自己加上两子数的后代 和后代的最大值  没有后代直接返回自己
        System.out.println(dfs(treeNodes[0]));


    }

    private static int dfs(TreeNode treeNode) {
        if (treeNode.left==null && treeNode.right==null){
            return treeNode.val;
        }

        int num1=treeNode.val,num2=0;
        if (treeNode.left!=null){
            num2+=dfs(treeNode.left);
            num1 += treeNode.left.left==null?0:dfs(treeNode.left.left);
            num1 += treeNode.left.right==null?0:dfs(treeNode.left.right);
        }
         if (treeNode.right!=null){
            num2+=dfs(treeNode.right);
            num1 += treeNode.right.left==null?0:dfs(treeNode.right.left);
            num1 += treeNode.right.right==null?0:dfs(treeNode.right.right);
        }

        return Math.max(num1,num2);
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
