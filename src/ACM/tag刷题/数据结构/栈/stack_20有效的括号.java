package ACM.tag刷题.数据结构.栈;

import java.util.Stack;

public class stack_20有效的括号 {
    /***
     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

     有效字符串需满足：

     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     */

    //思路:扫描+栈 (进栈 )和pop比较,是(则继续 字符直接继续
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='(' ||ch=='[' ||ch=='{'){
                stack.push(ch);
            }else if (ch==')'){
                if (stack.size()==0 || stack.pop() != '('){
                    return false;
                }
            }else if (ch==']'){
                if (stack.size()==0 || stack.pop() != '['){
                    return false;
                }
            }else if (ch=='}'){
                if (stack.size()==0 || stack.pop() != '{'){
                    return false;
                }
            }
        }
        return stack.size()==0?true:false;


    }
    public static void main(String[] args) {
        System.out.println(isValid("(sdf)"));
        System.out.println(isValid("(sdf}"));
        System.out.println(isValid("(sdf}{"));
        System.out.println(isValid("(sdf}(){"));
        System.out.println(isValid("]"));
    }
}
