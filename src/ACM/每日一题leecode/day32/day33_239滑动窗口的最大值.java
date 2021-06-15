package ACM.每日一题leecode.day32;

import java.util.Arrays;
import java.util.LinkedList;

public class day33_239滑动窗口的最大值 {
    /*****
     给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     返回滑动窗口中的最大值。

     示例 1：
     输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     输出：[3,3,5,5,6,7]
     解释：
     滑动窗口的位置                最大值
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     */
    public static void main(String[] args) {
        System.out.println("这是结果===" + Arrays.toString(maxSlidingWindow4(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    //暴力解法 //超时53 / 60 个通过测试用例
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length + 1 - k; i++) {
            res[i] = getMax(nums, i, i + k);
        }

        return res;
    }

    //获取指定区间的最大值
    public static int getMax(int[] nums, int i, int j) {
        int max = nums[i];
        for (int k = i + 1; k < j; k++) {
            if (nums[k] > max) {
                max = nums[k];
            }
        }

        return max;
    }

    //优化:前一次的最大值用起来,和后面比较一次就可以了---超时 //59 / 60 个通过测试用例
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length + 1 - k];
        int oldMaxIndex = -1;
        for (int i = 0; i < nums.length + 1 - k; i++) {
            oldMaxIndex = getMax2(nums, i, i + k, oldMaxIndex);
            res[i] = nums[oldMaxIndex];
        }

        return res;
    }

    //获取指定区间的最大值
    public static int getMax2(int[] nums, int i, int j, int oldMaxIndex) {
        int maxIndex = i;
        if (oldMaxIndex < i) {
            for (int k = i + 1; k < j; k++) {
                if (nums[k] > nums[maxIndex]) {
                    maxIndex = k;
                }
            }
        } else {
            maxIndex = nums[oldMaxIndex] > nums[j - 1] ? oldMaxIndex : j - 1;
        }


        return maxIndex;
    }

    //优化:方法不材分   还是材分把:----49 / 60 个通过测试用例
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int[] res = new int[nums.length + 1 - k];
        int oldMaxIndex = -1;
        int maxIndex;
        for (int i = 0; i < nums.length + 1 - k; i++) {

            maxIndex = i;
            if (oldMaxIndex < i) {
                for (int q = i + 1; q < i + k; q++) {
                    if (nums[q] > nums[maxIndex]) {
                        maxIndex = q;
                    }
                }
            } else {
                maxIndex = nums[oldMaxIndex] > nums[i + k - 1] ? oldMaxIndex : i + k - 1;
            }
            res[i] = nums[maxIndex];

        }

