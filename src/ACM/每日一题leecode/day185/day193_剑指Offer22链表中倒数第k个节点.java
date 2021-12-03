package ACM.每日一题leecode.day185;

public class day193_剑指Offer22链表中倒数第k个节点 {
    //给定一个链表: 1->2->3->4->5, 和 k = 2.   返回链表 4->5.

    //方法一:直接遍历一遍求长度,用len - k再遍历一遍即可   100 46
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = new ListNode();
        p = head;
        int len = 0;
        while (p.next!=null){p=p.next;len++;}

        p=head;
        len = len-k;
        while (len-- >=0){
            p=p.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4 , new ListNode(5)))));
        System.out.println(getKthFromEnd(head, 2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }
        ListNode(int x) {
            val = x;
        }

        ListNode(int x,ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
