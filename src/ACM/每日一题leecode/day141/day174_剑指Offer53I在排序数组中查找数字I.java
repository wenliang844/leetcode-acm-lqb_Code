package ACM.每日一题leecode.day141;

public class day174_剑指Offer53I在排序数组中查找数字I {

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10},8));
    }

    //二分
    public static int search(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target)count++;
        }

        return count;
    }
}
