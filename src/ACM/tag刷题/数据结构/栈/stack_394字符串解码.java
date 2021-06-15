package ACM.tag刷题.数据结构.栈;

import java.util.Stack;

public class stack_394字符串解码 {
    /***
     给定一个经过编码的字符串，返回它解码后的字符串。
     编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     示例 1：
     输入：s = "3[a]2[bc]"
     输出："aaabcbc"
     */

    /**
     思路:]是触发条件,当]  直接弹出直到[  再弹出一个数字3 循环3次 再入栈 继续等待]
     输出栈的StringBuider
     */
    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch==']'){
                //处理匹配
                StringBuilder temp = new StringBuilder();
                while (stack.peek()!='['){
                    temp.append(stack.pop());
                }
                stack.pop();

                //System.out.println("这是循环次数"+a+"-"+num+"这是temp="+temp);
                temp.reverse();
                String s1 = temp.toString();

                //有可能是多位数
                int a=0;
                int step = 1;
                while (!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                    Character num = stack.pop();
                    a += (num-48)*step;
                    step*=10;
                }

                while (a-- >1){
                    s1 += temp;
                }
                //System.out.println(s1);

                //将temp压入栈
                for (int j = 0; j < s1.length(); j++) {
                    stack.push(s1.charAt(j));
                }
            }else {
                stack.push(ch);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    //换用stack<String> 效率高一些 不必要一个一个进栈,可以一起string压栈
    public static String decodeString2(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch==']'){
                //处理匹配
                StringBuilder temp = new StringBuilder();
                while (!stack.peek().equals("]")){
                    temp.append(stack.pop());
                }
                stack.pop();

                //System.out.println("这是循环次数"+a+"-"+num+"这是temp="+temp);
                temp.reverse();
                String s1 = temp.toString();

                //有可能是多位数
                int a=0;
                int step = 1;
                while (!stack.isEmpty() && stack.peek().toCharArray()[0]>='0' && stack.peek().toCharArray()[0]<='9'){
                    Character num = stack.pop().toCharArray()[0];
                    a += (num-48)*step;
                    step*=10;
                }

                while (a-- >1){
                    s1 += temp;
                }
                //System.out.println(s1);

                stack.push(s1);
            }else {
                stack.push(String.valueOf(ch));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString2("3[a]2[bc]"));
        System.out.println(decodeString2("3[a2[c]]"));
        System.out.println(decodeString2("100[leetcode]"));
    }
}
