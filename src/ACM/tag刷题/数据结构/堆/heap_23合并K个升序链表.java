package ACM.tag刷题.数据结构.堆;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 给你一个链表数组，每个链表都已经按升序排列。
 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 示例 1：
 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 输出：[1,1,2,3,4,4,5,6]
 解释：链表数组如下：
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 将它们合并到一个有序链表中得到。
 1->1->2->3->4->4->5->6
 */
public class heap_23合并K个升序链表 {

    /**
     思路:
     方法一:顺序合并
     方法二:归并合并  每次合并两个 二分 两个的和两个的继续合并
     方法三:优先队列
     * @param lists
     * @return
     */
    //方法一:直接用一个list排序,在直接ListNode一个装进去
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode p = new ListNode();
            p = lists[i];

            while (p != null) {
                list.add(p.val);
                p = p.next;
            }
        }
        Collections.sort(list);
        System.out.println(list);

        ListNode head = new ListNode();
        ListNode p = new ListNode();
        head = p;
        for (Integer integer : list) {
            ListNode tmp = new ListNode(integer);
            p.next = tmp;
            p=p.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]      1->1->2->3->4->4->5->6
        System.out.println(mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        }));
    }


    //Definition for singly-linked list.
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
