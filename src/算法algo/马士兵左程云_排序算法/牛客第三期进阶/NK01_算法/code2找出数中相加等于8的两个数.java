package 算法algo.马士兵左程云_排序算法.牛客第三期进阶.NK01_算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class code2找出数中相加等于8的两个数 {

    //方法1,枚举
    public static void equal8_1(int[] nums) {
        //排序
        Arrays.sort(nums);
        //双重循环 输出 退出
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 8) {
                    System.out.println(i + "--" + j);
                    //break;
                }
            }
        }
    }

    //方法2:哈希表
    public static void equal8_2(int[] nums) {
        /** 123 57 9
         a + b = 8;
         数字--:>序号
         map<1 0>
         map 7 7
         map 3 2
         map 5 3
         O(n)
         */
        Map<Integer, Integer> map = new HashMap<>();
        /*for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        System.out.println(map);
        for (Integer integer : map.keySet()) {
            if (map.get(8 - integer)!=null){
                System.out.println(map.get(integer)+"<--->"+map.get(8-integer));
            }
        }*/

        //map的查 放 删都是O(1)
        //遍历到5的时候 查询有没有3的存在 一趟解决
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.get(8 - nums[i]) != null) {
                System.out.println(i + "===---===" + map.get(8 - nums[i]));
            }
        }
    }

    // 双指针 l r 向中间逼近
    public static void equal8_3(int[] nums) {
        Arrays.sort(nums);//有序
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > 8) {
                r--;
            } else if (nums[l] + nums[r] < 8) {
                l++;
            } else {
                System.out.println(l + "+++" + r);
                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) {
        //question1 输出相加等于8的下标
        equal8_3(new int[]{1, 2, 3,4, 5, 7, 9});

        //question2 输出相加等于8的两个数
        //双指针,排序后两边比较   指针输出的对,一直往下直到不是前一个数(判断和前面的一个数一样不一样),就输出的是唯一的


    }
}
