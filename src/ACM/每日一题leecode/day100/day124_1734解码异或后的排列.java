package ACM.每日一题leecode.day100;

import java.util.Arrays;

public class day124_1734解码异或后的排列 {
    /****
     你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
     它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
     给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
     示例 1：
     输入：encoded = [3,1]
     输出：[1,2,3]
     解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode2(new int[]{3, 1})));
        System.out.println(Arrays.toString(decode2(new int[]{6,5,4,6})));
        System.out.println(Arrays.toString(decode2(new int[]{2,6,3,4,6,4,15,1})));
        System.out.println(Arrays.toString(decode2(new int[]{12,6,11,10,5,3,4,6})));//[8,4,2,9,3,6,5,1,7]
    }

    //注意:所有数字在1-n中  超时
    public static int[] decode(int[] encoded) {
        //设第一个数是x:枚举第一个数

        int length = encoded.length;
        int[] ans = new int[length+1];
        for (int i = 1;; i++) {
            //只要有0就不行
            ans[0] = i;
            for (int j = 0; j < length; j++) {
                ans[j+1] = ans[j]^encoded[j];
                if (ans[j+1]==0 || ans[j+1]>length+1){
                    break;
                }
            }

            if (ans[length]!=0){
                return ans;
            }

        }

    }
    //注意:所有数字在1-n中   98/97
    public static int[] decode2(int[] encoded) {
        //1-n的数,直接把全部的n异或,再直接异或encoded的偶数得到ans[0]
        int len = encoded.length+1;
        int[] ans = new int[len];
        int sum = 1;
        for (int i = 2; i <= len; i++) {
            sum ^= i;
        }
        //sum再异或所有的encoded的偶数位
        for (int i = len-2; i >0; i-=2) {
            sum ^= encoded[i];
        }
        ans[0] = sum;

        for (int i = 0; i < len-1; i++) {
            ans[i+1] = ans[i]^encoded[i];
        }
       return ans;
    }
}
