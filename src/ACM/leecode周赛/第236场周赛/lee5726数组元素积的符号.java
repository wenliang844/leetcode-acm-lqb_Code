package ACM.leecode周赛.第236场周赛;

public class lee5726数组元素积的符号 {
    /***
     已知函数 signFunc(x) 将会根据 x 的正负返回特定值：

     如果 x 是正数，返回 1 。
     如果 x 是负数，返回 -1 。
     如果 x 是等于 0 ，返回 0 。
     给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
     返回 signFunc(product) 。
     */
    public static int signFunc(int x) {
        if (x>0)return 1;
        if (x<0)return -1;
        return 0;
    }
    public static int arraySign(int[] nums) {
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            ans *= signFunc(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
