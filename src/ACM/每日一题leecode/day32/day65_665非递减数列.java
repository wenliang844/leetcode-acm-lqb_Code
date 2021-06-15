package ACM.每日一题leecode.day32;

/****
 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

  

 示例 1:

 输入: nums = [4,2,3]
 输出: true
 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 示例 2:

 输入: nums = [4,2,1]
 输出: false
 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */
public class day65_665非递减数列 {

    public static void main(String[] args) {
        System.out.println("这是结果=" + checkPossibility(new int[]{4, 2, 3}));
        System.out.println("这是结果=" + checkPossibility(new int[]{4, 2, 1}));
        System.out.println("这是结果=" + checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println("这是结果=" + checkPossibility(new int[]{5, 7, 1, 8}));
    }

    /***
     思路:
     记录有两个以上是相邻a[i]>a[j]就是一个不可变递增数列
     java把握总体情况,解决特殊情况
     */
    public static boolean checkPossibility(int[] nums) {

        int counnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                counnt++;
                if (i > 0 && i < nums.length - 2) {
                    if (nums[i - 1] > nums[i + 1] && nums[i] > nums[i + 2]) {
                        return false;
                    }
                }
            }
        }
        if (counnt > 1) {
            return false;
        } else {
            return true;
        }

    }
}
