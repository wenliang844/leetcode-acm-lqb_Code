package ACM.每日一题leecode.day185;

import java.util.Map;

public class day229_367有效的完全平方数 {
    public static void main(String[] args) {

        System.out.println(isPerfectSquare(5));
        System.out.println(isPerfectSquare(4));
    }

    //线性查找 5|38
    public static boolean isPerfectSquare(int num) {
        for (int i = 0; i <= Math.sqrt(num); i++) {
            if (i*i==num){
                return true;
            }
        }
        return false;

    }
}
