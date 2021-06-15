package ACM.leecode周赛.第240场周赛;

import java.util.Arrays;

public class lee1_5750人口最多的年份 {
    /***
     给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
     年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
     返回 人口最多 且 最早 的年份。
     示例 1：
     输入：logs = [[1993,1999],[2000,2010]]
     输出：1993
     解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
     */
    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
        System.out.println(maximumPopulation(new int[][]{{1950,1961},{1960,1971},{1970,1981}}));
    }

    //方法一,做一个时间线,0表示+ -1表示-, 排序,加的年份max保存
    public static int maximumPopulation(int[][] logs) {
        int maxYaer = 0;
        int maxCount = 0;
        int len = logs.length;
        //生死两条线
        int sheng[] = new int[len];
        int shi[] = new int[len];
        //int timeLine[] = new int[len*2];
        for (int i = 0; i < len; i++) {
            sheng[i] = logs[i][0];
            shi[i] = logs[i][1];
        }
        //System.out.println(Arrays.toString(sheng));
        //System.out.println(Arrays.toString(shi));
        Arrays.sort(sheng);
        Arrays.sort(shi);
        int life = 0;
        int die = 0;
        int count  = 0;//人数量
        while (life<len && die<len){
            if (sheng[life]<shi[die]){
                count++;

                if (count>maxCount){
                    maxCount=count;
                    maxYaer=sheng[life];
                }
                life++;
            }else if (sheng[life]>shi[die]){
                count--;
                die++;
            }else {
                //相等
                life++;
                die++;
            }
        }
       // System.out.println(maxCount+"--"+maxYaer);
        //如果最后list还有的话,直接加上到最后一个
        if (life<len){
            return sheng[len-1];
        }

        return maxYaer;
    }
}
