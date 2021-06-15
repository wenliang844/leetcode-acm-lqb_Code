package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q28删除数组零元素 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        //1.投机取巧法 计算非0的个数 将非零输出
        int count = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                count++;
            }
        }
        System.out.println(count);
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                System.out.print(nums[i] + " ");
            }
        }

    }
}
