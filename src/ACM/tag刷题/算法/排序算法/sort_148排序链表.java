package ACM.tag刷题.算法.排序算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sort_148排序链表 {
    /***
     给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     进阶：
     你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     输入：head = [4,2,1,3]
     输出：[1,2,3,4]
     */
    //方法一:直接用一个list接收 排序,构造另一个node
    public static ListNode sortList(ListNode head) {
        //System.out.println("元数组"+head);
        List<Integer> list = new ArrayList<>();
        ListNode p1 = new ListNode();
        p1 = head;
        while (p1 != null) {
            list.add(p1.val);
            p1 = p1.next;
        }
        //System.out.println("这是lsit"+list);

        //排序后装载
        Collections.sort(list);
        ListNode newHead = new ListNode();
        p1 = newHead;
        for (Integer integer : list) {
            ListNode tmp = new ListNode(integer);
            p1.next = tmp;
            p1 = p1.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        System.out.println(sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))))));
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

    /***
     官方推荐:归并排序
     class Solution {
     public ListNode sortList(ListNode head) {
     return sortList(head, null);
     }

     public ListNode sortList(ListNode head, ListNode tail) {
     if (head == null) {
     return head;
     }
     if (head.next == tail) {
     head.next = null;
     return head;
     }
     ListNode slow = head, fast = head;
     while (fast != tail) {
     slow = slow.next;
     fast = fast.next;
     if (fast != tail) {
     fast = fast.next;
     }
     }
     ListNode mid = slow;
     ListNode list1 = sortList(head, mid);
     ListNode list2 = sortList(mid, tail);
     ListNode sorted = merge(list1, list2);
     return sorted;
     }

     public ListNode merge(ListNode head1, ListNode head2) {
     ListNode dummyHead = new ListNode(0);
     ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
     while (temp1 != null && temp2 != null) {
     if (temp1.val <= temp2.val) {
     temp.next = temp1;
     temp1 = temp1.next;
     } else {
     temp.next = temp2;
     temp2 = temp2.next;
     }
     temp = temp.next;
     }
     if (temp1 != null) {
     temp.next = temp1;
     } else if (temp2 != null) {
     temp.next = temp2;
     }
     return dummyHead.next;
     }
     }

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}

