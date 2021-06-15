package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;
import java.util.Stack;

public class q11表达式计算 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();//1-2+3*(4-5)        -4
        Stack<Character> operStack = new Stack<>();
        Stack<Character> numStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // num 符号 () 三种情况   优先级问题由数字决定 */代表1 +-代表0
            char ch = str.charAt(i);
            if (String.valueOf(ch).matches("\\d")) {//代表匹配数字
                numStack.push(ch);
            } else if (ch == '(') {
                //System.out.println("这是一个(");
                operStack.push(ch);
                //System.out.println(operStack);
            } else if (ch == ')') {
               // System.out.println(operStack);
                while (operStack.peek() != '(') {
                    numStack.push(operStack.pop());
                }
                operStack.pop();
                //System.out.println("这是()中间的符号都出栈后的operStack:" + operStack);
            } else {

                while (!operStack.isEmpty() && whoBig(operStack.peek()) >= whoBig(ch)) {//只有你的优先级高才能压住 不然出栈
                    numStack.push(operStack.pop());
                }

                operStack.push(ch);//最后不管怎么样,ch要入符号栈
            }
           // System.out.println("这是第i次遍历后的结果" + i + "--" + operStack + numStack);
        }

        //将operStack全部出栈到numstack
        while (operStack.size() > 0) {
            numStack.push(operStack.pop());
        }
        //将numStack 打印为一个string
        StringBuilder sb = new StringBuilder();
        for (Character character : numStack) {
            //System.out.print(character + " ");
            sb.append(character);
        }

        //System.out.println("这是最终的数栈:" + numStack);
        //System.out.println(sb.toString());

        Stack<Integer> stack = new Stack<>();
        //对这个后缀表达式进行计算
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                stack.add(c - '0');
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.add(calc(num2,num1, c));
            }
        }
        System.out.println(stack.peek());

    }

    private static Integer calc(int num1, int num2, char c) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return null;
        }
    }

    //比较优先级 优先级问题由数字决定 */代表1 +-代表0
    public static int whoBig(char ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 0;
        } else { //这里有运算符是(的情况 (情况下运算符直接入栈 所以括号直接当优先级小统一处理,以被运算符压住
            return -1;
        }
    }
}
