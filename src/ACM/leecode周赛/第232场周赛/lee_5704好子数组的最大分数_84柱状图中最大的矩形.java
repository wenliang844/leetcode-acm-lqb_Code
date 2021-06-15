package ACM.leecode周赛.第232场周赛;

import java.util.Stack;

public class lee_5704好子数组的最大分数_84柱状图中最大的矩形 {

    /***
     给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。

     一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。

     请你返回 好 子数组的最大可能 分数 。



     示例 1：

     输入：nums = [1,4,3,7,4,5], k = 3
     输出：15
     解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
     示例 2：

     输入：nums = [5,5,4,5,4,1,1,1], k = 0
     输出：20
     解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。

     */

    //方法1 暴力破解枚举  i j min maxResult=min()*多少个数--->超时
    public static int maximumScore(int[] nums, int k) {
        /**
         思路:固定min  比如min为1,
         双指针i j
         保存最小值minNUm
         保存最大分数maxScore
         */
        int maxScore = 0;
        for (int i = 0; i < nums.length; i++) {
            int minNum = nums[i];
            for (int j = i; j < nums.length; j++) {
                minNum = Math.min(minNum,nums[j]);
                if (i<=k && k<=j){
                    maxScore = Math.max(maxScore,minNum*(j-i+1));
                }
            }
        }



        return maxScore;
    }

    //使用滑动窗口 使用单调栈

    /*****
     使用单调栈：

     从左到右遍历，找到每个数右边第一个比它小的数的位置；
     从右到左遍历，找到每个数左边第一个比它小的数的位置。
     利用这两个值，可以得到以某一个数为最小值的最大区间范围。检查所有包含了kk位置的区间，就可以得到所要求的的最大分数。

     作者：吴自华
     链接：https://leetcode-cn.com/circle/discuss/VDhTB1/view/D9akdR/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int maximumScore2(int[] nums, int k) {
        /**
         思路:固定min  比如min为1,
         */
        int maxResult = 0;
        for (int i = 0; i < nums.length; i++) {
            int j1=i,j2=i;
            while (nums[j1]>=nums[i]){//找到每个数右边第一个比它小的数的位置；
                j1--;
            }
            while (nums[j2]>=nums[i]){//找到每个数右边第一个比它小的数的位置；
                j2++;
            }
            System.out.println(j1+"---"+j2);
            if (j1<=k && k<=j2){
//                maxResult = Math.max(maxResult,)
            }
        }


        return 0;
    }

    //优化双指针
    public static int maximumScore3(int[] nums, int k) {
        int area = 0;
        int h = nums[k];//先把h作为最小值
        int l=k,r=k;
        while (h>0){
            while (l>=0 && nums[l]>=h){
                --l;
            }
            while (r<nums.length && nums[r]>=h){
                ++r;
            }
            area = Math.max(area,h*(r-l+1));
            --h;
        }
        return area;//面积
    }

    /***
     初始指针 [公式] 都指向 [公式] ， [公式] 只能向右移动，
     [公式] 只能向左移动，我们发现每次移动指针不会使最小值mi变大，
     只会让区间长度加1，从而让答案更优。所以每次选 [公式]
     值大的那一侧移动指针，尽量让最小值mi大，这样一定能找到最优答案。
     */
    public static int maximumScore4(int[] nums, int k) {
        int mi = nums[k];
        int j = k-1;
        int i = k+1;
        int res = nums[k];
        while (i<=nums.length && j>=-1){
            if (j==-1){
                if (i==nums.length){
                    break;
                }
                mi = Math.min(mi,nums[i]);
                ++i;
            }else {
                if (i == nums.length || nums[j] > nums[i]) {
                    if (j == -1) {
                        break;
                    }
                    mi = Math.min(mi, nums[j]);
                    --j;
                } else {
                    mi = Math.min(mi, nums[i]);
                    ++i;
                }
            }
            res = Math.max(res,(i-j+1)*mi);
        }
        return res;
    }


    //84. 柱状图中最大的矩形 --官方题解改动

    /**
     求出 关于数据结构的例题:矩形的面积=底层高 固定高度,求最长底边
     遍历数组,向两边扩散 java通过,但是我的没通过,
     优化:空间换时间:
        动态规划
        将左边的小,右边的小,你就是确定了最大分数
        就是求一个单调栈
     last in
     first out lifo
     入栈不能确定
     出栈,当看到的元素小于栈中的元素高度,那么就可以出栈了. 下标可以直接获取高度 j-j+1   下标就是看到的  和栈顶元素   简单了
     遇到一样的高度,直接弹出不处理即可
     栈中存的是下标

     */
    public static int maximumScore5(int[] heights, int k) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if(right[i]>k&& left[i]<k)ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumScore5(new int[]{1, 4, 3, 7, 4, 5}, 3));

    }
}
