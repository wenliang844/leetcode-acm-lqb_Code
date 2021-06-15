package ACM.每日一题leecode.自刷;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leeTension_16最接近的三数之和 {
    /***
     给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

     示例：
     输入：nums = [-1,2,1,-4], target = 1
     输出：2
     解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     */
    //方法一:暴力破解 不一定要相邻的
    public static int threeSumClosest(int[] nums, int target) {

        int res = 10000;
        for (int i = 0; i < nums.length-2; i++) {


            int sum = 0;
            for (int j = i; j < i+3; j++) {
                sum+=nums[j];
            }
            if (Math.abs(sum-target)<Math.abs(res-target)){
                res=sum;
            }
            //System.out.println("当前i="+i);
            //System.out.println("当前sum="+sum);
            //System.out.println("res="+res);
        }

        return res;
    }

    //暴力破解 3变量  5  93
    public static int threeSumClosest2(int[] nums, int target) {
        int res = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[k]+ nums[i]+nums[j];

                    if (Math.abs(res-target)>Math.abs(sum-target)){
                        res=sum;
                    }
                }
            }
        }

       return res;
    }
    //双指针:枚举第一个a 剩下的两个变量利用双指针+数组排序
    public static int threeSumClosest2_2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        //枚举a
        for (int i = 0; i < nums.length; i++) {
            //保证和上一次枚举的元素不相等
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //使用双指针枚举b,c
            int j=i+1;
            int k=n-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                //如果和为target直接返回答案
                if (sum == target){
                    return target;
                }
                //根据差值的绝对值更新答案
                if (Math.abs(sum-target) < Math.abs(best-target)){
                    best = sum;
                }
                //如果和是大于taeget的,移动相应的指针c
                if (sum>target){
                    int k0 = k-1;
                    //移动到下一个不相等的元素
                    while (j<k0 && nums[k0]==nums[k]){
                        --k0;
                    }
                    k=k0;
                }else {
                    //如果和小于taegett,移动b对应的指针
                    int j0=j+1;
                    //移动到下一个不相等的元素
                    while (j0<k && nums[j0]==nums[j]){
                        --j0;
                    }
                    j=j0;
                }
            }
        }
        return best;
    }
    //不相邻的解法:
    public static int threeSumClosest3(int[] nums, int target) {

        int p1 = nums[0];
        int p2 = nums[1];
        int p3 = nums[2];
        for (int i = 3; i < nums.length; i++) {

        }

        return 0;
    }

    //方法二:滑动窗口
    public static int threeSumClosest4(int[] nums, int target) {



        return 0;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest2(new int[]{-1,2,1,-4},1));//2
        System.out.println(threeSumClosest2(new int[]{1,1,1,0},-100));//2
        System.out.println(threeSumClosest2(new int[]{1,1,-1,-1,3},-1));//
        System.out.println(threeSumClosest2(new int[]{1,1,-1,-1,3},3));//3
    }
}
