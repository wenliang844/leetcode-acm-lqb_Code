package 数据结构算法教程.java数据结构算法.第8节_树tree;

public class BinaryTreeDemo {
    //测试二叉树
    public static void teachersTest() {

        HeroNode root = new HeroNode(1, "松江");
        HeroNode node2 = new HeroNode(2, "陈文呢");
        HeroNode node3 = new HeroNode(3, "倪妮");
        HeroNode node4 = new HeroNode(4, "就业矿");
        HeroNode node5 = new HeroNode(5, "无人区");

        //说明,先手动创建这个二叉树,后面以递归方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        //测试遍历
        /*System.out.println("前序遍历=");
        root.preOrder();
        System.out.println("中序遍历=");
        root.infixOrder();
        System.out.println("后序遍历=");
        root.postOrder();*/
        /*****
         二叉树的前序查找: 前序 中序 后序查找
         1.先判断当前节点的no是不是等于要查找的
         2.是:返回 否:判断左节点是否空->否:继续前序查找
         中序:
         1.判断左节点是否空,递归查找
         2.如果找到,返回,没有找到,就和当前节点比较
         没找到就继续中序查找
         后序
         1.左点是否为空,不为空递归后序查找
         找到就返回,如果没,就判断右节点,不为空右递归
         和和当前节点进行比较,是 返回   否:返回null
         */

        //前序遍历查找
        System.out.println("前序遍历查找的方式======");
        BinaryTree binaryTree = new BinaryTree(root);
        /*HeroNode resNode = binaryTree.preOrderSearch(5);
        if (resNode != null) {
            System.out.println("这是前序查找的node=" + resNode);
        } else {
            System.out.println("没有找到=");
        }*/

        /***简易规则:
         删除思路分析:
         叶子节点删除这个叶子
         非叶子节点删除这颗树

         单向的树,所以我们判断当前节点的子节点是否需要删除,
         而不能判断当前节点是否是需要删除的,因为不能自删

         1.当前节点的左边或者右边是否需要删除
         2.如果当前节点的左子树不为空,并且左子节点是要删除的,将this.next置空 返回
         3.如果当前节点的右子节点,要删除  直接置空 返回
         4.如果没有,向左子树递归删除
         5.左也没有,就向右子树递归删除
         是root,等价于二叉树置空

         */

        System.out.println("测试删除代码的测试==删除前=");
        binaryTree.preOrder();
        System.out.println("删除后---");
        binaryTree.delNode(5);
        binaryTree.preOrder();

        /***
         思考:
         不直接删除子节点,
         而是如果是右节点符合,右节点只有一个子节点,则该节点替代右节点
         如果有两个子节点  则让左子节点代替这个节点
         if(this.right.no = no){
         //只有一个节点
         this.right = this.right.left
         //有两个节点
         this.right.left.right=this.right.right
         this.right = this.right.left
         }

         二叉排序树:难度有:因为有情况判断
         */


    }

