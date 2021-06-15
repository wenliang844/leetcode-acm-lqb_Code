package 蓝桥杯.lan真题训练.第十届2020决赛;

import java.util.Map;

public class B平均拆分 {//26287

    static int count=0;
    public static void dfs(int currentnum,int currentSum,int sum){
        if (currentSum>=sum){
            if (currentSum==sum){
                count++;
            }
            return;
        }

        for (int i = currentnum+1; i <= 45; i++) {
            dfs(i,currentSum+i*i,sum);
        }
    }
    public static void main(String[] args) {
        System.out.println(Math.sqrt(2019));//44.9   45
        for (int i = 1; i <= 45; i++) {
            dfs(i,i*i,2019);
        }

        System.out.println(count);
    }
}
