package ACM.每日一题leecode.day185;

public class day209_725分隔链表 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0,new ListNode(1,new  ListNode(2,new ListNode(3))));
        splitListToParts(node,5);

    }

    public static ListNode[] splitListToParts(ListNode head, int k) {

        return null;
    }


     //Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
