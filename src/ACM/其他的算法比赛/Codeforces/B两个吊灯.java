package ACM.其他的算法比赛.Codeforces;

import java.util.Scanner;

public class B两个吊灯 {
    /**
     Vasya是一家大型建筑公司的首席执行官。和其他任何一位大老板一样，他有一个宽敞，布置精美的办公室，里面有两个水晶吊灯。为了保持动力，Vasya需要每天改变办公室的灯光颜色。这就是为什么他订购了两个可以周期性改变其颜色的枝形吊灯的原因。例如：红色–棕色–黄色–红色–棕色–黄色，依此类推。

     有许多枝形吊灯，它们的颜色设置或颜色顺序不同。负责照明的人犯了一个严重的错误-他们购买了两个不同的枝形吊灯。

     由于枝形吊灯不同，因此有些日子它们的颜色相同，但有些日子却有所不同。当然，它看起来很差，只是让Vasya烦恼。结果，ķ第三次，当枝形吊灯以不同的颜色点亮时，Vasya会非常生气，很可能会解雇购买了枝形吊灯的人。

     您的任务是计算发生日期的天数（从安装吊灯的天数开始计算）。您可以认为Vasya每天都在工作，没有周末和休息日。

     输入
     第一行包含三个整数 ñ， 米 和 ķ （1 ≤ Ñ ，米≤ 500000; 1 ≤ ķ ≤1012）-第一和第二盏枝形吊灯的颜色数量，以及应激怒Vasya的颜色应变化多少次。

     第二行包含 ñ 不同的整数一种一世 （1 ≤一种一世≤ 2 ⋅最大值（Ñ ，米））来描述第一个枝形吊灯的颜色顺序。

     第三行包含 米 不同的整数bĴ （1 ≤b一世≤ 2 ⋅最大值（Ñ ，米））来描述第二个枝形吊灯的颜色顺序。

     在 一世-第一天，第一盏枝形吊灯有颜色 一种X， 在哪里 x = （（i − 1 ）国防部n ）+ 1 ） 第二个有颜色 bÿ， 在哪里 ÿ= （（i − 1 ）国防部m ）+ 1 ）。

     保证顺序 一种 与顺序不同 b，因此有时候吊灯的颜色会有所不同。

     输出
     打印单个整数-Vasya生气的日子的索引。

     例子
     输入复制
     4 2 4
     4 2 3 1
     2 1
     输出复制
     5
     输入复制
     3 8 41
     1 3 2
     1 6 4 3 5 7 2 8
     输出复制
     47
     输入复制
     1 2 31
     1个
     1 2
     输出复制
     62
     笔记
     在第一个示例中，枝形吊灯在几天内将具有不同的颜色 1个， 2个， 3 和 5。这就是为什么答案是5。
     */

    public static void test(){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M=sc.nextInt();
        int maxCount = sc.nextInt();
        int light1[] = new int[N];
        int light2[] = new int[M];
        for (int i = 0; i < N; i++) {
            light1[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            light2[i] = sc.nextInt();
        }

       /*//初始化数据
       int N=4;
       int M=2;
       int maxCount = 4;
       int light1[] = {4,2,3,1};
       int light2[] = {2,1};*/

       int count = 0;//灯不一样的天数
        int days = 0;//总天数

       int i=0;
       int j=0;

       while (true){

           //System.out.println("这是今天的灯"+light1[i]+" "+light2[j]);
           days++;
           if (light1[i]!=light2[j]){
               count++;
           }
           if (count==maxCount){
               break;
           }

           if (i==light1.length-1){
               i=0;
           }else {
               i++;
           }

           if (j==light2.length-1){
               j=0;
           }else {
               j++;
           }


       }

        System.out.println("生气的天数索引是="+days);
    }

    public static void main(String[] args) {
        test();

    }
}
