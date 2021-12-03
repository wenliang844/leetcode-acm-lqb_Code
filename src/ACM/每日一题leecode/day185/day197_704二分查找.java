package ACM.每日一题leecode.day185;

public class day197_704二分查找 {
    public static void main(String[] args) {
        System.out.println(search2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }


    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (left + right) / 2;
        if (target < mid) {
            search(nums, target, left, mid - 1);
        } else if (target > mid) {
            search(nums, target, mid + 1, right);
        } else {
            return mid;
        }
        return -1;
    }

    public static int search(int[] nums, int target, int left, int right) {

        int mid = (left + right) / 2;
        if (target < mid) {
            search(nums, target, left, mid - 1);
        } else if (target > mid) {
            search(nums, target, mid + 1, right);
        } else {
            return mid;
        }
        return -1;
    }

    //leetcode 100 49.9
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            // int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
