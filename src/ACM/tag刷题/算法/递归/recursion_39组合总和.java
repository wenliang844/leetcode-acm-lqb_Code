package ACM.tag刷题.算法.递归;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class recursion_39组合总和 {

    /***
     给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     candidates 中的数字可以无限制重复被选取。
     说明：
     所有数字（包括 target）都是正整数。
     解集不能包含重复的组合。 
     示例 1：
     输入：candidates = [2,3,6,7], target = 7,
     所求解集为：
     [
     [7],
     [2,2,3]
     ]
     */

    //方法一:暴力递归:

    /***2 3 4 6   target=7
     在2 3 4 6里面选一个 <7,继续选  >7break   =7list.add(list)
     下一层 2 3 4 6
     也就是第一次选2 再选2 选2 选2
     回退到第三次选2 选3 合格list.add
     * @param candidates
     * @param target
     * @return
     */
    //递归:10 62
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(candidates, target, new ArrayList<Integer>(), list, 0,0);
        return list;
    }

    //有重复的情况,所以限制每次只能从我这里开始找,而不能找上面的数字,传递一个i进行限制
    public static void dfs(int[] candidates, int target, List<Integer> currentList, List<List<Integer>> allList, int sum,int index) {
        //判断当下的和是否==target7
        if (sum == target) {
            allList.add(currentList);
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(currentList);
            temp.add(candidates[i]);
            dfs(candidates, target, temp, allList, sum + candidates[i],i);
        }

    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 4, 6}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{1,6,3,4,7}, 7));
    }
}
