package ACM.每日一题leecode.day141;

import java.util.List;

public class day148_203移除链表元素 {
    public static void main(String[] args) {
        System.out.println(removeElements(new ListNode(1, new ListNode(2, new ListNode(3))),1));
    }

    //99 36
    public static ListNode removeElements(ListNode head, int val) {
        System.out.println(head);
        ListNode root = new ListNode();
        root.next = head;
        ListNode pre = root;
        ListNode cur = pre.next;
        while (cur!=null){
            if (cur.val == val){
                pre.next = cur.next;
                cur=pre.next;
            }else {
                pre=cur;
                cur=pre.next;
            }
        }

        return root.next;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode() {

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
