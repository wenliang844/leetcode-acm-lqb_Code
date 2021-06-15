package ACM.每日一题leecode.day32;

public class day60_1290二进制链表转整数 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        head.next=node1;
        node1.next=node2;

        System.out.println("这是结果="+getDecimalValue(head));

    }

    public static int getDecimalValue(ListNode head) {
        ListNode p = head;
        int[] nums = new int[30];
        int i=0;
        while (p!=null){
            nums[i]= p.val;
            i++;
            p=p.next;
        }

        int n = 1;
        int sum = 0;
        while (i>0){
            i--;
            sum += n*nums[i];
            n=n*2;
        }
        return sum;
    }


//    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
