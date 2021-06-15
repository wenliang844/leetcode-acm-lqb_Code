package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.javaB;

import java.util.Scanner;

public class code1饮料换购 {
    /***
        C型饮料,3个瓶盖一瓶  模拟
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottle = 0;
        int cap = 0;
        //int init = scanner.nextInt();
        int init = 100;
        bottle+=init;
        cap+=init;
        while (cap>=3){
            int temp = cap/3;
            cap=cap%3;
            bottle+=temp;
            cap+=temp;

            System.out.println("-----------换了几瓶=="+temp);
            System.out.println("-----------瓶盖剩余"+cap);
        }

        System.out.println("结果=="+bottle);
        System.out.println("剩下的cap=="+cap);
    }
}
