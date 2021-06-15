package 蓝桥杯.蓝桥杯大赛历届真题.第七届.决赛;

import java.util.Scanner;

public class code2碱基 {
    /****
     一个字符串数组,查找有多少组合是:
     选m个字符串 -> 连续k个字符

     从0开始,再从1开始....构造k连续的字符,
     匹配下一个字符串1 再匹配下一个字符2

     3 2 2
     ATC
     TCG
     ACG

     4 3 3
     AAA
     AAAA
     AAA
     AAA
     */
    static int k;
    static int n;
    static int len;
    static int count = 0;
    static String s[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = 4;
        int m = 3;
        k = 3;
        s = new String[]{"AAA", "AAAA", "AAA", "AAA"};
        /*n = 3;
        int m = 2;
        k = 2;
        s = new String[]{"ATC", "TCG", "ACG"};*/


        /* n = sc.nextInt();
        int m = sc.nextInt();
        k = sc.nextInt();
        s = new String[n];//{"ATC", "TCG", "ACG"};
        for (int i = 0; i < n; i++) {
          s[i]=sc.next();
        }*/

        //len = n - m + 1;
        for (int i = 0; i < n; i++) {//从0开始,构造k连续字符
            //dfs里面继续for循环
            for (int j = 0; j < s[i].length() - k + 1; j++) {
                String temp = s[i].substring(j, j + k);
                for (int l = i; l < n; l++) {
                    dfs(temp, m - 1, l + 1);
                }
            }
        }


        System.out.println(count);
    }

    private static void dfs(String temp, int m, int i) {//m剩余次数
        //m==0;说明通过了所有考验,count可以++;然后return上一步
        /*if (m == 0) {
            System.out.println("成功:这是第几层i="+(i-1)+"字母是"+temp);
            count++;
            return;
        }*/
        if (i >= n) {
            return;
        }

        //不然从i开始再次遍历所有的s  如果i这个字符串会等于temp上一个字符串,就进入下一层查找

        for (int l = 0; l < s[i].length() - k + 1; l++) {
            String tmps = s[i].substring(l, l + k);
            if (tmps.equals(temp)) {//剪枝,限制向下运行,因为要m个k长度的全部一样才进入下一层

                //做一个限制,当你m>1的时候才需要向下运行,  =1的时候直接就是最后一个啦
                if (m > 1) {
                    for (int j = i; j < n; j++) {//继续从下面的每个中选一个可选的
                        dfs(tmps, m - 1, j + 1);
                    }
                } else {
                    //dfs(tmps,m-1,1);
                    System.out.println("成功:这是第几层i=" + (i) + "字母是" + temp);
                    count++;
                }
            }
        }

    }
}
