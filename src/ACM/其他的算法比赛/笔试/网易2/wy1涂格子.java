package ACM.其他的算法比赛.笔试.网易2;

import java.util.Scanner;

public class wy1涂格子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int Bcount = 0, Rcount = 0;
        if (str.charAt(0) == 'B') {
            Bcount++;
        } else {
            Rcount++;
        }
        for (int i = 1; i < n; i++) {
            if (str.charAt(i)!=str.charAt(i-1)){
                if (str.charAt(i) == 'B') {
                    Bcount++;
                } else {
                    Rcount++;
                }
            }
        }
        System.out.println(Math.min(Bcount,Rcount)+1);

    }
}
