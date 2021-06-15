package ACM.tag刷题.数据结构.栈;

import java.util.Stack;

public class stack_155最小栈 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());//-3
        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.top());//0
        System.out.println(minStack.getMin());//-2
        System.out.println(minStack);
    }

}

/***
 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) —— 将元素 x 推入栈中。
 pop() —— 删除栈顶的元素。
 top() —— 获取栈顶元素。
 getMin() —— 检索栈中的最小元素。


 方法二:官方: 直接用一个辅助栈,每次将最小值放到辅助栈,如果pop 辅助站的最小值也pop一个
 */
class MinStack {

    Stack<Integer> stack;
    int minNum = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        minNum = Math.min(val, minNum);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop == minNum) {
            minNum = Integer.MAX_VALUE;
            for (Integer integer : stack) {
                minNum = Math.min(integer, minNum);
            }
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        //int min = 0;

        return minNum;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}

class MinStack2 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()){
            minStack.push(val);
        }else {
            minStack.push(Math.min(val,minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */