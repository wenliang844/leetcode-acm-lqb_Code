package 数据结构算法教程.java数据结构算法.第3节_stack;

import java.util.Stack;

public class stack实现综合计算器 {
    /****
     * 关于stak的一切   两个栈实现综合计算器 7*7*7-5+3*4
     第一个栈存放数字numStack
     第二个站存放符号的operationStack
     使用栈完成 表达式的结果::
     创建一个指针index 一个值 其实就是一个进行对字符串扫描的一个索引
     遍历表达式
     1.idnex发现第一个是7就直接入数栈;
     2.扫描到的是一个符号:分如下情况来解决
     3.发现当前的符号栈为空直接入栈
     4.   不为空:看优先级
     5.如果栈顶的优先级高,就要操作栈 低,就不操作直接入栈
     6.将运算的结果入栈,当前扫描的符号也入栈
     7.当表达式扫描完毕 就顺序的从数栈和符号栈中pop出相应数和符号进行运算
     8.最后的数栈中的数字,就是表达式的结果
     * @param args
     */

    /***
     正数：r = 20 << 2
     　　20的二进制补码：0001 0100
     　　向左移动两位后：0101 0000
     　　　　   　　结果：r = 80
     注：以下数据类型默认为byte-8位
     正数：r = 20 >> 2
     　　20的二进制补码：0001 0100
     　　向右移动两位后：0000 0101
     　　　　　　　结果：r = 5
     * @param
     */

    public static void Mytest1() {
        System.out.println(1 << 35);//数字左移  右移
        System.out.println(1 << 3);//8  答案一样   应为int只有32位,超过的进行mod截取
        getNums();
        //System.out.println(7 * 2 - 4 + 2 * 3);
        //System.out.println("result==" + Calc_PlusSubDevideMul("32+3-3"));
    }

