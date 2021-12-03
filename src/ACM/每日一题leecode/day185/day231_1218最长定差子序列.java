package ACM.每日一题leecode.day185;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day231_1218最长定差子序列 {
    public static void main(String[] args) {
        System.out.println(longestSubsequence2(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
        System.out.println(longestSubsequence2(new int[]{1, 2, 3, 4}, 1));
    }

    //方法一:暴力破解  超时
    public static int longestSubsequence(int[] arr, int difference) {

        //两趟,一个数组升序的,一个降序
        int len = arr.length;
        int[] up = new int[len];
        int[] down = new int[len];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
                if (arr[i] - arr[j] == difference) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
            max = Math.max(up[i], max);
            max = Math.max(down[i], max);
        }
        return max;
    }

    //方法二:数组 哈希表 动态规划 59|32
    public static int longestSubsequence2(int[] arr, int difference) {

        //用map存好数字对应的下标
        int len = arr.length;
        //int[] up = new int[len];
        //int[] down = new int[len];
        //Arrays.fill(up, 1);
        //Arrays.fill(down, 1);
        Map<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < len; i++) {
            Integer val = map.get(arr[i] - difference);
            if (val!=null){
                map.put(arr[i],val+1);
                max = Math.max(max,val+1);
            }else {
                map.put(arr[i],1);
            }
        }
        return max;
    }
}