        return res;
    }

    //优化:双向队列 单调栈 优先队列
    public static int[] maxSlidingWindow4(int[] nums, int k) {

        /****
         此方法是看了左程云算法课讲解的思路，我只是知识的搬运工。当时听了之后，自己来做了一遍，并发表了评论。没想到现在成了热评，而且现在 LeetCode 可以自己写题解，官方既然发话了，我就再重新整理一下。

         思路
         遍历数组，将 数 存放在双向队列中，并用 L,R 来标记窗口的左边界和右边界。队列中保存的并不是真的 数，而是该数值对应的数组下标位置，并且数组中的数要从大到小排序。如果当前遍历的数比队尾的值大，则需要弹出队尾值，直到队列重新满足从大到小的要求。刚开始遍历时，L 和 R 都为 0，有一个形成窗口的过程，此过程没有最大值，L 不动，R 向右移。当窗口大小形成时，L 和 R 一起向右移，每次移动时，判断队首的值的数组下标是否在 [L,R] 中，如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。

         示例

         输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
         输出: [3,3,5,5,6,7]

         解释过程中队列中都是具体的值，方便理解，具体见代码。
         初始状态：L=R=0,队列:{}
         i=0,nums[0]=1。队列为空,直接加入。队列：{1}
         i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
         i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
         i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
         i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
         i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
         i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
         i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]
         通过示例发现 R=i，L=k-R。由于队列中的值是从大到小排序的，所以每次窗口变动时，只需要判断队首的值是否还在窗口中就行了。
         解释一下为什么队列中要存放数组下标的值而不是直接存储数值，因为要判断队首的值是否在窗口范围内，由数组下标取值很方便，而由值取数组下标不是很方便。
         */
        if (nums == null || nums.length < 2) return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        //结果数组
        int[] result = new int[nums.length+1-k];
        //遍历数组一个一个处理
        for (int i = 0; i < nums.length; i++) {
            //保证从小到大,如果前面的数小则需要依次弹出,直道满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            //添加当前的值对饮的数组下标到队尾
            queue.addLast(i);
            //判断当前队列中对首的值是否有效
            if (queue.peek() <= i-k){//不在范围内就弹出
                queue.poll();
            }

            //当窗口长度为k时,保存当前窗口的最大值
            if (i+1 >=k){
                result[i+1-k] = nums[queue.peek()];//对列首永远是最大值
            }
        }
        return result;
    }

    /*******官方
     方法一：优先队列
     思路与算法

     对于「最大值」，我们可以想到一种非常合适的数据结构，那就是优先队列（堆），其中的大根堆可以帮助我们实时维护一系列元素中的最大值。

     对于本题而言，初始时，我们将数组 \textit{nums}nums 的前 kk 个元素放入优先队列中。每当我们向右移动窗口时，我们就可以把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值。然而这个最大值可能并不在滑动窗口中，在这种情况下，这个值在数组 \textit{nums}nums 中的位置出现在滑动窗口左边界的左侧。因此，当我们后续继续向右移动窗口时，这个值就永远不可能出现在滑动窗口中了，我们可以将其永久地从优先队列中移除。

     我们不断地移除堆顶的元素，直到其确实出现在滑动窗口中。此时，堆顶元素就是滑动窗口中的最大值。为了方便判断堆顶元素与滑动窗口的位置关系，我们可以在优先队列中存储二元组 (\textit{num}, \textit{index})(num,index)，表示元素 \textit{num}num 在数组中的下标为 \textit{index}index。

     代码

     C++JavaPython3GolangC

     class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {
     int n = nums.length;
     PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
     public int compare(int[] pair1, int[] pair2) {
     return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
     }
     });
     for (int i = 0; i < k; ++i) {
     pq.offer(new int[]{nums[i], i});
     }
     int[] ans = new int[n - k + 1];
     ans[0] = pq.peek()[0];
     for (int i = k; i < n; ++i) {
     pq.offer(new int[]{nums[i], i});
     while (pq.peek()[1] <= i - k) {
     pq.poll();
     }
     ans[i - k + 1] = pq.peek()[0];
     }
     return ans;
     }
     }
     复杂度分析

     时间复杂度：O(n \log n)O(nlogn)，其中 nn 是数组 \textit{nums}nums 的长度。在最坏情况下，数组 \textit{nums}nums 中的元素单调递增，那么最终优先队列中包含了所有元素，没有元素被移除。由于将一个元素放入优先队列的时间复杂度为 O(\log n)O(logn)，因此总时间复杂度为 O(n \log n)O(nlogn)。

     空间复杂度：O(n)O(n)，即为优先队列需要使用的空间。这里所有的空间复杂度分析都不考虑返回的答案需要的 O(n)O(n) 空间，只计算额外的空间使用。

     方法二：单调队列
     思路与算法

     我们可以顺着方法一的思路继续进行优化。

     由于我们需要求出的是滑动窗口的最大值，如果当前的滑动窗口中有两个下标 ii 和 jj，其中 ii 在 jj 的左侧（i < ji<j），并且 ii 对应的元素不大于 jj 对应的元素（\textit{nums}[i] \leq \textit{nums}[j]nums[i]≤nums[j]），那么会发生什么呢？

     当滑动窗口向右移动时，只要 ii 还在窗口中，那么 jj 一定也还在窗口中，这是 ii 在 jj 的左侧所保证的。因此，由于 \textit{nums}[j]nums[j] 的存在，\textit{nums}[i]nums[i] 一定不会是滑动窗口中的最大值了，我们可以将 \textit{nums}[i]nums[i] 永久地移除。

     因此我们可以使用一个队列存储所有还没有被移除的下标。在队列中，这些下标按照从小到大的顺序被存储，并且它们在数组 \textit{nums}nums 中对应的值是严格单调递减的。因为如果队列中有两个相邻的下标，它们对应的值相等或者递增，那么令前者为 ii，后者为 jj，就对应了上面所说的情况，即 \textit{nums}[i]nums[i] 会被移除，这就产生了矛盾。

     当滑动窗口向右移动时，我们需要把一个新的元素放入队列中。为了保持队列的性质，我们会不断地将新的元素与队尾的元素相比较，如果前者大于等于后者，那么队尾的元素就可以被永久地移除，我们将其弹出队列。我们需要不断地进行此项操作，直到队列为空或者新的元素小于队尾的元素。

     由于队列中下标对应的元素是严格单调递减的，因此此时队首下标对应的元素就是滑动窗口中的最大值。但与方法一中相同的是，此时的最大值可能在滑动窗口左边界的左侧，并且随着窗口向右移动，它永远不可能出现在滑动窗口中了。因此我们还需要不断从队首弹出元素，直到队首元素在窗口中为止。

     为了可以同时弹出队首和队尾的元素，我们需要使用双端队列。满足这种单调性的双端队列一般称作「单调队列」。

     代码

     C++JavaPython3GolangCJavaScript

     class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {
     int n = nums.length;
     Deque<Integer> deque = new LinkedList<Integer>();
     for (int i = 0; i < k; ++i) {
     while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
     deque.pollLast();
     }
     deque.offerLast(i);
     }

     int[] ans = new int[n - k + 1];
     ans[0] = nums[deque.peekFirst()];
     for (int i = k; i < n; ++i) {
     while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
     deque.pollLast();
     }
     deque.offerLast(i);
     while (deque.peekFirst() <= i - k) {
     deque.pollFirst();
     }
     ans[i - k + 1] = nums[deque.peekFirst()];
     }
     return ans;
     }
     }
     复杂度分析

     时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{nums}nums 的长度。每一个下标恰好被放入队列一次，并且最多被弹出队列一次，因此时间复杂度为 O(n)O(n)。

     空间复杂度：O(k)O(k)。与方法一不同的是，在方法二中我们使用的数据结构是双向的，因此「不断从队首弹出元素」保证了队列中最多不会有超过 k+1k+1 个元素，因此队列使用的空间为 O(k)O(k)。

     方法三：分块 + 预处理
     思路与算法

     除了基于「随着窗口的移动实时维护最大值」的方法一以及方法二之外，我们还可以考虑其它有趣的做法。

     我们可以将数组 \textit{nums}nums 从左到右按照 kk 个一组进行分组，最后一组中元素的数量可能会不足 kk 个。如果我们希望求出 \textit{nums}[i]nums[i] 到 \textit{nums}[i+k-1]nums[i+k−1] 的最大值，就会有两种情况：

     如果 ii 是 kk 的倍数，那么 \textit{nums}[i]nums[i] 到 \textit{nums}[i+k-1]nums[i+k−1] 恰好是一个分组。我们只要预处理出每个分组中的最大值，即可得到答案；

     如果 ii 不是 kk 的倍数，那么 \textit{nums}[i]nums[i] 到 \textit{nums}[i+k-1]nums[i+k−1] 会跨越两个分组，占有第一个分组的后缀以及第二个分组的前缀。假设 jj 是 kk 的倍数，并且满足 i < j \leq i+k-1i<j≤i+k−1，那么 \textit{nums}[i]nums[i] 到 \textit{nums}[j-1]nums[j−1] 就是第一个分组的后缀，\textit{nums}[j]nums[j] 到 \textit{nums}[i+k-1]nums[i+k−1] 就是第二个分组的前缀。如果我们能够预处理出每个分组中的前缀最大值以及后缀最大值，同样可以在 O(1)O(1) 的时间得到答案。

     因此我们用 \textit{prefixMax}[i]prefixMax[i] 表示下标 ii 对应的分组中，以 ii 结尾的前缀最大值；\textit{suffixMax}[i]suffixMax[i] 表示下标 ii 对应的分组中，以 ii 开始的后缀最大值。它们分别满足如下的递推式

     \textit{prefixMax}[i]=\begin{cases} \textit{nums}[i], & \quad i ~是~ k ~的倍数 \\ \max\{ \textit{prefixMax}[i-1], \textit{nums}[i] \}, & \quad i ~不是~ k ~的倍数 \end{cases}
     prefixMax[i]={
     nums[i],
     max{prefixMax[i−1],nums[i]},
     ​

     i 是 k 的倍数
     i 不是 k 的倍数
     ​


     以及

     \textit{suffixMax}[i]=\begin{cases} \textit{nums}[i], & \quad i+1 ~是~ k ~的倍数 \\ \max\{ \textit{suffixMax}[i+1], \textit{nums}[i] \}, & \quad i+1 ~不是~ k ~的倍数 \end{cases}
     suffixMax[i]={
     nums[i],
     max{suffixMax[i+1],nums[i]},
     ​

     i+1 是 k 的倍数
     i+1 不是 k 的倍数
     ​


     需要注意在递推 \textit{suffixMax}[i]suffixMax[i] 时需要考虑到边界条件 \textit{suffixMax}[n-1]=\textit{nums}[n-1]suffixMax[n−1]=nums[n−1]，而在递推 \textit{prefixMax}[i]prefixMax[i] 时的边界条件 \textit{prefixMax}[0]=\textit{nums}[0]prefixMax[0]=nums[0] 恰好包含在递推式的第一种情况中，因此无需特殊考虑。

     在预处理完成之后，对于 \textit{nums}[i]nums[i] 到 \textit{nums}[i+k-1]nums[i+k−1] 的所有元素，如果 ii 不是 kk 的倍数，那么窗口中的最大值为 \textit{suffixMax}[i]suffixMax[i] 与 \textit{prefixMax}[i+k-1]prefixMax[i+k−1] 中的较大值；如果 ii 是 kk 的倍数，那么此时窗口恰好对应一整个分组，\textit{suffixMax}[i]suffixMax[i] 和 \textit{prefixMax}[i+k-1]prefixMax[i+k−1] 都等于分组中的最大值，因此无论窗口属于哪一种情况，

     \max\big\{ \textit{suffixMax}[i], \textit{prefixMax}[i+k-1] \big\}
     max{suffixMax[i],prefixMax[i+k−1]}

     即为答案。

     这种方法与稀疏表（Sparse Table）非常类似，感兴趣的读者可以自行查阅资料进行学习。

     代码

     C++JavaPython3GolangCJavaScript

     class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {
     int n = nums.length;
     int[] prefixMax = new int[n];
     int[] suffixMax = new int[n];
     for (int i = 0; i < n; ++i) {
     if (i % k == 0) {
     prefixMax[i] = nums[i];
     }
     else {
     prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
     }
     }
     for (int i = n - 1; i >= 0; --i) {
     if (i == n - 1 || (i + 1) % k == 0) {
     suffixMax[i] = nums[i];
     } else {
     suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
     }
     }

     int[] ans = new int[n - k + 1];
     for (int i = 0; i <= n - k; ++i) {
     ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
     }
     return ans;
     }
     }
     复杂度分析

     时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{nums}nums 的长度。我们需要 O(n)O(n) 的时间预处理出数组 \textit{prefixMax}prefixMax，\textit{suffixMax}suffixMax 以及计算答案。

     空间复杂度：O(n)O(n)，即为存储 \textit{prefixMax}prefixMax 和 \textit{suffixMax}suffixMax 需要的空间。

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
