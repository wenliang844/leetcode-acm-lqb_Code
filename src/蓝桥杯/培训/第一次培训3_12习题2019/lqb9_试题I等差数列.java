package 蓝桥杯.培训.第一次培训3_12习题2019;

import java.util.Arrays;
import java.util.Scanner;

public class lqb9_试题I等差数列 {

    /****
     数学老师给小明出了一道等差数列求和的题目。但是粗心的小明忘记了一
     部分的数列，只记得其中 N 个整数。
     现在给出这 N 个整数，小明想知道包含这 N 个整数的最短的等差数列有
     几项？
     【输入格式】
     输入的第一行包含一个整数 N。
     第二行包含 N 个整数 A1; A2; · · · ; AN。 (注意 A1 ∼ AN 并不一定是按等差数
     列中的顺序给出)
     【输出格式】
     输出一个整数表示答案。
     【样例输入】
     5
     2 6 4 10 20
     【样例输出】
     10
     【样例说明】
     包含 2、 6、 4、 10、 20 的最短的等差数列是 2、 4、 6、 8、 10、 12、 14、 16、
     18、 20
     */

    public static void test1(int N,int nums[]){
        /**
         思路:
         1.将差值最小的保存作为等差
         2.填充  直接排序,遍历每个元素
         */
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int minSub = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1] < minSub){
                minSub = nums[i]-nums[i-1];
            }
        }
        System.out.println(minSub);

        int count=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1] > minSub){
                count+= ((nums[i]-nums[i-1]) / minSub) - 1;
            }
        }
        System.out.println("这是count"+count);
        System.out.println("这是结果="+count+nums.length);

    }

    public static void test2(){
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int[] Ns=new int[N];
        for (int i = 0; i < Ns.length; i++) {
            Ns[i]=in.nextInt();
        }


        int max=Ns[0];//找到等差数列的最大值
        int min=Ns[0];//找到最小值   最大值-最小值   20-2 / 2  +1
        for (int i = 1; i < Ns.length; i++) {
            if(Ns[i]>max) {
                max=Ns[i];
            }
            if(Ns[i]<min) {
                min=Ns[i];
            }
        }
        System.out.println(max/min);
    }

    public static void main(String[] args) {
        test1(5,new int[]{2,6,4,10,20});
        test2();

    }

}
