package ACM.每日一题leecode.day141;

import java.util.HashMap;
import java.util.Map;

public class day147_160相交链表 {
    //  7 11
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //使用hashmap
        Map<ListNode,ListNode> map = new HashMap<>();
        //遍历第一个head 将他们映射为root1
        ListNode cur1 = headA;
        while (cur1!=null){
            map.put(cur1,headA);
            cur1 = cur1.next;
        }
        //遍历第二个节点,第一个在map中映射是root1的就是第一个相交的节点
        ListNode cur2 = headB;
        while (cur2!=null){
            if (map.get(cur2)==headA){
                return cur2;
            }
            cur2=cur2.next;
        }
        return null;

        /**
         if (headA == null || headB == null) {
         return null;
         }
         ListNode pA = headA, pB = headB;
         while (pA != pB) {
         pA = pA == null ? headB : pA.next;
         pB = pB == null ? headA : pB.next;
         }
         return pA;

         */
    }

    public static void main(String[] args) {
        //4,1,%8,4,5  5,0,1,%8,4,5
        ListNode root1 = new ListNode(4,new ListNode(1));
        ListNode root2 = new ListNode(5,new ListNode(0,new ListNode(1)));
        ListNode center = new ListNode(8);
        center.next=new ListNode(4,new ListNode(5));
        root1.next=center;
        root2.next=center;
        System.out.println(getIntersectionNode(root1, root2).val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x,ListNode next) {
            val = x;
            this.next = next;
        }

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode() {

        }
    }
}
