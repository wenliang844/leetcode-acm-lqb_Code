package 蓝桥杯.蓝桥杯每日一题;

import java.util.*;

public class day46_38接水问题 {
    /*****
     　学校里有一个水房，水房里一共装有m 个龙头可供同学们打开水，每个龙头每秒钟的 供水量相等，均为1。 现在有n 名同学准备接水，他们的初始接水顺序已经确定。将这些同学按接水顺序从1 到n 编号，i 号同学的接水量为wi。接水开始时，1 到m 号同学各占一个水龙头，并同时打 开水龙头接水。当其中某名同学j 完成其接水量要求wj 后，下一名排队等候接水的同学k 马上接替j 同学的位置开始接水。这个换人的过程是瞬间完成的，且没有任何水的浪费。即 j 同学第x 秒结束时完成接水，则k 同学第x+1 秒立刻开始接水。若当前接水人数n’不足m， 则只有n’个龙头供水，其它m−n’个龙头关闭。 现在给出n 名同学的接水量，按照上述接水规则，问所有同学都接完水需要多少秒。
     输入格式
     　　第1 行2 个整数n 和m，用一个空格隔开，分别表示接水人数和龙头个数。 第2 行n 个整数w1、w2、……、wn，每两个整数之间用一个空格隔开，wi 表示i 号同 学的接水量。
     输出格式
     　　输出只有一行，1 个整数，表示接水所需的总时间。
     样例输入
     5 3
     4 4 1 2 1
     样例输出
     4
     样例输入
     8 4
     23 71 87 32 70 93 80 76
     样例输出
     163
     */
    //方法一:比较两个值的大小:平均无浪费接水量,和最长个人接水量{需求数组中的最大值} 谁大取谁
    //有特殊值,当99999共用3个水龙头时,直接平均是15 最大是9 但是实际需要是18
    //三根管道往上堆,堆的最平均,则让大的先上,
    //接水的顺序确定了,也就是说1-m号的顺序接水
    //定义faucet个桶,初始值是1-faucet,下一个值从facet+1开始,哪个桶水少就装在哪里,最后返回桶中最多的水
    //复杂度O(m*n)高了,在对bucket进行找最小值,可以维护一个最小值,这样不需要每次找
    public static int getMinTime(int[] needs,int faucet){
        int minBucketIndex = 0;//每次维护这个bucket最小值的下标
        //int secondIndex = 0;//维护一个第二最小值,最小值加上了需求之后进行最小值更新
        //定义4个桶
        int bucket[] = new int[faucet];
        //初始化4个桶水量为前4个元素element
        int index=0;
        for (; index < bucket.length; index++) {
            bucket[index] = needs[index];
            if (bucket[index]<bucket[minBucketIndex] && index!=minBucketIndex){
                //secondIndex = minBucketIndex;//每次接收min最小值,在最小值要更新的时候
                minBucketIndex=index;
            }
            /*else if (bucket[index]<bucket[secondIndex] && index!=secondIndex){
                secondIndex = index;
            }*/
        }
        //用一个优先队列存下bucket的下标

        //System.out.println(index);//3 4
        //从index开始,对needs中的数据进行装载
        for (; index < needs.length; index++) {

            //找出bucket中的最小值的下标
            int tempIndex = 0;
            for (int i = 1; i < bucket.length; i++) {
                if (bucket[i]<bucket[tempIndex]){
                    tempIndex=i;
                }
            }
            //将needs[i]装载到bucket[tempindex]
            bucket[tempIndex] += needs[index];
        }

        //找出bucket里面的最大值,这个值就是最后的用时
        int maxTime = bucket[0];
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i]>maxTime){
                maxTime=bucket[i];
            }
        }

        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(getMinTime(new int[]{4,4,1,2,1},3));
        System.out.println(getMinTime(new int[]{23,71,87,32,70,93,80,76},4));//163

        System.out.println("---------测试优先队列--------");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int a[] = new int[]{2,5,3,4,8,1,5,3,2,1};
        for (int i = 0; i < a.length; i++) {
            queue.add(a[i]);
        }
        System.out.println(queue);
        System.out.println(queue.peek());//总能将最小的数放在前面让你得到
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);

    }

    //匿名Comparator实现_比较器
    public static Comparator<Integer> idComparator = new Comparator<Integer>(){
        @Override
        public int compare(Integer c1, Integer c2) {
            return (int) (c1 - c2);
        }
    };
}
