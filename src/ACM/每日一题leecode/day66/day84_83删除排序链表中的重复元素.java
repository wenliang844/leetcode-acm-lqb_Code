package ACM.每日一题leecode.day66;

import java.util.LinkedList;
import java.util.Stack;

/***
 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 返回同样按升序排列的结果链表。
 输入：head = [1,1,2]
 输出：[1,2]
 */
public class day84_83删除排序链表中的重复元素 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        //System.out.println(head);
        //给两个节点,如果p1 = p2 p2=p2.next flag=true--->   p1!=p2 p1.nect=p2 p2=p2.nect flag=false
        //直接判断两个节点是否相等,相等就直接跳过一个,删除一个就是,不相等就都王前进一步
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1 = head;
        p2=head.next;
        boolean flag = false;
        while (p2!=null){
            /*if (p1.val == p2.val){
                flag = true;
            }
            if (flag){
                if (p1.val != p2.val){
                    p1.next = p2;
                    flag = false;
                }
            }
            p2 = p2.next;*/

            if (p1.val == p2.val){
                p2=p2.next;
                p1.next = p2;
            }else {
                p2 = p2.next;
                p1 = p1.next;
            }
        }

        //System.out.println(head);
        return head;
    }

    //方法二:栈
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null){
            return null;
        }

        Stack<ListNode> stack = new Stack<>();


        ListNode p1 = new ListNode();
        stack.add(head);
        p1 = head.next;
        while (p1!=null){
            if (p1.val == stack.peek().val){
                p1 = p1.next;
            }else {
                stack.peek().next = p1.next;
                stack.add(p1);
                p1=p1.next;
            }
        }

        //System.out.println(head);
        return head;
    }

    public static void main(String[] args) {//1,1,1,2,2,3,4,5,5,6,7,7
        System.out.println(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4)))))))))));
        System.out.println(deleteDuplicates(null));
    }

    //Definition for singly-linked list.
    public static class ListNode {
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
