package ACM.其他的算法比赛.笔试.bilibili;

public class bb0数组原地去重 {
    public static void main(String[] args) {
        System.out.println(dist(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 6, 7, 8, 9}));
    }

    //方法一:直接交换法
    public static int dist(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                for (int j = i; j < len - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                len--;
            }
        }
        return len;

    }
}
