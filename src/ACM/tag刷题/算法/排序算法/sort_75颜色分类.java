package ACM.tag刷题.算法.排序算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sort_75颜色分类 {

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 示例 1：
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     */

    public static void swapTo(int[] nums, int i, int j) {
        int tmep = nums[i];
        nums[i] = nums[j];
        nums[j] = tmep;
    }

    //方法一:原地 交换   两轮:1.找到0交换前面的非0   2.找1 交换前面的非1   11 73
    public static void sortColors0(int[] nums) {
        //找0进行交换
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] != 0) {
                        swapTo(nums, i, j);
                        break;
                    }
                }
            }
        }
        //找1进行交换
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == 2) {
                        swapTo(nums, i, j);
                        break;
                    }
                }
            }
        }


    }

    //同时找两个 0和1
    public static void sortColors01(int[] nums) {
        //找0进行交换
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] != 0) {
                        swapTo(nums, i, j);
                        break;
                    }
                }
            }
            //找1进行交换
            if (nums[i] == 1) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == 2) {
                        swapTo(nums, i, j);
                        break;
                    }
                }
            }

        }

    }

    //直接sort
    public static void sortColors02(int[] nums) {
        Arrays.sort(nums);
    }

    //一趟,把0放前面,2放后面
    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] != 0) {
                        swapTo(nums, i, j);
                        break;
                    }
                }
            }

            if (nums[i] == 2) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] != 2) {
                        swapTo(nums, i, j);
                        i--;
                        break;
                    }
                }
            }
        }
    }

    //方法二:计数,替换这个数组 11 66
    public static void sortColors2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(nums[i]);
            if (integer == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], integer + 1);
            }

        }
        //System.out.println(map);
        int i = 0;
        int color0 = map.get(0) != null ? map.get(0) : 0;//有等于1的情况
        int color1 = map.get(1) != null ? map.get(1) : 0;
        int color2 = map.get(2) != null ? map.get(2) : 0;
        while (color0-- > 0) {
            nums[i] = 0;
            i++;
        }
        while (color1-- > 0) {
            nums[i] = 1;
            i++;
        }
        while (color2-- > 0) {
            nums[i] = 2;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(a);
        System.out.println(Arrays.toString(a));

        System.out.println("----------");
        int[] a1 = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(a1);
        System.out.println(Arrays.toString(a1));
    }
}
