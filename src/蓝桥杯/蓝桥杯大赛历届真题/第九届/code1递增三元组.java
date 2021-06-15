package 蓝桥杯.蓝桥杯大赛历届真题.第九届;

import java.util.Scanner;

public class code1递增三元组 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] num1 = new int[n];
        int[] num2 = new int[n];
        int[] num3 = new int[n];
        for (int i = 0; i < n; i++) {
            num1[i]=sc.nextInt();
        } for (int i = 0; i < n; i++) {
            num2[i]=sc.nextInt();
        } for (int i = 0; i < n; i++) {
            num3[i]=sc.nextInt();
        }
        //遍历三次
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (num1[i]<num2[j] && num2[j]<num3[k]){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
