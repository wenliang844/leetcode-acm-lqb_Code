package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈文亮
 * @date 2022/10/8 09:49
 */
public class day014_870优势洗牌 {
    /*
    给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。

    返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。

     

    示例 1：

    输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
    输出：[2,11,7,15]
    示例 2：

    输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
    输出：[24,32,8,12]
     

    提示：

    1 <= nums1.length <= 105
    nums2.length == nums1.length
    0 <= nums1[i], nums2[i] <= 109
     */
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11})));
        //24,32,8,12
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i],i);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int[] res = new int[nums1.length];
        int maxIndex = nums2.length-1;
        int minIndex = 0;
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums1[i]>nums2[index]){
                res[minIndex++] = nums1[index];
                index++;
            }else {
                res[maxIndex--]=nums1[index];
            }
        }

        return res;
    }
}
