package ACM.每日一题leecode.day66;

import java.util.Arrays;

public class day76_92反转链表II {

    /****
     给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     示例 1：
     输入：head = [1,2,3,4,5], left = 2, right = 4
     输出：[1,4,3,2,5]
     */


    //思路:用一个数组存放left-right的数,在left开始,直接反着赋值   两趟
    //假定头结点没有值
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode p1 ;
        ListNode p2 ;
        p1 = head;
        //定位p1到指定位置
        for (int i = 1; i <= left; i++) {
            p1 = p1.next;
        }

        //System.out.println(p1);
        p2 = p1;
        //从p1开始,进行遍历到right,用一个数组保存
        int[] temp = new int[right-left+1];
        for (int i = 0; i <= right - left; i++) {
            temp[i] = p1.val;
            p1=p1.next;
        }
        //System.out.println(Arrays.toString(temp));
        //System.out.println(p2);
        for (int i = right-left; i >=0 ; i--) {
            //System.out.println(p2.val);
            p2.val = temp[i];
            p2=p2.next;
        }
        //System.out.println(head);
        return head;
    }

    //头结点有值
    public static ListNode reverseBetween2(ListNode head, int left, int right) {

        ListNode p1 ;
        ListNode p2 ;
        p1 = head;
        //定位p1到指定位置
        for (int i = 1; i < left; i++) {
            p1 = p1.next;
        }

        //System.out.println(p1);
        p2 = p1;
        //从p1开始,进行遍历到right,用一个数组保存
        int[] temp = new int[right-left+1];
        for (int i = 0; i <= right - left; i++) {
            temp[i] = p1.val;
            p1=p1.next;
        }
        //System.out.println(Arrays.toString(temp));
        //System.out.println(p2);
        for (int i = right-left; i >=0 ; i--) {
            //System.out.println(p2.val);
            p2.val = temp[i];
            p2=p2.next;
        }
        //System.out.println(head);
        return head;
    }

    //1.用栈
    //2.穿针引线法
    public static void main(String[] args) {
        //ListNode head = new ListNode();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        //head.next = listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;

        /*ListNode p3 = new ListNode();
        p3=head.next;
        p3.val=100;
        ListNode p4 = new ListNode();
        p4=p3;
        p4.val=90;
        System.out.println(head);
        */
        System.out.println(reverseBetween2(listNode1,2,4));


    }
}

//Definition for singly-linked list.
class ListNode {
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