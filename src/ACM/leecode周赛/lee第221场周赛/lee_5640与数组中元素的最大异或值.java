package ACM.leecode周赛.lee第221场周赛;


import java.lang.reflect.Array;
import java.util.Arrays;

/***
 *
 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。

 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。

 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。



 示例 1：

 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 输出：[3,3,7]
 解释：
 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 2) 1 XOR 2 = 3.
 3) 5 XOR 2 = 7.
 示例 2：

 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 输出：[15,-1,5]
 */
public class lee_5640与数组中元素的最大异或值 {

    public static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] xors = maximizeXor2(new int[]{0, 1, 2, 3, 4}, new int[][]{{3, 1}, {1, 3}, {5, 6}});
        int[] xors2 = maximizeXor2(new int[]{5, 2, 4, 6, 6, 3}, new int[][]{{12, 4}, {8, 1}, {6, 3}});
        printNums(xors);
        printNums(xors2);
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {

        /***
         3、位异或运算（^）
         运算规则：两个数转为二进制，然后从高位开始比较，如果相同则为0，不同则为1.
         例如：8^11
         8转二进制是1000，而11转二进制是1011，从高位开始比较得到的是：0011.
         然后二进制转十进制，就是Integer.parseInt(“0011”,2)=3;

         示例 1：
         输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
         输出：[3,3,7]
         解释：
         1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
         2) 1 XOR 2 = 3.
         3) 5 XOR 2 = 7.
         */

        /***
         思路:
         1.遍历查询数组,quuery[xi][ji]   再遍历nums[k]中小于query[xi][1]的值 nums[k]和query[xi][0]异或.取最大值  作为答案
         */

        int[] answers = new int[queries.length];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = -1;
        }

        for (int i = 0; i < queries.length; i++) {
            int xi = queries[i][0];//需要进行xor的
            int ji = queries[i][1];//num要比ji小的限制条件
            //System.out.println("开始搜索第"+i+"个answer[->]"+i+"---------------------------"+xi+"限制大小的ji:"+ji);
            int maxNum = -1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= ji) {
                    //让xi和nums[i]做一次异或 xor
                    int xorNum = xor(nums[j], xi);
                    maxNum = xorNum > maxNum ? xorNum : maxNum;
                }
            }
            answers[i] = maxNum;
        }

        return answers;
    }

    public static int[] maximizeXor2(int[] nums, int[][] queries) {
        int[] answers = new int[queries.length];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = -1;
        }

        for (int i = 0; i < queries.length; i++) {
            int xi = queries[i][0];//需要进行xor的
            int ji = queries[i][1];//num要比ji小的限制条件
            System.out.println("开始搜索第"+i+"个answer[->]"+i+"---------------------------"+xi+"限制大小的ji:"+ji);
            int maxNum=-1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= ji) {
                    //让xi和nums[i]做一次异或 xor
                    int xorNum = nums[j]^xi;
                    maxNum = xorNum>maxNum?xorNum:maxNum;
                }
            }
            answers[i]=maxNum;
        }

        return answers;
    }

    /***
     优化:java异或 ^ 的使用  按位计算  相同则为0  不同则为1
     * @param a
     * @param b
     * @return
     */
    public static int xor(int a, int b) {
        int num = a^b;
        return num;
    }

    public static int xor2(int a, int b) {
        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);


        int len = a1.length() < b1.length() ? a1.length() : b1.length();
        char[] ss = a1.length() > b1.length() ? a1.toCharArray() : b1.toCharArray();
        //System.out.println(len + "--" + Arrays.toString(ss));
        int k1 = a1.length() - 1;//维持a1的变量
        int k2 = b1.length() - 1;//维持b1的变量
        int maxlen = ss.length - 1;//维持ss的变量   修改数组   都指向最后一个元素
        for (int i = len - 1; i >= 0; i--) {

            //if (i >= len) break;
            if (a1.charAt(k1) == b1.charAt(k2)) {
                ss[maxlen] = '0';
            } else {
                ss[maxlen] = '1';
            }
            k1--;
            k2--;
            maxlen--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            //System.out.println("=========" + ss[i]);
            sb.append(ss[i]);
        }

        int num = Integer.parseInt(sb.toString(), 2);
        //System.out.println("这是二进制的" + a + "-" + b + "<===>" + a1 + "-" + b1 + "---" + sb.toString()+"--"+num);

        return num;
    }
}
