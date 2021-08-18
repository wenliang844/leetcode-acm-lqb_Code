package 数据结构算法教程.java数据结构算法.第8节_树tree.BinarySortTree;

/***
 二叉排序树
 查询,增删改都比较可观,
 binary/ huffman/  没有涉及排序查找
 如何查询?
 利用二叉排序树
 BinarySortTree
 左小 右大   -相同的树左 右都可以
 构造:
 *  7 3 10 12 5 1 9
 *        7
 *     3     10
 *   1   5  9  12

 2.删除:
 *  左:parent.left=null
 *  右:parent.right=null
 ** 1.是叶子节点->直接删除
 * ***1.需要先定位节点targetNode
 *  **2.删除是找到目标节点的父节点 parent {考虑是否存在父节点
 *  **3.确定targetNode是左子节点还是右字节点
 *  **4.根据前面的情况对应删除
 ** 2.有一颗子树->直接顶上?
 * ****1.需要先定位节点targetNode
 *  ***2.删除是找到目标节点的父节点 parent {考虑是否存在父节点
 *  ***3.确定targetNode的子节点是左子节点还是右字节点
 *  ***4.targetNode是parent的左子节点还是右子节点
 *  //***5.如果target是parent的左子节点
 *  //*****5.1target的子节点是左子节点
 *  //*****parent.left = taget.left
 *  //*****5.2如果target子节点是右子节点
 *  //*****parent.left=target.right
 *  ***5.如果targetNode有左子节点
 *          **5.1如果targetNode是parent的左子节点
 *      parent.left = targetNode.left
 *          **5.1右子节点
 *      parent.right = targetNode.left
 *          **6.1如果targetNode是parent的左子节点
 *      parent.left = target.right
 *          **6.2targetNode是parent的是右子节点
 *      parent.right=target.right
 *
 ** 3.有两颗子树->
 *****1.需要先定位节点targetNode
 *  **2.删除是找到目标节点的父节点 parent {考虑是否存在父节点
 * ***3.从targetNode的右子树找到最小值        {或者左子树的最大值}
 * ***4.用一个临时变量,将最小节点的值temp保留
 * ***5.删除该最小节点
 *          targetNode.value = temp
 *
 * 两件事:1.删除该节点右节点的最小值---写一个小方法搞定
 *      2.把这个最小值的节点value返回,赋值给当前节点
 *
 巧妙:先判断第三种情况,直接先排除简单的情况

 作业:删除有两个子节点的节点,从左子树找一个最大的节点进行删除
 */
public class BinarySortTreeDemo {

    public static void teachersTest1() {
        int[] arr = {7, 3, 10, 12, 5, 1, 9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //添加节点 循环添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();//刚好中序是有序的->1 3 5 7 9 10 12

        //测试删除叶子节点 只要是叶子节点都可以删除
        //binarySortTree.delNode(2);//直接删除1 删除不了
        //System.out.println("删除节点后-----");
        //binarySortTree.infixOrder();

        //测试删除只有一个子节点
        //binarySortTree.delNode(1);
        //System.out.println("删除只有一个子节点的节点后--");
        //binarySortTree.infixOrder();

        //测试删除有两个节点的节点
        //binarySortTree.delNode(3);
        //System.out.println("删除有2个子节点的节点后--");
        //binarySortTree.infixOrder();


        //发现一个漏洞,当删除到最后的是根节点,且根节点只有一个节点,有根节点没有父节点而空指针
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        //binarySortTree.delNode(1);
        System.out.println("删除后:");
        binarySortTree.infixOrder();

    }

    public static void main(String[] args) {
        teachersTest1();
    }
}

//创建一颗二叉排序树
class BinarySortTree {
    private Node root;

    //添加
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("is null~");
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root==null){
            return null;
        }else {
            return root.search(value);
        }
    }

    //查找要删除节点额父节点
    public Node searchParent(int value) {
        if (root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    //编写一个方法,找到当前节点右节点的最小值
    public int delRightTreeMin(Node node){
        /****
         node传入的节点,当做新的节点 二叉排序树的根节点
         返回一个以node为根节点的最小节点,并且删除这个节点
         */
        Node target = node;
        //循环查找左节点,就会找到最小值
        while (target.left!=null){
            target = target.left;//target最终就是最小值,最左边的树
        }
        //target是最小值
        delNode(target.value);//相当于删除一个叶子节点
        return target.value;
    }
    //删除节点
    public void delNode(int value){
        if (root == null){
            return;
        }else {
            //1.需要找到要删除的节点
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个节点,删除
            if (root.left ==null && root.right==null){
                root = null;
                return;
            }

            //去找到targetNode的父节点
            Node parent = searchParent(value);
            //如果删除的节点是叶子节点
            if (targetNode.left==null && targetNode.right==null){
                //判断targetNode是父节点的左字节点还是右子节点
                if (parent.left!=null && parent.left.value == value){
                    //targetNode就是父节点的左子节点
                    parent.left=null;
                }else if (parent.right!=null && parent.right.value==value){
                    //说明是右子节点
                    parent.right=null;
                }
            }else if (targetNode.left!=null && targetNode.right!=null){//删除两个节点的
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;

                //可以从左子树找最大的,也是一样的思路
            }else {//删除只有一颗子树的节点
                //如果要删除的节点有左字节点 再分两种情况
                if (targetNode.left!=null){

                    //如果parent为空,有只有一个左子树,则root直接=targetNode
                    if (parent!=null){
                        //如果targetNode是parent的左子节点
                        if (parent.left.value ==value){
                            parent.left = targetNode.left;
                        }else {
                            parent.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }

                }else {
                    if (parent!=null){
                        //如果要删除的节点有右子节点
                        if (parent.left.value ==value){
                            parent.left=targetNode.right;
                        }else {
                            parent.right=targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }

                }

            }

        }
    }
}

//节点
class Node {
    int value;//值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点的方法
    public void add(Node node) {
        if (node == null) {
            return;
        }

        //判断传入的节点的值和当前的值比较 小左  大右放
        if (node.value < this.value) {
            if (this.left == null) {//没有左子树,放左
                this.left = node;
            } else {//递归往下面添加
                this.left.add(node);
            }
        } else {//添加的节点大于当前节点
            if (this.right == null) {//空则直接挂右
                this.right = node;
            } else {//否则递归向右节点添加
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        /**
         value: 查找的值
         return Node: 找到的节点,返回
         */
        if (value == this.value) {//找到了
            return this;
        } else if (value < this.value) {//小于当前值,取左子树找
            if (this.left == null) {//如果左节点为空
                return null;
            }
            return this.left.search(value);
        } else {//大于 右节点
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除节点额父节点
    public Node searchParent(int value) {
        /**value这是要查找的节点的值
         * return Node: 返回这个节点的父节点,如果没有就返回null
         */
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {//当前节点就是要删除的父节点
            return this;
        }else {
            //如果查找的这个值小于当前节点的这个值 并且当前这个节点的左子节点不为空  递归向左边去寻找
            if (value<this.value && this.left!=null){
                return this.left.searchParent(value);//想左子树
            }else if (value>=this.value && this.right !=null){
                return this.right.searchParent(value);//向右子树进行查找
            }else {
                return null;//没有父节点 比如根节点
            }
        }
    }

}