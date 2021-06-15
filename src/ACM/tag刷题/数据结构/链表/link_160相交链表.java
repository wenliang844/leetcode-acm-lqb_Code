package ACM.tag刷题.数据结构.链表;

import java.util.HashMap;
import java.util.Map;

public class link_160相交链表 {
    /***
     编写一个程序，找到两个单链表相交的起始节点。
     */
    //并查集,哈希表 两个链表过一遍,第一个相交的就是 14 5
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Character> map = new HashMap<>();
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1!=null){
            map.put(cur1,'a');
            cur1=cur1.next;
        }
        while (cur2!=null){
            if (map.get(cur2)!=null){
                return cur2;
            }
            cur2=cur2.next;
        }
        return null;
    }

    /**
     方法三：双指针法
     创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     当 pApA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。
     想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，pBpB 比 pApA 少经过 22 个结点，会先到达尾部。将 pBpB 重定向到 A 的头结点，pApA 重定向到 B 的头结点后，pBpB 要比 pApA 多走 2 个结点。因此，它们会同时到达交点。
     如果两个链表存在相交，它们末尾的结点必然相同。因此当 pApA/pBpB 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(5);
        ListNode head4 = new ListNode(6);
        head.next=head2;
        head4=head2;
        head2.next=head3;
        System.out.println(getIntersectionNode(head,head4));//4
    }
}
