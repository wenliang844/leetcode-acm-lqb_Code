package ACM.tag刷题.数据结构.数组;

import java.util.Arrays;
import java.util.Map;

public class array_581最短无序连续子数组 {
    /***
     给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     请你找出符合题意的 最短 子数组，并输出它的长度。
     示例 1：
     输入：nums = [2,6,4,8,10,9,15]
     输出：5
     解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     */
    /***
     思路和方法:方法一:将前面第一个降序的i找出来 1
     将后面最后一个降序的i找出来5    --- 1 2 3 4 5排序好即可
     原理,前面的都是升序,后面的都是升序,保证就可以了
     */
    public static int findUnsortedSubarray(int[] nums) {
        int i = 0;
        for (; i < nums.length - 1; i++) {//找到第一个降序的前面一个下标
            if (nums[i] >= nums[i + 1]) break;
        }

        int j = nums.length - 1;
        for (; j > 0; j--) {
            if (nums[j] <= nums[j - 1]) break;
        }
        System.out.println("这是ij" + i + "--" + j);
        if (i >= j) {
            return 0;
        }
        return j - i + 1;
    }

    //方法二:找升序序列的个数 166/307
    public static int findUnsortedSubarray2(int[] nums) {
        int i = 0;
        for (; i < nums.length - 1; i++) {//找到第一个升序序列
            if (nums[i] > nums[i + 1]) break;
        }
        // i++;

        int j = nums.length - 1;
        for (; j > 0 && nums[j] >= nums[i]; j--) {
            if (nums[j] < nums[j - 1]) break;
        }
        System.out.println("这是ij" + i + "--" + j);
        if (i >= j) {
            return 0;
        }
        return j - i + 1;
    }

    //方法三:从左到右记录最大值max num[i]<max i需要调整high
    //右边记录最小值min num[i]>min i位置需要调整low   high-low+1   80 80
    //最大值最小值策略
    public static int findUnsortedSubarray3(int[] nums) {

        if (nums.length <= 1) return 0;
        int high = 0;
        int low = nums.length - 1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - i - 1]);
            if (nums[i] < max) high = i;//这个i小于最大值就是需要修改的
            if (nums[nums.length - 1 - i] > min) low = nums.length - 1 - i;//大于最小值,就是需要修改的
        }

        System.out.println("这是high_low" + high + "---" + low);
        if (high <= low) return 0;
        return high - low + 1;

    }

    /***
     方法 3：排序
     算法
     另一个简单的想法是：我们将数组 numsnums 进行排序，记为 nums\_sortednums_sorted 。然后我们比较 numsnums
     和 nums\_sortednums_sorted 的元素来决定最左边和最右边不匹配的元素。它们之间的子数组就是要求的最短无序子数组。

     */
    //方法四:排序
    public static int findUnsortedSubarray4(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray3(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray3(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray3(new int[]{1, 3, 2, 4}));
        System.out.println(findUnsortedSubarray3(new int[]{1}));
        System.out.println(findUnsortedSubarray3(new int[]{1, 3, 2, 2, 2}));//相等的也要调整
        System.out.println(findUnsortedSubarray3(new int[]{1, 2, 3, 3, 3}));//相等不用调整的情况
        System.out.println(findUnsortedSubarray3(new int[]{2, 3, 3, 2, 4}));//相等不用调整的情况3
    }
}
