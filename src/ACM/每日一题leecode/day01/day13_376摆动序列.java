package ACM.每日一题leecode.day01;

import java.util.ArrayList;
import java.util.List;

public class day13_376摆动序列 {

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 4, 9, 2, 5};
        System.out.println("最后的结果==========================================" + wiggleMaxLength2(nums1));

        int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println("最后的结果==========================================" + wiggleMaxLength2(nums2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("最后的结果==========================================" + wiggleMaxLength2(nums3));

        int[] nums4 = {};
        System.out.println("最后的结果==========================================" + wiggleMaxLength2(nums4));
        int[] nums5 = {84};
        System.out.println("最后的结果==========================================" + wiggleMaxLength2(nums5));
        int[] nums6 = {1, 1, 7, 4, 9, 2, 5};
        System.out.println("最后的结果==========================================" + wiggleMaxLength2(nums6));
        int[] nums7 = {3, 3, 3, 2, 5};
        System.out.println("最后的结果==========================================" + wiggleMaxLength2(nums7));


    }

    /*
    方法一:暴力搜索
    枚举所有序列;是摆动序列则返回 标记最大值 和最大值比较;
    不是摆动序列则break;
     */
    /*public static int wiggleMaxLength(int[] nums) {
        for (int i = 1; i <= nums.length; i++) { //长度
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < i + j; j++) { //初始值
                list.add(nums[j]);

            }
            for (int k = j; k < nums.length; k++) {

                list.add(nums[j]);
                for (int l = j; l < i + j && l < nums.length; l++) {
                    list.add(nums[l]);
                }
                System.out.println(list);
            }


        }
        return 0;
    }*/


    /*
    贪心算法:从第一个数字开始;不满足摆动数列则将后面的删除
     */
    public static int wiggleMaxLength2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int count = 1;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println("这是初始list===" + list);
        boolean da = false;
        for (int i = 1; i < nums.length; i++) {
            if (list.get(i) > list.get(i - 1)) {
                /*if (i%2==1)
                da = true;
                else
                    da=false;*/

                da = true;

                System.out.println("===" + i);
                break;
            } else if (list.get(i) < list.get(i - 1)) {
                da = false;
                break;
            }
        }

        if (da) {
            for (int i = 1; i < list.size(); i++) {
                if (i % 2 == 0) {
                    if (list.get(i) < list.get(i - 1)) {
                        count++;
                    } else {
                        System.out.println("remove-i=" + list.get(i));
                        list.remove(i);
                        i--;
                    }

                } else {
                    if (list.get(i) > list.get(i - 1)) {
                        count++;
                    } else {
                        System.out.println("remove-i=" + list.get(i));
                        list.remove(i);
                        i--;
                    }
                }
            }
        } else {
            System.out.println("小路线");
            for (int i = 1; i < list.size(); i++) {
                if (i % 2 == 0) {

                    if (list.get(i) > list.get(i - 1)) {
                        count++;
                    } else {
                        System.out.println("remove-i=" + list.get(i));
                        list.remove(i);
                        i--;
                    }

                } else {
                    if (list.get(i) < list.get(i - 1)) {
                        count++;
                    } else {
                        System.out.println("remove-i=" + list.get(i));
                        list.remove(i);
                        i--;
                    }
                }
            }
        }
        System.out.println("这是后面的list==" + list);


        return count;
    }

    /*
    动态规划
    贪心算法
    计算up
    down方法;
    假设
    方程:up = down+1   --当nums[i]>num[i-1]
        down = up+1
     */

    /**
     * 思路
     * 本题大家都很容易想到用动态规划来求解，求解的过程类似最长上升子序列，不过是需要判断两个序列。大家在实现动态规划的平方复杂度时，就会考虑如何优化到线性复杂度。
     * <p>
     * 假设 up[i] 表示 nums[0:i] 中最后两个数字递增的最长摆动序列长度，down[i] 表示 nums[0:i] 中最后两个数字递减的最长摆动序列长度，只有一个数字时默认为 1。
     * <p>
     * 接下来我们进行分类讨论：
     * <p>
     * nums[i+1] > nums[i]
     * 假设 down[i] 表示的最长摆动序列的最远末尾元素下标正好为 i，遇到新的上升元素后，up[i+1] = down[i] + 1 ，这是因为 up 一定从 down 中产生（初始除外），并且 down[i] 此时最大。
     * 假设 down[i] 表示的最长摆动序列的最远末尾元素下标小于 i，设为 j，那么 nums[j:i] 一定是递增的，因为若完全递减，最远元素下标等于 i，若波动，那么 down[i] > down[j]。由于 nums[j:i] 递增，down[j:i] 一直等于 down[j] ，依然满足 up[i+1] = down[i] + 1 。
     * nums[i+1] < nums[i]，类似第一种情况
     * nums[i+1] == nums[i]，新的元素不能用于任何序列，保持不变
     * 演示
     * nums=[1,7,4,9,2,5] 时，演示如下：
     * <p>
     * 怎么样，是不是清晰易懂呀～
     * <p>
     * 注意到 down 和 up 只和前一个状态有关，所以我们可以优化存储，分别用一个变量即可。
     * <p>
     * 作者：lgh18
     * 链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/tan-xin-si-lu-qing-xi-er-zheng-que-de-ti-jie-by-lg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int wiggleMaxLength3(int[] nums) {
        int upNum = 1;//初始值
        int downNum = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                upNum = downNum + 1;
            }
            if (nums[i] < nums[i - 1]) {
                downNum = upNum + 1;
            }

        }

        return nums.length == 0 ? 0 : Math.max(upNum, downNum);
    }

    /*
    方法一：动态规划
思路及解法

每当我们选择一个元素作为摆动序列的一部分时，这个元素要么是上升的，要么是下降的，这取决于前一个元素的大小。那么列出状态表达式为：

\textit{up}[i]up[i] 表示以前 ii 个元素中的某一个为结尾的最长的「上升摆动序列」的长度。

\textit{down}[i]down[i] 表示以前 ii 个元素中的某一个为结尾的最长的「下降摆动序列」的长度。

下面以 \textit{up}[i]up[i] 为例，说明其状态转移规则：

当 \textit{nums}[i] \leq \textit{nums}[i - 1]nums[i]≤nums[i−1] 时，我们无法选出更长的「上升摆动序列」的方案。因为对于任何以 \textit{nums}[i]nums[i] 结尾的「上升摆动序列」，我们都可以将 \textit{nums}[i]nums[i] 替换为 \textit{nums}[i - 1]nums[i−1]，使其成为以 \textit{nums}[i - 1]nums[i−1] 结尾的「上升摆动序列」。

当 \textit{nums}[i] > \textit{nums}[i - 1]nums[i]>nums[i−1] 时，我们既可以从 up[i - 1]up[i−1] 进行转移，也可以从 \textit{down}[i - 1]down[i−1] 进行转移。下面我们证明从 \textit{down}[i - 1]down[i−1] 转移是必然合法的，即必然存在一个 \textit{down}[i - 1]down[i−1] 对应的最长的「下降摆动序列」的末尾元素小于 \textit{nums}[i]nums[i]。

我们记这个末尾元素在原序列中的下标为 jj，假设从 jj 往前的第一个「谷」为 \textit{nums}[k]nums[k]，我们总可以让 jj 移动到 kk，使得这个最长的「下降摆动序列」的末尾元素为「谷」。

然后我们可以证明在这个末尾元素为「谷」的情况下，这个末尾元素必然是从 \textit{nums}[i]nums[i] 往前的第一个「谷」。证明非常简单，我们使用反证法，如果这个末尾元素不是从 \textit{nums}[i]nums[i] 往前的第一个「谷」，那么我们总可以在末尾元素和 \textit{nums}[i]nums[i] 之间取得一对「峰」与「谷」，接在这个「下降摆动序列」后，使其更长。

这样我们知道必然存在一个 \textit{down}[i - 1]down[i−1] 对应的最长的「下降摆动序列」的末尾元素为 \textit{nums}[i]nums[i] 往前的第一个「谷」。这个「谷」必然小于 \textit{nums}[i]nums[i]。证毕。

这样我们可以用同样的方法说明 \textit{down}[i]down[i] 的状态转移规则，最终的状态转移方程为：

\begin{aligned} &\textit{up}[i]= \begin{cases} \textit{up}[i - 1],& \textit{nums}[i] \leq \textit{nums}[i - 1] \\ \max(\textit{up}[i - 1], \textit{down}[i - 1] + 1),& \textit{nums}[i] > \textit{nums}[i - 1] \end{cases} \\\\ &\textit{down}[i]= \begin{cases} \textit{down}[i - 1],& \textit{nums}[i] \geq \textit{nums}[i - 1] \\ \max(\textit{up}[i - 1] + 1, \textit{down}[i - 1]),& \textit{nums}[i] < \textit{nums}[i - 1] \end{cases} \end{aligned}
​

up[i]={
up[i−1],
max(up[i−1],down[i−1]+1),
​

nums[i]≤nums[i−1]
nums[i]>nums[i−1]
​

down[i]={
down[i−1],
max(up[i−1]+1,down[i−1]),
​

nums[i]≥nums[i−1]
nums[i]<nums[i−1]
​

​


最终的答案即为 \textit{up}[n-1]up[n−1] 和 \textit{down}[n-1]down[n−1] 中的较大值，其中 nn 是序列的长度。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode-solution-yh2m/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    /*
    方法三：贪心
思路及解法

观察这个序列可以发现，我们不断地交错选择「峰」与「谷」，可以使得该序列尽可能长。证明非常简单：如果我们选择了一个「过渡元素」，那么在原序列中，这个「过渡元素」的两侧有一个「峰」和一个「谷」。不失一般性，我们假设在原序列中的出现顺序为「峰」「过渡元素」「谷」。如果「过渡元素」在选择的序列中小于其两侧的元素，那么「谷」一定没有在选择的序列中出现，我们可以将「过渡元素」替换成「谷」；同理，如果「过渡元素」在选择的序列中大于其两侧的元素，那么「峰」一定没有在选择的序列中出现，我们可以将「过渡元素」替换成「峰」。这样一来，我们总可以将任意满足要求的序列中的所有「过渡元素」替换成「峰」或「谷」。并且由于我们不断地交错选择「峰」与「谷」的方法就可以满足要求，因此这种选择方法就一定可以达到可选元素数量的最大值。

这样，我们只需要统计该序列中「峰」与「谷」的数量即可（注意序列两端的数也是「峰」或「谷」），但需要注意处理相邻的相同元素。

在实际代码中，我们记录当前序列的上升下降趋势。每次加入一个新元素时，用新的上升下降趋势与之前对比，如果出现了「峰」或「谷」，答案加一，并更新当前序列的上升下降趋势。

代码

C++JavaJavaScriptPython3GolangC

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode-solution-yh2m/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
