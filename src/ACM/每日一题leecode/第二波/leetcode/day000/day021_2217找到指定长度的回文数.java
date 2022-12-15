package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.Arrays;

/**
 * @author 陈文亮
 * @date 2022/12/14 15:36
 */
public class day021_2217找到指定长度的回文数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthPalindrome(new int[]{1, 2, 3, 4, 5, 90}, 3)));
        System.out.println(Arrays.toString(kthPalindrome(new int[]{2, 4, 6}, 4)));
    }

    //方法一：暴力破解法 只需考虑前半部分，就是10 11 12...
    //脑筋急转弯了撒
    public static long[] kthPalindrome(int[] queries, int intLength) {
        int length = (intLength + 1) / 2;
        boolean flag = intLength % 2 == 0;
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < length; i++) {
            sb.append("0");
        }
        Integer integer = Integer.valueOf(sb.toString());
        String[] strings = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            strings[i] = String.valueOf(integer + queries[i] - 1);
        }
        //System.out.println(Arrays.toString(strings));

        long[] res = new long[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > length) {
                res[i] = -1;
            } else if (flag) {
                res[i] = Long.valueOf(strings[i] + new StringBuilder(strings[i]).reverse().toString());
            } else {
                res[i] = Long.valueOf(strings[i] + new StringBuilder(strings[i].substring(0, length - 1)).reverse().toString());
            }
        }
        return res;
    }
}
