package ACM.每日一题leecode.day32;

import java.util.Arrays;

/***
 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。

 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

 如果有多个答案，你可以返回其中任何一个。保证答案存在。

  

 示例 1：

 输入：A = [1,1], B = [2,2]
 输出：[1,2]
 示例 2：

 输入：A = [1,2], B = [2,3]
 输出：[1,2]
 示例 3：

 输入：A = [2], B = [1,3]
 输出：[2,3]
 */
public class day61_888公平的糖果棒交换 {

    public static void main(String[] args) {

        System.out.println("这是结果=" + Arrays.toString(fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
        System.out.println("这是结果=" + Arrays.toString(fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
        System.out.println("这是结果=" + Arrays.toString(fairCandySwap(new int[]{2}, new int[]{1, 3})));
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0;
        for (int i = 0; i < A.length; i++) {
            sum1 += A[i];
        }

        int sum2 = 0;
        for (int i = 0; i < B.length; i++) {
            sum2 += B[i];
        }

        System.out.println("这是sum1=" + sum1 + "--sum2=" + sum2);

        //方案一:枚举: 相当于A + Bi的两倍     B+A[i]的两倍要相等即可
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (sum1 + (2 * B[j]) == sum2 + (2 * A[i])) {
                    int[] temp = new int[2];
                    temp[0] = A[i];
                    temp[1] = B[j];
                    return temp;
                }
            }
        }

        return null;
    }

}
