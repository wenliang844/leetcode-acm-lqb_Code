package ACM.leecode周赛.第234场周赛;

import java.util.Arrays;

public class lee2_5715还原排列的最少操作步数 {

    /**
     * 给你一个偶数 n​​​​​​ ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i​（下标 从 0 开始 计数）。
     * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
     * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
     * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
     * 然后将 arr​​ 赋值​​给 perm 。
     * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
     * <p>
     * 示例 1：
     * 输入：n = 2
     * 输出：1
     * 解释：最初，perm = [0,1]
     * 第 1 步操作后，perm = [0,1]
     * 所以，仅需执行 1 步操作
     */

    //1.暴力模拟
    public static int reinitializePermutation(int n) {

        int perm[] = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        //开始模拟操作
        int count = 0;
        while (true){
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                if (i%2==0){
                    arr[i] = perm[i/2];
                }else {
                    arr[i] = perm[n/2 + (i-1)/2];
                }
            }
            count++;
            //System.out.println(Arrays.toString(arr) +"--"+Arrays.toString(perm));
            //System.out.println(Arrays.toString(arr).equals(Arrays.toString(perm)));
            //System.out.println(Arrays.toString(arr)==(Arrays.toString(perm)));
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (arr[i]!=i) {
                    flag=false;
                }
            }
            //System.out.println(flag);
            //如果arr和perm相等,就break,否则赋值继续
            if (flag){
                break;
            }else {
                for (int i = 0; i < n; i++) {
                    perm[i] = arr[i];
                }
            }

            //if (count>5)break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(reinitializePermutation(2));
        System.out.println(reinitializePermutation(4));
        System.out.println(reinitializePermutation(6));
        System.out.println(reinitializePermutation(8));
        System.out.println(reinitializePermutation(10));
        System.out.println(reinitializePermutation(12));
        System.out.println(reinitializePermutation(14));
        System.out.println(reinitializePermutation(16));
        System.out.println(reinitializePermutation(18));
        System.out.println(reinitializePermutation(20));
    }
}
