package ACM.leecode周赛.lee第222场周赛;

import java.util.Arrays;

public class lee_5643将数组分成三个子数组的方案数 {

    /****
     我们称一个分割整数数组的方案是 好的 ，当它满足：

     数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
     left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
     给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。



     示例 1：

     输入：nums = [1,1,1]
     输出：1
     解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。
     示例 2：

     输入：nums = [1,2,2,2,5,0]
     输出：3
     解释：nums 总共有 3 种好的分割方案：
     [1] [2] [2,2,5,0]
     [1] [2,2] [2,5,0]
     [1,2] [2,2] [5,0]
     示例 3：

     输入：nums = [3,2,1]
     输出：0
     解释：没有好的分割方案。
     */
    public static void main(String[] args) {
        System.out.println("这是结果=" + waysToSplit(new int[]{1,1,1}));
        System.out.println("这是结果=" + waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
        System.out.println("这是结果=" + waysToSplit(new int[]{3,2,1}));
    }

    //暴力破解  48 / 87 个通过测试用例


    public static int waysToSplit(int[] nums) {

        int count = 0;
        //for (int i = 0; i < nums.length - 2; i++) {
        //int i = 0;
        for (int j = 1; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (isOk(nums, j, k)) {
                    System.out.println(nums[j] + "-" + nums[k]);
                    count++;
                }
            }
        }
        //}


        return count;
    }

    public static boolean isOk(int[] nums, int left, int mid) {
        if (sum(nums, 0, left) <= sum(nums, left, mid) && sum(nums, left, mid) <= sum(nums, mid, nums.length)) {
            return true;
        }
        return false;
    }

    public static int sum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k < j; k++) {
            sum += nums[k];
        }

        return sum;
    }

    /***
     题目3：5643. 将数组分成三个子数组的方案数
     思路：前缀和 + 二分
     根据题意，需要用到某段区间内的元素和，所以提前维护一个前缀和数组 vv ，v[i]v[i] 记录给定数组中 [0, i - 1][0,i−1] 区间的元素和（其中 i = 1, 2, ..., ni=1,2,...,n）。
     遍历 nn 个位置，将位置 ii 作为 leftleft 和 midmid 子数组的分界线，二分查找 midmid 和 rightright 的分界线范围。
     假设分界线范围为 [x, y][x,y]，则 xx 位置需满足的条件是 v[x]v[x] - v[i] >= v[i]v[i]>=v[i]，此时才能满足 left < midleft<mid，同理 yy 位置需满足的条件是 v[n]v[n] - v[y] >= v[y]v[y]>=v[y] - v[i]v[i]，这样才能满足 mid < rightmid<right。求出 x, yx,y 后，这段区间内的任一位置都能作为 midmid 和 rightright 的分界线。
     代码：

     class Solution {
     public:
     int waysToSplit(vector<int>& a) {
     int n = a.size();
     vector<int> v(n + 1, 0);
     // 初始化前缀和数组
     for(int i = 1; i <= n; i++) {
     v[i] = v[i - 1] + a[i - 1];
     }
     // 返回值 ret
     long long ret = 0;
     const int M = 1e9 + 7;

     for(int i = 1; i < n; i++) {
     // 特判
     if(v[i] * 3 > v[n]) break;

     // 第一次二分找右边界
     int l = i + 1, r = n - 1;
     while(l <= r) {
     int mid = (l + r) / 2;
     if(v[n] - v[mid] < v[mid] - v[i]) {
     r = mid - 1;
     } else {
     l = mid + 1;
     }
     }

     // 第二次二分找左边界
     int ll = i + 1, rr = n - 1;
     while(ll <= rr) {
     int mid = (ll + rr) / 2;
     if(v[mid] - v[i] < v[i]) {
     ll = mid + 1;
     } else {
     rr = mid - 1;
     }
     }
     ret += l - ll;
     }
     return ret % M;
     }
     };
     复杂度分析：
     时间复杂度为 O(nlgn)O(nlgn)，遍历 leftleft 和 midmid 边界复杂度 O(n)O(n)，两次二分复杂度 O(lgn)O(lgn)

     空间复杂度为 O(n)O(n)，维护了前缀和数组

     作者：bndsbilly
     链接：https://leetcode-cn.com/problems/ways-to-split-array-into-three-subarrays/solution/c-qian-zhui-he-er-fen-sou-suo-by-bndsbil-ida2/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */


}
