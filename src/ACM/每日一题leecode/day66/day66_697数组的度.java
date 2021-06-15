package ACM.每日一题leecode.day66;

import java.util.HashMap;

/****
 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 示例 1：
 输入：[1, 2, 2, 3, 1]
 输出：2
 解释：
 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 连续子数组里面拥有相同度的有如下所示:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 最短连续子数组[2, 2]的长度为2，所以返回2.
 示例 2：
 输入：[1,2,2,3,1,4,2]
 输出：6
 */
public class day66_697数组的度 {

    public static void main(String[] args) {
        System.out.println("这是结果"+findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println("这是结果"+findShortestSubArray(new int[]{1,2,2,3,1,4,2}));

    }

    public static int findShortestSubArray(int[] nums) {
        //1.计数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            int tmp = nums[i];
            Integer n = map.get(tmp);
            if (n == null){
                map.put(tmp,1);
            }else {
                map.put(tmp,n+1);
            }
        }
        //2.扫描
        int maxCounts = 0;
        int maxValues = 0;
        for (Integer integer : map.keySet()) {
            int n = map.get(integer);
            if (n>maxCounts){
                maxCounts=n;
                maxValues=integer;
            }
        }

        System.out.println("这是最大的出现次数==="+maxCounts);
        System.out.println("这是最大出现的数字======"+maxValues);
        //3.记录开始和结束的下标
        int begin = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==maxValues){
                begin = i;
            }
        }
        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i]==maxValues){
                end=i;
            }
        }
        System.out.println("这是begin="+begin);
        System.out.println("这是end="+end);
        return begin-end+1;
    }
}
