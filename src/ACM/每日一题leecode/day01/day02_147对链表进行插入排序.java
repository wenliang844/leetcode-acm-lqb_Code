package ACM.每日一题leecode.day01;
/*

插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 

示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insertion-sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 */
public class day02_147对链表进行插入排序 {
    public static ListNode insertionSortList(ListNode head) {
        ListNode p = head;
        while (p!=null){
            System.out.println(p.val);
            p = p.next;
        }

        ListNode p1 = head.next;
        ListNode p2 = head;
        ListNode temp = null;
        ListNode p3 = null;

        while (p1!=null){
            while (p2!=p1){
                if (p2.val>p1.val){
                    temp = p1;
                    p3=p2.next;
                    int a = p3.val;
                    p3.val=p2.val;
                    int b;

                    while (p3!=p2){
                        p3=p3.next;
                         b = a;
                        a=p3.val;
                        p3.val=b;
                    }
                    break;
                }
                p2=p2.next;
            }
            p1=p1.next;
        }

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(1);
        ListNode list4 = new ListNode(3);
        list3.next=list4;
        list2.next=list3;
        head.next=list2;

        ListNode p = head;
        while (p!=null){
            System.out.println(p.val);
            p = p.next;
        }

        head = insertionSortList(head);

        p = head;
        while (p!=null){
            System.out.println(p.val);
            p = p.next;
        }

    }
}
