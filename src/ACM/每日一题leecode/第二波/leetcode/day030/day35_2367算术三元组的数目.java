package ACM.每日一题leecode.第二波.leetcode.day030;

/**
 * @author 陈文亮
 * @date 2023/3/31 15:32
 */
public class day35_2367算术三元组的数目 {
    public static void main(String[] args) {
        System.out.println(arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {

        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[j] - nums[i] != diff) continue;
                for (int k = j + 1; k < length; k++) {
                    if (nums[k] - nums[j] == diff) count++;
                }
            }
        }
        return count;
    }
}
