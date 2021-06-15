package ACM.每日一题leecode.day01;
/*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
通过次数264,706提交次数417,882
 */


import java.util.Scanner;

public class day01_leecode283_移动零 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        System.out.println(num);

        char[] chars = num.toCharArray();
        String s = new String(chars, 1, chars.length-1);
        String[] nums = s.split(",");
        System.out.println(nums.toString());

        StringBuilder count = new StringBuilder();
        for (String num1 : nums) {
            if (num1.equals("0")){
                count.append("0");
            }
        }
        String result = nums.toString().replace("0", "");
        System.out.println(result);
        System.out.println(result+""+count.toString());

    }
}
