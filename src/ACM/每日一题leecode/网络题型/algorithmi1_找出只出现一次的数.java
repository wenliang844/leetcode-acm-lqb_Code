package ACM.每日一题leecode.网络题型;

/****
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：
 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 思路:位操作Bit Operation
 异或的特性:相同为0 相异为1
 时间线性 空间0

 map计数方法
 排序算法
 */
public class algorithmi1_找出只出现一次的数 {
    public static void main(String[] args) {
        System.out.println(getNum(new int[]{1, 1, 2, 2, 3, 3, 5, 5, 8, 8,9}));//9
        System.out.println(getNum(new int[]{2,2,1}));//1
        System.out.println(getNum(new int[]{4,1,2,1,2}));//4
    }

    static int getNum(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
