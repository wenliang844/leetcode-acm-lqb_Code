package ACM.ACM1_20201116江西省赛;

import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result;
        result = n*n*(n-1)*(n-1);
        result = result%1000000007;
        System.out.println(result);
    }
}
