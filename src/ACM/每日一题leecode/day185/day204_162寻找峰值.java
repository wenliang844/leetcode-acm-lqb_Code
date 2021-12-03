package ACM.每日一题leecode.day185;

//你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
public class day204_162寻找峰值 {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{1,2}));
        System.out.println(findPeakElement(new int[]{1}));

    }

    // O(n)=n   100|23
    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len==1 || nums[0]>nums[1]){
            return 0;
        }
        if (nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                return i;
            }
        }
        return -1;
    }
}
