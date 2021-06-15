package 算法algo.马士兵左程云_排序算法.牛客第三期初级;

public class tree打印有父节点的二叉树的后继节点 {

    //获取最左节点
    public static Tnode getLeftNode(Tnode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node=node.left;
        }
        return node;
    }

    //获取没有右接地那的右子树  的第一个是右子树的parent节点
    //获取没有右节点的左子树的parent
    //获取后继节点
    public static Tnode getRightParent(Tnode node){

        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftNode(node.right);
        }else {
            Tnode parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent=node.parent;
            }
            return parent;
        }
    }
    //获取parent
    public static Tnode getParent(Tnode node) {
        return node.parent;
    }

    /*//获取后继节点
    public static Tnode getBackNode(Tnode node) {
        return getRightParent(node);

    }*/
    public static void main(String[] args) {

    }

}

class Tnode {
    Tnode left;
    Tnode right;
    Tnode parent;
    int data;

    Tnode() {
    }

    Tnode(int data) {
        this.data = data;
    }
}
