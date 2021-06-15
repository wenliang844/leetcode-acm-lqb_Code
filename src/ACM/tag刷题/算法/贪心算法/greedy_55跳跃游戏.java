package ACM.tag刷题.算法.贪心算法;

public class greedy_55跳跃游戏 {

    /***
     给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     数组中的每个元素代表你在该位置可以跳跃的最大长度。
     判断你是否能够到达最后一个下标。
     示例 1：
     输入：nums = [2,3,1,1,4]
     输出：true
     解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     示例 2：
     输入：nums = [3,2,1,0,4]
     输出：false
     解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     */

    //方法一:贪心算法 存留一个maxLength 每次更新,当最大下标maxLength<=i 跳不过去了
    public static boolean canJump(int[] nums) {
        /*if (nums.length <=1 ){
            return true;
        }*/
        int maxLenght = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLenght<i){
                return false;
            }
            maxLenght=Math.max(i+nums[i],maxLenght);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{0,1}));//false
        System.out.println(canJump(new int[]{0,0}));
        System.out.println(canJump(new int[]{2,0,0}));
    }
}
