package ACM.ACM1_20201116江西省赛;

import java.util.Scanner;


public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = (int) Math.pow(2,a);
       int result = count(sum-1)-1;
        System.out.println(result%998244353);
    }

    private static int count(int i) {
        int sum=0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;
    }
}
