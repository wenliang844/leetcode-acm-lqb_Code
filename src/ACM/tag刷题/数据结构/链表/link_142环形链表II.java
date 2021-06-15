package ACM.tag刷题.数据结构.链表;

import java.util.HashMap;
import java.util.Map;

public class link_142环形链表II {
    /**
     给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     说明：不允许修改给定的链表。
     进阶：
     你是否可以使用 O(1) 空间解决此题？
     输入：head = [3,2,0,-4], pos = 1
     输出：返回索引为 1 的链表节点
     解释：链表中有一个环，其尾部连接到第二个节点。
     */
    //方案一,并查集,哈希表 16 5
    public static ListNode detectCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        ListNode cur = head;
        while (cur!=null){
            if (map.get(cur)!=null){
                System.out.println(cur.val);
                return cur;
            }
            map.put(cur,1);
            cur = cur.next;
        }

        return null;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(4);
        ListNode head3 = new ListNode(5);
        ListNode head4 = new ListNode(6);
        head.next=head2;
        head2.next=head3;
        head3.next=head4;
        System.out.println(detectCycle(head));
        head4.next=head2;
        System.out.println(detectCycle(head).val);
    }
}
