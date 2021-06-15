package 蓝桥杯.练习系统.算法训练;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class q40区间k大数查询 {
    //新创建一个二维数组,存好数与源下标的对应关系,排序后,每次从高到低进行询问,是区间中的下标count--
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0]= scanner.nextInt();
            nums[i][1]=i;
        }

        //排序 默认小到大
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        //System.out.println(nums[0][0]);
        //System.out.println(nums[1][0]);
        //System.out.println(nums[2][0]);

        int query = scanner.nextInt();
        while (query-->0){
            int left = scanner.nextInt()-1;
            int right = scanner.nextInt()-1;
            int count = scanner.nextInt();

            //遍历nums,是left - right中的数字则count--;
            for (int i = n-1; i >=0; i--) {
                if (nums[i][1]>=left && nums[i][1]<=right){
                    if (--count==0){
                        System.out.println(nums[i][0]);
                        break;
                    }
                }
            }
        }
    }
}
