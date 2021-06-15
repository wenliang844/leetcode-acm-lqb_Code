package ACM.每日一题leecode.day01;

import java.util.HashMap;

/*
给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。

然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的 最短时间 。

 

示例 1：

输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
示例 2：

输入：tasks = ["A","A","A","B","B","B"], n = 0
输出：6
解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
诸如此类
示例 3：

输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
输出：16
解释：一种可能的解决方案是：
     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/task-scheduler
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day06_621任务调度器m {

    public static void main(String[] args) {
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println("===" + leastInterval(tasks1, 50));

        char[] tasks2 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println("===" + leastInterval(tasks2, 0));

        char[] tasks3 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println("===" + leastInterval(tasks3, 2));

        char[] tasks4 = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'B'};
        System.out.println("===" + leastInterval(tasks4, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        Integer count;  //计数字符出现次数
        int maxCount = 1;   //标记最大出现次数
        for (int i = 0; i < tasks.length; i++) {
            count = map.get(tasks[i]);
            //System.out.println(count);
            if (count == null) {
                map.put(tasks[i], 1);
            } else {
                map.put(tasks[i], count + 1);
                if (count + 1 > maxCount) {
                    maxCount = count + 1;
                }
            }
        }

        int sameCount = 0;//最大数的字符有几个并列
        for (Character character : map.keySet()) {
            if (map.get(character)==maxCount){
                sameCount++;
            }
        }
        //System.out.println("--max--" + maxCount);
        //公式(maxCount - 1) * (n+1) + 1 是最大出现的字符空n个再排列得出的最大序列   但是有两个最大序列怎么搞?
        //有n个相同最大的字符   最终结果＋(n-1)
        return (maxCount - 1) * (n + 1) + 1 +(sameCount-1)> tasks.length ? (maxCount - 1) * (n + 1) + 1 +(sameCount-1): tasks.length;
    }
}
