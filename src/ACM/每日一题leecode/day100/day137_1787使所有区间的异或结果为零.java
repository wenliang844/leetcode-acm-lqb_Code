package ACM.每日一题leecode.day100;

public class day137_1787使所有区间的异或结果为零 {
    /*****
     给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
     返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
     示例 1：
     输入：nums = [1,2,0,3,0], k = 1
     输出：3
     解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
     */
    public static void main(String[] args) {
        System.out.println(minChanges(new int[]{1, 2, 0, 3, 0}, 1));
        System.out.println(minChanges(new int[]{26,19,19,28,13,14,6,25,28,19,0,15,25,11}, 3));
    }

    //方法一:贪心算法,滑动窗口,直接将最后一个改,count+1
    public static int minChanges(int[] nums, int k) {
        int window = nums[0];//构造一个窗口
        int i = 1;
        for (; i < k; i++) {
            window ^= nums[i];
        }
        int count = 0;
        //看第一个window符不符合要求  每次保证window是0
        if (window != 0) {
            window ^= nums[i - 1];
            nums[i - 1] = window ^ 0;
            count++;
        }

        for (; i < nums.length; i++) {
            //判断window^nums[i] 再^nums[i-k]会不会等于0
            window=0;
            window^=nums[i-k];
            window^=nums[i];

            if (window != 0) {
                window ^= nums[i];
                nums[i] = window ^ 0;
                count++;
            }
        }
        return count;
    }

    //方法二:动态规划
    public static int minChanges2(int[] nums, int k) {
       return 0;
    }
}
