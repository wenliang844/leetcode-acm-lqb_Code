package ACM.其他的算法比赛.笔试.腾讯.code2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    //消消乐:相邻加起来等于10则消去,求最后最短
    //6 213792 2
    //7 2134314 7 not

    public static void main(String[] args) {
        //System.out.println((int)'0');
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        //char[] chs = s.toCharArray();
       //用一个栈
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        int i=1;
        while (i<s.length()){
            //System.out.println(stack);
            if (!stack.isEmpty() &&stack.peek()+s.charAt(i)-48-48==10){
                stack.pop();
            }else {
                stack.add(s.charAt(i));
            }
            i++;
        }


        System.out.println(stack);
        System.out.println(stack.size());
    }
}
