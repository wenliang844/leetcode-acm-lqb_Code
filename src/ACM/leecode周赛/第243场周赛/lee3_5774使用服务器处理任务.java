package ACM.leecode周赛.第243场周赛;

import java.util.Arrays;
import java.util.HashMap;

public class lee3_5774使用服务器处理任务 {
    /****

     通过的用户数0
     尝试过的用户数0
     用户总通过次数0
     用户总提交次数0
     题目难度Medium
     给你两个 下标从 0 开始 的整数数组 servers 和 tasks ，长度分别为 n​​​​​​ 和 m​​​​​​ 。servers[i] 是第 i​​​​​​​​​​ 台服务器的 权重 ，而 tasks[j] 是处理第 j​​​​​​ 项任务 所需要的时间（单位：秒）
     你正在运行一个仿真系统，在处理完所有任务后，该系统将会关闭。每台服务器只能同时处理一项任务。第 0 项任务在第 0 秒可以开始处理，相应地，第 j 项任务在第 j 秒可以开始处理。处理第 j 项任务时，你需要为它分配一台 权重最小 的空闲服务器。如果存在多台相同权重的空闲服务器，请选择 下标最小 的服务器。如果一台空闲服务器在第 t 秒分配到第 j 项任务，那么在 t + tasks[j] 时它将恢复空闲状态。
     如果没有空闲服务器，则必须等待，直到出现一台空闲服务器，并 尽可能早 地处理剩余任务。 如果有多项任务等待分配，则按照 下标递增 的顺序完成分配。
     如果同一时刻存在多台空闲服务器，可以同时将多项任务分别分配给它们。
     构建长度为 m 的答案数组 ans ，其中 ans[j] 是第 j 项任务分配的服务器的下标。
     返回答案数组 ans​​​​ 。
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(assignTasks(new int[]{3, 3, 2},new int[]{1, 2, 3, 2, 1, 2})));
        System.out.println(Arrays.toString(assignTasks(new int[]{10,63,95,16,85,57,83,95,6,29,71},new int[]{70,31,83,15,32,67,98,65,56,48,38,90,5})));//[8,0,3,9,5,1,10,6,4,2,7,9,0]
    }

    //方法一:暴力解法,记录每个下标的可用时间
    public static int[] assignTasks(int[] servers, int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();//<index,time>
        int[] ans = new int[tasks.length];
        for (int i = 0; i < servers.length; i++) {
            map.put(i,0);
        }

        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            //对taski进行计算,对ans赋值,选择一个权重最小的可用的服务器 并且是可用的时间<=i
            int index = 0;
            //找到第一个可用的

            System.out.println("当前服务器的时间"+map+"--当前time="+time+"当前i=="+i);
            while ( index<servers.length && map.get(index)>time){
                index++;
                //如果没有服务器,则将我的任务放到下一个任务
            }
            if (index==servers.length){
                time++;
                i--;
                continue;
            }
            for (   int j = index+1; j < servers.length; j++) {
                if (servers[j]<servers[index] && map.get(j)<=time){
                    index = j;
                }
            }

            //将j的可用时间加长
            map.put(index,time+tasks[i]);
            ans[i] = index;
            time++;
        }
        return ans;
    }
}
