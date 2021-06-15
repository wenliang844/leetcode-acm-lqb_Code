package ACM.ACM1_20201116江西省赛;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b[][] = new int[a][2];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < 2; j++) {
                b[i][j]=sc.nextInt();
            }
        }

        for (int i = 0; i < a; i++) {
            if (b[i][0]%b[i][1]==0)
                System.out.println("possible");
            else
                System.out.println("impossible");
        }
    }
}
