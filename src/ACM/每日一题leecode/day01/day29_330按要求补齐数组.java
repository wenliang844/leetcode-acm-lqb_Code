package ACM.每日一题leecode.day01;

import java.util.*;

/****
 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 
 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 示例 1:
 输入: nums = [1,3], n = 6
 输出: 1
 解释:
 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
 所以我们最少需要添加一个数字。
 示例 2:
 输入: nums = [1,5,10], n = 20
 输出: 2
 解释: 我们需要添加 [2, 4]。
 示例 3:
 输入: nums = [1,2,2], n = 5
 输出: 0

 */
public class day29_330按要求补齐数组 {
    /***
     思路:维持两个list
     list1是1 5 10 所能组成的数
     list2是1-20中的数
     每一轮中list1为自己 加上自己加和所能表示的数 +加上新的数和每一个数组合能表示的数
     list2为remove掉list1表示的数
     将list2中最小的数 给list1  也就是list2中的第一个数

     第一轮 list1: 1 5 6 10 11 15 16
     list2: 2 3 4 7 8 9 12 13 14 17 18 19 20
     第二轮 2 + list1: 1 2 3 5 7 6 8 10 12 11 13 15 17 16 18
     list2: 4 9 14 19 20
     第三轮 4+ list1: 1 2 3 5 9 7 6 8 10 14 12 11 13 15 19 17 21 16 20 18 22
     list2: 空(结束)
     每轮计数器count+1

     while(){
     list2 去掉list1中的数字
     如果list空了,退出结束
     如果list2还有,count加1 list加上list2中最小的数进行组合
     }
     */
    public static void main(String[] args) {
        System.out.println("这是结果=" + minPatches3(new int[]{1, 5, 10}, 20));
        System.out.println("这是结果=" + minPatches3(new int[]{1, 2, 3, 4, 5}, 20));
        System.out.println("这是结果=" + minPatches3(new int[]{1, 3}, 6));
        System.out.println("这是结果=" + minPatches3(new int[]{1, 2, 2}, 5));
        System.out.println("这是结果=" + minPatches3(new int[]{1, 2, 31, 33}, 1000));
        System.out.println("这是结果=" + minPatches3(new int[]{1, 2, 31, 33}, 2147483647));
        System.out.println("这是结果=" + minPatchesOthers1(new int[]{1, 2, 31, 33}, 2147483647));
    }

    //list 双指针  暴力解法
    public static int minPatches(int[] nums, int n) {
        List<Integer> list1 = new ArrayList<>();//源表示数列 如果用set可以去重和排序
        List<Integer> list2 = new ArrayList<>();//被表示数列
        for (int i = 0; i < nums.length; i++) {
            list1.add(nums[i]);
        }
        for (int i = 1; i <= n; i++) {
            list2.add(i);
        }

        //三指针 全表示
        //两个表示区间   一个表示后数
        // >1 >5 6 >10
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < list1.size() - 1; i++) {
            for (int j = i; j < list1.size() - 1; j++) {
                int temp = 0;
                for (int k = i; k <= j; k++) {
                    temp += list1.get(k);
                }
                for (int k = j + 1; k < list1.size(); k++) {
                    tmpList.add(temp + list1.get(k));

                }
            }
        }
        list1.addAll(tmpList);
        tmpList.clear();
        System.out.println("这是组合后的list1==" + list1);

