package 蓝桥杯.lan真题训练.lan2020省赛javaB组;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
在游戏《星际争霸 II》中，高阶圣堂武士作为星灵的重要 AOE 单位，在
游戏的中后期发挥着重要的作用，其技能”灵能风暴“可以消耗大量的灵能对
一片区域内的敌军造成毁灭性的伤害。经常用于对抗人类的生化部队和虫族的
刺蛇飞龙等低血量单位。
【问题描述】
你控制着 n 名高阶圣堂武士，方便起见标为 1; 2; · · · ; n。每名高阶圣堂武士
需要一定的灵能来战斗，每个人有一个灵能值 ai 表示其拥有的灵能的多少（ai
非负表示这名高阶圣堂武士比在最佳状态下多余了 ai 点灵能， ai 为负则表示这
名高阶圣堂武士还需要 −ai 点灵能才能到达最佳战斗状态）。现在系统赋予了
你的高阶圣堂武士一个能力，传递灵能，每次你可以选择一个 i 2 [2; n − 1]，若
ai ≥ 0 则其两旁的高阶圣堂武士，也就是 i − 1、 i + 1 这两名高阶圣堂武士会从
i 这名高阶圣堂武士这里各抽取 ai 点灵能；若 ai < 0 则其两旁的高阶圣堂武士，
也就是 i − 1; i + 1 这两名高阶圣堂武士会给 i 这名高阶圣堂武士 −ai 点灵能。形
式化来讲就是 ai−1+ = ai; ai+1+ = ai; ai− = 2ai。
灵能是非常高效的作战工具，同时也非常危险且不稳定，一位高阶圣堂
武士拥有的灵能过多或者过少都不好，定义一组高阶圣堂武士的不稳定度为
maxn
i=1jaij，请你通过不限次数的传递灵能操作使得你控制的这一组高阶圣堂武
士的不稳定度最小。
【输入格式】
本题包含多组询问。输入的第一行包含一个正整数 T 表示询问组数。
接下来依次输入每一组询问。
每组询问的第一行包含一个正整数 n，表示高阶圣堂武士的数量。
接下来一行包含 n 个数 a1; a2; · · · ; an。
试题 J: 灵能传输 15第十届蓝桥杯大赛软件类省赛Java大学B组
【输出格式】
输出 T 行。每行一个整数依次表示每组询问的答案。
【样例输入】
3 3
5 -2 3
4
0 0 0 0
3
1 2 3
【样例输出】
3 0 3
【样例说明】
对于第一组询问：
对 2 号高阶圣堂武士进行传输操作后 a1 = 3， a2 = 2， a3 = 1。答案为 3。
对于第二组询问：
这一组高阶圣堂武士拥有的灵能都正好可以让他们达到最佳战斗状态。
【样例输入】
3 4
-1 -2 -3 7
4
2 3 4 -8
5
-1 -1 6 -1 -1
试题J: 灵能传输 16第十届蓝桥杯大赛软件类省赛 Java 大学 B 组
【样例输出】
5 7 4
【样例输入】
见文件trans3.in。
【样例输出】
见文件trans3.ans。
 */
public class J灵能传输 {

    /***
     目标:通过自己给两边输送,或者两边给自己输送  降低最大的绝对值
     5 -2 3
     3 4 1   3

     0000   0

     123   3
     全是负数,不用搞了
     全是正数,不用搞了

     2、对于 a[i]，如果 a[i] 是正数，并且 a[i - 1] 和 a[i + 1] 至少有一个负数，
     那么我们的目标就是把那个绝对值最大的负数的绝对值缩小，这个时候如果另一边是正数，
     则需要考虑操作之后是否会产生新的绝对值更大的正数，比如现在有三个数：5 5 -6，
     如果我们把中间那个 5 按上面的操作 1 变换之后：10 -5 -1，绝对值最大数变成了 10，
     而之前是 6，显然不行。如果这三个数是这样的：1 5 -7，
     那么我们就可以按操作 1 变换：6 -5 -2，最大绝对值从 7 减小到了 6，
     是可行的。那么变换条件是什么呢？这里假设 a[i - 1] 是正数，a[i + 1] 是负数，
     那么条件可以写成：a[i - 1] + a[i] < abs(a[i + 1])。

     而如果 a[i - 1] 和 a[i + 1] 都是负数的时候，
     当两边的绝对值有一个大于 a[i] 时，就可以进行操作 1 变换。

     3、对于 a[i] 是负数的时候，如果 a[i - 1] 是负数，
     a[i+1] 是正数，那么确保 a[i + 1] > abs(a[i] + a[i-1])，就可以进行操作 2 变换，
     如果两边都是正数则只要有一边的值大于 abs(a[i]) 时就可以进行操作 2 变换

     //判断是否异号
     public static boolean judge(int a, int b) {
     return a > 0 && b < 0 || a < 0 && b > 0;
     }
     */
    public static boolean judge(int a, int b) {
        return a > 0 && b < 0 || a < 0 && b > 0;
    }

