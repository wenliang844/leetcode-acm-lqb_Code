package ACM.每日一题leecode.day66;

import java.util.Stack;

public class day78_150逆波兰表达式求值 {

    /***
     根据 逆波兰表示法，求表达式的值。

     有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     说明：
     整数除法只保留整数部分。
     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

     输入：tokens = ["2","1","+","3","*"]
     输出：9
     解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     */
    public static int calculate(int num2, int num1, String s) {
        switch (s) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }

        return 0;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            //如果是符号,将栈的两个数字pop,相加 Integer.parse
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(calculate(num1,num2,tokens[i]));
                //System.out.println(num1 +"-"+ num2);
                //System.out.println(stack);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        //System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));//9
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));//6
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));//22
    }
}
