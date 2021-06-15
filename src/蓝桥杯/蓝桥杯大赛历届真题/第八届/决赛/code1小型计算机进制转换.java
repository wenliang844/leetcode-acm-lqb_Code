package 蓝桥杯.蓝桥杯大赛历届真题.第八届.决赛;

import java.util.Scanner;

public class code1小型计算机进制转换 {

    /***
     7
     CLEAR
     NUM 1024
     CHANGE 2
     ADD
     NUM 100000
     CHANGE 8
     EQUAL
     */
    static int currentSystem = 10;//当前进制 默认10
    static String currentNum = "";//基础数值

    public static void main(String[] args) {
        //String s = "10101";//1+4+16==21
        //System.out.println(Integer.parseInt(s, 2));//结果是21
        //System.out.println(Integer.parseInt("200", 3));//18

        //System.out.println(Integer.toBinaryString(21));//10101
        //System.out.println(Integer.toString(18, 3));//18的三进制 -->200

        //case
        //System.out.println("---------------");
        Scanner sc = new Scanner(System.in);
       /* String a = sc.next();
        System.out.println(a);
*/
        int n = sc.nextInt();
        while (n-- > 0) {
            String oprater = sc.next();//只会读取一行
            switch (oprater) {
                case "CLEAR":
                    n--;
                    clear(sc.next(), sc.next());
                    break;
                case "CHANGE":
                    change(sc.next());
                    break;
                case "ADD":
                    n--;
                    add(sc.next(), sc.next());
                    break;
                case "SUB":
                    n--;
                    sub(sc.next(), sc.next());
                    break;
                case "MUL":
                    n--;
                    mul(sc.next(), sc.next());
                    break;
                case "DIV":
                    n--;
                    div(sc.next(), sc.next());
                    break;
                case "MOD":
                    n--;
                    mod(sc.next(), sc.next());
                    break;
                case "EQUAL":
                    System.out.println(equal());
            }

        }
    }

    private static String equal() {

        return currentNum;
    }

    private static void mod(String next, String next1) {
        currentNum = Integer.toString((Integer.parseInt(currentNum,currentSystem)%Integer.parseInt(next1,currentSystem)),currentSystem);
    }

    private static void div(String next, String next1) {
        currentNum = Integer.toString((Integer.parseInt(currentNum,currentSystem)/Integer.parseInt(next1,currentSystem)),currentSystem);
    }

    private static void mul(String next, String next1) {
        currentNum = Integer.toString((Integer.parseInt(currentNum,currentSystem)*Integer.parseInt(next1,currentSystem)),currentSystem);
    }

    private static void sub(String next, String next1) {
        currentNum = Integer.toString((Integer.parseInt(currentNum,currentSystem)-Integer.parseInt(next1,currentSystem)),currentSystem);
    }

    private static void add(String next, String next1) {
        //10进制直接加,其他进制转10进制加好了在转当前进制
            currentNum = Integer.toString((Integer.parseInt(currentNum,currentSystem)+Integer.parseInt(next1,currentSystem)),currentSystem);
    }

    private static void change(String newSystem) {
        //将现在的数字转新的进制
        //1.现在的数转10进制
        int temp = Integer.parseInt(currentNum, currentSystem);

        //2.temp转newSyatem
        currentSystem = Integer.parseInt(newSystem);
        currentNum = Integer.toString(temp, currentSystem);
    }

    private static void clear(String text, String num) {
        currentNum = num;
    }
}
