package 蓝桥杯.练习系统.算法训练;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class q2字符串合并 {
    public static void main(String[] args) {
        int[] anss = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(anss, 0, 0)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(anss, 0, 1)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(anss, 0, 2)));
        System.out.println(Arrays.toString(Arrays.copyOf(anss, 0)));
        System.out.println(Arrays.toString(Arrays.copyOf(anss, 1)));
        System.out.println(Arrays.toString(Arrays.copyOf(anss, 2)));
       /* Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(s1+s2);*/
    }
}
