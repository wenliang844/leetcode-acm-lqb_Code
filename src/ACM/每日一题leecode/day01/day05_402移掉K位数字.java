package ACM.每日一题leecode.day01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。
示例 1 :

输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
示例 2 :

输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
示例 3 :

输入: num = "10", k = 2
输出: "0"
解释: 从原数字移除所有的数字，剩余为空就是0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-k-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day05_402移掉K位数字 {

    public static void main(String[] args) {
        String num = "1432219";//1219
        int k = 3;
        String s = removeKdigits4(num, k);
        System.out.println(s);

        System.out.println("--------------------------------------");
        String num2 = "10200";//200
        System.out.println(removeKdigits4(num2, 1));

        System.out.println("--------------------------------------");
        String num3 = "10";//0
        System.out.println(removeKdigits4(num3, 2));

        System.out.println("--------------------------------------");
        System.out.println(removeKdigits4("1000", 2));
    }

    public static String removeKdigits(String num, int k) {
        char[] chs = num.toCharArray();
        int[] ints = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            ints[i] = (int) chs[i] - 48;
            System.out.println(ints[i]);
            //System.out.println(chs[i]);
        }

        for (int i = 0; i < k; i++) {
            System.out.println("---第" + i + "轮---");
            for (int j = 0; j < ints.length; j++) {
                if (j == 0 && ints[j] > ints[j + 1]) {
                    System.out.println(ints[j] + "---" + j);
                    ints[j] = -1;
                    break;
                }
                if (j > 0 && j != ints.length - 1 && ints[j] > ints[j - 1] && ints[j] > ints[j + 1]) {
                    System.out.println(ints[j] + "---" + j);
                    ints[j] = -1;
                    break;
                }
                if (j == ints.length - 1 && ints[j] >= ints[j - 1]) {
                    System.out.println(ints[j] + "---" + j);
                    ints[j] = -1;
                    break;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            sb.append(ints[i]);
        }
        return sb.toString();
    }

    public static String removeKdigits2(String num, int k) {
        char[] chs = num.toCharArray();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < chs.length; i++) {
            list.add((int) chs[i] - 48);
            //System.out.println(list.get(i));
        }

        if (k == list.size()) {
            return "0";
        }
        for (int i = 0; i < k; i++) {
            //System.out.println("---第" + i + "轮---");
            for (int j = 0; j < list.size(); j++) {
                if (j == 0 && list.get(j) > list.get(j + 1)) {
                    //System.out.println(list.get(j) + "---" + j);
                    list.remove(j);
                    break;
                }
                if (j > 0 && j != list.size() - 1 && list.get(j) >= list.get(j - 1) && list.get(j) > list.get(j + 1)) {
                    //System.out.println(list.get(j) + "---" + j);
                    list.remove(j);
                    break;
                }
                if (j == list.size() - 1 && list.get(j) >= list.get(j - 1)) {
                    //System.out.println(list.get(j) + "---" + j);
                    list.remove(j);
                    break;
                }
            }
        }

        while (list.size() > 0 && list.get(0) == 0) {
            list.remove(0);
        }
        if (list.size() <= 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    /*
    一个简单的思路就是：

每次丢弃一次，k 减去 1。当 k 减到 0 ，我们可以提前终止遍历。
而当遍历完成，如果 k 仍然大于 0。不妨假设最终还剩下 x 个需要丢弃，那么我们需要选择删除末尾 x 个元素。

作者：fe-lucifer
链接：https://leetcode-cn.com/problems/remove-k-digits/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static String removeKdigits3(String num, int k) {
        char[] chs = num.toCharArray();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < chs.length; i++) {
            list.add((int) chs[i] - 48);
            //System.out.println(list.get(i));
        }

        if (k == list.size()) {
            return "0";
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < list.size(); j++) {
                //使前面的数字尽量小即可;   425   4>2?    remove4 : continnue
                if (j==list.size()-1){
                    list.remove(j);
                    break;
                }else if(list.get(j) > list.get(j + 1)){
                    list.remove(j);
                    break;
                }
                else{
                    continue;
                }

            }
        }

        while (list.size() > 0 && list.get(0) == 0) {
            list.remove(0);
        }
        if (list.size() <= 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    /*
    让我们从一个简单的例子开始。给定一个数字序列，例如 425425，如果要求我们只删除一个数字，那么从左到右，我们有 44、22 和 55 三个选择。我们将每一个数字和它的左邻居进行比较。从 22 开始，22 小于它的左邻居 44。假设我们保留数字 44，那么所有可能的组合都是以数字 44（即 4242，4545）开头的。相反，如果移掉 44，留下 22，我们得到的是以 22 开头的组合（即 2525），这明显小于任何留下数字 44 的组合。因此我们应该移掉数字 44。如果不移掉数字 44，则之后无论移掉什么数字，都不会得到最小数。

基于上述分析，我们可以得出「删除一个数字」的贪心策略：

给定一个长度为 nn 的数字序列 [D_0D_1D_2D_3\ldots D_{n-1}][D
0
​
 D
1
​
 D
2
​
 D
3
​
 …D
n−1
​
 ]，从左往右找到第一个位置 ii（i>0i>0）使得 D_i<D_{i-1}D
i
​
 <D
i−1
​
 ，并删去 D_{i-1}D
i−1
​
 ；如果不存在，说明整个数字序列单调不降，删去最后一个数字即可。

基于此，我们可以每次对整个数字序列执行一次这个策略；删去一个字符后，剩下的 n-1n−1 长度的数字序列就形成了新的子问题，可以继续使用同样的策略，直至删除 kk 次。

然而暴力的实现复杂度最差会达到 O(nk)O(nk)（考虑整个数字序列是单调不降的），因此我们需要加速这个过程。

考虑从左往右增量的构造最后的答案。我们可以用一个栈维护当前的答案序列，栈中的元素代表截止到当前位置，删除不超过 kk 次个数字后，所能得到的最小整数。根据之前的讨论：在使用 kk 个删除次数之前，栈中的序列从栈底到栈顶单调不降。

因此，对于每个数字，如果该数字小于栈顶元素，我们就不断地弹出栈顶元素，直到

栈为空
或者新的栈顶元素不大于当前数字
或者我们已经删除了 kk 位数字

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static String removeKdigits4(String num, int k) {
       // ArrayList<Character> list = new ArrayList<Character>();
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k>0&&deque.peekLast()>digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i =0;i<k;++i){
            deque.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while(!deque.isEmpty()){
            char digit = deque.pollFirst();
            if (leadingZero && digit=='0'){
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length()==0?"0":sb.toString();
    }

    /*
    代码（Python）

class Solution(object):
    def removeKdigits(self, num, k):
        第3节_stack = []
        remain = len(num) - k
        for digit in num:
            while k and 第3节_stack and 第3节_stack[-1] > digit:
                第3节_stack.pop()
                k -= 1
            第3节_stack.append(digit)
        return ''.join(第3节_stack[:remain]).lstrip('0') or '0'
复杂度分析

时间复杂度：虽然内层还有一个 while 循环，但是由于每个数字最多仅会入栈出栈一次，因此时间复杂度仍然为 O(N)O(N)，其中 NN 为数字长度。
空间复杂度：我们使用了额外的栈来存储数字，因此空间复杂度为 O(N)O(N)，其中 NN 为数字长度。
提示： 如果题目改成求删除 k 个字符之后的最大数，我们只需要将 第3节_stack[-1] > digit 中的大于号改成小于号即可。
     */
}
