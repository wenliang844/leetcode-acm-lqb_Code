package ACM.每日一题leecode.第二波.leetcode.day000;

/**
 * @author 陈文亮
 * @date 2022/12/17 22:09
 */
public class day024_1764通过连接另一个数组的子数组得到一个数组 {
    public static void main(String[] args) {

    }

    //暴力 nums需要全顺序包含groups
    public static boolean canChoose(int[][] groups, int[] nums) {

        int i = 0;
        int j = 0;
        while (i<groups.length && j<nums.length){
            if (!contains(nums,j,groups[i])){
                return false;
            }
        }
        return true;
    }

    private static boolean contains(int[] nums, int j, int[] group) {

        return false;
    }
}
