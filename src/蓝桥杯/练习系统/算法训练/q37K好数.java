package 蓝桥杯.练习系统.算法训练;

import java.util.Map;
import java.util.Scanner;

public class q37K好数 {

    private static int count;
    private static int limit;

    //dp dfs--超时
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //封顶的数字
        limit = scanner.nextInt();
        int length = scanner.nextInt();//count 两位

        count = 0;
        for (int i = 1; i < limit; i++) {//从第一位开始,枚举所有
            dfs(i, length - 1);

        }
        System.out.println(count);

    }

    //dp
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //封顶的数字
        limit = scanner.nextInt();
        int length = scanner.nextInt();//count 两位



    }

    private static void dfs(int pre, int lenght) {
        if (lenght == 0) {
            count++;
            return;
        }
        for (int i = 0; i < limit; i++) {
            if (1 != Math.abs(i - pre)) {
                dfs(i, lenght - 1);
            }
        }
    }
}
