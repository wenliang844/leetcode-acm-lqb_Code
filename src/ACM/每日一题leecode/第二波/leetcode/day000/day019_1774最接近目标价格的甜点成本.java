package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/4 15:17
 */
public class day019_1774最接近目标价格的甜点成本 {
    public static void main(String[] args) {
        //baseCosts = [1,7], toppingCosts = [3,4], target = 10
        System.out.println(closestCost(new int[]{1, 7}, new int[]{3, 4}, 10));
    }

    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < baseCosts.length; i++) {
            int total = baseCosts[i];
            if (Math.abs(target - total) < Math.abs(target - res) || (Math.abs(target - total) == Math.abs(target - res) && total < res)) {
                res = total;
            }
            for (int j = 0; j < toppingCosts.length; j++) {
                total+=toppingCosts[i];
                if (Math.abs(target - total) < Math.abs(target - res) || (Math.abs(target - total) == Math.abs(target - res) && total < res)) {
                    res = total;
                }
            }
        }
        return res;
    }
}
