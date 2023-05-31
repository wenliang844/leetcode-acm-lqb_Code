package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈文亮
 * @date 2023/5/15 15:34
 */
public class day48_1072按列翻转得到最大值等行数 {
    public static void main(String[] args) {

        System.out.println(maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
    }


    /**
     *
     * 统计 0的个数 1的个数，只要列0的个数或length-0的个数相等，就res++   (需要全相等) 转十进制
     *
     * "行与行之间所有值都相等的最大行数 "应该改为“行内所有值都相等的最大行数”
     *
     * 题目是真的难懂，实际上指的是： 你可以将二维数组某一行的 所有 0 变成 1 ，同时把所有 1 变成 0 ，让你输出经过任意次数这样的变换后，相同行出现的最大次数。实际上还是计数。 和题目里的列没啥关系。
     *
     * class Solution {
     * 	public int maxEqualRowsAfterFlips(int[][] matrix) {
     * 		Map<String, Integer> map = new HashMap<>();
     * 		for (int[] arr : matrix) {
     * 			char[] str = new char[arr.length];
     * 			for (int i = 0; i < arr.length; i++) {
     *                 // 异或，相同为 0 ，不同为 1 。
     *                 // 利用该特点，可以将所有行转为 1 开头（不需要实际上是 1 开头，只需要逻辑上把 0 开头和 1 开头区分就行。）
     * 				str[i] = (char) (arr[i] ^ arr[0]);
     *                        }
     * 			String s = new String(str);
     * 			map.put(s, map.getOrDefault(s, 0) + 1);* 		}
     * 		int res = 0;
     *         // 只需要知道 value 。
     * 		for (int value : map.values()) {
     * 			res = Math.max(res, value);
     *        }
     * 		return res;
     *    }
     * }
     *
     * class Solution {
     *     public int maxEqualRowsAfterFlips(int[][] matrix) {
     *
     *         int m = matrix.length, n = matrix[0].length;
     *
     *         Map<String, Integer> map = new HashMap<>();
     *         for (int i = 0; i < m; i++) {
     *             char[] chars = new char[n];
     *             for (int j = 0; j < n; j++) {
     *                 chars[j] = (char) (matrix[i][j] ^ matrix[i][0]);
     *             }
     *             map.merge(String.valueOf(chars), 1, Integer::sum);
     *         }
     *         return map.values().stream().max(Integer::compareTo).get();
     *
     *     }
     * }
     * @param matrix
     * @return
     */
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> map = new HashMap<>();

        int res = 0;
        int length = matrix.length;
        int row = matrix[0].length;
        for (int i = 0; i < length; i++) {
            //统计0的个数
            char[] str = new char[row];
            for (int j = 0; j < row; j++) {
                str[j] = (char) (matrix[i][j] ^ matrix[i][0]);
            }
            String s = new String(str);
            map.put(s,map.getOrDefault(s,0)+1);
        }

        System.out.println(map);
        int bigRes = 0;
        for (Integer value : map.values()) {
            bigRes=Math.max(bigRes,value);
        }
        return bigRes;
    }
}