    //顺序存储二叉树
    public static void teachersTest_2() {
        /***
         momeryTree:
         数组存储二叉树
         *    1
         *   2  3
         *  4 5 6 7
         *
         *  1 2 3 4 5 6 7
         *  在遍历数组是,可以以前序,中序,后序进行展示
         顺序存储只考虑完全二叉树;
         n表示二叉树中的第一个元素 0开始编号
         n元素的左节点是2*n +1
         n元素的右节点为2*n+2
         n元素的父节点为 (n-1) / 2

         应用:堆排序用到顺序存储二叉树
         */
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);//1 2 4 5 3 6 7


    }


    //线索化二叉树介绍
    public static void teachersTest_3() {
        //HeroNode2为线索化二叉树服务
        /****
         n个节点的二叉树中含有n+1 公式[2n-(n-1)=n+1]个空指针域,利用二叉链表中的
         空指针域,存放指向节点在某种遍历次序下的前去和后继节点的指针,
         这种附加指针就是[线索]
         空域,指向下一个节点 -线索二叉树Threaded BinaryTree
         前序 中序 后序线索二叉树
         到底叶子节点指向那个后继节点
         左指针指向前驱节点
         右指针指向后继节点
         {8 3 10 1 14 6}
         *         1
         *     3       6
         *  8    10  14
         8后继3
         10前驱3 后继1
         14前驱1 后继6


         作业:前序线索化二叉树
         前序线索化遍历二叉树

         */

        //测试中序线索化二叉树的功能
        HeroNode2 root = new HeroNode2(1, "tom1");
        HeroNode2 node2 = new HeroNode2(3, "tom2");
        HeroNode2 node3 = new HeroNode2(6, "tom3");
        HeroNode2 node4 = new HeroNode2(8, "tom4");
        HeroNode2 node5 = new HeroNode2(10, "tom5");
        HeroNode2 node6 = new HeroNode2(14, "tom6");

        //二叉树,后面用程序生成,现在简单创建测试
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试线索化
        BinaryTree2 binaryTree2 = new BinaryTree2(root);
        binaryTree2.threadedNodes();

        //测试中序线索化 测试10号的前序 后继是不是3 1   ---原来这就是线索化!
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());


        /****
         线索化遍历方式有所改变:
         原来的方式会出现死循环因为叶子节点非null
         可以直接线性遍历:
         如果有后继-标记1,叶子节点直接后继即可
         */
        //binaryTree2.preOrder();
        System.out.println("使用线索化的方式遍历线索二叉树==============");
        binaryTree2.threadList();

    }

    public static void printNums(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int[] getNumsByRondan(int len){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random()*len);//生成0-len的随机数
        }
        return arr;
    }
    //大顶堆 小顶堆排序 sort
    public static void teacherTest_4() {
        /****
         堆排序基本介绍
         堆排序是一个利用堆这种数据结构设计的一种排序算法,堆排序是一种选择排序
         时间复杂度O(nlogn)-不稳定排序
         堆是有一下性质的完全二叉树,每个节点的值都大于或等于左右孩子的值,左右孩子大小关系不要求
         每个节点的值都小于或等于左右孩子的值,称为小顶堆
         大顶堆举例说明
         *         50
         *       45  40
         *     20 25 35 30
         *    10 15
         对大顶堆进行按层编号  就是如下数组
         50 45 40 20 25 35 30 10 15   arr[i] >= arr[2*i+1]   arr[i] >= arr[2*i+2]
         小顶堆正好相反:

         1.将待排序序列构造成一个大顶堆
         2.此时,整个序列的最大值就是堆顶根节点
         3.将其与末尾元素进行交换,此时末尾就为最大值
         4.然后将剩余的n-1个数重新构造成一个堆,得到n个元素的次小值,如此反复执行,便能得到一个有序序列

         在构建大顶推的过程中,元素的个数逐渐减少,最后得到一个有序序列了
         升序采用大顶堆:
         原始数组 [4,6,8,5,9]
         无序序列结构如下
         *   4
         *  6 8
         * 5 9
         从最后一个非叶子节点:arr.length/2-1=5/2-1=1
         从左至右,上至下进行调整
         一直在操作数组,但是理解用二叉树图
         调整非叶子结点,

         2.将堆顶元素和末尾元素进行交换,得到一个
         *    9                 4
         *  6    8          6         8
         * 5 4       --->  5  9
         数组
         9 6 8 5 4          4 6 8 5 9
         调整4685
         将8和5交换   -->  564 89
         反复交换     -->   45689

         1.构建成一个堆
         2.堆顶和末尾元素交换 将最大元素沉 到数组末端 for循环就可以
         3.重新构建一个大顶推,满足要求就->2

         我的解释:是维护一个最大堆,当下一次交换的时候,还是可以维持一个最大堆,因为是冒泡,是两者之间立即交换

         */

        int arr[] = {4, 6, 8, 5, 9};
        //int arr[] = {4, 6, 8, 5, 9,-1,56,85,4};
        //int[] arr = getNumsByRondan(8000000);//8百万 韩顺平3秒 我3秒-2.7秒
        //System.out.println("排序前---"+ Arrays.toString(arr));
        long start = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("排序时间="+(end-start));
    }

    //编写一个堆排序的算法 ->关键代码:数组调整成大顶堆的过程
    public static void heapSort(int[] arr) {
        /***
         搞一个将一个数组(二叉树),调整成大顶堆 的方法
         4 6 8 5 9
         i = 1;{6}  ==>  adjustHeap 得到 4 9 8 5 6
         i = 0;{4}  ===> 9 6 8 5 4

         */
        System.out.println("堆排序-----------------------");
        //adjustHeap(arr,1,arr.length);
        //System.out.println("第一次:" + Arrays.toString(arr));
        //adjustHeap(arr,0,arr.length);
        //System.out.println("第二次:" + Arrays.toString(arr));//大顶堆了

        //完成的最终代码
        int temp = 0;
        for (int i = arr.length/2-1; i >= 0; i--) {//int i = arr.length/2-1 => 始终是最后一个非叶子节点  //这是在构造大顶堆
            adjustHeap(arr,i,arr.length);//先第一次找到最大值到堆顶,后面直接从0堆顶入手
        }

        //System.out.println("数组:" + Arrays.toString(arr));


        for (int j = arr.length-1; j >0; j--) {
            //交换
            temp = arr[j];
            arr[j]=arr[0];
            arr[0]=temp;

            adjustHeap(arr,0,j);
        }
        //System.out.println("数组:" + Arrays.toString(arr));
    }

    //把数组调整成大顶堆的方法
    public static void adjustHeap(int[] arr, int i, int lenght) {
        /***
         说明:
         arr: 待调整的数组
         i: 非叶子节点在数组的索引
         length: 对多少个元素进行调整 每次会减少1
         task: 将以i对应的非叶子节点的这个数调整成大顶堆
         */
        int temp = arr[i];//先取出当前元素的值,保存在临时变量
        //开始调整
        //k指向的是i节点的左子树
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {//说明左子节点的值小于右子节点的值 k+1<lenght防止无效 需要找一个最大值
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点 交换
                arr[i] = arr[k];//把比较大的赋值给当前节点
                i = k;//i到了新的一个坑
            } else {
                break;//为什么敢break? 是从左至右,从上至下的比较   说明把最大值放在了以i为父节点的最顶上 /下标i上
            }
        }

        arr[i] = temp;//将temp值放到调整后的尾椎
    }

    public static void main(String[] args) {
        //teachersTest();
        //teachersTest_2();
        //teachersTest_3();
        teacherTest_4();
    }
}


