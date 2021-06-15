package ACM.其他的算法比赛.笔试.美团.code3;

import java.util.Scanner;

public class Main {
    /***
     第一行两个数 n, m。(1 ≤ n, m ≤ 50000)。

     第二行 n 个数，第 i 个数是 ai。(1 ≤ ai ≤ 1000000000)。

     接下来 m 行，每行一个数 x (1 ≤ x ≤ 1000000000)，代表一次询问。

     输出描述
     输出 m 行，若数 x 出现过，输出数 x 第一次出现的位置和最后一次出现的位置。若数 x 没出现过，输出 0。
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        while (m-- >0){
            int q = sc.nextInt();
            int start = 10;
            int end = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i]==q){
                    start = i+1;
                    break;
                }
            }

            for (int i = a.length-1; i >= 0; i--) {
                if (a[i]==q){
                    end = i+1;
                    break;
                }
            }

            if (start>end){
                System.out.println(0);
            }else {
                System.out.println(start+" "+end);
            }
        }
    }
}
