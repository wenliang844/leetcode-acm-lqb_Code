package 数据结构算法教程.java数据结构算法.第8节_树tree.AVL;

/****
 1.左旋转
 *       4                                   6
 *   3        6            ------>       4       7
 *         5     7                    3    5        8
 *                    8
 步骤:
 1.创建一个新节点newNode
 2.新节点的左子树为当前节点的左子树,
 3.新节点的右子树为新节点右子树的左子树
 4.把当前节点的值换成右节点的值
 5.把当前节点的右子树设置成右子树的右子树
 6.把当前节点的左子树设置为新节点

 我说:先创建另一个newRoot替代当前root  接管左和右左
 再用右的值替换root
 替换后这个root就连接newRoot和右右
 当右边比较高的时候需要左旋转

 左子树/右子树的高度是一个判断是否需要旋转的标准
 统计数数的高度 左子树,右子树的高度


 右旋转:
 *          10                  8
 *      8       12---->    7        10
 *    7   9             6        9     12
 *  6
 *
 1.创建一个新的节点10
 2.把新的节点的右子树设置为当前节点的右子树
 3.把新的节点的左子树设置为当前节点的左 右子树
 4.把当前节点的值换为左节点的值
 5.把当前节点的左子树设置为左左子树
 把当前节点的右子树设置为新的节点

 我说:就是创建一个新的节点先接管右和左右
 左子树的value爬上来接管root,root再接管左左和新节点


 双旋转:
 问题:当符合右旋转时,如果左子树的右子树高度大于它的右子树高度
 3.先对当前节点的左节点进行左旋转,
 4.在对当前节点进行右旋转即可
 */
public class AVL_Tree {

    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8}; //测试左旋转 √
        //int[] arr = {10, 12, 8, 9, 7, 6};//测试右旋转 √
        int[] arr = {10, 11, 7, 6, 8, 9};//测试双旋转 √
        AVLTree avlTree = new AVLTree();
        //添加节点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //遍历
        avlTree.infixOrder();
        System.out.println("源树");
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());

        System.out.println("左旋转后");
        System.out.println("当前的根节点="+avlTree.getRoot());
        System.out.println("根节点额左子节点"+avlTree.getRoot().left);//7
        System.out.println("根节点额左子节点"+avlTree.getRoot().left.left);//6
        System.out.println("根节点额左子节点"+avlTree.getRoot().right);//10
        System.out.println("根节点额左子节点"+avlTree.getRoot().right.left);//9
        System.out.println("根节点额左子节点"+avlTree.getRoot().right.right);//11
    }
}

//创建AVL Tree
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

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
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要删除节点额父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //编写一个方法,找到当前节点右节点的最小值
    public int delRightTreeMin(Node node) {
        /****
         node传入的节点,当做新的节点 二叉排序树的根节点
         返回一个以node为根节点的最小节点,并且删除这个节点
         */
        Node target = node;
        //循环查找左节点,就会找到最小值
        while (target.left != null) {
            target = target.left;//target最终就是最小值,最左边的树
        }
        //target是最小值
        delNode(target.value);//相当于删除一个叶子节点
        return target.value;
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1.需要找到要删除的节点
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个节点,删除
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父节点
            Node parent = searchParent(value);
            //如果删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode是父节点的左字节点还是右子节点
                if (parent.left != null && parent.left.value == value) {
                    //targetNode就是父节点的左子节点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    //说明是右子节点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除两个节点的
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;

                //可以从左子树找最大的,也是一样的思路
            } else {//删除只有一颗子树的节点
                //如果要删除的节点有左字节点 再分两种情况
                if (targetNode.left != null) {

                    //如果parent为空,有只有一个左子树,则root直接=targetNode
                    if (parent != null) {
                        //如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }

                } else {
                    if (parent != null) {
                        //如果要删除的节点有右子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
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

    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    //返回右子树高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    //返回当前节点为根节点的高度,以该节点为根节点的数的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;//本身节点算一层
    }

    //左旋转的方法
    private void leftRotate() {
        //1.创建新的节点,以当前根节点的值
        Node newNode = new Node(value);
        //2.把新的节点的左子树设置为当前节点的左子树
        newNode.left = left;
        //3.把新的节点的右设置为当前的右左树
        newNode.right = right.left;
        //4.把当前节点的值替换为右子节点的值
        value = right.value;
        //5把当前节点的右子树设置成右子树的右子树
        right = right.right;
        //6.把当前节点的左子树设置成新的节点
        left = newNode;
    }

    //右旋转的方法
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
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

        //当添加完节点之后发现条件满足{右子树的高度比左子树的高度>1} 左旋转
        if (rightHeight() - leftHeight() > 1) {
            //右子树的左子树的高度大于它的右子树的右子树的高度
            if (right!=null && right.leftHeight()>right.rightHeight()){
                //先对右子树进行旋转
                right.rightRotate();
                //再对当前节点进行左旋转
                leftRotate();
            }else {
                leftRotate();//根节点进行左旋转
            }
            return ;//加一个处理一个,不会向下继续判断了,是没有意义的
        }

        //当添加完一个节点后,如果 {左-右}>1--->右旋转
        if ((leftHeight()-rightHeight())>1){

            //如果它的左子树的右子树高度大于它的左子树的高度
            if (left!=null && left.rightHeight()>left.leftHeight()){
                //先对当前节点的左节点进行左旋转
                left.leftRotate();
                //再对当前节点进行右旋转
                rightRotate();
            }else {
                //直接进行右旋转即可
                rightRotate();
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
        } else {
            //如果查找的这个值小于当前节点的这个值 并且当前这个节点的左子节点不为空  递归向左边去寻找
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);//想左子树
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);//向右子树进行查找
            } else {
                return null;//没有父节点 比如根节点
            }
        }
    }

}