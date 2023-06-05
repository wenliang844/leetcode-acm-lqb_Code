package ACM.每日一题leecode.第二波.leetcode.day030;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈文亮
 * @date 2023/3/23 14:26
 */
public class day034_2389和有限的最长子序列 {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));//[2,3,4]
        //System.out.println(Arrays.toString(answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})));

        String title = "广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称广告计划名称新建产品测试";
        if (title.length() > 150){
            title = title.substring(0,150);
        }
        System.out.println(title);

    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            indexMap.put(queries[i], i);
            res[i] = queries[i];
        }

        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        Arrays.sort(queries);
        //System.out.println(Arrays.toString(queries));
        int length = nums.length;
        int sum = 0;


        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        //System.out.println("--sum=" + sum);

        int index = queries.length - 1;

        for (int i = length - 1; i >= 0; i--) {
            //System.out.println(nums[i]);
            while (index >= 0 && queries[index] >= sum) {
                //System.out.println("--sum=" + sum);
                //System.out.println(queries[index]);
                res[indexMap.get(queries[index])] = i+1;
                index--;
            }
            sum -= nums[i];
        }

        while (index >= 0) {
            res[indexMap.get(queries[index])] = 0;
            index--;
        }
        return res;
    }
}
