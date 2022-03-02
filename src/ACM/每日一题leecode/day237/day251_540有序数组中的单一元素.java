package ACM.每日一题leecode.day237;

public class day251_540有序数组中的单一元素 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i];
            }
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }
        return nums[nums.length - 1];
    }
}
