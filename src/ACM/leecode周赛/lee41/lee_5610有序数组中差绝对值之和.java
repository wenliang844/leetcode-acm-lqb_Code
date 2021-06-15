package ACM.leecode周赛.lee41;

/*
给你一个 非递减 有序整数数组 nums 。

请你建立并返回一个整数数组 result，它跟 nums 长度相同，且result[i] 等于 nums[i] 与数组中所有其他元素差的绝对值之和。

换句话说， result[i] 等于 sum(|nums[i]-nums[j]|) ，其中 0 <= j < nums.length 且 j != i （下标从 0 开始）。



示例 1：

输入：nums = [2,3,5]
输出：[4,3,5]
解释：假设数组下标从 0 开始，那么
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。
示例 2：

输入：nums = [1,4,6,8,10]
输出：[24,15,13,15,21]


提示：

2 <= nums.length <= 105
1 <= nums[i] <= nums[i + 1] <= 104
 */
public class lee_5610有序数组中差绝对值之和 {
    public static void main(String[] args) {

        long start1 = System.currentTimeMillis();
        int[] nums1 = {2, 3, 5, 2, 3, 5, 5, 5, 5, 5, 5, 5, 2, 3, 5, 5, 5, 5, 5, 5, 2, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5};
        int[] result1 = getSumAbsoluteDifferences(nums1);
        for (int i : result1) {
            System.out.print(i + "\t");
        }
        long end1 = System.currentTimeMillis();
        System.out.println("----------------------------" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        int[] nums2 = {2, 3, 5, 2, 3, 5, 5, 5, 5, 5, 5, 5, 2, 3, 5, 5, 5, 5, 5, 5, 2, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5};
        int[] result2 = getSumAbsoluteDifferences2(nums2);
        for (int i : result2) {
            System.out.print(i + "\t");
        }
        long end2 = System.currentTimeMillis();
        System.out.println("----------------------------" + (end2 - start2));

        long start3 = System.currentTimeMillis();
        int[] nums3 = {2, 3, 5, 2, 3, 5, 5, 5, 5, 5, 5, 5, 2, 3, 5, 5, 5, 5, 5, 5, 2, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5, 3, 5, 5, 5, 5, 5};
        int[] result3 = getSumAbsoluteDifferences3(nums3);
        for (int i : result3) {
            System.out.print(i + "\t");
        }
        long end3 = System.currentTimeMillis();
        System.out.println("----------------------------" + (end3 - start3));

    }

    //math.abs -------超时
    public static int[] getSumAbsoluteDifferences(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += Math.abs(nums[j] - nums[i]);
            }
            result[i] = sum;

        }

        return result;
    }

    //比大小 取值-----超时
    public static int[] getSumAbsoluteDifferences2(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    sum += nums[j] - nums[i];
                } else {
                    sum += nums[i] - nums[j];
                }
            }
            result[i] = sum;

        }

        return result;
    }

    //空间换时间
    //定义一个二维数组   abs[i][j]   j与i的绝对值
    public static int[] getSumAbsoluteDifferences3(int[] nums) {

        int[] result = new int[nums.length];
        int abs[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                abs[i][j] = Math.abs(nums[i] - nums[j]);
            }
        }

        for (int i = 0; i < result.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += abs[i][j];

            }
            result[i] = sum;

        }

        return result;
    }

    public static int[] getSumAbsoluteDifferences4(int[] nums) {

        int[] result = new int[nums.length];
        int abs[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                result[i] += Math.abs(nums[i] - nums[j]);
            }
        }
        return result;
    }

    public static int[] getSumAbsoluteDifferences5(int[] nums) {

        int[] result = new int[nums.length];
        //int abs[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    result[i] += nums[i]-nums[j];
                }
                if (nums[i]<nums[j]){
                    result[i] += nums[j]-nums[i];
                }

            }
        }
        return result;
    }


    /*
    解题思路
假设如果不需要取绝对值，那么每个位置的结果就是sum(n) - nums[i] * n
如果加上一个负数的绝对值，等于减去这个负数
加上某个数，在减去同一个数，结果不变
-(a-b) = +(b-a)
结合上面的数据定理，我们可以得到：


result[i] = sum(n) - nums[i] * n + (nums[i] - sum(i-1)) * 2
其中，n代表数据长度，sum(i),代表前i个数据之和

例子证明：
输入：nums = [2,3,5]
输出：[4,3,5]
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。

将刷上面的数据计算过程转换成以下：


result[0] = (2-2)+(3-2)+(5-2)
          = (2+3+5)-2*3
result[1] = (3-2)+(3-3)+(5-3)
          = (3-2)-【(2-3)+(2-3)】+(3-3)+(5-3)
          = (3-2)+(3-2)+(2-3)+(3-3)+(5-3)
          = (3-2)*2+(2+3+5)-3*3
result[2] = (5-2)+(5-3)+(5-5)
          = (5-2)+(5-3)-【(2-5)-(3-5)+(2-5)+(3-5)】+(5-5)
          = (5-2)+(5-3)+(5-2)+(5-3)+(2-5)+(3-5)+(5-5)
          = (5-2-3)*3+(2+3+5)-5*3

作者：Ethan-JX
链接：https://leetcode-cn.com/problems/sum-of-absolute-differences-in-a-sorted-array/solution/javashuang-bai-cai-yong-shu-xue-de-si-lu-uueb/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    //网络
    public static int[] getSumAbsoluteDifferences7(int[] nums) {
        int length = nums.length;
        int result[] = new int[length];

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        int su = 0;
        for (int i = 0, j = length; i < length; i++, j--) {
            result[i] = sum - nums[i] * length + (i * nums[i] - su) * 2;
            su += nums[i];
        }
        return result;
    }
}
