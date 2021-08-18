package 数据结构算法教程.java数据结构算法.第8节_树tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    //构造huffman树
    public static void techersTest1() {
        /****
         赫夫曼树创建思路图解:给一个数列 13 7 8 3 29 6 1
         要求转成一颗哈夫曼树
         1.冲小到大排序哈夫曼树,每一个数据是一个节点,一个最简单的二叉树
         2.取出根节点权值最小的两颗二叉树
         3.组成一颗新的二叉树,该新的二叉树的根节点的权值是前面两颗热茶树权值和
         4.以根节点的前置大小再次排序,重复1234

         如何构建一颗哈夫曼树的一个步骤,
         13 7 8 3 29 1 6
         排序1 3 6 7 8 13 29
         取前二合并1 3 ->4
         插入排序4 6 7 8 13 29
         取出4 6组合 4 6->10
         插入排序7 8 10 13 29
         取出7 8组合15
         插入排序10 13 15 29
         取出10 13组合23
         插入排序15 23 29
         取出15 23组合29 38
         插入排序29 38
         取出29 38组合67
         形成最终的huffman树
         *           67
         *       38      29
         *     15  23
         *   7  8  10 13
         *        4 6
         *       1 3
         这颗huffman树的权值就是最小的,就是这4步反复执行的过程,接下来代码实现
         */
        int[] arr = new int[]{13, 7, 8, 3, 29, 6, 1};
        createHuffmanTree(arr);
    }

    //变长编码举例
    public static void techersTest2() {
        /****
         i like like like java do you like a java
         102 32
         40字符 ->359长度

         按照各个字符出现的次数进行权值编码,数显的次数多,编码长度越少
         0空格 i10 k100 l101 o10 v111 j1000 u1001 y1010 d1011
         字符的编码都不能是其他字符编码的前缀,符合这要求就是前缀编码 即不能匹配重复的编码
         这个huffman有这个问题 1是a  i的公共前缀   匹配的多义性   如何处理?
         采用huffman编码: 权值划分

         huffman编码:1.需要传输的是 i like like like java do you like a java
         1. 排序: d1 y1 u1 j2 o2 i4 k4 e5 a5 null9
         2. 安照出现的次数进行huffman->出现的次数作为权值
         3.构建node节点  之后路径0 1表示左子树 右子树 ===向左的路径是0 向右的路径为1
         o:1000 u:10010 d:100110 y:100111 i:101
         a:110 k:1110 e:1111 j:0000 v:ooo1 l:001 空格:01
         是一个前缀编码{神器:研究过}
         每一个编码不会是另一个编码的前缀; 注意:是无损压缩
         101 01 001--------------长度为133 -原长度359 压缩率62.9%{无损的}

         1.有可能一样大的权值,那么有可能编码不一样; 顺序不稳定,
         wpl是一样的,都是最小的,





         */
    }

    public static void main(String[] args) {
        techersTest1();

    }

    //构建huffman树的方法
    public static Node createHuffmanTree(int[] arr) {
        //先构建成node ->装载集合里面 Collections.sort(); List<Node> 自动管理排序装载 方便
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }
        System.out.println("排序前" + nodes);
        Collections.sort(nodes);
        System.out.println("排序后" + nodes);

        while (nodes.size() > 1) {
            //1.取出权值最小的节点(就是一个最简单的二叉树)   循环
            Node leftNode = nodes.get(0);
            //2.取出次小的node(二叉树)
            Node rightNode = nodes.get(1);
            //三:构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
            Collections.sort(nodes);
            System.out.println("第...次排序后构建的huffman树:" + nodes);
        }

        Node huffmanTree = nodes.get(0);
        //前序遍历huffmanTree
        //System.out.println(huffmanTree);
        //System.out.println(huffmanTree.left);
        //System.out.println(huffmanTree.right);
        huffmanTree.preNode();
        return huffmanTree;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preNode();
        } else {
            System.out.println("---null---can't preOrder---");
        }
    }
}

//创建节点类
//为了让node对象 持续排序Collection集合排序
//让Node实现一个Compareable接口 进行排序
class Node implements Comparable<Node> {
    int value; //节点的权值
    char c;//字符
    Node left;//指向左子节点
    Node right;//指向右子节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node node) {
        //表示从小到大排序
        return this.value - node.value;//正数就表示调用者大  升序
    }

    //前序遍历huffmanTree
    public void preNode() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preNode();
        }
        if (this.right != null) {
            this.right.preNode();
        }
    }
}