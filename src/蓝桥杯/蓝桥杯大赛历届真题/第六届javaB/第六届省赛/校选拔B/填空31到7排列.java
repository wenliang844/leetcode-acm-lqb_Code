package 蓝桥杯.蓝桥杯大赛历届真题.第六届javaB.第六届省赛.校选拔B;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 填空31到7排列 {
    /***
     1到7的排列:要求1和1之间1个数字,...
     74000040700000
     74151643752362
     */
    public static void dfs(int arrange[],boolean visited[],int index){
        System.out.println(Arrays.toString(arrange));
        if (index==14){
            System.out.println("正在判断手符合条件------start...---");
            System.out.println(Arrays.toString(arrange));
            if (judgement(arrange)){
                System.out.println(Arrays.toString(arrange));
            }
            return;
        }

        //剪枝:当index这里有值的时候,不进行,直接去上一个状态继续遍历
        if (arrange[index]!=0){
            index++;
        }

        //没有到终点
        //遍历visited 挑选没有访问的i进行访问,并设置为i+1; 新定义两个新的arrange visited到下一个状态
        for (int i = 0; i < 7; i++) {
            if (!visited[i] && arrange[index]==0 && index+i+1+1<14 && arrange[index+i+1+1]==0){//这个节点没有被访问,那就访问这个节点  还有这个节点要没有值 要==0
                int[] temparrange = new int[14];
                boolean[] tempvisited = new boolean[7];
                System.arraycopy(arrange,0,temparrange,0,14);
                System.arraycopy(visited,0,tempvisited,0,7);
                temparrange[index]=i+1;
                temparrange[index+i+1+1]=i+1;
                tempvisited[i]=true;
                dfs(temparrange,tempvisited,index+1);
            }
        }
    }
    public static boolean judgement(int arrange[]){
        for (int i = 0; i < arrange.length; i++) {
            //需要满足两个条件return false
            boolean flag = false;
            if ((i-arrange[i]-1>=0 && arrange[i-arrange[i]-1]==arrange[i]) ||
                    (i+arrange[i]+1<arrange.length && arrange[i+arrange[i]+1]==arrange[i])){
               flag = true;
            }
            if (!flag)return flag;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arrange = new int[14];
        boolean[] visited = new boolean[7];//布局的时候等于i+1 下标0->对应1
        arrange[0]=7;
        arrange[8]=7;
        arrange[1]=4;
        arrange[6]=4;//从2开始布局
        visited[3]=true;
        visited[6]=true;
        dfs(arrange,visited,2);
        System.out.println(judgement(new int[]{1, 7, 1, 2, 6, 4, 2, 5, 3, 7, 4, 6, 3, 5}));
    }
}
