package ACM.ACM1_20201116江西省赛;

import java.util.Scanner;


public class Main7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(Math.pow(3,2));
        int result = (int) Math.pow(m+1,n);
        System.out.println(result%998244353);
    }
}
