package 数据结构算法教程.java数据结构算法.第8节_树tree;

import java.util.ArrayList;

public class TreeDemo {

    public static void teacherTest1() {
        /***
         1.数组
         数组查方便 增删改不方便
         链表:正好相反
         数:二者兼得,但是复杂,难学

         数组下标固定,长度固定,不能动态增长
         数组扩容:一个新长度+1数组,后移 复制数据过去
         空间:新数组 / 时间:需要后移
         开大一点? 不好把握
         ArrayList->底层维护了一个数组 Object 扩容策略: 按照比例扩容
         维护了  this.elementData = new Object[var1];空数组
         grow(int var1) 这个方法扩容:策略   初始10   1.5倍扩容

         int var2 = this.elementData.length;
         int var3 = var2 + (var2 >> 1);
         if (var3 - var1 < 0) {
         var3 = var1;
         }
         if (var3 - 2147483639 > 0) {
         var3 = hugeCapacity(var1);
         }
         this.elementData = Arrays.copyOf(this.elementData, var3);

         链表:插入高效,good
         但是查找呢 从头开始检索  效率低 100万数据 比较100万次

         二叉树存储:提高数据的增删
         用二叉排序树:提高检索速度
         集合用树:红黑树->自旋转的二叉排序树
         B+数
         分析:如何用二叉排序树来存储数据,并提高赠删改查的效率
         *     7
         *  3   10
         *1  5 9  12
         维护一颗二叉排序树 ->折半了  findValue比较7小就左 大就右
         13 找到7向右-找到10向右-找到12向右 null-则挂载12上
         删除呢?需要处理:维护一颗正常的排序树
         删除1  直接删除
         删除10 右节点上移动
         删除1 左节点上移动
         avl数
         霍夫曼编码数 权值分布距离
         b b+树

         */
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static void teacherTest_2() {
        /****
         术语:
         节点
         子节点
         根节点
         父节点
         叶子节点{没有子节点}
         路径root 到 节点
         层
         子树
         树的高度{最大层数}
         森林: 多颗子树构成森林

         二叉树:节点总数  2^n-1
         满二叉树:所有叶子节点都在最后一层
         完全二叉树  可以不满  只能叶子节点空 上面全部连续

         */
    }

    public static void teacherTest_3() {
        /****
         前序遍历:中 左 右
         中序:    左 中 右
         后续:    左 右 中
         *  1
         *2  3
         *     4

         创建一个树;
         前序遍历
         先输出当前节点
         左节点不为空,递归继续前序遍历
         如果右节点不为空,递归继续前序遍历
         -----
         中遍历
         左节点不为空,递归继续前序遍历
         输出当前节点
         如果右节点不为空,递归继续前序遍历
         -----
         后遍历
         左节点不为空,递归继续前序遍历
         如果右节点不为空,递归继续前序遍历
         输出当前节点

         */
    }

    public static void main(String[] args) {
        tree tree = new tree(7);
        tree tree1 = new tree(3);
        tree tree2 = new tree(10);
        tree tree3 = new tree(1);
        tree tree4 = new tree(5);
        tree tree5 = new tree(9);
        tree tree6 = new tree(12);
        tree.left = tree1;
        tree.right = tree2;
        tree1.left = tree3;
        tree1.right = tree4;
        tree2.left = tree5;
        tree2.right = tree6;
        list(tree);
        find(tree, 3);
        find(tree, 100);
        System.out.println("动态高效插入-----");
        add(tree, 0);
        add(tree, 20);
        list(tree);
    }


    public static void add(tree tree, int val) {
        if (val >= tree.data) {
            if (tree.right == null) {
                tree tempTree = new tree(val);
                tree.right = tempTree;
            } else {
                add(tree.right, val);
            }
        } else {
            if (tree.left == null) {
                tree tempTree = new tree(val);
                tree.left = tempTree;
            } else {
                add(tree.left, val);
            }
        }


    }

    public static int find(tree tree, int val) {
        if (val == tree.data) {
            System.out.println("找到了");
        } else if (val > tree.data) {
            if (tree.right != null) {
                System.out.println("在右边找");
                find(tree.right, val);
            } else {
                System.out.println("在右边找,空了~");
            }
        } else if (val < tree.data) {
            if (tree.left != null) {
                System.out.println("在左边找");
                find(tree.left, val);
            } else {
                System.out.println("在左边找,空了~");
            }
        }
        return -1;
    }

    public static int del(tree tree) {
        return 0;
    }

    public static void list(tree tree) {
        System.out.print(tree.data + "-");
        if (tree.left != null) {
            list(tree.left);
        }
        if (tree.right != null) {
            list(tree.right);
        }
    }
}

class tree {
    int data;
    tree left;
    tree right;

    public tree(int val) {
        data = val;
    }
}