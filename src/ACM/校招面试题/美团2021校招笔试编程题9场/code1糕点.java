package ACM.校招面试题.美团2021校招笔试编程题9场;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class code1糕点 {
    /***
     小团的蛋糕铺长期霸占着美团APP中“蛋糕奶茶”栏目的首位，因此总会吸引各路食客前来探店。
     小团一天最多可以烤n个蛋糕，每个蛋糕有一个正整数的重量。
     早上，糕点铺已经做好了m个蛋糕。
     现在，有一个顾客要来买两个蛋糕，他希望买这一天糕点铺烤好的最重的和最轻的蛋糕，
     并且希望这两个蛋糕的重量恰好为a和b。剩余的n-m个蛋糕可以现烤，请问小团能否满足他的要求？
     输入描述:
     输入包含多组数据，每组数据两行。
     每组数据的第一行包含4个整数，n,m,a,b，空格隔开。这里不保证a和b的大小关系。
     接下来一行m个数，空格隔开，代表烤好的蛋糕重量
     输出描述:
     对于每一组数据，如果可以办到顾客的要求，输出YES，否则输出NO
     */

    public static void Main(){
        Scanner sc = new Scanner(System.in);

        //接收数据 用一个list
       /*
        List<String> list = new ArrayList<>();
        while (sc.hasNext()){
            String s = sc.next();
        }*/

        while (sc.hasNext()){
            int n = sc.nextInt();//总的包子数量
            int m = sc.nextInt();//做好的包子数量
            int a = sc.nextInt();//接收的需求包子
            int b = sc.nextInt();

            int[] mm = new int[m];
            for (int i = 0; i < m; i++) {
                mm[i] = sc.nextInt();//做好的包子重量
            }
            Arrays.sort(mm);
            //System.out.println(Arrays.toString(mm));
            /*int buyMax = Math.max(a,b);
            int buyMin = Math.min(a,b);*/
            int buyMax,buyMin;
            if (a>b){
                buyMax=a;
                buyMin=b;
            }else {
                buyMax=b;
                buyMin=a;
            }
            //当做好的包子最大和最小 和要的相等 true
            int canDo = n-m;
            if (mm[0]==buyMin && mm[m-1]==buyMax){
                System.out.println("YES");
            }else if (mm[0]>buyMin && mm[m-1]<buyMax && canDo>=2){
                System.out.println("YES");
            }else if (mm[0]==buyMin && mm[m-1]<buyMax && canDo>=1){
                System.out.println("YES");
            }else if (mm[0]>buyMin && mm[m-1]==buyMax && canDo>=1){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }




    }
    public static void main(String[] args) {
        Main();
    }
}
