package 蓝桥杯.官方小模拟;

import java.util.Scanner;

public class F给底高求三角面积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double l = sc.nextDouble();
        double h = sc.nextDouble();
        if ((l*h)%2==0){
            System.out.printf("%.0f",(l*h)/2);
        }else{
            System.out.printf("%.1f",(l*h)/2);
        }


    }
}
