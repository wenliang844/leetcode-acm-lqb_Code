package ACM.tag刷题.数据结构.链表;

public class link_19删除链表的倒数第N个结点 {
    /***
     给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     进阶：你能尝试使用一趟扫描实现吗？
     **/

    //方法一:两趟扫描 100 91
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        //第一趟扫描:知道有几个节点
        ListNode p = head;
        int count = 0;
        while (p!=null){
            count++;
            p=p.next;
        }
        //System.out.println("链表的个数是"+count);
        //System.out.println("我需要将第几个删除"+(count-n));
        //if (count==1)return null;
        //删除的是自己
        if (n==count)return head.next;
        p=head;
        count = count-n;
        while (count-- >1){
            p=p.next;
        }
        //System.out.println(p);
        //将这个节点下一个节点删除
        //判断一下p.next是不是空
        /*if (p==head){//删除的是自己
            return head.next;
        }*/
        p.next=p.next.next;

        return head;
    }
    //在head前面加一个虚拟节点,就不要特殊判断了

    //方法二:栈
    //方法三:双指针,块慢指针 --- 指针之间差距是n个距离

    public static void main(String[] args) {
        //System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        //System.out.println(removeNthFromEnd(new ListNode(1), 1));
        System.out.println(removeNthFromEnd(new ListNode(1,new ListNode(2)), 2));
        System.out.println(removeNthFromEnd(new ListNode(1,new ListNode(2)), 1));
    }

}
