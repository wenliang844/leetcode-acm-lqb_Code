package 蓝桥杯.练习系统.算法训练;

import java.util.Arrays;
import java.util.Scanner;

public class q9审美课多少对答案是相反的 {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //构造
        int studenNum = scanner.nextInt();
        int imageNum = scanner.nextInt();
        int[] matrix = new int[studenNum];
        //用一个一维数组存储,每一列就是一个数字,1则*2,0则不变
        for (int i = 0; i < studenNum; i++) {
            int temp = 0;
            for (int j = 0; j < imageNum; j++) {
                temp *= 2;
                if (scanner.nextInt() == 1) {
                    temp += 1;
                }
            }
            matrix[i] = temp;
        }
        //System.out.println(Arrays.toString(matrix));

        int target = 0;
        for (int i = 0; i < imageNum; i++) {
            target *= 2;
            target += 1;
        }
        int count = 0;
        //System.out.println("这是目标值" + target);
        //业务处理 对每列
        for (int i = 0; i < studenNum; i++) {
            for (int j = i + 1; j < studenNum; j++) {
                //如果这两个答案 ^=1,则就是全部相反的操作
                int temp = matrix[i] ^ matrix[j];

                if (temp == target) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
    //优化策略:将每个的人数统计一下
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //构造
        int studenNum = scanner.nextInt();
        int imageNum = scanner.nextInt();
        int[] matrix = new int[studenNum];
        //用一个一维数组存储,每一列就是一个数字,1则*2,0则不变
        int target = 0;
        for (int i = 0; i < imageNum; i++) {
            target *= 2;
            target += 1;
        }
        int counts[] = new int[200000];//target
        for (int i = 0; i < studenNum; i++) {
            int temp = 0;
            for (int j = 0; j < imageNum; j++) {
                temp *= 2;
                //if (scanner.nextInt() == 1) {
                    temp += scanner.nextInt();
               // }
            }
            matrix[i] = temp;
            counts[temp]++;//获得每个答案的人数
        }
        //System.out.println(Arrays.toString(matrix));


        int count = 0;
        //System.out.println("这是目标值" + target);
        //业务处理 对每列
        for (int i = 0; i < studenNum; i++) {
            /*for (int j = i + 1; j < studenNum; j++) {
                //如果这两个答案 ^=1,则就是全部相反的操作
                int temp = matrix[i] ^ matrix[j];

                if (temp == target) {
                    count++;
                }
            }*/
            int temp = matrix[i] ^ target;
            count += counts[temp];

        }

        System.out.println(count/2);//有一半重复计算
    }
}
