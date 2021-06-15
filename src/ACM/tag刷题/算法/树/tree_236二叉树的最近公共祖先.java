package ACM.tag刷题.算法.树;

import java.util.HashMap;
import java.util.Map;

public class tree_236二叉树的最近公共祖先 {

    /***
     给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */

    public static void getParent(TreeNode root,Map<TreeNode,TreeNode> map){
        if (root.left!=null){
            map.put(root.left,root);
            getParent(root.left,map);
        }
        if (root.right!=null){
            map.put(root.right,root);
            getParent(root.right,map);
        }

    }

    /***
     特殊情况一:当父节点是p,q其中一个本身的时候
     * @param root
     * @param p
     * @param q
     * @return
     */
    //并查集
    //方法一:构造一颗有父节点的树,然后一直将p q一起找父节点,第一次重合的就是最近公共祖先 6 95
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //构造父节点指向 map<子节点,父节点>
        Map<TreeNode,TreeNode> map = new HashMap<>();//child-parent
        getParent(root,map);
        //System.out.println(map);
        //System.out.println(map.get(root.left));

        //找p,q的父节点
        //在封装一个map 把p的<父节点,子节点>
        //遍历q的父节点,如果get父节点会等于p这个子节点,return这个父节点
        Map<TreeNode,TreeNode> childMap = new HashMap<>();
        childMap.put(p,p);
        TreeNode tmp = map.get(p);
        while (tmp!=null){
            childMap.put(tmp,p);
            tmp = map.get(tmp);
        }

        //查询q
        //特殊情况,
        if (childMap.get(q) == p) {
            return q;
        }

        TreeNode qParent = map.get(q);
        while (qParent!=null){
            if (childMap.get(qParent)==p){
                return qParent;
            }else {
                qParent = map.get(qParent);
            }
        }


        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1,new TreeNode(0),new TreeNode(8)));
        System.out.println(lowestCommonAncestor(root,root.left,root.right));
    }


    /***官方
     方法一：递归
     思路和算法

     我们递归遍历整棵二叉树，定义 f_xf
     x
     ​
     表示 xx 节点的子树中是否包含 pp 节点或 qq 节点，如果包含为 true，否则为 false。那么符合条件的最近公共祖先 xx 一定满足如下条件：

     (f_{\text{lson}}\ \&\&\ f_{\text{rson}})\ ||\ ((x\ =\ p\ ||\ x\ =\ q)\ \&\&\ (f_{\text{lson}}\ ||\ f_{\text{rson}}))
     (f
     lson
     ​
      && f
     rson
     ​
     ) ∣∣ ((x = p ∣∣ x = q) && (f
     lson
     ​
      ∣∣ f
     rson
     ​
     ))

     其中 \text{lson}lson 和 \text{rson}rson 分别代表 xx 节点的左孩子和右孩子。初看可能会感觉条件判断有点复杂，我们来一条条看，f_{\text{lson}}\ \&\&\ f_{\text{rson}}f
     lson
     ​
      && f
     rson
     ​
     说明左子树和右子树均包含 pp 节点或 qq 节点，如果左子树包含的是 pp 节点，那么右子树只能包含 qq 节点，反之亦然，因为 pp 节点和 qq 节点都是不同且唯一的节点，因此如果满足这个判断条件即可说明 xx 就是我们要找的最近公共祖先。再来看第二条判断条件，这个判断条件即是考虑了 xx 恰好是 pp 节点或 qq 节点且它的左子树或右子树有一个包含了另一个节点的情况，因此如果满足这个判断条件亦可说明 xx 就是我们要找的最近公共祖先。

     你可能会疑惑这样找出来的公共祖先深度是否是最大的。其实是最大的，因为我们是自底向上从叶子节点开始更新的，所以在所有满足条件的公共祖先中一定是深度最大的祖先先被访问到，且由于 f_xf
     x
     ​
     本身的定义很巧妙，在找到最近公共祖先 xx 以后，f_xf
     x
     ​
     按定义被设置为 true ，即假定了这个子树中只有一个 pp 节点或 qq 节点，因此其他公共祖先不会再被判断为符合条件。

     下图展示了一个示例，搜索树中两个节点 9 和 11 的最近公共祖先。

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
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
