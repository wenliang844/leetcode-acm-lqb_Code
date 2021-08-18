package 数据结构算法教程.java数据结构算法.第3节_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/****
 科普:逆波兰表达式计算器完整版
 1.支持 + - * /()
 2.多位数 ,小数
 3.兼容处理,过滤任何的空白字符,包括空格 制表,换页

 小数点:2.1 + 2.3
        2.1-2.3
        2.4/1.24  同时扩大和缩小  没有的补0即可
        2.4*2.1  同时扩大和缩小

 */
public class stack计算器_前缀中缀后缀表达式 {
    /****
     前缀+21                        -*+3456
     中缀--就是1+2                  (3+4)*5-6   就是最常见的人运算表达式 这个需要判断运算符的优先级,需要上下文 括号问题--难度
     后缀表达式(逆波兰表达式)22+5-   3456+*-     一般用中缀表达式转成后缀表达式进行运算

     前缀表达式的计算机求值:
     从右扫描,遇到数组压入栈,遇到运算符弹出栈顶两个数进行运算,并将结果入栈 ,得到的结果就是最终的结果
     *
     */
    public static void Mytest1() {
        System.out.println("这是结果=" + proStack("-*+3456"));
        System.out.println("这是结果=" + leastStack("34+5*6-"));//34+5*6-  =>(3 +4)*5-6=29
    }

    public static void teachersTests1() {
        //先定义一个逆波兰表达式
        //3 4 + 5 * 6 -  ====>(3 +4)*5-6=29
        //为了方便说明,逆波兰表达式的数字和字符使用空格分开
        String s = mediumToLeast("1+((2+3)*4)-5");
        System.out.println("这是经过逆波兰转换的字符串===" + s);
        String suffixExpression = "3 4 + 5 * 6 -";
        //思路
        //1.现将3 4 + 5 * 6 -放到ArrayList中
        //2.将Arraylist传递给一个方法, 遍历arraylist 这个方法配合栈完成计算
        List<String> rpList = getListString(suffixExpression);
        System.out.println("rpList=" + rpList);
        System.out.println("这是老师的劳动结果" + calc_teacherLeastStack(rpList));//计算的结果 测试结果:非常正确

    }

    public static void techersTest2() {
        List<String> teacherList = teacher();
        System.out.println(teacherList);
    }

    public static void main(String[] args) {
        //Mytest1();
        //teachersTests1();
        techersTest2();
    }

    public static int proStack(String str) {
        /***
         前缀表达式求值
         //不需要判断优先级了,因为在中缀构造前缀表达式的时候已经进行了一个优先级构造 直接计算就可以了
         Integer.paserInt()  字符串变数字
         */
        Stack<Integer> stack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '+') {
                stack.push(stack.pop() + stack.pop());
                continue;
            } else if (str.charAt(i) == '-') {
                stack.push(stack.pop() - stack.pop());
                continue;
            } else if (str.charAt(i) == '*') {
                stack.push(stack.pop() * stack.pop());
                continue;
            } else if (str.charAt(i) == '/') {
                stack.push(stack.pop() / stack.pop());
                continue;
            }
            stack.push(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        return stack.pop();
    }

    public static int leastStack(String str) {
        /***
         实现逆波兰表达式{后缀}求值
         栈后一个操作栈顶 需要中间变量承接值
         */
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            switch (str.charAt(i)) {
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-':
                    int num = stack.pop();
                    stack.push(stack.pop() - num);
                    break;
                case '*':
                    stack.push(stack.pop() * stack.pop());
                    break;
                case '/':
                    int num1 = stack.pop();
                    stack.push(stack.pop() / num1);
                    break;
                default:
                    stack.push(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }
        return stack.pop();
    }

    public static int calc_teacherLeastStack(List<String> ls) {
        //完成对逆波兰表达式的计算
        //创建一个栈,只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //使用正则表达式来取出数
            if (item.matches("\\d+")) {//匹配多位数
                stack.push(item);
            } else {
                //如果不是就弹出两个数进行运算,运算的符号就是item ,再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    System.out.println("这个item啥也不是啊,跳过这个奇怪的字符把~~~");
                    throw new RuntimeException("UN算符有误~");
                }
                //res入栈
                stack.push(res + "");//直接加一个空字符串可以很好的转化成字符串
            }
        }