//定义ThreadedBinaryTree 实现了线索化功能的二叉树
class BinaryTree2 {
    private HeroNode2 root;

    //为了实现线索化,需要一个指向当前节点的前驱节点的指针
    private HeroNode2 pre = null;//保留前一个节点,在递归的时候

    public void setRoot(HeroNode2 root) {
        this.root = root;
    }

    public BinaryTree2(HeroNode2 root) {
        this.root = root;
    }

    public BinaryTree2() {

    }

    //遍历线索化二叉树的方法
    public void threadList() {
        //定义一个变量,存储当前遍历的节点
        HeroNode2 node = root;//root给node了,后面都用node
        while (node != null) {
            //循环找到lefttype == 1的节点,第一个找到的就是8节点
            //后面随着遍历而变化,因为当leftTYpe==1时,说明该节点是按照线索化的有效节点
            while (node.getLeftType() == 0) {//找叶子
                node = node.getLeft();
            }
            System.out.println(node);//打印这个节点
            //如果对当前节点的右指针指向的是后继节点,就一直输出
            while (node.getRightType() == 1) {//找后继
                //获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRight();//找下一个叶子
        }
    }

    //重载一个threadNodes方法 方便使用
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //编写对二叉树进行中序线索化的方法
    public void threadedNodes(HeroNode2 node) {
        //先判断 node就是当前需要献朵花的节点
        //如果node=null不能线索化
        if (node == null) {
            return;
        }
        //要有一个指针指向前驱结点,
        //1.先线索化左子树
        threadedNodes(node.getLeft());
        /****
         2.线索化当前节点
         比较麻烦,有点难度
         处理当前节点的前驱节点
         以8节点理解就是
         8号节点的lefttype=1  left指向null
         */

        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前左指针的类型
            node.setLeftType(1);
        }

        //处理后继节点 上一个节点right空 指向我
        if (pre != null && pre.getRight() == null) {//根节点没有前驱节点
            pre.setRight(node);
            pre.setRightType(1);
        }
        //！！！每处理一个节点,让当前节点是下一个节点的前驱节点
        pre = node;
        //3.线索化右子树
        threadedNodes(node.getRight());

    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root.toString() +
                '}';
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树不能删除");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树空");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树空");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树空");
        }
    }

    //前序查找
    public HeroNode2 preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode2 infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode2 postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

}

