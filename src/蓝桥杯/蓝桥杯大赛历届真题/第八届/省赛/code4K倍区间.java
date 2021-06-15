package 蓝桥杯.蓝桥杯大赛历届真题.第八届.省赛;

import java.util.Scanner;

public class code4K倍区间 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        //k被区间: 暴力搜   ----------需要有时间进行优化的
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;
        /*for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                //i - n的区间 求和
                int sum = 0;
                for (int l = i; l <=j; l++) {
                    sum += a[l];
                }
                System.out.println(i+"--"+j+"--==="+sum);

                if (sum%k==0){
                    count++;
                }
            }
        }*/

        for (int i = 0; i < n; i++) {
                //i - n的区间 求和
            int sum =0;
                for (int l = i; l <n; l++) {
                    sum += a[l];
                    //System.out.println(i + "--" + l + "--===" + sum);

                    if (sum % k == 0) {
                        count++;
                    }
                }

        }
        System.out.println(count);
    }
}
