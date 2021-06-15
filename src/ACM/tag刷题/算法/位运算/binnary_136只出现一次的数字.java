package ACM.tag刷题.算法.位运算;

import java.util.HashMap;
import java.util.Map;

/***
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 说明：
 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 示例 1:
 输入: [2,2,1]
 输出: 1

 示例 2:
 输入: [4,1,2,1,2]
 输出: 4
 */
public class binnary_136只出现一次的数字 {

    //方法一：map计数 value=1的就是出现一次的数字 8 5
    public static int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();//数字,出现的次数
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer==null){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],integer+1);
            }
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1){
                return integer;
            }
        }
        return 0;
    }

    //方法二:全部位运算 异或一下就是那个数了 100 26
    public static int singleNumber2(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 2}));
        System.out.println(singleNumber2(new int[]{1, 2, 2}));
    }


}
