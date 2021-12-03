package ACM.其他的算法比赛.笔试.网易2;

import java.util.Scanner;

public class wy2数字变换 {
    public static void main(String[] args) {

        //将b/a 最多分解成几个数相乘 8=2 2 2   10=5*2  63=3*3*7
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (b%a!=0){
            System.out.println(-1);
            return;
        }
        int sub = b/a;

        int count = 1;
        boolean flag = true;
        while (flag){
            System.out.println("---sub:"+sub);
            flag = false;
            for (int i = 2; i <= Math.sqrt(sub); i++) {
                if (sub%i==0){
                    flag = true;
                    sub=sub/i;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
