package ACM.tag刷题.数据结构.堆;

import java.util.Arrays;

public class heap_215数组中的第K个最大元素 {
    /***
     在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
     而不是第 k 个不同的元素。
     输入: [3,2,1,5,6,4] 和 k = 2
     6 5 4 3 2 1
     输出: 5
     输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     输出: 4
     */

    //方法一,暴力破解
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //方法二: -> /**利用快速排序中的partition思想解决，时间复杂度O(N); **/
    // 快排思想
    // 1 随机确定一个基准值
    // 2 小数放左 大数放右
    // 3 检查当前值的位置
    // =k-1 当前数就是第K大
    // <k-1 target在右区间
    // >k-1 target在左区间
    // 在目标区间继续寻找
    public static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //方法三:建立一个大根堆，做 k - 1k−1 次删除操作后堆顶元素

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
        System.out.println(findKthLargest(new int[]{3}, 1));//4
        System.out.println(findKthLargest(new int[]{0, 1}, 1));//4
    }
}
