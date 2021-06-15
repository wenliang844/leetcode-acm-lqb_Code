package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day135_1707与数组中元素的最大异或值 {
    /***
     给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
     第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
     返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
     示例 1：
     输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
     输出：[3,3,7]
     解释：
     1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
     2) 1 XOR 2 = 3.
     3) 5 XOR 2 = 7.
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximizeXor2(new int[]{0, 1, 2, 3, 4}, new int[][]{{3, 1}, {1, 3}, {5, 6}})));
    }

    //方法一:暴力破解
    public static int[] maximizeXor(int[] nums, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int standNum = queries[i][0];//标准值
            int limitNum = queries[i][1];//变化值,最大值,<=才可以
            int max = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]<=limitNum){
                    max = Math.max(max,standNum^nums[j]);
                }
            }
            ans[i]=max;
        }

        return ans;
    }
    //方法二:优化
    //规律:一定是某个最大的数和一个数的异或
    //需要采用字典树算法,利用字典树需要01的特点,在每一行选择0,1相反的两个数即是最大值
    public static int[] maximizeXor2(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int standNum = queries[i][0];//标准值
            int limitNum = queries[i][1];//变化值,最大值,<=才可以
            int max = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]<=limitNum){
                    max = Math.max(max,standNum^nums[j]);
                }else{
                    break;
                }
            }
            ans[i]=max;
        }

        return ans;
    }
}
class Trie {
    // 左子树指向表示 0 的子节点
    Trie left = null;
    // 右子树指向表示 1 的子节点
    Trie right = null;
}
