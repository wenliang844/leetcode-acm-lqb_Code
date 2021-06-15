package ACM.每日一题leecode.day32;

public class day56_724寻找数组的中心索引 {

    /***
     给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。

     数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。

     如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。

     注意：中心索引可能出现在数组的两端。

      

     示例 1：

     输入：nums = [1, 7, 3, 6, 5, 6]
     输出：3
     解释：
     索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
     同时, 3 也是第一个符合要求的中心索引。
     示例 2：

     输入：nums = [1, 2, 3]
     输出：-1
     解释：
     数组中不存在满足此条件的中心索引。
     示例 3：

     输入：nums = [2, 1, -1]
     输出：0
     解释：
     索引 0 左侧不存在元素，视作和为 0 ；右侧数之和为 1 + (-1) = 0 ，二者相等。

     */
    public static void main(String[] args) {

        System.out.println("这是结果="+pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println("这是结果="+pivotIndex2(new int[]{}));
        System.out.println("这是结果="+pivotIndex2(new int[]{-1,-1,-1,-1,-1,0}));

    }

    public static int pivotIndex(int[] nums) {
        /**
         思路:将
         */
        if (nums.length==0){
            return -1;
        }


        //定义两个i j   进行
       int i=0;
       int j=nums.length-1;
       int leftSum=0;
       int rightSum=0;
       if (nums[i]>nums[j]){
           System.out.println("右收缩,这是="+j+"这是left"+leftSum+"这是right"+rightSum);
           rightSum=nums[j];
           j--;
       }else {
           System.out.println("左收缩,这是="+i+"这是left"+leftSum+"这是right"+rightSum);
           leftSum=nums[i];
           i++;
       }
       while (i!=j){
           if (leftSum<rightSum){
               System.out.println("左边收缩,这是="+i+"这是left"+leftSum+"这是right"+rightSum);
               leftSum+=nums[i];
               i++;
           }else {
               System.out.println("右边收缩,这是="+j+"这是left"+leftSum+"这是right"+rightSum);
               rightSum+=nums[j];
               j--;
           }
       }

        System.out.println(leftSum+"-"+rightSum+"-"+i+"-"+j);
       if(rightSum == leftSum){
           return i;
       }else {
           return -1;
       }
    }

    //优化:采用双端队列 扫描方法
    public static int pivotIndex2(int[] nums) {

        if (nums.length==0)return -1;
        int leftSum = 0;
        int rightSum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            rightSum+=nums[j];
        }

        rightSum = rightSum-nums[0];
        if (leftSum == rightSum){
            return 0;
        }
        i++;
        //从左向右扫描
        while (i<nums.length){
            leftSum+=nums[i-1];
            rightSum-=nums[i];
            if (leftSum == rightSum){
                return i;
            }else {
                i++;
            }
        }
        return -1;
    }


}
