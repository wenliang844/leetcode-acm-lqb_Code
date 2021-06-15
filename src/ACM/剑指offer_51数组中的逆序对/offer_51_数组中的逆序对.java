package ACM.剑指offer_51数组中的逆序对;
/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

 

示例 1:

输入: [7,5,6,4]
输出: 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//O(nlogn)  O(n)
public class offer_51_数组中的逆序对 {
    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        System.out.println("==="+reversePairs(nums));
        System.out.println("==="+reversePairs2(nums));

        long start1 = System.currentTimeMillis();
        System.out.println("==="+reversePairs(JavaData.getData()));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

        long start2 = System.currentTimeMillis();
        System.out.println("==="+reversePairs2(JavaData.getData()));
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);
    }

    //暴力解法
    public static int reversePairs(int[] nums) {
        int count=0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    /*
    归并排序:解法:

     */
    public static int reversePairs2(int[] nums) {
        int len = nums.length;
        if (len <2){
            return 0;
        }
        int [] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i]=nums[i];
        }

        int[] temp = new int[len];//辅助数组
        return reversePairs2(copy,0,len-1,temp);
    }

    /**
     * nums[left,rightt] 计算逆序对个数并排序
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    public static int reversePairs2(int[] nums,int left,int right,int[] temp) {
        if (left == right){
            return 0;
        }
        //int mid = (left + right) / 2;//二分查找bug   整型溢出,做一个修改
        int mid =left + (right-left) / 2;//当做经验记住
        int leftPairs = reversePairs2(nums,left,mid,temp);
        int rightPairs = reversePairs2(nums,mid+1,right,temp);

        if (nums[mid]<=nums[mid+1]){//优化代码
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums,left,mid,right,temp);
        return leftPairs+rightPairs+crossPairs;

    }

    /**
     * 计算
     * 前提条件
     * nums[left,mid]有序  nums[mmid+1,right]有序
     * temp[]:使用一个临时数组:空间
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    public static int mergeAndCount(int[] nums,int left,int mid,int right,int[] temp){
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i=left;
        int j=mid+1;

        int count = 0;
        for (int k = left; k <=right ; k++) {
            if (i==mid+1){
                nums[k]=temp[j];
                j++;
            }else if (j == right+1){
                nums[k]=temp[i];
                i++;
            }else if (temp[i]<=temp[j]){//=归并就变成稳定的排序
                nums[k]=temp[i];
                i++;
            }else{
                nums[k]=temp[j];
                j++;
                count += (mid-i+1);
            }
        }
        return count;
    }

}
