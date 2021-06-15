package ACM.tag刷题.算法.深度优先dfs;

import org.omg.CORBA.PERSIST_STORE;

import java.util.ArrayList;
import java.util.List;

public class dfs_207课程表 {
    /**
     广度优先:把所有入度为0 的节点入队  然后删除这几个,循环
     没有入度为0的节点,就是有环路

     若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。换个角度说，若课程安排图中存在环，一定有节点的入度始终不为 00。
     因此，拓扑排序出队次数等于课程个数，返回 numCourses == 0 判断课程是否可以成功安排。
     */

    /****
     看了半天评论的总结：

     统计每个课被指向次数，初始被指向次数为0的肯定是安全的（不在环上）。

     每被安全课程指向一次，被指次数减一，

     如果被指次数减到0，说明该课程全部指向都来自安全课程，则它也是安全的。

     依此进行队列循环。
     class Solution {
     // 判断图是否有环，利用图节点的出度来计算
     // 构造邻接表来存储图，List<Integer>[] graphic = new List[numCourses];
     // 利用入度矩阵存储每个节点的入度
     // 将入度为0的节点一次入队，然后遍历，减少其对应端点的入度
     // 最后判断是否全部入队
     public boolean canFinish(int numCourses, int[][] prerequisites) {
     // 1.根据边的关系来构造图
     List<Integer>[] graphic = new List[numCourses];
     for(int i = 0; i < numCourses; i++){
     graphic[i] = new ArrayList<>();
     }
     for(int[] pre : prerequisites){
     graphic[pre[0]].add(pre[1]);
     }
     // 2.创建入度表
     int[] inDegree = new int[numCourses];
     for(int i = 0; i < numCourses; i++){
     List<Integer> pre = graphic[i];
     for(int num : pre)
     inDegree[num] += 1;
     }
     // 3.入度为0的节点入队，然后bfs求解
     Queue<Integer> queue = new LinkedList<>();
     for(int i = 0; i < numCourses; i++){
     if(inDegree[i] == 0)
     queue.offer(i);
     }
     while(!queue.isEmpty()){
     int temp = queue.poll();
     numCourses --;
     for(int num : graphic[temp]){
     inDegree[num] -= 1;
     if(inDegree[num] == 0)
     queue.offer(num);
     }
     }
     return numCourses == 0;
     }
     }
     */
    /****
     你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     输入：numCourses = 2, prerequisites = [[1,0]]
     输出：true
     解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     */
    //超时: 2000数据量的时候
        //int visited[] = new int[];
        static class PerClass0{
            int id;
            List<PerClass> PerClassList;
            PerClass0(){
                //PerClassList = new ArrayList<>();
            }
            PerClass0(int id){

                this.id=id;
                PerClassList = new ArrayList<>();
            }

            @Override
            public String toString() {
                return "PerClass{" +
                        "id=" + id;
            }
        }
        static class PerClass{
            int id;
            List<Integer> idList;
            PerClass(){
                //PerClassList = new ArrayList<>();
            }
            PerClass(int id){

                this.id=id;
                idList = new ArrayList<>();
            }

            @Override
            public String toString() {
                return "PerClass{" +
                        "id=" + id;
            }
        }

   /* public static boolean dfs(PerClass perClass,int match){
        if (perClass.id ==match){
            return false;
        }
        List<PerClass> perClassList = perClass.PerClassList;
        for (PerClass aClass : perClassList) {
            boolean flag = dfs(aClass,match);
            if (flag==false)return false;
        }
        return true;
    }*/
    public static boolean findCircleByDfs(PerClass[] perClasses,int perClass,List<Integer> match,int[] visited){
        if (match.contains(perClasses[perClass].id)){
            return false;
        }
        if (visited[perClass]==1)return true;//加一个记忆化数组,勉强过了 7 5
        visited[perClass]=1;

        ArrayList<Integer> list = new ArrayList();
        list.addAll(match);
        list.add(perClass);//可以一起做掉
        //match.add(perClass);
        List<Integer> perClassList = perClasses[perClass].idList;
        //System.out.println(perClassList+"--"+list);
        for (Integer aClass : perClassList) {
            //System.out.println(list+"---"+aClass);
            //if (aClass <perClass)continue;
            boolean flag = findCircleByDfs(perClasses,aClass,list,visited);
            if (flag==false)return false;
        }
        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int visited[] = new int[numCourses];
        PerClass[] perClasses = new PerClass[numCourses];
        //构造class
        for (int i = 0; i < numCourses; i++) {
            perClasses[i] = new PerClass(i);
        }
        //构造前驱节点
        for (int i = 0; i < prerequisites.length; i++) {
            perClasses[prerequisites[i][0]].idList.add(prerequisites[i][1]);
        }
        //System.out.println(perClasses[0].PerClassList+"---"+perClasses[1].PerClassList);

        //开始递归dfs找环
        for (int i = 0; i < numCourses; i++) {
            visited[i] = 1;
            //boolean flag = findCircleByDfs(perClasses[i],i);
            //if (flag==false)return false;
            List<Integer> perClassList = perClasses[i].idList;
            for (Integer aClass : perClassList) {
                //if (aClass <i)continue;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                boolean flag = findCircleByDfs(perClasses,aClass,list,visited);
                if (flag==false)return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(4, new int[][]{{0, 1}, {3, 1},{1,3},{3,2}}));
        System.out.println(canFinish(5, new int[][]{{1,4}, {2,4},{3,1},{3,2}}));
        System.out.println(canFinish(3, new int[][]{{0,2},{1,0},{2,1}}));
    }
}
