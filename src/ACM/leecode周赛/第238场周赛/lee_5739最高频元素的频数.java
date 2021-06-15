package ACM.leecode周赛.第238场周赛;

import java.util.Arrays;
import java.util.Map;

public class lee_5739最高频元素的频数 {
    /***
     元素的 频数 是该元素在一个数组中出现的次数。
     给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
     执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
     示例 1：
     输入：nums = [1,2,4], k = 5
     输出：3
     解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
     4 是数组中最高频元素，频数是 3 。
     */
    public static void main(String[] args) {
        System.out.println(maxFrequency2(new int[]{1, 2, 4}, 5));
        System.out.println(maxFrequency2(new int[]{1,4,8,13}, 5));
        System.out.println(maxFrequency2(new int[]{3,9,6}, 2));

    }

    //暴力,排序,每个当成最高频进行更新max
    public static int maxFrequency(int[] nums, int k) {
        int maxCount = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //从i-1开始,--操作,k-差距,count++,
            int count = 1;
            int tempk = k;
            for (int j = i-1; j >=0 ; j--) {
                tempk -= nums[i]-nums[j];
                if (tempk<0){
                    break;
                }
                count++;
            }
            //System.out.println("i="+i+"----count="+count);
            maxCount = Math.max(count,maxCount);
            if (maxCount==nums.length)return maxCount;
        }

        return maxCount;
    }

    //从大往小开始计算
    public static int maxFrequency2(int[] nums, int k) {
        int maxCount = 0;
        Arrays.sort(nums);
        for (int i = nums.length-1; i >=0; i--) {
            //从i-1开始,--操作,k-差距,count++,
            int count = 1;
            int tempk = k;
            for (int j = i-1; j >=0 ; j--) {
                tempk -= nums[i]-nums[j];
                if (tempk<0){
                    break;
                }
                count++;
            }
            //System.out.println("i="+i+"----count="+count);
            maxCount = Math.max(count,maxCount);
            if (maxCount==nums.length || tempk==k)return maxCount;//当一切平稳的时候,直接退出
        }

        return maxCount;
    }
}
