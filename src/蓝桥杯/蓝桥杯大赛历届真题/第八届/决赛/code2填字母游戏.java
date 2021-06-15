package 蓝桥杯.蓝桥杯大赛历届真题.第八届.决赛;

import java.util.Scanner;

public class code2填字母游戏 {
    public static void main(String[] args) {
        /***
         一直下L 谁下O谁输;
         两个L夹着*** 那么我就下一个L,照成偶数个**给对方;

         假如奇数个连续L夹着的**有奇数个,我赢,创造偶数个给对方

         ***             0
         **LL**            0
         L**L            -1
         L***L             1
         L**L***            1
         ***L**L           1
         **L**L****            -1
         *LO*
         **O***O**

         博弈论，记忆化dfs

         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String s = scanner.next();
            //判断一下,如果有LO的情况我赢
            boolean flag = false;
            for (int i = 0; i < s.length()-1; i++) {
                if ((s.charAt(i)=='L'&&s.charAt(i+1)=='O') ||(s.charAt(i)=='O'&&s.charAt(i+1)=='L')){
                    System.out.println(1);
                    flag = true;
                    continue;
                }
            }
            if (flag)continue;

            s=s.replace('O','L');
            //System.out.println(s);
            //记录L,L之间***号的奇数个数  如果是0 则平局
            //如果是有两个LL的情况,前后各加一个L 哨兵
            //两个连续的LL算一个
            int count = 0;
            //int evenCount = 0;
            int i = -1;
            boolean find = false;
            //第一个l给i
            //判断是否有两个不连续的L
            int Lcount = 0;
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'L') {
                    //find = true;
                    //break;
                    Lcount++;
                    i++;
                }
            }
            if (Lcount <= 1) {//只有1个或没有
                System.out.println(0);
            } else {
                //2个以上,加哨兵
                s = "L" + s + "L";
                //System.out.println("s="+s);
                i = 0;
           /* if (!find) {
                System.out.println(0);
            } else {*/
                int j = i + 1;
                while (j < s.length()) {
                    for (int k = j; k < s.length(); k++) {
                        if (s.charAt(k) == 'L') {
                            j = k;
                            break;
                        }
                    }
                    int temp = j - i - 1;
                    if (temp != 0) {
                        if (temp % 2 != 0) {
                            //是奇数
                            count++;
                        }/* else {
                            evenCount++;
                        }*/

                    } i = j;
                    j = i + 1;

                }

               /* if (count == 0&&evenCount==0) {//只有一个L,可以平手
                    System.out.println(0);
                } else */
                if (count % 2 == 0) {//有成对的,有赢家 输家
                    System.out.println(-1);
                } else {
                    System.out.println(1);
                }

                //System.out.println("count="+count);
            }


        }
    }
}
