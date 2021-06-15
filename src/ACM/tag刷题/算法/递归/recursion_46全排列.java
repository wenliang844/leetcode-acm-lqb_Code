package ACM.tag刷题.算法.递归;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recursion_46全排列 {
    /***
     给定一个 没有重复 数字的序列，返回其所有可能的全排列。

     示例:

     输入: [1,2,3]
     输出:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]

     1 2 3
     1 2 3
     1 2 3
     有几个就有多少层,对每层进行list.add 当list.size=len停止,加入resLists

     */
    //方法一:暴力递归,跟随一个visited数组,递归有lens层 96 67
    //官方:定义一个path,回溯过程中,将当前值从path中删除,再剪枝去重
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resLists = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,new ArrayList<>(),resLists);
        return resLists;
    }
    public static void dfs(int[] nums,boolean[] visited,List<Integer> currentList,List<List<Integer>> resLists){
        //当currentList=resList的时候,加入并return
        if (currentList.size()==nums.length){
            resLists.add(currentList);
            return;
        }
        //每次遍历,创建一个新的tempList,和一个新的visited数组,因为这些不能公用
        for (int i = 0; i < nums.length; i++) {
            //每次有4中选择,从上到下没访问过的都可以选择
            if (!visited[i]){
                List<Integer> tempList = new ArrayList<>();
                boolean[] tempVisited = new boolean[nums.length];
                System.arraycopy(visited,0,tempVisited,0,nums.length);//from->to
                tempList.addAll(currentList);
                tempList.add(nums[i]);
                tempVisited[i]=true;
                dfs(nums,tempVisited,tempList,resLists);
            }

        }
    }

    public static void main(String[] args) {
        /*//测试一下system.copyaray
        boolean[] a = new boolean[3];
        a[0] = true;
        boolean[] b = new boolean[3];
        System.arraycopy(a,0,b,0,3);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));*/
        System.out.println(permute(new int[]{1,2,3}));
    }
}
