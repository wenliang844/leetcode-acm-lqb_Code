package ACM.ACM1_20201116江西省赛;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b,c;
        int count1=0,count2=0;
        for (int i = 0; i < a; i++) {
            b = sc.nextInt();
            c = sc.nextInt();
            if (b%c==0){
                count1++;
            }else{
                count2++;
            }
        }

        for (int i = 0; i < count1; i++) {
            System.out.println("possible");
        }
        for (int i = 0; i < count2; i++) {
            System.out.println("impossible");
        }
    }
}
