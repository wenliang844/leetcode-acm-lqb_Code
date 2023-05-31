package ACM.每日一题leecode.第二波.leetcode.day030;

import ACM.leecode周赛.力扣杯2021春战队赛.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 陈文亮
 * @date 2023/5/30 11:19
 */
public class day53_1110删点成林 {
    public static void main(String[] args) {

        System.out.println(delNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))), new int[]{3, 5}));
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        /**
         *    1
         *   2 3
         * 4 5 6 7
         * 遍历bfs
         * 用栈
         *
         * if当前节点删除：父节点滞空，
         * 将左右节点加入栈
         */
        List<Integer> list = Arrays.stream(to_delete).boxed().collect(Collectors.toList());
        List<TreeNode> treeReslist = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
//
//        if (list.contains(root.getVal())){
//            if (root.getLeft() != null) {
//                stack.add(root.getLeft());
//                parentMap.put()
//            }
//            if (root.getRight() != null) {
//                stack.add(root.getRight());
//            }
//        }else {
//            stack.add(root);
//        }


        while (!stack.isEmpty()) {

            TreeNode pop = stack.pop();
            if (list.contains(pop.getVal())) {

                TreeNode node = parentMap.get(pop);
                if (node != null){
                    if (node.getLeft().getVal() == node.getVal()){
                        node.setLeft(null);
                    }else {
                        node.setRight(null);
                    }
                }
            }

            System.out.println(pop.getVal());

            if (pop.getLeft() != null) {
                stack.add(pop.getLeft());
            }
            if (pop.getRight() != null) {
                stack.add(pop.getRight());
            }
        }

        return treeReslist;
    }

}
