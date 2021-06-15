package 蓝桥杯.lan真题训练.lan2020省赛javaB组;

public class C数列求值 {

    /*
    给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求
第 20190324 项的最后 4 位数字。
     */
    public static void main(String[] args) {

        long a = 1;
        long b = 1;
        long c = 1;
        //201903242
        //取模  %10000
        //前面也可以 直接取模       尾部加的数不变     进位不影响后面的尾数
        long sum = 0;
        for (long i = 4; i <= 20190324; i++) {
            sum = (a+b+c)%10000;
            //long temp=a;
            a=b;
            b=c;
            c=sum;
        }

        System.out.println(sum);
        System.out.println(sum%10000);
    }
}
