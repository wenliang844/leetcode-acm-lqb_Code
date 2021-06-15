package ACM.leecode周赛.第48场双周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/***
 给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。
 在第 i 次操作时（操作编号从 1 开始），你需要：
 选择两个元素 x 和 y 。
 获得分数 i * gcd(x, y) 。
 将 x 和 y 从 nums 中删除。
 请你返回 n 次操作后你能获得的分数和最大为多少。
 函数 gcd(x, y) 是 x 和 y 的最大公约数。


 示例 1：
 输入：nums = [1,2]
 输出：1
 解释：最优操作是：
 (1 * gcd(1, 2)) = 1
 */
public class lee_45695N次操作后的最大分数和_记忆化搜索 {

    public static int maxScore(int[] nums) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));

        int maxResult = 0;
        //List<Integer> list = new ArrayList<>();
        int a[] = new int[nums.length / 2];
        int index = 0;
        /*for (int i = nums.length-1; i >=nums.length/2; i--) {
            int temp = 0;//最大公约数
            for (int j = 0; j < nums.length/2; j++) {
                temp = Math.max(temp,calc(nums[i],nums[j]));
            }
            a[index]=temp;
            index++;
        }*/
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            list2.add(nums[i]);
        }
        for (int i = nums.length - 1; i >= nums.length / 2; i--) {
            list1.add(nums[i]);
        }
        System.out.println(list1);
        System.out.println(list2);


        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        index = a.length;
        int maxNum = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            maxNum += index * a[i];
            index--;
        }
        return maxNum;

    }

    public static int maxScore2(int[] nums) {
        Arrays.sort(nums);


        int maxNum = 0;
        int max = nums.length/2;

        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(nums[i]);
        }
        int step = list.get(1);
        System.out.println(list);

        while (!list.isEmpty() &&step>=1){
            int[] a = new int[2];
            int a1 = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)%step == 0){
                    a[a1] = i;
                    a1++;
                }
            }

            if (a[0]!=0 && a[1]!=0){
                maxNum = step * max;
                max--;

                System.out.println(list.get(a[0])+"-"+list.get(a[1]));
                list.remove(a[0]);
                list.remove(a[1]-1);
                System.out.println(list);
            }
            step--;

            if (step==1){
                maxNum += list.size()/2;
            }
        }


        return maxNum;

    }

    private static int calc(int num, int num1) {
        for (int i = num; i > 1; i--) {
            if (num % i == 0 && num1 % i == 0) {
                System.out.println(num + "--" + num1 + "--" + i);
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        //System.out.println(maxScore(new int[]{1,2,3,4,5,6}));
        System.out.println(maxScore2(new int[]{697035, 181412, 384958, 575458}));
    }
}
