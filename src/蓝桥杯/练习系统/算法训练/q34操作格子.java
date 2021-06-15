package 蓝桥杯.练习系统.算法训练;

import java.util.Scanner;

public class q34操作格子 {

    private static int[] nums;
    private static int[] pre;

    //线段树 树状数组 前缀和   区间查询 单点修改 区间最大值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int query = scanner.nextInt();
        nums = new int[len];
        pre = new int[len+1];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 1; i < len + 1; i++) {
            pre[i] = pre[i-1]+nums[i-1];
        }

        while (query-- >0){
            int p = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            switch (p){
                case 1:
                    nums[x-1]=y;break;
                case 2:
                    System.out.println(pre[y] - pre[x-1]);break;
                case 3:
                    int max =nums[x-1];
                    for (int i = x; i < y; i++) {
                        if (nums[i]>max){
                            max=nums[i];
                        }
                    }
                    System.out.println(max);
            }
        }
    }
}
