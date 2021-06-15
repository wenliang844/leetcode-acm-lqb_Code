package 蓝桥杯.蓝桥杯大赛历届真题.第八届.决赛;

import java.util.Scanner;

public class code3区间移位 {

    public static void main(String[] args) {
        /***
         排序:然后计算max
         边上的两个max=缝隙
         中间的max=缝隙/2

         按照右端点排序
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int section[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            section[i][0]=sc.nextInt();
            section[i][1]=sc.nextInt();
        }

        //根据0排序

        double min = 0;
        min = Math.max(min,section[0][0]);
        min = Math.max(min,10000-section[n-1][1]);
        //找缝隙
        for (int i = 0; i < n-1; i++) {
            if (section[i][1]<section[i+1][0]){
                min = Math.max(min,(section[i+1][0]-section[i][1])*1.0/2);
            }
        }

        System.out.println(min);

    }
}
