package 蓝桥杯.培训.第一次培训3_12习题2019;

import java.util.*;

public class lqb7_试题G外卖店优先级 {

    /***
     “饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有
     一个优先级，初始时 (0 时刻) 优先级都为 0。
     每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减
     到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
     如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果
     优先级小于等于 3，则会被清除出优先缓存。
     给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优
     先缓存中。
     【输入格式】
     第一行包含 3 个整数 N、 M 和 T。
     以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到
     一个订单。
     【输出格式】
     输出一个整数代表答案。
     【样例输入】
     2店铺 6订单 6时刻
     1 1
     5 2
     3 1
     6 2
     2 1
     6 2
     试题G: 外卖店优先级 9第十届蓝桥杯大赛软件类省赛 Java 大学 C 组
     【样例输出】
     1
     */

    /**
     思路:
     1.排序订单   使用键值对就不用排序了==map中的key不可以重复 values做一个集合
     2.map存储店铺积分,   用数组进行存储  array{1,0,true}
     3.对订单的数组进行遍历,同时更新map店铺积分   count计数 超过5了就


     */

    public static void test1(Map<Integer, ArrayList<Integer>> map){
        int N=2;//店铺
        int M=6;//订单   map
        int T=6;//时刻

        int[][] stores = new int[N][3];  //积分 1处理过了 是否在优先队列01  老师用set
        int count=0;//多少个再优先缓存中

        for (int i = 1; i <= T; i++) {
            ArrayList<Integer> list = map.get(i);
            if (list !=null){
                for (Integer integer : list) {
                    stores[integer-1][0]+=2;
                    stores[integer-1][1]=1;
                    if (stores[integer-1][2]==0 && stores[integer-1][0]>5){
                        count++;
                        stores[integer-1][2]=1;
                    }
                }
            }

            for (int j = 0; j < stores.length; j++) {
                if (stores[j][1]==0 &&stores[j][0]>0){
                    stores[j][0]-=1;
                    if (stores[j][0]<=3 && stores[j][2]==1){
                        count--;
                        stores[j][2]=0;
                    }
                }

                stores[j][1] =0;
            }

            for (int j = 0; j < stores.length; j++) {
                System.out.println("这是数组="+ Arrays.toString(stores[j]));
            }

        }

        System.out.println(count);

    }

    public static void main(String[] args) {


        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList list = new ArrayList();
        list.add(1);
        map.put(1,list);
        map.put(2,list);
        map.put(3,list);

        ArrayList list2 = new ArrayList();
        list2.add(2);
        map.put(5,list2);

        ArrayList list3 = new ArrayList();
        list3.add(2);
        list3.add(2);
        map.put(6,list3);
        System.out.println(map);


        test1(map);
    }
}
