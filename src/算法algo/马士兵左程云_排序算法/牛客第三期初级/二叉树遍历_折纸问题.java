package 算法algo.马士兵左程云_排序算法.牛客第三期初级;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 5. 折纸问题:
 把一段纸条从下到上折一次  就是下折痕    0           0
 下        1      0+1
 折两次就是           上        下            下                   3  1+2
 折三次就是  上  上  下  下 上  下       下       7  3+4
 上上 下上 上下 下下 上上 下下  上 下 下     15 7+8


 这结构就是一颗树呀!
 左子树是上,右子树是下
 中序遍历的反过程  左右中

 */
public class 二叉树遍历_折纸问题 {

    //判断是否叶子节点:左右子树都为空   加节点的方法
    public static void addNode(TreeNode treeNode){
        Queue<TreeNode> tQueue = new LinkedList<>();
        tQueue.add(treeNode);
        while (!tQueue.isEmpty()){
            TreeNode treeNode1 = tQueue.poll();
            if (treeNode1.left!=null){
                tQueue.add(treeNode1.left);
                tQueue.add(treeNode1.right);
            }else {
                TreeNode newTreeNode1 = new TreeNode("上");
                TreeNode newTreeNode2 = new TreeNode("下");
                treeNode1.left = newTreeNode1;
                treeNode1.right = newTreeNode2;
            }
        }
    }
    //中序遍历二叉树  左 中 右
    public static void printTree(TreeNode treeNode,List<String> list){
        if (treeNode.left!=null){
            printTree(treeNode.left,list);
        }
        //System.out.println(treeNode.str);
        list.add(treeNode.str);
        if (treeNode.right!=null){
            printTree(treeNode.right,list);
        }
    }

    public static List<String> tree_PaperFolding(int N) {
        List<String> list = new ArrayList<>();
        TreeNode treeNode = new TreeNode("下");
        //构造二叉树
        for (int i = 2; i <= N; i++) {
            addNode(treeNode);
        }

        //中序遍历二叉树  左 中 右
        printTree(treeNode,list);



        return list;
    }

    public static void main(String[] args) {
        System.out.println(tree_PaperFolding(1));
        System.out.println(tree_PaperFolding(2));
        System.out.println(tree_PaperFolding(3));
        System.out.println(tree_PaperFolding(4));
    }


}

//构造二叉树
class Tree {//封装
    TreeNode node = new TreeNode();
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    String str;

    TreeNode(String str){
        this.str=str;
    }
    TreeNode(){

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", str='" + str + '\'' +
                '}';
    }
}