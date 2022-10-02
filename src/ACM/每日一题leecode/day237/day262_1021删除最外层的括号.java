package ACM.每日一题leecode.day237;

public class day262_1021删除最外层的括号 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    //方法一：暴力破解
    public static String removeOuterParentheses(String s) {

        int conut = 1;
        int begin = 0;
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                conut++;
            } else {
                conut--;
            }

            //count==0表示可分原语
            if (conut == 0) {
                String temp = s.substring(begin,i+1);
                res += temp.substring(1,temp.length()-1);
                begin = i+1;
            }
        }
        return res;
    }
}
