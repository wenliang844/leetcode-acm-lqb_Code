package ACM.leecode周赛.第233场周赛;

public class lee1_5709最大升序子数组和 {

    /****
     给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
     子数组是数组中的一个连续数字序列。
     已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），
     numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。

     示例 1：
     输入：nums = [10,20,30,5,10,50]
     输出：65
     解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
     */

    public static int maxAscendingSum(int[] nums) {

        int i=0;
        int j=1;
        int temp=nums[0];

        int maxNum=0;
        for (int k = 0; k < nums.length; k++) {
            maxNum = Math.max(maxNum,nums[k]);
        }
        while (j<nums.length){


            if (nums[j]>nums[j-1]){
                temp += nums[j];
                j++;
            }else{
                i=j;
                j++;
                maxNum = Math.max(maxNum,temp);
                temp = nums[i];
            }

            maxNum = Math.max(maxNum,temp);
            //System.out.println("这是maaxNum="+maxNum+"这是temp="+temp+"这是j"+j);
        }


        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50}));
    }
}
