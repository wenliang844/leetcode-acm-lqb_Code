package ACM.每日一题leecode.day32;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class day39_189旋转数组 {

    /***
     给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

     示例 1:

     输入: [1,2,3,4,5,6,7] 和 k = 3
     输出: [5,6,7,1,2,3,4]
     解释:
     向右旋转 1 步: [7,1,2,3,4,5,6]
     向右旋转 2 步: [6,7,1,2,3,4,5]
     向右旋转 3 步: [5,6,7,1,2,3,4]
     示例 2:

     输入: [-1,-100,3,99] 和 k = 2
     输出: [3,99,-1,-100]
     解释:
     向右旋转 1 步: [99,-1,-100,3]
     向右旋转 2 步: [3,99,-1,-100]

     尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     要求使用空间复杂度为 O(1) 的 原地 算法。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate3(nums, 3);
        System.out.println("旋转后" + Arrays.toString(nums));
    }

    //方法一:使用另一个数组   j=(i+k)%len
    public static void rotate(int[] nums, int k) {

        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }

        //System.out.println("转了"+Arrays.toString(temp));
        System.arraycopy(temp, 0, nums, 0, len);
        //System.out.println("赋值了"+Arrays.toString(temp));
    }

    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    //方法2:原地算法 用一个变量把nums[0]保存起来 从i=(len/k-1)*k+(len%k)开始 前进nums[(i+k)%len]=nums[i]
    //环状替换
    public static void rotate2(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    //方法三:翻转数组
    public static void rotate3(int[] nums, int k) {
        /***
         方法三：数组翻转
         该方法基于如下的事实：当我们将数组的元素向右移动 kk 次后，尾部 k\bmod nkmodn 个元素会移动至数组头部，其余元素向后移动 k\bmod nkmodn 个位置。

         该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k\bmod nkmodn 个元素就被移至数组头部，然后我们再翻转 [0, k\bmod n-1][0,kmodn−1] 区间的元素和 [k\bmod n, n-1][kmodn,n−1] 区间的元素即能得到最后的答案。

         我们以 n=7n=7，k=3k=3 为例进行如下展示：

         操作	结果
         原始数组	1~2~3~4~5~6~71 2 3 4 5 6 7
         翻转所有元素	7~6~5~4~3~2~17 6 5 4 3 2 1
         翻转 [0, k\bmod n - 1][0,kmodn−1] 区间的元素	5~6~7~4~3~2~15 6 7 4 3 2 1
         翻转 [k\bmod n, n - 1][kmodn,n−1] 区间的元素	5~6~7~1~2~3~45 6 7 1 2 3 4


         class Solution {
         public void rotate(int[] nums, int k) {
         k %= nums.length;
         reverse(nums, 0, nums.length - 1);
         reverse(nums, 0, k - 1);
         reverse(nums, k, nums.length - 1);
         }

         public void reverse(int[] nums, int start, int end) {
         while (start < end) {
         int temp = nums[start];
         nums[start] = nums[end];
         nums[end] = temp;
         start += 1;
         end -= 1;
         }
         }
         }
         */
        int len = nums.length;
        k=k%len;
        reverseArray(nums, 0, len - 1);
        //System.out.println("第1次翻转后" + Arrays.toString(nums));
        reverseArray(nums, 0, (k-1)%len);
        //System.out.println("第2次翻转后" + Arrays.toString(nums));
        reverseArray(nums, k%len, len - 1);
       // System.out.println("第3次翻转后" + Arrays.toString(nums));


    }

    public static void reverseArray(int[] nums, int i, int j) {
        while (i != j && i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}
