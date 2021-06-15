package 蓝桥杯.练习系统.算法训练;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class q14两个复数的运算 {
    /***
     除法:本身*分母的共轭复数(-虚部) / 分母的实部平方 + 虚部平方
     保留两位小数:
     1.直接*100/100
     2.double df = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
     3.DecimalFormat    df   = new DecimalFormat("######0.00");
     * @param args
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        double n1 = scanner.nextDouble();
        double n2 = scanner.nextDouble();
        double n3 = scanner.nextDouble();
        double n4 = scanner.nextDouble();

        double[] ans = new double[2];
        switch (c) {
            case '+':
                ans = plus(n1, n2, n3, n4);
                break;
            case '-':
                ans = sub(n1, n2, n3, n4);
                break;
            case '*':
                ans = mul(n1, n2, n3, n4);
                break;
            case '/':
                ans = div(n1, n2, n3, n4);
                break;
        }
        //double f1 = new BigDecimal(ans[0]).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //double f2 = new BigDecimal((ans[1])).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        String f1 = new DecimalFormat("#.00").format(ans[0]);
        String f2 = new DecimalFormat("#.00").format(ans[1]);
        //String result = String .format("%.2f");
        //System.out.println(f1);
        //System.out.println(f2);
        System.out.println(f1+"+"+f2+"i");
    }

    private static double[] div(double n1, double n2, double n3, double n4) {
        double[] nums = mul(n1,n2,n3,-n4);
        double num2 = n3*n3 + n4*n4;
        return new double[]{nums[0]/num2,nums[1]/num2};
    }

    private static double[] mul(double n1, double n2, double n3, double n4) {
        double num1 = n1*n3 - n2*n4;
        double num2 = n2*n3 + n1-n4;
        return new double[]{num1,num2};
    }

    private static double[] sub(double n1, double n2, double n3, double n4) {
        double num1 = (n1 - n3) * 100 / 100;
        double num2 = (n2 - n4) * 100 / 100;
        //String ans = (num1*100/100) +"+" + (num2*100/100)+"i";

        return new double[]{num1, num2};
    }

    //加法,直接实部和虚部直接加
    private static double[] plus(double n1, double n2, double n3, double n4) {
        double num1 = (n1 + n3);
        double num2 = (n2 + n4);
        //String ans = (num1*100/100) +"+" + (num2*100/100)+"i";

        return new double[]{num1, num2};
    }
}
