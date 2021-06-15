package ACM.每日一题leecode.day32;

public class day34_86分隔链表 {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        /*ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);*/

        int[] arr = {1, 4, 3, 2, 5, 2};
        //int[] arr = {1};
        ListNode p = head;
        p.val=arr[0];
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            p.next = node;
            p = p.next;
        }
        System.out.println(head);
        System.out.println(partition_2(head,2));

    }

    //head为空
    public static ListNode partition(ListNode head, int x) {

        /***
         思路:
         定义两个listNode head1
                listNode head2
         遍历head 小于3的就挂载head1上
                   大于等于3挂head2上
         合并head1前 head2后 -->head
         */
        if (head==null){
            return head;
        }

        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode p = head;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p.next!=null){
            p=p.next;
            if (p.val<x){
                p1.next=p;
                p1=p1.next;
            }else {
                p2.next=p;
                p2=p2.next;
            }
        }
        p1.next=null;
        p2.next=null;
        head.next=null;
        System.out.println("这是head1:"+head1);
        System.out.println("这是head2:"+head2);

        head.next=head1.next;
        ListNode p3 = head;
        while (p3.next!=null)p3=p3.next;
        p3.next=head2.next;

        return head;
    }

    //head有值
    public static ListNode partition_2(ListNode head, int x) {

        /***
         思路:
         定义两个listNode head1
                listNode head2
         遍历head 小于3的就挂载head1上
                   大于等于3挂head2上
         合并head1前 head2后 -->head

         * 维护两个链表，一个所有值小于x，一个所有值大于等于x，
         * 遍历原始链表，当值小于x时。curLess指向该节点，
         * 当值大于等于x时，curGreater指向该节点。
         */
        if (head==null){
            return head;
        }

        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (head!=null){
            if (head.val<x){
                p1.next=head;
                head=head.next;
                p1=p1.next;
                p1.next=null;
            }else {
                p2.next=head;
                head=head.next;
                p2=p2.next;
                p2.next=null;
            }
        }
        p1.next=head2.next;

        return head1.next;
    }


}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

   /* ListNode() {
    }*/

    @Override
    public String toString() {
        return val + "-> " + next + '}';
    }
}