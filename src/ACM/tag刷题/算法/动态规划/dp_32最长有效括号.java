package ACM.tag刷题.算法.动态规划;

import java.util.Stack;

public class dp_32最长有效括号 {

    /**
     给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

     示例 1：
     输入：s = "(()"
     输出：2
     解释：最长有效括号子串是 "()"
     */

    //方法一:用栈,遇到(进栈 遇到)看栈顶是不是非空且有( 是的话直接+2
    //问题一:要连续
    public static int longestValidParentheses(String s) {

        int maxCount = 0;
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='('){//进栈
                stack.push(ch);
            }else {//是)
                //如果stack是空,直接退出;如果否则pop一个,出栈,count+2
                if (!stack.isEmpty()){
                    count+=2;
                    stack.pop();
                }else{//空栈,匹配不了,更新最大值
                    maxCount = Math.max(maxCount,count);
                    count = 0;

                }
            }
        }
        maxCount = Math.max(maxCount,count);

        return maxCount;
    }

    //栈:直接把配好的以数字2进栈,每次新配了就2+2;
    public static int longestValidParentheses2(String s) {

        //int maxCount = 0;
        //int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='('){//进栈
                stack.push((int) ch);
            }else {//是)
                //如果stack是空,直接退出;如果否则pop一个,出栈,count+2
                if (!stack.isEmpty()){
                    //count+=2;
                    //stack.pop();
                    if (stack.peek()==')'){
                        stack.pop();
                        stack.push(2);
                    }else {//是数字2了,2出栈
                        Integer pop = stack.pop();
                        if (!stack.isEmpty()){
                            stack.pop();
                            stack.push(pop+2);
                        }

                    }

                }else{//空栈,匹配不了,更新最大值
                    //maxCount = Math.max(maxCount,count);
                    //count = 0;

                }
                System.out.println(stack);
            }
        }
        //maxCount = Math.max(maxCount,count);
        System.out.println(stack);
        return 0;
    }

    //方法三:栈 +数字代替法
    //如果是连续的偶数,可以叠加
    public static int longestValidParentheses3(String s) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                stack.add(1);
            }else {
                if (!stack.isEmpty()){//非空,看peek是什么
                    Integer pop = stack.pop();
                    if (pop==1){//是(
                        //看一下下面还有计数的吗,有的话合并
                        /*if (!stack.isEmpty()){
                            Integer peek = stack.peek();
                            if (peek%2==0){
                                stack.add(stack.pop()+2);
                            }else {
                                stack.add(2);
                            }
                        }else {
                            stack.add(2);
                        }*/
                        stack.add(2);
                        /*if (stack.size()>2 && stack.peek()%2==0){
                           stack.add( stack.pop()+stack.pop());
                        }*/
                    }else{//是计数的
                        if (!stack.isEmpty()){//非空则增
                            stack.pop();
                            stack.add(pop+2);
                        }else {//空的,把取出的2拿进来   并且把3入栈
                            stack.add(pop);
                            stack.add(3);
                        }
                    }

                }
            }
        }
       System.out.println(stack);

        int maxCount = 0;
        int count = 0;
       while (!stack.isEmpty()){
           Integer pop = stack.pop();
           if (pop==1 || pop==3){
               maxCount = Math.max(maxCount,count);
               count=0;
               continue;
           }else {
               //maxCount = Math.max(maxCount,pop);
               count += pop;
           }
       }
        maxCount = Math.max(maxCount,count);//如果一直没有碰上呢
        return maxCount;

    }


    //方法二:贪心用left right计数 ( left+1 )right+1 当right>left置0;  (()算不出来   69 66
    public static int longestValidParentheses4(String s) {
        int left = 0;//左括号永远要比右括号多,
        int right = 0;
        int maxLengthBracket = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }

            if (left==right){
                maxLengthBracket = Math.max(maxLengthBracket,left*2);
            }
            if (right>left){
                left=0;
                right=0;
            }
        }
        //maxLengthBracket = Math.max(maxLengthBracket,right*2);
        //需要反方向再来一次
        //s = new StringBuilder(s).reverse().toString();
        left=0;
        right=0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == ')'){
                right++;
            }else {
                left++;
            }

            if (left==right){
                maxLengthBracket = Math.max(maxLengthBracket,left*2);
            }
            if (right<left){
                left=0;
                right=0;
            }
        }
        return maxLengthBracket;
    }

    //方法五:动态规划:dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
    //anthor:LeetCode 100 24
    public static int longestValidParentheses5(String s){
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        //System.out.println(longestValidParentheses3("()(()"));
        //System.out.println(longestValidParentheses3(")()())"));
        //System.out.println(longestValidParentheses3("())"));
       // System.out.println(longestValidParentheses3("()()"));
        //System.out.println(longestValidParentheses3("()(())"));
        System.out.println(longestValidParentheses4(")()())()()("));
        System.out.println(longestValidParentheses4("((()"));
        System.out.println(longestValidParentheses4("()(()"));
        //System.out.println(longestValidParentheses3("()()()()()"));

       /* System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("())()"));
        System.out.println(longestValidParentheses("(()"));//2  最后更新一下
        System.out.println("-----------------222222222222--------------");
        System.out.println(longestValidParentheses2("()(()"));
        System.out.println("---");
        System.out.println((char)2+(char)2);
        System.out.println(((char)2+(char)2));
        System.out.println((char) ((int)'2'+(int)'2'));
        System.out.println("----------");
        System.out.println((int)'(');
        System.out.println((int)')');*/
    }
}
