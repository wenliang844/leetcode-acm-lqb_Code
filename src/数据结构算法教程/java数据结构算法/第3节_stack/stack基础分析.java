package 数据结构算法教程.java数据结构算法.第3节_stack;

import java.util.Scanner;

/***
 1.需求 输入一个表达式,如 7*2*2-5+1-5+3-3 计算这个结果
 前缀后缀中缀  逆波兰表达式
 一个字符串str给到你,分析运算符 考虑优先级
 用到stack就可以解决这个问题
 2.先入后出
 3.在栈顶操作数据 压栈 弹栈
 起始下标top = -1         0 1 2 3 4 5 6
 数组 或链表实现

 案例:
 *子程序的调用
 *递归调用
 *表达式的转换与求值{实际解决}
 * 二叉树的遍历
 * 图形的深度优先{depth first}
 * 层遍历用queue
 *
 stack的实现:
 1.数组模拟栈
 top初始化为-1
 入栈:数据加入栈,top++ stack[top]=data
 出栈:value = stack[top]  top--  return value
 */
public class stack基础分析 {

    public static void test1() {

        ArrayStack stack = new ArrayStack(10);
        /*stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.list();*/

        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);//扫描器

        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:添加数据到栈");
            System.out.println("pop:出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res = stack.pop();
                        System.out.println("出栈的数据是:"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop=false;
                    break;
                    default:
                        break;

            }
        }
        System.out.println("程序退出了");
    }

    public static void main(String[] args) {
        test1();
    }

}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;//表示栈底 初始化-1

    public ArrayStack(int maxSize) {
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
}
