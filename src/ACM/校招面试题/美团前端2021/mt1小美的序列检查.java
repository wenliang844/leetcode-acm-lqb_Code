package ACM.校招面试题.美团前端2021;

import java.util.Scanner;

public class mt1小美的序列检查 {

    //检查重复
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int len = sc.nextInt();
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = sc.nextInt();
            }

            //如果有重复或者||大于len就是No  反之Yes
            int[] check = new int[len + 1];
            check[0]=1;
            for (int i = 0; i < len; i++) {
                if (nums[i] > len) {
                    System.out.println("No");
                    return;
                }
                if (check[nums[i]] == 1) {
                    System.out.println("No");
                    return;
                } else {
                    check[nums[i]] = 1;
                }
            }
            System.out.println("Yes");
        }
    }
}
