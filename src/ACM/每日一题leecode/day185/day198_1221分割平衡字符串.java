package ACM.每日一题leecode.day185;

import java.util.Stack;

public class day198_1221分割平衡字符串 {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

    //用栈 LR抵消,如果栈空 count++ 9/48
    public static int balancedStringSplit(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.add(chars[0]);
        int count =0;
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty() && stack.peek() != chars[i]){
                stack.pop();
            }else {
                stack.add(chars[i]);
            }

            if (stack.isEmpty()){
                count++;
            }
        }
        return count;
    }
}