    //这是一位数字的解法 多位数字请看test3
    public static void TeacherTest2(String expression) {
        //属于中缀表达式
        //根据思路老师的,进行表达式的运算
        //创建两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每一个扫描得到的char保存到ch
        //开始while循环的搜啊秒expperssion
        while (true) {
            //一次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么做响应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                //判断栈是否胃空
                if (!operStack.isEmpty()) {
                    //有,进行操作符的比较,当前的操作符小就进行下面的操作   取值运算进出栈操作
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        //进行运算 把数栈出两个数  符号栈一个符号
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果入栈
                        numStack.push(res);
                        operStack.push(ch);//还需要把当期的操作符入栈
                    } else {
                        //运算符大,直接入栈
                        operStack.push(ch);
                    }
                } else {
                    //为空 那就是第一个,栈里面没有符号  直接如何入栈
                    operStack.push(ch);
                }
            } else {
                //如果是数  直接入数栈
                numStack.push(ch - 48);// 1 ->ascll49
            }
            //让idex+1  并判断是否扫描到了expression的最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //扫描完了就顺序的计算stack中的符号  数栈
        while (true) {
            //如果符号栈为空,则计算到了最后的结果,数栈中只一个结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);


        }
        //将最后的数栈中的数字pop出来就是一个结果
        System.out.println("表达式是结果:" + expression + "==" + numStack.pop());


    }

    /***
     数字的时候,如果后面还是数,进行拼接   如果是字符 直接运算
     定义一个keepNumber进行拼接多位数
     * @param expression
     */
    public static void TeacherTest3(String expression) {
        //属于中缀表达式
        //根据思路老师的,进行表达式的运算
        //创建两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每一个扫描得到的char保存到ch
        String keepNumber = "";//用于拼接数字
        //开始while循环的搜啊秒expperssion
        while (true) {
            //一次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么做响应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                //判断栈是否胃空
                if (!operStack.isEmpty()) {
                    //有,进行操作符的比较,当前的操作符小就进行下面的操作   取值运算进出栈操作
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        //进行运算 把数栈出两个数  符号栈一个符号
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果入栈
                        numStack.push(res);
                        operStack.push(ch);//还需要把当期的操作符入栈
                    } else {
                        //运算符大,直接入栈
                        operStack.push(ch);
                    }
                } else {
                    //为空 那就是第一个,栈里面没有符号  直接如何入栈
                    operStack.push(ch);
                }
            } else {
                //如果是数  直接入数栈
                //numStack.push(ch - 48);// 1 ->ascll49
                /***
                 处理多位数 采用keepNumber变量进行一个拼接

                 */
                keepNumber += ch;
                //判断下一个字符是不是数字,如果是数组就进行继续扫描 符号则数入栈

                //如果已经是最后一位,直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNumber));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {//如果是字符了,就停止拼接数,否则不执行这段,还是继续拼接数字
                        //如果是运算符 入栈 "1"  "123"
                        numStack.push(Integer.parseInt(keepNumber));
                        //重要 keepNumber清空
                        keepNumber = "";
                    }
                }


            }
            //让idex+1  并判断是否扫描到了expression的最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //扫描完了就顺序的计算stack中的符号  数栈
        while (true) {
            //如果符号栈为空,则计算到了最后的结果,数栈中只一个结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);


        }
        //将最后的数栈中的数字pop出来就是一个结果
        System.out.println("表达式是结果:" + expression + "==" + numStack.pop());


    }

    public static void main(String[] args) {
        System.out.println("系统雁阵=" + (3 + 2 * 6 - 2));
        TeacherTest3("3+2*6-2");
        TeacherTest3("70+2*6-2");
        //TeacherTest3("(70+2)*6-2");

    }

    public static void getNums() {
        /***
         思想1:相减
         思想2:相同的数 抵消
         异或:相同为0
         异或为本身
         (1^2^3^4^4)^(1^2^3^4)
         */
        int nums[] = new int[1001];
        for (int i = 1; i < 1001; i++) {
            nums[i] = i;
        }
        nums[0] = 5;

        for (int i = 1; i < 1001; i++) {
            nums[0] += nums[i];
        }
        nums[1] = 0;
        for (int i = 1; i <= 1000; i++) {
            nums[1] += i;
        }
        System.out.println(nums[0] - nums[1]);
    }

    public static int Calc_PlusSubDevideMul(String s) {
        /***
         计算器:两个栈实现
         */
        int result = 0;
        Stack<Integer> numstack = new Stack<Integer>();
        Stack<Character> oprationstack = new Stack<Character>();

        System.out.println("这是表达式=" + s);
        for (int i = 0; i < s.length(); ) {
            boolean isNum = false;
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/') {
                isNum = true;
                sb.append(s.charAt(i));
                i++;
            }
            if (isNum) {
                int num = Integer.parseInt(sb.toString());
                numstack.add(num);
                System.out.println("这是num=" + num);
            } else {
                System.out.println("这是操作符" + s.charAt(i));
                while (oprationstack.size() > 0) {
                    if (isBig(oprationstack.peek(), s.charAt(i))) {
                        //进行运算 将numstack里的两个数和stack.pop进行运算
                        int sum = calc_doubleNum(numstack.pop(), oprationstack.pop(), numstack.pop());
                        //result += sum;
                        numstack.add(sum);
                    }
                }
                oprationstack.add(s.charAt(i));
                i++;
            }
        }

        System.out.println(numstack);
        System.out.println(oprationstack);
        while (oprationstack.size() > 0) {
            numstack.add(calc_doubleNum(numstack.pop(), oprationstack.pop(), numstack.pop()));
        }


        return numstack.pop();

    }

    public static boolean isBig(char peek, char charat) {//比较优先级
        if (peek == '*' || peek == '/') {
            return true;
        } else if (charat == '+' || charat == '-') {
            return true;
        } else {
            return false;
        }
    }

    public static int calc_doubleNum(int one, char oper, int two) {
        switch (oper) {
            case '+':
                return two + one;
            case '-':
                return two - one;
            case '*':
                return two * one;
            case '/':
                return two / one;
            default:
                System.out.println("出错了,请输入正确的运算符~~~");
                return 0;
        }
    }


}


class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;//表示栈底 初始化-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("isFull~~");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈 数据返回 return value
    public int pop() {
        //判断空
        if (isEmpty()) {
            System.out.println("isEmpty~~~");
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //list遍历stack   要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空~~~不能先四数据");
            return;
        }
        //需要从栈顶开始打印数据
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + "--");
        }
        System.out.println();

    }


    //返回运算符的优先级,优先级是程序员来确定的,优先级采用数字表示,假定数字越大优先级高
    public int priority(int oper) {//操作符由程序员确定,char字符的底层也是一个数字,可以运算
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            System.out.println("操作有误~");
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;//用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                System.out.println("输入有误~~~不能运算");
        }
        return res;
    }

    //增加一个方法peek,可以返回当前栈顶的值,但是不是站赠你的pop  只是看一眼
    public int peek() {
        return stack[top];
    }
}
















