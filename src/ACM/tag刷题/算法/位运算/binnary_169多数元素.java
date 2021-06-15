package ACM.tag刷题.算法.位运算;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 示例 1：
 输入：[3,2,3]
 输出：3
 示例 2：

 输入：[2,2,1,1,1,2,2]
 输出：2
 */
public class binnary_169多数元素 {

    //方法一:计数 25 10
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer != null) {
                map.put(nums[i], integer + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) > nums.length / 2) {
                return integer;
            }
        }
        return 0;
    }

    //方法二:位运算

    /**
     * 摩尔投票法：
     * 核心就是对拼消耗。
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
     * 那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
     * 最后能剩下的必定是自己人。
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        //只要有不一样的数,就抵消掉
        //转list?

        return 0;
    }

    //从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，  减到0就重新换个数开始计数,总能找到最多的那个
    public static int majorityElement4(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }

    //方法二:排序后找中位数 67 94
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement3(new int[]{1, 1, 2, 2, 3, 3, 3, 3, 3, 3}));
    }
}
