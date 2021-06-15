package 蓝桥杯.练习系统.算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class q29最小乘积基本型 {

    //基本思想:最大值和最小值相乘
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int len1 = scanner.nextInt();
            int[] nums1 = new int[len1];
            int[] nums2 = new int[len1];
            for (int i = 0; i < len1; i++) {
                nums1[i] = scanner.nextInt();
            }
            for (int i = 0; i < len1; i++) {
                nums2[i] = scanner.nextInt();
            }

            //业务处理,用最大值乘以最新哦按子
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int sum = 0;
            for (int i = 0; i <len1; i++) {
                sum += nums1[i] * nums2[len1-i-1];
            }

            System.out.println(sum);
        }


    }
}
