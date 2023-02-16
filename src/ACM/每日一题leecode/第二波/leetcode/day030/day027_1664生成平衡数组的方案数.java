package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/1/28 15:26
 */
public class day027_1664生成平衡数组的方案数 {
    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{2, 1, 6, 4}));
        System.out.println(waysToMakeFair(new int[]{1,1,1}));
    }

    public int waysToMakeFair2(int[] nums) {
        int n = nums.length;
        // arr[i][0]，表示删除下标i位置，后面的偶数下标的值的和;
        // arr[i][1], 表示删除下标i位置， 后面的奇数下标的值的和;
        int[][] arr = new int[n][2];
        int odd = 0, even = 0;
        for (int i = n - 1; i >= 0; --i) {
            arr[i][0] = even;
            arr[i][1] = odd;
            if ((i & 1) == 1) even += nums[i];
            else odd += nums[i];
        }

        odd = 0;
        even = 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (even + arr[i][0] == odd + arr[i][1]) ++ans;
            if ((i & 1) == 0) even += nums[i];
            else odd += nums[i];
        }

        return ans;
    }

    //超出时间限制 94/105
    public static int waysToMakeFair(int[] nums) {

        int length = nums.length;
        int[] temp = new int[length - 1];
        int count = 0;
        System.arraycopy(nums, 1, temp, 0, length - 1);
        if (check(temp)) {
            count++;
        }

        for (int i = 1; i < length; i++) {
            temp[i - 1] = nums[i - 1];
            if (check(temp)) {
                count++;
            }
        }

        return count;
    }

    private static boolean check(int[] temp) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < temp.length; i++) {
            if (i % 2 == 0) {
                x += temp[i];
            } else {
                y += temp[i];
            }
        }
        return x == y;
    }
}
