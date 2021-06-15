package ACM.tag刷题.数据结构.链表;

import java.util.HashMap;
import java.util.Map;

public class link_141环形链表 {
    /****
     给定一个链表，判断链表中是否有环。
     如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     如果链表中存在环，则返回 true 。 否则，返回 false 。

     进阶：
     你能用 O(1)（即，常量）内存解决此问题吗？
     输入：head = [3,2,0,-4], pos = 1
     输出：true
     解释：链表中有一个环，其尾部连接到第二个节点。
     */
    //方案一:并差集,用map,把每一个的祖先设置为head节点,如果后面有新节点的祖先是head节点,有环 8 60
    public static boolean hasCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        ListNode cur = head;
        while (cur!=null){
            if (map.get(cur)!=null){
                return true;
            }
            map.put(cur,1);
            cur = cur.next;
        }

        return false;
    }

    //方案二:快慢指针
    public static boolean hasCycle2(ListNode head) {
        ListNode cur = head;
        ListNode cur2 = head.next;
        while (cur!=cur2){
            if (cur==null || cur2==null ||cur2.next==null)return false;
            cur = cur.next;
            cur2 = cur2.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(5);
        ListNode head4 = new ListNode(6);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        System.out.println(hasCycle2(head));
        head4.next=head2;
        System.out.println(hasCycle2(head));

    }

}