    //正数变换
    public static void change1(int[] a, int i) {
        /**
         变换
         a[i] = a[i]-2a[i]
         a[i-1] = a[i-1]+a[i]
         a[i+1] = a[i+1]+a[i]
         */
        int i1 = a[i];
        a[i] = a[i] - 2 * i1;
        a[i - 1] = a[i - 1] + i1;
        a[i + 1] = a[i + 1] + i1;
    }

    //负数变换
    public static void change2(int[] a, int i) {
        /**
         变换
         变换
         a[i] = a[i]+Math.abs(2a[i])
         a[i-1] = a[i-1]-a[i]
         a[i+1] = a[i+1]-a[i]
         */
        int i1 = a[i];
        a[i] = a[i] + Math.abs(2 * i1);
        a[i - 1] = a[i - 1] + i1;
        a[i + 1] = a[i + 1] + i1;
    }

    public static int test(int[] arr) {
        System.out.println(Arrays.toString(arr));
        //遍历arr,对1,n-1的数进行灵能传输
        for (int i = 1; i < arr.length - 1; i++) {
            //如果a[i] > 0
            if (arr[i] > 0) {
                //如果a[i-1] a[i+1]异号
                if (judge(arr[i - 1], arr[i + 1])) {
                    if (arr[i - 1] > 0 && arr[i - 1] + arr[i] < Math.abs(arr[i + 1])) {
                        //操作变换-1函数
                        change1(arr, i);
                    } else if (arr[i + 1] > 0 && arr[i + 1] + arr[i] < Math.abs(arr[i - 1])) {
                        change1(arr, i);
                    }
                } else if (arr[i - 1] < 0 && arr[i + 1] < 0) {//都是负数
                    //当两边的绝对值有一个大于 a[i] 时
                    if (Math.abs(arr[i - 1]) > arr[i] || Math.abs(arr[i + 1]) > arr[i]) {
                        change1(arr, i);
                    }
                }
            } else if (arr[i] < 0) {//如果a[i] < 0
                //如果 a[i - 1] 是负数，
                //     a[i+1] 是正数，那么确保 a[i + 1] > abs(a[i] + a[i-1])
                if (arr[i - 1] < 0 && arr[i + 1] > 0 && arr[i + 1] > Math.abs(arr[i] + arr[i - 1])) {
                    change2(arr, i);
                } else if (arr[i + 1] < 0 && arr[i - 1] > 0 && arr[i - 1] > Math.abs(arr[i] + arr[i + 1])) {
                    change2(arr, i);
                } else if (arr[i - 1] > 0 && arr[i + 1] > 0) {
                    //如果两边都是正数则只要有一边的值大于 abs(a[i]) 时就可以进行
                    if (arr[i - 1] > Math.abs(arr[i]) || arr[i + 1] > Math.abs(arr[i])) {
                        change2(arr, i);
                    }
                }
            }


        }

        System.out.println(Arrays.toString(arr));
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,Math.abs(arr[i]));
        }
        return max;

    }

    public static void main(String[] args) {
        /*测试change函数
        int[] a = {1,2,3};
        change1(a,1);
        System.out.println(Arrays.toString(a));

        int[] a1 = {1,-2,3};
        change2(a1,1);
        System.out.println(Arrays.toString(a1));*/

        System.out.println(test(new int[]{5,-2,3}));
        System.out.println(test(new int[]{0,0,0,0}));
        System.out.println(test(new int[]{1,2,3}));

        System.out.println(test(new int[]{-1, -2, -3, 7}));
        System.out.println(test(new int[]{2,3,4,-8}));
        System.out.println(test(new int[]{-1, -1,6,-1,-1}));
    }
}
