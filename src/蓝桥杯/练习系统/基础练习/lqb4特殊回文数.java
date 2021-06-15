package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

public class lqb4特殊回文数 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //5位的数字
        //满足前两位=后两位,中间1-9都可以,从1开始
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                //i j k j i
                //0-9

                /*for (int k = 0; k < 9; k++) {
                    int temp = num+k*100;
                    if ()
                }*/
                //固定了4个数字
                int sum = i + j + i + j;
                int sub = n - sum;
                if (sub >= 0 && sub <= 9) {
                    int num = i * 10000 + j * 1000 + sub * 100 + j * 10 + i;
                    System.out.println(num);
                }
            }
        }

        //6位的数字
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <=9 ; j++) {
                for (int k = 0; k <=9 ; k++) {
                    int sum = (i+j+k)*2;
                    if (n==sum){
                        int num=i*100000+j*10000+k*1000+k*100+j*10+i;
                        System.out.println(num);
                    }
                }

            }
        }
    }
}
