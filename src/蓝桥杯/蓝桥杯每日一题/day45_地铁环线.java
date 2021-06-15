package 蓝桥杯.蓝桥杯每日一题;

public class day45_地铁环线 {

    /***
     H市有一环线地铁，一共包含N站，编号1~N。正向行驶的地铁会按1 -> 2 -> 3 -> ... -> N -> 1的方向行驶，反向会按1 -> N -> N-1 -> ... -> 3 -> 2 -> 1的方向行驶。
     给定所有相邻两站之间地铁行驶的时间(正向、反向时间相同），假设小Hi要从第X站到第Y站，请你判断是小Hi是乘坐正向还是反向的列车用时更少？
     输入
     第一行包含两个整数N和M，分别代表地铁站数目和询问的次数。
     第二行包含N个整数A1, A2, ... AN，其中Ai代表从第i站正向行驶到下一站所用的时间。
     以下M行每行包含两个整数X和Y，代表一个询问。
     1 ≤ N, M ≤ 100000  1 ≤ X, Y ≤ N  1 ≤ Ai ≤ 100000
     输出
     对于每组询问，输出一个整数表示最短时间。

     样例输入
     5 2
     1 2 3 4 5
     1 3
     1 5
     样例输出
     3
     5
     */
    //方法一:暴力枚举
    public static int minTime(int[] times,int from,int to){
        //两种可能,1正向 2.反向 1 2 3 4 5
        //1-3 正向:1+2 反向5+4+3
        //策略:先求出sum总数,再算正向的大小,大于总数的一半就是不行 forward reverse
        int sum=0;
        for (int i = 0; i < times.length; i++) {
            sum += times[i];
        }

        //计算从from - to的时间就是from +from+1+...to-1
        int forwardTime = 0;
        for (int i = from-1; i < to-1; i++) {
            forwardTime += times[i];
        }
        //趴地阿门forwardTime和一般总时间sum/2的大小
        //避免除不尽,直接使用forward和reverse比较
        int reverseTime = sum-forwardTime;
        if (forwardTime < reverseTime){
            //就选择forwardTime
           return forwardTime;
        }else {
            return reverseTime;
        }
    }

    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1,2,3,4,5},1,3));
        System.out.println(minTime(new int[]{1,2,3,4,5},1,5));
    }

}
