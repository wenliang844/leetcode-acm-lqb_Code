package ACM.其他的算法比赛.笔试.阿里.code2城市最少时间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    /***
     1.计算每条路线的走路时间
     2.把权值w2公交的改成 公交和走路的差值,差值越大的就从走路换公交
     3.把每条路西线走路和,减去差值最大的k条换公交路线,其中最小的,就是最少时间

     城市 道路 换公交次数
     3n 3m 1k
     v1 v2 w1 w2
     v1 v2 w1 w2
     v1 v2 w1 w2

     3 3 1
     1 2 3 1
     2 3 3 1
     1 3 10 5
     */
    public static int deepMax(ListNode[] listNodes, ListNode root, int sum, List subList,int min,int k){
        subList.add(root.sub);
        sum+=root.wolk;
       // int max =0;
        if (root.load == 2){
            int all=sum+root.wolk;
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(subList);
            //list.add(root.sub);
            Collections.sort(list);
            Collections.reverse(list);
            System.out.println(list);
            for (int i = 0; i < k; i++) {
                all -= list.get(i);
            }
            min = Math.min(min,all);
            return min;
        }

        //没到终点的话,继续递归下一个节点
        ListNode cur = new ListNode();
        cur = root;
        System.out.println(cur);
        while (cur.next!=null){
            cur = cur.next;
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(subList);
            ListNode change = new ListNode();
            if (cur.load!=2){
                change = listNodes[cur.load];
            }else {
                change = cur;
            }
            min = Math.min(deepMax(listNodes,change,sum+root.load,list,min,k),min);
        }

        return min;
    }
    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode();
        listNodes[1] = new ListNode();
        listNodes[2] = new ListNode();
        ListNode list1 = new ListNode(1,3,2);
        ListNode list2 = new ListNode(2,10,5);
        ListNode list3 = new ListNode(2,3,2);
        listNodes[0].next = list1;
        listNodes[0].next.next = list2;
        listNodes[1].next = list3;
        System.out.println(deepMax(listNodes, listNodes[0], 0, new ArrayList(),100000,1));

    }

    static class ListNode{
        int load;
        int wolk;
        int sub;
        ListNode next;
        ListNode(int load,int wolk,int sub){
            this.load = load;
            this.wolk = wolk;
            this.sub = sub;
        }
        ListNode(){

        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "load=" + load +
                    ", wolk=" + wolk +
                    ", sub=" + sub +
                    ", next=" + next +
                    '}';
        }
    }
}
