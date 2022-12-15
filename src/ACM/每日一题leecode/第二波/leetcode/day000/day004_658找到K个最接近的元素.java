package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.Arrays;

/**
 * @author 陈文亮
 * @date 2022/8/25 00:57
 */
public class day004_658找到K个最接近的元素 {
    /**
     * 658. 找到 K 个最接近的元素
     * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     * <p>
     * 整数 a 比整数 b 更接近 x 需要满足：
     * <p>
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,2,3,4,5], k = 4, x = 3
     * 输出：[1,2,3,4]
     * 示例 2：
     * <p>
     * 输入：arr = [1,2,3,4,5], k = 4, x = -1
     * 输出：[1,2,3,4]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(k(new int[]{1, 2, 3, 4, 5}, 4, 3)));
    }

    //未验证
    private static int[] k(int[] ints, int k, int x) {
        //确定 i,j 的位置，ints[i] < k < ints[j]
        int begin = 0;
        int end = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > x) {
                end = i;
                begin = i - 1;
                break;
            }
        }
        int count = 0;
        while (count < k) {
            if (Math.abs(x - ints[begin]) <= Math.abs(ints[end] - x)) {
                begin--;
            } else {
                end++;
            }
            count++;
            if (begin < 0) {
                //end = end + k - count;
                break;
            }
            if (end >= ints.length) {
                begin = begin - k + count;
                break;
            }
            System.out.println("begin==="+begin+"end==="+end+"count=="+count);
        }

        System.out.println("begin==="+begin+"end==="+end);
        int[] res = new int[k];
        System.arraycopy(ints, begin + 1, res, 0, k);
        return res;
    }


}
