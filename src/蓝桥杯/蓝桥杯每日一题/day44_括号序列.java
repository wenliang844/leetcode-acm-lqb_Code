package 蓝桥杯.蓝桥杯每日一题;

import java.util.Arrays;

public class day44_括号序列 {
    /***
     给定一个只包含'(', ')'和'*'的字符串S，现在小Hi可以任意指定'*'为'('或')'，不同的'*'可以是不同的字符。
     请你判断小Hi是否可能得到一个合法匹配的字符串。

     输入
     第一行包含一个整数T，代表数据的组数。
     以下N行每行一个字符串S。
     1 ≤ T ≤ 10  1 ≤ |S| ≤ 1000
     输出
     对于每组数据，输出YES或者NO代表是否能得到一个合法匹配的字符串。

     样例输入
     2
     *
     (*)*
     样例输出
     NO
     YES
     */
    //方法一,遍历找到( 就将最近的)消除  *保留
    //碰到( 找最近的)成为# 如果右边的)已经没了,找*{定义一个flag标志有无)}
    //碰到* 找最近的)成为#
    //碰到) false
    public static void  bracketsSequence(String s){
        char[] chs = s.toCharArray();
        System.out.println("原来的数组是="+Arrays.toString(chs));
        boolean haveRight = true;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(' || chs[i]=='*'){
                boolean haveFined = false;
                for (int j = i+1; j < chs.length; j++) {
                    if (chs[j] == ')'){
                        chs[j]='#';
                        haveFined = true;
                        break;
                    }
                }
                if (!haveFined){//没有)括号的,后面直接找*
                    //从i开始,找*
                    for (int j = i; j < chs.length; j++) {
                        if (chs[j]=='(' || chs[j]=='*'){
                            boolean fined = false;
                            for (int k = j+1; k < chs.length; k++) {
                                if (chs[k] == '*'){
                                    chs[k]='#';
                                    fined = true;
                                    break;
                                }
                            }
                            if (!fined){
                                System.out.println("j停在了="+j+"数组变成了="+Arrays.toString(chs));
                                System.out.println("2NO");
                                return;
                            }
                        }
                    }
                    break;
                }
            }else if (chs[i]==')'){
                System.out.println("i停在了="+i+"数组变成了+"+Arrays.toString(chs));
                System.out.println("1NO");
                return;
            }
        }
        System.out.println("数组变成了="+Arrays.toString(chs));
        System.out.println("YES");
    }

    public static void main(String[] args) {
        bracketsSequence("*");
        bracketsSequence("(*)*");
        bracketsSequence("()()*)()()()()*(");
        bracketsSequence("(((()((()((((((()*)(()))**)()()**)(*)())(*))()*())*)*)*)))");
        bracketsSequence("");
    }
}
