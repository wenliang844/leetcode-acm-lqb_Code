package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q18图形显示 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = n; i >0; i--) {
            //输出n个*号
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
