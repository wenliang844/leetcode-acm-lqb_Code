package 蓝桥杯.蓝桥杯大赛历届真题.第九届;

import java.math.BigInteger;

public class 填空3复数幂 {
    public static void main(String[] args) {
        /***
         4043220979119144065
         -7374402350132176768
         */
        long a = 2;
        long b = 3;
        long tempAlast=a;
        long tempBlast=b;
        //Integer a = 4043220979119144065;
        int n = 123456;
        for (int i = 1; i < 123456; i++) {
            long tempA = tempAlast*a -tempBlast*b;
            long tempB = (tempAlast*b) + (tempBlast*a);
            tempAlast = tempA;
            tempBlast = tempB;
        }

        System.out.println(tempAlast);
        System.out.println(tempBlast);

        test();
        test2();
    }

    static void test(){
        BigInteger a = new BigInteger("2");
        BigInteger b = new BigInteger("3");
        BigInteger tempAlast = new BigInteger("2");
        BigInteger tempBlast = new BigInteger("3");
        //Integer a = 4043220979119144065   -7374402350132176768
        int n = 123456;
        for (int i = 1; i < n; i++) {
            BigInteger tempA = tempAlast.multiply(a).subtract(tempBlast.multiply(b));
            BigInteger tempB = (tempAlast.multiply(b)).add(tempBlast.multiply(a));
            tempAlast = tempA;
            tempBlast = tempB;
        }

        System.out.println(tempAlast);
        System.out.println(tempBlast);
    }

    static void test2(){
        try {
            //改变输出流，输出到work.txt文件
            //PrintStream ps = new PrintStream(new FileOutputStream("G:\\work.txt"));
            //System.setOut(ps);  //文件输出  用System.out.println()即可将内容输出到文件中
            BigInteger a = new BigInteger("2");
            BigInteger b = new BigInteger("3");
            BigInteger x = new BigInteger("2");
            BigInteger y = new BigInteger("3");
            for(int i = 0; i < 123455; i++) {
                BigInteger t = x;
                x = x.multiply(a).subtract(y.multiply(b));
                y = t.multiply(b).add(y.multiply(a));
            }
            System.out.println(x + "" + ((y.compareTo(BigInteger.ZERO) > 0)? "+" : "") + y + "i");
        } catch (Exception e) {  //抛出异常
            e.printStackTrace();
        }
    }
}
