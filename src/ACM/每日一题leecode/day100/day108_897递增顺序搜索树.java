package ACM.每日一题leecode.day100;

import java.util.Stack;

public class day108_897递增顺序搜索树 {
    /***

     */
    public static void main(String[] args) {
        System.out.println(increasingBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

    }

    //方法一,直接将每一个出栈的直接变成当前root p的右子树
    public static TreeNode increasingBST(TreeNode root) {

        TreeNode cur = root;
        TreeNode p = new TreeNode();//一个虚拟节点
        TreeNode tempP = p;
        System.out.println(cur);
        System.out.println(p);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null){
                stack.add(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                tempP.right=cur;//new TreeNode(cur.val)
                cur.left=null;
                tempP=tempP.right;
                cur=cur.right;
                //System.out.println(pop.val);
            }
        }

       // System.out.println(p);
        return p.right;
    }
}
