package 蓝桥杯.练习系统.算法训练;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;

public class q38最大最小公倍数 {
    //贪心算法,找3个 从N开始 到1   95152 861460772824848
    public static void main(String[] args) {
        System.out.println(Math.pow(10,6));
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = N; i>0; i--) {
            for (int j = i-1; j >0; j--) {
                if (check(i,j))
                for (int k = j-1; k >0 ; k--) {
                    if (check(i,k) && check(j,k)){
                        //System.out.println(i+" "+j+" "+k);
                        //System.out.println(i*j*k);
                        BigInteger bigDecimal1 = new BigInteger(i+"");
                        bigDecimal1 = bigDecimal1.multiply(new BigInteger(j+""));
                        bigDecimal1 = bigDecimal1.multiply(new BigInteger(k+""));
                        System.out.println(bigDecimal1);
                        return;
                    }
                }
            }
        }
    }

    //是互质数 true -> 辗转 相除法,互质则为1  互质最大公约数为1
    private static boolean check(int i, int j) {

        while (i%j!=0){
            if (i%j==1){
                return true;
            }
            int temp = i%j;
            i=j;
            j=temp;
        }
        return false;
    }
}
