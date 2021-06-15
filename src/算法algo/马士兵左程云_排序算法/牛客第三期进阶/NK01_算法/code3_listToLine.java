package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class code3_listToLine {

    /***
     * 1.链表val放数组中,进行一个一个抽
     list中  前面的偶数,进行分前后两种,交替取值
     i-3
     (i-4)/2 +1
     将链表 放数组中;进行洗牌操作,找规律


     */
    public static void listToLR1(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        int l=0;
        int r=list.size()/2;
        while (l<list.size()/2){
            newList.add(list.get(l));
            newList.add(list.get(r));
            l++;
            r++;
        }
        if (list.size()%2!=0){
            newList.add(list.get(list.size()-1));
        }
        System.out.println(newList);


    }

    //linkListTo list-->array
    public static void linkListToLR2(LinkedList linkedList){

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        //listToLR1(list);
        list.add(7);
        //listToLR1(list);

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);
        LinkedList linkedList1 = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        LinkedList linkedList5 = new LinkedList();
        LinkedList linkedList6 = new LinkedList();
        LinkedList linkedList7 = new LinkedList();



    }
}
