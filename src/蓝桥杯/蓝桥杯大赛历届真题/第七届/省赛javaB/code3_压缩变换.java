package 蓝桥杯.蓝桥杯大赛历届真题.第七届.省赛javaB;

import java.util.*;

public class code3_压缩变换 {
    /****
     压缩规则:遍历一维数组
     1.没出现过: 变相反数,用一个set存出现过的数字
     2.出现过:找倒过去第一个数,之间有几个数字,就是几   //暴力

     5
     1 2 2 1 2
     -1 -2 0 1 1       -------return

     12
     1 1 2 3 2 3 1 2 2 2 3 1
     -1 0 -2 -3 1 1 2 2 0 0 2 2  -----return
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//数字的个数
        int nums[] = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] newNums = new int[N];
        Set<Integer> set = new HashSet<>();//存储出现过的数字
        //在这个中,进行情况的遍历
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                //不存在这个数字
                set.add(num);
                newNums[i] = -num;
            } else {
                //已经存在了这个数字,找中间有多少重复值
                //先找到倒过去最近的一个相同值的index
                int index;
                Set<Integer> temp = new HashSet<>();//存储出现过的数字 计算几种数字
                for (index = i - 1; index >= 0; index--) {//可以直接在找的时候存入set,这样效率会高很多
                    if (nums[index] == nums[i]) {
                        break;
                    }else {
                        temp.add(nums[index]);
                    }
                }

                //从index - i map计数,nums[i]=map.size
                //Set<Integer> temp = new HashSet<>();//存储出现过的数字 计算几种数字
                /*for (int j = index + 1; j < i; j++) {
                    temp.add(nums[j]);
                }*/

                newNums[i] = temp.size();
            }

        }

        for (int i = 0; i < N-1; i++) {
            System.out.print(newNums[i]+" ");
        }
        System.out.println(newNums[N-1]);
    }
}
