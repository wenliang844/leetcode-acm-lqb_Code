package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q13最小公倍数 {
    public static void main(String[] args) {
        //最小公倍数 = 两数相乘 / 最大公因数
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        //保持num1的最大性
        if (num1 < num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }

        int num = getNum(num1, num2);
        //System.out.println(num);
        System.out.println(num1 * num2 / num);

    }

    //最大公因数
    //高效:辗转想除法 反复用被除数 除商 直到余数0   return被除数
    public static int getNum(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        } else {
            return getNum(num2, num1 % num2); //用32 6来证明
        }
    }
}
