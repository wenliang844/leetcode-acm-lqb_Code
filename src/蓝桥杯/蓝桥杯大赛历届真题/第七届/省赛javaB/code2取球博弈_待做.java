package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

import java.util.Scanner;

public class code2取球博弈_待做 {
    /****赛前一周,模仿exlipse进行操作,不适用快捷键
     两个人玩取球的游戏,N个球,取集合{n1 n2 n3}

     参考:拿 123的话,是4的倍数先手输  4=1+3
     //注意:是持有奇数的瀛


     思路:
     1.奇数次取球优先取奇数,不符合取偶数
     2.偶数优先取偶数个,不符合则取奇数个

     3.保证手上为奇数的情况下,每次取球满足要求的最大值,压缩对手的可取空间
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        int x5 = sc.nextInt();


        //String s = "";
        /*if (x1 % (n1 + n3) == 0) {//构造条件被对手得到,先手输
            s += "- ";
        } else {
            s += "+ ";
        }
        if (x2 % (n1 + n3) == 0) {//构造条件被对手得到,先手输
            s += "- ";
        } else {
            s += "+ ";
        }
        if (x3 % (n1 + n3) == 0) {//构造条件被对手得到,先手输
            s += "- ";
        } else {
            s += "+ ";
        }
        if (x4 % (n1 + n3) == 0) {//构造条件被对手得到,先手输
            s += "- ";
        } else {
            s += "+ ";
        }
        if (x5 % (n1 + n3) == 0) {//构造条件被对手得到,先手输
            s += "-";
        } else {
            s += "+";
        }*/

        //System.out.println(s);

    }
}
