package ACM.每日一题leecode.day237;

public class day260_307区域和检索数组可修改 {
    public static void main(String[] args) {

    }

    public int nums[];

    public day260_307区域和检索数组可修改(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum+=nums[i];
        }
        return sum;
    }
}
