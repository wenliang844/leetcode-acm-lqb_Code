package ACM.每日一题leecode.day66;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class day83_82删除排序链表中的重复元素II {

    /***
     存在一个按升序排列的链表，给你这个链表的头节点 head ，
     请你删除链表中所有存在数字重复情况的节点，只保留原始链表中
     没有重复出现 的数字。
     返回同样按升序排列的结果链表。
     */

    //方法一:直接用一个set保存列表中的数字,再进行重构一个列表
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newListNode = new ListNode();
        if (head == null){
            return null;
        }
        List list = new ArrayList<>();
        System.out.println(head);
        ListNode p1 = head;
        while (p1!=null){
            list.add(p1.val);
            p1 = p1.next;
        }
        //System.out.println(list);
        boolean flag = false;
        for (int i = 0; i < list.size()-1; i++) {
            //如果i 和i+1 相同,那么i+1删除,最后i也删除   continue
            while (i < list.size()-1 && list.get(i)==list.get(i+1)){
                list.remove(i+1);
                flag = true;
            }
            if (flag){
                list.remove(i);
                i--;
                flag = false;
            }
        }

        //System.out.println(list);
        //构造一个链表
        if (list.size()>=1){
            newListNode.val = (int) list.get(0);
        }else {
            return null;
        }

        p1 = newListNode;
        for (int i = 1; i < list.size(); i++) {
            ListNode p2 = new ListNode((Integer) list.get(i));
            p1.next = p2;
            p1=p1.next;
        }

        return newListNode;
    }

    public static void main(String[] args) {
        //1,2,3,3,4,4,5
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,
                new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5)))))));
        System.out.println(deleteDuplicates(listNode));
        System.out.println(deleteDuplicates(null));
        System.out.println(deleteDuplicates(new ListNode(1,new ListNode(1))));

    }


    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}




