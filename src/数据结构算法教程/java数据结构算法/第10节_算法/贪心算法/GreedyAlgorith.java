package 数据结构算法教程.java数据结构算法.第10节_算法.贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GreedyAlgorith {
    /***
     广播电台覆盖问题
     1. n个广播台 子集个数 2^n-1  穷举法
     2. 贪心算法 可以得到接近的解
     *   1.找一个电台,覆盖了最多未未覆盖的地区的电台  可能包含已覆盖的地区
     *   2.将这个加入集合,想办法把这个电台覆盖的地区在下次比较时直接去掉
     *   3.重复第一步,直到覆盖了全部的地区

     allArea=[1 2 3 4 5]
     select = list{ }
     第一次覆盖 第二次覆盖 第三次覆盖 第四次覆盖
     k1 123 3           2           0           0
     k2 234 3           2           2           0
     k3 456 3           0           0           0
     k4 45 2            2           2           0
     k5 34 2            1           1           1
     1.把k1加入
     2.把k2加入
     3.把k3加入

     局部最优的选择; 效率最高

     */
    public static void main(String[] args) {
        //先创建广播电台,放入到一个hashmap中,
        Map<String, HashSet<String>> broadcasts = new HashMap<>();
        //将电台放入即可
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet1.add("广州");
        hashSet1.add("北京");
        hashSet1.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet1.add("成都");
        hashSet1.add("上海");
        hashSet1.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet1.add("杭州");
        hashSet1.add("大连");

        //加入map
        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);

        //allAreas存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("深圳");

        //创建一个lsit,放悬着的lsit集合
        ArrayList<String> selects = new ArrayList<>();

        //临时集合,遍历这个电台覆盖的和全部地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义一个maxKey,保存在一次遍历过程总中,能够覆盖最大地区对应的电台的key
        //int key;
        //计算覆盖有几个
        String maxKey = null;
        while (allAreas.size() != 0) {//如果allArea不为0,则表示没有覆盖
            //hile循环 需要将maxKey每次w置空
            maxKey = null;
            //遍历 broadCasts,取出对应的key
            for (String key : broadcasts.keySet()) {
               //每次for循环,需要将tempSet进行清空
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);//key对应的加入了
                //求出tempSet 和 allArea 集合的交换  交集会赋值给tempSet
                tempSet.retainAll(allAreas);//是area和allarea的一个交集
                //如果当前这个集合包含的未覆盖地区的数量比maxKey大,maxKey指向新的大key
                if (tempSet.size() > 0 && (maxKey == null) || tempSet.size()>broadcasts.get(maxKey).size()){
                    maxKey = key;
                }
            }

            //maxKey不为空,就要加入select
            if(maxKey!=null){
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区从allArea中清除掉
                allAreas.retainAll(broadcasts.get(maxKey));
            }

        }

        System.out.println(selects);
    }

    public static void tenxin() {

    }
}
