package 蓝桥杯.练习系统.算法训练;

import java.math.BigDecimal;
import java.util.Scanner;

//4 3 2 20 30 15 2
public class q7猴子吃包子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a = 1000000000;
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int z1 = sc.nextInt();
        String bit = "%."+sc.next()+"f";

        double t1 = x1 * 1.0 / x;
        double t2 = y1 * 1.0 / y;
        double t3 = z1 * 1.0 / z;
        double time = t1 + t2 + t3;

        //BigDecimal b = new BigDecimal(time);
        //double f1 = b.setScale(bit, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(String.format(bit,time));//+"+(bit+"")+"

    }
}
