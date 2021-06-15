package ACM.每日一题leecode.day01;

import java.util.PriorityQueue;

public class day28_502IPO资本撬动利润max {

    public static void printNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(findMaximizedCapital2(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));//4
        System.out.println(findMaximizedCapital2(2, 0, new int[]{1, 2, 3}, new int[]{0, 11, 11}));//1
    }

    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        /****
         k :最大操作数
         w :初始资本
         Pi :第i个项目的利润
         Ci :第i个项目启动需要的资本
         方法一:暴力解法:
         每次K操作取最大的利润 最大的不行就取次大的,次大的不行就再下一个 全部不行直接退出
         第k-1次操作 同理

         时间O(n2  k*P)
         */
        System.out.println("排序前--");
        printNums(Profits);
        printNums(Capital);
        //1.将Profits进行一个排序 同时Capital也响应的排序
        for (int i = 0; i < Profits.length - 1; i++) {
            for (int j = 1; j < Profits.length; j++) {
                if (Profits[j] > Profits[i]) {
                    //j大 交换P C的i j位置  从大扫小排序
                    int tmp1 = Profits[i];
                    int tmp2 = Capital[i];
                    Profits[i] = Profits[j];
                    Capital[i] = Capital[j];
                    Profits[j] = tmp1;
                    Capital[j] = tmp2;
                }
            }
        }
        System.out.println("排序后--");
        printNums(Profits);
        printNums(Capital);


        /***
         遍历 N 个项目，并在 W>=Capital[j] 的项目之间进行选择，选择 Profits[j] 最大的一个。
         如果当前资本不足以启动任意一个项目，则 break。  也就是w < Capital
         更新 W += Profits[idx]，然后标记该项目启动资金为 Capital[j] =
         */
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < Profits.length; j++) {
                if (W >= Capital[j]) {
                    W += Profits[j];
                    Capital[j] = Integer.MAX_VALUE;

                    System.out.println("吃掉了Profits:" + j + "-" + Profits[j] + "-" + Capital[j]);
                    break;
                }
            }
        }


        return W;
    }

    public static int findMaximizedCapital2(int k, int W, int[] Profits, int[] Capital) {
        /***Others
         复杂度分析

         时间复杂度：若一开始的资本大于全部项目的启动资本则时间复杂度为 \mathcal{O}(N \log k)O(Nlogk)。其他情况为 \mathcal{O}(\min(k, N) N)O(min(k,N)N)
         空间复杂度：若一开始的资本大于全部项目的启动资本空间复杂度为：Java 中为 \mathcal{O}(k)O(k)，在 Python 为 \mathcal{O}(1)O(1)。其他情况为 \mathcal{O}(1)O(1)。
         */
        // to speed up: if all projects are available
        boolean speedUp = true;
        for (int c : Capital) if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p : Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();
            }
            for (int h : heap) W += h;
            return W;
        }

        int idx;
        int n = Profits.length;
        for (int i = 0; i < Math.min(k, n); ++i) {
            idx = -1;
            // if there are available projects,
            // pick the most profitable one
            for (int j = 0; j < n; ++j) {
                if (W >= Capital[j]) {
                    if (idx == -1) idx = j;
                    else if (Profits[idx] < Profits[j]) idx = j;
                }
            }
            // not enough capital to start any project
            if (idx == -1) break;

            // add the profit from chosen project
            // and remove the project from further consideration
            W += Profits[idx];
            Capital[idx] = Integer.MAX_VALUE;
        }
        return W;
    }

    public static int findMaximizedCapital3(int k, int W, int[] Profits, int[] Capital) {
        /*****
         算法：

         为了加快速度，首先检查是否存在所有项目都可投资且初始资本 W >= max(Capital) 的情况。如果是，返回利润中前 k 个最大元素的和。
         构造 projects：
         包含每个项目的启动资金和利润信息。
         按启动资金排序。
         提供 pop 操作以删除已开展的项目。
         符合以上条件的结构是 Java 中的最小堆和 Python 中的集合数组。
         迭代选择 k 个项目，每一次选择：
         更新当前资金可用的项目列表。可以选择最大堆存储可用的项目，可以马上得到下一个最赚钱的项目。
         如果有可投资的项目，选择最赚钱的项目，更新 W 并继续。
         如果资金不足以启动任何项目就结束。
         返回 W

         复杂度分析:
         时间复杂度：最好的情况是一开始所有项目都可以投资，这个时候时间复杂度为 \mathcal{O}(N \log k)O(Nlogk)。否则，需要 \mathcal{O}(N \log N)O(NlogN) 的时间来创建和排序项目，更新可用项目的时间不超过 \mathcal{O}(N \log N)O(NlogN)，计算资本的时间不超过 \mathcal{O}(k \log N)O(klogN) 。因此，总的时间复杂度是 \mathcal{O}(N \log N + N \log N + k \log N)O(NlogN+NlogN+klogN)，若 k < Nk<N，则有 \mathcal{O}(N \log N)O(NlogN)。
         空间复杂度：\mathcal{O}(N)O(N)。
         */
        // to speed up: if all projects are available
        boolean speedUp = true;
        for (
                int c : Capital)
            if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p : Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();
            }
            for (int h : heap) W += h;
            return W;
        }

        int n = Profits.length;
        // sort the projects
        // the most available (= the smallest capital) is the head of the heap
        PriorityQueue<int[]> projects = new PriorityQueue<>((x, y) -> (x[0] - y[0]));
        for (
                int i = 0;
                i < n; i++) {
            projects.add(new int[]{Capital[i], Profits[i]});
        }

        // max heap
        PriorityQueue<Integer> available = new PriorityQueue<>((x, y) -> (y - x));
        while (k > 0) {
            // update available projects
            while (!projects.isEmpty() && projects.peek()[0] <= W)
                available.add(projects.poll()[1]);

            // if there are available projects,
            // pick the most profitable one
            if (!available.isEmpty()) W += available.poll();
                // not enough capital to start any project
            else break;
            --k;
        }
        return W;
    }

}
