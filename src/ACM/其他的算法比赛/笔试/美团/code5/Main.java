package ACM.其他的算法比赛.笔试.美团.code5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /***
     小美负责维护某人民公园内的所有银杏树。

     公园里有 n 棵银杏，编号为 1…n，第i棵树的高度为 hi。但是树木太多，她自己一个人肯定无法完成任务，于是她找了一些同学，并将他们分为两组。

     为了公平，小美要确定两组的工作量（总爬树高度）一样多，而且小美也要参与工作。于是小美这样安排：自己先选一棵树 x 进行修剪，编号为 [x + 1, n] 的树重新编号为 [x，n - 1]，[1，x - 1] 的部分编号不变。对于新的编号，奇数编号的树由一队同学修剪，偶数编号的树由另一队同学修剪。

     请帮小美计算，自己选择可以选择修剪哪些树才能让两组同学的工作量（总爬树高度）一样多。并输出方案数。



     输入描述
     第一行一个正整数 n，表示一共有 n 棵树；

     第二行 n 个正整数 hi，第 i 个正整数表示第 i 棵树高度为 hi。

     1 ≤ n ≤ 2×105, 1 ≤ hi ≤ 104。

     输出描述
     如果无论小美怎么选择，都没有一种方案可以使得两组工作量相同，则只输出一行一个数  0。

     否则输出两行，第一行输出一个正整数表示小美选择树的方案数，第二行从小到大输出小美可以选择修剪树的编号，每两个编号之间有一个空格。请不要输出行末空格。
     4
     1 4 2 3
     样例输出
     1
     3
     * @param args
     */
    /*public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        //1.暴力:直接新建一个数组,
        int temp[] = new int[n-1];
        for (int i = 0; i < n; i++) {

            //一个一个遍历
            int current = tree[i];//保存当前值
            for (int j = i+1; j < n; j++) {
                temp[j-1] = tree[j];
            }

            //进行累加,如果奇偶相等count++; 把curren给temp数组 记录i下标list
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < temp.length; j++) {
                if (j%2==0){
                    sum1+=temp[j];
                }else {
                    sum2+=temp[j];
                }
            }

            if (sum1 == sum2){
                count++;
                list.add(i+1);
            }

            if (i<temp.length){
                temp[i] = current;
            }
        }

        //输出count 以及list
        if (count==0){
            System.out.println(0);
        }else {
            System.out.println(count);
            System.out.print(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                System.out.print(" "+list.get(i));
            }
        }

    }*/
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        //1.暴力:直接新建一个数组,
        //int temp[] = new int[n-1];
        for (int i = 0; i < n; i++) {

           /* //一个一个遍历
            int current = tree[i];//保存当前值
            for (int j = i+1; j < n; j++) {
                temp[j-1] = tree[j];
            }*/

            //进行累加,如果奇偶相等count++; 把curren给temp数组 记录i下标list
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < i; j++) {
                if (j%2==0){
                    sum1+=tree[j];
                }else {
                    sum2+=tree[j];
                }
            }
            for (int j = i+1; j < n; j++) {
                if (j%2==0){
                    sum2+=tree[j];
                }else {
                    sum1+=tree[j];
                }
            }

            if (sum1 == sum2){
                count++;
                list.add(i+1);
            }

            /*if (i<temp.length){
                temp[i] = current;
            }*/
        }

        //输出count 以及list
        if (count==0){
            System.out.println(0);
        }else {
            System.out.println(count);
            System.out.print(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                System.out.print(" "+list.get(i));
            }
        }

    }
}
