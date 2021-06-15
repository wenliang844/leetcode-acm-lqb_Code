package ACM.其他的算法比赛.笔试.baidu.code2数字期望;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int p = sc.nextInt();
        int[] nums = new int[N*2];
        for (int i = 0; i < N * 2; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int sum = 0;
        //判断p>50 还是小于50
        if (p>=50){
            for (int i = 0; i < N; i++) {
                sum += nums[i]*(100-p);
            }
            for (int i = N; i < 2*N; i++) {
                sum += nums[i]*p;
            }
        }else {
            for (int i = 0; i < 2 * N; i++) {
                if (i%2==0){
                    sum+=nums[i]*(100-p);
                }else {
                    sum+=nums[i]*p;
                }
            }
        }

        if (sum%100==0){
            System.out.println(sum/100);
        }else {
            System.out.println(sum+"%");
        }

    }
}
