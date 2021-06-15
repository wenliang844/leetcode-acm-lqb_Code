package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day125_1310子数组异或查询 {
    /***
     有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。

     对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。

     并返回一个包含给定查询 queries 所有结果的数组。
     */

    //暴力解法
    public static int[] xorQueries(int[] arr, int[][] queries) {

        int len = queries.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = arr[queries[i][0]];
            for (int j = queries[i][0] + 1; j <= queries[i][1]; j++) {
                ans[i] ^= arr[j];
            }
        }

        return ans;
    }

    //前缀和 100/96
    public static int[] xorQueries2(int[] arr, int[][] queries) {

        int len = queries.length;
        int[] ans = new int[len];

       //构造 前缀和
        int[] preArray = new int[arr.length+1];
        for (int i = 1; i <= arr.length; i++) {
            preArray[i] = preArray[i-1] ^ arr[i-1];
        }

        //利用前缀异或和:求3,5  1-2^3-5=1-5 1-5^1-2=3-5
        for (int i = 0; i < len; i++) {
            ans[i] = preArray[queries[i][1]+1]^preArray[queries[i][0]];//[2,7,14,8]
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries2(new int[]{1,3,4,8},new int[][]{{0,1},{1,2},{0,3},{3,3}})));
    }
}
