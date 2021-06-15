package 蓝桥杯.练习系统.算法训练;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class q26大小写转换 {
    public static void main(String[] args) {
        //System.out.println((int)'A'-(int)'a');
        Scanner scanner = new Scanner(System.in);
        char[] chs = scanner.next().toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= 'a' && chs[i] <= 'z') {
                chs[i] -= 32;
            } else {
                chs[i] += 32;
            }
        }

        //System.out.println(Arrays.toString(chs));
        System.out.println(new String(chs));
    }
}
