package 蓝桥杯.官方小模拟;
/*
问题描述
　　给定一个序列 a_1, a_2, ..., a_n。其中 a_1 < a_2 < ... < a_n。
　　相邻两个数之间的差（后一个数减前一个数）称为它们的间隙。
　　请问序列中最大的间隙值是多少？
输入格式
　　输入的第一行包含一个整数 n，表示序列的长度。
　　第二行包含 n 个正整数，为给定的序列。
输出格式
　　输出一个整数，表示序列中最大的间隙值。
样例输入
5
1 3 8 9 12
样例输出
5
样例说明
　　a_3 - a_2 = 5。
 */
import java.util.Scanner;

public class I数列的最大间隙 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=sc.nextInt();
        }
        int maxNum = 0;
        for (int i = 0; i < len-1; i++) {
                if (nums[i+1]-nums[i]>maxNum){
                    maxNum=nums[i+1]-nums[i];
                }
        }
        System.out.println(maxNum);




    }
}
