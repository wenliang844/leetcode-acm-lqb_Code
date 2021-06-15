package ACM.每日一题leecode.day32;

import java.util.Arrays;
import java.util.Map;

public class day47_628三个数的最大乘积 {

    public static void main(String[] args) {

        System.out.println("这是结果="+maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println("这是结果="+maximumProduct(new int[]{-1,-2,-3}));
        System.out.println("这是结果="+maximumProduct(new int[]{-100,-98,-1,2,3,4}));
        System.out.println("这是结果="+maximumProduct(new int[]{-8,-7,-2,10,20}));
    }


    //需要考虑负数的情况
    public static int maximumProduct(int[] nums) {

        System.out.println("排序前="+ Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("排序后="+Arrays.toString(nums));

        int len = nums.length;
        int sum1=nums[len-1] * nums[len-2]*nums[len-3];
        //int count=3;
        /*for (int i = nums.length-1; i >=0; i--) {
            sum1 *= nums[i];
            if (count==0){
                break;
            }
            count--;
        }*/
        int sum2 = nums[0]*nums[1]*nums[len-1];


        return Math.max(sum1,sum2);
    }
}
