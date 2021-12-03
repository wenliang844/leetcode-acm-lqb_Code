package ACM.每日一题leecode.day185;

import java.util.HashMap;
import java.util.Map;

public class day215_166分数到小数 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(1, 5));
    }

    //1.暴力破解: 考虑整数,小数,循环小数情况
    public static String fractionToDecimal(int numerator, int denominator) {

        if (numerator % denominator == 0) {
            return String.valueOf(numerator / denominator);
        } else {
            double res = numerator * 1.0 / denominator;
            System.out.println("double:" + res);
            String s = String.valueOf(res);
            //判断s是否是循环小数 是循环小数的长度大 直接将.后面的数字进行判断
            if (s.length() > 100) {
                String[] split = s.split(".");
                String tempS = split[1];
                //长度遍历
//                for (int i = 1; i < tempS.length(); i++) {
//                    String substring = tempS.substring(0, i);
//
//                }
                return s;
            } else {
                return s;
            }
        }
    }

    //java 1ms 100%，就是用哈希表记录所有被除数的下标，如果出现了重复的被除数，则证明出现了循环，把左括号塞到记录的下标位置，右括号放在最后
    public static String fractionToDecimal2(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long a = numerator, b = denominator;
        if (a > 0 && b < 0 || a < 0 && b > 0) {
            sb.append('-');
        }
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        if (a % b == 0) {
            return sb.toString();
        }
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            map.put(a, sb.length());
            sb.append(a / b);
        }
        if (a == 0) {
            return sb.toString();
        }
        return sb.insert(map.get(a).intValue(), '(').append(')').toString();
    }


}
