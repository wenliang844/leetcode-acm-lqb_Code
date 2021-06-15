package ACM.每日一题leecode.自刷;

import ACM.tag刷题.算法.树.tree_236二叉树的最近公共祖先;

import java.util.HashMap;
import java.util.Map;

public class leetension_235二叉搜索树的最近公共祖先 {
    /****
     给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     输出: 6
     解释: 节点 2 和节点 8 的最近公共祖先是 6。
     */
    //12 5
    public static void getParentMap(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root.left != null) {
            parent.put(root.left, root);
            getParentMap(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            getParentMap(root.right, parent);
        }
    }

    //方法一:并查集 封装一个子节点-父节点的map,将p的父节点封装到一个map,找q的父节点,一旦找到匹配p就是你了
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        getParentMap(root, parent);
        //System.out.println(parent);

        //构造一个map p的父节点-p
        Map<TreeNode, TreeNode> pMap = new HashMap<>();
        pMap.put(p, p);
        TreeNode temp = parent.get(p);
        while (temp != null) {
            pMap.put(temp, p);
            temp = parent.get(temp);
        }
        //System.out.println(pMap);

        //特殊情况,当q节点就是公共节点
        if (pMap.get(q) == p) {
            return q;
        }
        //获取q的父节点,如果q的父节点==map.get{}对应,则return
        TreeNode qparent = parent.get(q);
        while (qparent != null) {

            if (pMap.get(qparent) == p) {
                return qparent;
            } else {
                qparent = parent.get(qparent);
            }
        }

        return null;
    }

    //方法二:利用二叉搜索树的性质特点:

    /***
     如果p,q都比root小说明在左边
     如果p,q都比root大说明在右边
     如果一个大一个小说明就是root
     */
    //100 29
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(lowestCommonAncestor(root, root.left, root.right));
        System.out.println(lowestCommonAncestor2(root, root.left, root.right));
    }
}
