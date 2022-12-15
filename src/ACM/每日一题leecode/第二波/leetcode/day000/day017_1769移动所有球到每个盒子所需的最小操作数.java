package ACM.每日一题leecode.第二波.leetcode.day000;

import java.util.Arrays;

/**
 * @author 陈文亮
 * @date 2022/12/2 09:55
 */
public class day017_1769移动所有球到每个盒子所需的最小操作数 {
    /*
    输入：boxes = "110"
    输出：[1,1,3]

    110
    0   1

11011
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations2("110")));
    }

    //方法一：暴力解法   31%
    public static int[] minOperations(String boxes) {

        int length = boxes.length();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp += (i - j) * (boxes.charAt(j) - 48);
            }
            for (int j = i + 1; j < length; j++) {
                temp += (j - i) * (boxes.charAt(j) - 48);
            }
            res[i] = temp;
        }

        return res;
    }

    //方法二:空间换时间  82%
    public static int[] minOperations2(String boxes) {

        int length = boxes.length();
        int[] res = new int[length];
        int left = 0;
        int right = 0;
        int leftTotal = 0;
        int rightTotal = 0;
        if (boxes.charAt(0) == '1') {
            left = 1;
            leftTotal = 1;
        }
        for (int i = 1; i < length; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                res[0] += (i - 0) * (boxes.charAt(i) - '0');
            }
        }
        rightTotal = res[0];

        //110   left=1,1  right=1,1
        for (int i = 1; i < length; i++) {
            res[i] += leftTotal;
            if (boxes.charAt(i) == '1') {
               left++;
               leftTotal+=left;
               rightTotal-=right;
               right--;
            }else {
                leftTotal+=left;
                rightTotal-=right;
            }
            res[i] += rightTotal;
        }

        return res;
    }
}
