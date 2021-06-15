package ACM.leecode周赛.第233场周赛;

/***
 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[j]) <= high 。



 示例 1：

 输入：nums = [1,4,2,7], low = 2, high = 6
 输出：6
 解释：所有漂亮数对 (i, j) 列出如下：
 - (0, 1): nums[0] XOR nums[1] = 5
 - (0, 2): nums[0] XOR nums[2] = 3
 - (0, 3): nums[0] XOR nums[3] = 6
 - (1, 2): nums[1] XOR nums[2] = 6
 - (1, 3): nums[1] XOR nums[3] = 3
 - (2, 3): nums[2] XOR nums[3] = 5
 */
public class lee4_5696统计异或值在范围内的数对有多少_01字典树 {

    //方法一:暴力破解  ->超时
    public static int countPairs(int[] nums, int low, int high) {

        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int temp = nums[i] ^ nums[j];
                //System.out.println(temp);
                if (temp<=high && temp>=low){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1,4,2,7},2,6));
    }
}
