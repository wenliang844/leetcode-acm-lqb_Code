package ACM.每日一题leecode.day185;

public class day212_371两整数之和 {

    //给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
    public static void main(String[] args) {
        System.out.println(getSum(2, 3));
    }

    //100 83
    public static int getSum(int a, int b) {
        return a + b;
    }

    //方法二:位运算
    public static int getSum2(int a, int b) {

        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);

        return a + b;
    }

    //位运算
    public static int getSum3(int a, int b) {
        int sum,carry;
        sum = a^b;
        //carry = ((unsigned int)a&b)<<1;
        carry = (a & b) << 1;
        if(carry!=0){
            return getSum(sum,carry);
        }
        return sum;
        // return a+b;
    }
}
