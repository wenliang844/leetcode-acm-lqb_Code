package ACM.tag刷题.数据结构.栈;

import java.util.Arrays;
import java.util.Stack;

public class stack_739每日温度 {

    /**
     请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     */
    /***
     这种题我始终更喜欢KMP，空间复杂度更低哟

     时间复杂度O(n)

     空间复杂度O(1)

     该思路由KMP中失配数组的构造演变而来。假设ans[i]记录了i位置上的答案（向右找多少个比自己大），则求ans[i]时，我先看一眼i+1位置，如果T[i+1]比我大，那得了，答案就是它了。

     否则我要找的位置至少是比T[i+1]大，那么当然我就看一看ans[i+1]

     class Solution:
     def dailyTemperatures(self, T: List[int]) -> List[int]:
     n=len(T)
     ans=[0]*n
     for i in range(n-2,-1,-1):
     now=i+1
     while T[now]<=T[i]:
     if ans[now]:
     now+=ans[now]
     else:
     break
     else:
     ans[i]=now-i
     return ans
     */
    //方法一:暴力,
    public static int[] dailyTemperatures(int[] T) {
        for (int i = 0; i < T.length; i++) {
            boolean flag = true;
            for (int j = i+1; j < T.length; j++) {
                if (T[j]>T[i]){
                    T[i] = j-i;
                    flag = false;
                    break;
                }
            }

            if (flag){
                T[i] = 0;
            }

        }

        return T;// [1, 1, 4, 2, 1, 1, 0, 0]
    }

    //方法二:栈 一个一个进栈 如果比栈顶的大:栈顶出,栈顶下标对应数组更新j-i 如果小,直接入栈
    public static int[] dailyTemperatures2(int[] T) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
           while (stack.size()>0 && T[i] > T[stack.peek()]){
               int j = stack.pop();
               T[j] = i-j;
           }
           stack.add(i);
        }
        //System.out.println(stack);

        while (stack.size()>0){
            T[stack.pop()] = 0;
        }
        return T;// [1, 1, 4, 2, 1, 1, 0, 0]
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
