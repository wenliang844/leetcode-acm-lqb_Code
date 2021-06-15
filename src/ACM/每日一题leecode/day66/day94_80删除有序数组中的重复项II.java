package ACM.每日一题leecode.day66;

import java.util.Arrays;

public class day94_80删除有序数组中的重复项II {
    /***
     给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    //方法一,扫描 指针 10 80
    public static int removeDuplicates(int[] nums) {

        int count = 0;
        int index = nums.length;
        System.out.println(nums[index-1]);
        //使用count计数,超过2个就进行和后面的交换
        for (int i = 1; i < index; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count >= 1) {
                    //后面的整体迁移,将i覆盖
                    for (int j = i + 1; j < index; j++) {
                        nums[j-1] = nums[j];

                    }

                    index--;//长度-1
                    i--;//移动完成以后,i需要--,当前的数字需要继续处理

                } else {
                    count++;
                }
            } else {
                count = 0;
            }
            System.out.println("第"+i+"次结果调整"+Arrays.toString(nums)+"$count="+count+"$inex="+index);

        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3, 3}));
    }
}
