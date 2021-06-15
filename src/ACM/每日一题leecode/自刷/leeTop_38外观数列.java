package ACM.每日一题leecode.自刷;

import java.util.Arrays;

public class leeTop_38外观数列 {
    /***
     给定一个正整数 n ，输出外观数列的第 n 项。

     「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

     你可以将其视作是由递归公式定义的数字字符串序列：

     countAndSay(1) = "1"
     countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     前五项如下：

     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221
     第一项是数字 1
     描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
     描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
     描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
     描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     */
    //5 12
    public static String countAndSay(int n) {
        if (n==1)return 1+"";
        String[] countandSay = new String[n];
        countandSay[0]=1+"";
        countandSay[1]=11+"";
        for (int i = 2; i < n; i++) {
            //此后的每一项是对前一项的描述
            String target = countandSay[i-1];
            String s = "";
            int left=0;
            int right=left+1;
            while (right<target.length()){
                if (target.charAt(left)==target.charAt(right)){
                    //left++;
                    right++;
                }else {
                    s+= (right-left)+""+target.charAt(left);
                    left=right;
                    right=left+1;
                }
            }
            s+= (right-left)+""+target.charAt(left);
            countandSay[i]=s;
        }

        System.out.println(Arrays.toString(countandSay));

        return countandSay[n-1];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
