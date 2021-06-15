package ACM.每日一题leecode.day32;

public class day63_643子数组最大平均数I {
    public static void main(String[] args) {

        System.out.println("这是结果=" + findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println("这是结果=" + findMaxAverage(new int[]{-1}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int j = i + k;
            if (j <= nums.length) {
                int sum = 0;
                for (int k1 = i; k1 < j; k1++) {
                    sum += nums[k1];
                    System.out.println("这是数字"+k1+"-"+nums[k1]);
                }

                result = Math.max(result, sum);
                System.out.println("这是sum---"+sum);
            }
        }

        System.out.println("--这回死result--"+result);
        return result/k;
    }
}
