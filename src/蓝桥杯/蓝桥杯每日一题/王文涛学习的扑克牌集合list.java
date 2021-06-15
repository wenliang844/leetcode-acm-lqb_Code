package 蓝桥杯.蓝桥杯每日一题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class 王文涛学习的扑克牌集合list {
    /*
    创建 HashMap,键是编号,值是牌
    创建 ArrayList,存储编号
    创建花色数组和点数数组
    从0开始 HashMap往里面存储编号,并存储对应的牌。同时往 ArrayList里面存储编号
    洗牌(洗的是编号),用 Collections的shuffle（）方法实现
    发牌(发的也是编号,为了保证编号是排序的,创建 TreeSet集合接收
    定义方法看牌(遍历 TreeSet集合,获取编号,到HashMap集合找对应的牌
    调用看牌方法
     */
    public static void main(String[] args) {
//    创建 HashMap,键是编号,值是牌
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
//        创建 ArrayList,存储编号

        ArrayList<Integer> array = new ArrayList<Integer>();
//        创建花色数组和点数数组
        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
//        从0开始 HashMap往里面存储编号,并存储对应的牌。同时往 ArrayList里面存储编号
        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                hm.put(index, color + number);
                array.add(index);
                index++;
            }
            hm.put(index, "小王");
            array.add(index);
            index++;
            hm.put(index, "大王");
            array.add(index);
//            洗牌(洗的是编号),用 Collections的shuffle（）方法实现
            Collections.shuffle(array);
//            发牌(发的也是编号,为了保证编号是排序的,创建 TreeSet集合接收
            TreeSet<Integer> lqxSet = new TreeSet<Integer>();
            TreeSet<Integer> lySet = new TreeSet<Integer>();
            TreeSet<Integer> fqySet = new TreeSet<Integer>();
            TreeSet<Integer> dpSet = new TreeSet<Integer>();
            for (int i = 0; i < array.size(); i++) {
                int x = array.get(i);
                if (i >= array.size() - 3) {
                    dpSet.add(x);
                } else if (i % 3 == 0) {
                    lqxSet.add(x);
                } else if (i % 3 == 1) {
                    lySet.add(x);
                } else if (i % 3 == 2) {
                    fqySet.add(x);
                }
            }
            lookPoker("林青霞", lqxSet, hm);
            lookPoker("柳岩", lySet, hm);
            lookPoker("风清扬", fqySet, hm);
        }
    }

    //定义方法看牌(遍历 TreeSet集合,获取编号,到HashMap集合找对应的牌
    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.println(name + "的牌是");
        for (Integer key : ts) {
            String poker = hm.get(key);
            System.out.print(poker + " ");
        }
        System.out.println();
    }


}
