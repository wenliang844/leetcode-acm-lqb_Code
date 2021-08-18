package 数据结构算法教程.java数据结构算法.第2节_链表;

import java.util.Stack;

/*
添加
按照编号添加
思路分析示意图 excel
增删改查:基础最重要
思路:分析示意图:
修改节点的代码实现:
    思路简单:
    1.先找到这个节点 通过while遍历 通过:temp.name=new.name
    2.删除节点:temp.next=temp.next.next 删除的会被回收机制回收
    3.单链表的新浪面试题:5道

        1.求单链表的节点个数 遍历计数即可
        2.反转单链表: reverse
            方法1. 第一个和最后一个值互换,指针位置不换 以此来推
            方法2: 定义一个新head节点,把旧的遍历,插入到新head的头部
        3.百度面试题"从尾到头打印单链表;
            方法1:reverse
            方法2:stack打印  先进后出{尝试} srack<模板 泛型>
        4.合并两个单链表,合并之后依然有序
            head1 head2的合并  把head1保留;遍历head2 每个cur进行有序插入;
            创键一个新的链表,发现哪个链表的no编号更小,就加入这个新的链表head3
 */
public class LinklistDemo {

    public static void testLinked1(){
        /*
    第2节_链表:
    分有头结点的  无头节点的链表
    内存不是连续的,只是存储了下一个链表的指针

    用链表管理水浒传的英雄人物的增删查改;

     */

        Linklist list1 = new Linklist(1);
        Linklist list2 = new Linklist(2);
        Linklist list3 = new Linklist(3);
        list1.next = list2;
        list2.next = list3;
        list1.showLinkList();//谁调用我 我就是谁

        //进行一个测试,先创建以节点
        HeroNode hero1 = new HeroNode(1, "送江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "王麒麟");
        HeroNode hero3 = new HeroNode(3, "无用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(7, "777", "777");
        HeroNode hero6 = new HeroNode(6, "666", "666");

        SingeLinkedList singeLinkedList = new SingeLinkedList();
        //加入
        singeLinkedList.addNode(hero1);
        singeLinkedList.addNode(hero2);
        singeLinkedList.addNodeByOrder(hero3);
        singeLinkedList.addNodeByOrder(hero4);
        singeLinkedList.addNodeByOrder(hero5);
        singeLinkedList.addNodeByOrder(hero6);
        singeLinkedList.list();

        /*System.out.println("增加后---");
        HeroNode hero7 = new HeroNode(5, "陈文亮", "大神");
        singeLinkedList.update(hero7);
        singeLinkedList.list();*/

        /*System.out.println("删除后---");
        singeLinkedList.deleteByNo(1);
        singeLinkedList.list();
        System.out.println("有效节点个数是:"+getLength(singeLinkedList.getHead()));*/

        //测试
       /* HeroNode lastNode = findLastNode(singeLinkedList.getHead(), 1);
        System.out.println(lastNode);//测试成功*/

        System.out.println("测试反转后------");
        reverse(singeLinkedList.getHead());
        singeLinkedList.list();

        System.out.println("测试百度面试题逆序打印----");
        reversePrintByStack(singeLinkedList.getHead());
    }

    public static void main(String[] args) {
        testLinked1();

    }

    public static void reversePrintByStack(HeroNode head){
        /*
        推荐使用,避免破坏原链表的使用和结构
         */
        if (head.next==null)return;
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur!=null){
            stack.add(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    public static void reverse(HeroNode head){
        /*
        1.先创建一个节点;取名为reverse
        2.遍历原来的head,取出每一个节点 放到reverse的前面
            cur.next=reverce.next;
            reverse.next=cur
        3.把head.next 指向reverse的nect   告诉思路就觉得简单 不告诉就觉得难
         */

        //为空直接退出
        if (head.next==null || head.next.next==null){
            return;
        }
        //SingeLinkedList reverse = new SingeLinkedList();
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = head.next;//这个指针遍历原先的链表
        HeroNode next = null;//这个指针指向当前节点的下一个节点
        while (cur!=null){
            next=cur.next;//把cur的下一个节点保存下来,以备使用
            cur.next=reverseHead.next;
            reverseHead.next=cur;//将reverseHead连接到cur
            cur = next;
        }
        //连接head.next 指向reverseHead.nect//实现反转
        head.next = reverseHead.next;
    }
    public static void reverserLinked(HeroNode head){
        //HeroNode last = findLastNode(head,1);
        int size = getLength(head);
        System.out.println("这是长度:"+size);
        HeroNode cur = head.next;
        for (int i = 1; i <= size/2; i++) {
            HeroNode last = findLastNode(head,i);//只要将值替换即可,位置不变
            System.out.println("修改了："+cur+last);

            String name = cur.name;
            String nickName =cur.nickName;
            int no = cur.no;
            cur.name=last.name;
            cur.nickName=last.nickName;
            cur.no=last.no;
            last.name=name;
            last.nickName=nickName;
            last.no=no;
            cur = cur.next;
        }
    }
    public static HeroNode findLastNode(HeroNode head,int index){
        //查找单链表中的倒数第K个节点[新浪面试题]
    /*
    思路: 1.编写一个方法,接收head节点,同时接收一个index(倒数第index个节点)
            2.得到总的长度;然后遍历size-index个就可以了
     */
    //判断如果链表为空,就返回null
        if (head.next ==null){
            return null;//没有找到
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历到size-index个位置,就是我们倒数地k节点
        //先做一个size的校验 不可以找小于0的,大于size的
        if (index<=0||index>size){
            return null;
        }
        //定义辅助变量,for循环定位到倒数index
        HeroNode cur = head.next;//3个  找倒数第一个  移动两下   3-1=2  0 1
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }
    public static int getLength(HeroNode head){
        /**
         * head就是链表的头结点
         * return返回链表的长度
          */
        if (head.next==null){
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur!=null){
            length++;
            cur=cur.next;//进行遍历
        }
        return length;
    }

}



//SingeLinkedList 定义一个头结点 管理我们的英雄 头结点永远在最前面
class SingeLinkedList{

    /*
    head头节点  不存放数据 就是via表示单链表的头next
    HeroNode:数据 next节点   next==null就是最后一个链表了

    添加(创建)
        1.创建一个head头结点  表示单链表的头
        2.后面每次添加一个节点,直接加入到链表的最后
        遍历:
            1.通过一个辅助遍历,帮助遍历整个单链表
    */


    //先初始化一个头结点 不可以动 ----不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点的方法 添加到最后节点
    //当不考虑编号的循序,找到当前链表的最后一个节点  next指向新的节点
    //按照排名添加 代码实现
    public void addNode(HeroNode heroNode){
        //因为head不能动,因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后,就将temp后移
            temp=temp.next;
        }
        //当退出while循环的时候,temp就指向了最后
        temp.next = heroNode;
    }

    //第二种添加英雄的方式 插入指定的位置
    public void addNodeByOrder(HeroNode heroNode){
        //应为头结点不能动 只能临时指针
        //找的temp是添加位置的前一个节点 因为后面的指针才能找到
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在,默认为false
        while(true){
            if (temp.next == null){//说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no){//位置找到了,就在temp的后面  就在temp添加
                break;
            }else if (temp.next.no == heroNode.no){//存在了
                flag = true;//编号存在
                break;
            }

            temp = temp.next;//后移,相当于遍历链表
        }
        if (flag){
            System.out.println("已经存在这个编号了,不能在添加了呢!!!"+heroNode.no);
        }else {//temp的后面进行插入heroNode
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public  void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next==null){
            System.out.println("链表为空 不能更新");
            return;
        }
        //找到需要修改的节点  根据no编号
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp==null){
                break;//到了链表的底部 已经遍历完成了,还是没有找到
            }
            if (temp.no == newHeroNode.no){
                flag = true;//找到了这个节点  退出
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag){
            temp.name=newHeroNode.name;
            temp.nickName=newHeroNode.nickName;
        }else{
            System.out.println("不能修改 没有找到编号"+newHeroNode.no);
        }
    }

    public  void deleteByNo(int no){
        //判断是否为空
        if (head.next==null){
            System.out.println("链表为空 不能更新");
            return;
        }
        //找到需要修改的节点  根据no编号
        HeroNode temp = head.next;
        boolean flag = false;//标识是否找到前一个节点
        while (true){
            if (temp==null){
                break;//到了链表的底部 已经遍历完成了,还是没有找到
            }
            if (temp.no == no){
                flag = true;//找到了这个节点  退出
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要删除的节点
        //被删除的节点会被垃圾回收机制回收
        if (flag){
            temp.next=temp.next.next;//temp.next会自动被回收
        }else{
            System.out.println("不能delete没有找到编号"+no);
        }
    }

    //显示链表
    public void list(){
        //通过一个辅助变量遍历链表 head不能动
        //判断链表是佛为空,为空就不用遍历,直接退出return
        if (head.next==null){
            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            //判断是否到达链表的最后
            if (temp==null){
                break;
            }
            System.out.println(temp);
            //将nect后移
            temp = temp.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }
}
class HeroNode {
    int no;//序号
    String name;//名字
    String nickName;//昵称
    HeroNode next;//执向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


class Linklist {

    int data;
    Linklist next;

    public Linklist(int data) {
        this.data = data;
    }

    public void showLinkList() {
        Linklist list = this;
        while (list != null) {
            System.out.println(list.data);
            list = list.next;
        }
    }


}
