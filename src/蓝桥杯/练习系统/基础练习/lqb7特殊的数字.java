package 蓝桥杯.练习系统.基础练习;

public class lqb7特殊的数字 {
    public static void main(String[] args) {

        for (int i = 100; i <=999 ; i++) {

            int num1 = i%10;
            int num2 = i/10%10;
            int num3 = i/100%10;
            if (num1*num1*num1 + num2*num2*num2+num3*num3*num3==i){
                System.out.println(i);
            }

        }
    }
}
