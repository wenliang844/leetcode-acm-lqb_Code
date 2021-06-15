package ACM.每日一题leecode.day66;

import java.util.ArrayList;
import java.util.List;

public class day85_61旋转链表 {

    //方法一:转数组,移动k/len,后面的移到前面
    public static ListNode rotateRight(ListNode head, int k) {

        if (k==0){
            return head;
        }
        if (head==null){
            return null;
        }
        List<Integer> list = new ArrayList<>();

        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1 = head;
        while (p1!=null){
            list.add(p1.val);
            p1 = p1.next;
        }
        //p1 = head;
        int i=0;
        int len = list.size();
        k=k%len;//兜兜转转
        p2 = head;
        while (k-- > 0) {
            p2 = p2.next;
        }
        //System.out.println(p1+"--"+p2);
        //System.out.println(list);

        //进行遍历
        while (i<len){
            p2.val = list.get(i);
            p2=p2.next;
            i++;

            //当p2 = null;让p2 = head
            if (p2==null){
                p2=head;
            }
            //终止条件 i>len
            //System.out.println(p2);
        }


        return head;
    }

    public static void main(String[] args) {
        System.out.println(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4));
        System.out.println(rotateRight(new ListNode(),0));
        System.out.println(rotateRight(new ListNode(),4));
        System.out.println(rotateRight(null,4));
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



