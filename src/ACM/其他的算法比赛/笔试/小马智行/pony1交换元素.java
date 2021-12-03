package ACM.其他的算法比赛.笔试.小马智行;

import java.util.Arrays;
import java.util.Scanner;

public class pony1交换元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int nums[] = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int res = 0;
        for (int i = 0; i < len-1; i++) {
            res += (nums[i]-nums[i+1])*(nums[i]-nums[i+1]);
        }

        System.out.println(res);

    }


}
