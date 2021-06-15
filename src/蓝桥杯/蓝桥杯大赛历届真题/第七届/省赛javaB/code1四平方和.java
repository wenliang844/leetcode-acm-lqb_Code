package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

import java.util.Scanner;

public class code1四平方和 {
    /**

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int limited = (int) Math.sqrt(N);
        boolean flag = false;
        for (int i = 0; i <= limited; i++) {
            if (flag)break;
            for (int j = 0; j <=limited; j++) {
                if (flag)break;
                for (int k = 0; k <= limited; k++) {
                    if (flag)break;
                    for (int l = 0; l <= limited; l++) {
                        if (i*i + j*j + k*k+ l*l == N){
                            System.out.println(i+" "+j+" "+k+" "+l);
                            flag=true;
                            break;
                        }
                    }
                }
            }
        }
    }
}