        //最后留在stack中的数据就是结果了~
        return Integer.parseInt(stack.pop());
    }

    //将一个逆波兰表达式依次将数据和运算符放入一个arraylist中
    public static List<String> getListString(String suffixExpression) {
        //1.将sufixExpression进行分隔  按照空格
        String[] split = suffixExpression.split(" ");
        //System.out.println(split[0]);
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static String mediumToLeast(String str) {
        /****
         比如
         a+b        ab+
         a+(b-c)    abc-+
         a+(b-c)*d  abc-d*+
         a=1+3      a13+=
         详细介绍:
         计算操作:从左向右扫描,遇到数字压栈,遇到符号 将栈顶两元素进栈
         3 4 +5*6-  =>(3 +4) *5 -6   是栈后-栈顶一个

         前缀表达式 是栈顶操作栈后一个 不需要中间变量
         */
        /******
         中缀表达式转后缀表达式的思路分析:

         如何将中缀表达式 转换成后缀表达式?
         优先级:() * / +-
         初始化两个栈,运算符栈s1  存储中间结果栈s2
         1.从左到右扫描中缀表达式
         2.遇到操作数入栈s2
         3.遇到运算符 比较其与s1栈顶运算符的优先级
         ---如果s1为空  或栈顶元素为( 入栈s1
         ---否则 优先级比栈顶的元素高,入栈s1
         ---否则,将s1栈顶的运算符弹出入栈s2,再次转到栈顶比较
         遇到括号()时
         ---4.如果是( 直接入栈
         ---5.如果是) 一次弹出s1栈顶的运算符,压入s2直到遇到(
         重复2-5 直到表达式最右边
         将s1中剩余的元素直接弹出入s2
         依次弹出s2中的元素,便得到
         */
        /***
         * 总结:符号栈中碰到自己的优先级高就留在栈s1  不然s1栈顶就要出去  ()特殊处理
         对1+((2+3)*4)-5 进行一个逆波兰后缀转换
         扫描的元素  s2数栈    s1符号栈   说明
         1          1                   1是数字
         +          1           +       +是符号
         (          1           +(      (是左括号
         (          1           +((     (是左括号
         2          12                   2是数字
         +          12          +((+     +是符号
         3          123                   3是数字
         )          123+        +(       )右括号 把符号弹出
         *          123+        +(*     *是运算符 进栈
         4          123+4
         )          123+4*      +       )s1符号栈出栈,直到找到对应(
         -          123+4*+     -       -号并不比+号的优先级低,-号入栈
         5          123+4*+5    -       数字
         到达最右端  123+4*+5-   空       s1的元素运算符直接全部到s2中

         s2即后缀表达式
         可以自己设计出来这个计算算法吗? 难
         1.学习 应用
         2.自己去设计一个算法 这个档次太高了
         算法也涉及几个层面
         **1.层面:理解算法 灵活运用算法解决问题
         **2.自己设计一个算法,去创新
         * 比如8个算排序算法 要去floyd算法 逆波兰算法
         */
        Stack<Character> operStack = new Stack<>();
        Stack<Character> numStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // num 符号 () 三种情况   优先级问题由数字决定 */代表1 +-代表0
            char ch = str.charAt(i);
            if (String.valueOf(ch).matches("\\d")) {//代表匹配数字
                numStack.push(ch);
            } else if (ch == '(') {
                System.out.println("这是一个(");
                operStack.push(ch);
                System.out.println(operStack);
            } else if (ch == ')') {
                System.out.println(operStack);
                while (operStack.peek() != '(') {
                    numStack.push(operStack.pop());
                }
                operStack.pop();
                System.out.println("这是()中间的符号都出栈后的operStack:" + operStack);
            } else {

                while (!operStack.isEmpty() && whoBig(operStack.peek()) >= whoBig(ch)) {//只有你的优先级高才能压住 不然出栈
                    numStack.push(operStack.pop());
                }

                operStack.push(ch);//最后不管怎么样,ch要入符号栈
            }
            System.out.println("这是第i次遍历后的结果" + i + "--" + operStack + numStack);
        }

        //将operStack全部出栈到numstack
        while (operStack.size() > 0) {
            numStack.push(operStack.pop());
        }
        //将numStack 打印为一个string
        StringBuilder sb = new StringBuilder();
        for (Character character : numStack) {
            System.out.print(character + " ");
            sb.append(character);
        }

        System.out.println("这是最终的数栈:" + numStack);
        return sb.toString();
    }

    //老师的中缀转后缀表达式 string -> list
    public static List<String> teacher() {
        /***
         直接对字符串进行操作不方便,先把字符串转换为中缀对应的Arraylist 对list进行遍历
         */
        String str = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(str);//得到list
        System.out.println("这是格式化后的中缀" + list);
        Stack<String> operStack1 = new Stack<>();//符号栈
        //Stack<String> numStack2 = new Stack<>();//数值栈
        List<String> numLists2 = new ArrayList<>();//存储中间结果的lists2

        //遍历ls
        for (String item : list) {
            //如果是一个数,则加入到s2数栈
            if (item.matches("\\d+")) {
                numLists2.add(item);
            } else if (item.equals("(")) {
                operStack1.push(item);
            } else if (item.equals(")")) {
                //弹出s1中的 入s2
                while (!operStack1.peek().equals("(")) {
                    numLists2.add(operStack1.pop());
                }
                operStack1.pop();//将"("弹出--消除括号
            } else {//优先级的问题
                //当s1符号栈 ----当前优先级小于等于栈顶优先级 pop
                while (operStack1.size() != 0&& Operation.getValue(operStack1.peek())>=Operation.getValue(item)) {//缺一个比较优先级高低的方法
                    numLists2.add(operStack1.pop());
                }
                //最后把当前运算符入符号栈
                operStack1.push(item);
            }
        }
        while (operStack1.size()!=0){
            numLists2.add(operStack1.pop());
        }

        return numLists2;//注意,是在list中 顺序就是对应的逆波兰表达式
    }

    //方法:将中缀表达式转成一个List
    public static List<String> toInfixExpressionList(String s) {
        //定义一个list存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0;//这是一个指针索引,遍历字符串用
        String str;//对多位数的拼接作用
        char c;//没遍历到一个字符,放入c
        do {
            //如果c是一个非数字,需要加入ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { //如果是一个数,需要考虑多位数问题
                str = "";//先将str制成空
                //System.out.println(s.charAt(i));
                while (i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    //System.out.println("这是数字c" + c);
                    str += s.charAt(i);//进行拼接  '0' 48    '9' 57
                    i++;
                }
                //System.out.println("这是数字str" + str);
                ls.add(str);
                //continue;
            }

        } while (i < s.length());


        return ls;
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

//可以返回运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;break;
            case "-":
                result = SUB;break;
            case "*":
                result = MUL;break;
            case "/":
                result = DIV;break;
                default:
                    System.out.println("不存在的运算符 | 未定义的运算符"+operation);//morningresult是0 碰到(运算符直接入栈 优先级顶得住 压得住
        }
        return result;
    }
}