package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class code3圆圈舞 {
    /***
     1
     2
     3
     4
     5
     6
     7
     8
     9
     记得答案需要除1000000007的余数
     单链表
     map获取链表的上一级
     while遍历链表

     10
     1 1
     1 1
     1 1
     1 1
     1 1
     1 1
     1 1
     1 1
     1 1
     1 1
     9
     1 2 8
     1 2 6
     2 8 10
     3 5 10
     1 1 2
     1 2 1
     2 5 5
     1 4 8
     1 4 5
     * @param args
     */
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Map<Node, Node> parent = new HashMap<>();
        Map<Integer, Node> nmap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        //1.构造环
        int n = sc.nextInt();
        Node head = new Node(sc.nextInt(), sc.nextInt());
        nmap.put(1, head);
        Node p = head;
        for (int i = 2; i <= n; i++) {//1-9
            Node temp = new Node(sc.nextInt(), sc.nextInt());
            parent.put(temp, p);
            nmap.put(i, temp);
            p.next = temp;
            p=p.next;
        }

        //让最后一个元素连接head
        p.next=head;
        parent.put(head,p);
        System.out.println(parent);
        System.out.println(nmap);

        //接收Queue查询
        int query = sc.nextInt();
        while (query-- > 0) {
            int type = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            switch (type) {
                case 1:
                    changeLR(head, left, right, parent,nmap);
                    break;
                case 2:
                    nmap.get(left).happy = right;
                    break;
                case 3:
                    nmap.get(left).touch = right;
                    break;
            }
            System.out.println(nmap);
            System.out.println(calcHT(head, nmap));
        }

    }

    private static void changeLR(Node head, int left, int right, Map<Node, Node> parent, Map<Integer, Node> nmap) {
        //将left的next指向right  right的父节点的next指向2的next
        Node leftNode = nmap.get(left);
        Node rightNode = nmap.get(right);
        Node rightParent = parent.get(rightNode);
        Node leftNext = leftNode.next;
        leftNode.next = rightNode;
        parent.put(rightNode,leftNode);//更新父节点
        rightParent.next = leftNext;
        parent.put(leftNext,rightParent);
        //父节点需要个更新呀
    }

    private static int calcHT(Node head, Map<Integer, Node> nmap) {
        //遍历每一个nmap进行遍历,计算欢乐值,返回
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            //对每个node进行计算
            Node temp = nmap.get(i);
            //将环的总数total算出来
            int total = 1;
            Node p = temp;
            System.out.println(p);
            while (p.next != temp) {
                p = p.next;
                total++;//5
            }
            System.out.println("total="+total);
            //每一个j到tmp的距离
            int pToTemp = total - 1;
            p = temp.next;
            while (p != temp) {
                //计算p到temp有多少距离  直接是5-1
                sum += ((total - pToTemp) * temp.happy * temp.touch)%MOD;
                pToTemp--;
                p=p.next;
            }
            System.out.println("sum="+sum);


        }
        System.out.println("sumsum="+sum);
        return sum;//需要取余1000000007  每一步都需要
    }

    static class Node {
        int happy;//快乐值
        int touch;//感动值
        Node next;//下一个

        public Node() {

        }

        public Node(int happy, int touch) {
            this.happy = happy;
            this.touch = touch;
        }

        public Node(int happy, int touch, Node node) {
            this.happy = happy;
            this.touch = touch;
            this.next = node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "happy=" + happy +
                    ", touch=" + touch +//"有next<<<"+next==null?"no":next.touch+">>>"+
                    '}';
        }
    }
}
