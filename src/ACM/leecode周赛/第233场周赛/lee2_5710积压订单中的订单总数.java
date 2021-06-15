package ACM.leecode周赛.第233场周赛;

import java.util.*;

public class lee2_5710积压订单中的订单总数 {
    /**
     给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。

     订单类型 orderTypei 可以分为两种：

     0 表示这是一批采购订单 buy
     1 表示这是一批销售订单 sell
     注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。

     存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：

     如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
     反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。否则，销售订单 sell 将会添加到积压订单中。
     输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 109 + 7 取余的结果。
     */

    public static int getNumberOfBacklogOrders(int[][] orders) {
        /**
         思路:建立两个map,buyMap   sellMap
         来一个遍历一次map
         */
        Map<Integer,Integer> buyMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer-t1;
            }
        }); //0
        Map<Integer,Integer> sellMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        }); //1

        for (int i = 0; i < orders.length; i++) {
            if (orders[i][2] == 0){//buy
                //遍历sell的订单,有没有低于buy的销售价



               List<Integer> list = new ArrayList<>();
                for (Integer price : sellMap.keySet()) {
                    if (price<=orders[i][0]){//可以购买
                        //比较订单笔数

                        //销售的订单小于采购的,还要继续buy
                        if (sellMap.get(price) < orders[i][1]){
                            orders[i][1] -= sellMap.get(price);
                            //sellMap.remove(price);
                            list.add(price);
                        }else if (sellMap.get(price) > orders[i][1]){//大于,直接全部buy了
                            sellMap.put(price,sellMap.get(price)-orders[i][1]);
                            orders[i][1] =0;
                            continue;
                        }else {
                            //sellMap.remove(price);
                            list.add(price);
                            orders[i][1]=0;
                            continue;
                        }

                    }
                }

                if (orders[i][1]>0){
                    Integer integer = buyMap.get(orders[i][0]);
                    if (integer==null){
                        buyMap.put(orders[i][0],orders[i][1]);
                    }else {
                        buyMap.put(orders[i][0],orders[i][1]+integer);
                    }
                }

                //System.out.println(list);
                for (Integer integer : list) {
                    sellMap.remove(integer);
                }




            }else{//1-->sell 卖   寻找买的价格高的
                List<Integer> list = new ArrayList<>();
                for (Integer price : buyMap.keySet()) {
                    if (price>=orders[i][0]){//可以购买
                        //比较订单笔数

                        //采购的订单小于卖的,继续采购
                        if (buyMap.get(price) < orders[i][1]){
                            orders[i][1] -= buyMap.get(price);
                            //buyMap.remove(price);
                            list.add(price);
                        }else if (buyMap.get(price) > orders[i][1]){//大于,直接全部sell了
                            buyMap.put(price,buyMap.get(price)-orders[i][1]);
                            orders[i][1] =0;
                            continue;
                        }else {
                            //buyMap.remove(price);
                            list.add(price);
                            orders[i][1]=0;
                            continue;
                        }

                    }
                }

                if (orders[i][1]>0){
                    Integer integer = sellMap.get(orders[i][0]);
                    //System.out.println("=="+integer+"--"+orders[i][0]+"==="+orders[i][1]);
                    if (integer == null){
                        sellMap.put(orders[i][0],orders[i][1]);
                    }else {
                        sellMap.put(orders[i][0],integer+orders[i][1]);
                    }
                }

                //System.out.println(list);
                for (Integer integer : list) {
                    buyMap.remove(integer);
                }

            }

            //输出当前的sell   buy
            System.out.println(buyMap+"***"+sellMap);
        }
        int count = 0;
        for (Integer integer : buyMap.keySet()) {
            count += buyMap.get(integer);
        }
        for (Integer value : sellMap.values()) {
            count+=value;
        }

        return (int) (count % (Math.pow(10,9) + 7));
    }

    public static void main(String[] args) {
       /* Map<Integer,Integer> buyMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        }); //0
        buyMap.put(1,2);
        buyMap.put(3,2);
        buyMap.put(4,2);
        buyMap.put(2,2);
        for (Integer integer : buyMap.keySet()) {
            System.out.println(integer);
        }*/
        //System.out.println(getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}));
        //System.out.println(getNumberOfBacklogOrders(new int[][]{{7,1000000000,1}, {15,3,0}, {5,999999995,0}, {5,1,1}}));
        //System.out.println(getNumberOfBacklogOrders(new int[][]{{19,28,0},{9,4,1},{25,15,1}}));
        //System.out.println(getNumberOfBacklogOrders(new int[][]{{26,7,0},{16,1,1},{14,20,0},{23,15,1},{24,26,0},{19,4,1},{1,1,0}}));
        //System.out.println(getNumberOfBacklogOrders(new int[][]{{26,7,0},{16,1,1},{14,20,0},{23,15,1},{24,26,0},{19,4,1},{1,1,0}}));
        //System.out.println(getNumberOfBacklogOrders(new int[][]{{1,29,1},{22,7,1},{24,1,0},{25,15,1},{18,8,1},{8,22,0},{25,15,1},{30,1,1},{27,30,0}}));
        System.out.println(getNumberOfBacklogOrders(new int[][]{{27,30,0},{10,10,1},{28,17,1},{19,28,0},{16,8,1},{14,22,0},{12,18,1},{3,15,0},{25,6,1}}));
       
    }
}
