package ACM.tag刷题.算法.位运算;

import java.util.ArrayList;
import java.util.List;

public class binnary_78子集 {

    /***
     给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     示例 1：
     输入：nums = [1,2,3]
     输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

     示例 2：
     输入：nums = [0]
     输出：[[],[0]]
     */

    /***
     位运算: & | ^ ~ >>右移/2 <<左移*2

     */
    /***
     思路:从前开始遍历,遇到一个数就把这个数 和之前的子集进行合并加进去
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(nums[0]);
        list.add(list1);
        for (int i = 1; i < nums.length; i++) {

            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> integers : list) {
                List<Integer> l1 = new ArrayList<>();
                l1.addAll(integers);
                l1.add(nums[i]);
               tmp.add(l1);
            }
            list.addAll(tmp);

            List<Integer> list2 = new ArrayList<>();
            list2.add(nums[i]);
            list.add(list2);
        }

        list.add(new ArrayList<>());
        return list;
    }

    /***
     方法二
     用二进制标志状态
     000 表示123 都不在子集中
     001 3 表示3在自己中
     011 23
     111 123
     100 1
     110 12
     .............
     方法三:递归实现:
     我们也可以用递归来实现子集枚举。

     假设我们需要找到一个长度为 nn 的序列 aa 的所有子序列，代码框架是这样的：
     vector<int> t;
     void dfs(int cur, int n) {
     if (cur == n) {
     // 记录答案
     // ...
     return;
     }
     // 考虑选择当前位置
     t.push_back(cur);
     dfs(cur + 1, n, k);
     t.pop_back();
     // 考虑不选择当前位置
     dfs(cur + 1, n, k);
     }
     */

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));

    }
}
