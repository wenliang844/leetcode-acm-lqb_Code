package ACM.校招面试题.神策数据;

import java.util.Scanner;

//超时
public class shence2图片矩阵下到上输出 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] data = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                data[i][j] = sc.nextInt();
            }
        }

        //从下到上输出数据
        for (int j = 0; j < len; j++) {
            for (int i = len-1; i >=0 ; i--) {
                System.out.println(data[i][j]);
            }
        }


    }
}
