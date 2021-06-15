package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

public class lqb12字母图形 {
    public static void main(String[] args) {
        //0-1  1-7
        //0-2 2-7

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//行
        int m = sc.nextInt();//列 0-0 1-7
        int point = 0;//point==7 point==0;
        for (int i = 0; i < n; i++) {

            for (int j = point; j >=0; j--) {
                System.out.print((char)('A'+j));
            }
            for (int j = 1; j < m-point; j++) {
                System.out.print((char)('A'+j));
            }
            System.out.println();
            point++;
            if (point==m){
                point=0;
            }
        }
    }
}
