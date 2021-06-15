package ACM.每日一题leecode.day100;

public class day140_477汉明距离总和 {
    /*****
     两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

     计算一个数组中，任意两个数之间汉明距离的总和。

     示例:

     输入: 4, 14, 2

     输出: 6

     解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
     所以答案为：
     HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     */
    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
    }

    //方法一:O2方法 双重循环 5 44
    public static int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                sum += hammingDistance3(nums[i],nums[j]);
            }
        }
        return sum;
    }

    public int totalHammingDistance2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

    //2.异或解法
    public static int hammingDistance2(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
        //统计0的个数  或者统计%2==0的个数 或统计能不能^1==1

    }

    //3.内置工具法  效率最高
    public static int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
