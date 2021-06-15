package 蓝桥杯.练习系统.基础练习;

import java.util.Scanner;

/***
 6
 1 9 4 8 3 9
 9
 */
public class pqb9查找整数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int queue = sc.nextInt();
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == queue){
                res = i+1;
                break;
            }
        }

        System.out.println(res);
    }
}
