package 蓝桥杯.练习系统.算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class q23出现次数最多的整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        if(len < 1 || len > 20) System.exit(0);
        long nums[] = new long[len];
        Arrays.fill(nums, 1);
        long pre = sc.nextLong();
        long max = pre;
        long maxTimes = 1;
        for (int i =1; i < len; i++) {
            long cur = sc.nextLong();
            if (cur==pre){
                nums[i]=nums[i-1]+1;
                if (nums[i]>maxTimes){
                    maxTimes = nums[i];
                    max = cur;
                }
            }
            pre = cur;
        }

        System.out.println(max);
        sc.close();

        //业务处理
        //小到大,直接count相同的计数 出现了maxCount更新ans
       /* int count = 1;
        int maxCount = 0;
        long ans = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (maxCount < count) {
                    maxCount = count;
                    ans = nums[i - 1];
                }
                count = 1;
            }

        }
        System.out.println(ans);*/
    }
}
