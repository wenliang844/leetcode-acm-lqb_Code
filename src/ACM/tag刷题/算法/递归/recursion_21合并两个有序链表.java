package ACM.tag刷题.算法.递归;

import java.util.List;

public class recursion_21合并两个有序链表 {
    /***
     * 方法一：递归
     * 思路
     *
     * 我们可以如下递归地定义两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
     *
     * \left\{ \begin{array}{ll} list1[0] + merge(list1[1:], list2) & list1[0] < list2[0] \\ list2[0] + merge(list1, list2[1:]) & otherwise \end{array} \right.
     * {
     * list1[0]+merge(list1[1:],list2)
     * list2[0]+merge(list1,list2[1:])
     * ​
     *
     * list1[0]<list2[0]
     * otherwise


     将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     **/
    //方法一:双指针+伪头节点 100 24
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1=l1;
        p2=l2;
        while (p1!=null &&p2!=null){//一视同仁
            if (p1.val<=p2.val){//连接p1 优先
                ListNode temp = p1;
                p1=p1.next;
                cur.next=temp;
                cur=cur.next;
            }else {
                ListNode temp = p2;
                p2=p2.next;
                cur.next=temp;
                cur=cur.next;
            }
        }
        if (p1!=null){
            cur.next=p1;
        }
        if (p2!=null){
            cur.next=p2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode listNode2= new ListNode(1,new ListNode(3,new ListNode(4)));
        System.out.println(mergeTwoLists(listNode1, listNode2));
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
