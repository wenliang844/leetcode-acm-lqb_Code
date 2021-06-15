package ACM.其他的算法比赛.笔试.美团.code1;
/***
 小美想要为小团摆一行积木，每个积木上都有一个0-9的数字。现在已经摆好了 n 块积木，小美可以把其中一块积木替换成任意一块积木（也可以不替换），使得积木看起来更符合小美的审美。请你帮小美看看，替换后最好看的积木是什么样的。

 摆好后的积木上面的数字，从左到右会形成一个数字串（由数字组成的字符串）。小美会根据这个数字串来评判积木的好看程度，小美有两条审美标准：

 ①回文数字串相比于非回文数字串更符合小美的审美。例如：12321、2332是回文数字串，而12212、2121不是回文数字串。

 ②数字串形成的数字更小更好看。例如：1312比1313更好看，0102比1102更好看。

 小美会按照她的审美标准来判断两个数字串哪个更好看，即先按照审美标准①判断，若无法判断再按审美标准②判断。



 输入描述
 第一行一个数 T，表示一共有 T 组测试数据。(1 ≤ T ≤ 100)。

 接下来 T 组数据，每组数据两行，

 第一行一个数 n，表示有 n 块积木。(1 ≤ n ≤ 20000)。

 第二行 n 个数字，第 i 块积木上的数字是 si。(si是0-9的数字)。

 输出描述
 每组数据输出一行，表示最终摆好的积木形成的数字串。
 */

import java.util.Scanner;
public class Main {

    //数列的定义如下： 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- >0){
            int n = scanner.nextInt();
            String s = scanner.next();
            char[] chars = s.toCharArray();
            int i = 0;
            int j = s.length()-1;
            int count = 0;//记录不一样的组数
            int i1=0,i2=0;
            while (i<j){
                if (chars[i] != chars[j]){
                    count++;
                    i1 = i;
                    i2 = j;
                }
                i++;j--;
            }

            if (count==1){
                if (chars[i1]>chars[i2]){
                    chars[i1] = chars[i2];
                }else {
                    chars[i2]=chars[i1];
                }
            }else if (count==0){
                //是回文 且奇数ge,把中间的换0
                if (chars.length%2!=0){
                    chars[chars.length/2]='0';
                }
            }else {
                //不能回文 把第一个不是0的数变0
                for (int k = 0; k < chars.length; k++) {
                    if (chars[k] != '0'){
                        chars[k] = '0';
                        break;
                    }
                }
            }

            System.out.println(new String(chars));

        }
    }
}









