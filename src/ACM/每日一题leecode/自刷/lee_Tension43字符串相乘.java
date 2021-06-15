package ACM.每日一题leecode.自刷;

import java.math.BigDecimal;
import java.math.BigInteger;

public class lee_Tension43字符串相乘 {
    /***
     定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

     示例 1:
     输入: num1 = "2", num2 = "3"
     输出: "6"
     示例 2:
     输入: num1 = "123", num2 = "456"
     输出: "56088"
     */
    //方法一:调用apl
    public static String multiply(String num1, String num2) {

        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));//BigInteger()
    }

    //方法二:自己处理,调用bigInterger_API 43/33
    public static String multiply2(String num1, String num2) {

        int number1 = num1.charAt(0) - '0';
        for (int i = 1; i < num1.length(); i++) {
            number1 = number1 * 10 + num1.charAt(i) - '0';
        }
        //System.out.println(number1);

        int number2 = num2.charAt(0) - '0';
        for (int i = 1; i < num2.length(); i++) {
            number2 = number2 * 10 + num2.charAt(i) - '0';
        }
        //System.out.println(number2);

        //BigDecimal bigDecimal1 = new BigDecimal(number1);
        //BigDecimal bigDecimal2 = new BigDecimal(number2);
        //BigDecimal ans = bigDecimal1.multiply(bigDecimal2);
        //System.out.println(ans);
        BigInteger bigInteger1 = new BigInteger(num1);
        BigInteger bigInteger2 = new BigInteger(num2);
        BigInteger ans = bigInteger1.multiply(bigInteger2);
        return ans+"";
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
        System.out.println(multiply2("123", "456"));
        System.out.println(multiply2("9", "99"));
        System.out.println(multiply2("123456789", "987654321"));
        System.out.println(multiply2("6913259244","71103343"));
    }
}
