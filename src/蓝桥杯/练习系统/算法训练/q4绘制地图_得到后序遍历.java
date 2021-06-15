package 蓝桥杯.练习系统.算法训练;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class q4绘制地图_得到后序遍历 {


    //方法一:模拟法 49 9
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        int[] visited = new int[len];
        Stack<TreeNode> stackTree = new Stack<>();//方便直接加左右子树tree
        Stack<Integer> stackIndex = new Stack<>();//方便判断是左还是右子树

        TreeNode root = new TreeNode(preorder[0]);//第一个是头结点
        stackTree.add(root);
        Map<Integer, Integer> map = new HashMap<>();//inorder的值 下标  快速定位
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        visited[map.get(preorder[0])] = 1;
        stackIndex.push(map.get(preorder[0]));//把下标1放进去
        for (int i = 1; i < len; i++) {//遍历preorder
            TreeNode tree = new TreeNode(preorder[i]);
            //TreeNode p = stackTree.peek();
            int inorderIndex = map.get(preorder[i]);
            boolean flag = false;

            //考核的位置变一下
            while (stackIndex.size() > 1) {
                int l1 = stackIndex.peek() - 1 >= 0 ? stackIndex.peek() - 1 : stackIndex.peek();
                int r1 = stackIndex.peek() + 1 < len ? stackIndex.peek() + 1 : stackIndex.peek();
                if (visited[l1] == 1 && visited[r1] == 1) {//两边的节点都访问过了,继续peek栈的下一个
                    stackIndex.pop();
                    stackTree.pop();
                } else {
                    break;//考核结束
                }
            }


            if (inorderIndex < stackIndex.peek()) {//在上一个父节点的左边
                //TreeNode p = stackTree.pop();
                stackTree.peek().left = tree;
                flag = true;
                //stackTree.add(p);
            } else {
                //TreeNode p = stackTree.pop();
                stackTree.peek().right = tree;
                //stackTree.add(p);
            }
            //将9这个节点设为已访问
            visited[inorderIndex] = 1;

            //弄完之后栈里面有可能null   解决:size大于1才进行考核
            //1加在考核当前index值进栈之前,对栈中的peek元素进行考核,是否有资格
           /* while (stackIndex.size()>1){
                int l1 = stackIndex.peek() - 1 >= 0 ? stackIndex.peek() - 1 : stackIndex.peek();
                int r1 = stackIndex.peek() + 1 < len ? stackIndex.peek() + 1 : stackIndex.peek();
                if (visited[l1]==1 && visited[r1]==1){//两边的节点都访问过了,继续peek栈的下一个
                    stackIndex.pop();
                    stackTree.pop();
                }else {
                    break;//考核结束
                }
            }*/

            //这个perorder[i] 9可能作为根节点,判断9的左右有没有0 有的话就进栈
            int left = inorderIndex - 1 >= 0 ? inorderIndex - 1 : inorderIndex;
            int right = inorderIndex + 1 < len ? inorderIndex + 1 : inorderIndex;//两个值,处理边界情况
            if (visited[left] == 0 || visited[right] == 0) {
                //有任何一边有没访问的情况,把节点和下标加入栈
                stackIndex.add(inorderIndex);
                //stackTree.add(new TreeNode(preorder[i]));
                if (flag) {
                    stackTree.add(stackTree.peek().left);
                } else {
                    stackTree.add(stackTree.peek().right);
                }

            }

        }

        return root;
    }

    static int[] last;
    static int index;

    //输出后序遍历的方法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] pre = new int[n];
        int[] mid = new int[n];
        last = new int[n];
        index = 0;
        for (int i = 0; i < n; i++) {
            pre[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            mid[i] = scanner.nextInt();
        }

        //得到这棵树
        TreeNode root = buildTree2(pre, mid);
        //System.out.println(root);
        //得到后序遍历 左 右 中
        dfs(root);
        for (int i = 0; i < n; i++) {
            System.out.print(last[i] + " ");
        }
    }

    private static void dfs(TreeNode root) {

        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        last[index++] = root.val;

    }

    private static Map<Integer, Integer> indexMap;

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    //方法二:dfs递归法
    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;

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
