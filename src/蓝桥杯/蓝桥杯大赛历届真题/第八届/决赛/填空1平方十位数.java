package 蓝桥杯.蓝桥杯大赛历届真题.第八届.决赛;

import java.math.BigInteger;

public class 填空1平方十位数 {
    public static void main(String[] args) {
        //System.out.println(Math.sqrt(9876543210));
        System.out.println(Math.sqrt(1026753849));
        System.out.println(Math.sqrt(1026753850));
        System.out.println(Math.sqrt(1026753849)%1==0);//是整数
        System.out.println(Math.sqrt(1026753850)%1==0);//不是整数

        System.out.println(32043*32043);
        System.out.println(42043*42043);
        BigInteger limit = new BigInteger("9876543210");
        for (int i = 32043; i < 10000000; i++) {
            BigInteger bigInteger1 = new BigInteger(i+"");
            BigInteger multiply = bigInteger1.multiply(bigInteger1);
            if (bigInteger1.compareTo(limit)==-1){//小于  9814072356
                if (judge(multiply)){
                    System.out.println(bigInteger1+"==="+multiply);
                }
            }else {
                break;
            }
        }
    }

    private static boolean judge(BigInteger multiply) {
        String s = multiply+"";
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i)==s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
