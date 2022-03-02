package ACM.每日一题leecode.day237;

public class day240_1995统计特殊四元组 {
    public static void main(String[] args) {
        System.out.println(countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(countQuadruplets(new int[]{3, 3, 6, 4, 5}));
    }

    //nums[a] + nums[b] + nums[c] == nums[d] 且a < b < c < d   80 20
    public static int countQuadruplets(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            count++;
                        }

                    }

                }
            }

        }
        return count;
    }
}
