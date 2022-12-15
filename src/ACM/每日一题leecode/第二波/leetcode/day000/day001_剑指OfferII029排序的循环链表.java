package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/6/18 5:51 下午
 */
public class day001_剑指OfferII029排序的循环链表 {
    public Node insert(Node head, int insertVal) {

        if (head == null) {
            Node temp = new Node(insertVal);
            temp.next = temp;
            return temp;
        }

        if (head.next == null){
            head.next = new Node(insertVal,head);
            return head;
        }

        if (insertVal >= head.val){
            Node temp = new Node(insertVal);
            temp.next = head.next;
            head.next = temp;
            return head;
        }

        Node ori = head.next;
        Node p = ori;
        while (true){
            if (insertVal >= p.val){
                Node temp = new Node(insertVal);
                temp.next = p.next;
                p.next = temp;
                return head;
            }

            if (p.val <= p.next.val && p.val<= ori.val){
                Node temp = new Node(insertVal);
                temp.next = p;
                ori.next = temp;
                return head;
            }
            ori = p;
            p=p.next;
        }

    }


    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}


