package 数据结构算法教程.java数据结构算法.第2节_链表;
/*
约瑟夫环问题:
//用数组取模也可以实现,但是没有环形链表折磨形象;
    经典:使用循环链表解决 收尾相连的环形链表 可以带头节点   也可以不
    first不能动,所以用一个cur指向最后元素, next指向插入的hero  hero指向first
    1.先创建第一个节点,让first指向这个节点,形成一个环形 first.next = first
    2.后面没创建一个节点,把该节点,加入到已有的环形链表中即可

    3.遍历环形链表,让一个辅助变量指向first 一个while循环遍历这个环形链表curboy
        什么时候是终止条件 cur.next == first   就结束了 ==就是比较内存指针的
 */
public class MyCricleLinedListDemo {
    public static void test1(){
        CricleLinedList nodeList = new CricleLinedList();
        System.out.println(nodeList.getNode());
        CricleLinked hero2 = new CricleLinked(2);
        CricleLinked hero3 = new CricleLinked(3);
        CricleLinked hero4 = new CricleLinked(4);
        CricleLinked hero5 = new CricleLinked(5);
        nodeList.add(hero2);
        nodeList.add(hero3);
        nodeList.add(hero4);
        nodeList.add(hero5);
        nodeList.list();
    }


    public static void main(String[] args) {
        test1();
    }
}
class CricleLinedList{
    private CricleLinked node = new CricleLinked(1);

    public  CricleLinked getNode(){
        return node; //开始的节点
    }
    public void add(CricleLinked hero){
        if (node.next==null){
            node.next=hero;
            hero.next=node;
            return;
        }
        CricleLinked cur = node.next;
        while (cur.next.data!=node.data){//cur.next!=null &&
            cur=cur.next;
        }
        System.out.println("这是要加入的最后的cur:"+cur.data);
        cur.next=hero;
        hero.next=node;
    }

    public void list(){
        System.out.println("这是第一个节点--:"+node.data);
/*        System.out.println(node.next);
        System.out.println(node.next.next);
        System.out.println(node.next.next.next);
        System.out.println(node.next.next.next.next);*/
        CricleLinked cur = node.next;
        while (cur!=null && cur.next.data!=node.data){
            System.out.println(cur);
            cur=cur.next;
        }
        System.out.println(cur);
    }
}
class CricleLinked{
    int data;
    CricleLinked next;

    public CricleLinked(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CricleLinked{" +
                "data=" + data +
                '}';
    }
}


