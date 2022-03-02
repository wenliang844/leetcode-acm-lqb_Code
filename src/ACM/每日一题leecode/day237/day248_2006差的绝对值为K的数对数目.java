package ACM.每日一题leecode.day237;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day248_2006差的绝对值为K的数对数目 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new String[]{"张三", "李四", "王五", "张三", "Brad Pitt", "张三(1)", "张三"})));
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));
    }

    //75|5
    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count += map.getOrDefault(nums[i] - k, 0) + map.getOrDefault(nums[i] + k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return count;
    }


    //评测题目: 有一个包含n个字符串的数组，请输出n个字符串标识，如果碰到相同字符串的就输出字符串+（m）。
    //其中m是保证字符串标识唯一的最小正整数，n<= 1* 10^3，然后每个字符串由中文、英文、()或者数字组成。
    //输入：字符串数组 = ["张三","李四","王五","张三","Brad Pitt","张三(1)","张三"]
    //输出：            ["张三","李四","王五","张三(1)","Brad Pitt","张三(1)(1)","张三(2)"]
    public static String[] solve(String[] array) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                res[i] = array[i] + "(" + map.get(array[i]) + ")";
                map.put(array[i], map.get(array[i]) + 1);
                map.put(res[i], 1);
            } else {
                map.put(array[i], 1);
                res[i] = array[i];
            }
        }
        return res;
    }
}
