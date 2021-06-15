package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q21前缀表达式 {

    public static void main(String[] args) {
        //对前缀表达式从后向前扫描
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int ans = 0;
        switch (s){
            case "+":
                ans = plus(n1,n2);break;
            case "-":
                ans = sub(n1,n2);break;
            case "*":
                ans = mul(n1,n2);break;
            case "/":
                ans = div(n1,n2);break;
        }
        System.out.println(ans);
    }

    private static int div(int n1, int n2) {
        return n1/n2;
    }

    private static int mul(int n1, int n2) {
        return n1*n2;
    }

    private static int sub(int n1, int n2) {
        return n1-n2;
    }

    private static int plus(int n1, int n2) {
        return n1+n2;
    }
}
