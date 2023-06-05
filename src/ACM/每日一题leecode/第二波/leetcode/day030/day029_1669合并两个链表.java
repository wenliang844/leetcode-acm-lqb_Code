package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/1/29 11:24
 */
public class day029_1669合并两个链表 {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(0,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))));
        ListNode list2 = new ListNode(10001,new ListNode(10002));
        System.out.println(list1);
        System.out.println(mergeInBetween(list1,3,4,list2));
        //输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1;
        int count = 0;
        while (count < a-1){
            p = p.next;
            count++;
        }
        ListNode temp = p.next;
        p.next=list2;
        while (count<b){
            temp = temp.next;
            count++;
        }
        ListNode p2 = list2;
        while (p2.next!=null){
            p2 = p2.next;
        }
        p2.next=temp;

        return list1;
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

        @Override
        public String toString() {
            return val +"-" + next;
        }
    }
}
