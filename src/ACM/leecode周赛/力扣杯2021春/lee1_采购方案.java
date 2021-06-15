package ACM.leecode周赛.力扣杯2021春;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lee1_采购方案 {
    /***
     小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
     注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
     示例 1：
     输入：nums = [2,5,3,5], target = 6
     输出：1
     解释：预算内仅能购买 nums[0] 与 nums[2]。
     */
    public static int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;
        boolean canbuy = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (canbuy) {
                canbuy = false;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] <= target) {
                        canbuy = true;
                        count++;
                    }
                }
            }

        }

        return count % 1000000007;
    }

    //方法二:从后开始,直接count+= j-i
    //记得右移 left 指针，以及累加过程中求模。 88 47
    public static int purchasePlans2(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int limit = nums.length - 1;
        for (int i = 0; i < limit; i++) {
            for (int j = limit; j > i; j--) {
                if (nums[i] + nums[j] <= target) {
                    //System.out.println("count加的ij"+i+"-"+j);
                    count += (j - i);
                    limit = j;
                    break;
                }
            }
            count %= 1000000007;
        }

        return count % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(purchasePlans2(new int[]{2, 5, 3, 5}, 6));
        System.out.println(purchasePlans2(new int[]{2, 2, 1, 9}, 10));
        System.out.println(purchasePlans(new int[]{1,2,1,1,2,2,2,2,2,2,22,2,2,2,35,9,9,9}, 10));
        System.out.println(purchasePlans2(new int[]{1,2,1,1,2,2,2,2,2,2,22,2,2,2,35,9,9,9}, 10));

        System.out.println(purchasePlans(new int[]{5,5}, 10));
        System.out.println(purchasePlans2(new int[]{5,5}, 10));

        System.out.println(purchasePlans(new int[]{50,5,1,1,1}, 0));
        System.out.println(purchasePlans2(new int[]{50,5,1,1,1}, 0));


    }
}