        int count = 0;
        //进行循环组合
        while (true) {
            //list2 去掉list1中的数字
            for (Integer integer : list1) {
                boolean removeFlag = list2.remove(integer);
                //System.out.println("删除="+removeFlag+"删除的是"+integer);
            }
            //如果list空了,退出结束
            if (list2.isEmpty()) {
                return count;
            }

            //如果list2还有,count加1 list加上list2中最小的数进行组合
            count++;

            int minNum = list2.get(0);
            //System.out.println("这是本轮最小的数"+minNum);
            List<Integer> tempList2 = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                tempList2.add(minNum + list1.get(i));
            }
            list1.add(minNum);
            list1.addAll(tempList2);
            tempList2.clear();
        }

        //return 0;
    }

    //优化思路 用set去重  减少内存消耗
    public static int minPatches2(int[] nums, int n) {
        List<Integer> list1 = new ArrayList<>();//源表示数列 如果用set可以去重和排序
        List<Integer> list2 = new ArrayList<>();//被表示数列
        for (int i = 0; i < nums.length; i++) {
            list1.add(nums[i]);
        }
        for (int i = 1; i <= n; i++) {
            list2.add(i);
        }

        //三指针 全表示
        //两个表示区间   一个表示后数
        // >1 >5 6 >10
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < list1.size() - 1; i++) {
            for (int j = i; j < list1.size() - 1; j++) {
                int temp = 0;
                for (int k = i; k <= j; k++) {
                    temp += list1.get(k);
                }
                for (int k = j + 1; k < list1.size(); k++) {
                    tmpList.add(temp + list1.get(k));

                }
            }
        }
        list1.addAll(tmpList);
        tmpList.clear();
        System.out.println("这是组合后的list1==" + list1);

        int count = 0;
        Set<Integer> set1 = new HashSet<>();
        for (Integer integer : list1) {
            if (integer <= n) {
                set1.add(integer);
            }
        }
        //进行循环组合
        while (true) {
            //list2 去掉list1中的数字
            /*for (Integer integer : list1) {
                boolean removeFlag = list2.remove(integer);
                //System.out.println("删除="+removeFlag+"删除的是"+integer);
            }*/
            for (Integer integer : set1) {
                boolean remove = list2.remove(integer);
                //System.out.println("删除=" + remove + "删除的是" + integer);

            }
            //如果list空了,退出结束
            /*if (list2.isEmpty()) {
                return count;
            }*/
            //如果set1 size >= n   结束
            if (set1.size() >= n) {
                return count;
            }

            //如果list2还有,count加1 list加上list2中最小的数进行组合
            count++;

            int minNum = list2.get(0);//用set所不能表示的第一个数字表示minNum
           /* Collections.sort(list1);
            for (int i = 0; i < n; i++) {

            }*/
            //System.out.println("这是本轮最小的数"+minNum);
            Set<Integer> tmpset1 = new HashSet<>();
            /*for (int i = 0; i < list1.size(); i++) {
                tempList2.add(minNum+list1.get(i));
            }*/
            for (Integer integer : set1) {
                if (integer + minNum <= n) {
                    tmpset1.add(integer + minNum);
                }
            }
            set1.add(minNum);
            set1.addAll(tmpset1);
            tmpset1.clear();
        }

        //return 0;
    }


    //优化 巧妙解法
    public static int minPatches3(int[] nums, int n) {
        /****
         我的理解和思路{看了评论区后}{
         对nums:1 5 10 用一个指针pos指向
         对n=20:用一个指针cur表示  初始pos指向1  cur指向1
         当前可表示的最大值用maxNum表示 初始=1 ,while循环当maxNum>=n的时候表示可表示的数为maxNum  退出循环 每次cue<num[pos]的时候maxNum+=cur cur=maxNUm+1 res+1
         返回res
         就是说完全可覆盖的区间是[1,k]
         pos指向的是nums中的元素B
         当把B也加进去之后,可表示的数就向右扩展了B个  变成了1---k+B

         //以往数字的加和就是你能表示的最多数字,
         如果指向的最多数字加1   你数组没有  或者你数组的数指向一个比我还大的数,那你就表示不了我这个数,你就要把我加上
         同时能表示的最大数也要把我加上
         */
        int pos = 0;//指向nums的下标
        long cur = 1;//cur=1 1-n个数
        int res = 0;//要加的数

        //int max = 0;//当前可表示的最大数 1---max   max=k+b b是num[pos]
        long max = 0;//最好用long表示 因为太长了,比int还长

        while (max < n) {
            if (pos<nums.length && nums[pos] <= cur) {//能表示cur这个数   比如cur = maxNum+1 =7+1=8   pos=65可以表示
                max += nums[pos];
                pos++;
                cur = max + 1;
            } else {//pos太大  比如pos=5  cur指向2  表示不了2  就要加一个2
                max += cur;
                cur = max + 1;
                res++;
            }
        }

        return res;
    }

    /***
     可以这么理解，以[1,5,10]的例子为例: 我们从1开始遍历,并且维护一个指向nums的下标.
     一开始是1，而我们看到当前nums数组的第一个元素就是1,所以不需要其他操作.直接跳到2，
     并且让pos指向nums的第二个元素；

     现在,我们的目标数是2,但是当前pos指向的数却是5,显然我们只能自己填充一个2,所以让res+1;
     既然我们已经填过2了,而在2之前可以被覆盖的最长区间长度是1,所以当前可以遍历到的最大区间长度变成了3(即2 + 1);

     然后,我们可以忽略3,直接跳到4(因为上一步已经知道3在最大覆盖范围内了)。
     我们发现4同样比当前pos所指向的nums元素小,所以我们得填入4，即让res+1;既然已经填入4了,
     而我们知道在4之前可以覆盖的连续区间是(1-3),所以当前可以覆盖的最大区间被扩展到了7(即4 + 3)。

     接下来我们可以直接跳过5、6、7来到8,而当前pos所指向的元素是5,所以当前可覆盖的区间大小又可以加上5了(7+5 = 12),
     并让pos指向下一个元素

     最后我们跳过了7-12，从13开始遍历，这时候pos所指的元素是10,所以覆盖范围变成了12 + 10 = 22 >20，
     说明可以完全覆盖指定区间了！

     到这里大概能够看出端倪 ：我们不断维持一个从1开始的可以被完全覆盖的区间,举个例子,当前可以完全覆盖区间是[1,k]，
     而当前pos所指向的nums中的元素为B,说明在B之前(因为是升序，所以都比B小)的所有元素之和可以映射到1-----k，
     而当我们把B也加入进去后，显然，可映射范围一定向右扩展了B个，也就是变成了1---k+B，这就是解题的思路

     代码见评论区
     */

    /**
     方法一：贪心算法
     对于正整数 xx，如果区间 [1,x-1][1,x−1] 内的所有数字都已经被覆盖，且 xx 在数组中，则区间 [1,2x-1][1,2x−1] 内的所有数字也都被覆盖。证明如下。

     对于任意 1 \le y<x1≤y<x，yy 已经被覆盖，xx 在数组中，因此 y+xy+x 也被覆盖，区间 [x+1,2x-1][x+1,2x−1]（即区间 [1,x-1][1,x−1] 内的每个数字加上 xx 之后得到的区间）内的所有数字也被覆盖，由此可得区间 [1,2x-1][1,2x−1] 内的所有数字都被覆盖。

     假设数字 xx 缺失，则至少需要在数组中补充一个小于或等于 xx 的数，才能覆盖到 xx，否则无法覆盖到 xx。

     如果区间 [1,x-1][1,x−1] 内的所有数字都已经被覆盖，则从贪心的角度考虑，补充 xx 之后即可覆盖到 xx，且满足补充的数字个数最少。在补充 xx 之后，区间 [1,2x-1][1,2x−1] 内的所有数字都被覆盖，下一个缺失的数字一定不会小于 2x2x。

     由此可以提出一个贪心的方案。每次找到未被数组 \textit{nums}nums 覆盖的最小的整数 xx，在数组中补充 xx，然后寻找下一个未被覆盖的最小的整数，重复上述步骤直到区间 [1,n][1,n] 中的所有数字都被覆盖。

     具体实现方面，任何时候都应满足区间 [1,x-1][1,x−1] 内的所有数字都被覆盖。令 xx 的初始值为 11，数组下标 \textit{index}index 的初始值为 00，则初始状态下区间 [1,x-1][1,x−1] 为空区间，满足区间内的所有数字都被覆盖。进行如下操作。

     如果 \textit{index}index 在数组 \textit{nums}nums 的下标范围内且 \textit{nums}[\textit{index}] \le xnums[index]≤x，则将 \textit{nums}[\textit{index}]nums[index] 的值加给 xx，并将 \textit{index}index 的值加 11。

     被覆盖的区间从 [1,x-1][1,x−1] 扩展到 [1,x+\textit{nums}[\textit{index}]-1][1,x+nums[index]−1]，对 xx 的值更新以后，被覆盖的区间为 [1,x-1][1,x−1]。
     否则，xx 没有被覆盖，因此需要在数组中补充 xx，然后将 xx 的值乘以 22。

     在数组中补充 xx 之后，被覆盖的区间从 [1,x-1][1,x−1] 扩展到 [1,2x-1][1,2x−1]，对 xx 的值更新以后，被覆盖的区间为 [1,x-1][1,x−1]。
     重复上述操作，直到 xx 的值大于 nn。

     由于任何时候都满足区间 [1,x-1][1,x−1] 内的所有数字都被覆盖，因此上述操作可以保证区间 [1,n][1,n] 内的所有数字都被覆盖。

     又由于上述操作只在 xx 不被覆盖时才在数组中补充 xx，如果不补充 xx 则 xx 无法被覆盖，因此可以保证补充的数字个数最少。如果减少补充的数字个数，则无法覆盖区间 [1,n][1,n] 内的所有数字。

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode-solu-klp1/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param n
     * @return
     */
    static int minPatchesOthers1(int[] nums, int n) {
        int curr_range = 0;
        int m = nums.length;
        int res = 0;
        for (int i = 1, pos = 0; i <= n; ) {
            if (pos >= m || i < nums[pos]) {
                res++;
                curr_range += i;
            } else {
                curr_range += nums[pos];
                pos++;
            }
            i = curr_range + 1;
        }

        return res;
    }
}
