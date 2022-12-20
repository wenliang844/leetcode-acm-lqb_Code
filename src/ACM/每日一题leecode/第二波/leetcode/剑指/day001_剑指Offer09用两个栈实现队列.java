package ACM.每日一题leecode.第二波.leetcode.剑指;

import java.beans.IntrospectionException;
import java.util.Stack;

/**
 * @author 陈文亮
 * @date 2022/12/15 14:57
 */
public class day001_剑指Offer09用两个栈实现队列 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    //先进先出
    //思路：一个栈正常进， 一个栈正常出（没有了就从另一个栈倒序全部进入）
    static class CQueue {

        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public CQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (!outStack.isEmpty()){
                return outStack.pop();
            }else if (!inStack.isEmpty()){
                while (!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
                return outStack.pop();
            }
            return -1;
        }
    }

}
