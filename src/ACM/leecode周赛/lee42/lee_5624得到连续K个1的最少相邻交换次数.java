package ACM.leecode周赛.lee42;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。
 * <p>
 * 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：1
 * 解释：在第一次操作时，nums 可以变成 [1,0,0,0,1,1] 得到连续两个 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,0,0,0,0,1,1], k = 3
 * 输出：5
 * 解释：通过 5 次操作，最左边的 1 可以移到右边直到 nums 变为 [0,0,0,0,0,1,1,1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,0,1], k = 2
 * 输出：0
 * 解释：nums 已经有连续 2 个 1 了。
 */
public class lee_5624得到连续K个1的最少相邻交换次数 {

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 0, 0, 1, 0, 1}, 2));//1
        System.out.println(minMoves(new int[]{0, 1, 1, 0, 0, 1, 0, 0, 0}, 3));//1

    }

    public static int minMoves(int[] nums, int k) {

        /***
         思路,list   ->加入每个1中夹着的0的个数  0也算
         k取2  那就去list中的1个最小子串
         */
        //1暴力解法
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < nums.length; i++) {


            if (nums[i] == 0) {
                count++;
            }
            if (nums[i] == 1) {
                list.add(count);
                count = 0;
            }

        }
        System.out.println("这是list==" + list);

        int minSum = 100;//取大
        //开始去list的子串长度k

        k = k - 1;
        for (int i = 0; i < list.size(); i++) {
            int tmpSum = 0;
            //取k个
            if (i + k > list.size()) break;
            for (int j = i; j < i + k; j++) {
                tmpSum += list.get(j);
            }
            minSum = Math.min(minSum, tmpSum);
        }

        return minSum;
    }
}
