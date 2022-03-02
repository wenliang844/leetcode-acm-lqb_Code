package ACM.每日一题leecode.day237;

import java.util.*;

public class day243_382链表随机节点 {
    public static void main(String[] args) {
        day243_382链表随机节点 day = new day243_382链表随机节点(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
        System.out.println(day.getRandom());
    }

    ListNode head;

    public day243_382链表随机节点(ListNode head) {
        this.head = head;
    }

    // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
    //58 7
    public int getRandom() {
        List<Integer> list = new ArrayList<Integer>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p=p.next;
        }
        int i = (int) (Math.random() * list.size());//[0-1)  [0-3)
        return list.get(i);

    }

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
    }
}
