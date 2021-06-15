package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q19排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        if (n1>n2){
            if (n1>n3){
                System.out.print(n1+" ");
                if (n2>n3){
                    System.out.print(n2+" ");
                    System.out.print(n3+" ");
                }else {
                    System.out.print(n3+" ");
                    System.out.print(n2+" ");
                }
            }else {
                System.out.print(n3+" ");
                System.out.print(n1+" ");
                System.out.print(n2+" ");
            }
        }else {//n1 < n2
            if (n2>n3){
                System.out.print(n2+" ");
                if (n1>n3){
                    System.out.print(n1+" ");
                    System.out.print(n3+" ");
                }else {
                    System.out.print(n3+" ");
                    System.out.print(n1+" ");
                }
            }else {//n2<n3
                System.out.print(n3+" ");
                System.out.print(n2+" ");
                System.out.print(n1+" ");
            }
        }
    }
}