//测试线索化二叉树
class HeroNode2 {
    private int no;
    private String name;
    private HeroNode2 left;//默认空
    private HeroNode2 right;//默认空

    //left 0表示指向的是左子树,1表示表示指向前驱节点
    //right 0表示指向右子树   1表示指向后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);
        //递归向左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //编写中序遍历的方法
    public void infixOrder() {

        //递归向左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        //递归向右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //编写后序遍历的方法
    public void postOrder() {

        //递归向左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找   判断 左 右
    public HeroNode2 preOrderSearch(int no) {
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        } else {

            //定义一个变量
            HeroNode2 resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrderSearch(no);
            }
            if (resNode != null) {//说明左子树找到了
                return resNode;
            }
            if (this.right != null) {
                resNode = this.right.preOrderSearch(no);
            }

            return resNode;
        }

        //return null;
    }

    //中序遍历查找
    public HeroNode2 infixOrderSearch(int no) {
        /***
         左 判断中 右
         */
        HeroNode2 resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //和当前节点比较,空则就右
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;//不用判空 没找到会保持null
    }

    //后序遍历查找
    public HeroNode2 postOrderSearch(int no) {
        //判断 左 右 判断根当前
        HeroNode2 resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //如果没找到进行向右递归遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }

        return resNode;
    }

    //删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        //需要向左子树   右子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }

        if (this.right != null) {
            this.right.delNode(no);
        }

    }


}


//编写一个类,实现顺序存储二叉树遍历
class ArrBinaryTree {
    private int[] arr;//存储数据的数组,存储数据节点的数组

    public ArrBinaryTree(int[] arr) {//将数组传递
        this.arr = arr;
    }

    //重载preOrder方法  做一个默认0
    public void preOrder() {
        preOrder(0);
    }

    //编写一个方法,完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {//数组的下标
        //如果数组为空,或者arr.lenght=0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,不能前序遍历!");
        }
        //输出当前这个元素
        System.out.print(arr[index] + " ");
        //向左递归遍历
        if (index * 2 + 1 < arr.length) {//如果大于的话.就是没有节点
            preOrder(2 * index + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrder(2 * index + 2);
        }

    }
}

//定义一个BinaryTree 二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root.toString() +
                '}';
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树不能删除");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树空");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树空");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树空");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;//默认空
    private HeroNode right;//默认空

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder() {
        System.out.println(this);
        //递归向左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //编写中序遍历的方法
    public void infixOrder() {

        //递归向左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        //递归向右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //编写后序遍历的方法
    public void postOrder() {

        //递归向左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找   判断 左 右
    public HeroNode preOrderSearch(int no) {
        //比较当前节点是不是
        if (this.no == no) {
            return this;
        } else {

            //定义一个变量
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrderSearch(no);
            }
            if (resNode != null) {//说明左子树找到了
                return resNode;
            }
            if (this.right != null) {
                resNode = this.right.preOrderSearch(no);
            }

            return resNode;
        }

        //return null;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        /***
         左 判断中 右
         */
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //和当前节点比较,空则就右
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;//不用判空 没找到会保持null
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        //判断 左 右 判断根当前
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //如果没找到进行向右递归遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }

        return resNode;
    }

    //删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        //需要向左子树   右子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }

        if (this.right != null) {
            this.right.delNode(no);
        }

    }


}
