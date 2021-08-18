package ACM.校招面试题.神策数据;

import java.util.Scanner;

public class shence3很赞的整数对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int target = sc.nextInt();

        int count = 0;
        while (x<target && y<target){
            y = Math.max(x,y);
            x = x+y;

            count++;
        }

        System.out.println(count);
        //-4 6 2 6  8 6  14 8  22 14

    }
}
