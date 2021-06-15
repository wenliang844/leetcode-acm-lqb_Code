package ACM.tag刷题.数据结构.链表;

import java.util.ArrayList;
import java.util.List;

public class link_234回文链表 {
    /**
     * 请判断一个链表是否为回文链表。
     */
    //方法一:转成数组判断 22 20
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        //if (head.next==null)return true;//不是特殊情况
        //用字符串?万一是大数呢?
        //用list
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /****
     class Solution {
     private ListNode frontPointer;

     private boolean recursivelyCheck(ListNode currentNode) {
     if (currentNode != null) {
     if (!recursivelyCheck(currentNode.next)) {
     return false;
     }
     if (currentNode.val != frontPointer.val) {
     return false;
     }
     frontPointer = frontPointer.next;
     }
     return true;
     }

     public boolean isPalindrome(ListNode head) {
     frontPointer = head;
     return recursivelyCheck(head);
     }
     }*/
    //方法二:快慢指针:

    /****
     public boolean isPalindrome(ListNode head) {
     if (head == null) {
     return true;
     }

     // 找到前半部分链表的尾节点并反转后半部分链表
     ListNode firstHalfEnd = endOfFirstHalf(head);
     ListNode secondHalfStart = reverseList(firstHalfEnd.next);

     // 判断是否回文
     ListNode p1 = head;
     ListNode p2 = secondHalfStart;
     boolean result = true;
     while (result && p2 != null) {
     if (p1.val != p2.val) {
     result = false;
     }
     p1 = p1.next;
     p2 = p2.next;
     }

     // 还原链表并返回结果
     firstHalfEnd.next = reverseList(secondHalfStart);
     return result;
     }

     private ListNode reverseList(ListNode head) {
     ListNode prev = null;
     ListNode curr = head;
     while (curr != null) {
     ListNode nextTemp = curr.next;
     curr.next = prev;
     prev = curr;
     curr = nextTemp;
     }
     return prev;
     }

     private ListNode endOfFirstHalf(ListNode head) {
     ListNode fast = head;
     ListNode slow = head;
     while (fast.next != null && fast.next.next != null) {
     fast = fast.next.next;
     slow = slow.next;
     }
     return slow;
     }
     */
    public static boolean isPalindrome2(ListNode head) {

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
    }
}
