package ACM.每日一题leecode.day185;

import java.util.Stack;

public class day201_678有效的括号字符串 {
    /*
    给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串
    是否为有效字符串。有效字符串具有如下规则：
    任何左括号 ( 必须有相应的右括号 )。
    任何右括号 ) 必须有相应的左括号 ( 。
    左括号 ( 必须在对应的右括号之前 )。
    * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
    一个空字符串也被视为有效字符串。
    示例 1:
    输入: "()"
    输出: True
     */
    public static void main(String[] args) {
        //System.out.println(checkValidString3("()"));
        //System.out.println(checkValidString3("(*)"));
        System.out.println(checkValidString3("(((((*)))**"));//true
        //System.out.println(checkValidString3("(**)"));
        //System.out.println(checkValidString3("(*))"));
        //System.out.println(checkValidString3("((*)"));
        //System.out.println(checkValidString3("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));//fase
    }

    //方法一:栈   55
    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    stack.push('(');
                }
            }
        }
        return stack.isEmpty();
    }

    //方法一:栈:优化 67
    //通过 5/5
    public static boolean checkValidString3(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            System.out.println("1---"+stack);
            if (s.charAt(i) == '(' || s.charAt(i)=='*') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                //优先找一个(匹配 没有就找*
                if (!stack.isEmpty()) {
                    int count = 0;
                    while (!stack.isEmpty() && stack.peek()!='('){
                        stack.pop();
                        count++;
                    }
                    if (stack.isEmpty()){
                        count--;
                    }else {
                        stack.pop();
                    }

                    while (count-- >0){
                        stack.push('*');
                    }
                } else {
                    return false;
                }
            }
        }

        //里面只剩下( *  对计数: 需要左括号<=*
        //int leftCount = 0;
        //int starCount = 0;
        //while (!stack.isEmpty()){
        //    if (stack.pop() == '('){
        //        leftCount++;
        //    }else {
        //        starCount++;
        //    }
        //}
        //if (leftCount<=starCount){
        //    return true;
        //}else {
        //    return false;
        //}

        //对剩下的stack进行( *匹配  //46
        //*有(就匹配  没有就放掉
        Stack<Character> temp = new Stack<>();
        while (!stack.isEmpty()){ //通过 5/5
            temp.add(stack.pop());
        }
        while (!temp.isEmpty()){
            System.out.println("temp---"+temp);
            System.out.println("1---"+stack);
            char pop = temp.pop();
            if (pop == '('){
                stack.push(pop);
            }else {
                //if (temp.isEmpty()){
                //    return false;
                //}else {
                //    temp.pop();
                //}
                if (!stack.isEmpty()){ //65
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    //方法二:计数:左 星 右之间的数量关系  55
    public static boolean checkValidString2(String s) {
        int leftCount = 0;
        int starCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (s.charAt(i) == ')') {
                rightCount++;
            } else if (s.charAt(i) == '*') {
                starCount++;
            }

            //System.out.println(leftCount+"--"+rightCount+"--"+starCount);

        }
        if (Math.abs(leftCount - rightCount)>starCount){
            return false;
        }
        return true;
    }
}
