package ACM.每日一题leecode.day32;

import java.util.ArrayList;
import java.util.List;

/******
 公司共有 n 个项目和  m 个小组，每个项目要不无人接手，要不就由 m 个小组之一负责。

 group[i] 表示第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。（项目和小组都是从零开始编号的）小组可能存在没有接手任何项目的情况。

 请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表：

 同一小组的项目，排序后在列表中彼此相邻。
 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个项目左侧）应该完成的所有项目。
 如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 空列表 。

  

 示例 1：



 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
 输出：[6,3,4,1,5,2,0,7]
 示例 2：

 输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
 输出：[]
 解释：与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
 */
public class day42_1203项目管理 {
    public static void test1(){
        int[] group = {-1,-1,1,0,0,1,0,-1};
                  int[][] beforeitems = new int[group.length][2];//{{},{6},{5},{6},{3,6},{},{},{}}
                  beforeitems[1][0]=6;
                  beforeitems[2][0]=5;
                  beforeitems[3][0]=6;
                  beforeitems[4][0]=3;
                  beforeitems[4][1]=6;
                  List<List<Integer>> beforeItems = new ArrayList<>(group.length);
                  for (int i = 0; i < beforeitems.length; i++) {
                      List<Integer> list = new ArrayList<>();
                      if (beforeitems[i][0]!=0){
                          list.add(beforeitems[i][0]);
                          if (beforeitems[i][1]!=0){
                              list.add(beforeitems[i][1]);
              }
          }

            beforeItems.add(list);
        }
        System.out.println("这是初始化的beforelist="+beforeItems);
        System.out.println("这是结果="+sortItems(8, 2, group, beforeItems));

    }
    public static void main(String[] args) {
        test1();
    }

    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        /****
         思路:将项目的相同组放一起,依据前序条件排序
         再将项目组间进行排序

         再把-1的项目进行插入
         */
        List<List<Integer>> beforeList = new ArrayList<>();
        int len = group.length;
        int viseted[] = new int[len];//访问标记
        for (int i = 0; i < len; i++) {
            if (!beforeItems.isEmpty()){

                int i1 = 0;
                for (Integer integer: beforeItems.get(i)) {

                    //前后顺序调整
                    if (viseted[integer]==1){//已经有了
                        for (; i1 < beforeList.size(); i1++) {
                            if (beforeItems.get(i1).contains(integer)){
                                break;
                            }
                        }
                    }else {
                        if (beforeList.size()<1){
                            List<Integer> list1 = new ArrayList<>();
                            //List<Integer> list2 = new ArrayList<>();
                            list1.add(integer);
                            beforeList.add(list1);
                        }else {
                            beforeList.get(0).add(integer);
                        }
                        viseted[integer]=1;
                    }
                    if (group[i]!=group[integer]){
                        for (Integer bInteger: beforeItems.get(integer)) {
                            if (group[i]==group[integer]){
                                return null;
                            }
                        }
                    }
                }
                beforeList.get(i+1).add(i);
                viseted[i]=1;
            }
        }

        System.out.println("这是具有先后次序的list="+beforeList);

        return null;
    }
}
