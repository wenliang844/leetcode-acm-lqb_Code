package ACM.每日一题leecode.day66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class day86_173二叉搜索树迭代器 {
    /***
     实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
     BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
     boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
     int next()将指针向右移动，然后返回指针处的数字。
     注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。

     你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
     */
    public static void main(String[] args) {
        BSTIterator bstIterator = new BSTIterator(new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20))));
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());

        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

}

//37 78
class BSTIterator {

    TreeNode rootTree;
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    int index;

    public BSTIterator(TreeNode root) {//初始化
        index = 0;
        this.rootTree = root;
        //根据root构造stack
        //1.走到最左
        TreeNode p1 = new TreeNode();
        p1 = rootTree;
        //stack.push(p1);
        while (p1 !=null || !stack.isEmpty()) {
            //p1 = stack.peek();
            if (p1 != null) {//左子树都进栈  不空向左走
                stack.push(p1);
                p1 = p1.left;
            }else {//空了向右走 保证了根节点也会向右走,不重复左走
                p1 = stack.pop();
                list.add(p1.val);
                p1 = p1.right;
            }
            //stack.push(p1);
            /*list.add(stack.pop().val);
            if (p1.right != null) {//右子树进栈
                stack.push(p1.right);
            }*/
        }


    }

    public int next() {
        //将指针向右移动，然后返回指针处的数字。
        //第一次调用不存在的next,返回最小的数字 min
        //System.out.println(list);

        /*if (index<0){
            //返回最小值list
            index = index+1;
            return Collections.min(list);
        }else {
            return list.get(index++);
        }*/
        return list.get(index++);
    }

    public boolean hasNext() {
        //如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
        return index<list.size();
    }
}




//Definition for a binary tree node.
class TreeNode {
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
