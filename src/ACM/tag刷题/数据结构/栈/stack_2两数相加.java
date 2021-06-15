package ACM.tag刷题.数据结构.栈;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/***
 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 并且每个节点只能存储 一位 数字。
 请你将两个数相加，并以相同形式返回一个表示和的链表。
 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[7,0,8]
 解释：342 + 465 = 807.
 */
public class stack_2两数相加 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

       /* if (l1.val==0){
            return l2;
        }else if (l2.val==0){
            return l1;
        }*/
        //System.out.println(l1);
        //System.out.println(l2);
        //sum1 = li.var * 10
        long sum1 = 0, sum2 = 0;
        ListNode p1 = new ListNode();
        p1 = l1;
        long step = 1;
        while (p1 != null) {
            sum1 += p1.val * step;
            step *= 10;
            p1 = p1.next;
        }

        p1 = l2;
        step = 1;
        while (p1 != null) {
            sum2 += p1.val * step;
            step *= 10;
            p1 = p1.next;
        }
        long sum = sum1 + sum2;
        if (sum == 0) {
            return new ListNode(0);
        }
        //System.out.println(sum+"-"+sum1 + "-" + sum2);

        //把807 变成 7 -> 0 -> 8   还是807
        //Stack<Integer> stack = new Stack<>();
        Queue<Integer> stack = new LinkedList();
        while (sum > 0) {
            stack.add((int) (sum % 10));
            sum /= 10;
        }
        System.out.println(stack);

        //构造链表

        ListNode p = new ListNode(stack.poll());
        p1 = p;
        while (!stack.isEmpty()) {
            ListNode p2 = new ListNode(stack.poll());
            p1.next = p2;
            p1 = p1.next;
        }
        //System.out.println(p);


        return p;
    }

    //直接从第一个链表开始加,然后sum构造一个链表,然后拼接上没加的链表 return
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1 = l1;
        p2 = l2;
        long sum = 0;
        long step = 1;
        long count = 0;
        while (p1 != null && p2 != null) {
            sum += step * p1.val;
            sum += step * p2.val;
            p1 = p1.next;
            p2 = p2.next;
            step *= 10;
            count++;
        }
        //System.out.println(sum);
        ListNode p4 = new ListNode();
        if (p1 == null && p2 == null) {
            ListNode p = new ListNode();
            ListNode p33 = new ListNode((int) (sum % 10));
            p=p33;
            sum = sum / 10;
            while (sum > 0) {
                ListNode tem = new ListNode((int) (sum % 10));
                sum = sum / 10;
                p33.next = tem;
                p33 = p33.next;
            }
            return p;
        }
        p4 = p1 == null ? p2 : p1;
        //System.out.println(sum + "-" + count);
        //System.out.println(p4);

        ListNode p = new ListNode((int) (sum % 10));
        ListNode p3 = new ListNode();
        sum = sum / 10;
        count--;
        p3 = p;
        //模拟进位
        while (count-- > 0) {
            ListNode tem = new ListNode((int) (sum % 10));
            sum = sum / 10;
            p3.next = tem;
            p3 = p3.next;
        }
        if (sum > 0) {
            p4.val += sum;
        }
        p3.next = p4;
        while (p4.val >= 10) {
            int tmp = p4.val;
            p4.val = tmp % 10;

            if (p4.next != null) {
                p4.next.val += tmp / 10;
                p4 = p4.next;
            } else {
                ListNode newList = new ListNode(tmp / 10);
                p4.next = newList;
                break;
            }
        }
        return p;
    }

    //思路三:直接全部采用模拟进位
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {

        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1 = l1;
        p2 = l2;
        ListNode newList = new ListNode();
        ListNode p = new ListNode();
        p=newList;
        int sum = 0;
        while (p1!=null || p2!=null){
            if (p1!=null){
                sum+=p1.val;
                p1=p1.next;
            }

            if (p2!=null){
                sum+=p2.val;
                p2=p2.next;
            }

            ListNode tmp = new ListNode(sum%10);
            p.next = tmp;
            p=p.next;
            sum = sum/10;
            if (sum>0){
                if (p1!=null){
                    p1.val += sum;
                    sum = 0;
                }else if (p2!=null){
                    p2.val += sum;
                    sum = 0;
                }else {
                    ListNode t = new ListNode(sum);
                    p.next = t;
                }

            }
        }

       return newList.next;
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers3(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))));
        //System.out.println(addTwoNumbers(new ListNode(0), new ListNode(0)));
       System.out.println(addTwoNumbers3(new ListNode(9), new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))))));

    }
}


//Definition for singly-linked list.
class ListNode {
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

