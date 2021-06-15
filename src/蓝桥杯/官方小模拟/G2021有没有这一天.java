package 蓝桥杯.官方小模拟;

import java.util.Scanner;

public class G2021有没有这一天 {

    // 1,3,5,7,8,10,12
    // 4,6,9,11
    // 2
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();


        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day>=1 &&day<=31){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day>=1 && day<=30){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
                break;
            case 2:
                if (day>=1 && day<=28){
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
                break;
                default:
                    System.out.println("no");
        }





    }
}
