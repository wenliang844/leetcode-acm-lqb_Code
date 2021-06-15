package ACM.tag刷题.算法.并查集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class uf_128最长连续序列 {

    /**
     * union fing set
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
     */

    //方法一:暴力破解
    //问题:重复值  11 54
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        // Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int[] numss = new int[set.size()];
        System.out.println(set);
        int ii = 0;
        for (Integer integer : set) {
            numss[ii] = integer;
            ii++;
        }
        System.out.println(Arrays.toString(numss));

        int step = 1;
        int maxLenght = 0;
        int i = 0, j = 1;
        while (i < numss.length && j < numss.length) {
            if (numss[i] + step == numss[j]) {
                j++;
                step++;
            } else {
                maxLenght = Math.max(maxLenght, j - i);
                i = j;
                j = i + 1;
                step = 1;
            }
        }
        maxLenght = Math.max(maxLenght, j - i);


        return maxLenght;
    }

    //方法二:一趟扫描 33 38
    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int count = 1;
        int maxCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
                continue;
            } else if (nums[i] > nums[i - 1]) {
                //清零
                maxCount = Math.max(maxCount, count);
                count = 1;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            }
        }
        maxCount = Math.max(maxCount, count);

        return maxCount;
    }

    //方法3:并查集:哈希表 +set去重  15 18
    public static int longestConsecutive3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set);

        int maxLength = 0;
        for (Integer integer: set) {
            if (!set.contains(integer - 1)){//如果含有integer-1,那么这个数不是罪低下的数
                int currentNum = integer;
                int currrentStreak = 1;
                while (set.contains(currentNum+1)){
                    currentNum += 1;
                    currrentStreak+=1;
                }
                maxLength = Math.max(maxLength,currrentStreak);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive2(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive2(new int[]{}));
        System.out.println(longestConsecutive2(new int[]{1, 2, 0, 1}));
    }
}
