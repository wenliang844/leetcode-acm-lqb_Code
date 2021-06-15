package ACM.每日一题leecode.day32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class day62_剑指Offer54二叉搜索树的第k大节点 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left=node1;
        root.right=node2;
        node1.right=node3;
        System.out.println("这是结果="+kthLargest(root, 1));

    }

    //方法:遍历树
    public static List<Integer> DFSTree(TreeNode root,List<Integer> list){
        //List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left!=null){
            DFSTree(root.left,list);
        }
        if (root.right!=null){
            DFSTree(root.right,list);
        }
        return list;
    }

    public static int kthLargest(TreeNode root, int k) {

        //给定一棵二叉搜索树，请找出其中第k大的节点。
        List<Integer> list = new ArrayList<>();
        DFSTree(root,list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });
        System.out.println(list);

        return list.get(k-1);
    }




        //Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
