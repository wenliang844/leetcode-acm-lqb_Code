package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/4/26 10:35
 */
public class day47_1031两个非重叠子数组的最大和 {
    public static void main(String[] args) {
//        System.out.println(maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
        System.out.println(maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));//29
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

//        int left1 = 0;
        int right1 = firstLen;
        int sum1 = 0;
        for (int i = 0; i < right1; i++) {
            sum1 += nums[i];
        }

//        int left2 = 0;
        int right2 = secondLen;
        int sum2 = 0;
        for (int i = 0; i < right2; i++) {
            sum2 += nums[i];
        }

//        int left3 = firstLen;
        int right3 = firstLen + secondLen;
        int sum3 = 0;
        for (int i = firstLen; i < right3; i++) {
            sum3 += nums[i];
        }

        int maxsum = sum1 + sum3;
        int length = nums.length;

        System.out.println("开始值" + maxsum);
        System.out.println("0---" + right1 + "---" + sum1);
        System.out.println(0 + "---" + right2 + "---" + sum2);
        System.out.println(firstLen + "---" + right3 + "---" + sum3);

        for (int i = right1; i < length; i++) {
            System.out.println("开始第一次循环");
            sum1 += nums[i];
            sum1 -= nums[i - firstLen];

            System.out.println("开始向右边寻找");
            if (i + secondLen < length) {
                for (int j = i + secondLen; j < length; j++) {
                    sum3 += nums[j];
                    sum3 -= nums[j - secondLen];
                    maxsum = Math.max(maxsum, sum1 + sum3);
                    System.out.println("去掉下标" + (j - secondLen) + "---" + "加入下标" + j + "得到sum=" + sum3 + "maxsum=" + maxsum);
                }
            }

            System.out.println("开始向左边寻找");
            if (i >= firstLen + secondLen) {
                maxsum = Math.max(maxsum, sum1 + sum2);
                System.out.println("left=0到right=" + secondLen + "" + "初始值" + sum2);
                for (int j = secondLen + 1; j < i - firstLen + 1; j++) {
                    sum2 += nums[j];
                    sum2 -= nums[j - secondLen];
                    maxsum = Math.max(maxsum, sum1 + sum2);
                    System.out.println("去掉下标" + (j - secondLen) + "---" + "加入下标" + j + "得到sum=" + sum2 + "maxsum=" + maxsum);
                }
            }
        }

        return maxsum;
    }
}
