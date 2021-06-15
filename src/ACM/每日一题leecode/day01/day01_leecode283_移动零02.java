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


/*



py:


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        for i in range(nums.count(0)):
            nums.remove(0)
            nums.append(0)
 */

import java.util.Scanner;

public class day01_leecode283_移动零02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums = sc.next();


        nums = nums.replace("[", "");
        nums = nums.replace("]", "");
        String[] split = nums.split(",");
//        for (String s : split) {
//            System.out.print(s);
//        }

        String temp;
//        int j=1;
        boolean flag = true;
//        System.out.println("-----------------------------------");
        for (int i = 0; i < split.length-1 && flag; i++) {

            if (split[i].equals("0")){
                flag = false;
                for (int j=i+1;j<split.length;j++){
                    if (!split[j].equals("0")){

//                        System.out.println(split[i]+"---"+split[j]+"------");
                        temp = split[i];
                        split[i] = split[j];
                        split[j]=temp;
                        flag=true;
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");


        for (String s : split) {
            sb.append(s);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb);

    }
}
