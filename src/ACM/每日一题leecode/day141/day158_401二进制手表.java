package ACM.每日一题leecode.day141;

import java.util.ArrayList;
import java.util.List;

public class day158_401二进制手表 {
    /***
     二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
     例如，下面的二进制手表读取 "3:25" 。
     */
    public static void main(String[] args) {
        System.out.println(readBinaryWatch2(1));
        System.out.println(readBinaryWatch2(2));
    }

    /***
     二进制 4 ->16位
     6 -> 32位
     方法一:枚举 trun on最多8个 22//55
     */
    public static List<String> readBinaryWatch(int turnedOn) {
        int hours[] = new int[]{1, 2, 4, 8};
        int mimutes[] = new int[]{1, 2, 4, 8, 16, 32};

        List<String> all_list = new ArrayList<>();
        for (int i = 0; i <= turnedOn; i++) {//hour亮i个 mi亮turn-i
            List<Integer> hour_list = new ArrayList<>();
            List<Integer> mimute_list = new ArrayList<>();
            //hour从1 2 4 8中选取i个数字
            //mimute从1 2 4 8 16 32中选turn-i个数字
            dfs(hours, hour_list, i, 0, 0);
            dfs(mimutes, mimute_list, turnedOn - i, 0, 0);
            System.out.println(hour_list);
            System.out.println(mimute_list);
            for (int j = 0; j < hour_list.size(); j++) {
                if (hour_list.get(j) < 12) {
                    for (int k = 0; k < mimute_list.size(); k++) {
                        if (mimute_list.get(k) < 60) {
                            String mimute_string = mimute_list.get(k) <= 9 ? "0" + mimute_list.get(k) : "" + mimute_list.get(k);
                            all_list.add(hour_list.get(j) + ":" + mimute_string);
                        }
                    }
                }

            }
        }
        return all_list;
    }

    private static void dfs(int[] nums, List<Integer> list, int count, int res, int start) {
        if (count == 0) {
            list.add(res);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            dfs(nums, list, count - 1, res + nums[i], i + 1);
        }
    }


    //方法二:枚举时分,计算所有的0,11 与0,59的组合,如果他们的和为turnOn则加入 34//44
    public static List<String> readBinaryWatch2(int turnedOn) {
        List<String> list_res = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    list_res.add(i + ":" + (j <= 9 ? "0" : "") + j);
                }
            }
        }

        return list_res;
    }

    //方法三:二进制位枚举 34//36
    public static List<String> readBinaryWatch3(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }

}
