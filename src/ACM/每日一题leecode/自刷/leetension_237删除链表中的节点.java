package ACM.每日一题leecode.自刷;

public class leetension_237删除链表中的节点 {
    /***
     请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     */
    //不知道头结点,使用覆盖法: node = node.next 100 47
    public static void deleteNode(ListNode node) {
       /* node.val = node.next.val;
        while (node.next.next != null) {
            node.next.val = node.next.next.val;
            node = node.next;
        }
        node.next=null;*/
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4,new ListNode(5,new ListNode(1,new ListNode(9))));
        deleteNode(root);
        System.out.println(root);
    }
}
