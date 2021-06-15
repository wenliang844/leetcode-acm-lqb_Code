package ACM.leecode周赛.第236场周赛;

import sun.font.FontRunIterator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lee5729求出MK平均值 {
    /***
     给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。

     MK 平均值 按照如下步骤计算：

     如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。
     从这个容器中删除最小的 k 个数和最大的 k 个数。
     计算剩余元素的平均值，并 取整到最近的整数 。
     请你实现 MKAverage 类：

     MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。
     void addElement(int num) 往数据流中插入一个新的元素 num 。
     int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 取整到最近的整数 。
     */
    public static void main(String[] args) {
        MKAverage obj = new MKAverage(6, 1);
        obj.addElement(3);        // 当前元素为 [3]
        obj.addElement(1);        // 当前元素为 [3,1]
        obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(12);       // 当前元素为 [3,1,10]
        System.out.println(obj.calculateMKAverage());
        // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(5);        // 当前元素为 [3,1,10,5]
        obj.addElement(3);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(4);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage());//5 5 5
        // 删除最小以及最大的 1 个元素后，容器为 [5]
        // [5] 的平均值等于 5/1 = 5 ，故返回 5
        obj.addElement(6);
        obj.addElement(7);
        System.out.println(obj.calculateMKAverage());//5.5
    }

}

class MKAverage {
    int m;
    int k;
    List<Integer> list;//装数的容器
    int[] avg;//需要计算avg的独立的容器

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        list = new ArrayList<>();
        avg = new int[m];
    }

    public void addElement(int num) {
        list.add(num);
    }

    public int calculateMKAverage() {
        int len = list.size();
        if (len<m)return -1;
        int index = 0;
        System.out.println("当前列表="+list);
        for (int i = len - m; i < len; i++) {//封装数组元素
            avg[index++] = list.get(i);
        }
        //用sum加和 除了前一个元素和后一个元素,在减去最大值和最小值
        /*int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < avg.length; i++) {
            sum += avg[i];
            if (avg[i] > max) max = avg[i];
            if (avg[i] < min) min = avg[i];
        }
        sum -= max;
        sum -= min;*/
        int sum=0;
        Arrays.sort(avg);
        System.out.println("当前排序元素="+ Arrays.toString(avg));
        for (int i = k; i < avg.length - k; i++) {
            sum+=avg[i];
        }
        //return Math.round(sum / (avg.length - (k * 2)));
        return sum / (avg.length - (k * 2));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */