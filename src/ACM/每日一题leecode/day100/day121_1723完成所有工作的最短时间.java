package ACM.每日一题leecode.day100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class day121_1723完成所有工作的最短时间 {
    /*****
     给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
     请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
     返回分配方案中尽可能 最小 的 最大工作时间 。

     示例 1：
     输入：jobs = [3,2,3], k = 3
     输出：3
     解释：给每位工人分配一项工作，最大工作时间是 3 。
     */
    public static void main(String[] args) {
        System.out.println(minimumTimeRequired(new int[]{3, 2, 3}, 3));
        System.out.println(minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
        System.out.println(minimumTimeRequired(new int[]{5, 5, 4, 4, 4}, 2));
    }

    //方法一:从大到小开始分配,分配给最小的工人 工人数组work[k] 每次更新min最小值的下标  //48/60
    public static int minimumTimeRequired(int[] jobs, int k) {

       /* int secondIndex = 0;
        int minIndex = 0;*/
        int[] worker = new int[k];
        Arrays.sort(jobs);//从后面开始分配
        //保存下标,大的在前面

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return worker[integer] - worker[t1];
            }
        });
        //把0-k加到pri
        for (int i = 0; i < k; i++) {
            priorityQueue.add(i);
        }
        for (int i = jobs.length - 1; i >= 0; i--) {
            //一出一进,能让进来
            Integer poll = priorityQueue.poll();
            worker[poll] += jobs[i];
            priorityQueue.add(poll);
        }

        /*boolean offer = priorityQueue.offer(worker.length - 1);
        System.out.println(offer);*/
        //遍历一下获取最大
        /*for (Integer integer : priorityQueue) {
            System.out.println("--"+worker[integer]);
        }*/

        while (priorityQueue.size() > 1) {
            //System.out.println(priorityQueue.size());
            priorityQueue.poll();
        }
        return worker[priorityQueue.poll()];
    }

    static int[] jobs;
    static int n;
    static int k;
    static int ans = 0x3f3f3f3f;

    //宫水三叶:des爆搜
    public static int minimumTimeRequired2(int[] _jobs, int _k) {
        jobs = _jobs;
        n = _jobs.length;
        k = _k;
        int[] sum = new int[k];
        dfs(0, sum, 0);
        return ans;
    }

    /****
     * @param u : 当前处理到的那个job
     * @param sum : 人工的分配情况 如sum[0]=x带表0号工人工作量x
     * @param max : 当前的最大工作时间
     */
    private static void dfs(int u, int[] sum, int max) {

        if (max >= ans) return;
        if (u == n) {
            ans = max;
            return;
        }
        for (int i = 0; i < k; i++) {
            sum[i] += jobs[u];
            dfs(u + 1, sum, Math.max(sum[i], max));
            sum[i] -= jobs[u];
        }
    }

    private static void dfs(int u,int used, int[] sum, int max) {

        /**
         优化策略:可以做一下别的剪枝优化,除了max>=ans之外
         思想高明，没看懂,下次一定
         */
        if (max >= ans) return;
        if (u == n) {
            ans = max;
            return;
        }

        //优先分配给[空闲工人]
        if (used <k){
            sum[used] = jobs[u];
            dfs(u+1,used+1,sum,Math.max(sum[used],max));
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[u];
            dfs(u + 1,used, sum, Math.max(sum[i], max));
            sum[i] -= jobs[u];
        }
    }

}
