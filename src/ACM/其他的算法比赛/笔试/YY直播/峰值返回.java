package ACM.其他的算法比赛.笔试.YY直播;

import java.util.ArrayList;
import java.util.Scanner;

public class 峰值返回 {
    public static void main(String[] args) {

    }

    /***
     思路:创建一个数组保存最大的数 一个min保存最小的数 第一个和最后一个特殊判断
     * @param nums
     * @return
     */
    public static ArrayList<Integer> getNums(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int maxTemp = Integer.MIN_VALUE;
        int len = nums.length;
        int max[] = new int[len];
        for (int i = len-1; i >=0 ; i++) {
            maxTemp = Math.max(maxTemp,nums[i]);
            max[i]=maxTemp;
        }

        //第一个
        if (nums[0]>max[1]){
            list.add(nums[0]);
        }

        //中间的
        for (int i = 1; i < len-1; i++) {
            min = Math.min(min,nums[i-1]);
            if (nums[i]<min && nums[i]>max[i+1]){
                list.add(nums[i]);
            }
        }
        min = Math.min(min,nums[len-2]);
        //第len-1个
        if (nums[len-1]>min){
            list.add(nums[len-1]);
        }
        return list;
    }
}
