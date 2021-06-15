package 蓝桥杯.练习系统.算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class q4二分法查找数组元素 {
    public static void main2(String[] args) {
        int[] data = new int[200];
        for (int i = 0; i < 200; i++) {
            data[i] = 4 * i + 6;
        }
        //System.out.println(Arrays.toString(data));

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int left = 0;
        int right = data.length;
        while (left<right){
            int mid = (left+right) /2;
            if (data[mid]>target){
                right = mid-1;
            }else if (data[mid]<target){
                left=mid+1;
            }else {
                System.out.println(mid);
                break;
            }
        }
    } public static void main(String[] args) {
        int[] data = new int[200];
        for (int i = 0; i < 200; i++) {
            data[i] = 4 * i + 6;
        }
        //System.out.println(Arrays.toString(data));

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target){
                System.out.println(i);
                break;
            }
        }
    }
}