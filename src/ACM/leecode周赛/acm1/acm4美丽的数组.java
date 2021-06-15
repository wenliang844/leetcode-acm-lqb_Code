package ACM.leecode周赛.acm1;

import java.util.Arrays;
import java.util.Scanner;

public class acm4美丽的数组 {
    public static void main(String[] args) {
        //排列时候用最大值减最小值
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0){
            int n = scanner.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            //业务处理
            Arrays.sort(array);
            int sum = 0;
            int left = 0;
            int right = array.length-1;
            while (left<right){
                sum+= array[right] - array[left];
                left++;
                right--;
            }
            System.out.println(sum);
        }
    }
}
