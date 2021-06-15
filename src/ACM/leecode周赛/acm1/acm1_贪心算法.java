package ACM.leecode周赛.acm1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class acm1_贪心算法 {//无重叠区间   4 5  5 6   ->是可以的
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==0)return;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0]=scanner.nextInt();
            arr[i][1]=scanner.nextInt();
        }

        //业务逻辑

        //1.先排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {//按区间的结尾小排序
                return ints[1]-t1[1];
            }
        });

        /*for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }*/

        //贪心算法,判断右边区间大小,谁小学谁
       /* int count = 1;
        int begin = arr[0][0];
        int limit = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][1]<limit){
                limit=arr[i][1];
                begin=arr[i][0];
            }else if (arr[i][0]>limit){
                count++;
                limit = arr[i][1];
                begin=arr[i][0];
            }else if (arr[i][0]==begin){
                limit=Math.min(arr[i][1],limit);
            }
        }*/

        int count = 1;
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (arr[j][0] >= arr[i][1]) {//不重叠
                count++;
                i = j;
                j++;
            }else {
                j++;
            }
        }

        System.out.println(count);
    }
}
