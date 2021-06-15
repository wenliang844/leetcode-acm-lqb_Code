package ACM.tag刷题.数据结构.链表;

public class link_206反转链表 {
    /***
     输入: 1->2->3->4->5->NULL
     输出: 5->4->3->2->1->NULL
     */
    //方法一:新定义一个头结点,扫描一遍 100 74
    public static ListNode reverseList(ListNode head) {
        //判空
        if (head==null)return null;
        if (head.next==null)return head;
        ListNode p = new ListNode(head.val);
        ListNode cur = head.next;
        while (cur!=null){
            ListNode temp = new ListNode(cur.val);
            temp.next=p;
            p=temp;
            cur = cur.next;
        }

        return p;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        System.out.println(reverseList(head));
        //head4.next=head2;
        //System.out.println(reverseList(head).val);
    }
}
