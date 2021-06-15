package ACM.tag刷题.数据结构.栈;

import java.util.Stack;

/***
 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 输出：6
 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 示例 2：

 输入：height = [4,2,0,3,2,5]
 输出：9
 */
public class stack_42接雨水_面试题17_21直方图的水量 {

    /***
     思路：栈
     1.找打最高的,下一个低,计算面积一次
     计算完了,这个最高的入栈,  如果是左边的最高,需要填充之间的数为次高
     继续找一个最高的来计算

     调试边界条件:
     1.当左边的数等于右边的数符合条件也进行计算
     2.升序的话,就是第一次没找到一个符合条件的数入栈,stack.len = 0直接返回0
     3.

     */
    //栈 10 60
    public static int trap(int[] height) {
        if (height.length <= 2){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int i;
        for (i = 0; i < height.length-1; i++) {
            if (height[i] > height[i + 1]) {//第一个最大值,直接入栈
                stack.add(i);
                i++;
                break;
            }
        }
        if (stack.isEmpty())return 0;
        //System.out.println("这是第一个i后面的数"+i);
        for (; i < height.length - 1; i++) {
            if (height[i] >= height[i + 1] && height[i]>height[i-1]) {
                //后面的,处理 和第一个栈头的接雨水量
                    int n = stack.pop();
                    //System.out.println("这是两个下标"+n+"-"+i);
                    int min,max;
                    if (height[n]>height[i]){
                        max = n;
                        min = i;
                    }else {
                        max = i;
                        min = n;
                    }
                //System.out.println("min="+min+"max="+max);
                    for (int j = n + 1; j < i; j++) {
                        //sum += (height[min] - height[j]);
                        // 如果没有变动,就不可以更改
                        //sum += (height[min] - height[j])>0?(height[min] - height[j]):0;
                        if ((height[min] - height[j])>0){
                            sum += (height[min] - height[j]);
                            height[j] = height[min];
                        }

                        //System.out.println("sum="+sum);
                    }
                    stack.add(max);//把大的加入栈

                }
            //System.out.println(stack+"---"+sum);
            }

        if (height[height.length-1]>height[height.length-2]){
            int n = stack.pop();
            int min;
            if (height[n]>height[height.length-1]){
                min = i;
            }else {
                min = n;
            }
            for (int j = n + 1; j < height.length-1; j++) {
                if ((height[min] - height[j])>0){
                    sum += (height[min] - height[j]);
                    height[j] = height[min];
                }
            }
        }



        return sum;
    }

    //方法2:计算单层
    public static int trap2(int[] height) {
        if (height.length <= 2){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int i;
        for (i = 0; i < height.length-1; i++) {
            if (height[i] > height[i + 1]) {//第一个最大值,直接入栈
                stack.add(i);
                i++;
                break;
            }
        }
        if (stack.isEmpty())return 0;
        //System.out.println("这是第一个i后面的数"+i);
        for (; i < height.length - 1; i++) {
            if (height[i] >= height[i + 1] && height[i]>height[i-1]) {
                //后面的,处理 和第一个栈头的接雨水量
                    int n = stack.pop();
                    //System.out.println("这是两个下标"+n+"-"+i);
                    int min,max;
                    if (height[n]>height[i]){
                        max = n;
                        min = i;
                    }else {
                        max = i;
                        min = n;
                    }
                //System.out.println("min="+min+"max="+max);
                    for (int j = n + 1; j < i; j++) {
                        //sum += (height[min] - height[j]);
                        // 如果没有变动,就不可以更改
                        //sum += (height[min] - height[j])>0?(height[min] - height[j]):0;
                        if ((height[min] - height[j])>0){
                            sum += (height[min] - height[j]);
                            height[j] = height[min];
                        }

                        //System.out.println("sum="+sum);
                    }
                    stack.add(max);//把大的加入栈

                }
            //System.out.println(stack+"---"+sum);
            }

        if (height[height.length-1]>height[height.length-2]){
            int n = stack.pop();
            int min;
            if (height[n]>height[height.length-1]){
                min = i;
            }else {
                min = n;
            }
            for (int j = n + 1; j < height.length-1; j++) {
                if ((height[min] - height[j])>0){
                    sum += (height[min] - height[j]);
                    height[j] = height[min];
                }
            }
        }



        return sum;
    }

    public static void main(String[] args) {
        /*System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trap(new int[]{}));
        System.out.println(trap(new int[]{1}));
        System.out.println(trap(new int[]{1,2}));
        System.out.println(trap(new int[]{5,4,1,2}));*/
        System.out.println(trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}));
        System.out.println(trap(new int[]{9,6,8,8,5,6,3}));//3
        System.out.println(trap(new int[]{1,7,8}));//3
    }
}
