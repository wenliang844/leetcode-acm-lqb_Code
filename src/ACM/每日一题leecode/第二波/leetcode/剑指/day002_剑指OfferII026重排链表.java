package ACM.每日一题leecode.第二波.leetcode.剑指;

/**
 * @author 陈文亮
 * @date 2022/12/15 15:22
 */
public class day002_剑指OfferII026重排链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        reorderList(head);
        System.out.println(head);
    }
    public static void reorderList(ListNode head) {
        ListNode p1 = head;
        while (p1!=null && p1.next!=null && p1.next.next!=null){
            ListNode p2 = p1;
            while (p2.next.next!=null){
                p2 = p2.next;
            }

            p2.next.next = p1.next;
            p1.next = p2.next;
            p1=p2.next.next;
            p2.next=null;

            System.out.println(head);
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
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
