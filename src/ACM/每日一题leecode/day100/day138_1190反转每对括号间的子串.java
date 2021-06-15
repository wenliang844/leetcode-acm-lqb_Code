package ACM.每日一题leecode.day100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class day138_1190反转每对括号间的子串 {
    /***
     给出一个字符串 s（仅含有小写英文字母和括号）。
     请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
     注意，您的结果中 不应 包含任何括号。
     示例 1：
     输入：s = "(abcd)"
     输出："dcba"
     */
    public static void main(String[] args) {
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    //栈匹配算法 :40/34
    public static String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==')'){
                //是右括号,匹配到下一个(,出栈反转再进栈
                List<Character> list = new ArrayList<>();
                while (true){
                    Character pop = stack.pop();
                    if (pop=='('){
                        break;
                    }
                    list.add(pop);
                }
                for (int j = 0; j < list.size(); j++) {
                    stack.add(list.get(j));
                }
            }else {
                stack.add(s.charAt(i));
            }
        }
        String replace = stack.toString().replace(", ", "");
        String replace1 = replace.replace("[", "");
        String replace2 = replace1.replace("]", "");

        return replace2;
    }
}
