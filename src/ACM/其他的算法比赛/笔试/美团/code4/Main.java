package ACM.其他的算法比赛.笔试.美团.code4;

import java.util.Scanner;

public class Main {
    /***
     小美超级幸运，这不今天又双叒叕中奖了！！！主办方给了小美 n 个积分球，从左到右排成一行，第 i 个积分球的积分为 ai 。让小美自行选取其中一段连续的积分球，最多选取k 个。假设小美选取了 [l, r] 这个区间中的积分球，小美获得的积分为al⊕al+1⊕…⊕ar-1⊕ar。例如，小美选取了 [3, 4, 2] 这三个积分球那么小美最终获得的积分为 3⊕4⊕2 = 5。

     小美想要获得最多的积分。小美虽然幸运，但是却被这个难题难倒了，请你帮帮小美，帮她获得更多积分。

     ⊕：异或运算的数学符号。其运算法则相当于不带进位的二进制加法：二进制下用1表示真，0表示假，则异或的运算法则为：0⊕0=0，1⊕0=1，0⊕1=1，1⊕1=0（同为0，异为1），这些法则与加法是相同的，只是不带进位，所以异或常被认作不进位加法。例如：3⊕5=(011)2 ⊕ (101) 2 = (110) 2 = 6。

     异或在C语言中表示为^。



     输入描述
     第一行两个数 n, k。(1 ≤ n, k ≤ 100000)。

     第二行 n 个数，第 i 个数是 ai。(0 ≤ ai ≤ 1000000000)。

     输出描述
     输出一个数，代表小美能够获得的最多积分。
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        if (k==0){
            System.out.println(0);
            return;
        }
        long max = 0;
        //for (int i = 0; i < n - k+1; i++) {
            for (int j = 0; j < n - k + 1; j++) {//连续的

                long temp = a[j];
                max = Math.max(max,temp);
                //System.out.println(a[j]);
                for (int l = j+1; l < j + k; l++) {
                    temp = temp ^ a[l];
                    max = Math.max(max,temp);
                    //System.out.println(a[l]);
                }
                //System.out.println("这是tmep"+temp);

                max = Math.max(max,temp);
            }
        //}
        System.out.println(max);

    }
}
