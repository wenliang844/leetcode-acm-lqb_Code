package ACM.其他的算法比赛.笔试.网易2;

import java.util.Scanner;
//60
public class wy4等比拆分 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int i = 2;
            int count = 0;
            for (; i <= n; i++) {
                int sum = 1;
                int currentNum = 1;
                count=1;
                while (sum < n) {
                    count++;
                    currentNum*=i;
                    sum+=currentNum;
                }
                if (sum==n){
                    break;
                }
            }
            System.out.println(count+" "+i);
        }
    }


}

