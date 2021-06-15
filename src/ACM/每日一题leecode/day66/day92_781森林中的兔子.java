package ACM.每日一题leecode.day66;

import java.util.Arrays;

public class day92_781森林中的兔子 {

    /***
     森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。

     返回森林中兔子的最少数量。

     示例:
     输入: answers = [1, 1, 2]
     输出: 5
     解释:
     两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
     之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
     设回答了 "2" 的兔子为蓝色。
     此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
     因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。

     输入: answers = [10, 10, 10]
     输出: 11

     输入: answers = []
     输出: 0


     ⌈
     y+1
     x
     ⌉⋅(y+1)

     ans += (x + y) / (y + 1) * (y + 1);
     */

    //方法一:排序+双指针 重复的有多少个,个数+1/数量+1 *数量+1   96 73
    public static int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int rabbit = 0;
       int i=0;
       int j=i+1;
       while (true){
           if (j<answers.length && answers[i] == answers[j]){
               j++;
           }else {
               int count = j-i;
               int val = answers[i]+1;
               rabbit += ((count+val-1) / val) *val;
               i=j;
               j=i+1;

               if (j>=answers.length){
                   break;
               }
           }
       }

       if (answers[answers.length-1] != answers[answers.length-2]){
           rabbit += answers[answers.length-1]+1;
       }

       return rabbit;
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1, 1, 2}));//5
        System.out.println(numRabbits(new int[]{1, 1, 2,2}));//5
        System.out.println(numRabbits(new int[]{10,10,10}));//11
    }
}
